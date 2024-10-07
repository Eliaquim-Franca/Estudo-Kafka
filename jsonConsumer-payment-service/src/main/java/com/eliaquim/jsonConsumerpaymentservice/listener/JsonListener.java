package com.eliaquim.jsonConsumerpaymentservice.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.eliaquim.jsonConsumerpaymentservice.model.Payment;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class JsonListener {
	
	@SneakyThrows
	@KafkaListener(topics= "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
	public void antiFraud(@Payload Payment payment) {
		log.info("Recebi o pagamento", payment.toString());
		Thread.sleep(2000);
		
		log.info("Validando fraude ...");
		Thread.sleep(2000);
		
		log.info("Compra aprovada ...");
		Thread.sleep(3000);
	}

	@SneakyThrows
	@KafkaListener(topics= "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
	public void pdfGenerator() {
		log.info("Gerando pdf ...");
		Thread.sleep(2000);
		
	}
	
	@KafkaListener(topics= "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
	public void sendEmail() {
		log.info("Enviando email de confirmação");
		
	}
}
