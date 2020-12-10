import java.util.ArrayList;
import java.util.GregorianCalendar;

public class AtividadeIndividual extends Atividade{
	
	/*Essa é uma classe filha de Atividade, especialização que trata do cenário em que um é disponibilizada uma
	 * atividade individual e cada aluno deve submeter e ter sua tarefa avaliada separadamente.
	 */
	
	// Array que armazena a correspondência entre o aluno a sua atividade (arquivo e nota)
	private ArrayList<Submissao> submissoes;	
	
	// Construtor invocado a partir do método criarAtividade() em Turma
	public AtividadeIndividual(Turma turma, String titulo, Labels label, String descricao, int notaMaxima,
			GregorianCalendar dataInicio, GregorianCalendar data) {
		
		super(turma, titulo, label, descricao, notaMaxima, dataInicio, data);
		submissoes = new ArrayList<Submissao>();
	}
	
	// Permite ao aluno enviar sua tarefa. O parâmetro arquivo simboliza o upload de um documento de texto
	public void submeterAtividade(Aluno aluno, String arquivo) {
		if(getTurma().getAlunos().contains(aluno))	// Verifica-se se o alumo de fato pertence a turma
				getSubmissoes().add(new Submissao(aluno, arquivo));	// Vincula o arquivo ao aluno no vetor submissoes
	}
	
	// Permite ao um administrador(ped ou professor) atribuir nota ao aluno
	public void atribuirNota(Usuario user, Aluno aluno, double nota) {
		if(super.atribuirNota(user)){
			for(Submissao s:getSubmissoes()) {	// Faz a busca do aluno no vetor que contém submissões já feitas
				if(s.getAluno() == aluno) {
					s.setNota(nota);
					break;
				}
			}
		}		
	}
	
	// Permite ao aluno visualizar sua nota
	public String visualizarNota(Aluno aluno) {
		double aux = -2;
		
		for(Submissao s:getSubmissoes()) { // Busca pelo aluno no vetor submissoes
			if(s.getAluno() == aluno) {
				aux = s.getNota();
				break;
			}
		}
		
		return super.visualizarNota(aux);
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
