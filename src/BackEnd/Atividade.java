package BackEnd;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;

/* A classe Atividade e mae de duas outras especializadas, AtividadeIndividual e AtividadeGrupo.
 * Aqui sao reunidos alguns atributos e metodos comuns a elas.
 * Optou-se por interromper a heranca entre Atividade e Evento. Agora Evento eh obtida por meio das instancias agendaTurma e agendaAluno. */
public abstract class Atividade implements Feed{
	private Calendar dataInicio = new GregorianCalendar();
	private int notaMaxima;
	private Evento agendaTurma;
	private Evento agendaAluno;
	private Turma turma;
	private ArrayList<Submissao> submissoes; // Array que armazena a correspondencia entre o aluno a sua atividade (arquivo e nota)
	
	public Atividade(Turma turma, String titulo, Labels label, String descricao, int notaMaxima,
			GregorianCalendar dataInicio, GregorianCalendar data) {

		// Um novo objeto agendaTurma e instanciado e adicionado a agenda da turma. Versao futura anulara essa necessidade
		this.agendaTurma = new Evento(titulo, label, descricao, data, false);
		turma.getAgenda().add(0, agendaTurma);	
		
		// Novo objeto de Reuniao e criado, agora para ser incluido a cada agenda de alunos da turma
		this.agendaAluno = new Evento(titulo, label, descricao, turma.getSigla(), turma.getCor(), data, false);
		for(Usuario u:turma.getAlunos()) {
			u.getAgenda().add(0, agendaAluno);
		}
		
		this.submissoes = new ArrayList<Submissao>();
		this.dataInicio = dataInicio;
		this.notaMaxima = notaMaxima;
		this.turma = turma;
		criaArquivoAtividade();
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
	
	public ArrayList<Submissao> getSubmissoes() {
		return submissoes;
	}
	
	public void submeterAtividade(Aluno aluno, Grupo grupo, String arquivo) {
		try {
			Formatter file = new Formatter("files/" + getTurma().getSigla() + "/Atividades/" + agendaAluno.getTitulo() + "/Submissoes/" + arquivo);
			String out;
			if (aluno != null) {
				out = "Nome do aluno: " + aluno.getNome() + " RA: " + aluno.getRa();
			}
			else {
				out = "Grupo :";
				for (Usuario membro:grupo.getGrupo()) {
					out += "\n- Nome: " + membro.getNome() + " RA: " + ((Aluno)membro).getRa(); 
				}
			}
			file.format("%s", out);
			file.flush(); 
			file.close();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public abstract void atribuirNota(Usuario user, Aluno aluno, Grupo grupo, double nota);
	
	public abstract String visualizarNota(Aluno aluno, Grupo grupo);
	
	public void adicionarFeed() {
		if(getTurma().getMural().size() == 3)
			getTurma().getMural().remove(2);
		
		getTurma().getMural().add(0, this);
		
		for(Aluno a : getTurma().getAlunos()) {
			if(a.getFeedAluno().size() == 3)
				a.getFeedAluno().remove(2);
			
			a.getFeedAluno().add(0, this);
		}
	}
	
	public String exibirFeed() {
		String out = "Voce tem uma nova " + agendaAluno.getLabel().getDescricao() + " na turma " + turma.getSigla() + "\n";
		out += "INFO: " + "Titulo: " + agendaAluno.getTitulo() + "\t Descricao: " + agendaAluno.getDescricao();
		
		return out;
	}
	
	
	private void criaArquivoAtividade() {
		try {
			File folder = new File("files/" + getTurma().getSigla() + "/Atividades/" + agendaAluno.getTitulo());
			folder.mkdir();
			File folder2 = new File("files/" + getTurma().getSigla() + "/Atividades/" + agendaAluno.getTitulo() + "/Submissoes/");
			folder2.mkdir();
			Formatter file = new Formatter("files/" + getTurma().getSigla() + "/Atividades/" + agendaAluno.getTitulo() + "/" + agendaAluno.getTitulo() + ".txt");
			file.format("%s", agendaAluno.getDescricao()); 
			file.flush();
			file.close(); 
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public String toString() {
		String out = super.toString();	
		out+= "# Nota Maxima: " + getNotaMaxima() + "\n";
		out+= "# Data de inicio: " + getDataInicio().get(Calendar.DAY_OF_MONTH) + "/" + getDataInicio().get(Calendar.MONTH)
				+ " " + getDataInicio().get(Calendar.HOUR_OF_DAY) + ":" + getDataInicio().get(Calendar.MINUTE) + "\n";

		return out;
	}
}
