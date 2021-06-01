package com.gameshop.gameshop.controller;

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

import com.gameshop.gameshop.model.Categorias;
import com.gameshop.gameshop.model.Produtos;
import com.gameshop.gameshop.repository.CategoriasRepository;
import com.gameshop.gameshop.repository.ProdutosRepository;
import com.gameshop.gameshop.service.CategoriasServices;

/*Utilizando apenas um controller e um service para Categorias e Produtos, pois para existir uma entidade produto, 
 * necessariamente, neste caso, deverá existir uma entidade categoria. Portanto, todos os end-point's 
 * foram colocados na classe CategoriasController e todos os services na classe CategoriasServices.
 */

@RestController

@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	private CategoriasRepository repositoryC;
	
	@Autowired
	private CategoriasServices servicesC;
	
	@Autowired
	private ProdutosRepository repositoryP;
	
	@GetMapping
	public ResponseEntity<List<Categorias>> pegarTodas(){
		List<Categorias> listaDeCategorias = repositoryC.findAll();
		
		if(listaDeCategorias.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaDeCategorias);
		}
	}
	
	@GetMapping("/id/{id_categoria}")
	public ResponseEntity<Optional<Categorias>> buscarCategoriaPorId(@PathVariable(value = "id_categoria") Long idCategoria) {
		Optional<Categorias> idDaCategoria = repositoryC.findById(idCategoria);
		
		if(idDaCategoria.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(idDaCategoria);
		}
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Object> buscarCategoriaPorNome(@RequestParam(defaultValue = "") String nomeCategoria) {
		List<Categorias> listaDeCategorias = repositoryC.findAllByNomeCategoriaContaining(nomeCategoria);
		
		if(listaDeCategorias.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaDeCategorias);
		}
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Object> salvarCategoria(@RequestBody Categorias novaCategoria) {
		return servicesC.cadastrarCategoria(novaCategoria)
				.map(verificaCategoria -> ResponseEntity.status(201).body(verificaCategoria))
				.orElse(ResponseEntity.status(400).body("Categoria já cadastrada. Por favor, tente outra."));
	}
	
	@PutMapping("/atualizar/{id_categoria}")
	public ResponseEntity<Object> atualizarCategoria(@PathVariable(value = "id_categoria") Long idCategoria, @Valid @RequestBody Categorias atualizacaoCategoria) {
		return servicesC.atualizarCategoria(idCategoria, atualizacaoCategoria)
				.map(categoriaAtualizada -> ResponseEntity.status(201).body(categoriaAtualizada))
				.orElse(ResponseEntity.status(400).body("Categoria já cadastrada. Por favor, tente outra."));
	}
	
	@DeleteMapping
	public void deletarCategoria(@RequestParam long idCategoria) {
		repositoryC.deleteById(idCategoria);
	}
	
	
	@PostMapping("/{id_categoria}/novo/produto")
	public ResponseEntity<Object> salvarProduto
	(@PathVariable(value = "id_categoria") Long idCategoria, @Valid @RequestBody Produtos novoProduto) {
		return servicesC.cadastrarProduto(idCategoria, novoProduto)
				.map(salvarNovoProduto -> ResponseEntity.status(201).body(salvarNovoProduto))
				.orElse(ResponseEntity.status(400).body("Produto já existente ou categoria inexistente. Por favor, verifique."));
	}
	
	@PutMapping("{id_categoria}/atualizar/produto/{id_produto}")
	public ResponseEntity<Object> atualizarProduto(@PathVariable(value = "id_categoria") Long idCategoria, @PathVariable(value = "id_produto") Long idProduto, @Valid @RequestBody Produtos atualizacaoProduto) {
		return servicesC.atualizarProduto(idCategoria, idProduto, atualizacaoProduto)
				.map(produtoAtualizado -> ResponseEntity.status(201).body(produtoAtualizado))
				.orElse(ResponseEntity.status(400).body("Produto já existente ou categoria inexistente. Por favor, verifique."));
	}
	
	@GetMapping("/produtos")
	public ResponseEntity<List<Produtos>> pegarTodos(){
		List<Produtos> listaDeProdutos = repositoryP.findAll();
		
		if(listaDeProdutos.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaDeProdutos);
		}
	}
	
	@GetMapping("/produtos/id/{id_produto}")
	public ResponseEntity<Optional<Produtos>> buscarProdutoPorId(@PathVariable(value = "id_produto") Long idProduto) {
		Optional<Produtos> idDoProduto = repositoryP.findById(idProduto);
		
		if(idDoProduto.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(idDoProduto);
		}
	}
	
	@GetMapping("/produtos/buscar")
	public ResponseEntity<Object> buscarProdutoPorNome(@RequestParam(defaultValue = "") String nomeProduto) {
		List<Produtos> listaDeProdutos = repositoryP.findAllByNomeProdutoContaining(nomeProduto);
		
		if(listaDeProdutos.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaDeProdutos);
		}
	}
	
	@DeleteMapping("/produtos/{id_produto}")
	public void deletarProduto(@PathVariable(value = "id_produto") long idProduto) {
		repositoryP.deleteById(idProduto);
	}
}
