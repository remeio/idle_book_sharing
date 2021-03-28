package com.xumengqi.reme.api.book;

import com.xumengqi.reme.api.book.request.GetShareLogListByShareRecordIdRequest;
import com.xumengqi.reme.api.book.response.GetShareLogListByShareRecordIdResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 共享日志服务
 *
 * @author xumengqi
 */
@Api(tags = "ShareLogService", description = "共享日志服务")
@RequestMapping("/shareLog")
@RestController
public interface ShareLogService {
    /**
     * 根据共享记录ID查询共享记录和共享日志列表
     *
     * @param request /
     * @return /
     */
    @ApiOperation("根据共享记录ID查询共享记录和共享日志列表")
    @PostMapping("/getShareLogListByShareRecordIdResponse")
    GetShareLogListByShareRecordIdResponse getShareLogListByShareRecordIdResponse(@ApiParam @Valid @RequestBody GetShareLogListByShareRecordIdRequest request);
}
