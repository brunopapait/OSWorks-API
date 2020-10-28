package com.brunopapait.osworks.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.brunopapait.osworks.domain.ValidationGroups;

@Entity
public class Cliente {

	@NotNull(groups = ValidationGroups.ClienteId.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Por favor informe um nome !")
	@Size(max = 60, min = 0, message = "Deve ter no mínimo 0 caracteres e no máximo 60 caracteres")
	private String nome;

	@NotBlank(message = "Por favor informe um email !")
	@Email(message = "Deve estar no formato correto de email. Ex: xxx@xxx.com")
	@Size(max = 255, min = 0, message = "Deve ter no mínimo 0 caracteres e no máximo 255 caracteres")
	private String email;

	@NotBlank(message = "Por favor informe um telefone !")
	@Size(max = 20, min = 0, message = "Deve ter no mínimo 0 caracteres e no máximo 20 caracteres.")
	private String telefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
