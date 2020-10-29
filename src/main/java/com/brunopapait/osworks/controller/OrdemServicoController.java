package com.brunopapait.osworks.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brunopapait.osworks.api.model.OrdemServico;
import com.brunopapait.osworks.api.model.OrdemServicoInput;
import com.brunopapait.osworks.api.model.OrdemServicoModel;
import com.brunopapait.osworks.domain.repository.OrdemServicoRepository;
import com.brunopapait.osworks.domain.service.OrdemServicoService;

@RestController
public class OrdemServicoController {
	@Autowired
	private OrdemServicoService ordemServicoService;

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/ordem-servico")
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServicoModel criar(@RequestBody @Valid OrdemServicoInput ordemServicoInput) {
		OrdemServico ordemServico = toEntity(ordemServicoInput);
		return toModel(ordemServicoService.criar(ordemServico));
	}

	@GetMapping("/ordem-servico")
	public List<OrdemServicoModel> listar() {
		return toCollectionModel(ordemServicoRepository.findAll());
	}

	@GetMapping("/ordem-servico/{id}")
	public ResponseEntity<OrdemServicoModel> buscarPorId(@PathVariable Long id) {
		Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(id);

		if (ordemServico.isPresent()) {
			OrdemServicoModel ordemServicoModel = toModel(ordemServico.get());
			return ResponseEntity.ok(ordemServicoModel);
		}
		return ResponseEntity.notFound().build();

	}

	private OrdemServicoModel toModel(OrdemServico ordemServico) {
		return modelMapper.map(ordemServico, OrdemServicoModel.class);
	}

	private List<OrdemServicoModel> toCollectionModel(List<OrdemServico> ordensServicos) {
		return ordensServicos.stream().map(ordemServico -> toModel(ordemServico)).collect(Collectors.toList());

	}

	private OrdemServico toEntity(OrdemServicoInput ordemServicoInput) {
		return modelMapper.map(ordemServicoInput, OrdemServico.class);
	}
	
	@PutMapping("/ordem-servico/{id}/finalizar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long id) {
		ordemServicoService.finalizar(id);
		
	}
}
