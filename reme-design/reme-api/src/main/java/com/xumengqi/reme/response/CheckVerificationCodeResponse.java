package com.xumengqi.reme.response;

import com.xumengqi.reme.base.BaseResponse;

/**
 * @author xumengqi
 * @date 2020/12/29 19:43
 */
public class CheckVerificationCodeResponse extends BaseResponse {

    private Boolean isPass;

    public Boolean getIsPass() {
        return this.isPass;
    }

    public void setIsPass(Boolean isPass) {
        this.isPass = isPass;
    }
}
