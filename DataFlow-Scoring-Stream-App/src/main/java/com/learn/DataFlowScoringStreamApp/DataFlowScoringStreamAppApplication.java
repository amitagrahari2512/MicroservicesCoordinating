package com.learn.DataFlowScoringStreamApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

import com.learn.DataFlowScoringStreamApp.pojo.TollReading;
import com.learn.DataFlowScoringStreamApp.pojo.TollReadingProperties;

@EnableConfigurationProperties(TollReadingProperties.class)
@EnableBinding(Processor.class)
@SpringBootApplication
public class DataFlowScoringStreamAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataFlowScoringStreamAppApplication.class, args);
	}
	
	@Autowired
	private TollReadingProperties properties;
	
	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public TollReading assignScore(TollReading r) {
		
		System.out.println("Station Id: "+r.getStationId());
		
		int fraudThreshould = properties.getFraudThreshould();
		
		int fraudProbabilityScore = 0;
		
		if(r.getStationId() == 110) {
			//in real life,pull from cache that stores result of calculation
			fraudProbabilityScore = 30;
		}
		
		if(fraudProbabilityScore > fraudThreshould)
		{
			r.setIsFraud(true);
		}
		
		return r;
	}

}
