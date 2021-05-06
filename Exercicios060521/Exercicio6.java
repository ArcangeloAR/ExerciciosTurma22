package Exercicios060521;

import java.util.Scanner;

public class Exercicio6 {

	public static void main(String[] args) {
		/* (Utilizando o laço Do While) Escrever um programa que receba vários números inteiros no teclado.
			 E no final imprimir a média dos números múltiplos de 3. Para sair digitar 0.:
		*/
		
		int num, cont=-1, totalParaMedia=0;
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("O programa abaixo solicitará que sejam inseridos números até ser digitado o número 0. Após isso, o programa mostrará a médioa dos números múltiplos de 3: ");
		
		do {
			System.out.println("\nPor favor, digite um número: ");
			num = read.nextInt();
						if(num%3==0) {
				cont = cont+1;
				totalParaMedia = totalParaMedia + num;
			}
		}while(num!=0);
		
		System.out.println("\nA quantidade de números múltiplos de 3 digitados foi: "+cont+". A soma total desses números foi: "+totalParaMedia+". E a média desses números foi: "+(totalParaMedia/cont)+".");
	}
}
