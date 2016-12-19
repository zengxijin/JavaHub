package com.jackzeng.mutiltenant.cfg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;
/***
 * @ClassName: ProcessEngineCfg
 * @author:  Jack Zeng
 * @CreateDate: [2016年12月13日 下午3:23:41]   
 * @UpdateUser: Jack Zeng 
 * @UpdateDate: [2016年12月13日 下午3:23:41]   
 * @UpdateRemark: [TODO()]
 * @Description:  [TODO()]
 * @version: [V1.0]
 */
public class ProcessEngineCfg {
	/**
	 * @Title: createDataSource   
	 * @Description: 这是MySQL的DataSource获取例子，官方的例子是基于H2的，需要改写  
	 * @param @param jdbcUrl
	 * @param @param jdbcUsername
	 * @param @param jdbcPassword
	 * @param @return
	 * @param @throws Exception  
	 * @return DataSource  
	 * @throws
	 */
	public static DataSource createDataSource(String jdbcUrl, String jdbcUsername, String jdbcPassword) throws Exception {
		BitronixDataSourceFactoryBean bds = new BitronixDataSourceFactoryBean();
		bds.setClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
		bds.setUniqueName("actDS");
		bds.setMaxPoolSize(20);
		bds.setAllowLocalTransactions(true);
		
		Properties properties = new Properties();
		properties.setProperty("url", jdbcUrl);          //"jdbc:mysql://localhost:3306/act_multi_tenant");
		properties.setProperty("user", jdbcUsername);    //"root"
		properties.setProperty("password", jdbcPassword);//"admin"
		
		bds.setDriverProperties(properties);
		
		return bds.getObject();
	}
	
	/**
	 * @throws ClassNotFoundException 
	 * @Title: dropAndCreateDatabase   
	 * @Description: 纯粹测试使用，先删除数据库再创建数据库  
	 * @param @param jdbcUrl
	 * @param @param jdbcUsername
	 * @param @param jdbcPassword
	 * @param @param dataBase
	 * @param @throws SQLException  
	 * @return void  
	 * @throws
	 */
	public static void dropAndCreateDatabase(String jdbcUrl, String jdbcUsername, String jdbcPassword,String dataBase) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			final String dropSql = "DROP DATABASE IF EXISTS ";
			final String createSql = "CREATE DATABASE IF NOT EXISTS ";
			String connStr = jdbcUrl + "?user=" + jdbcUsername + "&password=" + jdbcPassword;
			// DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=rootpassword");
			conn = DriverManager.getConnection(connStr);
			statement = conn.createStatement();
			statement.executeUpdate(dropSql + dataBase);
			statement.executeUpdate(createSql + dataBase);
			System.out.println(dataBase + "创建成功");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(statement!=null){
				statement.close();
				statement = null;
			}
			if(conn!=null){
				conn.close();
				conn = null;
			}
		}
	}
}
