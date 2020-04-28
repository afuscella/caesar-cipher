package com.caesarcipher.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.caesarcipher.digest.Digest;

public class CaesarCipherException extends Exception {

	public static final String DIGEST_FAILED = "Could not create digest for the given value.";
	public static final String HTTP_FAILED = "HTTP call was not successful.";
	public static final String FILE_WRITE_ERROR = "Could not write the file";
	public static final String FILE_CLOSE_ERROR = "Could not close the file";

	protected Logger logger = LogManager.getLogger(Digest.class);

	public CaesarCipherException(String message) {
		super(message);
	}
}
