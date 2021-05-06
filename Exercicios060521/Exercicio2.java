package Exercicios060521;

import java.util.Scanner;

public class Exercicio2 {

	public static void main(String[] args) {
		// (Utilizando o laço For) Ler 10 números e imprimir quantos são pares e quantos são ímpares:
		
		int i, num, qntPares=0, qntImpares=0;
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("Abaixo você poderá digitar 10 números e descobrir quantos foram pares e quantos foram ímpares: ");
		
		for(i=1;i<=10;i++) {
			System.out.println("Por favor, digite o "+i+"º número: ");
			num = read.nextInt();
			if(num%2==0) {
				qntPares++;
			}else {
				qntImpares++;
			}
		}
		
		System.out.println("A quantidade de números pares digitados foi: "+qntPares+".");
		System.out.println("A quantidade de números ímpares digitados foi: "+qntImpares+".");

	}

}
