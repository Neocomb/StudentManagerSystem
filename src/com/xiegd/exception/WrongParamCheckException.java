package com.xiegd.exception;

public class WrongParamCheckException extends Exception {
	private String reason;
	public WrongParamCheckException() {
		// TODO Auto-generated constructor stub
	}
	public WrongParamCheckException(String reason) {
		super(reason);
		this.reason = reason;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
