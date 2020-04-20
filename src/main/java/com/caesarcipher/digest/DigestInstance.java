package com.caesarcipher.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.caesarcipher.constants.CaesarCipherConstants;
import com.caesarcipher.exception.CaesarCipherException;

public class DigestInstance {

	public MessageDigest createInstance() throws CaesarCipherException {
		try {
			return MessageDigest.getInstance(CaesarCipherConstants.SHA1);
		}
		catch (NoSuchAlgorithmException e) {
			throw new CaesarCipherException(CaesarCipherException.DIGEST_FAILED);
		}
	}

}
