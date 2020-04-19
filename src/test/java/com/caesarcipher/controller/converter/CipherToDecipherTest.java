package com.caesarcipher.controller.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.caesarcipher.converter.CipherToDecipher;

public class CipherToDecipherTest {

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void CipherToDecipherShouldConvertWhenStringIsRequested() {
		CipherToDecipher cipherToDecipher = new  CipherToDecipher();

		String withoutSpace = cipherToDecipher.decipher(26, "aeiouz");
		Assert.assertEquals("aeiouz", withoutSpace);

		String withSpaces = cipherToDecipher.decipher(1, "aeiou aeiou");
		Assert.assertEquals("bfjpv bfjpv", withSpaces);

		String longShift = cipherToDecipher.decipher(30, "aeiouz");
		Assert.assertEquals("eimsyd", longShift);

	}

}
