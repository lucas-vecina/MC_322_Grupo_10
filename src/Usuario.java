import java.util.ArrayList;
import java.util.Calendar;

public class Usuario {
	private static int numeroUsuarios = 0;
	private final int id;
	private Genero genero;
	private String nome;
	private String email;
	private String senha;
	private ArrayList<Grupo> grupos;	// Contem os grupos em que o usuario esta
	private ArrayList<Evento> agenda;	// Conterá informações e datas de atividades
	private ArrayList<Turma> turmas;	// Conterá as turmas as quais o Usuário (Professor ou Aluno) participa
	private ArrayList<Conversa> conversas;		// Conterá mensagens enviadas e recebidas pelo Usuário
	private ArrayList<Notificacoes> notificacoes;	// Conterá mensagens pré-definidas que avisam sobre uma nova ação
	private Permissoes permissao;	// Restringe o nível de visualização e interação do Usuário
	/*Ideias
	//private String descricao;
	private boolean status;*/
	
	public Usuario(String nome, Genero genero, String email, String senha, Permissoes permissao) {
		numeroUsuarios ++;
		this.id = numeroUsuarios;
		this.genero = genero;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		agenda = new ArrayList<Evento>();
		turmas = new ArrayList<Turma>();
		conversas = new ArrayList<Conversa>();
		notificacoes = new ArrayList<Notificacoes>();
		this.permissao = permissao;
	}

	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(ArrayList<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setSexo(Genero genero) {
		this.genero = genero;
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

	public ArrayList<Conversa> getConversas() {
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
