package Exercicios060521;

import java.util.Scanner;

public class Exercicio3 {

	public static void main(String[] args) {
		/* (Utilizando o laço While) Solicitar a idade de várias pessoas e imprimir: Total de pessoas com menos de
		21 anos. Total de pessoas com mais de 50 anos. O programa termina quando idade for =-99. */
		
		int idade=0, numPessoasMenos21=0, numPessoasMais50=0;
		Scanner read = new Scanner(System.in);
		
		System.out.println("Abaixo, você poderá digitar a idade de várias pessoas e descobrir quantas são mais novas do que 21 anos e quantas são mais velhas que 50 anos. O programa continuará pedindo a idade das pessoas até ser digitado -99: ");
		while(idade!=-99) {
			System.out.println("Por favor, digite sua idade: ");
			idade = read.nextInt();
			if(idade<21) {
				numPessoasMenos21++;
			}else if(idade>50) {
				numPessoasMais50++;
			}
		}
		
		System.out.println("O total de pessoas que têm a idade menor que 21 anos é: "+numPessoasMenos21+".");
		System.out.println("O total de pessoas que têm a idade maior que 50 anos é: "+numPessoasMais50+".");
	}

}
