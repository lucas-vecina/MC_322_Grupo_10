import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Turma {
	private String turma;
	private String sigla;
	private Cor cor = Cor.LARANJA;	//default, possivel alterar
	private String ementa;
	private Professor professor;
	private ArrayList<Aluno> ped;	// Lista contendo elementos do tipo Aluno com permissões próximas ao do Professor
	private ArrayList<Aluno> pad;	// Lista contendo elementos do tipo Aluno algumas permissões a mais do que um aluno comum
	private ArrayList<Aluno> alunos;	// Lista contendo os Alunos que de fato cursarão a disciplina
	private ArrayList<Evento> agenda;	// Contém labels informando sobre atividades agendadas
	private ArrayList<Teoria> teoria;	// Contém simbolicamente arquivos e conteúdos da disciplina
	private ArrayList<Atividade> atividades;	// Ambiente em que é possível visualizar todas as atividades criadas
	private ArrayList<Monitoria> monitorias;	// Ambiente simbólico para atendimento síncrono do aluno
	private ArrayList<Duvidas> duvidas;		// Ambiente para retirada de dúvidas. Visível a todos os alunos que cursam a disciplina
	
	//Contrutor para ser usado na criacao de turmas pelo professor
	public Turma(String turma, String sigla, Professor professor) {
		this.turma = turma;
		this.sigla = sigla;
		this.professor = professor;
		ped = new ArrayList<Aluno>();
		pad = new ArrayList<Aluno>();
		alunos = new ArrayList<Aluno>();
		agenda = new ArrayList<Evento>();
		teoria = new ArrayList<Teoria>();
		monitorias = new ArrayList<Monitoria>();
		duvidas = new ArrayList<Duvidas>();
	}
	
	/* Um professor ou ped podem criar uma nova atividade.
	 * É feita uma diferenciação entre duas atividades, individual e em grupo. O parâmetro labels as segrega.
	 * Ao fim é enviada uma notificação para cada aluno da turma informando sobre a nova atividade.
	 */
	public void criarAtividade(Usuario user, Turma turma, String titulo, Labels label, String descricao, int notaMaxima, 
			GregorianCalendar dataInicio, GregorianCalendar data) {
		
		if(user instanceof Professor || getPed().contains(user)) {
			if(label == Labels.ATIVIDADE_INDIVIDUAL)
				getAtividades().add(1, new AtividadeIndividual(turma, titulo, label, descricao, notaMaxima, dataInicio, data));
			
			else 
				getAtividades().add(1, new AtividadeGrupo(turma, titulo, label, descricao, notaMaxima, dataInicio, data));

			for(Usuario u: getAlunos()) {
				u.getNotificacoes().add(1, Notificacoes.NOVA_ATIVIDADE);
			}
		}
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public ArrayList<Aluno> getPed() {
		return ped;
	}

	public ArrayList<Aluno> getPad() {
		return pad;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public ArrayList<Evento> getAgenda() {
		return agenda;
	}

	public ArrayList<Teoria> getTeoria() {
		return teoria;
	}

	public ArrayList<Atividade> getAtividades() {
		return atividades;
	}

	public ArrayList<Monitoria> getMonitorias() {
		return monitorias;
	}

	public ArrayList<Duvidas> getDuvidas() {
		return duvidas;
	}
		
	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}
	
	@Override
	public String toString() {
		String out = "\n";
		out+= "-> Disciplina: " + getTurma() + " (" + getSigla() + "," + getCor() + ") \n";
		out+= "-> Ementa: " + getEmenta() + "\n";
		out+= "-> Professor: " + getProfessor().getNome() + "\n";
		out+= "-> PED's: [";
		
		for(Usuario u:getPed())
			out+= u.getNome() + ", ";
		
		out+= "] \n";
		out+= "-> Pad's: [";
		
		for(Usuario u:getPad())
			out+= u.getNome() + ", ";
		
		out+= "] \n";
		out+= "-> Alunos: [";
		
		for(Aluno a:getAlunos())
			out+= a.getNome() + ", ";
		
		out+= "] \n";
		out+= "-> Agenda: " + getAgenda();
		out+= "-> Teoria: " + getTeoria() + "\n";
		out+= "-> Atividades: " + getAtividades();
		out+= "-> Monitorias: " + getMonitorias() + "\n";
		out+= "-> Dúvidas: " + getDuvidas() + "\n";
				
		return out;
	}
}
