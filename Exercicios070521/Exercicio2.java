package Exercicios070521;

import java.util.Scanner;

public class Exercicio2 {

	public static void main(String[] args) {
		/* (Utilizando Vetor) Fa�a um programa que receba 6 n�meros inteiros e mostre:
	   	- Os n�meros pares digitados;
	   	- A soma dos n�meros pares digitados;
	   	- Os n�meros �mpares digitados;
	   	- A quantidade de n�meros �mpares digitados.
	*/
		System.out.println("Abaixo voc� poder� escrever 6 valores e descobrir a soma dos n�meros pares digitados e a quantidade de �mpares que foi digitada: \n");
		int[] numeros = new int[6];
		int somaPar=0, contImpar=0, i;
		
		Scanner read = new Scanner(System.in);
		
		for(i=0;i<numeros.length;i++) {
			System.out.println("Por favor, digite um n�mero: ");
			numeros[i] = read.nextInt();
			
			if(numeros[i]%2==0) {
				somaPar = somaPar+numeros[i];
			}else {
				contImpar++;
			}
		}
		
		System.out.println("\nOs n�meros pares digitados foram: ");
		for(i=0;i<numeros.length;i++) {
			if(numeros[i]%2==0) {
				System.out.println(numeros[i]+";");
			}
		}
		
		System.out.println("A soma desses n�meros foi: "+somaPar+("."));
		
		
		System.out.println("\nOs n�meros �mpares digitados foram: ");
		for(i=0;i<numeros.length;i++) {
			if(numeros[i]%2!=0) {
				System.out.println(numeros[i]+";");
			}
		}

		System.out.println("A quantidade desses n�meros foi: "+contImpar+("."));		
		
	}

}
