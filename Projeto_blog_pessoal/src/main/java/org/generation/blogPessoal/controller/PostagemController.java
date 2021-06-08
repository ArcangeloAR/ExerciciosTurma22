package org.generation.blogPessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.service.PostagemService;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {
	
	@Autowired
	private PostagemService postagemService;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll(){
		return postagemService.findAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable Long idPostagem){
		return postagemService.procurarPostagemPorId(idPostagem);
	}
	
	@GetMapping("/titulo")
	public ResponseEntity<List<Postagem>> getByTitulos(@RequestParam String titulo) {
		return postagemService.procurarPostagemPorTitulo(titulo);
	}
	
	@PostMapping("/{id_usuario}")
	public ResponseEntity<Postagem> efetuarPostagem(@PathVariable(value = "id_usuario") Long idUsuario, @RequestBody String descricaoTema, @RequestBody Postagem novaPostagem) {
		return postagemService.efetuarPostagem(idUsuario, descricaoTema, novaPostagem);
	}
	
	@PutMapping("/{id_usuario}/{id_postagem}")
	public ResponseEntity<Postagem> alterarPostagem(@PathVariable(value = "id_usuario") Long idUsuario, @PathVariable(value = "id_postagem") Long idPostagem, @RequestBody String descricaoTema, @RequestBody Postagem novaPostagem){
		return postagemService.modificarPostagem(idUsuario, idPostagem, descricaoTema, novaPostagem);
	}
	
	@DeleteMapping("/{id_postagem}")
	public ResponseEntity<String> deletar(@PathVariable(value = "id_postagem") Long idPostagem) {
		return postagemService.deletarPostagem(idPostagem);
	}
	
}
