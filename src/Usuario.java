import java.util.ArrayList;

public class Usuario {
	private static int numeroUsuarios = 0;
	private final int id;
	private Genero genero;
	private String nome;
	private String email;
	private String senha;
	private ArrayList<Evento> agenda;	// Contera informacoes e datas de atividades
	private ArrayList<Turma> turmas;	// Conterá as turmas as quais o Usuario (Professor ou Aluno) participa
	private ArrayList<Grupo> grupos;	// Contem os grupos em que o usuario esta
	private ArrayList<Conversa> conversas;		// Contera mensagens enviadas e recebidas pelo Usuario
	private ArrayList<Notificacoes> notificacoes;	// Contera mensagens pre-definidas que avisam sobre uma nova acao
	private Permissoes permissao;	// Restringe o nivel de visualizacao e interacao do Usuario
	
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
		grupos = new ArrayList<Grupo>(); 
		conversas = new ArrayList<Conversa>();
		notificacoes = new ArrayList<Notificacoes>();
		this.permissao = permissao;
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
	
	/* Esse metodo possibilita a um usuário (user) visualizar um apanhado de informações sobre outro (this).
	 * Ele e sobrescrito em Aluno e também invocado pelo mesmo. Para Professor, esse metodo ja se faz suficiente.
	 * Conforme a permissao do user, diferentes informacoes sao exibidas. 
	 * Como os metodos do atributo amigos de Aluno ainda nao foram implementados, entao a permissao PRIVATE ainda
	 * nao esta funcional. Por tal motivo esse metodo ainda nao foi demonstrado na main.
	 * Outros metodos de visualizar tambem so serao totalmente funcionais na versao futura do projeto */	
	protected String visualizarInfo(Usuario user) {
		String out;
		
		switch(getPermissao().getChave()) {	// Verifica a permissao do user
			case 1:	// Permissao Publica
				out= "-Id: " + getId() + "\n";
				out+= "-Nome: " + getNome() + "\n";
				out+= "-Genero: " + getGenero().getDescricao() + "\n";
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
	
	public Conversa iniciarConversa(ArrayList<Usuario> grupo) {
		Conversa conversa = new Conversa(grupo);
		conversa.adicionarConversa();
		
		return conversa;
	}
	
	/* Exibe as turmas que o usuario participa. Evita loops e exibição de informacoes desnecessarias
	 * Metodo é sobrescrito e invocado por meio da subclasse Aluno, mas e suficiete para Professor. */
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
	
	public Grupo criarGrupo(String nome, ArrayList<Usuario> membros) {
		Grupo grupo = new Grupo(nome, membros);
		grupo.adicionarGrupo();
		
		return grupo;
	}
	
	public Grupo criarGrupo(ArrayList<Usuario> membros) {
		Grupo grupo = new Grupo(membros);
		grupo.adicionarGrupo();
 
		return grupo;
	}
	
	
	public String exibirNotificacoes(Usuario user) {
		if(user == this) {
			int i = 0;
			String out = "Notificacoes: [";
			
			for(Notificacoes n:getNotificacoes()) {
				out+= "\n* " + n.getNotificacao();
			
				if(i != getNotificacoes().size() - 1)
					out += ", ";
				i++;
			}
			
			out+= " ]\n";
			return out;
		}
		
		return "Voce nao tem permissao de visualizar as notificações de " + getNome(); 
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
	
	public String toString() {
		String out = "\n";
		out+= "| id: " + getId() + "\n";
		out+= "| Nome: " + getNome() + "\n";
		out+= "| Genero: " + getGenero().getDescricao() + "\n";
		out+= "| Email: " + getEmail() + "\n";
		out+= "| Nome: " + getNome() + "\n";
		out+= "| Senha: " + getSenha() + "\n";
		out+= "| Permissao: " + getPermissao().getDescricao() + "\n\n";
		out+= "| Agenda: " + getAgenda() + "\n\n";
		out+= "| Turmas: [\n";
		
		for(Turma t:getTurmas()) {
			out += "-" + t.getTurma() + " {" + t.getSigla() + ", " + t.getCor() + "} \n"; 
		}
		
		out+= "] \n\n";
		out+= "| " + exibirNotificacoes(this) + "\n";
		out+= "| Conversas: " + getConversas() + "\n\n";
		out+= "| Grupos: " + getGrupos() + "\n\n";
		
		return out;
	}
	
	

}
