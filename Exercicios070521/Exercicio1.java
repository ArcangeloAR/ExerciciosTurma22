package Exercicios070521;

public class Exercicio1 {

	public static void main(String[] args) {
		/* (Utilizando Vetor) Fa�a um programa que possua um vetor denominado A que armazene 6 n�meros inteiros. O programa deve executar os seguintes passos:
		   	- Atribua os seguintes valores a esse vetor: 1, 0, 5, -2, -5, 7;
		   	- Armazene em uma vari�vel inteira (simples) a soma entre os valores das posi��es A[0], A[1] e A[5] do vetor e mostre na tela esta soma;
		   	- Modifique o vetor na posi��o 4, atribuindo a esta posi��o o valor 100;
		   	- Mostre na tela cada valor do vetor A, um em cada linha.
		*/
		
		System.out.println("Abaixo, ser� executado um programa que leia o Vetor A com 6 posi��es, some 3 posi��o, altere uma posi��o e mostre a atualiza��o dessas posi��es: \n");
		
		int[] A = {1, 0, 5, -2, -5, 7};
		int soma;
		
		soma = A[0] + A[1] + A[5];

		System.out.println("A soma das posi��es 0, 1 e 5 do array a foi: "+soma+"\n");
		
		A[4] = 100;
		
		for(int i=0;i<6;i++) {
			System.out.println("O valor de a na posi��o "+i+" �: "+A[i]);
		}

	
	}

}
