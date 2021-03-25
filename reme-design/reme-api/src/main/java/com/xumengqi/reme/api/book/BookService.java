package com.xumengqi.reme.api.book;

import com.xumengqi.reme.api.book.request.GetBookCatalogListRequest;
import com.xumengqi.reme.api.book.request.GetBookListByBookCatalogRequest;
import com.xumengqi.reme.api.book.request.UploadBookRequest;
import com.xumengqi.reme.api.book.response.GetBookCatalogListResponse;
import com.xumengqi.reme.api.book.response.GetBookListByBookCatalogResponse;
import com.xumengqi.reme.api.book.response.UploadBookResponse;
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
@Api(tags = "BookService", description = "书籍服务")
@RequestMapping("/book")
@RestController
public interface BookService {
    /**
     * 发布书籍
     *
     * @param request /
     * @return /
     */
    @ApiOperation("发布书籍")
    @PostMapping("/uploadBook")
    UploadBookResponse uploadBook(@ApiParam @Valid @RequestBody UploadBookRequest request);


    /**
     * 获取书籍分类列表
     *
     * @param request /
     * @return /
     */
    @ApiOperation("获取书籍分类列表")
    @PostMapping("/getBookCatalogList")
    GetBookCatalogListResponse getBookCatalogList(@ApiParam @Valid @RequestBody GetBookCatalogListRequest request);

    /**
     * 根据书籍分类获取书籍列表
     *
     * @param request /
     * @return /
     */
    @ApiOperation("根据书籍分类获取书籍列表")
    @PostMapping("/getBookListByBookCatalog")
    GetBookListByBookCatalogResponse getBookListByBookCatalog(@ApiParam @Valid @RequestBody GetBookListByBookCatalogRequest request);
}
