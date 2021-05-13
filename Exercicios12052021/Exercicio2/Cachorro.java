package Exercicio2;

public class Cachorro extends Animal {
	
	public Cachorro(String nome, int idade) {
		super(nome, idade);
	}
	
	public void emitirSom() {
		System.out.println(nome+" está relinchando.");
	}
	
	public void correr() {
		System.out.println(nome+" está trotar.");
	}
}
