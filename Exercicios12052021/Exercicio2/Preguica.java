package Exercicio2;

public class Preguica extends Animal {
	
	public Preguica(String nome, int idade) {
		super(nome, idade);
	}
	
	public void emitirSom() {
		System.out.println(nome+" está relinchando.");
	}
	
	public void subirEmArvores() {
		System.out.println(nome+" está subindo em uma árvore.");
	}
}
