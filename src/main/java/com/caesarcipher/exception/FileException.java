package com.caesarcipher.exception;

public class FileException extends CaesarCipherException {

	public FileException(String message) {
		super(message);
		logger.error("IO error: {}", message);
	}

}
