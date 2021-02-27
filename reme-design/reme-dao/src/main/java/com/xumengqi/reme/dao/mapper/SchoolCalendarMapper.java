package com.xumengqi.reme.dao.mapper;

import com.xumengqi.reme.dao.entity.SchoolCalendar;
import com.xumengqi.reme.dao.entity.SchoolCalendarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchoolCalendarMapper {
    long countByExample(SchoolCalendarExample example);

    int deleteByExample(SchoolCalendarExample example);

    int deleteByPrimaryKey(Long schoolCalendarId);

    int insert(SchoolCalendar record);

    int insertSelective(SchoolCalendar record);

    List<SchoolCalendar> selectByExample(SchoolCalendarExample example);

    SchoolCalendar selectByPrimaryKey(Long schoolCalendarId);

    int updateByExampleSelective(@Param("record") SchoolCalendar record, @Param("example") SchoolCalendarExample example);

    int updateByExample(@Param("record") SchoolCalendar record, @Param("example") SchoolCalendarExample example);

    int updateByPrimaryKeySelective(SchoolCalendar record);

    int updateByPrimaryKey(SchoolCalendar record);
}