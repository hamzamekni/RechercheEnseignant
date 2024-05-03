package com.pfe.rechercheens.Auth.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.naming.Context;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmailRegistrationService {

    public  JavaMailSender mailSender;

    @Async
    public void send(
            String to,
            String username,
            String templateName,
            String confirmationUrl
    ) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(
                mimeMessage,
                MimeMessageHelper.MULTIPART_MODE_MIXED,
                StandardCharsets.UTF_8.name()
        );
        Map<String, Object> properties = new HashMap<>();
        properties.put("username", username);
        properties.put("confirmationUrl", confirmationUrl);

        helper.setFrom("dancescape@outlook.com");
        helper.setTo(to);
        helper.setSubject("Welcome to DanceScape Explorer");

        String template = "templateEngine.process(templateName, context);";

        helper.setText(template, true);

        mailSender.send(mimeMessage);
    }
}
