package com.kiit.myFirstSpringboot.response;

import lombok.Data;

@Data
public class ErrorResponse {

	String errorMsg;
	int httpStatusCode;
	boolean success;
	public ErrorResponse(String errorMsg, int httpStatusCode, boolean success) {
		super();
		this.errorMsg = errorMsg;
		this.httpStatusCode = httpStatusCode;
		this.success = success;
	}
	
}
