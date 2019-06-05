package org.jackzeng.mapper.generator;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jackzeng.pojo.ZoomAfeFeatureExecutor;
import org.jackzeng.pojo.ZoomAfeFeatureExecutorExample;

public interface ZoomAfeFeatureExecutorMapper {
    int countByExample(ZoomAfeFeatureExecutorExample example);

    int deleteByExample(ZoomAfeFeatureExecutorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ZoomAfeFeatureExecutor record);

    int insertSelective(ZoomAfeFeatureExecutor record);

    List<ZoomAfeFeatureExecutor> selectByExample(ZoomAfeFeatureExecutorExample example);

    ZoomAfeFeatureExecutor selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ZoomAfeFeatureExecutor record, @Param("example") ZoomAfeFeatureExecutorExample example);

    int updateByExample(@Param("record") ZoomAfeFeatureExecutor record, @Param("example") ZoomAfeFeatureExecutorExample example);

    int updateByPrimaryKeySelective(ZoomAfeFeatureExecutor record);

    int updateByPrimaryKey(ZoomAfeFeatureExecutor record);
}