package com.learn.DataFlowTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@EnableTask
@EnableConfigurationProperties(Task1Properties.class)
@SpringBootApplication
public class DataFlowTask1Application {

	public static void main(String[] args) {
		SpringApplication.run(DataFlowTask1Application.class, args);
	}
	
	@Bean
	public Task1 task1() {
		return new Task1();
	}
	
	public class Task1 implements CommandLineRunner {
		@Autowired
		private Task1Properties config;

		@Override
		public void run(String... args) throws Exception {
			System.out.println("source  : "+config.getSourceFilePath());
			System.out.println("destination  : "+config.getDestinationFilePath());
			System.out.println("controlMessage  : "+config.getControlMessage());
			
			if(config.getControlMessage().equalsIgnoreCase("fail")) {
				System.out.println("Throwing an exception");
				throw new Exception("I am angry!");
			}
			
			System.out.println("Task 1 complete");
		}
		
		
		
	}

}
