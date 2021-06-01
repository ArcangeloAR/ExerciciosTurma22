package com.gameshop.gameshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gameshop.gameshop.model.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
	
	public Optional<Object> findByNomeProduto(String nomeProduto);
	
	public List<Produtos> findAllByNomeProdutoContaining(String nomeProduto);

	
}
