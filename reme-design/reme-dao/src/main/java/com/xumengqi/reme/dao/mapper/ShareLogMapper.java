package com.xumengqi.reme.dao.mapper;

import com.xumengqi.reme.dao.entity.ShareLog;
import com.xumengqi.reme.dao.entity.ShareLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShareLogMapper {
    long countByExample(ShareLogExample example);

    int deleteByExample(ShareLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShareLog record);

    int insertSelective(ShareLog record);

    List<ShareLog> selectByExample(ShareLogExample example);

    ShareLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShareLog record, @Param("example") ShareLogExample example);

    int updateByExample(@Param("record") ShareLog record, @Param("example") ShareLogExample example);

    int updateByPrimaryKeySelective(ShareLog record);

    int updateByPrimaryKey(ShareLog record);
}