package com.learn.EurekaTollRateService.pojo;

import java.math.BigDecimal;

public class TollRate {
	private int stationId;
	private BigDecimal currentRate;
	private String timestamp;
	
	public TollRate() {
		super();
	}
	public TollRate(int stationId, BigDecimal currentRate, String timestamp) {
		super();
		this.stationId = stationId;
		this.currentRate = currentRate;
		this.timestamp = timestamp;
	}
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	public BigDecimal getCurrentRate() {
		return currentRate;
	}
	public void setCurrentRate(BigDecimal currentRate) {
		this.currentRate = currentRate;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
