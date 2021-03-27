package com.xumengqi.reme.as.service.book;

import com.xumengqi.reme.api.book.ShareRecordService;
import com.xumengqi.reme.api.book.request.*;
import com.xumengqi.reme.api.book.response.*;
import com.xumengqi.reme.as.logic.book.ShareRecordLogic;
import com.xumengqi.reme.base.annotations.AccessToken;
import com.xumengqi.reme.base.annotations.SystemLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;


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
    public OverdueReturnBookResponse overdueReturnBook(OverdueReturnBookRequest request) {
        final Long userId = request.getOperatorId();
        final Long shareRecordId = request.getShareRecordId();
        shareRecordLogic.overdueReturnBook(shareRecordId, userId);
        return new OverdueReturnBookResponse();
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
}
