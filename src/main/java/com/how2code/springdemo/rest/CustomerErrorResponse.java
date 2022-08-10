package com.how2code.springdemo.rest;

public class CustomerErrorResponse {
	
	private Integer status;
	private String messageString;
	private Long timeStamp;

	public CustomerErrorResponse() {
	}

	public CustomerErrorResponse(Integer status, String messageString, Long timeStamp) {
		super();
		this.status = status;
		this.messageString = messageString;
		this.timeStamp = timeStamp;
	}

	public Integer getstatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessageString() {
		return messageString;
	}

	public void setMessageString(String messageString) {
		this.messageString = messageString;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
