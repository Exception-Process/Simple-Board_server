package com.example.feed.global.jms;

import com.example.feed.global.exception.MailSendException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@RequiredArgsConstructor
@Component
public class JmsUtil {

    private final JmsProperties jmsProperties;
    private final JavaMailSender javaMailSender;

    public void sendMail(String email, String authenticationCode) {

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, false, "UTF-8");

            messageHelper.setTo(email);
            messageHelper.setFrom(jmsProperties.getUsername());
            messageHelper.setSubject("[Simple Board 메일인증]");

            String text = "인증코드 : " + authenticationCode;
            messageHelper.setText(text);

            javaMailSender.send(message);
        } catch (Exception e) {
            throw MailSendException.EXCEPTION;
        }
    }
}
