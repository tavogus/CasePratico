package com.casepratico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casepratico.model.Pais;
import com.casepratico.repository.PaisRepository;
import com.casepratico.service.PaisService;

@RestController
public class PaisController {

	@Autowired
	private PaisService paisService;

	@Autowired
	private PaisRepository paisRepository;

	@GetMapping("/listar")
	public ResponseEntity<List<Pais>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(paisService.listar());
	}

	@PostMapping("/salvar")
	public ResponseEntity<Pais> salvar(@RequestBody Pais pais) {
		try {
			return new ResponseEntity<>(paisRepository.save(pais), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Pais> buscarPorId(@PathVariable Long id) {
		return paisRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePais(@PathVariable("id") Long id) {
		return paisRepository.findById(id).map(record -> {
			paisRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());

	}

}
