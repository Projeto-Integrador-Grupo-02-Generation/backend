package com.generation.kelp_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.kelp_project.model.CategoriaModel;


public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
	
	
}
