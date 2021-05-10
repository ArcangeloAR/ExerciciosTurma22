package Exercicio1;

import java.text.NumberFormat;

public class ClasseCliente {

	private String nomeCliente;
	private double cpfCliente;
	private double valorCompra;
	private double valorPagamento;
	
	public ClasseCliente(String nomeCliente, double cpfCliente, double valorCompra, double valorPagamento) {
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.valorCompra = valorCompra;
		this.valorPagamento = valorPagamento;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public double getValorCompra() {
		return valorCompra;
	}
	
	public void setValorCompra(){
		this.valorCompra = valorCompra;
	}
	
	public String formatarMoeda() {
		NumberFormat moeda = NumberFormat.getCurrencyInstance();
		moeda.setMinimumFractionDigits(2);
		String moedaFormatada = moeda.format(valorCompra);
		return moedaFormatada;
	}
	
	public void print() {
		if(valorCompra<=valorPagamento) {
			System.out.printf("\nO(A) cliente %s de CPF %2.0f efetuou o pagamento de %s.",nomeCliente,cpfCliente,this.formatarMoeda());
		}
		else {
			System.out.printf("\nValor insuficiente.");
		}
	}
	
}


	
	
