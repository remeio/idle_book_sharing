package com.xumengqi.reme.api.book.response;

import com.xumengqi.reme.api.book.dto.ShareRecordDTO;
import com.xumengqi.reme.base.BaseResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/27 19:30
 */
@Getter
@Setter
public class GetShareRecordListByBorrowUserIdResponse extends BaseResponse {
    @ApiModelProperty("借阅记录")
    private List<ShareRecordDTO> shareRecordDTOList;
}
