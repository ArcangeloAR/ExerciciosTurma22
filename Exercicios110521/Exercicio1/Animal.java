package Exercicios110521.Exercicio1;

public class Animal {
	
	private String nome;
	private int idade;
	private String som;

	public Animal(String nome, int idade, String som) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.som = som;
	}
	
	public void emitirSom() {
		System.out.printf("%s está %s!\n",nome,som);
	}

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

	public String getSom() {
		return som;
	}

	public void setSom(String som) {
		this.som = som;
	}
}
