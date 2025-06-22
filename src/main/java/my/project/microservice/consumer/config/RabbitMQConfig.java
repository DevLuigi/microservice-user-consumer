package my.project.microservice.consumer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${broker.queue.name}")
    private String queue;

    @Value("${broker.exchange.name}")
    private String exchange;

    @Value("${broker.routing.key}")
    private String routingKey;

    @Bean
    public Queue userCompletedQueue() {
        return new Queue(queue, true);
    }

    @Bean
    public DirectExchange userExchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Binding orderBinding() {
        return BindingBuilder
                .bind(userCompletedQueue())
                .to(userExchange())
                .with(routingKey);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }

}