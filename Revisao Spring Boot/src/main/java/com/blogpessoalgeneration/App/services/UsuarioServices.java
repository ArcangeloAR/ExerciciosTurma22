package com.blogpessoalgeneration.App.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogpessoalgeneration.App.models.Usuario;
import com.blogpessoalgeneration.App.repositories.UsuarioRepository;

// Camada de desenvolvimento Services, utilizada quando qualquer método altere a estrutura do DB (criar, modificar, deletar, etc.) e para introduzir as regras de negócio.

@Service
public class UsuarioServices {
	
	private @Autowired UsuarioRepository repository;
	
	// Abaixo podemos ver uma documentação feita para facilitar o entendimento do método, os parâmetros, seu retorno, etc. Para fazer isso /** e enter
	
	/**
	 * Método utilizado para cadastrar um novo usuário no sistema, validando sua existência.
	 * @param novoUsuario
	 * @since 1.0
	 * @return Optional vazio ou com entidade Usuario dentro
	 * @author Angelo
	 */
	
	public Optional<Object> cadastrarUsuario(Usuario novoUsuario){
		Optional<Object> usuarioExistente = repository.findByNome(novoUsuario.getUsuario()); // Está sendo instanciado um objeto chamado usuarioExistente onde ele recebe o Usuario a partir do método findByUsuario criado no Repository (observar que o parâmetro que o findByUsuario necessita é o novoUsuario que está sendo passado no começo desse método, e para conseguir pegar efetivamente o usuario é utilizado o método .getUsuario(). Aqui, ele verifica se um usuário existe, ou seja, se ele encontrar algum usuario igual, é o que ele irá retornar.
		// O método acima faz a pesquisa no DB e ele retorna um Optional, agora é necessário escrever um código pra saber se têm algo lá dentro
		
		if(usuarioExistente.isPresent()) { // Aqui ele está verificando se há alguma coisa no objeto usuarioExistente.
			return Optional.empty(); // Caso exista o usuario, será retornado um optional vazio
		}else {
			return Optional.ofNullable(repository.save(novoUsuario)); // Caso não exista, será criado um optional com esse novo usuário.
		}
	}
	
	/**
	 * Utilizada para atualizar os campos de nome e senha do usuário.
	 * @param idUsuario - Long idUsuario
	 * @param atualizacaoUsuario - Entidade Usuário
	 * @author Angelo
	 * @since 1.0
	 * @return Retorna um Optional com entidade Usuario, caso ele exista. Caso contrário, um Optional vazio.
	 */
	public Optional<Usuario> atualizarUsuario(Long idUsuario, Usuario atualizacaoUsuario){ // Atualização do nome e senha do usuário. O método retornará um optional. Os parâmetros pedidos são o idUsuario porque é possível pesquisar o elemento no DB, se ele existir, o retorno é a atualização dos campos (atributos), por isso o outro parâmetro são os dados atualizados, ou seja, atualizacaoUsuario. Se ele não existir, será apenas uma mensagem avisando que o Usuário não é existente. Uma outra forma que poderia ser feita é não passar o Id como parâmetro e pegar no usuário seu Id, porém é necessário pensar que o front-end trabalhará com todas as informações do usuário pra saber colher essa informação, por isso é necessário ter uma relação estreita com o front.
		Optional<Usuario> usuarioExistente = repository.findById(idUsuario); // Está sendo instanciado um objeto chamado usuarioExistente onde ele recebe o nº do Id a partir do método findById que foi extendido de Repository que foi extendido de Jpa. Aqui, ele verifica se o idUsuario existe, ou seja, se ele encontrar algum id igual, é o que ele irá retornar.
		if(usuarioExistente.isPresent()) { // Separando os retornos a partir da verificação se o id existe dentro do DB, isso ocorre utilizando a função isPresent().
			usuarioExistente.get().setNome(atualizacaoUsuario.getNome()); // Aqui é utilizado o método .get() retornando o Optional, conforme a criação do objeto usuarioExistente. Em seguida, é passado o método setNome() com o parâmetro atualizacaoUsuario e o método .getNome(), para efetuar efetivamente a atualização do nome a partir do novo nome passado pelo parâmetro atualizacaoUsuario que deverá ser passado pelo front.
			usuarioExistente.get().setSenha(atualizacaoUsuario.getSenha()); // Aqui deverá ser feito o mesmo método utilizando o mesmo tipo de parâmetro, mas com o objetivo de alterar a senha.
			return Optional.ofNullable(repository.save(usuarioExistente.get())); // Necessário criar um Optional porque o método solicita um retorno de um Optional. O método ofNullable pede que seja passada uma entidade como parâmetro, essa entidade deverá ser o usuarioExistente atualizado, portanto é utilizado o método repository.save e como parâmetro o usuarioExistente que foi o objeto (entidade) que teve as informações atualizadas utilizando os métodos acima e é necessário utilizar o método .get() para pegar essas modificações.
			// Acima, só foi permitida a modificação de dois campos, nome e senha, por regra de negócio. O campo usuário não foi conforme regra de negócio.
		} else {
			return Optional.empty(); // Aqui como não foi encontrado um usuário, foi retornado um Optional vazio.
		}
	}
	
	
}
