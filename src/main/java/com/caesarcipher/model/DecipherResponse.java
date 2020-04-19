package com.caesarcipher.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DecipherResponse {

	@JsonProperty("decipher")
	String decipher;

	@JsonProperty("sha1")
	String sha1;

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
