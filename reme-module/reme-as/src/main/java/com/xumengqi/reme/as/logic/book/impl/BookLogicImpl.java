package com.xumengqi.reme.as.logic.book.impl;

import com.xumengqi.reme.as.logic.book.BookLogic;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.common.enums.biz.BookStatusEnum;
import com.xumengqi.reme.dao.entity.Book;
import com.xumengqi.reme.dao.entity.BookExample;
import com.xumengqi.reme.dao.entity.User;
import com.xumengqi.reme.dao.mapper.BookMapper;
import com.xumengqi.reme.dao.mapper.UserMapper;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xumengqi
 * @date 2021/3/25 14:37
 */
@Component
public class BookLogicImpl implements BookLogic {
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private UserMapper userMapper;

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
        // 已删除的书籍不能被查询到
        criteria.andBookStatusNotEqualTo(BookStatusEnum.HAD_DELETED.getCode());
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
        AssertUtils.asserter().assertTrue(bookStatusEnum.equals(BookStatusEnum.IDLE)
                || bookStatusEnum.equals(BookStatusEnum.ABNORMAL))
                .elseThrow(ErrorCodeEnum.BOOK_CAN_NOT_OFF_SHELF);
        // 将书籍状态更新为已下架
        book.setBookStatus(BookStatusEnum.HAD_OFF_SHELF.getCode());
        bookMapper.updateByPrimaryKeySelective(book);
    }

    @Override
    public void deleteBook(Long bookId, Long userId) {
        Book book = getBook(bookId);
        AssertUtils.asserter().assertNotNull(book).elseThrow(ErrorCodeEnum.BOOK_NOT_EXIST);
        // 判断用户是否正确
        AssertUtils.asserter().assertEqual(userId, book.getUserId()).elseThrow(ErrorCodeEnum.PERMISSION_DENIED);
        // 判断书籍状态，空闲或异常或已下架才能被删除
        BookStatusEnum bookStatusEnum = BookStatusEnum.getByCode(book.getBookStatus());
        AssertUtils.asserter().assertTrue(bookStatusEnum.equals(BookStatusEnum.IDLE)
                || bookStatusEnum.equals(BookStatusEnum.ABNORMAL)
                || bookStatusEnum.equals(BookStatusEnum.HAD_OFF_SHELF))
                .elseThrow(ErrorCodeEnum.BOOK_CAN_NOT_DELETED);
        // 将书籍状态更新为已删除
        book.setBookStatus(BookStatusEnum.HAD_DELETED.getCode());
        bookMapper.updateByPrimaryKeySelective(book);
    }

    @Override
    public void onShelfBook(Long bookId, Long userId) {
        Book book = getBook(bookId);
        AssertUtils.asserter().assertNotNull(book).elseThrow(ErrorCodeEnum.BOOK_NOT_EXIST);
        // 判断用户是否正确
        AssertUtils.asserter().assertEqual(userId, book.getUserId()).elseThrow(ErrorCodeEnum.PERMISSION_DENIED);
        // 判断书籍状态，已下架才能被上架
        BookStatusEnum bookStatusEnum = BookStatusEnum.getByCode(book.getBookStatus());
        AssertUtils.asserter().assertTrue(bookStatusEnum.equals(BookStatusEnum.HAD_OFF_SHELF))
                .elseThrow(ErrorCodeEnum.BOOK_CAN_NOT_ON_SHELF);
        // 将书籍状态更新为空闲
        book.setBookStatus(BookStatusEnum.IDLE.getCode());
        bookMapper.updateByPrimaryKeySelective(book);
    }

    @Override
    public List<Book> getRecommendBookList(Long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        BookExample bookExample = new BookExample();
        bookExample.createCriteria()
                .andSchoolIdEqualTo(user.getSchoolId())
                .andBookStatusEqualTo(BookStatusEnum.IDLE.getCode());
        bookExample.setOrderByClause("id desc");
        List<Book> books = bookMapper.selectByExample(bookExample);
        List<Book> result = new ArrayList<>();
        if (books.size() == 0) {
            return result;
        }
        // 随机推荐 6 个
        int count = 6;
        for (int i = 0; i < count; i++) {
            Book book = books.get(RandomUtils.nextInt(0, books.size()));
            result.add(book);
        }
        return result.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<Book> getTodayBookList(Long userId) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        Calendar calendarFinal = Calendar.getInstance();
        calendarFinal.set(year, month, day, 0, 0, 0);
        User user = userMapper.selectByPrimaryKey(userId);
        BookExample bookExample = new BookExample();
        bookExample.createCriteria()
                .andSchoolIdEqualTo(user.getSchoolId())
                .andGmtCreateGreaterThan(calendarFinal.getTime())
                .andBookStatusEqualTo(BookStatusEnum.IDLE.getCode());
        bookExample.setOrderByClause("id desc");
        List<Book> books = bookMapper.selectByExample(bookExample);
        if (books.size() == 0) {
            return new ArrayList<>();
        }
        // 要 12 个
        int count  = 12;
        return books.subList(0, Math.min(count, books.size()));
    }
}
