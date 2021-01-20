package BackEnd;

import java.util.ArrayList;
import java.util.Collections;

public class Aluno extends Usuario implements Feed{
	private ArrayList<Usuario> amigos;
	private ArrayList<Feed> feedAluno;
	private String curso;
	private String ra;
	
	//Construtor
	public Aluno(String nome, Genero genero, String email, String senha, Permissoes permissao, String curso, String ra) {
		super(nome, genero, email, senha, permissao);
		this.curso = curso; 
		this.ra = ra;
		amigos = new ArrayList<Usuario>();
		feedAluno = new ArrayList<Feed>();
	}
	
	public ArrayList<Usuario> getAmigos() {
		return amigos;
	}

	public void setAmigos(ArrayList<Usuario> amigos) {
		this.amigos = amigos;
	}
	
	public ArrayList<Feed> getFeedAluno(){
		return feedAluno;
	}
	
	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}
	
	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	/* Metodo sobrescrito em Usuario. 
	 * Verifica permissoes do usuario (this) e exibe informacoes de acordo */
	@Override
	public String visualizarInfo(Usuario user) {
		String out;
		
		switch(getPermissao().getChave()) {
			case 1:
				out = super.visualizarInfo(user);
				out += "-Curso: " + getCurso() + "\n";
				out += "-RA: " + getRa() + "\n";
				out += "-Amigos: " + visualizarAmigos(user);
				
				return out;
				
			case 2:
				out = super.visualizarInfo(user);
				out += "-Curso: " + getCurso() + "\n";
				return out;
			
			case 3:
				if(getAmigos().contains(user)) {
					out = super.visualizarInfo(user);
					out += "-Curso: " + getCurso() + "\n";
					return out;
				}
				
				else
					return "Voce nao tem permissao para visualizar informacoes desse perfil";	
		}
		return "";
	}
	
	// Verifica permissoes do usuario (this) e exibe sua lista de amigos
	@Override
	public String visualizarAmigos(Usuario user) {
		if(this.getPermissao().getChave() == 1) {
			String out;
			out = "-Amigos: [";
			for(Usuario u:getAmigos())
				out += u.getNome() + ", ";
			out += " ]";
			
			return out;
		}	
		
		else
			return "Voce nao tem permissao para visualizar a lista de amigos de " + getNome() + "\n";
				
	}
	
	public void adicionarSolicitacao(Usuario user) {
		user.getSolicitacoes().add(new Solicitacao(this, user));
		user.getNotificacoes().add(Notificacoes.NOVA_SOLICITACAO);
	}
	
	public void aceitarSolicitacao(Solicitacao solicitacao, boolean resposta) {
		if(getSolicitacoes().contains(solicitacao)){
			Aluno a = (Aluno) solicitacao.getSolicitante();

			if(resposta) {
				
				//Adicionando Usuario a lista de amigos
				amigos.add(a);
				a.getAmigos().add(this);
				
				//Adicionando notificacao
				a.getNotificacoes().add(Notificacoes.NOVO_AMIGO);
				getNotificacoes().add(Notificacoes.NOVO_AMIGO);
				
				//Adicionando ao feed
				adicionarFeed(solicitacao);
				getSolicitacoes().remove(solicitacao);
			}
			
			else {
				a.getNotificacoes().add(Notificacoes.SOLICITACAO_RECUSADA);
				getSolicitacoes().remove(solicitacao);
			}
		}
	}
	
	public void removerAmigo(Aluno amigo) {
		amigos.remove(amigo);
		amigo.getAmigos().remove(this);
	}
	
	 //Verifica permissoes do usuario (this) e exibe as turmas
	@Override
	public String visualizarTurma(Usuario user) {
		if(this.getPermissao().getChave() != 3 || getAmigos().contains(user)) {
			String out = super.visualizarTurma(user);
			return out;
		}
		
		else
			return "Voce nao tem permissao de visualizar as turmas que " + getNome() + " participa.\n";
	}
	
	public void trancarDisciplina(Turma turma) {
		if(getTurmas().contains(turma)) {
			turma.getAlunos().remove(this);
			getTurmas().remove(turma);
		}
	}
	
	public void adicionarFeed() {}
        
        public void adicionarFeed(Solicitacao solicitacao) {
            if(((Aluno) solicitacao.getSolicitante()).getFeedAluno().size() == 3)
		((Aluno) solicitacao.getSolicitante()).getFeedAluno().remove(2);
            ((Aluno) solicitacao.getSolicitante()).getFeedAluno().add(0, this);
            
            if(this.getFeedAluno().size() == 3)
                this.getFeedAluno().remove(2);
            this.getFeedAluno().add(0, (Aluno)solicitacao.getSolicitante()); 
        }
	
	public String exibirFeed() {
		String out;
		out = getNome() + " te adicionou como amigo.";
		out += "INFO: " + "RA: " + ra + "\tEmail: " + getEmail() + "\nCurso: " + curso;
		
		return out;
	}
	
	public String visualizarFeed() {
		String out = "";
		for(Feed f:feedAluno) {
			out += f.exibirFeed() + "\n";
		}
		
		return out;
		
	}
	
	public String toString() {
		String out = super.toString();
		out+= "| RA: " + getRa() + "\n";
		out+= "| Curso: " + getCurso() + "\n";
		out+= "| Amigos: [" ;
	
		for(Usuario u:getAmigos())
			out += "-" + u.getNome() + ","; 
		
		out+= "]\n\n";
		out+= "Feed do aluno: " + getFeedAluno() + "\n";
		
		return out;
	}
}
