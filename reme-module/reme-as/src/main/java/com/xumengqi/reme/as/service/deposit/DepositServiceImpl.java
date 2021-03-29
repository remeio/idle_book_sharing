package com.xumengqi.reme.as.service.deposit;

import com.xumengqi.reme.api.deposit.DepositService;
import com.xumengqi.reme.api.deposit.dto.DepositDTO;
import com.xumengqi.reme.api.deposit.request.DrawDepositRequest;
import com.xumengqi.reme.api.deposit.request.GetDepositListByUserIdRequest;
import com.xumengqi.reme.api.deposit.request.PayDepositRequest;
import com.xumengqi.reme.api.deposit.response.DrawDepositResponse;
import com.xumengqi.reme.api.deposit.response.GetDepositListByUserIdResponse;
import com.xumengqi.reme.api.deposit.response.PayDepositResponse;
import com.xumengqi.reme.as.logic.deposit.DepositLogic;
import com.xumengqi.reme.base.annotations.AccessToken;
import com.xumengqi.reme.base.annotations.SystemLog;
import com.xumengqi.reme.base.util.ConvertUtils;
import com.xumengqi.reme.dao.entity.Deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/27 12:58
 */
@SystemLog
@Component
public class DepositServiceImpl implements DepositService {
    @Autowired
    private DepositLogic depositLogic;

    @AccessToken
    @Override
    public PayDepositResponse payDeposit(PayDepositRequest request) {
        final Long userId = request.getOperatorId();
        final Long depositAmount = request.getDepositAmount();
        final String outerOrderNo = request.getOuterOrderNo();
        depositLogic.payDeposit(userId, depositAmount, outerOrderNo);
        return new PayDepositResponse();
    }

    @AccessToken
    @Override
    public DrawDepositResponse drawDeposit(DrawDepositRequest request) {
        final Long userId = request.getOperatorId();
        final Long depositAmount = request.getDepositAmount();
        final String outerOrderNo = request.getOuterOrderNo();
        depositLogic.drawDeposit(userId, depositAmount, outerOrderNo);
        return new DrawDepositResponse();
    }

    @AccessToken
    @Override
    public GetDepositListByUserIdResponse getDepositListByUserId(@Valid GetDepositListByUserIdRequest request) {
        List<Deposit> deposits = depositLogic.getDepositListByUserId(request.getOperatorId());
        GetDepositListByUserIdResponse response = new GetDepositListByUserIdResponse();
        response.setDepositDTOList(ConvertUtils.toList(deposits, DepositDTO.class));
        return response;
    }
}
