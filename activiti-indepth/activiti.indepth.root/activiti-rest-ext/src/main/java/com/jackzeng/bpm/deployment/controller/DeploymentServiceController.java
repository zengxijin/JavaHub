package com.jackzeng.bpm.deployment.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.activiti.engine.ActivitiObjectNotFoundException;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.cfg.multitenant.MultiSchemaMultiTenantProcessEngineConfiguration;
import org.activiti.engine.impl.cfg.multitenant.TenantAwareDataSource;
import org.activiti.engine.repository.Deployment;
import org.activiti.rest.service.api.RestResponseFactory;
import org.activiti.rest.service.api.repository.DeploymentResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.jackzeng.bpm.deployment.request.DeployRequest;
import com.jackzeng.bpm.deployment.request.SchemaRequest;
import com.jackzeng.bpm.deployment.response.SchemaResponse;
import com.jackzeng.bpm.deployment.service.CRCDeploymentService;
import com.jackzeng.bpm.deployment.service.CRCResourceManager;
import com.jackzeng.entity.CRCResponse;
import com.jackzeng.mutiltenant.DummyTenantInfoHolder;
import com.jackzeng.mutiltenant.cfg.MultiTenantDBCfg;
import com.jackzeng.mutiltenant.cfg.ProcessEngineCfg;
import com.jackzeng.util.CRCDataSourceFactory;
import com.jackzeng.util.SpringContextHolder;

/**
 * @author XijinZeng 扩展的CRC的Rest服务
 */
@RestController
public class DeploymentServiceController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DeploymentServiceController.class);

	@Autowired
	protected RestResponseFactory restResponseFactory;

	@Autowired
	protected CRCResourceManager crcResourceManager;

	@Autowired
	protected CRCDeploymentService crcDeploymentService;

	/**
	 * 	多租户信息存储和管理，具有简单的路由功能
	 */
	@Autowired
	protected DummyTenantInfoHolder tenantInfoHolder; 

	@Autowired
	protected MultiTenantDBCfg multiTenantDBCfg;
	
	/**
	 * 多租户流程引擎ProcessEngine
	 */
	@Autowired
	@Qualifier("multiTenantEngine")
	protected ProcessEngine multiTenantEngine;
	
	@Value("${bpm.resource.path}")
	protected String resourcePath;
	
	/**
	 * 多租户流程引擎配置信息
	 */
	@Autowired
	@Qualifier("processEngineConfigurationTenant")
	protected MultiSchemaMultiTenantProcessEngineConfiguration engineCfg;

	@RequestMapping(value = "/crc/deployment/deploy", method = RequestMethod.POST, produces = "application/json")
	public DeploymentResponse deploy(HttpServletRequest request, @RequestBody String message) {
		try {
			DeployRequest deployRequest = JSONObject.parseObject(message, DeployRequest.class);
			String tenantId = deployRequest.getTenantId();
			
			//向引擎注册租户信息
			tenantInfoHolder.setCurrentTenantId(tenantId);
			engineCfg.registerTenant(tenantId, ProcessEngineCfg.createDataSource(
					multiTenantDBCfg.getJdbcUrl() + deployRequest.getSchema(), multiTenantDBCfg.getJdbcUser(), multiTenantDBCfg.getJdbcPassword()));
			
			//获取资源信息
			String fileNameFull = resourcePath + crcResourceManager.getResource(deployRequest.getResourceId());
			FileInputStream fileInputStream = new FileInputStream(new File(fileNameFull));
			
			//部署资源
			tenantInfoHolder.setCurrentTenantId(tenantId);
			RepositoryService  repositoryService = multiTenantEngine.getRepositoryService();
			Deployment deployment = repositoryService.createDeployment()
					.tenantId(tenantId)
					.name(deployRequest.getName())
					.addInputStream(deployRequest.getResourceId(), fileInputStream)
					.deploy();
			
			LOGGER.info("resource deployed:resourceId=" + deployRequest.getResourceId() + " resourcePath=" + fileNameFull + " deploymentId=" + deployment.getId());

			//为了保持与activiti原生rest的一致性，部署成功返回结果报文使用activiti-rest部署资源接口一样的DeploymentResponse
			return restResponseFactory.createDeploymentResponse(deployment);
			
		} catch (Exception e) {
			LOGGER.error("deployment fail", e);
			throw new ActivitiObjectNotFoundException("deployment fail.",
					Deployment.class);
		}finally{
			tenantInfoHolder.clearCurrentUserId();
			tenantInfoHolder.clearCurrentTenantId();
		}
	}

	@RequestMapping(value = "/crc/schema/create", method = RequestMethod.POST, produces = "application/json")
	public SchemaResponse create(HttpServletRequest request, @RequestBody String message) {
		SchemaResponse schemaResponse = new SchemaResponse();
		try {
			SchemaRequest schemaRequest = JSONObject.parseObject(message, SchemaRequest.class);
			if (schemaRequest != null) {
				DataSource dataSource = null;
				if (!StringUtils.isBlank(schemaRequest.getJdbcType())
						&& CRCDataSourceFactory.DB_TYPE.MYSQL.equals(schemaRequest.getJdbcType().toLowerCase())) {
					dataSource = CRCDataSourceFactory.getMySQLDataSource(schemaRequest.getJdbcUrl(),
							schemaRequest.getJdbcUser(), schemaRequest.getJdbcPassword());
					boolean falg = crcDeploymentService
							.createDataSource(dataSource, schemaRequest.getSchema(), schemaRequest.getJdbcType())
							.createSchema();
					if (falg) {
						schemaResponse.setCode(CRCResponse.CODE.NORMAL);
						schemaResponse.setMsg("OK");
					} else {
						schemaResponse.setMsg("create schema fail");
						schemaResponse.setCode(CRCResponse.CODE.ERROR);
					}
				} else {
					schemaResponse.setCode(CRCResponse.CODE.ERROR);
					schemaResponse.setMsg(schemaRequest.getJdbcType() + " unsuported,create schema fail");
				}
			}
		} catch (Exception e) {
			schemaResponse.setCode(CRCResponse.CODE.ERROR);
			schemaResponse.setMsg("create schema internal error");
			LOGGER.error("create schema internal error",e);
		}
		return schemaResponse;
	}
}
