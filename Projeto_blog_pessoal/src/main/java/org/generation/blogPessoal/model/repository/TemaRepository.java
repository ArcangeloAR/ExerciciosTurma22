package org.generation.blogPessoal.model.repository;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<Tema, Long>{
	
	public List<Tema> findAllByDescricaoTemaContainingIgnoreCase(String descricaoTema);
	
	public Optional<Tema> findByDescricaoTema(String descricaoTema);
	
}
