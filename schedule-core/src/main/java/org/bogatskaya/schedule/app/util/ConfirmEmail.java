package org.bogatskaya.schedule.app.util;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class ConfirmEmail {

    private static Properties mailServerProperties;
    private static Session getMailSession;
    private static MimeMessage generateMailMessage;

    public static void sendLetter (String to,String sub,String msg) throws AddressException, MessagingException {
        JavaMailSenderImpl mailSender  = new JavaMailSenderImpl();

        mailSender.setHost("smtp.gmail.com");

        MimeMessage message =mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("barleysugar96@gmail.com");
        helper.setTo(to);
        helper.setSubject(sub);
        helper.setText(msg);
        mailSender.send(message);

//        mailServerProperties = System.getProperties();
//        mailServerProperties.put("mail.smtp.port", "587");
//        mailServerProperties.put("mail.smtp.auth", "true");
//        mailServerProperties.put("mail.smtp.starttls.enable", "true");
//        //get Session
//        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
//        generateMailMessage = new MimeMessage(getMailSession);
//        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
////        generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("shadowmulligan@gmail.com"));
//        generateMailMessage.setSubject(sub);
//        generateMailMessage.setContent(msg, "text/html");
//        //compose message
//        Transport transport = getMailSession.getTransport("smtp");
//
//        // Enter your correct gmail UserID and Password
//        // if you have 2FA enabled then provide App Specific Password
//        transport.connect("smtp.gmail.com", "barleysugar96@gmail.com", "barleysugar96hollyevill");
//        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
//        transport.close();

    }
}

