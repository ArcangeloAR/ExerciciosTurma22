package org.generation.blogPessoal.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // Anotação setando o ambiente de teste.
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Anotação de teste de instância, pois deverão ser intanciados objetos dentro, por exemplo, criar usuários, chamar os métodos do JPA, etc.
public class UsuarioControllerTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate; // Com essa injeção de dependência, é possível chamar uma rota específica e efetuar rollback, caso necessário.
	
	private Usuario usuario; //  Criando um objeto do tipo Usuario chamado usuario.
	private Usuario usuarioAlterado; // Criando um objeto do tipo Usuario chamado usuarioAlterado.
	
	@BeforeAll
	public void start() {
		usuario = new Usuario("Bora Testar", "Usuario Bora Testas", "teste123teste"); // Atribuindo valores para o objeto usuario, instanciando assim as informações necessárias da classe Usuario.
		usuarioAlterado = new Usuario("Bora Testar", "Usuario Bora Testas", "123teste123teste"); // Atribuindo valores para o objeto usuario, instanciando assim as informações necessárias da classe Usuario.
	}
	
	@Disabled // Disabilitar um teste para não ser executado
	@Test
	void deveSalvarUsuarioRetornaStatus201() {
		/*
		 * Criando um objeto do tipo HttpEntity para enviar como terceiro
		 * parâmetro do método exchange. (Enviando um objeto Usuario via body).
		 */
		
		HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuario); // Replicando o que o Postman faz, ou seja, efetuando as requisições. Isso é feito instanciando um objeto do tipo HttpEntity de Usuario chamado request que recebe a atribuição desse método (HttpEntity<Usuario>) recebendo o usuario (setado no @BeforeAll) como parâmetro.
		
		ResponseEntity<Usuario> resposta = testRestTemplate.exchange("/usuarios/cadastrar", HttpMethod.POST, request, Usuario.class); // Está sendo instanciado um objeto do tipo ResponseEntity de Usuario chamado resposta que recebe a atribuição o método exchange vindo do objeto testRestTemplate (da injeção de dependência da classe TestRestTemplate), recebendo como parâmetro o caminho da rota do controlador (se a rota necessitar de autenticação, deverá ser necessário inclui-la) , o verbo que será utilziado, os elementos que serão usados (aqui funciona como um body, utiliza-se o objeto request que está simulando o @RequestBody do Postman) e a classe de retorno, que será um Usuario.class, ou seja, uma classe de usuario. 
		assertEquals(resposta.getStatusCode(), HttpStatus.CREATED); // Verificando se o retorno do objeto resposta é igual ao status created.
	}
	
	@Disabled
	@Test
	void deveRetornarListaDeUsuariosRetorna200() {
		ResponseEntity<String> resposta = testRestTemplate.withBasicAuth("Bora Testar", "teste123teste") // Antes de utilizar o método exchange foi necessário passar o método withBasicAuth para efetuar a autenticação do usuario para o caminho, pois a solicitação de autenticação da URL foi feita na parte de Security, deve ser passado um usuario já existente, por isso foi utilizado o usuario criado no @BeforAll. Em seguida, vem o método exchange, passando o caminho, o verbo, como é um GET não precisa de elementos, e o retorno será um String.
				.exchange("/usuarios", HttpMethod.GET, null, String.class);
		assertEquals(resposta.getStatusCode(), HttpStatus.OK);
		
	}
	
	
	@Test
	void deveAtualizarSenhaUsuarioRetorna200() {
		/*
		 * Criando um objeto do tipo HttpEntity para enviar como terceiro
		 * parâmetro para o método exchange. (Enviando um objeto Usuario via body).
		 */
		
		HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuarioAlterado);
		
		ResponseEntity<Usuario> resposta = testRestTemplate.withBasicAuth("Bora Testar", "teste123teste")
		.exchange("/usuarios/alterar", HttpMethod.PUT, request, Usuario.class);
		assertEquals(resposta.getStatusCode(), HttpStatus.CREATED);
	}

}
