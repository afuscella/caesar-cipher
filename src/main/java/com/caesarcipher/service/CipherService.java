package com.caesarcipher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caesarcipher.converter.CaesarCipher;
import com.caesarcipher.digest.Digest;
import com.caesarcipher.exception.CaesarCipherException;
import com.caesarcipher.model.dto.Cipher;
import com.caesarcipher.model.dto.CipherTransformer;
import com.caesarcipher.model.dto.Decipher;

@Service
public class CipherService {

	private CaesarCipher caesarCipher;

	private Digest digest;

	@Autowired
	public CipherService(CaesarCipher caesarCipher, Digest digest) {
		this.caesarCipher = caesarCipher;
		this.digest = digest;
	}

	public Decipher handleDecode(Cipher cipher) throws CaesarCipherException {
		String decoded = caesarCipher.decode(cipher.getNumberShift(), cipher.getCipher());
		String sha1 = digest.digest(cipher.getCipher());

		CipherTransformer cipherTransformer = new CipherTransformer();
		return cipherTransformer.transformToDecipher(decoded, sha1);
	}

}
