package com.jackzeng.mybatis.gen.service;

import org.apache.ibatis.session.SqlSession;

import com.jackzeng.mybatis.gen.dao.BpmInstInfoMapper;
import com.jackzeng.mybatis.gen.entity.BpmInstInfo;
import com.jackzeng.mybatis.gen.util.MyBatisSqlSession;

public class BpmInstInfoService {
	public int insert(BpmInstInfo bpmInstInfo){
		SqlSession session = MyBatisSqlSession.getSqlSession();
		try{
			BpmInstInfoMapper mapper = session.getMapper(BpmInstInfoMapper.class);
			int effedRow = mapper.insert(bpmInstInfo);
			session.commit();
			return effedRow;
		}finally{
			session.close();
		}
	}
}
