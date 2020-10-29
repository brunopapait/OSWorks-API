package com.brunopapait.osworks.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunopapait.osworks.api.model.OrdemServico;
import com.brunopapait.osworks.domain.exception.EntidadeNaoEncontrada;
import com.brunopapait.osworks.domain.exception.NegocioException;
import com.brunopapait.osworks.domain.model.Cliente;
import com.brunopapait.osworks.domain.model.Comentario;
import com.brunopapait.osworks.domain.model.StatusOrdemServico;
import com.brunopapait.osworks.domain.repository.ClienteRepository;
import com.brunopapait.osworks.domain.repository.ComentarioRepository;
import com.brunopapait.osworks.domain.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ComentarioRepository comentarioRepository;

	public OrdemServico criar(OrdemServico ordemServico) {

		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));

		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(OffsetDateTime.now());

		return ordemServicoRepository.save(ordemServico);
	}

	public Comentario adicionarComentario(Long ordemServicoId, String descricao) {
		OrdemServico ordemServico = buscarOrdemServico(ordemServicoId);
		Comentario comentario = new Comentario();

		comentario.setDataEnvio(OffsetDateTime.now());
		comentario.setDescricao(descricao);
		comentario.setOrdemServico(ordemServico);
		return comentarioRepository.save(comentario);
	}

	public void finalizar(Long ordemServicoId) {
		OrdemServico ordemServico = buscarOrdemServico(ordemServicoId);

		ordemServico.finalizarOrdem();

		ordemServicoRepository.save(ordemServico);
	}

	/**
	 * @param ordemServicoId
	 * @return
	 */
	private OrdemServico buscarOrdemServico(Long ordemServicoId) {
		return ordemServicoRepository.findById(ordemServicoId)
				.orElseThrow(() -> new EntidadeNaoEncontrada("Ordem de servico não encontrada."));
	}
}
