package com.xumengqi.reme.api.service;

import com.xumengqi.reme.api.request.GetErrorCodePageRequest;
import com.xumengqi.reme.api.response.GetErrorCodePageResponse;
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
 * @date 2021/1/30 22:14
 */
@Api(tags = "ErrorCodeService", description = "错误码服务")
@RequestMapping("/errorCode")
@RestController
public interface ErrorCodeService {
    /**
     * 获取错误码分页
     * @param request /
     * @return /
     */
    @ApiOperation("获取错误码分页")
    @PostMapping("/getErrorCodePage")
    GetErrorCodePageResponse getErrorCodePage(@Valid @RequestBody @ApiParam GetErrorCodePageRequest request);
}
