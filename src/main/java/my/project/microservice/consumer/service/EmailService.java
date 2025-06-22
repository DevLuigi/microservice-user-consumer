package my.project.microservice.consumer.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import my.project.microservice.consumer.dto.UserDto;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {

    private final JavaMailSender emailSender;
    private final TemplateEngine templateEngine;

    public EmailService(JavaMailSender emailSender, TemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    public void sendEmail(UserDto user) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(user.getEmail());
            helper.setSubject("E-mail de boas-vindas ao meu primeiro microserviço!");

            Context context = new Context();
            context.setVariable("name", user.getName());

            String html = templateEngine.process("email-template.html", context);

            helper.setText(html, true);

            ClassPathResource image = new ClassPathResource("/static/images/wolf.png");
            helper.addInline("image", image);

            emailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Falha ao enviar e-mail", e);
        }
    }
}