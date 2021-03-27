package com.xumengqi.reme.api.deposit.request;

import com.xumengqi.reme.base.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author xumengqi
 * @date 2021/3/27 12:50
 */
@Getter
@Setter
public class PayDepositRequest extends BaseRequest {
    @ApiModelProperty("押金金额")
    @Min(1)
    @Max(200)
    private Long depositAmount;

    @ApiModelProperty("外部订单号")
    @NotBlank
    private String outerOrderNo;
}
