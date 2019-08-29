package com.learn.DataFlowScoringStreamApp.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties("fraud")
@Validated
public class TollReadingProperties {
	
	//limit before we might be worry for fraud
	private Integer fraudThreshould = 10;

	public Integer getFraudThreshould() {
		return fraudThreshould;
	}

	public void setFraudThreshould(Integer fraudThreshould) {
		this.fraudThreshould = fraudThreshould;
	}
	
	
}
