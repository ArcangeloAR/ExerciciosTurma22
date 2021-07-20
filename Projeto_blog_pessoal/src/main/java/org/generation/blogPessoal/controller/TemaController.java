package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.Tema;
import org.generation.blogPessoal.service.TemaService;
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
@RequestMapping("/tema")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class TemaController {
	
	@Autowired
	private TemaService temaService;
	
	@GetMapping
	public ResponseEntity<List<Tema>> getAll (){
		return temaService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Tema> getById (@PathVariable(value="id") long id){
		return temaService.findByIdTema(id);
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity <List<Tema>> getByNome (@PathVariable(value="descricao") String descricao){
		return temaService.findByDescricaoTema(descricao);
	}
	
	@PostMapping
	public ResponseEntity<Tema> post (@RequestBody Tema tema){
		return temaService.cadastrarTema(tema);
	}
	
	@PutMapping
	public ResponseEntity<Tema> put (@RequestBody Tema tema){
		return temaService.modificarTema(tema);
	}
	
	@DeleteMapping ("/{id}")
	public void delete (@PathVariable(value="id") long id) {
		temaService.deletarPostagem(id);
	}
}
