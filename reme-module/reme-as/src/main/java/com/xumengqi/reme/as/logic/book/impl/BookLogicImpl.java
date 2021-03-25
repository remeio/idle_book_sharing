package com.xumengqi.reme.as.logic.book.impl;

import com.xumengqi.reme.as.logic.book.BookLogic;
import com.xumengqi.reme.common.enums.biz.BookStatusEnum;
import com.xumengqi.reme.dao.entity.Book;
import com.xumengqi.reme.dao.entity.BookExample;
import com.xumengqi.reme.dao.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public List<Book> getBookList(Long schoolId, Long bookCatalogId, BookStatusEnum bookStatusEnum) {
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        if (schoolId != null) {
            criteria.andSchoolIdEqualTo(schoolId);
        }
        if (bookCatalogId != null) {
            criteria.andBookCatalogIdEqualTo(bookCatalogId);
        }
        if (bookStatusEnum != null) {
            criteria.andBookStatusEqualTo(bookStatusEnum.getCode());
        }
        return bookMapper.selectByExample(bookExample);
    }
}
