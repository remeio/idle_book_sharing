package com.xumengqi.reme.as.logic.deposit;

import com.xumengqi.reme.as.vo.DepositVO;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/26 21:02
 */
public interface DepositLogic {

    /**
     * 缴纳押金
     *
     * @param userId        /
     * @param depositAmount /
     * @param outerOrderNo  /
     */
    void payDeposit(Long userId, Long depositAmount, String outerOrderNo);

    /**
     * 提取
     *
     * @param userId        /
     * @param depositAmount /
     * @param outerOrderNo  /
     */
    void drawDeposit(Long userId, Long depositAmount, String outerOrderNo);

    /**
     * 支付损失
     *
     * @param depositAmount /
     * @param innerOrderNo  /
     */
    void payLossDeposit(Long depositAmount, String innerOrderNo);

    /**
     * 所得补偿
     *
     * @param depositAmount /
     * @param innerOrderNo  /
     */
    void compensation(Long depositAmount, String innerOrderNo);

    /**
     * 占用押金
     *
     * @param depositAmount /
     * @param innerOrderNo  /
     */
    void occupyDeposit(Long depositAmount, String innerOrderNo);


    /**
     * 释放押金
     *
     * @param depositAmount /
     * @param innerOrderNo  /
     */
    void releaseDeposit(Long depositAmount, String innerOrderNo);


    /**
     * 根据用户ID获取押金记录（ID倒序）
     *
     * @param userId /
     * @return /
     */
    List<DepositVO> getDepositListByUserId(Long userId);

}
