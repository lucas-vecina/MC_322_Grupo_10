public enum Notificacoes {
	NOVA_MENSAGEM("Nova mensagem"),
	NOVA_ATIVIDADE("Nova atividade"),
	NOVO_AMIGO("Novo pedido de amizade"),
	INICIO_AULA("A aula começa daqui a pouco"),
	INICIO_MONITORIA("A monitoria começa daqui a pouco"); 
	
	private final String descricao; 
	
	Notificacoes(String descricao) {
		this.descricao = descricao; 
	}
	
	public String getDescricao() {
		return descricao; 
	}
}