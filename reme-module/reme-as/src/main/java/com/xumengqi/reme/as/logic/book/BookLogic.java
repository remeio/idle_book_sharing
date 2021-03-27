package com.xumengqi.reme.as.logic.book;

import com.xumengqi.reme.common.enums.biz.BookStatusEnum;
import com.xumengqi.reme.dao.entity.Book;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/25 14:36
 */
public interface BookLogic {

    /**
     * 新增书籍
     *
     * @param book /
     */
    void addBook(Book book);

    /**
     * 获取书籍列表
     *
     * @param schoolId       为空查询全部
     * @param bookCatalogId  为空查询全部
     * @param bookStatusEnum 为空查询全部
     * @return /
     */
    List<Book> getBookList(Long schoolId, Long bookCatalogId, BookStatusEnum bookStatusEnum);

    /**
     * 获取书籍列表
     *
     * @param userId 为空查询全部
     * @return /
     */
    List<Book> getBookList(Long userId);

    /**
     * 获取书籍
     *
     * @param bookId /
     * @return /
     */
    Book getBook(Long bookId);

    /**
     * 下架书籍
     *
     * @param bookId /
     * @param userId /
     */
    void offShelfBook(Long bookId, Long userId);

    /**
     * 删除书籍
     *
     * @param bookId /
     * @param userId /
     */
    void deleteBook(Long bookId, Long userId);

    /**
     * 上架书籍
     *
     * @param bookId /
     * @param userId /
     */
    void onShelfBook(Long bookId, Long userId);
}
