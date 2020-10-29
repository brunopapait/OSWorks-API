package com.brunopapait.osworks.api.model;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrdemServicoInput {

	@NotBlank(message = "O campo é obrigatório.")
	private String descricao;
	
	@NotNull(message = "O campo é obrigatório.")
	private BigDecimal preco;
	
	@Valid
	@NotNull(message = "O campo é obrigatório.")
	private ClienteIdInput clienteid;

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
	 * @return the preco
	 */
	public BigDecimal getPreco() {
		return preco;
	}

	/**
	 * @param preco the preco to set
	 */
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	/**
	 * @return the clienteid
	 */
	public ClienteIdInput getClienteid() {
		return clienteid;
	}

	/**
	 * @param clienteid the clienteid to set
	 */
	public void setClienteid(ClienteIdInput clienteid) {
		this.clienteid = clienteid;
	}

}
