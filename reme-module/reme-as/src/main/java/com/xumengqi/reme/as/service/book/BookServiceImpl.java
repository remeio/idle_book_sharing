package com.xumengqi.reme.as.service.book;

import com.xumengqi.reme.api.book.BookService;
import com.xumengqi.reme.api.book.dto.BookCatalogDTO;
import com.xumengqi.reme.api.book.dto.BookDTO;
import com.xumengqi.reme.api.book.request.*;
import com.xumengqi.reme.api.book.response.*;
import com.xumengqi.reme.as.logic.book.BookCatalogLogic;
import com.xumengqi.reme.as.logic.book.BookLogic;
import com.xumengqi.reme.as.logic.book.ShareRecordLogic;
import com.xumengqi.reme.as.logic.user.UserLogic;
import com.xumengqi.reme.base.annotations.AccessToken;
import com.xumengqi.reme.base.annotations.SystemLog;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.base.util.ConvertUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.common.enums.biz.BookStatusEnum;
import com.xumengqi.reme.dao.entity.Book;
import com.xumengqi.reme.dao.entity.BookCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Autowired
    private ShareRecordLogic shareRecordLogic;

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
        book.setBookStatus(BookStatusEnum.IDLE.getCode());
        book.setGmtCreate(new Date());
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
        List<Book> books = bookLogic.getBookList(schoolId, bookCatalogId, BookStatusEnum.IDLE);
        GetBookListByBookCatalogResponse response = new GetBookListByBookCatalogResponse();
        response.setBookDTOList(ConvertUtils.toList(books, BookDTO.class));
        return response;
    }

    @AccessToken
    @Override
    public GetBookListByUserIdResponse getBookListByUserId(@Valid GetBookListByUserIdRequest request) {
        List<Book> books = bookLogic.getBookList(request.getOperatorId());
        List<BookCatalog> bookCatalogs = bookCatalogLogic.getBookCatalogList();
        Map<Long, String> bookCatalogMap = bookCatalogs.stream().collect(Collectors.toMap(BookCatalog::getId, BookCatalog::getBookCatalogName));
        GetBookListByUserIdResponse response = new GetBookListByUserIdResponse();
        response.setBookDTOList(ConvertUtils.toList(books, BookDTO.class)
                .stream()
                .peek(e -> e.setBookCatalogName(bookCatalogMap.get(e.getBookCatalogId())))
                .collect(Collectors.toList()));
        return response;
    }

    @Override
    public GetBookInfoResponse getBookInfo(GetBookInfoRequest request) {
        final Long bookId = request.getBookId();
        // 判断书籍是否存在
        Book book = bookLogic.getBook(bookId);
        AssertUtils.asserter().assertNotNull(book).elseThrow(ErrorCodeEnum.BOOK_NOT_EXIST);
        final Long userId = book.getUserId();
        BookDTO bookDTO = ConvertUtils.toObj(book, BookDTO.class);
        // 填充学校
        bookDTO.setSchoolName(userLogic.getSchoolByUserId(userId).getSchoolName());
        // 填充上传用户
        bookDTO.setUserFullName(userLogic.getUser(userId).getUserFullName());
        // 填充书籍分类
        bookDTO.setBookCatalogName(bookCatalogLogic.getBookCatalog(book.getBookCatalogId()).getBookCatalogName());
        GetBookInfoResponse response = new GetBookInfoResponse();
        response.setBookDTO(bookDTO);
        return response;
    }

    @AccessToken
    @Override
    public BorrowBookResponse borrowBook(BorrowBookRequest request) {
        final Long bookId = request.getBookId();
        final Long borrowUserId = request.getOperatorId();
        shareRecordLogic.borrowBook(bookId, borrowUserId);
        return new BorrowBookResponse();
    }

    @AccessToken
    @Override
    public OffShelfBookResponse offShelfBook(OffShelfBookRequest request) {
        bookLogic.offShelfBook(request.getBookId(), request.getOperatorId());
        return new OffShelfBookResponse();
    }

    @AccessToken
    @Override
    public OnShelfBookResponse onShelfBook(@Valid OnShelfBookRequest request) {
        bookLogic.onShelfBook(request.getBookId(), request.getOperatorId());
        return new OnShelfBookResponse();
    }

    @AccessToken
    @Override
    public DeleteBookResponse deleteBook(DeleteBookRequest request) {
        bookLogic.deleteBook(request.getBookId(), request.getOperatorId());
        return new DeleteBookResponse();
    }

    @Override
    public GetRecommendBookListResponse getRecommendBookList(@Valid GetRecommendBookListRequest request) {
        List<Book> books = bookLogic.getRecommendBookList(request.getOperatorId());
        GetRecommendBookListResponse response = new GetRecommendBookListResponse();
        response.setBookDTOList(ConvertUtils.toList(books, BookDTO.class));
        return response;
    }

    @Override
    public GetTodayBookListResponse getTodayBookList(GetTodayBookListRequest request) {
        List<Book> books = bookLogic.getTodayBookList(request.getOperatorId());
        GetTodayBookListResponse response = new GetTodayBookListResponse();
        response.setBookDTOList(ConvertUtils.toList(books, BookDTO.class));
        return response;
    }
}
