package com.jackzeng.mybatis.gen.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSqlSession {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	private MyBatisSqlSession(){
	}
	
	static{
		Reader reader = null;
		try{
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}catch(IOException e){
			throw new RuntimeException(e.getMessage()); 
		}finally{
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static SqlSession getSqlSession(){
		return sqlSessionFactory.openSession();
	}
}
