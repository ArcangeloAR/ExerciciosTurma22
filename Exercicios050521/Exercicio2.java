package Exercicios050521;

import java.util.Scanner;

public class Exercicio2 {

	public static void main(String[] args) {
		
		// (Utilizando apenas la�o condicional) Fa�a um programa que entre com tr�s n�meros e coloque em ordem crescente:
		int a, b, c, posicao1=0, posicao2=0, posicao3=0;
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("Abaixo, por favor, digite tr�s n�meros para coloca-los em ordem crescente: ");
		System.out.println("Por favor, digite o primeiro n�mero: ");
		a = read.nextInt();
		System.out.println("Por favor, digite o segundo n�mero: ");
		b = read.nextInt();
		System.out.println("Por favor, digite o terceiro n�mero: ");
		c = read.nextInt();
		
		if(a<=b && a<=c) {
			posicao1 = a;
		} else if(b<=a && b<=c) {
			posicao1 = b;
		} else if(c<=a && c<=b) {
			posicao1 = c;
		}
		
		if(posicao1 == a && b<=c) {
			posicao2 = b;
		} else if(posicao1 == a && c<=b) {
			posicao2 = c;
		} else if(posicao1 == b && a<=c) {
			posicao2 = a;
		} else if(posicao1 == b && c<=a) {
			posicao2 = c;
		} else if(posicao1 == c && a<=b) {
			posicao2 = a;
		} else if(posicao1 == c && b<=a) {
			posicao2 = b;
		}
		
		if(posicao1==a && posicao2==b) {
			posicao3 = c;
		} else if(posicao1==a && posicao2==c) {
			posicao3 = b;
		} else if(posicao1==b && posicao2==c) {
			posicao3 = a;
		} else if(posicao1==b && posicao2==a) {
			posicao3 = c;
		} else if(posicao1==c && posicao2==a) {
			posicao3 = b;
		} else if(posicao1==c && posicao2==b) {
			posicao3 = a;
		}
		
		System.out.println("A ordem crescente dos n�meros escitos foi: "+posicao1+" "+posicao2+" "+posicao3+".");
		
		
	}

}
