package com.blogpessoalgeneration.App.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.blogpessoalgeneration.App.models.Usuario;
import com.blogpessoalgeneration.App.repositories.UsuarioRepository;
import com.blogpessoalgeneration.App.services.UsuarioServices;

@RestController // Criação de uma interface para ter acesso aos objetos do servidor
@RequestMapping("/api/usuarios") // Caminho da URL
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository; // A partir da notação do @Autowired, está sendo feita uma injeção de dependência, ou seja, uma conexão entre essa classe e a UsuarioRepository sendo nomeada como repository para serem puxados os métodos.
	
	private @Autowired UsuarioServices services; // A injeção de usuário pode ser feito da forma de cima ou dessa.
	
	@GetMapping //Verbo de acesso que o usuário vai passar para utilizar esse método. Se não houver outro URL, pegará a partir do RequestMapping.
	public List<Usuario> pegarTodes(){ // Método publico chamado pegarTodes que espera uma Lista de usuários como retorno.
		return repository.findAll(); // O findAll devolve uma lista, conforme solicitado pelo método. Essa lista é de Usuários, pois foi isso que foi definido no Repository (nesse pedaço JpaRepository<Usuario, Long>). Isto é uma regra de negócio.
	}
	
	@GetMapping("/t") // Este método é igual o de cima, só coloquei para testar uma rota e para utilizar o ResponseEntity
	public ResponseEntity<List<Usuario>> pegarTodesUsers(){ // Neste método, está sendo solicitado agora um retorno de ResponseEntity com uma lista em vez de só uma lista. 
		return ResponseEntity.status(202).body(repository.findAll()); // Retornando o ResponseEntity com o status que deseja que apareça, onde o médoto findAll será construído no body, ou seja, apareça na tela do site. A diferença desse método para o de cima é que o de cima, por default, retornará o stauts 200, enquanto que neste método com ResponseEntity a saída poderá ser manipulada.
	}
	
	/*Existem 3 formas de passar status (exemplo abaixo, 202 - Acepted):
		- return ResponseEntity.status(202).body(repository.findAll())
		- return ResponseEntity.status(HttpStatus.ACCEPTED).body(repository.findAll())
		- return ResponseEntity.accepted(repository.findAll());
	*/
	
	// Compare os dois GetMapping acima no Postman para ver suas diferenças.
	
	// Também poderá ser feito de outras formas utilizando IfElse e Optional:
	
	@GetMapping("/todes")
	public ResponseEntity<List<Usuario>> pegarTodesUsuarios(){
		List<Usuario> listaDeUsuario = repository.findAll(); // Instanciando um novo objeto chamado listaDeUsuarios que recebe a lista de usuarios do repositório. Isso é utilizado para que a manipulação da lista fique mais fácil.
		if(!listaDeUsuario.isEmpty()) { // IfElse não é uma forma elegante, mas poderá ser usada. O ! é apenas um operador not, ou seja, se a lista NÃO estiver vazia é o verdadeiro, se não, é o falso. Aqui o método está verificando se existem usuários, ou seja, se a lista não está vazia.
			return ResponseEntity.status(200).body(listaDeUsuario);
		}else {
			return ResponseEntity.status(204).build(); // O build é apenas para construir no site, NÃO aparece na tela, apenas aparece o status no F12 do Chrome.
		}
	}
	
	@PostMapping("/s") // Neste método está apenas criando um novo usuário sem validação se já é existente.
	public Usuario salvarUs(@Valid @RequestBody Usuario novoUsuario) { // O Válid é apanenas para validar se as informações estão sendo passadas para o BD, conforme especificações passadas na classe Usuario. O método salvarUsuario vai pegar o novoUsuario a partir do corpo da solicitação, poderá ser um formulário passado pelo front. Para fazer isso no Postman, é necessário ir na aba Body, alterar a aba abaixo para raw e o texto como JSON, depois disso, escrever as informações seguindo o padrão definido pela classe Usuario. Nesse caso: { "nome":"teste", "usuario":"teste", "senha":"teste123"}
		return repository.save(novoUsuario); // Recebe uma entidade como parâmetro, que é a entidade novoUsuario que foi passada no parâmetro do método.
	
	}
	
	
	/* Este método é apenas para comparativo com o método acima sem a validação do novo usuário. Para a cadastro de um novo usuário, foi utilizada uma nova classe chamada Services, que contém os métodos referentes as regras de negócio (cadastro de um novo usuário é uma regra de negócio). Isso foi feito, por conta da programação dissociativa.
	@PostMapping("/salvar") // Neste método está sendo criado um novo usuário validando validação se já é existente.
	public ResponseEntity<Usuario> salvarUsuario(@Valid @RequestBody Usuario novoUsuario) { // O método salvarUsuario vai pegar o novoUsuario a partir do corpo da solicitação, poderá ser um formulário passado pelo front. Para fazer isso no Postman, é necessário ir na aba Body, alterar a aba abaixo para raw e o texto como JSON, depois disso, escrever as informações seguindo o padrão definido pela classe Usuario. Nesse caso: { "nome":"teste", "usuario":"teste", "senha":"teste123"}
		Optional<Usuario> usuarioExistente = repository.findByUsuario(novoUsuario.getUsuario()); // Está sendo instanciado um objeto chamado usuarioExistente onde ele recebe o Usuario a partir do método findByUsuario criado no Repository (observar que o parâmetro que o findByUsuario necessita é o novoUsuario que está sendo passado no começo desse método, e para conseguir pegar efetivamente o usuario é utilizado o método .getUsuario(). Aqui, ele verifica se um usuário existe, ou seja, se ele encontrar algum usuario igual, é o que ele irá retornar.
		// O método acima faz a pesquisa no DB e ele retorna um Optional, agora é necessário escrever um código pra saber se têm algo lá dentro
		
		if(usuarioExistente.isPresent()) { // Aqui ele está verificando se há alguma coisa no objeto usuarioExistente.
			return ResponseEntity.status(400).body(usuarioExistente.get()); // Caso tenha, é possível pegar essa informação.
		}else {
			return ResponseEntity.status(201).body(repository.save(novoUsuario)); // Caso não tenha, será salvo um novo usuário.
		}
	} 
	É necessário observar que o método acima foi feito sem elegância, ou seja, não explorando todas as funcionalidades do Optional e utilizando um IfElse. Desta forma, sem elegância, é funcional e não está errado.*/

	@PostMapping("/salvar") // Este é o método para cadastrar um novo usuário utilizando a classe Service
	public ResponseEntity<Object> salvarUsuario(@Valid @RequestBody Usuario novoUsuario) { // O método salvarUsuario vai pegar o novoUsuario a partir do corpo da solicitação, poderá ser um formulário passado pelo front. Para fazer isso no Postman, é necessário ir na aba Body, alterar a aba abaixo para raw e o texto como JSON, depois disso, escrever as informações seguindo o padrão definido pela classe Usuario. Nesse caso: { "nome":"teste", "usuario":"teste", "senha":"teste123"}
		return services.cadastrarUsuario(novoUsuario)
				.map(usuarioExistente -> ResponseEntity.status(201).body(usuarioExistente))
				.orElse(ResponseEntity.status(400).body("Usuário já cadastrado.")); 
		// Chamando primeiro onde existem as regras de negócio, ou seja, o services com o método de cadastrarUsuario (que foi criado), recebendo o parâmetro novoUsuario que foi requisitado do corpo do site. Em seguida vem o .map que retornará a entidade que será cadastrada dentro do map, ou seja, terá certeza que existirá algo para retornar, por isso dentro do método .map foi feita uma arrow function com o nome usuarioExistente, onde será feita uma contrução a partir desse usuarioExistente retornando ou um novo usuário (resposta 200) ou um 400 pois já existe um usuário, por isso utiliza o OrElse.
	}
	
	@GetMapping("/id/{id_usuario}") // O caminho da URL, o {} funciona como uma interpolação
	public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable(value = "id_usuario") Long idUsuario) { // Pega um parâmetro pelo caminho passado e vai joga-lo dentro do idUsuario que deverá ter seu tipo antes.
		return repository.findById(idUsuario)
				.map(idExistente -> ResponseEntity.status(200).body(idExistente))
				.orElse(ResponseEntity.status(204).build()); 
		// Aqui o método findById de repository está recebendo como parâmetro o idUsuario que está sendo verificado a partir do map, a resposta aparece no idExistente, caso tenha realmente o id, ele retornará um 200 com o idUsuario no corpo, caso não tenha, ele constrói um 400.
	}
	
	@GetMapping("/busca")
	public ResponseEntity<Object> buscarUsuarioPorNome(@RequestParam(defaultValue = "") String nome){ // Utilizando o ResponseEntity em Object para conseguir retornar uma lista e uma string, pois ambas são extendidas a partir dessa classe. O RequestParam é utilizado quando são enviados parâmetros do front-end para utiliza-los em um método. No Postman, para passar parâmetros utilize a aba Params, na coluna key coloque o parâmetro que esta função está recebendo, ou seja, o nome, e em values, o valor que será passado para a função (nesse caso, um nome). O defaultValue é apenas para deixar um valor predefino para evitar um bad request.
		List<Usuario> listaDeUsuarios = repository.findAllByNomeContaining(nome); // Para verificar se a lista contém algum valor.
		
		if(!listaDeUsuarios.isEmpty()) { // Seguindo o mesmo padrão do @GetMapping("/todes").
			return ResponseEntity.status(202).body(listaDeUsuarios);
		}else {
			return ResponseEntity.status(204).build();
		}
	}
	
	@PutMapping("/atualizar/{id_usuario}")
	public ResponseEntity<Usuario> atualizarUsuario(@PathVariable(value = "id_usuario") Long idUsuario, @Valid @RequestBody Usuario atualizacaoUsuario) { // Para o método atualizarUsuario que foi criado na classe UsuarioServices são necessários 2 parâmetros, o idUsuario e o atualizarUsuario (o próprio Usuario), portanto, foi solicitado de duas formas diferentes. Pelo caminho (PathVariable) é solcitado o número do Id, e a partir do corpo (RequestBody) é possível pegar o Usuario, por exemplo, com um formulário no front (atentar-se com o @Valid pois toda a entidade usuário quando for passado pelo body precisa dessa validação). Para passar as informações no corpo no Postman, é necessário ir na aba Body, alterar a aba abaixo para raw e o texto como JSON, depois disso, escrever as informações seguindo o padrão definido pela classe Usuario. Nesse caso: { "nome":"novoTeste", "senha":"novoTeste123"}
		return services.atualizarUsuario(idUsuario, atualizacaoUsuario)
				.map(usuarioAtualizado -> ResponseEntity.status(201).body(usuarioAtualizado))
				.orElse(ResponseEntity.status(304).build()); 
		// Retornando o método atualizarUsuario que está dentro da classe UsuarioServices que foi feita a injeção de dependência com o nome apenas de service. Onde esse método solicita 2 parâmetros, que foram pegos a partir do PathVariable e do RequestBody, onde está retornando um Optional, por conta disso, é possível retornar da forma elegante utilizando o .map, solicitando assim a arrow function, onde o usuarioAtualizado receberá e retornará ou um ResponseEntity com a resposta 201 construindo no corpo o a atualização do usuário, ou ele retorná um 304 (não modificado).
	}
	
	@DeleteMapping
	public void deleteUsuario(@RequestParam long id) { // Método para deletar usuário onde o id está sendo passado por param.
		repository.deleteById(id); // O método deleteById é extendido da interface repository que extende de Jpa, método padrão dessa interface.
	}
	
	@GetMapping(path = "/pesquisar", params = "usuario") // O URL contém um path e param para devolver o método.
	public ResponseEntity<Object> buscarUsuario(@RequestParam String usuario){ // O método está pedindo um ResponseEntity como retorno e um parâmetro de RequestParam, passando essa informação para o GetMapping.
		return repository.findByUsuarioIgnoreCase(usuario)
				.map(resp -> ResponseEntity.status(200).body(resp))
				.orElse(ResponseEntity.status(404).body("Não existe este usuário."));
		// Retornando o método findByUsuarioIgnoreCase() que está dentro da classe UsuarioRepository que foi feita a injeção de dependência com o nome apenas de repository. Onde esse método solicita 1 parâmetro através do RequestBody, onde está retornando um Optional, por conta disso, é possível retornar da forma elegante utilizando o .map, solicitando assim a arrow function, onde o res receberá e retornará ou um ResponseEntity com a resposta 200 construindo no corpo o usuario que está sendo procurado, ou ele retorná um 404 construindo no corpo uma mensagem.

	}
	
}










