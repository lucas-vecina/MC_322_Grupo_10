import java.util.ArrayList;

public class Aluno extends Usuario{
	private ArrayList<Usuario> amigos;
	private String curso;
	private int ra;
	
	//Construtor
	public Aluno(String nome, Genero genero, String email, String senha, Permissoes permissao, String curso, int ra) {
		super(nome, genero, email, senha, permissao);
		this.curso = curso; 
		this.ra = ra;
		amigos = new ArrayList<Usuario>();
	}
	
	/* Método sobrescrito em Usuario. 
	 * Verifica permissoes do usuario (this) e exibe informacoes de acordo */
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
					return "Você não tem permissão para visualizar informações desse perfil";	
		}
		return "";
	}
	
	// Verifica permissoes do usuario (this) e exibe sua lista de amigos
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
			return "Você não tem permissão para visualizar a lista de amigos de " + getNome() + "\n";
				
	}
	
	/* Método sobrescrito em Usuario. 
	 * Verifica permissoes do usuario (this) e exibe as turmas */
	public String visualizarTurma(Usuario user) {
		if(this.getPermissao().getChave() != 3 || getAmigos().contains(user)) {
			String out = super.visualizarTurma(user);
			return out;
		}
		
		else
			return "Você não tem permissão de visualizar as turmas que " + getNome() + " participa.\n";
	}

	public ArrayList<Usuario> getAmigos() {
		return amigos;
	}

	public void setAmigos(ArrayList<Usuario> amigos) {
		this.amigos = amigos;
	}
	
	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	//******************Nao seria um metodo de Usuario???
	public void criarGrupo(String nome, ArrayList<Usuario> membros) {
		Grupo grupo = new Grupo(nome, membros);
		grupo.getGrupo().add(this);
		this.getGrupos().add(grupo);
		for(Usuario membro:membros) 
			membro.getGrupos().add(grupo); 
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
