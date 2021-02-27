package com.xumengqi.reme.dao.mapper;

import com.xumengqi.reme.dao.entity.ConfessionTag;
import com.xumengqi.reme.dao.entity.ConfessionTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConfessionTagMapper {
    long countByExample(ConfessionTagExample example);

    int deleteByExample(ConfessionTagExample example);

    int deleteByPrimaryKey(Long confessionTagId);

    int insert(ConfessionTag record);

    int insertSelective(ConfessionTag record);

    List<ConfessionTag> selectByExample(ConfessionTagExample example);

    ConfessionTag selectByPrimaryKey(Long confessionTagId);

    int updateByExampleSelective(@Param("record") ConfessionTag record, @Param("example") ConfessionTagExample example);

    int updateByExample(@Param("record") ConfessionTag record, @Param("example") ConfessionTagExample example);

    int updateByPrimaryKeySelective(ConfessionTag record);

    int updateByPrimaryKey(ConfessionTag record);
}