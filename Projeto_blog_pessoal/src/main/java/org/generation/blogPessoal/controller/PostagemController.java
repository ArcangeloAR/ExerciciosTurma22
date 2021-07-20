package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.service.PostagemService;
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
import org.springframework.web.bind.annotation.RestController;


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
	
	@GetMapping("/{id}")
	public ResponseEntity <Postagem> GetById (@PathVariable(value = "id") long id) {
		return postagemService.findByIdPostagem(id);
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable(value = "titulo") String titulo) {
		return postagemService.findByTituloPostagem(titulo);
	}
	
	@PostMapping
	public ResponseEntity<Postagem> post(@RequestBody Postagem postagem){
		return postagemService.efetuarPostagem(postagem);
	}
	
	@PutMapping
	public ResponseEntity<Postagem> put(@RequestBody Postagem postagem){
		return postagemService.modificarPostagem(postagem);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") long id) {
		postagemService.deletarPostagem(id);
	}	
}
