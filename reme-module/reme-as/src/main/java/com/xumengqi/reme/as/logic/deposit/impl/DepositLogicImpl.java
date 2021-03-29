package com.xumengqi.reme.as.logic.deposit.impl;

import com.xumengqi.reme.as.logic.deposit.DepositLogic;
import com.xumengqi.reme.as.mapper.DepositExtMapper;
import com.xumengqi.reme.as.vo.DepositVO;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.base.util.UUIDUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.common.enums.biz.DepositOperateTypeEnum;
import com.xumengqi.reme.dao.entity.Deposit;
import com.xumengqi.reme.dao.entity.ShareRecord;
import com.xumengqi.reme.dao.entity.ShareRecordExample;
import com.xumengqi.reme.dao.entity.User;
import com.xumengqi.reme.dao.mapper.DepositMapper;
import com.xumengqi.reme.dao.mapper.ShareRecordMapper;
import com.xumengqi.reme.dao.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/26 21:03
 */
@Component
public class DepositLogicImpl implements DepositLogic {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DepositMapper depositMapper;

    @Autowired
    private ShareRecordMapper shareRecordMapper;

    @Autowired
    private DepositExtMapper depositExtMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void payDeposit(Long userId, Long depositAmount, String outerOrderNo) {
        outerHandle(userId, depositAmount, outerOrderNo, DepositOperateTypeEnum.PAY);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void drawDeposit(Long userId, Long depositAmount, String outerOrderNo) {
        outerHandle(userId, depositAmount, outerOrderNo, DepositOperateTypeEnum.DRAW);
    }

    private void outerHandle(Long userId, Long depositAmount, String outerOrderNo, DepositOperateTypeEnum depositOperateTypeEnum) {
        // 判断类型是否正确
        if (!(DepositOperateTypeEnum.PAY.equals(depositOperateTypeEnum) || DepositOperateTypeEnum.DRAW.equals(depositOperateTypeEnum))) {
            throw new IllegalArgumentException("押金类型错误");
        }
        // 判断用户是否存在
        User user = userMapper.selectByPrimaryKey(userId);
        AssertUtils.asserter().assertNotNull(user).elseThrow(ErrorCodeEnum.USER_NOT_EXIST);
        // 判断金额是否大于 0
        if (depositAmount == null || depositAmount <= 0) {
            throw new IllegalArgumentException("金额小于等于 0");
        }
        // 判断外部订单号是否存在
        if (StringUtils.isBlank(outerOrderNo)) {
            throw new IllegalArgumentException("外部订单号不存在");
        }
        // 插入押金流水,并更新用户押金状态
        Deposit deposit = new Deposit();
        deposit.setDepositOrderNo(UUIDUtils.getOrderNo());
        deposit.setDepositAmount(depositAmount);
        deposit.setDepositOperateType(depositOperateTypeEnum.getCode());
        deposit.setUserId(userId);
        deposit.setOuterOrderNo(outerOrderNo);
        deposit.setGmtCreate(new Date());
        depositMapper.insertSelective(deposit);
        if (DepositOperateTypeEnum.PAY.equals(depositOperateTypeEnum)) {
            // 缴纳押金
            user.setCanUseDeposit(user.getCanUseDeposit() + depositAmount);
        } else if (DepositOperateTypeEnum.DRAW.equals(depositOperateTypeEnum)) {
            // 提取押金
            long balance = user.getCanUseDeposit() - depositAmount;
            AssertUtils.asserter().assertGreaterThanOrEqualZero(balance).elseThrow(ErrorCodeEnum.CAN_USE_DEPOSIT_NOT_ENOUGH);
            user.setCanUseDeposit(balance);
        }
        userMapper.updateByPrimaryKeySelective(user);
    }

    private void innerHandle(Long depositAmount, String innerOrderNo, DepositOperateTypeEnum depositOperateTypeEnum) {
        // 判断类型是否正确
        if (!(DepositOperateTypeEnum.OCCUPY.equals(depositOperateTypeEnum)
                || DepositOperateTypeEnum.RELEASE.equals(depositOperateTypeEnum)
                || DepositOperateTypeEnum.PAY_LOSS.equals(depositOperateTypeEnum)
                || DepositOperateTypeEnum.COMPENSATION.equals(depositOperateTypeEnum))) {
            throw new IllegalArgumentException("押金类型错误");
        }
        // 判断共享记录订单是否存在
        ShareRecordExample shareRecordExample = new ShareRecordExample();
        shareRecordExample.createCriteria().andOrderNoEqualTo(innerOrderNo);
        ShareRecord shareRecord = shareRecordMapper.selectByExample(shareRecordExample).stream().findFirst().orElse(null);
        AssertUtils.asserter().assertNotNull(shareRecord).elseThrow(ErrorCodeEnum.SHARE_RECORD_NOT_EXIST);
        // 判断金额是否大于 0
        if (depositAmount == null || depositAmount <= 0) {
            throw new IllegalArgumentException("金额小于等于 0");
        }
        // 插入押金流水,并更新用户押金状态
        Deposit deposit = new Deposit();
        deposit.setDepositOrderNo(UUIDUtils.getOrderNo());
        deposit.setDepositAmount(depositAmount);
        deposit.setDepositOperateType(depositOperateTypeEnum.getCode());
        deposit.setUserId(DepositOperateTypeEnum.COMPENSATION.equals(depositOperateTypeEnum) ? shareRecord.getShareUserId() : shareRecord.getBorrowUserId());
        deposit.setInnerOrderNo(innerOrderNo);
        deposit.setGmtCreate(new Date());
        depositMapper.insertSelective(deposit);
        // 获取用户
        User user = userMapper.selectByPrimaryKey(deposit.getUserId());
        if (DepositOperateTypeEnum.OCCUPY.equals(depositOperateTypeEnum)) {
            long balance = user.getCanUseDeposit() - depositAmount;
            AssertUtils.asserter().assertGreaterThanOrEqualZero(balance).elseThrow(ErrorCodeEnum.CAN_USE_DEPOSIT_NOT_ENOUGH);
            user.setCanUseDeposit(balance);
            user.setOccupyDeposit(user.getOccupyDeposit() + depositAmount);
        } else if (DepositOperateTypeEnum.RELEASE.equals(depositOperateTypeEnum)) {
            long balance = user.getOccupyDeposit() - depositAmount;
            AssertUtils.asserter().assertTrue(balance >= 0).elseThrow(ErrorCodeEnum.OCCUPY_DEPOSIT_NOT_ENOUGH);
            user.setCanUseDeposit(user.getCanUseDeposit() + depositAmount);
            user.setOccupyDeposit(balance);
        } else if (DepositOperateTypeEnum.PAY_LOSS.equals(depositOperateTypeEnum)) {
            long balance = user.getOccupyDeposit() - depositAmount;
            AssertUtils.asserter().assertTrue(balance >= 0).elseThrow(ErrorCodeEnum.OCCUPY_DEPOSIT_NOT_ENOUGH);
            user.setOccupyDeposit(balance);
            user.setLossDeposit(user.getLossDeposit() + depositAmount);
        } else if (DepositOperateTypeEnum.COMPENSATION.equals(depositOperateTypeEnum)) {
            user.setMakeUpDeposit(depositAmount);
        }
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void payLossDeposit(Long depositAmount, String innerOrderNo) {
        innerHandle(depositAmount, innerOrderNo, DepositOperateTypeEnum.PAY_LOSS);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void compensation(Long depositAmount, String innerOrderNo) {
        innerHandle(depositAmount, innerOrderNo, DepositOperateTypeEnum.COMPENSATION);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void occupyDeposit(Long depositAmount, String innerOrderNo) {
        innerHandle(depositAmount, innerOrderNo, DepositOperateTypeEnum.OCCUPY);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void releaseDeposit(Long depositAmount, String innerOrderNo) {
        innerHandle(depositAmount, innerOrderNo, DepositOperateTypeEnum.RELEASE);
    }

    @Override
    public List<DepositVO> getDepositListByUserId(Long userId) {
        return depositExtMapper.selectByUserId(userId);
    }
}
