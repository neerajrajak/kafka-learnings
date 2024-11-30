package com.producer.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producer.example.service.KafkaMessagePublisher;

@RestController
@RequestMapping("api/kafka/producer/")
public class ProducerController {

	@Autowired
	private KafkaMessagePublisher kafkaMessagePublisher;
	
	@GetMapping("send/{message}")
	public ResponseEntity<?> sendMessageFromKafka(@PathVariable String message){
		try {
			for(int i=1; i <= 10000; i++) {
				kafkaMessagePublisher.publishMessage(message+i);
			}
			return ResponseEntity.ok(message +" sent from publisher");
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
