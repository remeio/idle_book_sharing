package com.xumengqi.reme.as.service;

import com.xumengqi.reme.api.request.CheckVerificationCodeRequest;
import com.xumengqi.reme.api.request.GetVerificationCodeRequest;
import com.xumengqi.reme.api.response.CheckVerificationCodeResponse;
import com.xumengqi.reme.api.response.GetVerificationCodeResponse;
import com.xumengqi.reme.api.service.VerificationCodeService;
import com.xumengqi.reme.as.logic.VerificationCodeLogic;
import com.xumengqi.reme.base.aspect.LogAspect;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xumengqi
 * @date 2020/12/28 19:29
 */
@LogAspect
@Component
public class VerificationCodeServiceImpl implements VerificationCodeService {
    @Autowired
    private VerificationCodeLogic verificationCodeLogic;

    @Override
    public GetVerificationCodeResponse getVerificationCode(GetVerificationCodeRequest request) {
        GetVerificationCodeResponse response = new GetVerificationCodeResponse();
        verificationCodeLogic.generateVerificationCode(request.getEmail());
        response.success(ErrorCodeEnum.VERIFICATION_CODE_SEND_SUCCESS);
        return response;
    }

    @Override
    public CheckVerificationCodeResponse checkVerificationCode(CheckVerificationCodeRequest request) {
        CheckVerificationCodeResponse response = new CheckVerificationCodeResponse();
        boolean isPass = verificationCodeLogic.checkVerificationCode(request.getEmail(), request.getVerificationCode());
        response.setIsPass(isPass);
        response.success(isPass ? ErrorCodeEnum.VERIFICATION_CODE_PASS : ErrorCodeEnum.VERIFICATION_CODE_NOT_PASS);
        return response;
    }
}
