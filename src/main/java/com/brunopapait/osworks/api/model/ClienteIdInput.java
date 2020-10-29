package com.brunopapait.osworks.api.model;

import javax.validation.constraints.NotNull;

public class ClienteIdInput {

	@NotNull(message = "O campo é obrigatório.")
	private Long id;

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

}
