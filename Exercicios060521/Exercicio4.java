package Exercicios060521;

import java.util.Scanner;

public class Exercicio4 {

	public static void main(String[] args) {
		/* (Utilizando o laço While) Uma empresa desenvolveu uma pesquisa para saber as características psicológicas dos indivíduos de uma região. 
			Para tanto, a cada uma das pessoas era perguntado: idade, sexo (1-feminino / 2-masculino / 3-Outros), e as opções
			(1, se a pessoa era calma; 2, se a pessoa era nervosa e 3, se a pessoa era agressiva). 
			Pede-se para elaborar um sistema que permita ler os dados de 150 pessoas, calcule e mostre:
				- O número de pessoas calmas;
				- O número de mulheres nervosas;
				- O número de homens agressivos;
				- O número de outros calmos;
				- O número de pessoas nervosas com mais de 40 anos;
				- O número de pessoas calmas com menos de 18 anos. 
		*/
	
		int repetir=1, pessoas=1, idade, sexo, temperamento, numMulheres=0, numHomens=0, numOutros=0, numCalmas=0, numNervosas=0, numAgressivas=0, numMulheresNervosas=0, numHomensAgressivos=0, numOutrosCalmos=0, numNervosasMais40=0, numCalmasMenos18=0;

		
		Scanner read = new Scanner(System.in);
		
		System.out.println("Abaixo, você poderá digitar dados de até 150 pessoas que moram em uma região para obter informações demográficas: ");
		
		while(pessoas<=150 && repetir==1) {
			
			System.out.println("Por favor, digite a idade da "+pessoas+"ª pessoa: ");
			idade = read.nextInt();
			
			System.out.println("Por favor, digite a opção referente ao sexo da "+pessoas+"ª pessoa (1- Feminino / 2- Masculino / 3- Outros): ");
			sexo = read.nextInt();
			
				while(sexo<1 || sexo>3) {
				System.out.println("Por favor, digite uma opção válida referente ao sexo da "+pessoas+"ª pessoa (1- Feminino / 2- Masculino / 3- Outros): ");
				sexo = read.nextInt();
				}
			
				
			System.out.println("Por favor, digite a opção referente ao temperamento da "+pessoas+"ª pessoa (1- Calma / 2- Nervosa / 3- Agressiva): ");
				temperamento = read.nextInt();
				
					while(temperamento<1 || temperamento>3) {
					System.out.println("Por favor, digite uma opção válida referente ao temperamento da "+pessoas+"ª pessoa (1- Calma / 2- Nervosa / 3- Agressiva): ");
					temperamento = read.nextInt();
					}			
			
			switch(sexo) {
				case 1:
					numMulheres++;
				break;
				case 2:
					numHomens++;
				break;
				case 3:
					numOutros++;
				break;	
			}
			
			switch(temperamento) {
			case 1:
				numCalmas++;
			break;
			case 2:
				numNervosas++;
			break;
			case 3:
				numAgressivas++;
			break;	
		}
			
			if(sexo==1 && temperamento==2) {
				numMulheresNervosas++;
			}
			if(sexo==2 && temperamento==3) {
				numHomensAgressivos++;
			}
			if(sexo==3 && temperamento==1) {
				numOutrosCalmos++;
			}
			if(idade>40 && temperamento==2) {
				numNervosasMais40++;
			} 
			if(idade<18 && temperamento==1) {
				numCalmasMenos18++;
			}
			
			System.out.println("Você deseja incluir os dados de mais uma pessoa (1- Sim / 2- Não): ");
			repetir = read.nextInt();
			
			while(repetir<1 || repetir>2) {
				System.out.println("Por favor, digite uma opção possível, para incluir os dados de uma nova pessoa (1- Sim / 2- Não): ");	
				repetir = read.nextInt();
			}
			
			pessoas++;
			
		}
		
		System.out.println("\nO número de pessoas calmas foi: "+numCalmas+".");	
		System.out.println("O número de mulheres nervosas foi: "+numMulheresNervosas+".");	
		System.out.println("O número de homens agressivos foi: "+numHomensAgressivos+".");
		System.out.println("O número de outros calmos foi: "+numOutrosCalmos+".");
		System.out.println("O número de pessoas nervosas com mais de 40 anos: "+numNervosasMais40+".");
		System.out.println("O número de pessoas calmas com menos de 18 anos: "+numCalmasMenos18+".");

	}

}
