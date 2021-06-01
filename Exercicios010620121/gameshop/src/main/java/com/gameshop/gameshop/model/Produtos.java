package com.gameshop.gameshop.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class Produtos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	
	@NotNull
	@Size(min = 5, max = 70, message = "Entre 5 e 70 caracteres.")
	private String nomeProduto;
	
	@NotNull
	@Size(min = 2, max = 70, message = "Entre 2 e 70 caracteres.")
	private String nomeDesenvolvedora;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_categoria")
	@JsonIgnoreProperties({"produtosDaCategoria"})
	private Categorias gerador;
	
	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getNomeDesenvolvedora() {
		return nomeDesenvolvedora;
	}

	public void setNomeDesenvolvedora(String nomeDesenvolvedora) {
		this.nomeDesenvolvedora = nomeDesenvolvedora;
	}

	public Categorias getGerador() {
		return gerador;
	}

	public void setGerador(Categorias gerador) {
		this.gerador = gerador;
	}	
	
}
