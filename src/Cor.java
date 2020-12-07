public enum Cor {
	VERMELHO("Vermelho"),
	AZUL("Azul"),
	AMARELO("Amarelo"),
	VERDE("Verde"),
	LARANJA("Laranja"); 
	
	private final String descricao;
	
	Cor(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
