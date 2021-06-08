package org.generation.blogPessoal.service;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.model.Tema;
import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.model.repository.PostagemRepository;
import org.generation.blogPessoal.model.repository.TemaRepository;
import org.generation.blogPessoal.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostagemService {
	
	private @Autowired PostagemRepository postagemRepository;
	private @Autowired TemaRepository temaRepository;
	private @Autowired UsuarioRepository usuarioRepository;
	
	public ResponseEntity<List<Postagem>> findAll() {
		List<Postagem> listaDePostagens = postagemRepository.findAll();
		
		if (listaDePostagens.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaDePostagens);
		}
	}
	
	public ResponseEntity<Postagem> procurarPostagemPorId(Long idPostagem) {
		return postagemRepository.findById(idPostagem)
				.map(idPostagemExistente -> ResponseEntity.status(200).body(idPostagemExistente))
				.orElse(ResponseEntity.status(404).build());
	}
	
	public ResponseEntity<List<Postagem>> procurarPostagemPorTitulo(String titulo) {
		List<Postagem> listaDePostagens = postagemRepository.findAllByTituloContainingIgnoreCase(titulo);
		
		if (listaDePostagens.isEmpty()) {
			return ResponseEntity.status(404).build();
		} else {
			return ResponseEntity.status(200).body(listaDePostagens);
		}
	}
	
	public ResponseEntity<Postagem> efetuarPostagem(Long idUsuario, String descricaoTema, Postagem novaPostagem) {
		Optional<Usuario> usuarioExiste = usuarioRepository.findById(idUsuario);
		Optional<Tema> temaExistente = temaRepository.findByDescricaoTema(descricaoTema);
		
		if(usuarioExiste.isPresent() && temaExistente.isPresent()) {
			novaPostagem.setTema(temaExistente.get());
			return ResponseEntity.status(201).body(postagemRepository.save(novaPostagem));
		} else {
			return ResponseEntity.status(406).build();
		}
	}
	
	public ResponseEntity<Postagem> modificarPostagem(Long idUsuario, Long idPostagem, String descricaoTema, Postagem novaPostagem) {
		Optional<Usuario> usuarioExiste = usuarioRepository.findById(idUsuario);
		Optional<Postagem> postagemExistente = postagemRepository.findById(idPostagem);
		Optional<Tema> temaExistente = temaRepository.findByDescricaoTema(descricaoTema);
		
		if(usuarioExiste.isPresent() && postagemExistente.isPresent() && temaExistente.isPresent()) {
			postagemExistente.get().setTema(novaPostagem.getTema());
			postagemExistente.get().setTexto(novaPostagem.getTexto());
			postagemExistente.get().setTitulo(novaPostagem.getTitulo());
			return ResponseEntity.status(202).body(postagemRepository.save(postagemExistente.get()));
		} else {
			return ResponseEntity.status(406).build();
		}
	}
	
	public ResponseEntity<String> deletarPostagem(Long idPostagem) {
		Optional<Postagem> idPostagemExistente = postagemRepository.findById(idPostagem);

		if (idPostagemExistente.isEmpty()) {
			return ResponseEntity.status(400).body("Postagem não localizada. Por favor tente outra.");
		} else {
			postagemRepository.deleteById(idPostagem);
			return ResponseEntity.status(200).body("Postagem deletada com sucesso!");
		}
	}
}
