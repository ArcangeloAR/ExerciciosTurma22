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
		System.out.printf("O avião %s da fabricante %s e capacidade máxima de %d passageiros, está com %2.2f%% de lotação, pois %d passageiros embarcaram.",modeloAviao, fabricanteAviao,capacidadeTotalPassageiros,porcentagemLotacao,qntPassageirosEmbarcados);
	}
	
}
