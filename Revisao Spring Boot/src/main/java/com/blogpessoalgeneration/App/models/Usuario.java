package com.blogpessoalgeneration.App.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// Model utilizado para inserir os atributos

@Entity //@Entity + @Id mínimo necessário para a criação de uma tabela.
@Table(name = "usuarios") // Para mudar o nome da tabela.
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Valor autoincrementado;
	private Long idUsuario;
	
	@NotNull
	@Size(min = 5, max = 100, message = "Entre 5 e 100 caracteres")
	@Column(name = "nomeUsuario") // Caso queira trocar o nome da coluna no DB
	private String nome;
	
	@NotNull
	@Size(min = 5, max = 50, message = "Entre 5 e 50 caracteres")
	private String usuario;
	
	@NotNull
	@Size(min = 5, max = 20, message = "Entre 5 e 20 caracteres")
	private String senha;
	
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
