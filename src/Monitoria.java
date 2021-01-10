import java.util.ArrayList; 

// Ambiente simbolico para interacao entre um monitor e alunos para retirada de duvidas de maneira sincrona
public class Monitoria implements Feed {	
	private Turma turma; 
	private Aluno monitor;
	private boolean status;
	private ArrayList<Aluno> fila;	// Onde os alunos ingressarao e aguardarao serem atendidos
	
	public Monitoria(Aluno monitor, Turma turma) {
		this.turma = turma;
		turma.getMonitorias().add(this);
		this.monitor = monitor;
		status = false;
		fila = new ArrayList<Aluno>();
	}
	
		public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Aluno getMonitor() {
		return monitor;
	}

	public void setMonitor(Aluno monitor) {
		this.monitor = monitor;
	}

	public boolean isStatus() {
		return status;
	}

	public ArrayList<Aluno> getFila() {
		return fila;
	}

	public void setFila(ArrayList<Aluno> fila) {
		this.fila = fila;
	}
	
	// O monitor atende o primeiro aluno da fila
	public void atender(Aluno monitor) {
		if (!fila.isEmpty() && status && monitor == this.monitor) {
			fila.remove(1); 
		}
	}
	
	public void abrirMonitoria(Aluno monitor) {
		if (!status && monitor == this.monitor) {
			status = true;
			adicionarFeed();
			
			for(Aluno a: getTurma().getAlunos())
				a.getNotificacoes().add(0, Notificacoes.INICIO_MONITORIA);
		}
	}
	
	public void fecharMontoria(Aluno monitor) {
		if (status && monitor == this.monitor) {
			for (Usuario aluno:fila) 
				fila.remove(aluno);
			status = false; 
		}
	}
	
	// Permite a um aluno entrar na fila de atendimento da monitoria
	public void entrarMonitoria(Aluno aluno) {
		if (status && turma.getAlunos().contains(aluno)) {
			fila.add(aluno); 
		}
	}
	
	public void sairMonitoria(Aluno aluno) {
		if (fila.contains(aluno)) {
			fila.remove(aluno); 
		}
	}
	
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
	
	@Override
	public String toString() {
		String out = "\nMonitor:" + getMonitor().getNome() + ", RA: " + getMonitor().getRa();
		out += "\n Turma: " + getTurma().getSigla(); 
		out += "\n Status: " + (isStatus()? "Aberto" : "Fechado"); 
		out += "\n Pessoas na fila: " + (getFila().size() == 0 ? "0":"") ;
		for (Aluno aluno:fila) {
			out += "\n-" + aluno.getNome() + ", RA: " + aluno.getRa();
		}
		return out;
	}
	
}
