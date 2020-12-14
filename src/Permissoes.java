public enum Permissoes {
	PUBLIC (1, "Permissao Publica: Qualquer um pode visualizar grande parte das suas informacoes e lhe enviar mensagens."),
	DEFAULT (2, "Permissao Default: Qualquer um pode visualizar algumas de suas informacoes e lhe enviar mensagens."),
	
	/* Ainda nao utilizamos amigos no programa estamos deixando para uma versao futura. Logo essa constante PRIVATE
	 * ainda nao esta plenamente funcional. */
	PRIVATE (3, "Permissao Privada: Somente amigos podem visualizar algumas de suas informacoes e lhe enviar mensagens.");
	
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
