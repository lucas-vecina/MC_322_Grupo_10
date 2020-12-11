import java.util.ArrayList;

public class Professor extends Usuario{
	
	private ArrayList<Turma> materias; // Turmas criadas pelo professor em que ele atua
	
	public Professor(String nome, Genero genero, String email, String senha, Permissoes permissao) {
		super(nome, genero, email, senha, permissao);
		materias = new ArrayList<Turma>();
	}
	
	public String visualizarInfo(Usuario user) {
		String out = super.visualizarInfo(user);
		return out;
	}
	
	//metodo para cada professor criar sua turma para inumeras materias
	public void criarTurma(String nome, String sigla) {
		Turma t1 = new Turma(nome,sigla,this);
		materias.add(t1);
	}
	
	//remove uma turma especifica de um professor e de todos os alunos matriculados
	public void removeTurma(Turma turma) {
	
		for(int i = 0; i < turma.getAlunos().size(); i++ ) {
			ArrayList<Turma> turmaAluno = turma.getAlunos().get(i).getTurmas();
			turmaAluno.remove(turma);
		}
			
		this.materias.remove(turma);
	}
}
