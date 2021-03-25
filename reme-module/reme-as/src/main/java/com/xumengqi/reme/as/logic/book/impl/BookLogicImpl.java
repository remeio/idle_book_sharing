package com.xumengqi.reme.as.logic.book.impl;

import com.xumengqi.reme.as.logic.book.BookLogic;
import com.xumengqi.reme.dao.entity.Book;
import com.xumengqi.reme.dao.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xumengqi
 * @date 2021/3/25 14:37
 */
@Component
public class BookLogicImpl implements BookLogic {
    @Autowired
    private BookMapper bookMapper;
    
    @Override
    public void addBook(Book book) {
        bookMapper.insertSelective(book);
    }
}
