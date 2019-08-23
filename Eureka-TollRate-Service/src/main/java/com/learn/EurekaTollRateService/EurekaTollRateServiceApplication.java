package com.learn.EurekaTollRateService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaTollRateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaTollRateServiceApplication.class, args);
	}

}
