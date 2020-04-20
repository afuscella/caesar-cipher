package com.caesarcipher.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DecipherAPI {

	@JsonProperty("numero_casas")
	private int numero_casas;

	@JsonProperty("token")
	private String token;

	@JsonProperty("cifrado")
	private String cifrado;

	@JsonProperty("decifrado")
	private String decifrado;

	@JsonProperty("resumo_criptografico")
	private String resumo_criptografico;

	public int getNumero_casas() {
		return numero_casas;
	}

	public void setNumero_casas(int numero_casas) {
		this.numero_casas = numero_casas;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCifrado() {
		return cifrado;
	}

	public void setCifrado(String cifrado) {
		this.cifrado = cifrado;
	}

	public String getDecifrado() {
		return decifrado;
	}

	public void setDecifrado(String decifrado) {
		this.decifrado = decifrado;
	}

	public String getResumo_criptografico() {
		return resumo_criptografico;
	}

	public void setResumo_criptografico(String resumo_criptografico) {
		this.resumo_criptografico = resumo_criptografico;
	}
}