package Exercicios060521;

import java.util.Scanner;

public class Exercicio5 {

	public static void main(String[] args) {
		/* (Utilizando o laço Do While) Crie um programa que leia um número do teclado até que encontre um
		 	número igual a zero. No final, mostre a soma dos números digitados.
		 */
		
		int num, somaNum=0;
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("O programa abaixo solicitará que sejam inseridos números até ser digitado o número 0. Após isso, o programa mostrará a soma dos números digitados: ");
		
		do {
			System.out.println("\nPor favor, digite um número: ");
			num = read.nextInt();
			somaNum = somaNum + num;
		}while(num!=0);
		
		System.out.println("\nA soma dos números digitados foi: "+somaNum);

	}

}
