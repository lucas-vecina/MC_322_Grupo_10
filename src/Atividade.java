import java.util.Calendar;
import java.util.GregorianCalendar;

public class Atividade extends Evento{
	private Calendar dataInicio = new GregorianCalendar();
	private int notaMaxima;
	private Evento agendaAluno;
	private Turma turma;
	
	public Atividade(Turma turma, String titulo, Labels label, String descricao, int notaMaxima, GregorianCalendar dataInicio, GregorianCalendar data) {
		super(titulo, label, descricao, data, false);
		turma.getAgenda().add(0, (Evento) this);
			
		this.agendaAluno = new Evento(titulo, label, descricao, turma.getSigla(), turma.getCor(), data, false);
		for(Usuario u:turma.getAlunos()) {
			u.getAgenda().add(0, agendaAluno);
		}
		
		this.dataInicio = dataInicio;
		this.notaMaxima = notaMaxima;
		this.turma = turma;
	}
	
	public boolean atribuirNota(Usuario user, Aluno aluno) {
		if (user instanceof Professor || turma.getPed().contains(user)) {
			return true;
		}
		return false;
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

	public void setAgendaAluno(Evento agendaAluno) {
		this.agendaAluno = agendaAluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public String toString() {
		String out = super.toString();	
		out+= "# Data de início: " + getDataInicio().get(Calendar.DAY_OF_MONTH) + "/" + getDataInicio().get(Calendar.MONTH)
				+ " " + getDataInicio().get(Calendar.HOUR_OF_DAY) + ":" + getDataInicio().get(Calendar.MINUTE) + "\n";

		return out;
	}
}
