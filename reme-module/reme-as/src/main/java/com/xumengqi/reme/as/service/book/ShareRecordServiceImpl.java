package com.xumengqi.reme.as.service.book;

import com.xumengqi.reme.api.book.ShareRecordService;
import com.xumengqi.reme.api.book.dto.MessageDTO;
import com.xumengqi.reme.api.book.dto.RankDTO;
import com.xumengqi.reme.api.book.dto.ShareRecordDTO;
import com.xumengqi.reme.api.book.request.*;
import com.xumengqi.reme.api.book.response.*;
import com.xumengqi.reme.as.logic.book.BookLogic;
import com.xumengqi.reme.as.logic.book.ShareRecordLogic;
import com.xumengqi.reme.as.logic.user.UserLogic;
import com.xumengqi.reme.as.vo.RankVO;
import com.xumengqi.reme.as.vo.ShareRecordVO;
import com.xumengqi.reme.base.annotations.AccessToken;
import com.xumengqi.reme.base.annotations.NoAccessToken;
import com.xumengqi.reme.base.annotations.SystemLog;
import com.xumengqi.reme.base.util.ConvertUtils;
import com.xumengqi.reme.dao.entity.Message;
import com.xumengqi.reme.dao.entity.ShareRecord;
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
    private UserLogic userLogic;

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

    @NoAccessToken
    @Override
    public GetShareRankListResponse getShareRankList(@Valid GetShareRankListRequest request) {
        List<RankVO> rankVOList = shareRecordLogic.getShareRankList(100);
        GetShareRankListResponse response = new GetShareRankListResponse();
        response.setRankDTOList(ConvertUtils.toList(rankVOList, RankDTO.class));
        return response;
    }

    @NoAccessToken
    @Override
    public GetBorrowRankListResponse getBorrowRankList(@Valid GetBorrowRankListRequest request) {
        List<RankVO> rankVOList = shareRecordLogic.getBorrowRankList(100);
        GetBorrowRankListResponse response = new GetBorrowRankListResponse();
        response.setRankDTOList(ConvertUtils.toList(rankVOList, RankDTO.class));
        return response;
    }

    @AccessToken
    @Override
    public SendMessageResponse sendMessage(@Valid SendMessageRequest request) {
        shareRecordLogic.sendMessage(request.getOperatorId(), request.getShareRecordId(), request.getMessageContent());
        return new SendMessageResponse();
    }

    @AccessToken
    @Override
    public GetMessageListResponse getMessageList(@Valid GetMessageListRequest request) {
        List<Message> messages = shareRecordLogic.getMessageList(request.getOperatorId(), request.getShareRecordId());
        ShareRecordVO shareRecordVO = shareRecordLogic.getShareRecord(request.getShareRecordId());
        String borrowUserFullName = userLogic.getUser(shareRecordVO.getBorrowUserId()).getUserFullName();
        String shareUserFullName = userLogic.getUser(shareRecordVO.getShareUserId()).getUserFullName();
        GetMessageListResponse response = new GetMessageListResponse();
        response.setMessageDTOList(ConvertUtils.toList(messages, MessageDTO.class));
        response.setBorrowUserFullName(borrowUserFullName);
        response.setShareUserFullName(shareUserFullName);
        return response;
    }
}
