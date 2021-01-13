package BackEnd;
import java.util.ArrayList;

public class Professor extends Usuario{
	
	// Construtor
	public Professor(String nome, Genero genero, String email, String senha) {
		super(nome, genero, email, senha, Permissoes.DEFAULT);
	}
	
	//Metodo para cada professor criar sua turma para inumeras materias
	public Turma criarTurma(String nome, String sigla) {
		Turma t1 = new Turma(nome,sigla,this);
		getTurmas().add(t1);
		
		return t1;
	}
	
	//Remove uma turma especifica de um professor e de todos os alunos matriculados
	public void removeTurma(Turma turma) {
	
		for(int i = 0; i < turma.getAlunos().size(); i++ ) {
			ArrayList<Turma> turmaAluno = turma.getAlunos().get(i).getTurmas();
			turmaAluno.remove(turma);
		}
			
		this.getTurmas().remove(turma);
	}
	
	@Override
	public String visualizarAmigos(Usuario user) {
		return null;
	}
	
	public void adicionarSolicitacao(Usuario user) {
		user.getSolicitacoes().add(new Solicitacao(this, this.getNome(), Tipo.AULA));
	}
	
	public String toString() {
		String out = super.toString();		
		return out;
	}
}
