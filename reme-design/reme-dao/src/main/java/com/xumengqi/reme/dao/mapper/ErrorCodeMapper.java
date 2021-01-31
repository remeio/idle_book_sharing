package com.xumengqi.reme.dao.mapper;

import com.xumengqi.reme.dao.entity.ErrorCode;
import com.xumengqi.reme.dao.entity.ErrorCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErrorCodeMapper {
    long countByExample(ErrorCodeExample example);

    int deleteByExample(ErrorCodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ErrorCode record);

    int insertSelective(ErrorCode record);

    List<ErrorCode> selectByExample(ErrorCodeExample example);

    ErrorCode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ErrorCode record, @Param("example") ErrorCodeExample example);

    int updateByExample(@Param("record") ErrorCode record, @Param("example") ErrorCodeExample example);

    int updateByPrimaryKeySelective(ErrorCode record);

    int updateByPrimaryKey(ErrorCode record);
}