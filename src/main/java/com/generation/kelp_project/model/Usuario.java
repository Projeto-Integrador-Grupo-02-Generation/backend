package com.generation.kelp_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome_usuario é obrigatório.")
	@Size(min = 5, max = 100, message = "O atributo nome_usuario deve conter no mínimo 5 e no máximo 100 caracters.")
	private String nome_usuario;
	
	@NotBlank(message = "O atributo email é obrigatório.")
	@Size(min = 5, max = 100, message = "O atributo email_usuario deve conter no mínimo 5 e no máximo 100 caracters.")
	private String email_usuario;
	
	@NotBlank(message = "O atributo senha é obrigatório.")
	@Size(min = 5, max = 100, message = "O atributo senha_usuario deve conter no mínimo 5 e no máximo 100 caracters.")
	private String senha_usuario;
	
	private String foto_usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	public String getSenha_usuario() {
		return senha_usuario;
	}

	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}

	public String getFoto_usuario() {
		return foto_usuario;
	}

	public void setFoto_usuario(String foto_usuario) {
		this.foto_usuario = foto_usuario;
	}
	
	
}
