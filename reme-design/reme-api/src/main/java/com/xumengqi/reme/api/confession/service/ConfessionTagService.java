package com.xumengqi.reme.api.confession.service;

import com.xumengqi.reme.api.confession.request.GetConfessionTagListRequest;
import com.xumengqi.reme.api.confession.request.PostConfessionRequest;
import com.xumengqi.reme.api.confession.response.GetConfessionTagListResponse;
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
 * @author xumengqi
 * @date 2021/3/9 17:47
 */
@Api(tags = "ConfessionTagService", description = "表白标签服务")
@RequestMapping("/confessionTag")
@RestController
public interface ConfessionTagService {
    /**
     * 获取表白标签列表
     *
     * @param request /
     * @return /
     */
    @ApiOperation("获取表白标签列表")
    @PostMapping("/getConfessionTagList")
    GetConfessionTagListResponse getConfessionTagList(@ApiParam @Valid @RequestBody GetConfessionTagListRequest request);
}
