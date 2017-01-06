package com.jackzeng.mybatis.gen.dao;

import com.jackzeng.mybatis.gen.entity.TenantSchemaCfg;
import com.jackzeng.mybatis.gen.entity.TenantSchemaCfgExample;
import org.apache.ibatis.annotations.Param;

public interface TenantSchemaCfgMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TenantSchemaCfg record);

    int insertSelective(TenantSchemaCfg record);

    TenantSchemaCfg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TenantSchemaCfg record, @Param("example") TenantSchemaCfgExample example);

    int updateByExample(@Param("record") TenantSchemaCfg record, @Param("example") TenantSchemaCfgExample example);

    int updateByPrimaryKeySelective(TenantSchemaCfg record);

    int updateByPrimaryKey(TenantSchemaCfg record);
}