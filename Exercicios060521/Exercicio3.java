package Exercicios060521;

import java.util.Scanner;

public class Exercicio3 {

	public static void main(String[] args) {
		/* (Utilizando o la�o While) Solicitar a idade de v�rias pessoas e imprimir: Total de pessoas com menos de
		21 anos. Total de pessoas com mais de 50 anos. O programa termina quando idade for =-99. */
		
		int idade=0, numPessoasMenos21=0, numPessoasMais50=0;
		Scanner read = new Scanner(System.in);
		
		System.out.println("Abaixo, voc� poder� digitar a idade de v�rias pessoas e descobrir quantas s�o mais novas do que 21 anos e quantas s�o mais velhas que 50 anos. O programa continuar� pedindo a idade das pessoas at� ser digitado -99: ");
		while(idade!=-99) {
			System.out.println("Por favor, digite sua idade: ");
			idade = read.nextInt();
			if(idade<21) {
				numPessoasMenos21++;
			}else if(idade>50) {
				numPessoasMais50++;
			}
		}
		
		System.out.println("O total de pessoas que t�m a idade menor que 21 anos �: "+numPessoasMenos21+".");
		System.out.println("O total de pessoas que t�m a idade maior que 50 anos �: "+numPessoasMais50+".");
	}

}
