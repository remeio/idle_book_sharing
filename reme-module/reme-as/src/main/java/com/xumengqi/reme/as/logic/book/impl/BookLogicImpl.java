package com.xumengqi.reme.as.logic.book.impl;

import com.xumengqi.reme.as.logic.book.BookLogic;
import com.xumengqi.reme.as.logic.book.ShareRecordLogic;
import com.xumengqi.reme.as.mapper.ShareRecordExtMapper;
import com.xumengqi.reme.as.util.IsbnUtils;
import com.xumengqi.reme.as.util.recommend.BookSample;
import com.xumengqi.reme.as.util.recommend.RecommendException;
import com.xumengqi.reme.as.util.recommend.Recommender;
import com.xumengqi.reme.as.vo.ShareRecordVO;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.base.util.ConvertUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.common.enums.biz.BookStatusEnum;
import com.xumengqi.reme.dao.entity.Book;
import com.xumengqi.reme.dao.entity.BookExample;
import com.xumengqi.reme.dao.entity.User;
import com.xumengqi.reme.dao.mapper.BookMapper;
import com.xumengqi.reme.dao.mapper.UserMapper;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xumengqi
 * @date 2021/3/25 14:37
 */
@Component
public class BookLogicImpl implements BookLogic {

    private static final Logger log = Logger.getLogger(BookLogicImpl.class);

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ShareRecordExtMapper shareRecordExtMapper;

    @Autowired
    private ShareRecordLogic shareRecordLogic;

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
    public List<Book> getRecommendBookList(Long userId, int count) {
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
        // 随机推荐 count 个
        Collections.shuffle(books);
        result.addAll(books.subList(0, Math.min(count, books.size())));
        return result;
    }

    @Override
    public List<Book> getTodayBookList(Long userId, int count) {
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
        // 要 count 个
        return books.subList(0, Math.min(count, books.size()));
    }

    @Override
    public List<Book> search(String keyword) {
        List<Book> result;
        // 根据书籍名称查询
        BookExample bookExampleName = new BookExample();
        bookExampleName.createCriteria()
                .andBookNameLike("%" + keyword + "%")
                .andBookStatusEqualTo(BookStatusEnum.IDLE.getCode());
        result = bookMapper.selectByExample(bookExampleName);
        if (result.size() > 0) {
            return result;
        }
        // 根据 ISBN 查询
        if (IsbnUtils.isValidIsbn(keyword)) {
            BookExample bookExampleIsbn = new BookExample();
            bookExampleIsbn.createCriteria()
                    .andBookIsbnEqualTo(keyword)
                    .andBookStatusEqualTo(BookStatusEnum.IDLE.getCode());
            return bookMapper.selectByExample(bookExampleName);
        }
        // 根据免押金与否查询
        final String noDeposit = "免押金";
        if (noDeposit.equals(keyword)) {
            BookExample bookExampleDeposit = new BookExample();
            bookExampleDeposit.createCriteria()
                    .andBookDepositEqualTo(0L)
                    .andBookStatusEqualTo(BookStatusEnum.IDLE.getCode());
            return bookMapper.selectByExample(bookExampleDeposit);
        }
        return result;
    }

    @Override
    public List<Book> recommend(Long userId, int count) {
        List<BookSample> bookExampleList = shareRecordExtMapper.getBookSampleList(userId);
        List<Book> bookList = new ArrayList<>();
        try {
            Set<Long> neighborIds = Recommender.recommend(userId, bookExampleList, 1);
            // 找到邻居借阅过的书籍
            neighborIds.forEach(e -> {
                List<ShareRecordVO> shareRecordVOList = shareRecordLogic.getShareRecordListByBorrowUserId(e);
                shareRecordVOList.forEach(sr -> {
                    Book book = ConvertUtils.toObj(sr, Book.class);
                    book.setId(sr.getBookId());
                    bookList.add(book);
                });
            });
            // 推荐 count 个
            Collections.shuffle(bookList);
            return bookList.subList(0, Math.min(bookList.size(), count));
        } catch (RecommendException e) {
            log.warn("KNN推荐失败，启用随机推荐", e);
            // 随机推荐
            return getRecommendBookList(userId, count);
        }
    }
}
