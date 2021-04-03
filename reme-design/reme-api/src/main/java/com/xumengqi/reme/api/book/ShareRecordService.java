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
 * 共享记录服务
 *
 * @author xumengqi
 */
@Api(tags = "ShareRecordService", description = "共享记录服务")
@RequestMapping("/shareRecord")
@RestController
public interface ShareRecordService {

    /**
     * 借阅者收到书籍
     *
     * @param request /
     * @return /
     */
    @ApiOperation("借阅者收到书籍")
    @PostMapping("/receiveBook")
    ReceiveBookResponse receiveBook(@ApiParam @Valid @RequestBody ReceiveBookRequest request);

    /**
     * 共享者收到书籍
     *
     * @param request /
     * @return /
     */
    @ApiOperation("共享者收到书籍")
    @PostMapping("/returnBook")
    ReturnBookResponse returnBook(@ApiParam @Valid @RequestBody ReturnBookRequest request);

    /**
     * 借阅者或共享者取消订单
     *
     * @param request /
     * @return /
     */
    @ApiOperation("借阅者或共享者取消订单")
    @PostMapping("/cancelBorrowBook")
    CancelBorrowBookResponse cancelBorrowBook(@ApiParam @Valid @RequestBody CancelBorrowBookRequest request);


    /**
     * 丢失书籍处理 (共享者或借阅者均可处理)
     *
     * @param request /
     * @return /
     */
    @ApiOperation("丢失书籍处理 (共享者或借阅者均可处理)")
    @PostMapping("/lostHandleBook")
    LostHandleBookResponse lostHandleBook(@ApiParam @Valid @RequestBody LostHandleBookRequest request);

    /**
     * 共享者严重逾期处理书籍
     *
     * @param request /
     * @return /
     */
    @ApiOperation("共享者严重逾期处理书籍")
    @PostMapping("/seriouslyOverdueHandleBook")
    SeriouslyOverdueHandleBookResponse seriouslyOverdueHandleBook(@ApiParam @Valid @RequestBody SeriouslyOverdueHandleBookRequest request);


    /**
     * 根据借阅者查询共享记录列表
     *
     * @param request /
     * @return /
     */
    @ApiOperation("根据借阅者查询共享记录列表")
    @PostMapping("/getShareRecordListByBorrowUserId")
    GetShareRecordListByBorrowUserIdResponse getShareRecordListByBorrowUserId(@ApiParam @Valid @RequestBody GetShareRecordListByBorrowUserIdRequest request);

    /**
     * 根据共享者查询共享记录列表
     *
     * @param request /
     * @return /
     */
    @ApiOperation("根据共享者查询共享记录列表")
    @PostMapping("/getShareRecordListByShareUserId")
    GetShareRecordListByShareUserIdResponse getShareRecordListByShareUserId(@ApiParam @Valid @RequestBody GetShareRecordListByShareUserIdRequest request);


    /**
     * 获取共享排行榜
     *
     * @param request /
     * @return /
     */
    @ApiOperation("获取共享排行榜")
    @PostMapping("/getShareRankList")
    GetShareRankListResponse getShareRankList(@ApiParam @Valid @RequestBody GetShareRankListRequest request);


    /**
     * 获取借阅排行榜
     *
     * @param request /
     * @return /
     */
    @ApiOperation("获取借阅排行榜")
    @PostMapping("/getBorrowRankList")
    GetBorrowRankListResponse getBorrowRankList(@ApiParam @Valid @RequestBody GetBorrowRankListRequest request);

    /**
     * 发送消息
     *
     * @param request /
     * @return /
     */
    @ApiOperation("发送消息")
    @PostMapping("/sendMessage")
    SendMessageResponse sendMessage(@ApiParam @Valid @RequestBody SendMessageRequest request);


    /**
     * 发送消息
     *
     * @param request /
     * @return /
     */
    @ApiOperation("获取消息列表")
    @PostMapping("/getMessageList")
    GetMessageListResponse getMessageList(@ApiParam @Valid @RequestBody GetMessageListRequest request);


    /**
     * 评分
     *
     * @param request /
     * @return /
     */
    @ApiOperation("评分")
    @PostMapping("/score")
    ScoreResponse score(@ApiParam @Valid @RequestBody ScoreRequest request);

    /**
     * 获取书籍评分
     *
     * @param request /
     * @return /
     */
    @ApiOperation("获取书籍评分")
    @PostMapping("/getScoreOfBook")
    GetScoreOfBookResponse getScoreOfBook(@ApiParam @Valid @RequestBody GetScoreOfBookRequest request);
}
