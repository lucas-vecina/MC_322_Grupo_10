/* Essa e uma classe de apoio as classe AtividadeIndividual e AtividadeGrupo.
 * Ela possibilita um correspondencia direta entre o arquivo de envio e a nota com o aluno, seja ele individual
 * ou em grupo. */
public class Submissao {	
	private Aluno aluno;
	private Grupo equipe;
	private String arquivo;
	private double nota = -1.0;
	
	// Construtor sobrecarregado invocado por AtividadeIndividual
	public Submissao(Aluno aluno, String arquivo) {
		this.aluno = aluno;
		this.arquivo = arquivo;
	}
	
	/* Construtor sobrecarregado invocado por AtividadeGrupo. 
	 * Notar que arquivo nao e passado de inicio. Isso porque o grupo e estabelecido previamente e so depois a 
	 * atividade e submetida (alterada pelo set()). */
	public Submissao(Grupo equipe) {
		this.equipe = equipe;
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

	public Grupo getEquipe() {
		return equipe;
	}

	public void setEquipe(Grupo equipe) {
		this.equipe = equipe;
	}

	public String toString() {
		String out = (getAluno() != null ? "! Aluno: " + getAluno().getNome() + " [" + getAluno().getRa() + "]" + "\n" : "");
		out+= (getEquipe() != null ? "! Grupo: " + getEquipe() + "\n" : "");
		out+= (getArquivo() != null ? "! Arquivo: " + getArquivo() + "\n" : "");
		out+= "! " + (getNota() != -1 ? "Nota: " + getNota() : "Nota ainda não atribuida") + "\n";
		
		return out;
	}	
}
