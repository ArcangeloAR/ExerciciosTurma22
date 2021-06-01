package com.gameshop.gameshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_categorias")
public class Categorias {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	
	@NotNull
	@Size(min=5, max=50, message = "Entre 5 e 50 caracteres.")
	private String nomeCategoria;
	
	@NotNull
	@Size(min=5, max=50, message = "Entre 5 e 50 caracteres.")
	private String jogabilidade;
	
	@OneToMany(mappedBy = "gerador", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"gerador"})
	private List<Produtos> produtosDaCategoria = new ArrayList<>();
	
	
	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getJogabilidade() {
		return jogabilidade;
	}

	public void setJogabilidade(String jogabilidade) {
		this.jogabilidade = jogabilidade;
	}

	public List<Produtos> getProdutosDaCategoria() {
		return produtosDaCategoria;
	}

	public void setProdutosDaCategoria(List<Produtos> produtosDaCategoria) {
		this.produtosDaCategoria = produtosDaCategoria;
	}
	
}
