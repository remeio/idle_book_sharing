package com.xumengqi.reme.dao.mapper;

import com.xumengqi.reme.dao.entity.BookCatalog;
import com.xumengqi.reme.dao.entity.BookCatalogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookCatalogMapper {
    long countByExample(BookCatalogExample example);

    int deleteByExample(BookCatalogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BookCatalog record);

    int insertSelective(BookCatalog record);

    List<BookCatalog> selectByExample(BookCatalogExample example);

    BookCatalog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BookCatalog record, @Param("example") BookCatalogExample example);

    int updateByExample(@Param("record") BookCatalog record, @Param("example") BookCatalogExample example);

    int updateByPrimaryKeySelective(BookCatalog record);

    int updateByPrimaryKey(BookCatalog record);
}