package Exercicios060521;

import java.util.Scanner;

public class Exercicio5 {

	public static void main(String[] args) {
		/* (Utilizando o la�o Do While) Crie um programa que leia um n�mero do teclado at� que encontre um
		 	n�mero igual a zero. No final, mostre a soma dos n�meros digitados.
		 */
		
		int num, somaNum=0;
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("O programa abaixo solicitar� que sejam inseridos n�meros at� ser digitado o n�mero 0. Ap�s isso, o programa mostrar� a soma dos n�meros digitados: ");
		
		do {
			System.out.println("\nPor favor, digite um n�mero: ");
			num = read.nextInt();
			somaNum = somaNum + num;
		}while(num!=0);
		
		System.out.println("\nA soma dos n�meros digitados foi: "+somaNum);

	}

}
