package org.generation.blogPessoal.controller;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.UserLogin;
import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/entrar")
	public ResponseEntity<UserLogin> autentication(@RequestBody Optional<UserLogin> user) {
		return usuarioService.logar(user).map(resp -> ResponseEntity.status(200).body(resp))
				.orElse(ResponseEntity.status(401).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> post(@RequestBody Usuario usuario) {
		Optional<Usuario> user = usuarioService.cadastrarUsuario(usuario);
		try {
				return ResponseEntity.status(200).body(user.get());
		} catch (Exception e) {
			return ResponseEntity.status(400).build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {
		return usuarioService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable(value = "id") long id) {
		return usuarioService.getByIdUsuario(id);
	}

}
