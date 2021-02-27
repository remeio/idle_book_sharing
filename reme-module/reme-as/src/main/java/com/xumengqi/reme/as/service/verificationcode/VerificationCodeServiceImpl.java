package com.xumengqi.reme.as.service.verificationcode;

import com.xumengqi.reme.api.biz.verificationcode.request.GetVerificationCodeRequest;
import com.xumengqi.reme.api.biz.verificationcode.response.GetVerificationCodeResponse;
import com.xumengqi.reme.api.biz.verificationcode.service.VerificationCodeService;
import com.xumengqi.reme.as.logic.verificationcode.VerificationCodeLogic;
import com.xumengqi.reme.base.annotations.ParamLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xumengqi
 * @date 2021/2/27 14:25
 */
@ParamLog
@Component
public class VerificationCodeServiceImpl implements VerificationCodeService {
    @Autowired
    private VerificationCodeLogic verificationCodeLogic;

    @Override
    public GetVerificationCodeResponse getVerificationCode(GetVerificationCodeRequest request) {
        verificationCodeLogic.generateAndSendVerificationCode(request.getUserParameter(), request.getVerificationCodeTypeName());
        return new GetVerificationCodeResponse();
    }

}
