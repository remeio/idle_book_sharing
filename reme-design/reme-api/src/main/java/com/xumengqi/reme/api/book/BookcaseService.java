package com.xumengqi.reme.api.book;

import com.xumengqi.reme.api.book.request.*;
import com.xumengqi.reme.api.book.response.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 书籍服务
 *
 * @author xumengqi
 */
@Api(tags = "BookcaseService", description = "书箱服务")
@RequestMapping("/bookcase")
@RestController
public interface BookcaseService {
    /**
     * 添加书籍到书箱
     *
     * @param request /
     * @return /
     */
    @ApiOperation("添加书籍到书箱")
    @PostMapping("/addToBookcase")
    AddToBookcaseResponse addToBookcase(@ApiParam @Valid @RequestBody AddToBookcaseRequest request);

    /**
     * 从书箱中删除书籍
     *
     * @param request /
     * @return /
     */
    @ApiOperation("从书箱中删除书籍")
    @PostMapping("/deleteFromBookcase")
    DeleteFromBookcaseResponse deleteFromBookcase(@ApiParam @Valid @RequestBody DeleteFromBookcaseRequest request);

    /**
     * 获取书箱
     *
     * @param request /
     * @return /
     */
    @ApiOperation("获取书箱")
    @PostMapping("/getBookcaseListByUserId")
    GetBookcaseListByUserIdResponse getBookcaseListByUserId(@ApiParam @Valid @RequestBody GetBookListByUserIdRequest request);


}
