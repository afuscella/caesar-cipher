package com.caesarcipher.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.caesarcipher.converter.CaesarCipher;
import com.caesarcipher.exception.CaesarCipherException;
import com.caesarcipher.model.dto.Cipher;

public class CipherServiceTest {

	private final int TEST_NUMBER_SHIFT = 5;
	private final String TEST_CIPHER = "nk ymjwj nx st xywzllqj, ymjwj nx st uwtlwjxx. kwjijwnhp itzlqfxx";

	@Mock
	private CaesarCipher caesarCipher;

	@InjectMocks
	private CipherService cipherService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void handleEncodeExternal() throws CaesarCipherException {
		//	cipherService.handleDecodeExternal(loadCipher());
	}

	private Cipher loadCipher() {
		Cipher cipher = new Cipher();
		cipher.setNumberShift(TEST_NUMBER_SHIFT);
		cipher.setCipher(TEST_CIPHER);
		return cipher;
	}
}
