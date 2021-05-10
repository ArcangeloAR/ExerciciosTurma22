package Exercicio1;

import java.util.Scanner;

public class ClassePrincipal {

	public static void main(String[] args) {
		
		/*Crie uma classe cliente e apresente os atributos e métodos referentes esta classe, em seguida crie um objeto cliente, defina as instancias deste
			objeto e apresente as informações deste objeto no console.
		 */
		
		ClasseCliente[] lista = new ClasseCliente[3];
		
		lista[0] = new ClasseCliente("Vanessa",111111,200,400);
		lista[1] = new ClasseCliente("Judith",222222,700,300);
		lista[2] = new ClasseCliente("Thalia",33333,500,500);
		
		for(ClasseCliente percorre:lista)
		{
			percorre.print();
		}


	}

}

