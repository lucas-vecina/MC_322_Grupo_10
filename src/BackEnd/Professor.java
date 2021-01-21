package BackEnd;
import java.util.ArrayList;
import java.util.HashMap;

public class Professor extends Usuario{
	
	// Construtor
	public Professor(String nome, Genero genero, String email, String senha) {
		super(nome, genero, email, senha, Permissoes.DEFAULT);
	}
	
	//Metodo para cada professor criar sua turma para inumeras materias
	public Turma criarTurma(String nome, String sigla, HashMap<Integer,ArrayList<Integer>> horarios, String ementa) {
		Turma t1 = new Turma(nome,sigla,this, horarios, ementa);
		getTurmas().add(t1);
		
		return t1;
	}
	
	//Remove uma turma especifica de um professor e de todos os alunos matriculados
	public void removeTurma(Turma turma) {
	
		for(int i = 0; i < turma.getAlunos().size(); i++) {
			ArrayList<Turma> turmaAluno = turma.getAlunos().get(i).getTurmas();
			turmaAluno.remove(turma);
		}
                for(int i = 0; i < turma.getPed().size(); i++) { 
                        ArrayList<Turma> turmaPed = turma.getPed().get(i).getTurmas(); 
                        turmaPed.remove(turma); 
                }
                for(int i = 0; i < turma.getPad().size(); i++) {
                    ArrayList<Turma> turmaPad = turma.getPad().get(i).getTurmas();
                    turmaPad.remove(turma); 
                }
		this.getTurmas().remove(turma);
	}
	
	@Override
	public String visualizarAmigos(Usuario user) {
		return null;
	}
	
	public String toString() {
		String out = super.toString();		
		return out;
	}
}
