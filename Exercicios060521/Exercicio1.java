package Exercicios060521;

public class Exercicio1 {

	public static void main(String[] args) {
		// (Utilizando o laço For) Informar todos os números de 1000 a 1999 que quando divididos por 11 obtemos resto = 5:
		
		int i;
		System.out.println("Abaixo, serão informados todos os números entre 1000 e 1999 que quando divididos por 11 obtem-se o resto de 5: ");
		for(i=1000;i<2000;i++) {
			if(i%11==5) {
				System.out.println(i);
			}
			
		}

	}

}
