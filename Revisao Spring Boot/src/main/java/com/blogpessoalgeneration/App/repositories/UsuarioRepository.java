package com.blogpessoalgeneration.App.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogpessoalgeneration.App.models.Usuario;

// Interface de repositórios onde é extendida da Jpa, que é uma Interface que contém diversos métodos já prontos e úteis.

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { // JpaRepository solicita 2 argumentos, entidade (usuário) e o Id (tipo do Id)
	
	// Jpa por padrão já tem o findById, é necessário criar outros findBy, caso precise de outras validações
	
	// Sobrescrevendo (criando um novo) método findBy: List<User> findByColunaQueEuQuero(TipoDaColuna coulaQueEuQuero);

	// Existem diversas formas de escrever utiizando operadores lógicos ou informações da query (tabela) como Between. Para esses casos, deve ser passado mais de um parâmetro: findByColunaQueEuQueroAndOutraColunaQueEuQuero(TipoDaColuna coulaQueEuQuero, TipoDaColuna OutraColunaQueEuQuero);

	public Optional<Object> findByNome(String nome); // Este é o método que está sobrescrevendo o findBy e poderá ser utilizado agora no Controller como qualquer método convencional, prestar atenção que o retorno dele é um Optional com um único usuário e não uma lista deles.
	
	List<Usuario> findAllByNomeContaining(String nome); // Método que retona uma lista utilizando um like no nome.

	public Optional<Object> findByUsuarioIgnoreCase(String usuario);

	
}
	