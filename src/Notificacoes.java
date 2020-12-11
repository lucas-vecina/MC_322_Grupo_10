public enum Notificacoes {
	NOVA_MENSAGEM("Você recebeu uma nova mensagem!"),
	NOVA_ATIVIDADE("Você tem uma nova atividade para entrega!"),
	NOVO_AMIGO("Você tem um novo amigo!"),
	INICIO_MONITORIA("Uma monitoria acabou de começar!"),
	INICIO_AULA("Uma nova aula foi postada"),
	NOVA_RESPOSTA("Responderam uma dúvida que você fez!"),
	NOVA_NOTA("Postaram a sua nota de uma atividade!");
	
	private final String notificacao;
	
	Notificacoes(String notificacao) {
		this.notificacao = notificacao;
	}

	public String getNotificacao() {
		return notificacao;
	}
}
