package com.xumengqi.reme.as.service.book;

import com.xumengqi.reme.api.book.ShareRecordService;
import com.xumengqi.reme.api.book.dto.ShareRecordDTO;
import com.xumengqi.reme.api.book.request.*;
import com.xumengqi.reme.api.book.response.*;
import com.xumengqi.reme.as.logic.book.BookLogic;
import com.xumengqi.reme.as.logic.book.ShareRecordLogic;
import com.xumengqi.reme.as.vo.ShareRecordVO;
import com.xumengqi.reme.base.annotations.AccessToken;
import com.xumengqi.reme.base.annotations.SystemLog;
import com.xumengqi.reme.base.util.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.List;


/**
 * @author xumengqi
 * @date 2021/3/27 13:22
 */
@AccessToken
@Component
@SystemLog
public class ShareRecordServiceImpl implements ShareRecordService {
    @Autowired
    private ShareRecordLogic shareRecordLogic;

    @Autowired
    private BookLogic bookLogic;

    @Override
    public ReceiveBookResponse receiveBook(ReceiveBookRequest request) {
        final Long userId = request.getOperatorId();
        final Long shareRecordId = request.getShareRecordId();
        shareRecordLogic.receiveBook(shareRecordId, userId);
        return new ReceiveBookResponse();
    }

    @Override
    public ReturnBookResponse returnBook(@Valid ReturnBookRequest request) {
        final Long userId = request.getOperatorId();
        final Long shareRecordId = request.getShareRecordId();
        shareRecordLogic.returnBook(shareRecordId, userId);
        return new ReturnBookResponse();
    }

    @Override
    public CancelBorrowBookResponse cancelBorrowBook(CancelBorrowBookRequest request) {
        final Long userId = request.getOperatorId();
        final Long shareRecordId = request.getShareRecordId();
        shareRecordLogic.cancelBorrowBook(shareRecordId, userId);
        return new CancelBorrowBookResponse();
    }

    @Override
    public LostHandleBookResponse lostHandleBook(LostHandleBookRequest request) {
        final Long userId = request.getOperatorId();
        final Long shareRecordId = request.getShareRecordId();
        shareRecordLogic.lostHandleBook(shareRecordId, userId);
        return new LostHandleBookResponse();
    }

    @Override
    public SeriouslyOverdueHandleBookResponse seriouslyOverdueHandleBook(SeriouslyOverdueHandleBookRequest request) {
        final Long userId = request.getOperatorId();
        final Long shareRecordId = request.getShareRecordId();
        shareRecordLogic.seriouslyOverdueHandleBook(shareRecordId, userId);
        return new SeriouslyOverdueHandleBookResponse();
    }

    @AccessToken
    @Override
    public GetShareRecordListByBorrowUserIdResponse getShareRecordListByBorrowUserId(GetShareRecordListByBorrowUserIdRequest request) {
        List<ShareRecordVO> shareRecordList = shareRecordLogic.getShareRecordListByBorrowUserId(request.getOperatorId());
        GetShareRecordListByBorrowUserIdResponse response = new GetShareRecordListByBorrowUserIdResponse();
        response.setShareRecordDTOList(ConvertUtils.toList(shareRecordList, ShareRecordDTO.class));
        return response;
    }

    @AccessToken
    @Override
    public GetShareRecordListByShareUserIdResponse getShareRecordListByShareUserId(GetShareRecordListByShareUserIdRequest request) {
        List<ShareRecordVO> shareRecordList = shareRecordLogic.getShareRecordListByShareUserId(request.getOperatorId());
        GetShareRecordListByShareUserIdResponse response = new GetShareRecordListByShareUserIdResponse();
        response.setShareRecordDTOList(ConvertUtils.toList(shareRecordList, ShareRecordDTO.class));
        return response;
    }
}
