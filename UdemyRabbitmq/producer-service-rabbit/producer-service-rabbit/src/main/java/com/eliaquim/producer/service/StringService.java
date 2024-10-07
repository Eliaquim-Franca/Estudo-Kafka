package com.eliaquim.producer.service;

import static com.eliaquim.producer.configs.RabbitMQConfig.EXG_NAME_MARKETPLACE;
import static com.eliaquim.producer.configs.RabbitMQConfig.ROUTING_KEY_PRODUCT_LOG;

import org.rabbitmq.commons.dtos.ProductDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class StringService {
	
	private final RabbitTemplate rabbitTemplate;
	
	public void produce(String message) {
		var product = new ProductDTO();
		log.info("Received message" + message);
		rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, ROUTING_KEY_PRODUCT_LOG
				, message );
	}
}
