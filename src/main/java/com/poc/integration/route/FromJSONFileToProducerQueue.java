package com.poc.integration.route;

import com.poc.config.rabbit.RabbitConfig;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FromJSONFileToProducerQueue extends RouteBuilder {

    @Autowired
    @Qualifier(value="producerQueueConfig")
    private RabbitConfig rabbitProducerConfig;

    @Value("${rabbitmq.producerExchange.producerPath}")
    private String producerPath;

    @Override
    public void configure() throws Exception {

        from("file:".concat(producerPath))

            .routeId("1-STEP_".concat(this.getClass().getSimpleName()))

            .routeDescription("This route reads a file and send to producer queue.")

            .convertBodyTo(String.class)

            .setHeader("rabbitmq.DELIVERY_MODE", simple("2"))

            .log("Sending ${body} to producer queue.")

            .to(rabbitProducerConfig.build());
    }
}