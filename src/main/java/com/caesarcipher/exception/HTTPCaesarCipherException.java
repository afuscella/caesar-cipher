package com.caesarcipher.exception;

public class HTTPCaesarCipherException extends CaesarCipherException {

	private int code;
	private String response;

	public HTTPCaesarCipherException(String message) {
		super(message);
	}

	public HTTPCaesarCipherException(String message, int code, String response) {
		super(message);
		this.code = code;
		this.response = response;
	}

	public int getCode() {
		return this.code;
	}

	public String getResponse() {
		return this.response;
	}

}
