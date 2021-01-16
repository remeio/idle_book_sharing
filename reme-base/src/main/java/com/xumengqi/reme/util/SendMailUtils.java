package com.xumengqi.reme.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送工具类
 * @author xumengqi
 * @date 2021/1/4 15:14
 */
@Component
public class SendMailUtils {
    private JavaMailSenderImpl sender;

    @Autowired
    public void setSender(JavaMailSenderImpl sender) {
        this.sender = sender;
    }

    public void sendSimpleMail(String to, String subject, String content) {
        sendSimpleMail(sender.getUsername(), to, subject, content);
    }

    public void sendSimpleMail(String from, String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        sender.send(message);
    }

    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        sendHtmlMail(sender.getUsername(), to, subject, content);
    }

    public void sendHtmlMail(String from, String to, String subject, String content) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        message.setSubject(subject);
        helper.setText(content, true);
        sender.send(message);
    }

}
