package org.generation.blogPessoal.service;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Tema;
import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.model.repository.TemaRepository;
import org.generation.blogPessoal.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TemaService {
	
	private @Autowired TemaRepository temaRepository;
	private @Autowired UsuarioRepository usuarioRepository;
	
	public ResponseEntity<List<Tema>> findAll() {
		List<Tema> listaDeTemas = temaRepository.findAll();
		
		if (listaDeTemas.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaDeTemas);
		}
	}
	
	public ResponseEntity<Tema> procurarTemaPorId(Long idTema) {
		return temaRepository.findById(idTema)
				.map(idTemaExistente -> ResponseEntity.status(200).body(idTemaExistente))
				.orElse(ResponseEntity.status(404).build());
	}
	
	public ResponseEntity<List<Tema>> procurarTemaPorDescricao(String descricaoTema) {
		List<Tema> listaDeTemas = temaRepository.findAllByDescricaoTemaContainingIgnoreCase(descricaoTema);
		
		if (listaDeTemas.isEmpty()) {
			return ResponseEntity.status(404).build();
		} else {
			return ResponseEntity.status(200).body(listaDeTemas);
		}
	}
	
	public ResponseEntity<Tema> criarTema(Long idUsuario, Tema novoTema) {
		Optional<Usuario> usuarioExiste = usuarioRepository.findById(idUsuario);
		Optional<Tema> temaExistente = temaRepository.findByDescricaoTema(novoTema.getDescricaoTema());
		
		if(usuarioExiste.isPresent() && temaExistente.isEmpty()) {
			return ResponseEntity.status(201).body(temaRepository.save(novoTema));
		} else {
			return ResponseEntity.status(406).build();
		}
	}
	
	public ResponseEntity<Tema> modificarTema(Long idUsuario, Tema novoTema) {
		Optional<Usuario> usuarioExiste = usuarioRepository.findById(idUsuario);
		Optional<Tema> temaExistente = temaRepository.findByDescricaoTema(novoTema.getDescricaoTema());
		
		if(usuarioExiste.isPresent() && temaExistente.isPresent()) {
			temaExistente.get().setDescricaoTema(novoTema.getDescricaoTema());
			return ResponseEntity.status(202).body(temaRepository.save(temaExistente.get()));
		} else {
			return ResponseEntity.status(406).build();
		}
	}
	
	public ResponseEntity<String> deletarTema(Long idTema) {
		Optional<Tema> idTemaExistente = temaRepository.findById(idTema);

		if (idTemaExistente.isEmpty()) {
			return ResponseEntity.status(400).body("Tema não localizado. Por favor tente outro.");
		} else {
			temaRepository.deleteById(idTema);
			return ResponseEntity.status(200).body("Tema deletado com sucesso!");
		}
	}
}
