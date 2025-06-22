package my.project.microservice.consumer.consumer;

import my.project.microservice.consumer.dto.UserDto;
import my.project.microservice.consumer.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class userCompletedConsumer {

    final EmailService emailService;

    public userCompletedConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${broker.queue.name}")
    public void listenerOrderCompletedQueue(UserDto user) {
        emailService.sendEmail(user);
    }

}