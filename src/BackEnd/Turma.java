package BackEnd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;

public class Turma {
	private String turma;
	private String sigla;
	private Cor cor = Cor.LARANJA;	//default, possivel alterar
	private String ementa;
	private Professor professor;
	private HashMap <Integer, ArrayList<Integer>> horarios;
	private ArrayList<Aluno> ped;	// Lista contendo elementos do tipo Aluno com permissoees proximas ao do Professor
	private ArrayList<Aluno> pad;	// Lista contendo elementos do tipo Aluno algumas permissoes a mais do que um aluno comum
	private ArrayList<Aluno> alunos;	// Lista contendo os Alunos que de fato cursarao a disciplina
	private ArrayList<Evento> agenda;	// Contem labels informando sobre atividades agendadas
	private ArrayList<Teoria> teoria;	// Contem simbolicamente arquivos e conteudos da disciplina
	private ArrayList<Atividade> atividades;	// Ambiente em que e possivel visualizar todas as atividades criadas
	private ArrayList<Monitoria> monitorias;	// Ambiente simbolico para atendimento sincrono do aluno
	private ArrayList<Duvidas> duvidas;		// Ambiente para retirada de duvidas. Visivel a todos os alunos que cursam a disciplina
	private ArrayList<Feed> mural;		// Feed da turma
	
	//Contrutor para ser usado na criacao de turmas pelo professor
	
	public Turma(String turma, String sigla, Professor professor, HashMap<Integer,ArrayList<Integer>> horarios) {
		this.turma = turma;
		this.sigla = sigla;
		this.professor = professor;
		this.horarios = horarios;
		ped = new ArrayList<Aluno>();
		pad = new ArrayList<Aluno>();
		alunos = new ArrayList<Aluno>();
		agenda = new ArrayList<Evento>();
		atividades = new ArrayList<Atividade>();
		teoria = new ArrayList<Teoria>();
		monitorias = new ArrayList<Monitoria>();
		duvidas = new ArrayList<Duvidas>();
		mural = new ArrayList<Feed>();
		criarPastas();
	}
	
	public String getTurma() {
		return turma;
	}
	
