package com.xumengqi.reme.dao.mapper;

import com.xumengqi.reme.dao.entity.Province;
import com.xumengqi.reme.dao.entity.ProvinceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProvinceMapper {
    long countByExample(ProvinceExample example);

    int deleteByExample(ProvinceExample example);

    int deleteByPrimaryKey(Long provinceId);

    int insert(Province record);

    int insertSelective(Province record);

    List<Province> selectByExample(ProvinceExample example);

    Province selectByPrimaryKey(Long provinceId);

    int updateByExampleSelective(@Param("record") Province record, @Param("example") ProvinceExample example);

    int updateByExample(@Param("record") Province record, @Param("example") ProvinceExample example);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);
}