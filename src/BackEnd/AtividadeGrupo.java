package BackEnd;
import java.util.GregorianCalendar;

/* Essa sublcasse de Atividade se diferencia pela possibilidade de submissao conjunta de uma atividade.
 * Assim um grupo de alunos envia um arquivo e sua nota e atribuida unicamente a todos os integrantes. */
public class AtividadeGrupo extends Atividade{
	private int tamanhoGrupo;

	
	// Construtor invocado a partir de criarAtividade() em Turma
	public AtividadeGrupo(Turma turma, String titulo, Labels label, String descricao, int notaMaxima,
			GregorianCalendar dataInicio, GregorianCalendar data) {
		
		super(turma, titulo, label, descricao, notaMaxima, dataInicio, data);
		this.tamanhoGrupo = 3;	//default, pode ser alterado
	}
	
	public int getTamanhoGrupo() {
		return tamanhoGrupo;
	}

	public void setTamanhoGrupo(int tamanhoGrupo) {
		this.tamanhoGrupo = tamanhoGrupo;
	}
	
	/* Um grupo de alunos ja pre-definido é inserido atraves do desse metodo.
	 * Se faz necessario que o grupo de alunos seja estabelecido e adicionado antes da submissão da atividade */
	public String adicionarGrupo(Grupo equipe) {
		int verif = 1;	// variavel para manipulacao das saídas
		
		for(Usuario u:equipe.getGrupo()) {
			if(!getTurma().getAlunos().contains(u)) { // Analisa o caso em que um ou mais integrantes nao pertencem a turma
				verif = -2;
				break;
			}
			
			// Caso especial em que ao menos um dos integrantes do grupo ja esta em outro grupo da mesma atividade
			if(getSubmissoes().size() > 0) {
				for(Submissao s : getSubmissoes()) {
					if(s.getEquipe().getGrupo().contains(u)) {
						verif = -1;
						break;
					}
				}
			}		
		}
		
		// Caso especial em que o numero de integrantes nao corresponde ao solicitado pelo administrador
		if(equipe.getGrupo().size() != getTamanhoGrupo()) 
			verif = 0;
		
		// Acoes de saida personalizadas conforme o cenario
		switch(verif) {
			case -2:
				return "Grupo nao pode ser adicionado. Um ou mais alunos nao pertencem a essa turma."; 
				
			case -1:
				return "Grupo nao pode ser adicionado. um ou mais integrantes ja pertencem a um outro grupo dessa atividade"; 
			
			case 0:
				return "Grupo nao pode ser adicionado. Quantidade de integrantes diferente da solicitada.";

			default:
				getSubmissoes().add(new Submissao(equipe));	// grupo adicionado ao array de submissoes
				return "Grupo adicionado!";		
		}		
	}
	
	// Permite a um grupo ja adicionado submeter sua atividade
	// Parametro aluno nao utilizado nesse e proximos metodos. Necessario para garantir polimorfismo
	@Override
	public void submeterAtividade(Aluno aluno, Grupo grupo, String arquivo) {
		for(Submissao s: getSubmissoes()) {
			if(s.getEquipe() == grupo) {
				s.setArquivo(arquivo);
				super.submeterAtividade(aluno, grupo, arquivo); 
				break;
			}	
		}
	}
	
	// Permite ao grupo visualizar sua nota
	@Override
	public String visualizarNota(Aluno aluno, Grupo grupo) {
		double aux = -3;	//variavel que administra a saida
		String out;
		
		for(Submissao s: getSubmissoes()) {
			if(s.getEquipe() == grupo) {				
				if(s.getArquivo() == null) { //Caso especial. Grupo foi adicionado previamente, mas nao submeteu arquivo 
					aux = -2;
					break;
				}
				
				aux = s.getNota();
				break;
			}
		}
		
		switch((int) aux){
			case -3:
				out = "Seu grupo ainda nao foi adicionado a lista dessa atividade";
		
			case -2:
				out = "Voce nao entregou essa atividade.";
	
			case -1:
				out = "Sua nota ainda nao foi atribuida.";
			
			default:
				out = "Sua nota foi: " + Double.toString(aux) + "/" + getNotaMaxima();
		}
		
		return out;	
	}
	
	//Permite ao admin (prof e ped) atribuir uma nota unica aos integrantes do grupo
	@Override
	public void atribuirNota(Usuario user, Aluno aluno, Grupo grupo, double nota) {
		if(user instanceof Professor || getTurma().getPed().contains(user)){
			for(Submissao s:getSubmissoes()) {
				if(s.getEquipe() == grupo) {
					s.setNota(nota);
					s.adicionarFeed();
					break;
				}
			}
			for(Usuario a : grupo.getGrupo()) {
				a.getNotificacoes().add(1, Notificacoes.NOVA_NOTA);
			}
		}		
	}

	public String toString() {
		String out = super.toString();	
		out += "# Tamanho do grupo: " + getTamanhoGrupo() + "\n";
		out += "# Submissoes: " + getSubmissoes() + "\n";
		
		return out;
	}
}
