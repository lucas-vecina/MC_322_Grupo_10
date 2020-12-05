import java.util.ArrayList;
import java.util.Calendar;

public class Usuario {
	private static int numeroUsuarios = 0;
	private final int id;
	private Sexo sexo;
	private String nome;
	private String email;
	private String senha;
	private ArrayList<Evento> agenda;	// Conterá informações e datas de atividades
	private ArrayList<Turma> turmas;	// Conterá as turmas as quais o Usuário (Professor ou Aluno) participa
	private ArrayList<Conversas> conversas;		// Conterá mensagens enviadas e recebidas pelo Usuário
	private ArrayList<Notificacoes> notificacoes;	// Conterá mensagens pré-definidas que avisam sobre uma nova ação
	private Permissoes permissao;	// Restringe o nível de visualização e interação do Usuário
	/*Ideias
	//private String descricao;
	private boolean status;*/
	
	public Usuario(String nome, Sexo sexo, String email, String senha, Permissoes permissao) {
		numeroUsuarios ++;
		this.id = numeroUsuarios;
		this.sexo = sexo;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		agenda = new ArrayList<Evento>();
		turmas = new ArrayList<Turma>();
		conversas = new ArrayList<Conversas>();
		notificacoes = new ArrayList<Notificacoes>();
		this.permissao = permissao;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Permissoes getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissoes permissao) {
		this.permissao = permissao;
	}

	public static int getNumeroUsuarios() {
		return numeroUsuarios;
	}

	public int getId() {
		return id;
	}

	public ArrayList<Evento> getAgenda() {
		return agenda;
	}

	public ArrayList<Turma> getTurmas() {
		return turmas;
	}

	public ArrayList<Conversas> getConversas() {
		return conversas;
	}

	public ArrayList<Notificacoes> getNotificacoes() {
		return notificacoes;
	}
	
	public String toString() {
		String out = "\n";
		out+= "| id: " + getId() + "\n";
		out+= "| Nome: " + getNome()+ "\n";
		out+= "| Email: " + getEmail()+ "\n";
		out+= "| Nome: " + getNome()+ "\n";
		out+= "| Senha: " + getSenha()+ "\n";
		// Necessário complementar

		
		return out;
	}
	
	

}
