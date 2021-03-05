package com.book.www.utils;

import com.book.www.entity.User;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtils {
    private static final String FROM = "xxx@163.com";

    public static void sendMail(String to, String code) throws MessagingException {
        Session session = Session.getInstance(new Properties(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("smtp.qq.com", "111");
            }
        });

        //创建邮件对象
        Message message = new MimeMessage(session);
        //设置发件人，这里我创建了一个server@store.com用于发送邮件
        message.setFrom(new InternetAddress("smtp.qq.com"));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
        message.setSubject("来自个博网的注册激活邮件");
        message.setContent("<a href='http://localhost:8080/online_bookstore/active.do'>点我激活</a>","text/html;charset=utf-8");

        //发送邮件
        Transport.send(message);
    }
}
