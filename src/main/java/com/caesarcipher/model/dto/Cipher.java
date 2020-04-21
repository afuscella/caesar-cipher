package com.caesarcipher.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cipher implements CipherDTO {

	@NotNull
	@JsonProperty("numberShift")
	private int numberShift;

	@NotNull @NotEmpty
	@JsonProperty("token")
	private String token;

	@NotNull @NotEmpty
	@JsonProperty("cipher")
	private String cipher;

	public int getNumberShift() {
		return numberShift;
	}

	public void setNumberShift(int numberShift) {
		this.numberShift = numberShift;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCipher() {
		return cipher;
	}

	public void setCipher(String cipher) {
		this.cipher = cipher;
	}
}
