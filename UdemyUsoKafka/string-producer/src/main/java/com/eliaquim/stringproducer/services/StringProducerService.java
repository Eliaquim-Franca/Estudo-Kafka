package com.eliaquim.stringproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {


    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        kafkaTemplate.send("str-topic", message).addCallback(
                success -> {
                    if(success != null ){
                        log.info("SucessoOOOOOOOOOOOOO, the message sended was: {}", message);
                        log.info("Partition: {}, Offset: {}", success.getRecordMetadata().partition(), success.getRecordMetadata().offset());
                    }},
                erro -> log.error("Errouuuu, got it bad sending message")
        );
    }


}
