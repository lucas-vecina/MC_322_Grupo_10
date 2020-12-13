import java.util.ArrayList; 

public class Monitoria {
	private Turma turma; 
	private Aluno monitor;
	private boolean status;
	private ArrayList<Aluno> fila;
	
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

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ArrayList<Aluno> getFila() {
		return fila;
	}

	public void setFila(ArrayList<Aluno> fila) {
		this.fila = fila;
	}

	public void atender(Aluno monitor) {
		if (!fila.isEmpty() && status && monitor == this.monitor) {
			fila.remove(1); 
		}
	}
	
	public void abrirMonitoria(Aluno monitor) {
		if (!status && monitor == this.monitor) {
			status = true;
		}
	}
	
	public void fecharMontoria(Aluno monitor) {
		if (status && monitor == this.monitor) {
			for (Usuario aluno:fila) 
				fila.remove(aluno);
			status = false; 
		}
	}
	
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
	
	@Override
	public String toString() {
		String out = "\nMonitor:" + getMonitor().getNome() + ", RA: " + getMonitor().getRa();
		out += "\n Turma: " + getTurma().getSigla(); 
		out += "\n Status: " + (isStatus()? "Aberto" : "Fechado"); 
		out += "\n Pessoas na fila:";
		for (Aluno aluno:fila) {
			out += "\n-" + aluno.getNome() + ", RA: " + aluno.getRa();
		}
		return out;
	}
	
}
