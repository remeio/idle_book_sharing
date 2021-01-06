package com.xumengqi.reme.service;

import com.xumengqi.reme.aspect.LogAspect;
import com.xumengqi.reme.request.CheckVerificationCodeRequest;
import com.xumengqi.reme.request.GetVerificationCodeRequest;
import com.xumengqi.reme.response.CheckVerificationCodeResponse;
import com.xumengqi.reme.response.GetVerificationCodeResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author xumengqi
 * @date 2020/12/28 19:26
 */
@RequestMapping("/verificationCode")
@RestController
public interface VerificationCodeService {
    /**
     * 获取验证码
     * @param request /
     * @return /
     */
    @PostMapping("/getVerificationCode")
    GetVerificationCodeResponse getVerificationCode(@Valid @RequestBody GetVerificationCodeRequest request);

    /**
     * 校验验证码
     * @param request /
     * @return /
     */

    @PostMapping("/checkVerificationCode")
    CheckVerificationCodeResponse checkVerificationCode(@Valid @RequestBody CheckVerificationCodeRequest request);
}
