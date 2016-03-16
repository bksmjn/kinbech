package com.codebhatti.kinbech.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String errorMessage;
	
	public BusinessException() {}
	
	public BusinessException(String errorMessage) {
		this.errorMessage=errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
