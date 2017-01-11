package com.jackzeng.mybatis.gen.service;

import org.apache.ibatis.session.SqlSession;

import com.jackzeng.mybatis.gen.dao.TenantSchemaCfgMapper;
import com.jackzeng.mybatis.gen.entity.TenantSchemaCfg;
import com.jackzeng.mybatis.gen.util.MyBatisSqlSession;

public class TenantSchemaCfgService {

	public int insert(TenantSchemaCfg cfg) {
		SqlSession session = MyBatisSqlSession.getSqlSession();
		try{
			TenantSchemaCfgMapper mapper = session.getMapper(TenantSchemaCfgMapper.class);
			int effedRow = mapper.insert(cfg);
			session.commit();
			return effedRow;
		}finally{
			session.close();
		}
	}

}
