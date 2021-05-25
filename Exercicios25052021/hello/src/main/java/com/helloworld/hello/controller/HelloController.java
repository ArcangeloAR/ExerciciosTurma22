package com.helloworld.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
	Atividades Spring-boot

		Atividade 1 Spring-boot (minha primeira aplicação):
		Crie uma aplicação spring de hello world.
		
		A aplicação deverá conter um end-point que retorna
		uma string com as habilidades e mentalidades que você
		utilizou para realizar essa atividade.
		
		Atividade 2 Spring-boot (minha segunda aplicação):
		Crie uma aplicação spring de hello world.
		
		A aplicação deverá conter um end-point que retorna
		uma string com os seus objetivos de aprendizagem para
		essa semana.
 
 */



@RestController
@RequestMapping("")
public class HelloController {
	
	@RequestMapping(value = "/mentalidadeEHabilidade")
		@GetMapping
		public String mentalidadeEHabilidade() {
			return "- Mentalidade: Persistência;\n"
					+ "- Habilidade: Atenção aos detalhes.";
		}
	
	@RequestMapping(value = "/objetivo")
		@GetMapping
		public String objetivo() {
			return "- Objetivo de aprendizagem: Spring.";
		}
}
