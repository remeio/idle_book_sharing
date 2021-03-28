package com.xumengqi.reme.api.book.response;

import com.xumengqi.reme.api.book.dto.ShareLogDTO;
import com.xumengqi.reme.api.book.dto.ShareRecordDTO;
import com.xumengqi.reme.base.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/28 14:00
 */
@Getter
@Setter
public class GetShareLogListByShareRecordIdResponse extends BaseResponse {

    private List<ShareLogDTO> shareLogDTOList;

    private ShareRecordDTO shareRecordDTO;
}
