package com.producer.example.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessagePublisher {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public void publishMessage(String message) {
		CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("springConfigProducerTopic", message);
		future.whenComplete((res, ex)->{
			if(ex == null) {
				System.out.println("Message: "+message+" with offset: "+res.getRecordMetadata().offset());
			} else {
				System.out.println("Unable to send: "+ message +" due to: "+ex.getMessage());
			}
		});
	}
	
}
