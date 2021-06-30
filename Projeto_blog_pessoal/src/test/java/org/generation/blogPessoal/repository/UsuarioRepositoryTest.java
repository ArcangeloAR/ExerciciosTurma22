package org.generation.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.model.repository.UsuarioRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // Anotação setando o ambiente de teste.
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Anotação de teste de instância, pois deverão ser intanciados objetos dentro, por exemplo, criar usuários, chamar os métodos do JPA, etc.
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository repository; // Injeção de dependência da classe que será feita o teste.
	
	@BeforeAll // Método utilizado antes dos testes
	void start() {
		Usuario usuario = new Usuario("Batatinha Testeira Testadora", "Usuario Batata Teste", "BatataTeste12345"); // Instanciando um novo usuário.
		if(repository.findByUsuario(usuario.getUsuario())!=null) // Verificando se este usuário já é existente no BD.
			repository.save(usuario); // Salvando o Usuario no BD.
		
		usuario = new Usuario("Batatao Testeira Testadora", "Usuario Batatao Teste", "BatataoTeste12345"); // Instanciando um novo usuário.
		if(repository.findByUsuario(usuario.getUsuario())!=null) // Verificando se este usuário já é existente no BD.
			repository.save(usuario); // Salvando o Usuario no BD.
		
		usuario = new Usuario("Testeira Testadora", "Usuario Testador", "TesteTestador12345"); // Instanciando um novo usuário.
		if(repository.findByUsuario(usuario.getUsuario())!=null) // Verificando se este usuário já é existente no BD.
			repository.save(usuario); // Salvando o Usuario no BD.
	}
	
	@Test
	public void findByUsuarioRetornoUsuario() throws Exception {
		Usuario usuario = repository.findByUsuario("Usuario Batata Teste").get(); // Procurando exatamente o nome do Usuario específico.
		assert(usuario.getUsuario().equals("Usuario Batata Teste")); // Utilizando o assert para validar se é igual ao valor (String) que deseja.
	}
	
	@Test
	public void findAllByUsuarioContainingIgnoreCaseRetornaTresUsuarios() { // Método para verificar se existem três Usuários com o mesmo nome.
		List<Usuario> listaDeUsuarios = repository.findAllByUsuarioContainingIgnoreCase("Teste"); // Instanciando uma nova lista para receber todos os Usuários que tem o determinado nome.
		assertEquals(listaDeUsuarios.size(), 3); // Comparando o tamanho do objeto listaDeUsuarios com o número 3.
	}
	
	@AfterAll // Notação de métodos para serem executados depois de todos os testes.
	public void end() {
		repository.deleteAll(); // Deletando todos os elementos do BD.
	}
	
}
