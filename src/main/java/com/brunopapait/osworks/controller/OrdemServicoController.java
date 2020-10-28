package com.brunopapait.osworks.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brunopapait.osworks.api.model.OrdemServicoModel;
import com.brunopapait.osworks.domain.model.OrdemServico;
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
	public OrdemServico criar(@RequestBody @Valid OrdemServico ordemServico) {

		return ordemServicoService.criar(ordemServico);
	}

	@GetMapping("/ordem-servico")
	public List<OrdemServico> listar() {
		return ordemServicoRepository.findAll();
	}

	@GetMapping("/ordem-servico/{id}")
	public ResponseEntity<OrdemServicoModel> buscarPorId(@PathVariable Long id) {
		Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(id);

		if (ordemServico.isPresent()) {
			OrdemServicoModel ordemServicoModel = modelMapper.map(ordemServico.get(), OrdemServicoModel.class);
			return ResponseEntity.ok(ordemServicoModel);
		}
		return ResponseEntity.notFound().build();

	}
}
