public enum Permissoes {
	PUBLIC (1, "Permissão Pública: Qualquer um pode visualizar grande parte das suas informações e lhe enviar mensagens."),
	DEFAULT (2, "Permissão Default: Qualquer um pode visualizar algumas de suas informações e lhe enviar mensagens."),
	PRIVATE (3, "Permissão Privada: Somente amigos podem visualizar algumas de suas informações e lhe enviar mensagens.");
	
	int chave;
	String descricao;
	
	private Permissoes(int chave, String descricao) {
		this.chave = chave;
		this.descricao = descricao;
	}

	public int getChave() {
		return chave;
	}

	public String getDescricao() {
		return descricao;
	}
}
