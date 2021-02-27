package com.xumengqi.reme.dao.mapper;

import com.xumengqi.reme.dao.entity.Attach;
import com.xumengqi.reme.dao.entity.AttachExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttachMapper {
    long countByExample(AttachExample example);

    int deleteByExample(AttachExample example);

    int deleteByPrimaryKey(Long attachId);

    int insert(Attach record);

    int insertSelective(Attach record);

    List<Attach> selectByExample(AttachExample example);

    Attach selectByPrimaryKey(Long attachId);

    int updateByExampleSelective(@Param("record") Attach record, @Param("example") AttachExample example);

    int updateByExample(@Param("record") Attach record, @Param("example") AttachExample example);

    int updateByPrimaryKeySelective(Attach record);

    int updateByPrimaryKey(Attach record);
}