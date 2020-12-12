
public class Teoria {

	private String descricao;
	private String arquivos;
	
	public Teoria(String descricao, String arquivos) {
		this.descricao = descricao;
		this.arquivos = arquivos;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getArquivos() {
		return arquivos;
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
	
	public String toString() {
		String out = "\n";
		out += "* Descricao: " + getDescricao() + "; " + "\n" + "Arquivo: " + getArquivos() + ";\n ";
						
		return out;
	}
}
