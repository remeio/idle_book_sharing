package com.xumengqi.reme.as.service.book;

import com.xumengqi.reme.api.book.BookService;
import com.xumengqi.reme.api.book.dto.BookCatalogDTO;
import com.xumengqi.reme.api.book.request.GetBookCatalogListRequest;
import com.xumengqi.reme.api.book.request.UploadBookRequest;
import com.xumengqi.reme.api.book.response.GetBookCatalogListResponse;
import com.xumengqi.reme.api.book.response.UploadBookResponse;
import com.xumengqi.reme.as.logic.book.BookCatalogLogic;
import com.xumengqi.reme.as.logic.book.BookLogic;
import com.xumengqi.reme.as.logic.user.UserLogic;
import com.xumengqi.reme.base.annotations.AccessToken;
import com.xumengqi.reme.base.annotations.SystemLog;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.base.util.ConvertUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.common.enums.YesOrNoEnum;
import com.xumengqi.reme.dao.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        // 初始为未删除
        book.setIsDelete(YesOrNoEnum.NO.getCode());
        bookLogic.addBook(book);
        return new UploadBookResponse();
    }

    @Override
    public GetBookCatalogListResponse getBookCatalogList(GetBookCatalogListRequest request) {
        GetBookCatalogListResponse response = new GetBookCatalogListResponse();
        response.setBookCatalogDTOList(ConvertUtils.toList(bookCatalogLogic.getBookCatalogList(), BookCatalogDTO.class));
        return response;
    }
}
