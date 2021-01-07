import java.util.Calendar;
import java.util.GregorianCalendar;

/* A classe Atividade e mae de duas outras especializadas, AtividadeIndividual e AtividadeGrupo.
 * Aqui sao reunidos alguns atributos e metodos comuns a elas.
 * Atividade, por conseguinte, tambem e filha de Evento, pois toda atividade instanciada e diretamente
 * associada a agenda do usuario e da turma.
 * Ainda nao utilizamos plenamente a heranca com Evento, sera melhor explorado na continuacao do projeto */
public abstract class Atividade extends Evento{
	private Calendar dataInicio = new GregorianCalendar();
	private int notaMaxima;
	private Evento agendaTurma;
	private Evento agendaAluno;
	private Turma turma;
	
	public Atividade(Turma turma, String titulo, Labels label, String descricao, int notaMaxima,
			GregorianCalendar dataInicio, GregorianCalendar data) {
	
		// Como o construtor de Evento e sobrecerregado, optou-se por inicializar, por default, aquele associado a Turma
		super(titulo, label, descricao, data, false);
		
		// Um novo objeto agendaTurma e instanciado e adicionado a agenda da turma. Versao futura anulara essa necessidade
		this.agendaTurma = new Evento(titulo, label, descricao, data, false);
		turma.getAgenda().add(0, agendaTurma);	
		
		// Novo objeto de Reuniao e criado, agora para ser incluido a cada agenda de alunos da turma
		this.agendaAluno = new Evento(titulo, label, descricao, turma.getSigla(), turma.getCor(), data, false);
		for(Usuario u:turma.getAlunos()) {
			u.getAgenda().add(0, agendaAluno);
		}
		
		this.dataInicio = dataInicio;
		this.notaMaxima = notaMaxima;
		this.turma = turma;
	}
	
	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public int getNotaMaxima() {
		return notaMaxima;
	}

	public void setNotaMaxima(int notaMaxima) {
		this.notaMaxima = notaMaxima;
	}

	public Evento getAgendaAluno() {
		return agendaAluno;
	}
	
	public Evento getAgendaTurma() {
		return agendaTurma;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public abstract void submeterAtividade(Aluno aluno, Grupo grupo, String arquivo);
	
	public abstract void atribuirNota(Usuario user, Aluno aluno, Grupo grupo, double nota);
	
	public abstract String visualizarNota(Aluno aluno, Grupo grupo);
	
	public String toString() {
		String out = super.toString();	
		out+= "# Nota Maxima: " + getNotaMaxima() + "\n";
		out+= "# Data de inicio: " + getDataInicio().get(Calendar.DAY_OF_MONTH) + "/" + getDataInicio().get(Calendar.MONTH)
				+ " " + getDataInicio().get(Calendar.HOUR_OF_DAY) + ":" + getDataInicio().get(Calendar.MINUTE) + "\n";

		return out;
	}
}
