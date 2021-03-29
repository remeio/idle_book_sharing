package com.xumengqi.reme.api.deposit;

import com.xumengqi.reme.api.deposit.request.DrawDepositRequest;
import com.xumengqi.reme.api.deposit.request.GetDepositListByUserIdRequest;
import com.xumengqi.reme.api.deposit.request.PayDepositRequest;
import com.xumengqi.reme.api.deposit.response.DrawDepositResponse;
import com.xumengqi.reme.api.deposit.response.GetDepositListByUserIdResponse;
import com.xumengqi.reme.api.deposit.response.PayDepositResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 押金服务
 *
 * @author xumengqi
 */
@Api(tags = "DepositService", description = "押金服务")
@RequestMapping("/deposit")
@RestController
public interface DepositService {

    /**
     * 缴纳押金
     *
     * @param request /
     * @return /
     */
    @ApiOperation("缴纳押金")
    @PostMapping("/payDeposit")
    PayDepositResponse payDeposit(@ApiParam @Valid @RequestBody PayDepositRequest request);

    /**
     * 提取押金
     *
     * @param request /
     * @return /
     */
    @ApiOperation("提取押金")
    @PostMapping("/drawDeposit")
    DrawDepositResponse drawDeposit(@ApiParam @Valid @RequestBody DrawDepositRequest request);

    /**
     * 根据用户ID获取押金列表
     *
     * @param request /
     * @return /
     */
    @ApiOperation("根据用户ID获取押金列表")
    @PostMapping("/getDepositListByUserId")
    GetDepositListByUserIdResponse getDepositListByUserId(@ApiParam @Valid @RequestBody GetDepositListByUserIdRequest request);
}
