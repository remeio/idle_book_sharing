package com.xumengqi.reme.dao.mapper;

import com.xumengqi.reme.dao.entity.Bookcase;
import com.xumengqi.reme.dao.entity.BookcaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookcaseMapper {
    long countByExample(BookcaseExample example);

    int deleteByExample(BookcaseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Bookcase record);

    int insertSelective(Bookcase record);

    List<Bookcase> selectByExample(BookcaseExample example);

    Bookcase selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Bookcase record, @Param("example") BookcaseExample example);

    int updateByExample(@Param("record") Bookcase record, @Param("example") BookcaseExample example);

    int updateByPrimaryKeySelective(Bookcase record);

    int updateByPrimaryKey(Bookcase record);
}