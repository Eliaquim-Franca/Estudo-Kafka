package com.eliaquim.consumertest.service;


import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StringConsumer {

    @RabbitListener(queues = {"product.log"})
    public void consume(String message){
        var product = new org.rabbitmq.commons.dtos.ProductDTO();

        log.info("Received" + product);

    }

}
