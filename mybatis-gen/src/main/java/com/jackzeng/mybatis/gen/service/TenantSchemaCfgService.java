package com.jackzeng.mybatis.gen.service;

import org.apache.ibatis.session.SqlSession;

import com.jackzeng.mybatis.gen.dao.TenantSchemaCfgMapper;
import com.jackzeng.mybatis.gen.entity.TenantSchemaCfg;
import com.jackzeng.mybatis.gen.util.MyBatisSqlSession;

public class TenantSchemaCfgService {

	public int insert(TenantSchemaCfg tenantSchemaCfg) {
		SqlSession session = MyBatisSqlSession.getSqlSession();
		try{
			TenantSchemaCfgMapper mapper = session.getMapper(TenantSchemaCfgMapper.class);
			int efftRow = mapper.insert(tenantSchemaCfg);
			session.commit();
			return efftRow;
		}finally{
			session.close();
		}
	}
}
