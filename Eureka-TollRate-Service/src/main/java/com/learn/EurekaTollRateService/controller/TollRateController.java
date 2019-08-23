package com.learn.EurekaTollRateService.controller;

import java.math.BigDecimal;
import java.time.Instant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learn.EurekaTollRateService.pojo.TollRate;

@RestController
public class TollRateController {
	
	
	@GetMapping(path = "/tollRate/{stationId}")
	public TollRate getTollRate(@PathVariable int stationId) {
		
		TollRate tollRate;
		
		System.out.println("Station Id Called :"+stationId);
		switch(stationId) {
		case 1:
			tollRate = new TollRate(stationId , new BigDecimal("0.55") , Instant.now().toString());
			break;
		case 2:
			tollRate = new TollRate(stationId , new BigDecimal("1.05") , Instant.now().toString());
			break;
		case 3:
			tollRate = new TollRate(stationId , new BigDecimal("0.60") , Instant.now().toString());
			break;
		default:
			tollRate = new TollRate(stationId , new BigDecimal("1.00") , Instant.now().toString());
		}
		
		return tollRate;
	}
}
