package Exercicios070521;

import java.util.Scanner;

public class Exercicio3 {

	public static void main(String[] args) {
		// (Utilizando Matriz) Leia uma matriz 3 x 3, conte e escreva quantos valores maiores que 10 ela possui.

		System.out.println("Abaixo você poderá digitar 9 números e descobrir quantos e quais deles são maiores que 10: \n");
		int[][] numeros = new int[3][3];
		int i, j, contPosicao=1, contMaior10=0;
		
		Scanner read = new Scanner(System.in);
		
		for(i=0;i<3;i++) {
			for(j=0;j<3;j++) {
				System.out.println("Por favor, digite o "+contPosicao+"º número: ");
				numeros[i][j] = read.nextInt();
				contPosicao++;
				
				if(numeros[i][j]>10) {
					contMaior10++;
				}
			}
		}
		
		System.out.println("\nA quantidade de números digitados maiores que 10 foi "+contMaior10+". Abaixo você poderá visualizar qual(is) foi(ram) o(s) número(s) e em que posição ele(s) foi(ram) digitado(s): ");
		
		contPosicao = 0;
		
		for(i=0;i<3;i++) {
			for(j=0;j<3;j++) {
				contPosicao++;
				if(numeros[i][j]>10) {
					System.out.println("O número "+numeros[i][j]+ " foi digitado na "+contPosicao+"ª posição.");
				}
			}
		}
	}

}
