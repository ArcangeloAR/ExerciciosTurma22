package Exercicios060521;

import java.util.Scanner;

public class Exercicio2 {

	public static void main(String[] args) {
		// (Utilizando o la�o For) Ler 10 n�meros e imprimir quantos s�o pares e quantos s�o �mpares:
		
		int i, num, qntPares=0, qntImpares=0;
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("Abaixo voc� poder� digitar 10 n�meros e descobrir quantos foram pares e quantos foram �mpares: ");
		
		for(i=1;i<=10;i++) {
			System.out.println("Por favor, digite o "+i+"� n�mero: ");
			num = read.nextInt();
			if(num%2==0) {
				qntPares++;
			}else {
				qntImpares++;
			}
		}
		
		System.out.println("A quantidade de n�meros pares digitados foi: "+qntPares+".");
		System.out.println("A quantidade de n�meros �mpares digitados foi: "+qntImpares+".");

	}

}
