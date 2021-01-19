package BackEnd;

public enum Tipo {
	AMIZADE ("amizade"), 
	GRUPO ("grupo"),
	AULA ("aula");
	
	String descricao;
	
	private Tipo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
