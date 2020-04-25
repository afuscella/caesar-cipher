package com.caesarcipher.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.caesarcipher.constants.CaesarCipherConstants;
import com.caesarcipher.exception.CaesarCipherException;

@Component
public class DigestInstance {

	/**
	 * create digest instance
	 * @return
	 * @throws CaesarCipherException
	 */
	public MessageDigest createInstance() throws CaesarCipherException {
		try {
			return MessageDigest.getInstance(CaesarCipherConstants.SHA1);
		}
		catch (NoSuchAlgorithmException e) {
			throw new CaesarCipherException(CaesarCipherException.DIGEST_FAILED);
		}
	}

}
