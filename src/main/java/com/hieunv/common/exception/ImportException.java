package com.hieunv.common.exception;

public class ImportException extends Exception {
	private static final long serialVersionUID = 1L;

	private String code;
	private String simpleMessage;
	private Object listErrorImport;

	public ImportException(String code, String simpleMessage, Object listErrorImport) {
		super();
		this.code = code;
		this.simpleMessage = simpleMessage;
		this.listErrorImport = listErrorImport;
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

	public Object getListErrorImport() {
		return listErrorImport;
	}

	public void setListErrorImport(Object listErrorImport) {
		this.listErrorImport = listErrorImport;
	}

}
