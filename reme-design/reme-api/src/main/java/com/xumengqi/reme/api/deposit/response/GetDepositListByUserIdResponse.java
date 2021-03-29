package com.xumengqi.reme.api.deposit.response;

import com.xumengqi.reme.api.deposit.dto.DepositDTO;
import com.xumengqi.reme.base.BaseResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/29 19:32
 */
@Getter
@Setter
public class GetDepositListByUserIdResponse extends BaseResponse {
    @ApiModelProperty("押金列表")
    private List<DepositDTO> depositDTOList;
}
