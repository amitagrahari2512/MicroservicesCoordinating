package com.learn.EurekaTollRateBillBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.learn.EurekaTollRateService.pojo.TollRate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
public class DashBoardController {
	
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder)
	{
		return builder.build();
	}
	
	@Autowired
	public RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getTollRateBackup")
	@RequestMapping(path = "/dashboard")
	public String getTollRate(@RequestParam int stationId , Model m) {
		TollRate tollRate = restTemplate.getForObject("http://Eureka-TollRate-Service/tollRate/"+stationId, TollRate.class);
		System.out.println("stationId : "+stationId);
		m.addAttribute("rate",tollRate.getCurrentRate());
		return "dashboard";
	}
	
	public String getTollRateBackup(@RequestParam int stationId , Model m) {
		System.out.println("Toll Fall Back operation Called");
		
		m.addAttribute("rate","1.00");
		return "dashboard";
	}
}
