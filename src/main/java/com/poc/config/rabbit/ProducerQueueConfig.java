package com.poc.config.rabbit;

import com.poc.config.rabbit.common.RabbitConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerQueueConfig extends RabbitConfig {

    @Override
    public Boolean isActive() {
        return null;
    }

    @Override
    public String getExchange() {
        return null;
    }

    @Override
    public String getQueue() {
        return null;
    }

    @Override
    public String getRoutingKey() {
        return null;
    }

    @Override
    public String getOptions() {
        return null;
    }

    @Override
    public String getExchangeType() {
        return null;
    }
}
