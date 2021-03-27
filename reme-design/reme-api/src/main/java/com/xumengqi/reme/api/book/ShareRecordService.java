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
     * 共享者收到书籍 (逾期)
     *
     * @param request /
     * @return /
     */
    @ApiOperation("共享者收到书籍 (逾期)")
    @PostMapping("/overdueReturnBook")
    OverdueReturnBookResponse overdueReturnBook(@ApiParam @Valid @RequestBody OverdueReturnBookRequest request);


    /**
     * 借阅者取消订单
     *
     * @param request /
     * @return /
     */
    @ApiOperation("借阅者取消订单")
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

}
