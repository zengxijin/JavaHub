package org.jackzeng.mapper.generator;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.jackzeng.pojo.ZoomAfeFeaturesMap;
import org.jackzeng.pojo.ZoomAfeFeaturesMapExample;

public interface ZoomAfeFeaturesMapMapper {
    int countByExample(ZoomAfeFeaturesMapExample example);

    int deleteByExample(ZoomAfeFeaturesMapExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ZoomAfeFeaturesMap record);

    int insertSelective(ZoomAfeFeaturesMap record);

    List<ZoomAfeFeaturesMap> selectByExample(ZoomAfeFeaturesMapExample example);

    ZoomAfeFeaturesMap selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ZoomAfeFeaturesMap record, @Param("example") ZoomAfeFeaturesMapExample example);

    int updateByExample(@Param("record") ZoomAfeFeaturesMap record, @Param("example") ZoomAfeFeaturesMapExample example);

    int updateByPrimaryKeySelective(ZoomAfeFeaturesMap record);

    int updateByPrimaryKey(ZoomAfeFeaturesMap record);
}