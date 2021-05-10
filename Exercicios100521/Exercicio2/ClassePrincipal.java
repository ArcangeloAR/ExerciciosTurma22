package Exercicio2;

import java.util.Scanner;

public class ClassePrincipal {

	public static void main(String[] args) {
		/* Crie uma classe avião e apresente os atributos e métodos referentes esta classe, em seguida crie um objeto avião, defina as instancias deste
		objeto e apresente as informações deste objeto no console.
		*/
		String modeloAviao1;
		String fabricanteAviao1;
		int capacidadeTotalPassageiros1;
		float porcentagemLotacao1;
		int qntPassageirosEmbarcados1;
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("Por favor, digite o modelo do avião: ");
		modeloAviao1 = read.next();
		System.out.println("Por favor, digite o fabricante do avião: ");
		fabricanteAviao1 = read.next();
		System.out.println("Por favor, digite a capacidade total do avião: ");
		capacidadeTotalPassageiros1 = read.nextInt();
		System.out.println("Por favor, digite a quantidade de passageiros embarcados no avião: ");
		qntPassageirosEmbarcados1 = read.nextInt();
		
		porcentagemLotacao1 = (((float)qntPassageirosEmbarcados1/(float)capacidadeTotalPassageiros1));
		
		ClasseAviao aviao1 = new ClasseAviao(modeloAviao1, fabricanteAviao1, capacidadeTotalPassageiros1, porcentagemLotacao1, qntPassageirosEmbarcados1);
		aviao1.imprimirInfos();

	}

}
