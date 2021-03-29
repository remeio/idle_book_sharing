package com.xumengqi.reme.as.service.book;

import com.xumengqi.reme.api.book.BookcaseService;
import com.xumengqi.reme.api.book.dto.BookcaseDTO;
import com.xumengqi.reme.api.book.request.AddToBookcaseRequest;
import com.xumengqi.reme.api.book.request.DeleteFromBookcaseRequest;
import com.xumengqi.reme.api.book.request.GetBookListByUserIdRequest;
import com.xumengqi.reme.api.book.response.AddToBookcaseResponse;
import com.xumengqi.reme.api.book.response.DeleteFromBookcaseResponse;
import com.xumengqi.reme.api.book.response.GetBookcaseListByUserIdResponse;
import com.xumengqi.reme.as.logic.book.BookLogic;
import com.xumengqi.reme.as.logic.book.BookcaseLogic;
import com.xumengqi.reme.as.vo.BookcaseVO;
import com.xumengqi.reme.base.annotations.AccessToken;
import com.xumengqi.reme.base.annotations.SystemLog;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.base.util.ConvertUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.dao.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/29 22:35
 */
@AccessToken
@SystemLog
@Component
public class BookcaseServiceImpl implements BookcaseService {
    @Autowired
    private BookLogic bookLogic;

    @Autowired
    private BookcaseLogic bookcaseLogic;

    @Override
    public AddToBookcaseResponse addToBookcase(AddToBookcaseRequest request) {
        // 判断书籍是否存在
        Book book = bookLogic.getBook(request.getBookId());
        AssertUtils.asserter().assertNotNull(book).elseThrow(ErrorCodeEnum.BOOK_NOT_EXIST);
        bookcaseLogic.add(request.getBookId(), request.getOperatorId());
        return new AddToBookcaseResponse();
    }

    @Override
    public DeleteFromBookcaseResponse deleteFromBookcase(DeleteFromBookcaseRequest request) {
        bookcaseLogic.delete(request.getBookcaseId(), request.getOperatorId());
        return new DeleteFromBookcaseResponse();
    }

    @Override
    public GetBookcaseListByUserIdResponse getBookcaseListByUserId(GetBookListByUserIdRequest request) {
        List<BookcaseVO> bookcaseVOList = bookcaseLogic.getListByUserId(request.getOperatorId());
        GetBookcaseListByUserIdResponse response = new GetBookcaseListByUserIdResponse();
        response.setBookcaseDTOList(ConvertUtils.toList(bookcaseVOList, BookcaseDTO.class));
        return response;
    }
}
