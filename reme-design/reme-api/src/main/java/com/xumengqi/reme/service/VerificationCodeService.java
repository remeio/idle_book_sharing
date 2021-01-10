package com.xumengqi.reme.service;

import com.xumengqi.reme.request.CheckVerificationCodeRequest;
import com.xumengqi.reme.request.GetVerificationCodeRequest;
import com.xumengqi.reme.response.CheckVerificationCodeResponse;
import com.xumengqi.reme.response.GetVerificationCodeResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author xumengqi
 * @date 2020/12/28 19:26
 */
@Api(tags = "VerificationCodeService", description = "验证码服务")
@RequestMapping("/verificationCode")
@RestController
public interface VerificationCodeService {
    /**
     * 获取验证码
     * @param request /
     * @return /
     */
    @ApiOperation("获取验证码")
    @PostMapping("/getVerificationCode")
    GetVerificationCodeResponse getVerificationCode(@Valid @RequestBody @ApiParam GetVerificationCodeRequest request);

    /**
     * 校验验证码
     * @param request /
     * @return /
     */
    @ApiOperation("校验验证码")
    @PostMapping("/checkVerificationCode")
    CheckVerificationCodeResponse checkVerificationCode(@Valid @RequestBody @ApiParam CheckVerificationCodeRequest request);
}
