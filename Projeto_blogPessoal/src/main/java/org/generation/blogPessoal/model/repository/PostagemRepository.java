package org.generation.blogPessoal.model.repository;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> { //Postagem = modelo
	
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo); // Titulo = Nome do atributo da entidade. Countaining = like.
	
}
