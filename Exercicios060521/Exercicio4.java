package Exercicios060521;

import java.util.Scanner;

public class Exercicio4 {

	public static void main(String[] args) {
		/* (Utilizando o la�o While) Uma empresa desenvolveu uma pesquisa para saber as caracter�sticas psicol�gicas dos indiv�duos de uma regi�o. 
			Para tanto, a cada uma das pessoas era perguntado: idade, sexo (1-feminino / 2-masculino / 3-Outros), e as op��es
			(1, se a pessoa era calma; 2, se a pessoa era nervosa e 3, se a pessoa era agressiva). 
			Pede-se para elaborar um sistema que permita ler os dados de 150 pessoas, calcule e mostre:
				- O n�mero de pessoas calmas;
				- O n�mero de mulheres nervosas;
				- O n�mero de homens agressivos;
				- O n�mero de outros calmos;
				- O n�mero de pessoas nervosas com mais de 40 anos;
				- O n�mero de pessoas calmas com menos de 18 anos. 
		*/
	
		int repetir=1, pessoas=1, idade, sexo, temperamento, numMulheres=0, numHomens=0, numOutros=0, numCalmas=0, numNervosas=0, numAgressivas=0, numMulheresNervosas=0, numHomensAgressivos=0, numOutrosCalmos=0, numNervosasMais40=0, numCalmasMenos18=0;

		
		Scanner read = new Scanner(System.in);
		
		System.out.println("Abaixo, voc� poder� digitar dados de at� 150 pessoas que moram em uma regi�o para obter informa��es demogr�ficas: ");
		
		while(pessoas<=150 && repetir==1) {
			
			System.out.println("Por favor, digite a idade da "+pessoas+"� pessoa: ");
			idade = read.nextInt();
			
			System.out.println("Por favor, digite a op��o referente ao sexo da "+pessoas+"� pessoa (1- Feminino / 2- Masculino / 3- Outros): ");
			sexo = read.nextInt();
			
				while(sexo<1 || sexo>3) {
				System.out.println("Por favor, digite uma op��o v�lida referente ao sexo da "+pessoas+"� pessoa (1- Feminino / 2- Masculino / 3- Outros): ");
				sexo = read.nextInt();
				}
			
				
			System.out.println("Por favor, digite a op��o referente ao temperamento da "+pessoas+"� pessoa (1- Calma / 2- Nervosa / 3- Agressiva): ");
				temperamento = read.nextInt();
				
					while(temperamento<1 || temperamento>3) {
					System.out.println("Por favor, digite uma op��o v�lida referente ao temperamento da "+pessoas+"� pessoa (1- Calma / 2- Nervosa / 3- Agressiva): ");
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
			
			System.out.println("Voc� deseja incluir os dados de mais uma pessoa (1- Sim / 2- N�o): ");
			repetir = read.nextInt();
			
			while(repetir<1 || repetir>2) {
				System.out.println("Por favor, digite uma op��o poss�vel, para incluir os dados de uma nova pessoa (1- Sim / 2- N�o): ");	
				repetir = read.nextInt();
			}
			
			pessoas++;
			
		}
		
		System.out.println("\nO n�mero de pessoas calmas foi: "+numCalmas+".");	
		System.out.println("O n�mero de mulheres nervosas foi: "+numMulheresNervosas+".");	
		System.out.println("O n�mero de homens agressivos foi: "+numHomensAgressivos+".");
		System.out.println("O n�mero de outros calmos foi: "+numOutrosCalmos+".");
		System.out.println("O n�mero de pessoas nervosas com mais de 40 anos: "+numNervosasMais40+".");
		System.out.println("O n�mero de pessoas calmas com menos de 18 anos: "+numCalmasMenos18+".");

	}

}
