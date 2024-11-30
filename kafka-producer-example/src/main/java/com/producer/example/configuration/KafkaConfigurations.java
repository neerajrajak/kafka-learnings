package com.producer.example.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfigurations {

	@Bean
	public NewTopic createTopic() {
		return new NewTopic("springMultiConfigProducerTopic", 5, (short) 1);
	}
}
