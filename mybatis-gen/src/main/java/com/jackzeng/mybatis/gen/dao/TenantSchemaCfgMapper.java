package com.jackzeng.mybatis.gen.dao;

import com.jackzeng.mybatis.gen.entity.TenantSchemaCfg;

public interface TenantSchemaCfgMapper {
    int deleteByPrimaryKey(String tenant_id);

    int insert(TenantSchemaCfg record);

    int insertSelective(TenantSchemaCfg record);

    TenantSchemaCfg selectByPrimaryKey(String tenant_id);

    int updateByPrimaryKeySelective(TenantSchemaCfg record);

    int updateByPrimaryKey(TenantSchemaCfg record);
}