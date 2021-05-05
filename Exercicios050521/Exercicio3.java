package Exercicios050521;

import java.util.Scanner;

public class Exercicio3 {

	public static void main(String[] args) {
		/*(Utilizando apenas laço condicional) Faça um programa que receba a idade de uma pessoa e mostre na saída em qual categoria ela se encontra:
			- 10-14 infantil;
			- 15-17 juvenil;
			- 18-25 adulto.
		
		 */
		
		int idade1, idade2, idade3;
		Scanner read = new Scanner(System.in);
		
		System.out.println("Abaixo, por favor, digite a idade de três pessoas para descobrir em qual cadegoria cada uma delas se encontra: ");
		System.out.println("Por favor, digite a primeira idade: ");
		idade1 = read.nextInt();
		System.out.println("Por favor, digite a segunda idade: ");
		idade2 = read.nextInt();
		System.out.println("Por favor, digite a terceira idade: ");
		idade3 = read.nextInt();
		
		if(idade1>=10 && idade1<=14) {
			System.out.println("A categoria que a pessoa se encontra é a Infantil.");
		} else if(idade1>=15 && idade1<=17) {
			System.out.println("A categoria que a pessoa se encontra é a Juvenil.");
		} else if(idade1>=18 && idade1<=25) {
			System.out.println("A categoria que a pessoa se encontra é a Adulto.");
		} else if(idade1<10 || idade1>25) {
			System.out.println("A idade digitada não está apta para nenhuma categoria.");
		}

		if(idade2>=10 && idade2<=14) {
			System.out.println("A categoria que a pessoa se encontra é a Infantil.");
		} else if(idade2>=15 && idade2<=17) {
			System.out.println("A categoria que a pessoa se encontra é a Juvenil.");
		} else if(idade2>=18 && idade2<=25) {
			System.out.println("A categoria que a pessoa se encontra é a Adulto.");
		} else if(idade2<10 || idade2>25) {
			System.out.println("A idade digitada não está apta para nenhuma categoria.");
		}
		
		if(idade3>=10 && idade3<=14) {
			System.out.println("A categoria que a pessoa se encontra é a Infantil.");
		} else if(idade3>=15 && idade3<=17) {
			System.out.println("A categoria que a pessoa se encontra é a Juvenil.");
		} else if(idade3>=18 && idade3<=25) {
			System.out.println("A categoria que a pessoa se encontra é a Adulto.");
		} else if(idade3<10 || idade3>25) {
			System.out.println("A idade digitada não está apta para nenhuma categoria.");
		}
		
	}

}
