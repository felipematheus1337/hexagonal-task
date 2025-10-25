package com.hexagonal.tasks.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FILA = "fila.inserir";
    public static final String EXCHANGE = "exchange.inserir";
    public static final String ROUTING_KEY = "route.task";

    @Bean
    public Queue filaInserir() {
        return QueueBuilder
                .durable(FILA)
                .build();
    }

    @Bean
    public TopicExchange exchangeExemplo() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding bindingExemplo(Queue filaExemplo, TopicExchange exchangeExemplo) {
        return BindingBuilder.bind(filaExemplo)
                .to(exchangeExemplo)
                .with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }



}
