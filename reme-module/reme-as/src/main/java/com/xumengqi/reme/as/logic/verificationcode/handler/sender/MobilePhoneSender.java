package com.xumengqi.reme.as.logic.verificationcode.handler.sender;

import com.xumengqi.reme.as.logic.verificationcode.handler.SendAble;
import org.springframework.stereotype.Component;

/**
 * @author xumengqi
 * @date 2021/2/27 15:28
 */
@Component
public class MobilePhoneSender implements SendAble {

    @Override
    public void send(String to, String content) {
        System.out.println(to + " -: 您的验证码是" + content);
    }

}
