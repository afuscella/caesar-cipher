package com.caesarcipher.model.dto;

import org.springframework.stereotype.Component;

import com.caesarcipher.model.response.Decoded;
import com.caesarcipher.model.response.Encoded;

@Component
public class CipherTransformer {

	public DecipherAPI transformToDecipherAPI(Cipher cipher, String decipher, String sha1) {
		DecipherAPI decipherAPI = new DecipherAPI();
		decipherAPI.setNumero_casas(cipher.getNumberShift());
//		decipherAPI.setToken(cipher.getToken());
		decipherAPI.setCifrado(cipher.getCipher());
		decipherAPI.setDecifrado(decipher);
		decipherAPI.setResumo_criptografico(sha1);
		return decipherAPI;
	}

	public Decoded transformToDecoded(String token, String sha1) {
		Decoded decipher = new Decoded();
		decipher.setDecoded(token);
		decipher.setSha1(sha1);
		return decipher;
	}

	public Encoded transformToEncoded(String token, String sha1) {
		Encoded decipher = new Encoded();
		decipher.setEncoded(token);
		decipher.setSha1(sha1);
		return decipher;
	}
}
