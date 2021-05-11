package Exercicios110521.Exercicio1;

public class Cachorro extends Animal{

	public Cachorro(String nome, int idade, String som) {
		super(nome, idade, som);
	}
	
	public void Correr() {
		System.out.printf("%s está correndo!\n",getNome());
	}
	
}
