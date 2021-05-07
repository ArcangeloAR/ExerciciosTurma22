package Exercicios070521;

import java.util.Scanner;

public class Exercicio4 {
	


	public static void main(String[] args) {
		/* (Utilizando Matriz) Fa�a um programa que leia duas matrizes 2 x 2 com valores reais. Ofere�a ao usu�rio um menu de op��es:
		   	1. Somar duas matrizes;
		   	2. Subtrair a primeira matriz da segunda;
		   	3. Adicionar uma constante as duas matrizes;
		   	4. Imprimir as matrizes.
		   	
		   	Nas duas primeiras op��es uma terceira matriz 2 x 2 deve ser criada. Na terceira op��o o valor da constante deve ser lido e o resultado da adi��o da constante deve ser armazenado na pr�pria matriz.
		   	
		 */

		System.out.println("Abaixo voc� poder� escrever os valores de duas matrizes, em seguida, ter� uma gama de op��es para efetuar opera��es com elas: \n");
		
		int[][] matriz1 = new int[2][2];
		int[][] matriz2 = new int[2][2];
		int[][] matriz3 = new int[2][2];
		
		int i,j, opcao;
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("Por favor, digite abaixo os valores da primeira matriz: ");
		for(i=0;i<2;i++) {
			for(j=0;j<2;j++) {
				System.out.println("Digite o valor da "+(i+1)+"� linha e "+(j+1)+"� coluna: ");
				matriz1[i][j] = read.nextInt();
			}
		}
		
		System.out.println("\nPor favor, digite abaixo os valores da segunda matriz: ");
		for(i=0;i<2;i++) {
			for(j=0;j<2;j++) {
				System.out.println("Digite o valor da "+(i+1)+"� linha e "+(j+1)+"� coluna: ");
				matriz2[i][j] = read.nextInt();
			}
		}		
		
		System.out.println("\nPor favor, digite abaixo a opera��o que voc� deseja efetuar com as matrizes digitadas: \n1. Somar duas matrizes;\n2. Subtrair a primeira matriz da segunda;\n3. Adicionar uma constante as duas matrizes;\n4. Imprimir as matrizes.");
		opcao = read.nextInt();
		
		while(opcao<1 || opcao>4) {
			System.out.println("\nPor favor, digite uma das op��es apresentadas: \n1. Somar duas matrizes;\n2. Subtrair a primeira matriz da segunda;\n3. Adicionar uma constante as duas matrizes;\n4. Imprimir as matrizes.");
			opcao = read.nextInt();
			}
		
		switch(opcao) {
		case 1:
			for(i=0;i<2;i++) {
				for(j=0;j<2;j++) {
					matriz3[i][j] = matriz1[i][j] + matriz2[i][j];
				}
			}
			
			for(i=0;i<2;i++) {
				for(j=0;j<2;j++) {
					System.out.printf("\t %d \t |",matriz3[i][j]);
				}
				System.out.println();
			}
		break;
		
		case 2:
			for(i=0;i<2;i++) {
				for(j=0;j<2;j++) {
					matriz3[i][j] = matriz2[i][j] - matriz1[i][j];
				}
			}
			
			for(i=0;i<2;i++) {
				for(j=0;j<2;j++) {
					System.out.printf("\t %d \t |",matriz3[i][j]);
				}
				System.out.println();
			}
		break;
		
		case 3:
			
			final int a = 5;
					System.out.println("\nA constante a (que vale 5) foi adicionada a cada posi��o da primeira matriz, sendo assim, agora ela est� preenchida com os seguintes valores: ");
			for(i=0;i<2;i++) {
				for(j=0;j<2;j++) {
					matriz1[i][j] = matriz1[i][j] + a;
				}
			}
			
			for(i=0;i<2;i++) {
				for(j=0;j<2;j++) {
					System.out.printf("\t %d \t |",matriz1[i][j]);
				}
				System.out.println();
			}
			
			System.out.println("\nA constante a foi adicionada a cada posi��o da segunda matriz, sendo assim, agora ela est� preenchida com os seguintes valores: ");
			for(i=0;i<2;i++) {
				for(j=0;j<2;j++) {
					matriz2[i][j] = matriz2[i][j] + a;
				}
			}
			
			for(i=0;i<2;i++) {
				for(j=0;j<2;j++) {
					System.out.printf("\t %d \t |",matriz2[i][j]);
				}
				System.out.println();
			}
			
		break;
		
		case 4:
			
			System.out.println("\nA primeira matriz foi preenchida com os seguintes valores: ");
			for(i=0;i<2;i++) {
				for(j=0;j<2;j++) {
					System.out.printf("\t %d \t |",matriz1[i][j]);
				}
				System.out.println();
			}		
			
			System.out.println("\nA segunda matriz foi preenchida com os seguintes valores: ");
			for(i=0;i<2;i++) {
				for(j=0;j<2;j++) {
					System.out.printf("\t %d \t |",matriz2[i][j]);
				}
				System.out.println();
			}	
		break;
		
		default:
			System.out.println("\nPor favor, digite uma das op��es v�lida");
	
		}
	}

}
