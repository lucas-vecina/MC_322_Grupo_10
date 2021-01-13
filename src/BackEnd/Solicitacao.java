package BackEnd;

public class Solicitacao {
	private Usuario user;
	private String nome;
	private Tipo tipo;
	
	public Solicitacao(Usuario user, String nome, Tipo tipo) {
		this.user = user;
		this.nome = nome;
		this.tipo = tipo;
	}

	public Usuario getUser() {
		return user;
	}

	public String getNome() {
		return nome;
	}

	public Tipo getTipo() {
		return tipo;
	}	
	
	public String toString() {
		String out = "";
		out += "Solicitacao de " + tipo + " vinda de " + nome;
		return out;
	}
}