package com.farmacia.farmacia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.farmacia.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public List<Object> findAllByNomeProdutoContaining(String nomeProduto);
	
	public Optional<Object> findByNomeProduto(String nomeProduto);
	
}
