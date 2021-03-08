package com.xumengqi.reme.api.confession.service;

import com.xumengqi.reme.api.confession.request.PostConfessionRequest;
import com.xumengqi.reme.api.confession.response.PostConfessionResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 表白服务
 *
 * @author xumengqi
 * @date 2021/3/8 18:01
 */
@Api(tags = "ConfessionService", description = "表白服务")
@RequestMapping("/confession")
@RestController
public interface ConfessionService {
    /**
     * 发布表白信息
     *
     * @param request /
     * @return /
     */
    @ApiOperation("发布表白信息")
    @PostMapping("/postConfession")
    PostConfessionResponse postConfession(@ApiParam @Valid @RequestBody PostConfessionRequest request);
}
