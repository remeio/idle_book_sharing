package com.xumengqi.reme.api.response;

import com.xumengqi.reme.base.base.BaseResponse;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author xumengqi
 * @date 2020/12/29 19:43
 */
public class CheckVerificationCodeResponse extends BaseResponse {

    @ApiModelProperty("是否通过验证")
    private Boolean isPass;

    public Boolean getIsPass() {
        return this.isPass;
    }

    public void setIsPass(Boolean isPass) {
        this.isPass = isPass;
    }
}
