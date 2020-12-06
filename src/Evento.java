import java.util.GregorianCalendar;
import java.util.Calendar;

public class Evento {
	
	/* A classe Evento tem por obejtivo organizar a entrega de atividades disponibilizadas na plataforma EAD.
	 * Ela é fundamentada através de Labels que indicam o tipo de atividade, a disciplina e o horário de entrega da mesma. 
	 * A representação dos Labels é simbólica por meio do método toString() */
	
	private Labels label;
	private String descricao;
	private boolean repeticao;
	private String sigla;
	private Cor cor;
	private Calendar data = new GregorianCalendar();
	
	public Evento(Labels label, String descricao, String sigla, Cor cor, GregorianCalendar data, boolean repeticao) {
		this.label = label;
		this.descricao = descricao;
		this.sigla = sigla;
		this.cor = cor;
		this.data = data;
		this.repeticao = repeticao;
	}

	public Labels getLabel() {
		return label;
	}

	public void setLabel(Labels label) {
		this.label = label;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isRepeticao() {
		return repeticao;
	}

	public void setRepeticao(boolean repeticao) {
		this.repeticao = repeticao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
	public String toString() {
		String out = "\n";
		out+= "# (" + label.getDescricao() + ", " + label.getCor() + ") ; ";
		out+= "(" + getSigla() + ", " + getCor() + ") ; ";
		out+= "(" + getData().get(Calendar.DAY_OF_MONTH) + "/" + getData().get(Calendar.MONTH)
				+ " " + getData().get(Calendar.HOUR_OF_DAY) + ":" + getData().get(Calendar.MINUTE) + ") \n";
		out+= "# Descrição: " + getDescricao()+ "\n";
		out+= "# Repete? " + (isRepeticao() ? "Sim" : "Não") + "\n";
				
		return out;
	}
}
