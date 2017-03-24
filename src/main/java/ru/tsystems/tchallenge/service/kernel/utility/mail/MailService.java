package ru.tsystems.tchallenge.service.kernel.utility.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private MailSender mailSender;

    public void send(MailProperties properties) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(properties.getContent());
        message.setTo(properties.getTarget());
        message.setSubject(properties.getSubject());
        message.setFrom("info@t-challenge.ru");
        try {
            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
