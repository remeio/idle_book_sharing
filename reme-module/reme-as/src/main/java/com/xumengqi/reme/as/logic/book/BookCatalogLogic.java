package com.xumengqi.reme.as.logic.book;

import com.xumengqi.reme.dao.entity.BookCatalog;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/25 14:29
 */
public interface BookCatalogLogic {
    /**
     * 获取书籍分类列表
     *
     * @return /
     */
    List<BookCatalog> getBookCatalogList();

    /**
     * 判断书籍分类是否存在
     *
     * @param bookCatalogId 书籍分类ID
     * @return /
     */
    Boolean isExistBookCatalog(Long bookCatalogId);

    /**
     * 获取书籍分类
     *
     * @param bookCatalogId /
     * @return /
     */
    BookCatalog getBookCatalog(Long bookCatalogId);
}
