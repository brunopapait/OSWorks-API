package com.brunopapait.osworks.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.brunopapait.osworks.api.model.OrdemServico;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private OrdemServico ordemServico;
	
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
	 * @return the ordemServico
	 */
	public OrdemServico getOrdemServico() {
		return ordemServico;
	}
	/**
	 * @param ordemServico the ordemServico to set
	 */
	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
