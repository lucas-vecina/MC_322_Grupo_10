public enum Labels {
	PROVA("Prova", Cor.VERMELHO),
	ATIVIDADE_INDIVIDUAL("Atividade individual", Cor.LARANJA),
	ATIVIDADE_GRUPO("Atividade em grupo", Cor.LARANJA), 
	RELATORIO("Relatorio", Cor.AMARELO),
	APRESENTACAO("Apresentacao", Cor.VERDE),
	LISTA_EXERCICIOS("Lista de exercicios", Cor.AZUL);
	
	private final String descricao;
	private final Cor cor; 
	
	Labels(String descricao, Cor cor) {
		this.descricao = descricao;
		this.cor = cor;
	}
	
	public String getDescricao() {
		return descricao; 
	}
	
	public Cor getCor() {
		return cor;
	}
}
