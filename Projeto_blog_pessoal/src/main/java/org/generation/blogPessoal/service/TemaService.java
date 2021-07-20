package org.generation.blogPessoal.service;

import java.util.List;

import org.generation.blogPessoal.model.Tema;
import org.generation.blogPessoal.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TemaService {
	
	private @Autowired TemaRepository temaRepository;
	
	public ResponseEntity<List<Tema>> findAll() {
		List<Tema> listaDeTemas = temaRepository.findAll();
		
		if(listaDeTemas.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaDeTemas);
		}
	}
	
	public ResponseEntity<Tema> findByIdTema(long id) {
		return temaRepository.findById(id)
				.map(resp -> ResponseEntity.status(200).body(resp))
				.orElse(ResponseEntity.status(204).build());
	}
	
	public ResponseEntity<List<Tema>> findByDescricaoTema(String descricao) {
		List<Tema> listaDeTemas = temaRepository.findAllByDescricaoContainingIgnoreCase(descricao);
		
		if(listaDeTemas.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaDeTemas);
		}
	}
	
	public ResponseEntity<Tema> cadastrarTema(Tema tema) {
		return ResponseEntity.status(201).body(temaRepository.save(tema));
	}
	
	public ResponseEntity<Tema> modificarTema(Tema tema) {
		return ResponseEntity.status(200).body(temaRepository.save(tema));
	}
	
	public void deletarPostagem(long id) {
		temaRepository.deleteById(id);
	}
	
	
}
