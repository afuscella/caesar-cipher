package com.caesarcipher.exception;

public class HTTPCaesarCipherException extends CaesarCipherException {

	private String response;

	public HTTPCaesarCipherException(String message) {
		super(message);
	}

	public HTTPCaesarCipherException(String message, String response) {
		super(message);
		this.response = response;
	}

	public String getResponse() {
		return this.response;
	}

}
