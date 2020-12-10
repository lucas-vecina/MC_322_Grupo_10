
public class Submissao {
	private Aluno aluno;
	private String arquivo;
	private double nota;
	
	public Submissao(Aluno aluno, String arquivo) {
		this.aluno = aluno;
		this.arquivo = arquivo;
		this.nota = -1.0;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public String getArquivo() {
		return arquivo;
	}
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}

	public String toString() {
		String out = "\n";
		out+= "! Aluno: " + getAluno().getNome() + " [" + getAluno().getRa() + "]" + "\n";
		out+= "! Arquivo: " + getArquivo() + "\n";
		out+= "! " + (getNota() != -1 ? "Nota: " + getNota() : "Nota ainda não atribuída") + "\n";
		
		return out;
	}	
}
