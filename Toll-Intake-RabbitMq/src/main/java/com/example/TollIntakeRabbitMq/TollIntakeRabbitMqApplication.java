package com.example.TollIntakeRabbitMq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;

@EnableBinding(Sink.class)
@SpringBootApplication
public class TollIntakeRabbitMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollIntakeRabbitMqApplication.class, args);
	}
	
	//It is working , but we can Use @ServiceActivator also.
	//@StreamListener(Sink.INPUT)
	@ServiceActivator(inputChannel = Sink.INPUT)
	public void log(String msg) {
		System.out.println(msg);
	}

}
