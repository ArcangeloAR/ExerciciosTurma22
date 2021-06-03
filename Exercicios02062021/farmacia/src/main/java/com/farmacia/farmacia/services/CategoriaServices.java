package com.farmacia.farmacia.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmacia.farmacia.model.Categoria;
import com.farmacia.farmacia.model.Produto;
import com.farmacia.farmacia.repository.CategoriaRepository;
import com.farmacia.farmacia.repository.ProdutoRepository;

@Service
public class CategoriaServices {
	
	private @Autowired CategoriaRepository repositoryC;
	private @Autowired ProdutoRepository repositoryP;
	
	public Optional<Object> cadastrarNovaCategoria(Categoria novaCategoria) {
		Optional<Object> categoriaExistente = repositoryC.findByNomeCategoria(novaCategoria.getNomeCategoria());
		
		if(categoriaExistente.isPresent()) {
			return Optional.empty();
		} else {
			return Optional.ofNullable(repositoryC.save(novaCategoria));
		}
	}

	
	public Optional<Object> atualizarCategoria(Long idCategoria, Categoria atualizacaoCategoria){
		Optional<Categoria> idCategoriaExistente = repositoryC.findById(idCategoria);
		Optional<Object> nomeCategoriaExistente = repositoryC.findByNomeCategoria(atualizacaoCategoria.getNomeCategoria());
		
		if(idCategoriaExistente.isPresent() && nomeCategoriaExistente.isEmpty()) {
			idCategoriaExistente.get().setNomeCategoria(atualizacaoCategoria.getNomeCategoria());
			idCategoriaExistente.get().setTipo(atualizacaoCategoria.getTipo());
			return Optional.ofNullable(repositoryC.save(idCategoriaExistente.get()));
		} else {
			return Optional.empty();
		}
	}
	
	public Optional<Object> deletarIdCategoria(Long idCategoria){
		Optional<Categoria> idCategoriaExistente = repositoryC.findById(idCategoria);
		
		if(idCategoriaExistente.isEmpty()) {
			return Optional.ofNullable(idCategoriaExistente);
		} else {
			repositoryC.deleteById(idCategoria);
			return Optional.empty();
		} 
		
	}
	
	
	public Optional<Object> cadastrarNovoProduto(Long idCategoria, Produto novoProduto) {
		Optional<Categoria> idCategoriaExistente = repositoryC.findById(idCategoria);
		Optional<Object> produtoExistente = repositoryP.findByNomeProduto(novoProduto.getNomeProduto());
		
		if(idCategoriaExistente.isPresent() && produtoExistente.isEmpty()) {
			novoProduto.setGerador(idCategoriaExistente.get());
			return Optional.ofNullable(repositoryP.save(novoProduto));
		} else {
			return Optional.empty();
		}
	}
	
	public Optional<Object> atualizarProduto(Long idCategoria, Long idProduto, Produto atualizacaoProduto){
		Optional<Categoria> idCategoriaExistente = repositoryC.findById(idCategoria);
		Optional<Produto> idProdutoExistente = repositoryP.findById(idProduto);
		Optional<Object> nomeProdutoExistente = repositoryP.findByNomeProduto(atualizacaoProduto.getNomeProduto());
		
		if(idCategoriaExistente.isPresent() && idProdutoExistente.isPresent() && nomeProdutoExistente.isEmpty()) {
			idProdutoExistente.get().setNomeProduto(atualizacaoProduto.getNomeProduto());
			idProdutoExistente.get().setPreco(atualizacaoProduto.getPreco());
			return Optional.ofNullable(repositoryP.save(idProdutoExistente.get()));
		} else {
			return Optional.empty();
		}
	}
	
	public Optional<Object> deletarIdProduto(Long idCategoria, Long idProduto){
		Optional<Categoria> idCategoriaExistente = repositoryC.findById(idCategoria);
		Optional<Produto> idProdutoExistente = repositoryP.findById(idProduto);
		
		if(idCategoriaExistente.isEmpty() || idProdutoExistente.isEmpty()) {
			return Optional.ofNullable(idProdutoExistente);
		} else {
			repositoryP.deleteById(idProduto);
			return Optional.empty();
		} 
		
	}
}
