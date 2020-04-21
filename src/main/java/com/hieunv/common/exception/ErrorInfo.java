package com.hieunv.common.exception;

import java.io.Serializable;


public class ErrorInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String code;
	private String simpleMessage;

	public ErrorInfo() {
	}

	public ErrorInfo(String code) {
		super();
		this.code = code;
	}

	public ErrorInfo(String code, String simpleMessage) {
		super();
		this.code = code;
		this.simpleMessage = simpleMessage;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSimpleMessage() {
		return simpleMessage;
	}

	public void setSimpleMessage(String simpleMessage) {
		this.simpleMessage = simpleMessage;
	}

}
