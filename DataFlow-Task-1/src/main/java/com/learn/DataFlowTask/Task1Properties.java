package com.learn.DataFlowTask;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("task1")
public class Task1Properties {
	/*
	 * path to get the source document from
	 */
	private String sourceFilePath;
	
	/*
	 * path to put the destination document
	 */
	private String destinationFilePath;
	
	/*
	 * property to drive the exit code
	 */
	private String controlMessage;

	public String getSourceFilePath() {
		return sourceFilePath;
	}

	public void setSourceFilePath(String sourceFilePath) {
		this.sourceFilePath = sourceFilePath;
	}

	public String getDestinationFilePath() {
		return destinationFilePath;
	}

	public void setDestinationFilePath(String destinationFilePath) {
		this.destinationFilePath = destinationFilePath;
	}

	public String getControlMessage() {
		return controlMessage;
	}

	public void setControlMessage(String controlMessage) {
		this.controlMessage = controlMessage;
	}
	
	
}
