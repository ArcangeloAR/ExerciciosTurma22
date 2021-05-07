package Exercicios070521;

public class Exercicio1 {

	public static void main(String[] args) {
		/* (Utilizando Vetor) Faça um programa que possua um vetor denominado A que armazene 6 números inteiros. O programa deve executar os seguintes passos:
		   	- Atribua os seguintes valores a esse vetor: 1, 0, 5, -2, -5, 7;
		   	- Armazene em uma variável inteira (simples) a soma entre os valores das posições A[0], A[1] e A[5] do vetor e mostre na tela esta soma;
		   	- Modifique o vetor na posição 4, atribuindo a esta posição o valor 100;
		   	- Mostre na tela cada valor do vetor A, um em cada linha.
		*/
		
		System.out.println("Abaixo, será executado um programa que leia o Vetor A com 6 posições, some 3 posição, altere uma posição e mostre a atualização dessas posições: \n");
		
		int[] A = {1, 0, 5, -2, -5, 7};
		int soma;
		
		soma = A[0] + A[1] + A[5];

		System.out.println("A soma das posições 0, 1 e 5 do array a foi: "+soma+"\n");
		
		A[4] = 100;
		
		for(int i=0;i<6;i++) {
			System.out.println("O valor de a na posição "+i+" é: "+A[i]);
		}

	
	}

}
