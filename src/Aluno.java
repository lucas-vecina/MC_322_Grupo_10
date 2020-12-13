import java.util.ArrayList;

public class Aluno extends Usuario{
	//Ainda nao utilizamos amigos no programa estamos deixando para uma versao futura
	private ArrayList<Usuario> amigos;
	private String curso;
	private String ra;
	
	//Construtor
	public Aluno(String nome, Genero genero, String email, String senha, Permissoes permissao, String curso, String ra) {
		super(nome, genero, email, senha, permissao);
		this.curso = curso; 
		this.ra = ra;
		amigos = new ArrayList<Usuario>();
	}
	
	/* Metodo sobrescrito em Usuario. 
	 * Verifica permissoes do usuario (this) e exibe informacoes de acordo */
	//Ainda nao utilizamos amigos no programa estamos deixando para uma versao futura
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
	//Ainda nao utilizamos amigos no programa estamos deixando para uma versao futura
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
	
	/* Metodo sobrescrito em Usuario. 
	 * Verifica permissoes do usuario (this) e exibe as turmas */
	//Ainda nao utilizamos amigos no programa estamos deixando para uma versao futura
	public String visualizarTurma(Usuario user) {
		if(this.getPermissao().getChave() != 3 || getAmigos().contains(user)) {
			String out = super.visualizarTurma(user);
			return out;
		}
		
		else
			return "Voce nao tem permissao de visualizar as turmas que " + getNome() + " participa.\n";
	}

	public ArrayList<Usuario> getAmigos() {
		return amigos;
	}

	public void setAmigos(ArrayList<Usuario> amigos) {
		this.amigos = amigos;
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
	
	public void trancarDisciplina(Turma turma) {
		if(getTurmas().contains(turma)) {
			turma.getAlunos().remove(this);
			getTurmas().remove(turma);
		}
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
