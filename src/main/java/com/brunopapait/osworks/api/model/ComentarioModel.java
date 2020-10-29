package com.brunopapait.osworks.api.model;

import java.time.OffsetDateTime;

public class ComentarioModel {
	private Long id;
	private String descricao;
	private OffsetDateTime dataEnvio;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the dataEnvio
	 */
	public OffsetDateTime getDataEnvio() {
		return dataEnvio;
	}

	/**
	 * @param dataEnvio the dataEnvio to set
	 */
	public void setDataEnvio(OffsetDateTime dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

}
