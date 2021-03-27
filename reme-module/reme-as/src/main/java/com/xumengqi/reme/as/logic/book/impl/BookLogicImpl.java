package com.xumengqi.reme.as.logic.book.impl;

import com.xumengqi.reme.as.logic.book.BookLogic;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
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
        bookExample.setOrderByClause("gmt_create desc");
        return bookMapper.selectByExample(bookExample);
    }

    @Override
    public List<Book> getBookList(Long userId) {
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        bookExample.setOrderByClause("gmt_create desc");
        return bookMapper.selectByExample(bookExample);
    }

    @Override
    public Book getBook(Long bookId) {
        return bookMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public void offShelfBook(Long bookId, Long userId) {
        Book book = getBook(bookId);
        AssertUtils.asserter().assertNotNull(book).elseThrow(ErrorCodeEnum.BOOK_NOT_EXIST);
        // 判断用户是否正确
        AssertUtils.asserter().assertEqual(userId, book.getUserId()).elseThrow(ErrorCodeEnum.PERMISSION_DENIED);
        // 判断书籍状态，空闲和异常才能被下架
        BookStatusEnum bookStatusEnum = BookStatusEnum.getByCode(book.getBookStatus());
        AssertUtils.asserter().assertTrue(bookStatusEnum.equals(BookStatusEnum.IDLE) || bookStatusEnum.equals(BookStatusEnum.ABNORMAL))
                .elseThrow(ErrorCodeEnum.BOOK_CAN_NOT_OFF_SHELF);
        // 将书籍状态更新为已下架
        book.setBookStatus(BookStatusEnum.HAD_DELETED.getCode());
        bookMapper.updateByPrimaryKeySelective(book);
    }
}
