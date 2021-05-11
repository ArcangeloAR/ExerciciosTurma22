package Exercicios110521.Exercicio1;

public class Preguica extends Animal {
	
	public Preguica(String nome, int idade, String som) {
		super(nome, idade, som);
	}
	
	public void subirArvores() {
		System.out.printf("%s está subindo em uma árvore!\n",getNome());
	}
}