	public HashMap<Integer, ArrayList<Integer>> getHorarios(){
		return horarios;
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
	
	public ArrayList<Feed> getMural() {
		return mural;
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
				atividade.adicionarFeed();
				return atividade;
			}
			
			else {
				AtividadeGrupo atividade= new AtividadeGrupo(this, titulo, label, descricao, notaMaxima, dataInicio, data);
				getAtividades().add(0, atividade);
				atividade.adicionarFeed();
				return atividade;
			}
		}
		return null;
	}
	
	// Possibilita um aluno criar uma nova duvida
	public Duvidas criarDuvida(Aluno aluno, String indagacao) {		
		Duvidas duvida = new Duvidas(aluno, indagacao, this);
                return duvida;
	}
	
	public Teoria criarTeoria(Usuario user, String descricao, String arquivos) {
		if(user == professor) {
			Teoria t1 = new Teoria(descricao,arquivos, this);
			t1.submeterTeoria(this);
			t1.adicionarFeed();
			return t1;
		} else {
			return null;
		}
	}
	
	public Monitoria criarMonitoria(Aluno monitor) {
		if (ped.contains(monitor) || pad.contains(monitor)) {
			Monitoria monitoria = new Monitoria(monitor, this);
			
			return monitoria;
		} else {
			return null;
		}
	}
	
	public void removePed(Usuario user, Aluno aluno) {
		if(user == professor && ped.contains(aluno)) {
			ped.remove(aluno);
                        aluno.getTurmas().remove(this); 
		}
	}
	
	public void adicionaPed(Usuario user, Aluno aluno) {
		if(user == professor) {
			ped.add(aluno);
                        aluno.getTurmas().add(this); 
		}
	}
	
	public void adicionaAluno(Usuario user, Aluno aluno) {
		if(user == professor) {
			alunos.add(aluno);
			aluno.getTurmas().add(this);
		}
	}
	
	public void adicionaAluno(Usuario user, ArrayList<Aluno> alunos) {
		if(user == professor) {
			for(Aluno a: alunos) {
				this.alunos.add(a);
				a.getTurmas().add(this);
			}
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
                        aluno.getTurmas().remove(this); 
		}
	}
	
	public void adicionaPad(Usuario user, Aluno aluno) {
		if(user == professor) {
			pad.add(aluno);
                        aluno.getTurmas().add(this); 
		}
	}
	
	private void criarPastas() {
		File dirTurma = new File("files/" + getSigla()); 
		dirTurma.mkdir();
		File dirAtividades = new File("files/" + getSigla() + "/Atividades/"); 
		dirAtividades.mkdir();
		File dirTeoria = new File("files/" + getSigla() + "/Teoria");
		dirTeoria.mkdir(); 
	}
	
	public void tirarMedia(Professor professor) { 
			Collections.sort(alunos);
			double[] medias = new double[alunos.size()];
			for (int i=0; i<alunos.size(); i+=1) {
				medias[i] = 0;
			}
			int natividades = 0; 
			for (Atividade atividade:atividades) {
				natividades += 1;  
				for (Submissao submissao:atividade.getSubmissoes()) {
					if (submissao.getAluno() == null) {
						for (Usuario aluno:submissao.getEquipe().getGrupo()) {
							if (alunos.contains(aluno)) {
								int posicao = alunos.indexOf(aluno);
								medias[posicao] += submissao.getNota();
							}
						}
					}
					else {
						if (alunos.contains(submissao.getAluno())) {
							int posicao = alunos.indexOf(submissao.getAluno()); 
							medias[posicao] += submissao.getNota(); 
						}
					}
				}
			}
			for (int i=0; i<alunos.size(); i+=1) {
				medias[i] = medias[i]/natividades; 
			}
			
			try {
				Formatter file = new Formatter("files/" + getSigla() + "/Medias.txt"); 
				String out = "Medias: ";
				for (int i=0; i<alunos.size(); i+=1) {
					Aluno aluno = alunos.get(i);
					out += "\n -" + aluno.getNome() + ", RA: " + aluno.getRa() + ", Nota: " + medias[i] + ". Aprovado: " + (medias[i]>=5? "Sim":"Nao");
				}
				file.format("%s", out);
				file.flush();
				file.close();
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
	}
	
	@Override
	public String toString() {
		int i = 0;
		String out = "\n";
		out+= "-> Disciplina: " + getTurma() + " (" + getSigla() + ", " + getCor() + ") \n";
		out+= (ementa != null? "-> Ementa: " + getEmenta() + "\n":"");
		out+= "-> Professor: " + getProfessor().getNome() + "\n";
		out+= "-> Horarios: " + getHorarios() + "\n";
		out+= "-> PED's: [";
		
		for(Usuario u:getPed()) {
			out+= u.getNome();
			
			if(i != getPed().size() - 1)
				out+= ", ";
			i++;
		}
		
		out+= "] \n";
		out+= "-> Pad's: [";
		
		i = 0;
		for(Usuario u:getPad()) {
			out+= u.getNome();
			
			if(i != getPad().size() - 1)
				out+= ", ";
			i++;
		}
			
		out+= "] \n";
		out+= "-> Alunos: [";
		
		i = 0;
		for(Aluno a:getAlunos()) {
			out+= a.getNome();
		
			if(i != getAlunos().size() -1)
				out+= ", ";
			i++;
		}
		
		out+= "] \n";
		out+= "\n-> Agenda: " + getAgenda() + "\n";
		out+= "\n-> Teoria: " + getTeoria() + "\n";
		out+= "\n-> Atividades: " + getAtividades() + "\n";
		out+= "\n-> Monitorias: " + getMonitorias() + "\n";
		out+= "\n-> Duvidas: " + getDuvidas() + "\n";
		out+= "\n-> Mural: " + getMural() + "\n";
				
		return out;
	}

}
