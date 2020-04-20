package com.caesarcipher.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Decipher implements CipherDTO {

	@JsonProperty("decipher")
	private String decipher;

	@JsonProperty("sha1")
	private String sha1;

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
