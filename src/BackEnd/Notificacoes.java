package BackEnd;
public enum Notificacoes {
	NOVA_MENSAGEM("Voce recebeu uma nova mensagem!"),
	NOVA_ATIVIDADE("Voce tem uma nova atividade para entrega!"),
	NOVO_AMIGO("Voce tem um novo amigo!"),
	NOVA_SOLICITACAO("Voce tem uma nova solicitacao"),
	SOLICITACAO_RECUSADA("Sua solicitacao nao foi aceita"),
	INICIO_MONITORIA("Uma monitoria acabou de comecar!"),
	NOVA_AULA("Uma nova aula foi postada"),
	NOVA_RESPOSTA("Responderam uma duvida que voce fez!"),
	NOVA_NOTA("Postaram a sua nota de uma atividade!");
	
	private final String notificacao;
	
	Notificacoes(String notificacao) {
		this.notificacao = notificacao;
	}

	public String getNotificacao() {
		return notificacao;
	}
}
