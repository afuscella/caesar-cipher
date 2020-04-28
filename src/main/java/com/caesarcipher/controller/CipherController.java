package com.caesarcipher.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caesarcipher.exception.CaesarCipherException;
import com.caesarcipher.model.dto.Cipher;
import com.caesarcipher.model.response.DecipherAPIResponse;
import com.caesarcipher.model.response.Decoded;
import com.caesarcipher.model.response.Encoded;
import com.caesarcipher.service.CipherService;

@RestController
@Validated
@RequestMapping(CipherController.PATH)
public class CipherController {

	public static final String PATH = "cipher/v1";

	private CipherService cipherService;

	@Autowired
	public CipherController(CipherService cipherService) {
		this.cipherService = cipherService;
	}

	/**
	 * POST cipher/v1/decode
	 *
	 * @param cipher
	 * @return
	 */
	@PostMapping(value = "/decode", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity decodeCall(@Valid @RequestBody Cipher cipher) {
		try {
			Decoded decipher = cipherService.handleDecode(cipher);
			return ResponseEntity.ok(decipher);
		}
		catch (CaesarCipherException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	/**
	 * POST cipher/v1/decode
	 *
	 * @param cipher
	 * @return
	 */
	@PostMapping(value = "/encode", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity encodeCall(@Valid @RequestBody Cipher cipher) {
		try {
			Encoded decipher = cipherService.handleEncode(cipher);
			return ResponseEntity.ok(decipher);
		}
		catch (CaesarCipherException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping(value = "/decodeExternal")
	public ResponseEntity decodeExternalCall(@Valid @RequestBody Cipher cipher) {
		DecipherAPIResponse response;
		try {
			response = cipherService.handleDecodeExternal(cipher);
			return ResponseEntity.ok(response);
		}
		catch (CaesarCipherException e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
	}

}
