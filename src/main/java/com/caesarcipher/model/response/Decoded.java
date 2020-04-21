package com.caesarcipher.model.response;

import com.caesarcipher.model.dto.CipherDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Decoded implements CipherDTO {

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
