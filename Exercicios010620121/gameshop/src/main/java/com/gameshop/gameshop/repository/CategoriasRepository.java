package com.gameshop.gameshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gameshop.gameshop.model.Categorias;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
	
	public Optional<Object> findByNomeCategoria(String nomeCategoria);
	
	public List<Categorias> findAllByNomeCategoriaContaining(String nomeCategoria);
	
}
