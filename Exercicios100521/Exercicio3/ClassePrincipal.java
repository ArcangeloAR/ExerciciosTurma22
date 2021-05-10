package Exercicio3;

import java.util.Scanner;

public class ClassePrincipal {

	public static void main(String[] args) {
		/* Crie uma classe produto eletrônico e apresente os atributos e métodos referentes esta classe, em seguida crie um objeto produto eletrônico,
		defina as instancias deste objeto e apresente as informações deste objeto no console.
		*/
		
		String[] modelos = new String[3];
		String[] marcas = new String[3];		
		String[] tipos = new String[3];		
		float[] valores = new float[3];
		int[] qntEstoques = new int[3];
		float[] valoresTotalEstoque = new float[3];
		int i;
		
		Scanner read = new Scanner(System.in);		
		
		for(i=0;i<3;i++) {
			System.out.println("\nPor favor, digite o "+(i+1)+"º modelo do aparelho: ");
			modelos[i] = read.next();
			System.out.println("\nPor favor, digite a marca do "+(i+1)+"º aparelho: ");
			marcas[i] = read.next();
			System.out.println("\nPor favor, digite o tipo do "+(i+1)+"º aparelho: ");
			tipos[i] = read.next();		
			System.out.println("\nPor favor, digite o valor do "+(i+1)+"º aparelho: ");
			valores[i] = read.nextFloat();
			System.out.println("\nPor favor, digite a quantidade do "+(i+1)+"º tipo de aparelho em estoque: ");
			qntEstoques[i] = read.nextInt();
			
			valoresTotalEstoque[i] = valores[i]*(float)qntEstoques[i];
		}
		
		
			ClasseEletronicos eletronico0 = new ClasseEletronicos(modelos[0], marcas[0], tipos[0], valores[0], qntEstoques[0], valoresTotalEstoque[0]);
			eletronico0.imprimirInfos();

			ClasseEletronicos eletronico1 = new ClasseEletronicos(modelos[1], marcas[1], tipos[1], valores[1], qntEstoques[1], valoresTotalEstoque[1]);
			eletronico1.imprimirInfos();
			
			ClasseEletronicos eletronico2 = new ClasseEletronicos(modelos[2], marcas[2], tipos[2], valores[2], qntEstoques[2], valoresTotalEstoque[2]);
			eletronico2.imprimirInfos();
			
	}

}
