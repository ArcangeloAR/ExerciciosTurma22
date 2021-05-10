package Exercicio3;

public class ClasseEletronicos {
	private String modelo;
	private String marca;
	private String tipo;
	private float valor;
	private int qntEstoque;
	private float valorTotalEstoque;
	
	public ClasseEletronicos(String modelo, String marca, String tipo, float valor, int qntEstoque, float valorTotalEstoque) {
		this.modelo = modelo;
		this.marca = marca;
		this.tipo = tipo;
		this.valor = valor;
		this.qntEstoque = qntEstoque;
		this.valorTotalEstoque = valorTotalEstoque;
	}
	
	public void imprimirInfos() {
		System.out.printf("\nExite em estoque %d aparelhos do tipo %s, modelo %s e marca %s no valor de R$%2.2f, portanto existe R$%2.2f em valor desse produto em estoque.", qntEstoque, tipo, modelo, marca, valor, valorTotalEstoque);
	}
	
}
