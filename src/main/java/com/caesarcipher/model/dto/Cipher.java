package com.caesarcipher.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cipher implements CipherDTO {

	@JsonProperty("numberShift")
	int numberShift;

	@JsonProperty("token")
	String token;

	@JsonProperty("cipher")
	String cipher;

	@JsonProperty("decipher")
	String decipher;

	@JsonProperty("sha1")
	String sha1;

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

	public String getDecipher() {
		return decipher;
	}

	public void setDecipher(String decipher) {
		this.decipher = decipher;
	}

	public String getSha1() {
		return sha1;
	}

	public void setSha1(String sha1) {
		this.sha1 = sha1;
	}
}
