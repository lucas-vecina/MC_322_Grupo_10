import java.util.ArrayList;

public class Duvidas {
	private Turma turma; 
	private ArrayList<Mensagem> comentarios;
	private Usuario indagador;
	private String indagacao; 
	private boolean resolvido; 
	
	public Duvidas(Usuario indagador, String indagacao, Turma turma) {
		this.turma = turma;
		turma.getDuvidas().add(this);
		this.indagador = indagador;
		this.indagacao = indagacao;
		resolvido = false;
		comentarios = new ArrayList<Mensagem>();
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public ArrayList<Mensagem> getComentarios() {
		return comentarios;
	}

	public void setComentarios(ArrayList<Mensagem> comentarios) {
		this.comentarios = comentarios;
	}

	public Usuario getIndagador() {
		return indagador;
	}

	public void setIndagador(Usuario indagador) {
		this.indagador = indagador;
	}

	public String getIndagacao() {
		return indagacao;
	}

	public void setIndagacao(String indagacao) {
		this.indagacao = indagacao;
	}

	public boolean isResolvido() {
		return resolvido;
	}

	public void setResolvido(boolean resolvido) {
		this.resolvido = resolvido;
	}
	
	public void Replicar(Usuario replicador, String comentario) {
		if (!resolvido && (replicador instanceof Professor || this.turma.getAlunos().contains(replicador))) {
			Mensagem mensagem = new Mensagem(replicador, comentario);
			comentarios.add(mensagem); 
			
			getIndagador().getNotificacoes().add(0, Notificacoes.NOVA_RESPOSTA);
			}
		}
	
	public void Resolver() {
		resolvido = true; 
	}
	
	public String toString() {
		String out = "\n";
		out+= "Indagador: " + getIndagador().getNome() + "\n";
		out+= "Indagacao: " + getIndagacao() + "\n";
		
		out+= "Comentarios: ";
		for(Mensagem m: comentarios) {
			out+= "\n" + m;
		}
		
		out += "\nResolvido? " + (isResolvido() ? "Sim" : "Nao");
				
		return out;
	}
}
