package com.farmacia.farmacia.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.farmacia.model.Categoria;
import com.farmacia.farmacia.model.Produto;
import com.farmacia.farmacia.repository.CategoriaRepository;
import com.farmacia.farmacia.repository.ProdutoRepository;
import com.farmacia.farmacia.services.CategoriaServices;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	private @Autowired CategoriaRepository repositoryC;
	private @Autowired CategoriaServices servicesC;
	private @Autowired ProdutoRepository repositoryP;
	
	
	@GetMapping
	public ResponseEntity<List<Categoria>> pegarTodas() {
		List<Categoria> listaDeCategorias = repositoryC.findAll();
		
		if(listaDeCategorias.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaDeCategorias);
		}
	}
	
	@GetMapping("/id/{id_categoria}")
	public ResponseEntity<Optional<Categoria>> buscarCategoriaPorId(@PathVariable(value = "id_categoria") Long idCategoria) {
		Optional<Categoria> idDaCategoria = repositoryC.findById(idCategoria);
		
		if(idDaCategoria.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(idDaCategoria);
		}
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Object> buscarCategoriaPorNome(@RequestParam(defaultValue = "") String nomeCategoria) {
		List<Object> listaDeCategorias = repositoryC.findAllByNomeCategoriaContaining(nomeCategoria);
		
		if(listaDeCategorias.isEmpty()) {
			return ResponseEntity.status(400).body("Não há nenhuma categoria com esse nome. Por favor, verifique.");
		} else {
			return ResponseEntity.status(200).body(listaDeCategorias);
		}
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Object> salvarNovaCategoria(@RequestBody Categoria novaCategoria) {
		return servicesC.cadastrarNovaCategoria(novaCategoria)
				.map(verificaCategoria -> ResponseEntity.status(201).body(verificaCategoria))
				.orElse(ResponseEntity.status(400).body("Categoria já cadastrada. Por favor, verifique."));
	}
	

	@PutMapping("/atualizar/{id_categoria}")
	public ResponseEntity<Object> remodelarCategoria(@PathVariable(value = "id_categoria") Long idCategoria, @Valid @RequestBody Categoria atualizacaoCategoria) {
		return servicesC.atualizarCategoria(idCategoria, atualizacaoCategoria)
				.map(categoriaAtualizada -> ResponseEntity.status(201).body(categoriaAtualizada))
				.orElse(ResponseEntity.status(400).body("Categoria já cadastrada. Por favor, tente outro nome."));
	}
	
	@DeleteMapping("/deletar")
	public ResponseEntity<String> deletarCategoria(@RequestParam Long idCategoria) {
		return servicesC.deletarIdCategoria(idCategoria)
				.map(categoriaDeletada -> ResponseEntity.status(400).body("Categoria não localizada. Por favor, tente outro id."))
				.orElse(ResponseEntity.status(200).body("Categoria deletada."));
	}
	
	
	
	
	@GetMapping("/produtos")
	public ResponseEntity<List<Produto>> pegarTodos() {
		List<Produto> listaDeProdutos = repositoryP.findAll();
		if(listaDeProdutos.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaDeProdutos);
		}
	}
	
	@GetMapping("/produtos/id/{id_produto}")
	public ResponseEntity<Optional<Produto>> buscarProdutoPorId(@PathVariable(value = "id_produto") Long idProduto) {
		Optional<Produto> idDoProduto = repositoryP.findById(idProduto);
		
		if(idDoProduto.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(idDoProduto);
		}
	}
	
	@GetMapping("produtos/buscar")
	public ResponseEntity<Object> buscarProdutoPorNome(@RequestParam(defaultValue = "") String nomeProduto) {
		List<Object> listaDeProdutos = repositoryP.findAllByNomeProdutoContaining(nomeProduto);
		
		if(listaDeProdutos.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaDeProdutos);
		}
	}
	
	@PostMapping("/{id_categoria}/novo/produto")
	public ResponseEntity<Object> salvarNovoProduto(@PathVariable(value = "id_categoria") Long idCategoriam, @RequestBody Produto novoProduto) {
		return servicesC.cadastrarNovoProduto(idCategoriam, novoProduto)
				.map(verificaProduto -> ResponseEntity.status(201).body(verificaProduto))
				.orElse(ResponseEntity.status(400).body("Produto já cadastrada ou categoria não cadastrada. Por favor, verifique."));
	}
	
	@PutMapping("/{id_categoria}/atualizar/produto/{id_produto}")
	public ResponseEntity<Object> atualizarProduto(@PathVariable(value = "id_categoria") Long idCategoria, @PathVariable(value = "id_produto") Long idProduto, @Valid @RequestBody Produto atualizacaoProduto) {
		return servicesC.atualizarProduto(idCategoria, idProduto, atualizacaoProduto)
				.map(produtoAtualizado -> ResponseEntity.status(201).body(produtoAtualizado))
				.orElse(ResponseEntity.status(400).body("Produto já cadastrada ou categoria não cadastrada. Por favor, verifique."));
	}

	
	@DeleteMapping("/deletar/produto")
	public ResponseEntity<String> deletarProduto(@RequestParam Long idCategoria, @RequestParam Long idProduto) {
		return servicesC.deletarIdProduto(idCategoria, idProduto)
				.map(produtoDeletado -> ResponseEntity.status(400).body("Produto ou categoria não localizados. Por favor, tente outro nome."))
				.orElse(ResponseEntity.status(200).body("Produto deletado."));
	}
}







