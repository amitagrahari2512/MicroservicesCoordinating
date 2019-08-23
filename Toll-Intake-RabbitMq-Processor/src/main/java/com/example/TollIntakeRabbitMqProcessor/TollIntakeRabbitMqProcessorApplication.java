package com.example.TollIntakeRabbitMqProcessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(Processor.class)
@SpringBootApplication
public class TollIntakeRabbitMqProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollIntakeRabbitMqProcessorApplication.class, args);
	}
	
	//It is working , but we can Use @ServiceActivator also.
	//@StreamListener(Sink.INPUT)
	//@ServiceActivator(inputChannel = Sink.INPUT)
	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public String log(String msg) {
		System.out.println(msg);
		return msg;
	}


}
