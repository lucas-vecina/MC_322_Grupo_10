package BackEnd;

public class Solicitacao implements Feed{
	private Usuario solicitante;
	private Usuario receptor;
	private Tipo tipo;
	
	public Solicitacao(Usuario solicitante, Usuario receptor, Tipo tipo) {
		this.solicitante = solicitante;
		this.receptor = receptor;
		this.tipo = tipo;
		adicionarFeed();
		receptor.getNotificacoes().add(Notificacoes.NOVA_SOLICITACAO);
	}

	public Usuario getSolicitante() {
		return solicitante;
	}
	
	public Usuario getReceptor() {
		return receptor;
	}

	public Tipo getTipo() {
		return tipo;
	}	
	
	public void adicionarFeed() {		
		if(((Aluno) receptor).getFeedAluno().size() == 3) {
			((Aluno) receptor).getFeedAluno().remove(2);
		}
		
		((Aluno) receptor).getFeedAluno().add(0, this);
	}
	
	public String exibirFeed() {
		String out = "Voce tem uma nova solicitacao de " + tipo.getDescricao() + " vinda de " 
					+ solicitante.getNome();
		
		return out;
	}
	
	
	public String toString() {
		String out = "";
		out += "Solicitacao de " + tipo + " vinda de " + solicitante.getNome();
		return out;
	}
}