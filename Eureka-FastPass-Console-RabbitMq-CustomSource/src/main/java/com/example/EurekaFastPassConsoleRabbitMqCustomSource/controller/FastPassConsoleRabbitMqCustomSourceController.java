package com.example.EurekaFastPassConsoleRabbitMqCustomSource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.EurekaFastPassConsoleRabbitMqCustomSource.pojo.FastPassCustomer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
public class FastPassConsoleRabbitMqCustomSourceController {
	
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFastPassCustomerDetailsBackup")
	@RequestMapping(path = "/customerDetails" , params = {"fastPassId"})
	public String getFastPassCustomerDetails(@RequestParam String fastPassId , Model m) {
		FastPassCustomer customer = restTemplate.getForObject("http://Eureka-FastPass-Service/fastPass?fastPassId="+fastPassId, FastPassCustomer.class);
		System.out.println("Retrived Customer Details");
		m.addAttribute("customer" , customer);
		return "console";
	}
	
	public String getFastPassCustomerDetailsBackup(@RequestParam String fastPassId , Model m) {
		System.out.println("Fast Pass Fall Back operation Called");
		FastPassCustomer customer = new FastPassCustomer();
		customer.setFastPassId(fastPassId);
		
		m.addAttribute("customer" , customer);
		return "console";
	}
	
}
