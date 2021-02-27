package com.xumengqi.reme.api.verificationcode.service;

import com.xumengqi.reme.api.verificationcode.request.GetVerificationCodeRequest;
import com.xumengqi.reme.api.verificationcode.response.GetVerificationCodeResponse;
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
 * @date 2021/2/27 14:22
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
    GetVerificationCodeResponse getVerificationCode(@ApiParam @Valid @RequestBody GetVerificationCodeRequest request);
}
