package kafkaComJavaRaiz.consumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;


public class Consumer {
	public static void main(String[] args) {
		var consumer = new KafkaConsumer<String, String>(properties());
		
		consumer.subscribe(Collections.singletonList("compras.do.cliente"));
		
		while(true) {
			
			var records = consumer.poll(Duration.ofMillis(100));
			
			for(var rec : records) {
				System.out.println("Compra nova: ");
				System.out.println(rec.key());
				System.out.println(rec.value());
				System.out.println(rec.offset());
				System.out.println(rec.partition());
			}
		}
	}
	
	private static Properties properties() {

		Properties properties = new Properties();

		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "consumo-cliente-teste-que-queremos");
		
		return properties;
	}
}
