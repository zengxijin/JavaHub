package com.jackzeng.orm.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
/**
 * @ClassName: CustomSqlSessionFactory
 * @author:  Jack Zeng 
 * @CreateDate: [2016年12月29日 下午6:30:17]   
 * @UpdateUser: Jack Zeng 
 * @UpdateDate: [2016年12月29日 下午6:30:17]   
 * @UpdateRemark: [TODO()]
 * @Description:  [TODO()]
 * @version: [V1.0]
 */

public class CustomSqlSessionFactory {
	private static SqlSessionFactory sqlSessionFactory = null;

	/**可能会有并发的情况，需要考虑同步*/
	private synchronized static SqlSessionFactory buildSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream("resources/mybatis-config.xml");

			} catch (Exception e) {
				e.printStackTrace();
				try {
					throw e;
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} finally {
				try {
					if (inputStream != null) {
						inputStream.close();
					}
				} catch (Exception e) {
				}
			}
		}
		
		return sqlSessionFactory;
	}
	
	public static SqlSessionFactory getInstance(){
		return buildSqlSessionFactory();
	}
	
	public static SqlSession getSqlSession(){
		return buildSqlSessionFactory().openSession();
	}
}
