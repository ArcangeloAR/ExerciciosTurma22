package Exercicios050521;

import java.util.Scanner;

public class Exercicio1 {

	public static void main(String[] args) {
		// (Utilizando apenas la�o condicional) Fa�a um programa que receba tr�s inteiros e diga qual deles � o maior:
		
		int a,b,c,maior=0;
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("Abaixo, por favor, digite tr�s n�meros para descobrir qual o maior deles: ");
		System.out.println("Por favor, digite o primeiro n�mero: ");
		a = read.nextInt();
		System.out.println("Por favor, digite o segundo n�mero: ");
		b = read.nextInt();
		System.out.println("Por favor, digite o terceiro n�mero: ");
		c = read.nextInt();
		
		if(a>b) {
			maior = a;
		}else {
			maior = b;
		}
		
		if(c>maior) {
			maior = c;
		}
		
		System.out.println("O maior n�mero digitado foi "+maior+".");
	}

}
