package com.caesarcipher.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;

import com.caesarcipher.constants.CaesarCipherConstants;
import com.caesarcipher.exception.CaesarCipherException;

public class DigestInstance {

	@Autowired
	private MessageDigest messageDigest;

	public DigestInstance(MessageDigest messageDigest) {
		this.messageDigest = messageDigest;
	}

	public MessageDigest createInstance() throws CaesarCipherException {
		try {
			return MessageDigest.getInstance(CaesarCipherConstants.SHA1);
		}
		catch (NoSuchAlgorithmException e) {
			throw new CaesarCipherException(CaesarCipherException.DIGEST_FAILED);
		}
	}

}
