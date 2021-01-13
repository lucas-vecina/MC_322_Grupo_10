package BackEnd;
public enum Genero {
	FEMININO("Feminino"),
	MASCULINO("Masculino"),
	NAO_BINARIO("Nao binario"),
	NAO_IDENTIFICADO("Nao identificado");
	
	private final String descricao;
	
	Genero(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
