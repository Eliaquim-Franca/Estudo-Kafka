package com.eliaquim.consumerservice.rabbitmq.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import lombok.extern.log4j.Log4j2;



@Log4j2
@Component
public class StringConsumer {
	
	@RabbitListener(queues = {"product.log"})
	public void consumer(String message) {
		var products = new org.rabbitmq.commons.dtos.ProductDTO();

		log.info("Consumer receveid a message" + message);
	}
	
}
