package BackEnd;
public enum Labels {
	ATIVIDADE_INDIVIDUAL ("Atividade individual", Cor.AZUL),
	ATIVIDADE_GRUPO ("Atividade em grupo", Cor.VERDE);

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
