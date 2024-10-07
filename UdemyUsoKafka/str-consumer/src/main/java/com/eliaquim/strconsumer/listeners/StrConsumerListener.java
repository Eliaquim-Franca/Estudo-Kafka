package com.eliaquim.strconsumer.listeners;

import com.eliaquim.strconsumer.custom.StrConsumerCustomizacaoListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;
@Log4j2
@Component
public class StrConsumerListener {


    @SneakyThrows
   @StrConsumerCustomizacaoListener(groupId = "group-1")
    public void create(String message){
        log.info("CREATE ::: Receive message {} ", message);
        throw  new IllegalArgumentException("Exception");

    }

    @KafkaListener(groupId = "group-1",
             topicPartitions = {
                @TopicPartition(topic = "str-topic" , partitions = {"1"})
             }
            , containerFactory = "strContainerFactory")
    public void log(String message){
        log.info("LOG ::: Receive message {} ", message);
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic" , containerFactory = "strContainerFactory")
    public void history(String message){
        log.info("History ::: Receive message {} ", message);
    }

    @KafkaListener(groupId = "group-3", topics = "str-topic" , containerFactory = "validaMessageContainerFactory")
    public void justExample(String message){
        log.info("EXAMPLE ::: Receive message {} ", message);
    }




}
