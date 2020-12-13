import java.util.ArrayList;

public class Usuario {
	private static int numeroUsuarios = 0;
	private final int id;
	private Genero genero;
	private String nome;
	private String email;
	private String senha;
	private ArrayList<Evento> agenda;	// Conterá informações e datas de atividades
	private ArrayList<Turma> turmas;	// Conterá as turmas as quais o Usuário (Professor ou Aluno) participa
	private ArrayList<Grupo> grupos;	// Contem os grupos em que o usuario esta
	private ArrayList<Conversa> conversas;		// Conterá mensagens enviadas e recebidas pelo Usuário
	private ArrayList<Notificacoes> notificacoes;	// Conterá mensagens pré-definidas que avisam sobre uma nova ação
	private Permissoes permissao;	// Restringe o nível de visualização e interação do Usuário
	
	// Construtor
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
	
	/* Esse método possibilita a um usuário (user) visualizar um apanhado de informações sobre outro (this).
	 * Ele é sobrescrito em Aluno e também invocado pelo mesmo. Para Professor, esse método já se faz suficiente.
	 * Conforme a permissão do user, diferentes informações são exibidas. */
	
	protected String visualizarInfo(Usuario user) {
		String out;
		
		switch(getPermissao().getChave()) {	// Verifica a permissao do user
			case 1:	// Permissao Publica
				out= "-Id: " + getId() + "\n";
				out+= "-Nome: " + getNome() + "\n";
				out+= "-Gênero: " + getGenero().getDescricao() + "\n";
				out+= "-Email: " + getEmail() + "\n";
				out+= visualizarTurma(user);
				
				return out;
			
			case 2: case 3:	//Permissao Privada e Default. Nesse escopo, sao equivalentes
				out= "-Nome: " + getNome() + "\n";
				out+= "-Email: " + getEmail() + "\n";
				out+= visualizarTurma(user);
				
				return out;
		}
		return "";
	}
	
	public void iniciarConversa(ArrayList<Usuario> grupo) {
		Conversa conversa = new Conversa(grupo);
		conversas.add(conversa); 
		for (Usuario membro:grupo) {
			membro.conversas.add(conversa);
		}
	}
	
	/* Exibe as turmas que o usuário participa. Evita loops e exibição de informações desnecessárias
	 * Metódo é sobrescrito e invocado por meio da subclasse Aluno, mas é suficiete para Professor. */
	public String visualizarTurma(Usuario user) {
		String out = "-Turmas: \n";
		out+= "[";
		
		for(Turma t : getTurmas()) {
			out+= "[>> " + t.getTurma() + "\t{" + t.getSigla() + ", " + t.getCor() + "}" + "\n";
			out+= "Ementa: " + t.getEmenta() + "\n";
			out+= "Prof: " + t.getProfessor().getNome() + "]\n";
		}
		out+= "]";
		return out;
	}
	
	public void criarGrupo(String nome, ArrayList<Usuario> membros) {
		Grupo grupo = new Grupo(nome, membros);
		grupo.getGrupo().add(this);
		this.getGrupos().add(grupo);
		for(Usuario membro:membros) 
			membro.getGrupos().add(grupo); 
	}
	
	public String exibirNotificacoes(Usuario user) {
		if(user == this) {
			String out = "Notificacoes: [";
			
			for(Notificacoes n:getNotificacoes())
				out+= "\n* " + n.getNotificacao() + ", ";

			out+= "]\n";
			return out;
		}
		
		return "Você não tem permissão de visualizar as notificações de " + getNome(); 
	}
	
	public boolean removerNotificacao(Usuario user, int i) {
		if(user == this) {
			getNotificacoes().remove(i);
			return true;
		}
		return false;
	}
	
	public boolean limparNotificacoes(Usuario user) {
		if(user == this) {
			getNotificacoes().clear();
			return true;
		}
		return false;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
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
	
	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(ArrayList<Grupo> grupos) {
		this.grupos = grupos;
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
		out+= "| Nome: " + getNome() + "\n";
		out+= "| Genêro: " + getGenero().getDescricao() + "\n";
		out+= "| Email: " + getEmail() + "\n";
		out+= "| Nome: " + getNome() + "\n";
		out+= "| Senha: " + getSenha() + "\n";
		out+= "| Permissão: " + getPermissao().getDescricao() + "\n";
		out+= "| Agenda: " + getAgenda();
		out+= "| Turmas: [";
		
		for(Turma t:getTurmas()) {
			out += "-" + t.getTurma() + " {" + t.getSigla() + ", " + t.getCor() + "} \n"; 
		}
		
		out+= "] \n";
		out+= "| " + exibirNotificacoes(this);
		out+= "| Conversas: " + getConversas() + "\n";
		out+= "| Grupos: " + getGrupos() + "\n";
		
		return out;
	}
	
	

}
