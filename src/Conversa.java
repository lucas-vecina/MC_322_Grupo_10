import java.util.ArrayList;

//Disponibiliza um ambiente para interacao e troca de mensagens entre diferentes usuarios
public class Conversa implements Feed{	
	private Grupo pessoas;
	private ArrayList<Mensagem> mensagens; 
	
	public Conversa(ArrayList<Usuario> pessoas) {
		this.pessoas = new Grupo(pessoas);
		getPessoas().adicionarGrupo();
		mensagens = new ArrayList<Mensagem>();
	}

	public Grupo getPessoas() {
		return pessoas;
	}

	public void setPessoas(Grupo pessoas) {
		this.pessoas = pessoas;
	}

	public ArrayList<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(ArrayList<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}
	
	public void enviarMensagem(Usuario remetente, String texto) {
		if(pessoas.getGrupo().contains(remetente)) {
			Mensagem mensagem = new Mensagem(remetente, texto); 
			mensagens.add(mensagem); 
			
			for(Usuario u : pessoas.getGrupo()) {
				u.getNotificacoes().add(0, Notificacoes.NOVA_MENSAGEM);
			}
			adicionarFeed();
		}
	}
		
	public void adicionarUsuario(Usuario integrante, Usuario forasteiro) {
		if(getPessoas().adicionarUsuario(integrante, forasteiro))
			forasteiro.getConversas().add(this);
	}
	
	public void removerUsuario(Usuario integrante, Usuario removido) {
		if(getPessoas().removerUsuario(integrante, removido))
			removido.getConversas().remove(this);
	}
	
	public void adicionarConversa() {
		for(Usuario u:getPessoas().getGrupo())
			u.getConversas().add(this);
	}
	
	public void adicionarFeed() {
		for(Usuario u : pessoas.getGrupo()) {
			if(!((Aluno) u).getFeedAluno().contains(this)) {
				
				if(((Aluno) u).getFeedAluno().size() == 3)
					((Aluno) u).getFeedAluno().remove(2);
				
				((Aluno) u).getFeedAluno().add(0, this);
			}			
		}
	}

	
	@Override
	public String toString() {
		String out = "Pessoas na conversa:";
		for(Usuario pessoa:pessoas.getGrupo()) {
			out = out + "\n" + pessoa.getNome() + " - id:" + pessoa.getId();
		}
		out = out + "\nMensagens:"; 
		for(Mensagem mensagem:mensagens) {
			out = out + "\n" + mensagem; 
		}
		return out + "\n"; 
	}
}
