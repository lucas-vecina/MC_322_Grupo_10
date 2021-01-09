import java.util.ArrayList;
import java.util.Scanner;

public class Aluno extends Usuario implements Comparable<Aluno>{
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
		user.getSolicitacoes().add(new Solicitacao(this, this.getNome(), Tipo.AMIZADE));
	}
	
	public void aceitarSolicitacao() {
		Scanner scan = new Scanner(System.in);
		if(!(super.getSolicitacoes().isEmpty())){
			System.out.println("Proxima solicitacao: ");
			System.out.println(super.getSolicitacoes().get(0));
			System.out.println("Aceitar? (Y/N) \n");
			while (true) {
				String resposta = scan.next();
				if(resposta == "Y") {
					amigos.add(super.getSolicitacoes().get(0).getUser());
					super.getSolicitacoes().remove(0);
					break;
				}
				if(resposta == "N") {
					super.getSolicitacoes().remove(0);
					break;
				}
			}
			
			if(!(super.getSolicitacoes().isEmpty())) {
				System.out.println("Proxima solicitacao? (Y/N) \n");
				while (true) {
					String resposta = scan.next();
					if(resposta == "Y") {
						this.aceitarSolicitacao();
						break;
					}
					if(resposta == "N") {
						break;
					}
				}
			}
		}
		scan.close();
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
	
	public int compareTo(Aluno outro) {
		if (getNome().compareTo(outro.getNome()) == 1)
			return 1;
		else if (getNome().compareTo(outro.getNome()) == 0)
			return 0;
		else
			return -1; 
	}
	
	public String toString() {
		String out = super.toString();
		out+= "| RA: " + getRa() + "\n";
		out+= "| Curso: " + getCurso() + "\n";
		out+= "| Amigos: [" ;
	
		for(Usuario u:getAmigos())
			out += "-" + u.getNome() + ","; 
		
		out+= "]\n";
		
		return out;
	}
}
