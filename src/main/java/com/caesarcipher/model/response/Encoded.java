package com.caesarcipher.model.response;

import com.caesarcipher.model.dto.CipherDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Encoded implements CipherDTO {

	@JsonProperty("encoded")
	private String encoded;

	@JsonProperty("sha1")
	private String sha1;

	public String getEncoded() {
		return encoded;
	}

	public void setEncoded(String encoded) {
		this.encoded = encoded;
	}

	public String getSha1() {
		return sha1;
	}

	public void setSha1(String sha1) {
		this.sha1 = sha1;
	}

}
