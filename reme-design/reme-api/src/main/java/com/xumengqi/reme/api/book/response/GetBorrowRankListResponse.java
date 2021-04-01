package com.xumengqi.reme.api.book.response;

import com.xumengqi.reme.api.book.dto.RankDTO;
import com.xumengqi.reme.base.BaseResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/4/1 12:35
 */
@Getter
@Setter
public class GetBorrowRankListResponse extends BaseResponse {
    @ApiModelProperty("排行榜")
    private List<RankDTO> rankDTOList;
}
