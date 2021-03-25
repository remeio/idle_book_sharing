package com.xumengqi.reme.as.logic.book.impl;

import com.xumengqi.reme.as.logic.book.BookCatalogLogic;
import com.xumengqi.reme.dao.entity.BookCatalog;
import com.xumengqi.reme.dao.entity.BookCatalogExample;
import com.xumengqi.reme.dao.mapper.BookCatalogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/25 14:30
 */
@Component
public class BookCatalogLogicImpl implements BookCatalogLogic {
    @Autowired
    private BookCatalogMapper bookCatalogMapper;

    @Override
    public List<BookCatalog> getBookCatalogList() {
        return bookCatalogMapper.selectByExample(new BookCatalogExample());
    }

    @Override
    public Boolean isExistBookCatalog(Long bookCatalogId) {
        return bookCatalogMapper.selectByPrimaryKey(bookCatalogId) != null;
    }
}
