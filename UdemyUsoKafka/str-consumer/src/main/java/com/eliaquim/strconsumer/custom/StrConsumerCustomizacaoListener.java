package com.eliaquim.strconsumer.custom;

import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // falamos ao java que essa anotação vai ficar disponivel em tempo de execução
@Target(ElementType.METHOD) // significa que voce pode definir suas proprias anotações personalizadas pois estamos criando uma META ANOTAÇÂO
@KafkaListener
public @interface StrConsumerCustomizacaoListener {

    // AliasFor essa anotation  nos podemos usar para decorar atributos dentro de uma unica anotação
    @AliasFor(annotation = KafkaListener.class, attribute = "topics")
    String[] topics() default "str-topic"; // topics é um array, por isso declaramos ele como array com o padrao ja definido

    @AliasFor(annotation = KafkaListener.class, attribute = "containerFactory")
    String containerFactory() default "strContainerFactory";


    @AliasFor(annotation = KafkaListener.class, attribute = "groupId")
    String groupId() default "";

    @AliasFor(annotation = KafkaListener.class, attribute = "errorHandler")
    String errorHandler() default "errorCustomHandler"; //passamos o nome da nossa classe com letra minuscula.
    //esse error handler vem do kafkaListener estamos customizando ele

}
