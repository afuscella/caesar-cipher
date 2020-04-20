package com.caesarcipher.digest;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;

import com.caesarcipher.exception.CaesarCipherException;

public class Digest {

	@Autowired
	private DigestInstance digestInstance;

	public Digest(DigestInstance digestInstance) {
		this.digestInstance = digestInstance;
	}

	public String digest(String data) throws CaesarCipherException {
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
