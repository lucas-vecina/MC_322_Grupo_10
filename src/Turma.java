import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Turma {
	private String turma;
	private String sigla;
	private Cor cor = Cor.LARANJA;	//default, possivel alterar
	private String ementa;
	private Professor professor;
	private ArrayList<Aluno> ped;	// Lista contendo elementos do tipo Aluno com permissoees proximas ao do Professor
	private ArrayList<Aluno> pad;	// Lista contendo elementos do tipo Aluno algumas permissoes a mais do que um aluno comum
	private ArrayList<Aluno> alunos;	// Lista contendo os Alunos que de fato cursarao a disciplina
	private ArrayList<Evento> agenda;	// Contem labels informando sobre atividades agendadas
	private ArrayList<Teoria> teoria;	// Contem simbolicamente arquivos e conteudos da disciplina
	private ArrayList<Atividade> atividades;	// Ambiente em que e possivel visualizar todas as atividades criadas
	private ArrayList<Monitoria> monitorias;	// Ambiente simbolico para atendimento sincrono do aluno
	private ArrayList<Duvidas> duvidas;		// Ambiente para retirada de duvidas. Visivel a todos os alunos que cursam a disciplina
	
	//Contrutor para ser usado na criacao de turmas pelo professor
	public Turma(String turma, String sigla, Professor professor) {
		this.turma = turma;
		this.sigla = sigla;
		this.professor = professor;
		ped = new ArrayList<Aluno>();
		pad = new ArrayList<Aluno>();
		alunos = new ArrayList<Aluno>();
		agenda = new ArrayList<Evento>();
		atividades = new ArrayList<Atividade>();
		teoria = new ArrayList<Teoria>();
		monitorias = new ArrayList<Monitoria>();
		duvidas = new ArrayList<Duvidas>();
	}
	
	/* Um professor ou ped podem criar uma nova atividade.
	 * E feita uma diferenciacao entre duas atividades, individual e em grupo. O parametro labels as segrega.
	 * Ao fim e enviada uma notificacao para cada aluno da turma informando sobre a nova atividade. */
	public Atividade criarAtividade(Usuario user, String titulo, Labels label, String descricao, int notaMaxima, 
			GregorianCalendar dataInicio, GregorianCalendar data) {
		
		if(user instanceof Professor || getPed().contains(user)) {
			
			for(Usuario u: getAlunos()) {
				u.getNotificacoes().add(0, Notificacoes.NOVA_ATIVIDADE);
			}
			
			if(label == Labels.ATIVIDADE_INDIVIDUAL) {
				AtividadeIndividual atividade = new AtividadeIndividual(this, titulo, label, descricao, notaMaxima, dataInicio, data);
				getAtividades().add(0, atividade);
				return atividade;
			}
			
			else {
				AtividadeGrupo atividade= new AtividadeGrupo(this, titulo, label, descricao, notaMaxima, dataInicio, data);
				getAtividades().add(0, atividade);
				return atividade;
			}
		}
		return null;
	}
	
	// Possibilita um aluno criar uma nova duvida
	public Duvidas criarDuvida(Aluno aluno, String indagacao) {
		if(!getAlunos().contains(aluno))
			return null;
		
		Duvidas duvida = new Duvidas(aluno, indagacao, this);
		return duvida;
	}
	
	public Teoria criarTeoria(Usuario user, String descricao, String arquivos) {
		if(user == professor) {
			Teoria t1 = new Teoria(descricao,arquivos);
			t1.submeterTeoria(this);
			return t1;
		} else {
			return null;
		}
	}
	
	public Monitoria criarMonitoria(Aluno monitor) {
		if (ped.contains(monitor) || pad.contains(monitor)) {
			Monitoria monitoria = new Monitoria(monitor, this);
			for(Usuario u: getAlunos()) {
				u.getNotificacoes().add(0, Notificacoes.INICIO_MONITORIA);
			}
			return monitoria;
		}else {
			return null;
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
	
	public void setPed(ArrayList<Aluno> ped) {
		this.ped = ped;
	}

	public void setPad(ArrayList<Aluno> pad) {
		this.pad = pad;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public String toString() {
		String out = "\n";
		out+= "-> Disciplina: " + getTurma() + " (" + getSigla() + ", " + getCor() + ") \n";
		out+= "-> Ementa: " + getEmenta() + "\n";
		out+= "-> Professor: " + getProfessor().getNome() + "\n";
		out+= "-> PED's: [";
		
		for(Usuario u:getPed()) {
			out+= u.getNome();
			
			if(getPed().indexOf(u) != getPed().size() - 1)
				out+= ", ";
		}
		
		out+= "] \n";
		out+= "-> Pad's: [";
		
		for(Usuario u:getPad()) {
			out+= u.getNome();
			
			if(getPad().indexOf(u) != getPad().size() - 1)
				out+= ", ";
		}
			
		out+= "] \n";
		out+= "-> Alunos: [";
		
		for(Aluno a:getAlunos()) {
			out+= a.getNome();
		
			if(getAlunos().indexOf(a) != getAlunos().size() -1)
				out+= ", ";
		}
		
		out+= "] \n";
		out+= "\n-> Agenda: " + getAgenda();
		out+= "-> Teoria: " + getTeoria() + "\n";
		out+= "-> Atividades: " + getAtividades();
		out+= "-> Monitorias: " + getMonitorias() + "\n";
		out+= "-> Duvidas: " + getDuvidas() + "\n";
				
		return out;
	}
	
	public void removePed(Usuario user, Aluno aluno) {
		if(user == professor && ped.contains(aluno)) {
			ped.remove(aluno);
		}
	}
	
	public void adicionaPed(Usuario user, Aluno aluno) {
		if(user == professor) {
			ped.add(aluno);
		}
	}
	
	public void adicionaAluno(Usuario user, Aluno aluno) {
		if(user == professor) {
			alunos.add(aluno);
			aluno.getTurmas().add(this);
		}
	}
	
	public void removeAluno(Usuario user, Aluno aluno) {
		if(user == professor && alunos.contains(aluno)) {
			alunos.remove(aluno);
			aluno.getTurmas().remove(this);
		}
	}
	
	public void removePad(Usuario user, Aluno aluno) {
		if(user == professor && pad.contains(aluno)) {
			pad.remove(aluno);
		}
	}
	
	public void adicionaPad(Usuario user, Aluno aluno) {
		if(user == professor) {
			pad.add(aluno);
		}
	}
	
	

}
