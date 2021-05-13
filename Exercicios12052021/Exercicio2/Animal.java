package Exercicio2;

public abstract class Animal {
	
	protected String nome;
	protected int idade;
	
	public Animal(String nomeAnimal, int idadeAnimal) {
		this.nome = nomeAnimal;
		this.idade = idadeAnimal;
	}
	
	public abstract void emitirSom();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
}
