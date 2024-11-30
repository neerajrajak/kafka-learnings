package com.consumer.example.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	@KafkaListener(topics="springMultiConfigProducerTopic", groupId = "demo-multi-consumer-grp")
	public void consumeMessage(String message) {
		System.out.println("Consumer 1 consume message: "+message);
	}
	
	@KafkaListener(topics="springMultiConfigProducerTopic", groupId = "demo-multi-consumer-grp")
	public void consumeMessage2(String message) {
		System.out.println("Consumer 2 consume message: "+message);
	}
	
	@KafkaListener(topics="springMultiConfigProducerTopic", groupId = "demo-multi-consumer-grp")
	public void consumeMessage3(String message) {
		System.out.println("Consumer 3 consume message: "+message);
	}
	
	@KafkaListener(topics="springMultiConfigProducerTopic", groupId = "demo-multi-consumer-grp")
	public void consumeMessage4(String message) {
		System.out.println("Consumer 4 consume message: "+message);
	}
	
	@KafkaListener(topics="springMultiConfigProducerTopic", groupId = "demo-multi-consumer-grp")
	public void consumeMessage5(String message) {
		System.out.println("Consumer 5 consume message: "+message);
	}
	
	@KafkaListener(topics="springMultiConfigProducerTopic", groupId = "demo-multi-consumer-grp")
	public void consumeMessage6(String message) {
		System.out.println("Consumer 6 consume message: "+message);
	}
}
