import java.util.ArrayList;
import java.util.GregorianCalendar;

/* Essa e uma classe filha de Atividade, especializacao que trata do cenario em que um e disponibilizada uma
 * atividade individual e cada aluno deve submeter e ter sua tarefa avaliada separadamente. */
public class AtividadeIndividual extends Atividade{
	private ArrayList<Submissao> submissoes;	// Array que armazena a correspondencia entre o aluno a sua atividade (arquivo e nota)
	
	// Construtor invocado a partir do metodo criarAtividade() em Turma
	public AtividadeIndividual(Turma turma, String titulo, Labels label, String descricao, int notaMaxima,
			GregorianCalendar dataInicio, GregorianCalendar data) {
		
		super(turma, titulo, label, descricao, notaMaxima, dataInicio, data);
		submissoes = new ArrayList<Submissao>();
	}
	
	public ArrayList<Submissao> getSubmissoes() {
		return submissoes;
	}
	
	// Permite ao aluno enviar sua tarefa. O parametro arquivo simboliza o upload de um documento de texto
		public void submeterAtividade(Aluno aluno, String arquivo) {
			if(getTurma().getAlunos().contains(aluno))	// Verifica-se se o alumo de fato pertence a turma
					getSubmissoes().add(new Submissao(aluno, arquivo));	// Vincula o arquivo ao aluno no vetor submissoes
		}
		
		// Permite ao um administrador(ped ou professor) atribuir nota ao aluno
		public void atribuirNota(Usuario user, Aluno aluno, double nota) {
			if(super.atribuirNota(user)){
				for(Submissao s:getSubmissoes()) {	// Faz a busca do aluno no vetor que contem submissões ja feitas
					if(s.getAluno() == aluno) {
						s.setNota(nota);
						break;
					}
				}
				aluno.getNotificacoes().add(1, Notificacoes.NOVA_NOTA);
			}		
		}
		
		// Permite ao aluno visualizar sua nota
		public String visualizarNota(Aluno aluno) {
			double aux = -2;	// variavel de controle de saída
			
			for(Submissao s:getSubmissoes()) { // Busca pelo aluno no vetor submissoes
				if(s.getAluno() == aluno) {
					aux = s.getNota();
					break;
				}
			}
			
			return "<" + aluno.getNome() + ">" + super.visualizarNota(aux);
		}
	
	public String toString() {
		String out = super.toString();	
		out += "# Submissoes: ";
		for(Submissao s: submissoes) {
			out += "\n" + s;
		}
		
		return out;
	}
}
