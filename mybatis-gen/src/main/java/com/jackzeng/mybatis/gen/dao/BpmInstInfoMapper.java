package com.jackzeng.mybatis.gen.dao;

import com.jackzeng.mybatis.gen.entity.BpmInstInfo;

public interface BpmInstInfoMapper {
    int deleteByPrimaryKey(String transaction_no);

    int insert(BpmInstInfo record);

    int insertSelective(BpmInstInfo record);

    BpmInstInfo selectByPrimaryKey(String transaction_no);

    int updateByPrimaryKeySelective(BpmInstInfo record);

    int updateByPrimaryKey(BpmInstInfo record);
}