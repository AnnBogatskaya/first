package org.bogatskaya.schedule.app.service.impl;

import org.bogatskaya.schedule.app.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendConfirmationMessage(String to, String subject, String token) throws MessagingException{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        helper.setTo(to);
        helper.setSubject(subject);

        StringBuilder builder = new StringBuilder();
        builder.append("To complete your registration please follow this link: ")
                .append("<a href='")
                .append("http://localhost:8080/confirmation?token=")
                .append(token)
                .append("'")
                .append(">Confirm Email!</a>");


        helper.setText(builder.toString(), true);
        helper.setFrom("barleysugar96@gmail.com");
        mailSender.send(mimeMessage);
    }
}
