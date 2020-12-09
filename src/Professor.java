import java.util.ArrayList;

public class Professor extends Usuario{
	
	private ArrayList<Turmas> materias; // Turmas criadas pelo professor em que ele atua
	
	
	public Professor(String nome, Genero genero, String email, String senha, Permissoes permissao) {
		super(nome, genero, email, senha, permissao);
		materias = new ArrayList<Turmas>();
		// TODO Auto-generated constructor stub
	}
	
	public void criarTurma(String nome) {
		Turma t1 = new Turma(nome,this);
		materias.add(t1);
	}
}
