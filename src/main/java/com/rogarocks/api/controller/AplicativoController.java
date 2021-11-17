package com.rogarocks.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rogarocks.domain.model.Aplicativo;
import com.rogarocks.domain.repository.AplicativoRepository;
import com.rogarocks.domain.service.AplicativoService;

@RestController
@RequestMapping("/aplicativos")
public class AplicativoController {
	
	@Autowired
	private AplicativoService aplicativoService;
	@Autowired
	private AplicativoRepository aplicativoRepository;
	
	@PostMapping
	public ResponseEntity<Aplicativo> cadastrar (@RequestBody Aplicativo aplicativo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(aplicativoService.salvar(aplicativo));
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<List<Aplicativo>> buscarPorNomeETipo (@RequestParam String nome, @RequestParam String tipo) {
		return ResponseEntity.status(HttpStatus.OK).body(aplicativoRepository.buscarPorNomeETipo(nome, tipo));
	}
	
	@GetMapping("/buscarBarato")
	public ResponseEntity<List<Aplicativo>> buscarMaisBarato (@RequestParam String tipo) {
		return ResponseEntity.status(HttpStatus.OK).body(aplicativoService.buscarMaisBaratoPorTipo(tipo));
	}
}