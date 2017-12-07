package com.poc.config.rabbit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerQueueConfig extends RabbitConfig {

    @Value("${rabbitmq.producerExchange.name}")
    private String exchange;

    @Value("${rabbitmq.producerExchange.producerQueue.name}")
    private String queue;

    @Value("${rabbitmq.producerExchange.producerQueue.routingKey}")
    private String routingKey;

    @Override
    public String getExchange() {
        return exchange;
    }

    @Override
    public String getQueue() {
        return queue;
    }

    @Override
    public String getRoutingKey() {
        return routingKey;
    }
}