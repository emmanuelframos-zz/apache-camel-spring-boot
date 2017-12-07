package com.poc.config.rabbit;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public abstract class RabbitConfig {

    @Value("${rabbitmq.host}")
    private String host;

    @Value("${rabbitmq.port}")
    private Integer port;

    @Value("${rabbitmq.username}")
    private String username;

    @Value("${rabbitmq.password}")
    private String password;

    public String build() {
        return "rabbitmq://" + this.host + ":" + this.port + "/" + this.getExchange()
                + "?username=" + this.username + "&password=" + this.password
                + "&exchangeType=direct"
                + "&routingKey=" + this.getRoutingKey()
                + "&queue=" + this.getQueue()
                + "&autoDelete=false";
    }

    public abstract String getExchange();

    public abstract String getQueue();

    public abstract String getRoutingKey();

}