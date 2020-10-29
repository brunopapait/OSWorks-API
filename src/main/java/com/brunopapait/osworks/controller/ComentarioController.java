package com.brunopapait.osworks.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brunopapait.osworks.api.model.ComentarioInput;
import com.brunopapait.osworks.api.model.ComentarioModel;
import com.brunopapait.osworks.api.model.OrdemServico;
import com.brunopapait.osworks.domain.exception.EntidadeNaoEncontrada;
import com.brunopapait.osworks.domain.model.Comentario;
import com.brunopapait.osworks.domain.repository.OrdemServicoRepository;
import com.brunopapait.osworks.domain.service.OrdemServicoService;

@RestController
public class ComentarioController {

	@Autowired
	private OrdemServicoService ordemServicoService;
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/ordem-servico/{ordemServicoId}/comentario")
	public List<ComentarioModel> listarTodos(@PathVariable Long ordemServicoId) {
		OrdemServico ordemServico = ordemServicoRepository.findById(ordemServicoId)
				.orElseThrow(() -> new EntidadeNaoEncontrada("Ordem de serviço não encontrada."));
		return toCollectionModel(ordemServico.getComentarios());
	}

	private List<ComentarioModel> toCollectionModel(List<Comentario> comentarios) {
		// TODO Auto-generated method stub
		return comentarios.stream().map((comentario) -> toModel(comentario)).collect(Collectors.toList());
	}

	@PostMapping("/ordem-servico/{ordemServicoId}/comentario")
	@ResponseStatus(HttpStatus.CREATED)
	public ComentarioModel adicionar(@PathVariable Long ordemServicoId,
			@Valid @RequestBody ComentarioInput comentarioInput) {

		Comentario comentario = ordemServicoService.adicionarComentario(ordemServicoId, comentarioInput.getDescricao());

		return toModel(comentario);
	}

	private ComentarioModel toModel(Comentario comentario) {
		return modelMapper.map(comentario, ComentarioModel.class);
	}

}
