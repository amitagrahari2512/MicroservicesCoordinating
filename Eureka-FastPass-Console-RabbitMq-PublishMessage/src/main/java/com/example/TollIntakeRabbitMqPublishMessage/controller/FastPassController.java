package com.example.TollIntakeRabbitMqPublishMessage.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TollIntakeRabbitMqPublishMessage.publisher.TollSource;

@RestController
public class FastPassController {
	
	@Autowired
	TollSource mySource;
	
	@PostMapping(path = "/toll")
	public String publishMessage(@RequestBody String payload) {
		System.out.println(payload);
		Random r = new Random();
		mySource.fastpassToll().send(MessageBuilder.withPayload(payload).setHeader("speed", r.nextInt(8) * 10).build());
		return "Success";
	}
	
}
