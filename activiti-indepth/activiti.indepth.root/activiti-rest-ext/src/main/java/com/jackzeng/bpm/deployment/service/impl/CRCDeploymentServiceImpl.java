package com.jackzeng.bpm.deployment.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jackzeng.bpm.deployment.service.CRCDeploymentService;
/**
 * @author XijinZeng
 *
 */

@Service
public class CRCDeploymentServiceImpl implements CRCDeploymentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CRCDeploymentServiceImpl.class);
	
	private DataSource dataSource;
	private String schema;

	public boolean createSchema() {
		Connection conn = null;
		Statement st = null;
		try {
			conn = dataSource.getConnection();
			st = conn.createStatement();
			st.executeUpdate("CREATE DATABASE IF NOT EXISTS  " + schema);
			return true;
		} catch (Exception e) {
			LOGGER.error("create schema error", e);
		}finally{
			try {
				if(conn!=null){
					conn.close();
				}
				if(st!=null){
					st.close();
				}
			} catch (SQLException e) {
				LOGGER.error("close connection error", e);
			}
		}
		return false;
	}

	public boolean dropSchema() {
		Connection conn = null;
		Statement st = null;
		try {
			conn = dataSource.getConnection();
			st = conn.createStatement();
			st.executeUpdate("DROP DATABASE IF EXISTS  " + schema);
			return true;
		} catch (Exception e) {
			LOGGER.error("drop schema error", e);
		}finally{
			try {
				if(conn!=null){
					conn.close();
				}
				if(st!=null){
					st.close();
				}
			} catch (SQLException e) {
				LOGGER.error("close connection error", e);
			}
		}
		return false;
	}

	public CRCDeploymentService createDataSource(DataSource dataSource, String schema, String jdbcType) {
		this.dataSource = dataSource;
		this.schema = schema;
		return this;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}


}
