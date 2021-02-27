package com.xumengqi.reme.dao.mapper;

import com.xumengqi.reme.dao.entity.Favor;
import com.xumengqi.reme.dao.entity.FavorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FavorMapper {
    long countByExample(FavorExample example);

    int deleteByExample(FavorExample example);

    int deleteByPrimaryKey(Long favorId);

    int insert(Favor record);

    int insertSelective(Favor record);

    List<Favor> selectByExample(FavorExample example);

    Favor selectByPrimaryKey(Long favorId);

    int updateByExampleSelective(@Param("record") Favor record, @Param("example") FavorExample example);

    int updateByExample(@Param("record") Favor record, @Param("example") FavorExample example);

    int updateByPrimaryKeySelective(Favor record);

    int updateByPrimaryKey(Favor record);
}