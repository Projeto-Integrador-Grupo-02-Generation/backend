package com.generation.kelp_project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.kelp_project.model.Produto;
import com.generation.kelp_project.repository.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {
		return ResponseEntity.ok(produtoRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable Long id) {
		return produtoRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));

	}
	@PostMapping
	public ResponseEntity<Produto> post(@Valid @RequestBody Produto categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(categoria));
	}

	@PutMapping
	public ResponseEntity<Produto> put (@Valid @RequestBody Produto produtos) {
		if (produtoRepository.existsById(produtos.getId())) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(produtoRepository.save(produtos));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Produto> categoria = produtoRepository.findById(id);

		if (categoria.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		produtoRepository.deleteById(id);
	}
}