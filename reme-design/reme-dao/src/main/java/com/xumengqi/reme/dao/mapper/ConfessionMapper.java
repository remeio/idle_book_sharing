package com.xumengqi.reme.dao.mapper;

import com.xumengqi.reme.dao.entity.Confession;
import com.xumengqi.reme.dao.entity.ConfessionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConfessionMapper {
    long countByExample(ConfessionExample example);

    int deleteByExample(ConfessionExample example);

    int deleteByPrimaryKey(Long confessionId);

    int insert(Confession record);

    int insertSelective(Confession record);

    List<Confession> selectByExample(ConfessionExample example);

    Confession selectByPrimaryKey(Long confessionId);

    int updateByExampleSelective(@Param("record") Confession record, @Param("example") ConfessionExample example);

    int updateByExample(@Param("record") Confession record, @Param("example") ConfessionExample example);

    int updateByPrimaryKeySelective(Confession record);

    int updateByPrimaryKey(Confession record);
}