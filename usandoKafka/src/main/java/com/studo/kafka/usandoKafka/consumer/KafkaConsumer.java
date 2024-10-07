package com.studo.kafka.usandoKafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
	
	
	@KafkaListener(topics = "banco-milionario", groupId = "banco-milionario")
	public void consumer(String message) {
		System.out.println("voce recebeu a mensagem:" + message);
	}
}
