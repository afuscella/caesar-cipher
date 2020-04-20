package com.caesarcipher.exception;

public class CaesarCipherException extends Exception {

	public static final String DIGEST_FAILED = "Could not create digest for the given value.";

	public CaesarCipherException(String message) {
		super(message);
	}
}
