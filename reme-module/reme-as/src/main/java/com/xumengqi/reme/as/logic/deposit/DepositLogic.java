package com.xumengqi.reme.as.logic.deposit;

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

}
