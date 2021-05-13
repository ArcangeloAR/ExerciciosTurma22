package Exercicio2;

public class ClassePrincipal {

	public static void main(String[] args) {
		
		Cavalo spirit = new Cavalo("Spirit",15);
		
		spirit.emitirSom();
		spirit.correr();
		
		Cachorro scooby = new Cachorro("Scooby",10);
		
		scooby.emitirSom();
		scooby.correr();
		
		Preguica arboreo = new Preguica("Arboreo",20);
		
		arboreo.emitirSom();
		arboreo.subirEmArvores();		

	}

}
