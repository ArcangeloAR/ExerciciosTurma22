package Exercicio2;

public class Preguica extends Animal {
	
	public Preguica(String nome, int idade) {
		super(nome, idade);
	}
	
	public void emitirSom() {
		System.out.println(nome+" est� relinchando.");
	}
	
	public void subirEmArvores() {
		System.out.println(nome+" est� subindo em uma �rvore.");
	}
}
