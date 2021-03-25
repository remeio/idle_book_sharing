package com.xumengqi.reme.as.service.book;

import com.xumengqi.reme.api.book.BookService;
import com.xumengqi.reme.api.book.dto.BookCatalogDTO;
import com.xumengqi.reme.api.book.dto.BookDTO;
import com.xumengqi.reme.api.book.request.GetBookCatalogListRequest;
import com.xumengqi.reme.api.book.request.GetBookListByBookCatalogRequest;
import com.xumengqi.reme.api.book.request.UploadBookRequest;
import com.xumengqi.reme.api.book.response.GetBookCatalogListResponse;
import com.xumengqi.reme.api.book.response.GetBookListByBookCatalogResponse;
import com.xumengqi.reme.api.book.response.UploadBookResponse;
import com.xumengqi.reme.as.logic.book.BookCatalogLogic;
import com.xumengqi.reme.as.logic.book.BookLogic;
import com.xumengqi.reme.as.logic.user.UserLogic;
import com.xumengqi.reme.base.annotations.AccessToken;
import com.xumengqi.reme.base.annotations.SystemLog;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.base.util.ConvertUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.common.enums.biz.BookStatusEnum;
import com.xumengqi.reme.dao.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author xumengqi
 * @date 2021/3/25 14:21
 */
@SystemLog
@Component
public class BookServiceImpl implements BookService {

    @Autowired
    private BookCatalogLogic bookCatalogLogic;

    @Autowired
    private BookLogic bookLogic;

    @Autowired
    private UserLogic userLogic;

    @AccessToken
    @Override
    public UploadBookResponse uploadBook(UploadBookRequest request) {
        Book book = new Book();
        book.setBookIsbn(Optional.ofNullable(request.getBookIsbn()).orElse(""));
        book.setBookName(request.getBookName());
        book.setBookDescription(request.getBookDescription());
        book.setBookImageUrl(request.getBookImageUrl());
        book.setBookDeposit(request.getBookDeposit());
        book.setBookMaxPeriod(request.getBookMaxPeriod());
        // 检查分类是否存在
        final Long bookCatalogId = request.getBookCatalogId();
        AssertUtils.asserter()
                .assertTrue(bookCatalogLogic.isExistBookCatalog(bookCatalogId))
                .elseThrow(ErrorCodeEnum.BOOK_CATALOG_NOT_EXIST);
        book.setBookCatalogId(bookCatalogId);
        // 插入 userId 和 schoolId
        final Long userId = request.getOperatorId();
        book.setUserId(userId);
        book.setSchoolId(userLogic.getSchoolByUserId(userId).getId());
        // 初始为可借阅
        book.setBookStatus(BookStatusEnum.CAN_BE_BORROWED.getCode());
        bookLogic.addBook(book);
        return new UploadBookResponse();
    }

    @Override
    public GetBookCatalogListResponse getBookCatalogList(GetBookCatalogListRequest request) {
        GetBookCatalogListResponse response = new GetBookCatalogListResponse();
        response.setBookCatalogDTOList(ConvertUtils.toList(bookCatalogLogic.getBookCatalogList(), BookCatalogDTO.class));
        return response;
    }

    @AccessToken
    @Override
    public GetBookListByBookCatalogResponse getBookListByBookCatalog(GetBookListByBookCatalogRequest request) {
        // 检查分类是否存在
        final Long bookCatalogId = request.getBookCatalogId();
        AssertUtils.asserter()
                .assertTrue(bookCatalogLogic.isExistBookCatalog(bookCatalogId))
                .elseThrow(ErrorCodeEnum.BOOK_CATALOG_NOT_EXIST);
        // 获取学校ID
        final Long userId = request.getOperatorId();
        final Long schoolId = userLogic.getSchoolByUserId(userId).getId();
        // 根据学校ID和分类ID查询书籍列表
        List<Book> books = bookLogic.getBookList(schoolId, bookCatalogId, BookStatusEnum.CAN_BE_BORROWED);
        GetBookListByBookCatalogResponse response = new GetBookListByBookCatalogResponse();
        response.setBookDTOList(ConvertUtils.toList(books, BookDTO.class));
        return response;
    }
}
