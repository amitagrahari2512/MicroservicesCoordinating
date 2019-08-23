package com.example.TollIntakeRabbitMqHeader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
@SpringBootApplication
public class TollIntakeRabbitMqHeaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollIntakeRabbitMqHeaderApplication.class, args);
	}

	@StreamListener(target = Sink.INPUT , condition = "headers['speed'] > 40")
	public void logFast(String msg) {
		System.out.println("fast : " + msg);
	}
	
	@StreamListener(target = Sink.INPUT , condition = "headers['speed'] <= 40")
	public void logSlow(String msg) {
		System.out.println("slow : " + msg);
	}
}
