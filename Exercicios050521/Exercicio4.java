package Exercicios050521;

import java.util.Scanner;

public class Exercicio4 {
	public static void main(String[] args) {
		/* (Utilizando apenas la�o condicional) Fa�a um programa em que permita a entrada de um n�mero qualquer e exiba se este
		n�mero � par ou �mpar. Se for par exiba tamb�m a raiz quadrada do mesmo; se for
		�mpar exiba o n�mero elevado ao quadrado:
		*/
		
		double num, saida;
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("Abaixo, por favor, digite um n�mero. Se ele for par, a sa�da ser� sua raiz quadrada, caso ele seja �mpar, a sa�da ser� esse n�mero elevado ao quadrado: ");
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
