package com.caesarcipher.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class CaesarCipherTest {

	private String TEST_ENCODED = "nk ymjwj nx st xywzllqj, ymjwj nx st uwtlwjxx. kwjijwnhp itzlqfxx";
	private String TEST_DECODED = "if there is no struggle, there is no progress. frederick douglass";

	@InjectMocks
	private CaesarCipher caesarCipher;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void decodeShouldConvertWhenHashcodeIsRequested() {
		String sentence = caesarCipher.decode(5, TEST_ENCODED);
		Assert.assertEquals(TEST_DECODED, sentence);

		String textLongShift = caesarCipher.decode(83, TEST_ENCODED);
		Assert.assertEquals(TEST_DECODED, textLongShift);
	}

	@Test
	public void encodeShouldConvertWhenHashcodeIsRequested() {
		String sentence = caesarCipher.encode(5, TEST_DECODED);
		Assert.assertEquals(TEST_ENCODED, sentence);

		String textLongShift = caesarCipher.encode(83, TEST_DECODED);
		Assert.assertEquals(TEST_ENCODED, textLongShift);
	}

}
