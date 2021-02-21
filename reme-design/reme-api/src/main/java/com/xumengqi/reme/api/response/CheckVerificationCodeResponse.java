package com.xumengqi.reme.api.response;

import com.xumengqi.reme.base.BaseResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xumengqi
 * @date 2020/12/29 19:43
 */
@Getter
@Setter
public class CheckVerificationCodeResponse extends BaseResponse {

    @ApiModelProperty("是否通过验证")
    private Boolean isPass;
}
