package com.caesarcipher.digest;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.caesarcipher.exception.CaesarCipherException;

@Component
public class Digest {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private DigestInstance digestInstance;

	public Digest(DigestInstance digestInstance) {
		this.digestInstance = digestInstance;
	}

	public String digest(String data) throws CaesarCipherException {
		logger.info("generating sha1");
		MessageDigest digest = digestInstance.createInstance();
		byte[] hashCode = digest.digest(data.getBytes(StandardCharsets.UTF_8));
		return bytesToHex(hashCode);
	}

	private String bytesToHex(byte[] hashArr) {
		StringBuffer sb = new StringBuffer();
		String hex;

		for (byte hash : hashArr) {
			hex = Integer.toHexString(0xff & hash);

			if (hex.length() == 1) {
				sb.append('0');
			}
			sb.append(hex);
		}
		return sb.toString();
	}
}
