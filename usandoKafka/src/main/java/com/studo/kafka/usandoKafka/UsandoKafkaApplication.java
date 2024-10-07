package com.studo.kafka.usandoKafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class UsandoKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsandoKafkaApplication.class, args);
	}

}
