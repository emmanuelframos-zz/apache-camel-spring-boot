package com.poc.config.rabbit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerQueueConfig extends RabbitConfig {

    @Value("${rabbitmq.consumerExchange.name}")
    private String exchange;

    @Value("${rabbitmq.consumerExchange.consumerQueue.name}")
    private String queue;

    @Value("${rabbitmq.consumerExchange.consumerQueue.routingKey}")
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