package Exercicio2;

public class Cavalo extends Animal {
	
	public Cavalo(String nome, int idade) {
		super(nome, idade);
	}
	
	public void emitirSom() {
		System.out.println(nome+" est� relinchando.");
	}
	
	public void correr() {
		System.out.println(nome+" est� trotar.");
	}
}
