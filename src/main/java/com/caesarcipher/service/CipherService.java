package com.caesarcipher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caesarcipher.converter.CaesarCipher;
import com.caesarcipher.digest.Digest;
import com.caesarcipher.exception.CaesarCipherException;
import com.caesarcipher.model.dto.Cipher;
import com.caesarcipher.model.dto.CipherTransformer;
import com.caesarcipher.model.response.Decoded;
import com.caesarcipher.model.response.Encoded;

@Service
public class CipherService {

	private CaesarCipher caesarCipher;

	private Digest digest;

	@Autowired
	public CipherService(CaesarCipher caesarCipher, Digest digest) {
		this.caesarCipher = caesarCipher;
		this.digest = digest;
	}

	/**
	 * handle decode service
	 * @param cipher
	 * @return
	 * @throws CaesarCipherException
	 */
	public Decoded handleDecode(Cipher cipher) throws CaesarCipherException {
		String decoded = caesarCipher.decode(cipher.getNumberShift(), cipher.getCipher());
		String sha1 = digest.digest(decoded);

		CipherTransformer cipherTransformer = new CipherTransformer();
		return cipherTransformer.transformToDecoded(decoded, sha1);
	}

	/**
	 * handle encode service
	 * @param cipher
	 * @return
	 * @throws CaesarCipherException
	 */
	public Encoded handleEncode(Cipher cipher) throws CaesarCipherException {
		String encoded = caesarCipher.encode(cipher.getNumberShift(), cipher.getCipher());
		String sha1 = digest.digest(encoded);

		CipherTransformer cipherTransformer = new CipherTransformer();
		return cipherTransformer.transformToEncoded(encoded, sha1);
	}

}
