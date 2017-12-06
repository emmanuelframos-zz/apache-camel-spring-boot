package com.poc.config.rabbit.common;

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

    @Value("${rabbitmq.deliveryMode}")
    private String deliveryMode;

    @Value("${rabbitmq.autoDelete}")
    private Boolean autoDelete;

    public String build() {
        return build(false);
    }

    public String buildError() {
        return build(true);
    }

    private String build(boolean isError) {
        return "rabbitmq://" + this.host + ":" + this.port + "/" + this.getExchange()
                + "?username=" + this.username + "&password=" + this.password
                + "&exchangeType=" + this.getExchangeType()
                + "&routingKey=" + this.getRoutingKey()
                + "&queue=" + this.getQueue()
                + this.getOptions();
    }

    public abstract Boolean isActive();

    public abstract String getExchange();

    public abstract String getQueue();

    public abstract String getRoutingKey();

    public abstract String getOptions();

    public abstract String getExchangeType();

    public String getIndexHeaderName(){return "";}

    public String getXmlTagName(){return "";}

}