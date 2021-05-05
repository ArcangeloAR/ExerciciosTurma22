package Exercicios050521;

import java.util.Scanner;

public class Exercicio1 {

	public static void main(String[] args) {
		// (Utilizando apenas laço condicional) Faça um programa que receba três inteiros e diga qual deles é o maior:
		
		int a,b,c,maior=0;
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("Abaixo, por favor, digite três números para descobrir qual o maior deles: ");
		System.out.println("Por favor, digite o primeiro número: ");
		a = read.nextInt();
		System.out.println("Por favor, digite o segundo número: ");
		b = read.nextInt();
		System.out.println("Por favor, digite o terceiro número: ");
		c = read.nextInt();
		
		if(a>b) {
			maior = a;
		}else {
			maior = b;
		}
		
		if(c>maior) {
			maior = c;
		}
		
		System.out.println("O maior número digitado foi "+maior+".");
	}

}
