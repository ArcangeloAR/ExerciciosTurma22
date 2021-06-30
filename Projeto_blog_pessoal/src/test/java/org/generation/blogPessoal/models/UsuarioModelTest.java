/*
Ambiente de testes é separado

1. Colocar a dependência:
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<exclusions>
				<exclusion>
					<groupId>org.junit.vintage</groupId>
					<artifactId>junit-vintage-engine</artifactId>
				</exclusion>
			</exclusions>
		</dependency>

2. Criar um folder de teste em src/test/resource
3. Criar um novo file application.properties (para criar um DB para teste)
4. Criar novos packages de acordo com a aplicação do main, ou seja, replicar em teste as packages do main.
5. Criar agora as classes de teste, de acordo com as classes que você deseja testar. Ir no package e criar um "JUnit Test Case". Por exemplo: UsuarioModelTest.
6. Criar os métodos de teste.
*/

package org.generation.blogPessoal.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // Criando e setando um ambiente pra testes. o webEnvironment faz uma varredura e utiliza uma porta que não esteja sendo utilziada.
class UsuarioModelTest {
	
	public Usuario usuario; // Como o teste será feito na model Usuario, é necessário instancia-la.
	
	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory(); // Colocando a injeção de dependência da classe ValidatorFactory (que veio da biblioteca Validation) para trabalhar com a parte de validação. O método que Validation está recebendo, ele monta o erro quando ocorrer e nos mostra, é um validador.
	Validator validator = factory.getValidator();
	
	
	@BeforeEach // Notação utilizada para efetuar uma ação antes de começar o teste
	public void start() { // Método normalmente chamado start, nesse caso ele é void e cria um novo usuário.
		usuario = new Usuario("Testeiro Testador", "Usuario Teste", "Teste12345"); // Está sendo instanciado um novo usuário. Se não houver construtor, será necessário cria-lo.
	}
	
	@Test // Todo o método de teste deve ter a notação @Test que diz para o Java que esse método deve ser executado como um teste.
	void testValidarAtributos() { // Escrever o nome da função de forma semântica para indicar exatamente o que o teste faz.
		Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuario); // Está sendo instanciado um objeto chamado violacao do tipo Set (que é um tipo de lista) do tipo ConstraintViolation, ou seja, violação de restrição de Usuario. O objeto está recebendo um chaamdo do método validate do objeto validador (vindo de injeção de dependência) e sendo passado como parâmetro o usuário que foi instanciado no @BeforeEach.
		System.out.println(violacao.toString()); //  Imprimindo na tela a lista (set) violacao transformada em String.
		assertTrue(violacao.isEmpty()); // Os asserts são os métodos utilizados para verificação, funcionam como um return da validação, nesse caso, ele espera que receberá um valor "true". Dentro do método assertTrue foi passado como parâmetro o objeto violacao com o método isEmpty(), isso ocorreu para efetuar a verificação se a lista do objeto está vazia. Se estiver vazia não há erro, porque o método validate encontrará o erro e armazenará na lista do objeto violacao, ou seja, se ela estiver vazia, o método foi executado e nenhum erro foi guardado, ou seja, está sem erros.
	}
	
	@Test
	void testValidarAtributosNulos() {
		Usuario usuarioErro = new Usuario(); // Instanciando um novo Usuario;
		usuarioErro.setUsuario("Batatinha Testeira Testadora"); // Está sendo instanciado um Usuario sem a senha. Como a senha tem a notação @NotNull, sabemos que está com erro.
		Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuario); // Instanciando o objeto para verificação;
		System.out.println(violacao.toString()); // Imprimindo em tela.
		assertFalse(violacao.isEmpty()); // Como sabemos que há um erro pois não foi passada a senha, o método violacao.isEmpty() retornará um false, que é exatamente o que se espera no assertFalse, ou seja, o teste não deve dar erro.
	}

}
