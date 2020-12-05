public enum Labels {
	PROVA ("Prova", Cor.VERMELHO),
	ATIVIDADE_INDIVIDUAL ("Atividade individual", Cor.PRETO),
	ATIVIDADE_GRUPO ("Atividade em grupo", Cor.ROXO),
	RELATORIO ("Relatório", Cor.VERDE),
	APRESENTACAO ("Apresentacao", Cor.AMARELO),
	LISTA_EXERCICIOS ("Lista de exercícios", Cor.AZUL);
	
	private final String descricao;
	private final Cor cor;
	
	Labels(String descricao, Cor cor){
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
