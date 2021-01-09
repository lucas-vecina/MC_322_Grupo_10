
public class Teoria implements Feed{
	private String descricao;
	private String arquivos;
	private Turma turma;
	
	public Teoria(String descricao, String arquivos, Turma turma) {
		this.descricao = descricao;
		this.arquivos = arquivos;
		this.turma = turma;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getArquivos() {
		return arquivos;
	}
	
	public Turma getTurma() {
		return turma;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setArquivos(String arquivos) {
		this.arquivos = arquivos;
	}

	public void submeterTeoria(Turma turma) {
		turma.getTeoria().add(this);
		for(Usuario u:turma.getAlunos()) {
			u.getNotificacoes().add(0, Notificacoes.NOVA_AULA);
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
	
	public String toString() {
		String out = "\n";
		out += "* Descricao: " + getDescricao() + "; " + "\n" + "Arquivo: " + getArquivos() + ";\n ";
						
		return out;
	}
}
