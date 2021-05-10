package Exercicio2;

public class ClasseAviao {
	
	private String modeloAviao;
	private String fabricanteAviao;
	private int capacidadeTotalPassageiros;
	private float porcentagemLotacao;
	private int qntPassageirosEmbarcados;

	
	public ClasseAviao(String modeloAviao, String fabricanteAviao, int capacidadeTotalPassageiros, float porcentagemLotacao, int qntPassageirosEmbarcados) {
		this.modeloAviao = modeloAviao;
		this.fabricanteAviao = fabricanteAviao;
		this.capacidadeTotalPassageiros = capacidadeTotalPassageiros;
		this.porcentagemLotacao = porcentagemLotacao;
		this.qntPassageirosEmbarcados = qntPassageirosEmbarcados;
	}
	
	public void imprimirInfos() {
		System.out.printf("O avi�o %s da fabricante %s e capacidade m�xima de %d passageiros, est� com %2.2f%% de lota��o, pois %d passageiros embarcaram.",modeloAviao, fabricanteAviao,capacidadeTotalPassageiros,porcentagemLotacao,qntPassageirosEmbarcados);
	}
	
}
