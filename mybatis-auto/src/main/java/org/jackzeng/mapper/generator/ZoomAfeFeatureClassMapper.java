package org.jackzeng.mapper.generator;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jackzeng.pojo.ZoomAfeFeatureClass;
import org.jackzeng.pojo.ZoomAfeFeatureClassExample;

public interface ZoomAfeFeatureClassMapper {
    int countByExample(ZoomAfeFeatureClassExample example);

    int deleteByExample(ZoomAfeFeatureClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZoomAfeFeatureClass record);

    int insertSelective(ZoomAfeFeatureClass record);

    List<ZoomAfeFeatureClass> selectByExample(ZoomAfeFeatureClassExample example);

    ZoomAfeFeatureClass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZoomAfeFeatureClass record, @Param("example") ZoomAfeFeatureClassExample example);

    int updateByExample(@Param("record") ZoomAfeFeatureClass record, @Param("example") ZoomAfeFeatureClassExample example);

    int updateByPrimaryKeySelective(ZoomAfeFeatureClass record);

    int updateByPrimaryKey(ZoomAfeFeatureClass record);
}