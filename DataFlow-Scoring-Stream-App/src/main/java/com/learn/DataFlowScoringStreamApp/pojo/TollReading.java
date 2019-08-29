package com.learn.DataFlowScoringStreamApp.pojo;

public class TollReading {
	private Integer stationId;
	private Integer customerId;
	private String timestamp;
	private Boolean isFraud = false;
	public TollReading() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TollReading(Integer stationId, Integer customerId, String timestamp, Boolean isFraud) {
		super();
		this.stationId = stationId;
		this.customerId = customerId;
		this.timestamp = timestamp;
		this.isFraud = isFraud;
	}
	public Integer getStationId() {
		return stationId;
	}
	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public Boolean getIsFraud() {
		return isFraud;
	}
	public void setIsFraud(Boolean isFraud) {
		this.isFraud = isFraud;
	}
	
	
}
