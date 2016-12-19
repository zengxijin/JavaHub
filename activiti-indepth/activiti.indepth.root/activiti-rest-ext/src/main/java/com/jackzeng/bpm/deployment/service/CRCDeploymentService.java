package com.jackzeng.bpm.deployment.service;

import javax.sql.DataSource;

/**
 * @author XijinZeng
 * 扩展activiti一些没有的部署服务接口
 */
public interface CRCDeploymentService {
	boolean createSchema();
	boolean dropSchema();
	CRCDeploymentService createDataSource(DataSource dataSource, String schema, String jdbcType);
}