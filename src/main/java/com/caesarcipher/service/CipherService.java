package com.caesarcipher.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caesarcipher.converter.CaesarCipher;
import com.caesarcipher.digest.Digest;
import com.caesarcipher.exception.CaesarCipherException;
import com.caesarcipher.external.ExternalServiceCipher;
import com.caesarcipher.model.dto.Cipher;
import com.caesarcipher.model.dto.CipherTransformer;
import com.caesarcipher.model.dto.DecipherAPI;
import com.caesarcipher.model.response.DecipherAPIResponse;
import com.caesarcipher.model.response.Decoded;
import com.caesarcipher.model.response.Encoded;

@Service
public class CipherService {

	private static Logger logger = LogManager.getLogger(CipherService.class);

	private CaesarCipher caesarCipher;
	private Digest digest;
	private ExternalServiceCipher externalServiceCipher;

	@Autowired
	public CipherService(CaesarCipher caesarCipher, Digest digest, ExternalServiceCipher externalServiceCipher) {
		this.caesarCipher = caesarCipher;
		this.digest = digest;
		this.externalServiceCipher = externalServiceCipher;
	}

	/**
	 * handle decode service
	 *
	 * @param cipher
	 * @return
	 * @throws CaesarCipherException
	 */
	public Decoded handleDecode(Cipher cipher) throws CaesarCipherException {
		String decoded = caesarCipher.decode(cipher.getNumberShift(), cipher.getCipher());
		String sha1 = digest.createSHA1(decoded);

		CipherTransformer cipherTransformer = new CipherTransformer();
		return cipherTransformer.transformToDecoded(decoded, sha1);
	}

	/**
	 * @param cipher
	 * @throws CaesarCipherException
	 */
	public DecipherAPIResponse handleDecodeExternal(Cipher cipher) throws CaesarCipherException {
		String decoded = caesarCipher.decode(cipher.getNumberShift(), cipher.getCipher());
		String sha1 = digest.createSHA1(decoded);

		CipherTransformer cipherTransformer = new CipherTransformer();
		DecipherAPI decipherAPI = cipherTransformer.transformToDecipherAPI(cipher, decoded, sha1);

		return externalServiceCipher.invokeExternalCall(decipherAPI);

	}

	/**
	 * handle encode service
	 *
	 * @param cipher
	 * @return
	 * @throws CaesarCipherException
	 */
	public Encoded handleEncode(Cipher cipher) throws CaesarCipherException {
		String encoded = caesarCipher.encode(cipher.getNumberShift(), cipher.getCipher());
		String sha1 = digest.createSHA1(encoded);

		CipherTransformer cipherTransformer = new CipherTransformer();
		return cipherTransformer.transformToEncoded(encoded, sha1);
	}
}
