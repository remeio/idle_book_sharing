package com.xumengqi.reme.as.service.biz.verificationcode;

import com.xumengqi.reme.api.biz.verificationcode.request.GetVerificationCodeRequest;
import com.xumengqi.reme.api.biz.verificationcode.response.GetVerificationCodeResponse;
import com.xumengqi.reme.api.biz.verificationcode.service.VerificationCodeService;
import com.xumengqi.reme.as.enums.VerificationCodeTypeEnum;
import com.xumengqi.reme.as.logic.verificationcode.VerificationCodeLogic;
import com.xumengqi.reme.base.annotations.ParamLog;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

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
        VerificationCodeTypeEnum verificationCodeTypeEnum = VerificationCodeTypeEnum.getByCode(request.getVerificationCodeTypeCode());
        AssertUtils.isNotNull(verificationCodeTypeEnum, ErrorCodeEnum.SQL_ERROR);
        verificationCodeLogic.generateAndSendVerificationCode(request.getUserInput(), verificationCodeTypeEnum);
        return new GetVerificationCodeResponse();
    }

}
