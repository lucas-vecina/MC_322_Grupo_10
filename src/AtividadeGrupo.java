import java.util.ArrayList;
import java.util.GregorianCalendar;

public class AtividadeGrupo extends Atividade{
	
	/* Essa sublcasse de Atividade se diferencia pela possibilidade de submissão conjunta de uma atividade.
	 * Assim um grupo de alunos envia um arquivo e sua nota é atribuida unicamente a todos os integrantes.
	 */
	
	private int tamanhoGrupo;
	private ArrayList<Submissao> submissoes;	// Armazena a relação entre o grupo e sua atividade(nota, arquivo)
	
	// Construtor invocado a partir de criarAtividade() em Turma
	public AtividadeGrupo(Turma turma, String titulo, Labels label, String descricao, int notaMaxima,
			GregorianCalendar dataInicio, GregorianCalendar data) {
		
		super(turma, titulo, label, descricao, notaMaxima, dataInicio, data);
		this.tamanhoGrupo = 4;	//default, pode ser alterado
		this.submissoes = new ArrayList<Submissao>();
	}
	
	/* Um grupo de alunos já pré-definido é inserido atraves do desse metodo.
	 * Se faz necessário que o grupo de alunos seja estabelcido e adicionado antes da submissão da atividade
	 */
	@SuppressWarnings("unused")
	private String adicionarGrupo(Grupo equipe) {
		int verif = 1;	// variavel para manipulação das saídas
		
		for(Usuario u:equipe.getGrupo()) {
			if(!getTurma().getAlunos().contains(u)) { // Analisa o caso em que um ou mais integrantes não pertencem a turma
				verif = -2;
				break;
			}
			
			// Caso especial em que ao menos um dos integrantes do grupo já está em outro grupo da mesma atividade
			if(getSubmissoes().size() > 0) {
				for(Submissao s : getSubmissoes()) {
					if(s.getEquipe().getGrupo().contains(u)) {
						verif = -1;
						break;
					}
				}
			}		
		}
		
		// Caso especial em que o número de integrantes não corresponde ao solicitado pelo administrador
		if(equipe.getGrupo().size() != getTamanhoGrupo()) 
			verif = 0;
		
		// Ações de saída personalizadas conforme o cenário
		switch(verif) {
			case -2:
				return "Grupo não pode ser adicionado. Um ou mais alunos não pertencem a essa turma."; 
				
			case -1:
				return "Grupo não pode ser adicionado. um ou mais integrantes já pertencem a um outro grupo dessa atividade"; 
			
			case 0:
				return "Grupo não pode ser adicionado. Quantidade de integrantes diferente da solicitada.";

			default:
				getSubmissoes().add(new Submissao(equipe));	// grupo adicionado ao array de submissoes
				return "Grupo adicionado!";		
		}		
	}
	
	// Permite a um grupo já adicionado submeter sua atividade
	public void submeterAtividade(Grupo grupo, String arquivo) {
		for(Submissao s: getSubmissoes()) {
			if(s.getEquipe() == grupo) {
				s.setArquivo(arquivo);
				break;
			}	
		}
	}
	
	// Permite ao grupo visualizar sua nota
	public String visualizarNota(Grupo grupo) {
		double aux = -3;	//variavel que administra a saida
		
		for(Submissao s: getSubmissoes()) {
			if(s.getEquipe() == grupo) {				
				if(s.getArquivo() == null) //Caso especial. Grupo foi adicionado previamente, mas não submeteu arquivo 
					aux = -2;
				
				aux = s.getNota();
				break;
			}
		}
		return super.visualizarNota(aux);	
	}
	
	//Permite ao admin (prof e ped) atribuir uma nota única aos integrantes do grupo
	public void atribuirNota(Usuario user, Grupo grupo, double nota) {
		if(super.atribuirNota(user)){
			for(Submissao s:getSubmissoes()) {
				if(s.getEquipe() == grupo) {
					s.setNota(nota);
					break;
				}
			}
			for(Usuario a : grupo.getGrupo()) {
				a.getNotificacoes().add(1, Notificacoes.NOVA_NOTA);
			}
		}		
	}
		
	public int getTamanhoGrupo() {
		return tamanhoGrupo;
	}

	public void setTamanhoGrupo(int tamanhoGrupo) {
		this.tamanhoGrupo = tamanhoGrupo;
	}

	public ArrayList<Submissao> getSubmissoes() {
		return submissoes;
	}

	public String toString() {
		String out = super.toString();	
		out += "# Tamanho do grupo: " + getTamanhoGrupo() + "\n";
		out += "# Submissões: " + getSubmissoes() + "\n";
		
		return out;
	}
}
