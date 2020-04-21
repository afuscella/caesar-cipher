package com.caesarcipher.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Decipher implements CipherDTO {

	@JsonProperty("decoded")
	private String decoded;

	@JsonProperty("sha1")
	private String sha1;

	public String getDecoded() {
		return decoded;
	}

	public void setDecoded(String decoded) {
		this.decoded = decoded;
	}

	public String getSha1() {
		return sha1;
	}

	public void setSha1(String sha1) {
		this.sha1 = sha1;
	}

}
