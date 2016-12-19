package com.jackzeng.util;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class CRCDataSourceFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(CRCDataSourceFactory.class);
	public static DataSource getMySQLDataSource(String jdbcUrl,String jdbcUser,String jdbcPassword) {
		MysqlDataSource ds = null;
		try {
			ds = new MysqlDataSource();
			ds.setURL(jdbcUrl);
			ds.setUser(jdbcUser);
			ds.setPassword(jdbcPassword);
		} catch (Exception e) {
			LOGGER.error("get mysql datasource error");
		}
		return ds;
	}
	
	public static DataSource getOracleDataSource() throws Exception{
		throw new Exception("oracle datasource unsopported now!");
//		OracleDataSource oracleDS = null;
//		try {
//			oracleDS = new OracleDataSource();
//			oracleDS.setURL(props.getProperty("ORACLE_DB_URL"));
//			oracleDS.setUser(props.getProperty("ORACLE_DB_USERNAME"));
//			oracleDS.setPassword(props.getProperty("ORACLE_DB_PASSWORD"));
//		} catch (Exception e) {
//			
//		}
//		return oracleDS;
	}
	
	public static class DB_TYPE{
		public static final String MYSQL = "mysql";
		public static final String ORACLE = "oracle";
		public static final String MSSQL = "mssql";
	}
}
