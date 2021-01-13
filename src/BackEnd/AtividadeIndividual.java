package BackEnd;
import java.util.GregorianCalendar;

/* Essa e uma classe filha de Atividade, especializacao que trata do cenario em que um e disponibilizada uma
 * atividade individual e cada aluno deve submeter e ter sua tarefa avaliada separadamente. */
public class AtividadeIndividual extends Atividade{
	
	// Construtor invocado a partir do metodo criarAtividade() em Turma
	public AtividadeIndividual(Turma turma, String titulo, Labels label, String descricao, int notaMaxima,
			GregorianCalendar dataInicio, GregorianCalendar data) {
		
		super(turma, titulo, label, descricao, notaMaxima, dataInicio, data);
	}
	
	// Permite ao aluno enviar sua tarefa. O parametro arquivo simboliza o upload de um documento de texto
	// Parametro grupo nao utilizado nesse e proximos metodos. Necessario para garantir polimorfismo
	@Override
	public void submeterAtividade(Aluno aluno, Grupo grupo, String arquivo) {
		if(getTurma().getAlunos().contains(aluno))	{// Verifica-se se o alumo de fato pertence a turma
				getSubmissoes().add(new Submissao(aluno, arquivo));	// Vincula o arquivo ao aluno no vetor submissoes
				super.submeterAtividade(aluno, grupo, arquivo); 
		}
	}
	
	// Permite ao um administrador(ped ou professor) atribuir nota ao aluno
	@Override
	public void atribuirNota(Usuario user, Aluno aluno, Grupo grupo, double nota) {
		if(user instanceof Professor || getTurma().getPed().contains(user)){
			for(Submissao s:getSubmissoes()) {	// Faz a busca do aluno no vetor que contem submissões ja feitas
				if(s.getAluno() == aluno) {
					s.setNota(nota);
					s.adicionarFeed();
					break;
				}
			}
			aluno.getNotificacoes().add(1, Notificacoes.NOVA_NOTA);
		}		
	}
	
	// Permite ao aluno visualizar sua nota
	@Override
	public String visualizarNota(Aluno aluno, Grupo grupo) {
		double aux = -2;	// variavel de controle de saída
		String out;
		
		for(Submissao s:getSubmissoes()) { // Busca pelo aluno no vetor submissoes
			if(s.getAluno() == aluno) {
				aux = s.getNota();
				break;
			}
		}
		
		switch((int) aux){
			case -2:
				out = "Voce nao entregou essa atividade.";
	
			case -1:
				out = "Sua nota ainda nao foi atribuida.";
			
			default:
				out = "Sua nota foi: " + Double.toString(aux) + "/" + getNotaMaxima();
		}
		
		return "<" + aluno.getNome() + ">" + out;
	}
	
	public String toString() {
		String out = super.toString();	
		out += "# Submissoes: ";
		
		for(Submissao s: getSubmissoes()) {
			out += "\n" + s;
		}
		
		return out;
	}
}
