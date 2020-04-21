package com.caesarcipher.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.caesarcipher.model.dto.Cipher;
import com.caesarcipher.model.dto.CipherTransformer;
import com.caesarcipher.model.dto.DecipherAPI;
import com.caesarcipher.model.response.Decoded;

public class CipherTransformerTest {

	private static final int TEST_NUMBER_SHIFT = 2;
	private static final String TEST_TOKEN = "1qaz2ws3edc4rfv5tgb6yhn7ujm8ik";
	private static final String TEST_CIPHER = "aeiou";
	private static final String TEST_DECIPHER = "bfjpv";
	private static final String TEST_SHA1 = "2d0b2d330c09be5189853d7a36108c9e91525e56";

	@InjectMocks
	private CipherTransformer cipherTransformer;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void transformToDecipherAPIShouldTransform() {
		Cipher cipher = loadCipher();
		DecipherAPI decipherAPI = cipherTransformer.transformToDecipherAPI(cipher, TEST_DECIPHER, TEST_SHA1);

		assertDecipherAPI(decipherAPI);
	}

	@Test
	public void transformToDecipherShouldTransform() {
		Decoded decoded = cipherTransformer.transformToDecoded(TEST_DECIPHER, TEST_SHA1);

		assertDecoded(decoded);
	}

	private Cipher loadCipher() {
		Cipher cipher = new Cipher();
		cipher.setNumberShift(TEST_NUMBER_SHIFT);
		cipher.setCipher(TEST_CIPHER);
		return cipher;
	}

	private void assertDecoded(Decoded decoded) {
		Assert.assertEquals(TEST_DECIPHER, decoded.getDecoded());
		Assert.assertEquals(TEST_SHA1, decoded.getSha1());
	}

	private void assertDecipherAPI(DecipherAPI decipherAPI) {
		Assert.assertEquals(TEST_NUMBER_SHIFT, decipherAPI.getNumero_casas());
//		Assert.assertEquals(TEST_TOKEN, decipherAPI.getToken());
		Assert.assertEquals(TEST_CIPHER, decipherAPI.getCifrado());
		Assert.assertEquals(TEST_DECIPHER, decipherAPI.getDecifrado());
		Assert.assertEquals(TEST_SHA1, decipherAPI.getResumo_criptografico());
	}

}
