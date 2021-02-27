package com.xumengqi.reme.dao.mapper;

import com.xumengqi.reme.dao.entity.Browse;
import com.xumengqi.reme.dao.entity.BrowseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrowseMapper {
    long countByExample(BrowseExample example);

    int deleteByExample(BrowseExample example);

    int deleteByPrimaryKey(Long browseId);

    int insert(Browse record);

    int insertSelective(Browse record);

    List<Browse> selectByExample(BrowseExample example);

    Browse selectByPrimaryKey(Long browseId);

    int updateByExampleSelective(@Param("record") Browse record, @Param("example") BrowseExample example);

    int updateByExample(@Param("record") Browse record, @Param("example") BrowseExample example);

    int updateByPrimaryKeySelective(Browse record);

    int updateByPrimaryKey(Browse record);
}