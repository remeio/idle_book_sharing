package com.xumengqi.reme.dao.mapper;

import com.xumengqi.reme.dao.entity.ConfessionAttach;
import com.xumengqi.reme.dao.entity.ConfessionAttachExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConfessionAttachMapper {
    long countByExample(ConfessionAttachExample example);

    int deleteByExample(ConfessionAttachExample example);

    int deleteByPrimaryKey(Long confessionId);

    int insert(ConfessionAttach record);

    int insertSelective(ConfessionAttach record);

    List<ConfessionAttach> selectByExample(ConfessionAttachExample example);

    ConfessionAttach selectByPrimaryKey(Long confessionId);

    int updateByExampleSelective(@Param("record") ConfessionAttach record, @Param("example") ConfessionAttachExample example);

    int updateByExample(@Param("record") ConfessionAttach record, @Param("example") ConfessionAttachExample example);

    int updateByPrimaryKeySelective(ConfessionAttach record);

    int updateByPrimaryKey(ConfessionAttach record);
}