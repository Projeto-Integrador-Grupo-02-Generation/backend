package com.generation.kelp_project.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome_produto é obrigatório.")
	private String nome_produto;
	
	@NotBlank(message = "O atributo descricao_produto é obrigatório.")
	private String descricao_produto;
	
	@NotNull(message = "O atributo preco_produto é obrigatório.")
	@Digits(integer = 8, fraction = 2, message = "O atributo preco_produto deve deve conter no máximo 8 casas inteiras e 2 decimais.")
	private BigDecimal preco_produto;
	
	@NotNull(message = "O atributo estoque_produto é obrigatório.")
	private int estoque_produto;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public String getDescricao_produto() {
		return descricao_produto;
	}

	public void setDescricao_produto(String descricao_produto) {
		this.descricao_produto = descricao_produto;
	}

	public BigDecimal getPreco_produto() {
		return preco_produto;
	}

	public void setPreco_produto(BigDecimal preco_produto) {
		this.preco_produto = preco_produto;
	}

	public int getEstoque_produto() {
		return estoque_produto;
	}

	public void setEstoque_produto(int estoque_produto) {
		this.estoque_produto = estoque_produto;
	}
	

	
	
	//TODO Relacionar a Classe Model Produto com a Classe Model Categoria;
	// (Produto: ManyToOne e Categoria: OneToMany
	
	//TODO Relacionar a Classe Model de Produto com a Classe Model Usuario
	// (Produto: ManyToOne e Usuário: OneToMany)
}
