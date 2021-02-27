package com.xumengqi.reme.dao.mapper;

import com.xumengqi.reme.dao.entity.City;
import com.xumengqi.reme.dao.entity.CityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityMapper {
    long countByExample(CityExample example);

    int deleteByExample(CityExample example);

    int deleteByPrimaryKey(Long cityId);

    int insert(City record);

    int insertSelective(City record);

    List<City> selectByExample(CityExample example);

    City selectByPrimaryKey(Long cityId);

    int updateByExampleSelective(@Param("record") City record, @Param("example") CityExample example);

    int updateByExample(@Param("record") City record, @Param("example") CityExample example);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}