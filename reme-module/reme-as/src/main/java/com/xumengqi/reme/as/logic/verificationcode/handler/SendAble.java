package com.xumengqi.reme.as.logic.verificationcode.handler;

/**
 * @author xumengqi
 * @date 2021/2/27 15:21
 */
public interface SendAble {
    /**
     * 发送内容
     * @param to 接收方
     * @param content 内容
     */
    void send(String to, String content);
}
