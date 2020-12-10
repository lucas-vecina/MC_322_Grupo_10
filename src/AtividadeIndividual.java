import java.util.ArrayList;
import java.util.GregorianCalendar;

public class AtividadeIndividual extends Atividade{
	private ArrayList<Submissao> submissoes;
	
	public AtividadeIndividual(Turma turma, String titulo, Labels label, String descricao, int notaMaxima, GregorianCalendar dataInicio, GregorianCalendar data) {
		super(turma, titulo, label, descricao, notaMaxima, dataInicio, data);
		submissoes = new ArrayList<Submissao>();
	}
	
	public void submeterAtividade(Aluno aluno, String arquivo) {
		if(getTurma().getAlunos().contains(aluno))
				getSubmissoes().add(new Submissao(aluno, arquivo));
	}
	
	public void atribuirNota(Usuario user, Aluno aluno, double nota) {
		if(super.atribuirNota(user, aluno)){
			for(Submissao s:getSubmissoes()) {
				if(s.getAluno() == aluno) {
					s.setNota(nota);
					break;
				}
			}
		}		
	}
	
	public String visualizarNota(Aluno aluno) {
		double aux = 0;
		boolean verif = false;
		
		for(Submissao s:getSubmissoes()) {
			if(s.getAluno() == aluno) {
				aux = s.getNota();
				verif = true;
				break;
			}
		}
		
		if(!verif)
			return "Você não entregou essa atividade.";
		
		if(aux == -1)
			return "Nota ainda não atribuída.";
		
		return "Nota: " + Double.toString(aux);
			
	}


	public ArrayList<Submissao> getSubmissoes() {
		return submissoes;
	}
	
	public String toString() {
		String out = super.toString();	
		out += "# Submissões: " + getSubmissoes() + "\n";
		
		return out;
	}
	

}
