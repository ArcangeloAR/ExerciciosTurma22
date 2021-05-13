package Exercicio13052021;

import java.util.ArrayList;
import java.util.Scanner;

public class Estoque {

	public static void main(String[] args) {
		
		int opcao=5;
		
		Scanner read = new Scanner(System.in);
		
		ArrayList<String> estoque = new ArrayList();
		
		do {
			System.out.println("\n--------------------------------------------");
			System.out.println("\nPor favor, digite uma op��o de acordo com a lista abaixo: "
					+ "\n\t1. Adicionar novos produtos ao estoque;"
					+ "\n\t2. Remover produtos do estoque;"
					+ "\n\t3. Atualizar produtos ao estoque;"
					+ "\n\t4. Mostrar todos os produtos"
					+ "\n\t5. Sair do programa."
					+ "\nPor favor, digite sua op��o:");

			try {
				opcao = read.nextInt();
			}catch(Exception erro){
				System.err.println("\nPor favor, execute o programa novamente e digite um n�mero de acordo com a lista de op��es.");
			}
			
			while(opcao<1 || opcao>5) {
				System.out.println("\nPor favor, digite uma op��o v�lida: ");
			}
			
			switch(opcao) {
			
			case 1:
				System.out.println("\nPor favor, digite o produto para adiciona-lo ao estoque: ");
				String produto = read.next();
				estoque.add(produto);
				
			break;
			
			
			case 2:
				System.out.println("\nPor favor, digite o produto para remove-lo do estoque: ");
				String produto1 = read.next();
				if(estoque.contains(produto1)) {			
					estoque.remove(produto1);
				} else {
					System.out.println("\nProduto n�o foi encontrado em estoque.");
				}
				
			break;
			
			
			case 3:
				System.out.println("\nPor favor, digite o produto que deseja atualizar: ");
				String verifica = read.next();
				System.out.println("\nDigite o produto que atualizar� "+verifica+": ");
				String novoProduto = read.next();
				if(estoque.contains(verifica)) { 			
					estoque.remove(verifica);
					estoque.add(novoProduto);
				} else {
					System.out.println("\nProduto n�o foi encontrado em estoque.");
				}
			break;
			
			
			case 4:
				System.out.println("\nOs produtos que est�o atualmente no estoque s�o: "+estoque);
			break;
			
			default:
				System.out.println("O programa est� sendo finalizado, obrigado por utiliza-lo.");
			
			}
		
		} while(opcao!=5);

	}

}

