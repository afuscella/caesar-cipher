package com.caesarcipher.model.dto;

import org.springframework.stereotype.Component;

@Component
public class CipherTransformer {

	public DecipherAPI transformToDecipherAPI(Cipher cipher, String decipher, String sha1) {
		DecipherAPI decipherAPI = new DecipherAPI();
		decipherAPI.setNumero_casas(cipher.getNumberShift());
		decipherAPI.setToken(cipher.getToken());
		decipherAPI.setCifrado(cipher.getCipher());
		decipherAPI.setDecifrado(decipher);
		decipherAPI.setResumo_criptografico(sha1);
		return decipherAPI;
	}

	public Decipher transformToDecipher(String token, String sha1) {
		Decipher decipher = new Decipher();
		decipher.setDecipher(token);
		decipher.setSha1(sha1);
		return decipher;
	}
}
