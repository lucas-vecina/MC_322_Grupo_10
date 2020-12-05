import java.util.Calendar;

public class Evento {
	private Labels label;
	private String descricao;
	private boolean repeticao;
	private String sigla;
	private Cor cor;
	private Calendar data;
	
	public Evento(Labels label, String descricao, String sigla, Cor cor, Calendar data) {
		this.label = label;
		this.descricao = descricao;
		this.sigla = sigla;
		this.cor = cor;
		this.data = data;
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
		out+= "# (" + label.getDescricao() + ", " + label.getCor() + ") , ";
		out+= "(" + getSigla() + "," + getCor() + ") ; ";
		out+= "(" + getData().get(Calendar.DAY_OF_MONTH) + "/" + getData().get(Calendar.MONTH)
				+ " " + getData().get(Calendar.HOUR) + ":" + getData().get(Calendar.MINUTE) + ") \n";
		out+= "# Descrição: " + getDescricao()+ "\n";
		out+= "# Repete? " + (isRepeticao() ? "Sim" : "Não") + "\n";
				
		return out;
	}
}
