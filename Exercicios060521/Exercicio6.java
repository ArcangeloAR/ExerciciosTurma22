package Exercicios060521;

import java.util.Scanner;

public class Exercicio6 {

	public static void main(String[] args) {
		/* (Utilizando o la�o Do While) Escrever um programa que receba v�rios n�meros inteiros no teclado.
			 E no final imprimir a m�dia dos n�meros m�ltiplos de 3. Para sair digitar 0.:
		*/
		
		int num, cont=-1, totalParaMedia=0;
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("O programa abaixo solicitar� que sejam inseridos n�meros at� ser digitado o n�mero 0. Ap�s isso, o programa mostrar� a m�dioa dos n�meros m�ltiplos de 3: ");
		
		do {
			System.out.println("\nPor favor, digite um n�mero: ");
			num = read.nextInt();
						if(num%3==0) {
				cont = cont+1;
				totalParaMedia = totalParaMedia + num;
			}
		}while(num!=0);
		
		System.out.println("\nA quantidade de n�meros m�ltiplos de 3 digitados foi: "+cont+". A soma total desses n�meros foi: "+totalParaMedia+". E a m�dia desses n�meros foi: "+(totalParaMedia/cont)+".");
	}
}
