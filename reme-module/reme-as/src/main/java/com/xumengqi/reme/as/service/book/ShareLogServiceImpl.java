package com.xumengqi.reme.as.service.book;

import com.xumengqi.reme.api.book.ShareLogService;
import com.xumengqi.reme.api.book.dto.ShareLogDTO;
import com.xumengqi.reme.api.book.dto.ShareRecordDTO;
import com.xumengqi.reme.api.book.request.GetShareLogListByShareRecordIdRequest;
import com.xumengqi.reme.api.book.response.GetShareLogListByShareRecordIdResponse;
import com.xumengqi.reme.as.logic.book.ShareLogLogic;
import com.xumengqi.reme.as.logic.book.ShareRecordLogic;
import com.xumengqi.reme.as.vo.ShareRecordVO;
import com.xumengqi.reme.base.annotations.AccessToken;
import com.xumengqi.reme.base.annotations.SystemLog;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.base.util.ConvertUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.dao.entity.ShareLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/28 14:06
 */
@Component
@SystemLog
public class ShareLogServiceImpl implements ShareLogService {

    @Autowired
    private ShareLogLogic shareLogLogic;

    @Autowired
    private ShareRecordLogic shareRecordLogic;

    @AccessToken
    @Override
    public GetShareLogListByShareRecordIdResponse getShareLogListByShareRecordId(GetShareLogListByShareRecordIdRequest request) {
        final Long userId = request.getOperatorId();
        final Long shareRecordId = request.getShareRecordId();
        ShareRecordVO shareRecordVO = shareRecordLogic.getShareRecord(shareRecordId);
        // 判断用户是否有权限
        AssertUtils.asserter().assertTrue(userId.equals(shareRecordVO.getBorrowUserId()) || userId.equals(shareRecordVO.getShareUserId()))
                .elseThrow(ErrorCodeEnum.PERMISSION_DENIED);
        List<ShareLog> shareLogs = shareLogLogic.getShareLogListByShareRecordId(shareRecordId);
        GetShareLogListByShareRecordIdResponse response = new GetShareLogListByShareRecordIdResponse();
        response.setShareRecordDTO(ConvertUtils.toObj(shareRecordVO, ShareRecordDTO.class));
        response.setShareLogDTOList(ConvertUtils.toList(shareLogs, ShareLogDTO.class));
        return response;
    }

}
