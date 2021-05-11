package Exercicios110521.Exercicio1;

public class ClassePrincipal {

	public static void main(String[] args) {
		
		Cachorro bob = new Cachorro("Bob",10,"latindo");
		bob.Correr();
		bob.emitirSom();
	
		Cavalo silver = new Cavalo("Silver",20,"relinchando");
		silver.Correr();
		silver.emitirSom();
		
		Preguica arboreo = new Preguica("Arbóreo",45,"grunhindo");
		arboreo.subirArvores();
		arboreo.emitirSom();
	}

}
