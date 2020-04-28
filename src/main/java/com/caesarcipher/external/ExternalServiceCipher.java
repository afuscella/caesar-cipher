package com.caesarcipher.external;

import java.net.URI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.caesarcipher.exception.FileException;
import com.caesarcipher.exception.HTTPCaesarCipherException;
import com.caesarcipher.file.CipherFile;
import com.caesarcipher.model.dto.DecipherAPI;
import com.caesarcipher.model.response.DecipherAPIResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ExternalServiceCipher {

	private static Logger logger = LogManager.getLogger(ExternalServiceCipher.class);

	@Value("${SHARED_HOST}")
	private String sharedHost;

	@Value("${SHARED_URI}")
	private String sharedUri;

	private RestTemplate restTemplate;

	private CipherFile cipherFile;

	@Autowired
	public ExternalServiceCipher(RestTemplate restTemplate, CipherFile cipherFile) {
		this.restTemplate = restTemplate;
		this.cipherFile = cipherFile;
	}

	/**
	 * @param decipherAPI
	 * @return
	 * @throws HTTPCaesarCipherException
	 */
	public DecipherAPIResponse invokeExternalCall(DecipherAPI decipherAPI) throws HTTPCaesarCipherException {
		String token = decipherAPI.getToken();
		URI uri = URI.create(sharedHost + sharedUri + token);

		JSONObject jsonObject = new JSONObject(decipherAPI);
		ObjectMapper mapper = new ObjectMapper();

		try {
			ResponseEntity entity = restTemplate.exchange(uri, HttpMethod.POST, createEntity(jsonObject), String.class);
			DecipherAPIResponse apiResponse = mapper.readValue(entity.getBody().toString(), DecipherAPIResponse.class);
			apiResponse.setStatusCode(entity.getStatusCode().value());
			return apiResponse;
		}
		catch (HttpClientErrorException e) {
			throw new HTTPCaesarCipherException(e.getMessage(), e.getResponseBodyAsString());
		}
		catch (JsonProcessingException e) {
			throw new HTTPCaesarCipherException(e.getMessage());
		}
	}

	/**
	 * @param jsonObject
	 * @return
	 */
	private HttpEntity createEntity(JSONObject jsonObject) {
		HttpEntity<MultiValueMap<String, Object>> requestEntity;
		FileSystemResource file = null;

		try {
			file = cipherFile.createJsonFile(jsonObject);
		}
		catch (FileException e) {
			logger.info("Not able to create the answer.json file: {}", e.getLocalizedMessage());
		}
		requestEntity = new HttpEntity<>(createMultiPart(file), createHeaders());
		return requestEntity;
	}

	/**
	 * @return
	 */
	private HttpHeaders createHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		return headers;
	}

	/**
	 * @param file
	 * @return
	 */
	private MultiValueMap<String, Object> createMultiPart(FileSystemResource file) {
		MultiValueMap<String, Object> multiPart = new LinkedMultiValueMap<>();
		multiPart.add("answer", file);
		return multiPart;
	}

}
