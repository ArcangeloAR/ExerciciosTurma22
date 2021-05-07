package Exercicios070521;

import java.util.Scanner;

public class Exercicio2 {

	public static void main(String[] args) {
		/* (Utilizando Vetor) Faça um programa que receba 6 números inteiros e mostre:
	   	- Os números pares digitados;
	   	- A soma dos números pares digitados;
	   	- Os números ímpares digitados;
	   	- A quantidade de números ímpares digitados.
	*/
		System.out.println("Abaixo você poderá escrever 6 valores e descobrir a soma dos números pares digitados e a quantidade de ímpares que foi digitada: \n");
		int[] numeros = new int[6];
		int somaPar=0, contImpar=0, i;
		
		Scanner read = new Scanner(System.in);
		
		for(i=0;i<numeros.length;i++) {
			System.out.println("Por favor, digite um número: ");
			numeros[i] = read.nextInt();
			
			if(numeros[i]%2==0) {
				somaPar = somaPar+numeros[i];
			}else {
				contImpar++;
			}
		}
		
		System.out.println("\nOs números pares digitados foram: ");
		for(i=0;i<numeros.length;i++) {
			if(numeros[i]%2==0) {
				System.out.println(numeros[i]+";");
			}
		}
		
		System.out.println("A soma desses números foi: "+somaPar+("."));
		
		
		System.out.println("\nOs números ímpares digitados foram: ");
		for(i=0;i<numeros.length;i++) {
			if(numeros[i]%2!=0) {
				System.out.println(numeros[i]+";");
			}
		}

		System.out.println("A quantidade desses números foi: "+contImpar+("."));		
		
	}

}
