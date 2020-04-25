package com.caesarcipher.digest;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.caesarcipher.exception.CaesarCipherException;

@Component
public class Digest {

	private static Logger logger = LogManager.getLogger(Digest.class);

	private DigestInstance digestInstance;

	@Autowired
	public Digest(DigestInstance digestInstance) {
		this.digestInstance = digestInstance;
	}

	/**
	 * generate the sha1 hashcode
	 * @param s
	 * @return
	 * @throws CaesarCipherException
	 */
	public String createSHA1(String s) throws CaesarCipherException {
		logger.info("generating sha1");

		MessageDigest digest = digestInstance.createInstance();
		byte[] hashCode = digest.digest(s.getBytes(StandardCharsets.UTF_8));
		return convertBytesToHex(hashCode);
	}

	/**
	 * convert bytes into hex
	 * @param hashArr
	 * @return
	 */
	private String convertBytesToHex(byte[] hashArr) {
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
