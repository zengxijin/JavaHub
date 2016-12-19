package com.jackzeng.bpm.deployment.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jackzeng.bpm.deployment.service.CRCResourceManager;
import com.jackzeng.util.SpringContextHolder;
/**
 * @author XijinZeng
 * CRC activiti流程资源管理接口实现
 * 注意：在资源管理方案不一样时，比如资源文件存ftp服务器或者存数据库，
 * 可以有不同的impl，通过Spring等方式注入对应的impl
 */

@Service
public class CRCResourceManagerImpl implements CRCResourceManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(CRCResourceManager.class);
	
	public String getResource(String resourceId) {
		//todo:纯测试使用，资源ID和资源文件的映射关系根据上游内容管理系统再实现此部分
		Map<String,String> simpleResourceMapper = new HashMap<String,String>();
		simpleResourceMapper.put(resourceId, "oneTaskProcess.bpmn20.xml");
		
		return simpleResourceMapper.get(resourceId);
	}

	public byte[] getResourceBinary(String resourceId) {
		String resourcePath = SpringContextHolder.getApplicationContext()
				.getEnvironment().getProperty("activiti.resource.path")
				+ this.getResource(resourceId);
		
		try {
			Path path = Paths.get(resourcePath);
			byte[] data = Files.readAllBytes(path);
			return data;
		} catch (IOException e) {
			LOGGER.error("get resource binary error", e);
		}
		
		return null;
	}

	public boolean deleteResource(String resourceId) {
		// TODO Auto-generated method stub
		return false;
	}

}
