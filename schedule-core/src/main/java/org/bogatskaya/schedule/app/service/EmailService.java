package org.bogatskaya.schedule.app.service;

import javax.mail.MessagingException;

public interface EmailService {

    void sendConfirmationMessage(String to, String subject, String token) throws MessagingException;
}
