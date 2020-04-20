package com.caesarcipher.digest;

import java.security.MessageDigest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.caesarcipher.exception.CaesarCipherException;

public class DigestInstanceTest {

	@InjectMocks
	private DigestInstance digestInstance;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createInstanceShouldCreateMessageDigestWhenRequested() throws CaesarCipherException {
		MessageDigest digest = digestInstance.createInstance();
		Assert.assertNotNull(digest);
	}

}
