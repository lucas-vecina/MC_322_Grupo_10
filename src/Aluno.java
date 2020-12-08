import java.util.ArrayList;

public class Aluno extends Usuario{
	private ArrayList<Usuario> amigos;
	private String curso;
	
	public Aluno(String nome, Genero genero, String email, String senha, Permissoes permissao, String curso) {
		super(nome, genero, email, senha, permissao);
		this.curso = curso; 
		amigos = new ArrayList<Usuario>();
	}

	public ArrayList<Usuario> getAmigos() {
		return amigos;
	}

	public void setAmigos(ArrayList<Usuario> amigos) {
		this.amigos = amigos;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
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
}
