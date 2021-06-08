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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/tema")
public class TemaController {
	
	
	private @Autowired TemaService temaService;
	
	@GetMapping
	public ResponseEntity<List<Tema>> getAll(){
		return temaService.findAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Tema> GetById(@PathVariable long idTema){
		return temaService.procurarTemaPorId(idTema);
	}
	
	@GetMapping("/titulo")
	public ResponseEntity<List<Tema>> getByDescricaoTema(@RequestParam String descricaoTema) {
		return temaService.procurarTemaPorDescricao(descricaoTema);
	}
	
	@PostMapping("/{id_usuario}")
	public ResponseEntity<Tema> elaborarTema(@PathVariable(value = "id_usuario") Long idUsuario, @RequestBody Tema novoTema) {
		return temaService.criarTema(idUsuario, novoTema);
	}
	
	@PutMapping("/{id_usuario}/modificar/tema")
	public ResponseEntity<Tema> alterarTema(@PathVariable(value = "id_usuario") Long idUsuario, @RequestBody Tema novoTema){
		return temaService.modificarTema(idUsuario, novoTema);
	}
	
	@DeleteMapping("/{id_tema}")
	public ResponseEntity<String> deletar(@PathVariable(value = "id_tema") Long idTema) {
		return temaService.deletarTema(idTema);
	}
	
}
