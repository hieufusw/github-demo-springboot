package com.hieunv.common.exception;

public class AuthenticationException extends Exception {
	private static final long serialVersionUID = 1L;

	private String code;
	private String simpleMessage;

	public AuthenticationException() {
		super();
	}

	public AuthenticationException(String code) {
		super();
		this.code = code;
	}

	public AuthenticationException(String code, String simpleMessage) {
		super();
		this.code = code;
		this.simpleMessage = simpleMessage;
	}

	public String getSimpleMessage() {
		return simpleMessage;
	}

	public void setSimpleMessage(String simpleMessage) {
		this.simpleMessage = simpleMessage;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
