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


    /**
     * 根据用户ID获取书籍列表
     *
     * @param request /
     * @return /
     */
    @ApiOperation("根据用户ID获取书籍列表")
    @PostMapping("getBookListByUserId")
    GetBookListByUserIdResponse getBookListByUserId(@ApiParam @Valid @RequestBody GetBookListByUserIdRequest request);


    /**
     * 获取书籍信息
     *
     * @param request /
     * @return /
     */
    @ApiOperation("获取书籍信息")
    @PostMapping("/getBookInfo")
    GetBookInfoResponse getBookInfo(@ApiParam @Valid @RequestBody GetBookInfoRequest request);

    /**
     * 借阅书籍
     *
     * @param request /
     * @return /
     */
    @ApiOperation("借阅书籍")
    @PostMapping("/borrowBook")
    BorrowBookResponse borrowBook(@ApiParam @Valid @RequestBody BorrowBookRequest request);

    /**
     * 下架书籍
     *
     * @param request /
     * @return /
     */
    @ApiOperation("下架书籍")
    @PostMapping("/offShelfBook")
    OffShelfBookResponse offShelfBook(@ApiParam @Valid @RequestBody OffShelfBookRequest request);

    /**
     * 上架书籍
     *
     * @param request /
     * @return /
     */
    @ApiOperation("上架书籍")
    @PostMapping("/onShelfBook")
    OnShelfBookResponse onShelfBook(@ApiParam @Valid @RequestBody OnShelfBookRequest request);

    /**
     * 删除书籍
     *
     * @param request /
     * @return /
     */
    @ApiOperation("删除书籍")
    @PostMapping("/deleteBook")
    DeleteBookResponse deleteBook(@ApiParam @Valid @RequestBody DeleteBookRequest request);


    /**
     * 获取推荐书籍列表
     *
     * @param request /
     * @return /
     */
    @ApiOperation("获取推荐书籍列表")
    @PostMapping("/getRecommendBookList")
    GetRecommendBookListResponse getRecommendBookList(@ApiParam @Valid @RequestBody GetRecommendBookListRequest request);


    /**
     * 获取今日上新
     *
     * @param request /
     * @return /
     */
    @ApiOperation("获取今日上新")
    @PostMapping("/getTodayBookList")
    GetTodayBookListResponse getTodayBookList(@ApiParam @Valid @RequestBody GetTodayBookListRequest request);
}
