package com.gameshop.gameshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameshop.gameshop.model.Categorias;
import com.gameshop.gameshop.model.Produtos;
import com.gameshop.gameshop.repository.CategoriasRepository;
import com.gameshop.gameshop.repository.ProdutosRepository;

@Service
public class CategoriasServices {
	
	@Autowired
	private CategoriasRepository repositoryC;
	
	@Autowired
	private ProdutosRepository repositoryP;
	
	
	/**
	 * Método utilizado para cadastrar uma nova categoria no sistema, validando sua existência.
	 * @param novaCategoria
	 * @return Optional vazio ou com entidade Categoria dentro.
	 * @since 1.0
	 * @author ArcangeloAR
	 */
	public Optional<Object> cadastrarCategoria(Categorias novaCategoria) {
		Optional<Object> categoriaExistente = repositoryC.findByNomeCategoria(novaCategoria.getNomeCategoria());
		if(!categoriaExistente.isEmpty()) {
			return Optional.empty();
		} else {
			return Optional.ofNullable(repositoryC.save(novaCategoria));
		}
	}
	
	
	/**
	 * Método utilizado para atualizar os campos de nome e jogabilidade da categoria, validando se outra categoria já detém o novo nome escolhido.
	 * @param idCategoria
	 * @param atualizacaoCategoria
	 * @return Retorna um Optional com entidade Categoria atualizada, caso ela já exista. Caso contrário, um Optional vazio.
	 * @since 1.0
	 * @author ArcangeloAR
	 */
	public Optional<Object> atualizarCategoria(Long idCategoria, Categorias atualizacaoCategoria) {
		Optional<Categorias> idCategoriaExistente = repositoryC.findById(idCategoria);
		Optional<Object> nomeCategoriaExistente = repositoryC.findByNomeCategoria(atualizacaoCategoria.getNomeCategoria());
		
		if(idCategoriaExistente.isPresent() && nomeCategoriaExistente.isEmpty()) {
			idCategoriaExistente.get().setNomeCategoria(atualizacaoCategoria.getNomeCategoria());
			idCategoriaExistente.get().setJogabilidade(atualizacaoCategoria.getJogabilidade());
			return Optional.ofNullable(repositoryC.save(idCategoriaExistente.get()));
		} else {
			return Optional.empty();	
		}
	}
	
	
	/**
	 * Método utilizado para cadastrar um novo produto no sistema, validando sua existência e a da categoria.
	 * @param idCategoria
	 * @param novoProduto
	 * @return Optional vazio ou com entidade Produto dentro.
	 * @since 1.0
	 * @author ArcangeloAR
	 */
	public Optional<Object> cadastrarProduto(Long idCategoria, Produtos novoProduto){
		Optional<Categorias> categoriaExistente = repositoryC.findById(idCategoria);
		Optional<Object> produtoExistente = repositoryP.findByNomeProduto(novoProduto.getNomeProduto());
		if(categoriaExistente.isPresent() && !produtoExistente.isPresent()) {
			novoProduto.setGerador(categoriaExistente.get());
			return Optional.ofNullable(repositoryP.save(novoProduto));
		} else {
			return Optional.empty();
		}
	}
	
	
	/**
	 * Método utilizado para atualizar os campos de nome do produto e da desenvolvedora do produto, validando se outra categoria já detém o novo nome escolhido e validando se a categoria é existente.
	 * @param idCategoria
	 * @param idProduto
	 * @param atualizacaoProduto
	 * @return Retorna um Optional com entidade Produto atualizado, caso ele já exista. Caso contrário, um Optional vazio.
	 * @since 1.0
	 * @author ArcangeloAR
	 */
	public Optional<Object> atualizarProduto(Long idCategoria, Long idProduto, Produtos atualizacaoProduto){
		Optional<Categorias> categoriaExistente = repositoryC.findById(idCategoria);
		Optional<Produtos> produtoExistente = repositoryP.findById(idProduto);
		Optional<Object> nomeProdutoExistente = repositoryP.findByNomeProduto(atualizacaoProduto.getNomeProduto());
		
		
		if(categoriaExistente.isPresent() && produtoExistente.isPresent() && nomeProdutoExistente.isEmpty()) {
			produtoExistente.get().setNomeProduto(atualizacaoProduto.getNomeProduto());
			produtoExistente.get().setNomeDesenvolvedora(atualizacaoProduto.getNomeDesenvolvedora());
			return Optional.ofNullable(repositoryP.save(produtoExistente.get()));
		} else {
			return Optional.empty();
		}
	}
}


