package com.caesarcipher.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.caesarcipher.constants.CaesarCipherConstants;
import com.caesarcipher.exception.CaesarCipherException;

public class DigestTest {

	private static final String TEST_INPUT_DATA = "1234567890";

	@InjectMocks
	private Digest digest;

	@Mock
	private DigestInstance digestInstance;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void digestShouldThrowExceptionWhenMessageDigestIsNotAvailable() throws CaesarCipherException {
		Mockito.doThrow(CaesarCipherException.class).when(digestInstance).createInstance();
		digest.createSHA1(TEST_INPUT_DATA);
	}

	@Test
	public void digestShouldCreateHashCodeWhenMessageDigestIsAvailable()
			throws CaesarCipherException, NoSuchAlgorithmException {
		MessageDigest localDigest = MessageDigest.getInstance(CaesarCipherConstants.SHA1);

		Mockito.when(digestInstance.createInstance()).thenReturn(localDigest);

		String actual = digest.createSHA1(TEST_INPUT_DATA);
		Assert.assertNotNull(actual);
	}

}
