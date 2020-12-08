public class Mensagem {
	private Usuario sujeito;
	private String texto; 
	
	public Mensagem(Usuario sujeito, String texto) {
		this.sujeito = sujeito;
		this.texto = texto;
	}

	public Usuario getSujeito() {
		return sujeito;
	}

	public void setSujeito(Usuario sujeito) {
		this.sujeito = sujeito;
	}

	public String getTexto() {
		return texto;
	}

	public void Edit(String texto) {
		this.texto = texto;
	}
	
	@Override
	public String toString() {
		String out = "Remetente:" + sujeito.getNome(); 
		out = out + "Mensagem:\n" + texto;
		return out;
	}
}
