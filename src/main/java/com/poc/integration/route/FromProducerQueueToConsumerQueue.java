package com.poc.integration.route;

import com.poc.config.rabbit.common.RabbitConfig;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FromProducerQueueToConsumerQueue extends RouteBuilder {

    @Autowired
    @Qualifier(value="ProducerQueueConfig")
    private RabbitConfig rabbitProducerConfig;

    @Autowired
    @Qualifier(value="ConsumerQueueConfig")
    private RabbitConfig rabbitConsumerConfig;


    private static Logger logger = LoggerFactory.getLogger(FromJSONFileToProducerQueue.class);

    @Override
    public void configure() throws Exception {
        if (!rabbitProducerConfig.isActive()) {
            logger.warn(this.getClass().getSimpleName() + " is inactive.");
            return;
        }

        from("")

                .routeId("1-STEP_".concat(this.getClass().getSimpleName()))

                .routeDescription("This route converts from ")

                .split(body())

                .setHeader("CamelSplitIndex", simple("${header.CamelSplitIndex}"))

                .to("");
    }
}