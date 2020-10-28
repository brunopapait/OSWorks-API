package com.brunopapait.osworks.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunopapait.osworks.domain.exception.NegocioException;
import com.brunopapait.osworks.domain.model.Cliente;
import com.brunopapait.osworks.domain.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente salvar(Cliente cliente) throws Exception {
		Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
		String mensagem = "Já existe um cliente cadastrado com este e-mail";
		if (clienteExistente != null && !clienteExistente.equals(cliente)) {
			throw new NegocioException(mensagem);
		}
		
		return clienteRepository.save(cliente);
	}

	public void excluir(Long id) { 
		clienteRepository.deleteById(id);
	}
}
