package org.generation.blogPessoal.service;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostagemService {
	
	private @Autowired PostagemRepository postagemRepository;
	
	public ResponseEntity<List<Postagem>> findAll() {
		List<Postagem> listaDePostagens = postagemRepository.findAll();

		if(listaDePostagens.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaDePostagens);
		}
	}
	
	public ResponseEntity<Postagem> findByIdPostagem(long id) {
		return postagemRepository.findById(id)
				.map(resp -> ResponseEntity.status(200).body(resp))
				.orElse(ResponseEntity.status(204).build());
		}
	
	public ResponseEntity<List<Postagem>> findByTituloPostagem(String titulo) {
		List<Postagem> listaDePostagens = postagemRepository.findAllByTituloContainingIgnoreCase(titulo);
		
		if(listaDePostagens.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaDePostagens);
		}
	}
	
	public ResponseEntity<Postagem> efetuarPostagem(Postagem postagem) {
		return ResponseEntity.status(201).body(postagemRepository.save(postagem));
	}
	
	public ResponseEntity<Postagem> modificarPostagem(Postagem postagem) {
		return ResponseEntity.status(200).body(postagemRepository.save(postagem));
	}
	
	public void deletarPostagem(long id) {
		postagemRepository.deleteById(id);
	}
	
}
