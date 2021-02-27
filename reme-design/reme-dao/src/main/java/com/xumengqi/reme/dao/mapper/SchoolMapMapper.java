package com.xumengqi.reme.dao.mapper;

import com.xumengqi.reme.dao.entity.SchoolMap;
import com.xumengqi.reme.dao.entity.SchoolMapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchoolMapMapper {
    long countByExample(SchoolMapExample example);

    int deleteByExample(SchoolMapExample example);

    int deleteByPrimaryKey(Long schoolMapId);

    int insert(SchoolMap record);

    int insertSelective(SchoolMap record);

    List<SchoolMap> selectByExample(SchoolMapExample example);

    SchoolMap selectByPrimaryKey(Long schoolMapId);

    int updateByExampleSelective(@Param("record") SchoolMap record, @Param("example") SchoolMapExample example);

    int updateByExample(@Param("record") SchoolMap record, @Param("example") SchoolMapExample example);

    int updateByPrimaryKeySelective(SchoolMap record);

    int updateByPrimaryKey(SchoolMap record);
}