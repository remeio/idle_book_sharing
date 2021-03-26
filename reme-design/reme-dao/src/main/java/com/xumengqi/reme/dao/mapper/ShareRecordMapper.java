package com.xumengqi.reme.dao.mapper;

import com.xumengqi.reme.dao.entity.ShareRecord;
import com.xumengqi.reme.dao.entity.ShareRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShareRecordMapper {
    long countByExample(ShareRecordExample example);

    int deleteByExample(ShareRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShareRecord record);

    int insertSelective(ShareRecord record);

    List<ShareRecord> selectByExample(ShareRecordExample example);

    ShareRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShareRecord record, @Param("example") ShareRecordExample example);

    int updateByExample(@Param("record") ShareRecord record, @Param("example") ShareRecordExample example);

    int updateByPrimaryKeySelective(ShareRecord record);

    int updateByPrimaryKey(ShareRecord record);
}