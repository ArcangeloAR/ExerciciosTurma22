package Exercicios050521;

import java.util.Scanner;

public class Exercicio4 {
	public static void main(String[] args) {
		/* (Utilizando apenas laço condicional) Faça um programa em que permita a entrada de um número qualquer e exiba se este
		número é par ou ímpar. Se for par exiba também a raiz quadrada do mesmo; se for
		ímpar exiba o número elevado ao quadrado:
		*/
		
		double num, saida;
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("Abaixo, por favor, digite um número. Se ele for par, a saída será sua raiz quadrada, caso ele seja ímpar, a saída será esse número elevado ao quadrado: ");
		num = read.nextDouble();
		
		if(num%2==0) {
			saida = Math.sqrt(num);
			System.out.printf("Seu resultado foi: %2.2f ",saida);
		}else {
			saida = Math.pow(num,2);
			System.out.printf("Seu resultado foi: %2.0f",saida);
		}
		

	}
}
