package com.caesarcipher.external;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.caesarcipher.exception.FileException;
import com.caesarcipher.exception.HTTPCaesarCipherException;
import com.caesarcipher.file.CipherFile;
import com.caesarcipher.model.dto.DecipherAPI;
import com.caesarcipher.model.response.DecipherAPIResponse;

public class ExternalServiceCipherTest {

	private final String TEST_CODE = "200";
	private final int TEST_SCORE = 100;

	@Mock
	private RestTemplate restTemplate;

	@Mock
	private CipherFile cipherFile;

	@InjectMocks
	private ExternalServiceCipher externalServiceCipher;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void invokeExternalCallShouldResultSucessfullWhenRequestIsValid()
			throws HTTPCaesarCipherException, FileException {
		String response = "{ \"score\": 100 }";
		ResponseEntity entity = Mockito.mock(ResponseEntity.class);
		FileSystemResource file = Mockito.mock(FileSystemResource.class);

		Mockito.when(entity.getBody()).thenReturn(response);
		Mockito.when(restTemplate.exchange(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.eq(String.class)))
				.thenReturn(entity);
		Mockito.when(entity.getStatusCode()).thenReturn(HttpStatus.valueOf(200));
		Mockito.when(cipherFile.createJsonFile(Mockito.any())).thenReturn(file);

		DecipherAPIResponse decipherAPIResponse = externalServiceCipher.invokeExternalCall(new DecipherAPI());

		assertValues(decipherAPIResponse);
	}

	private void assertValues(DecipherAPIResponse decipherAPIResponse) {
		Assert.assertEquals(decipherAPIResponse.getCode(), TEST_CODE);
		Assert.assertEquals(decipherAPIResponse.getScore(), TEST_SCORE);
	}
}
