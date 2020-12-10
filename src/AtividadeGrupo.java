import java.util.ArrayList;
import java.util.GregorianCalendar;

public class AtividadeGrupo extends Atividade{
	private int tamanhoGrupo;
	private ArrayList<Submissao> submissoes;
	
	public AtividadeGrupo(Turma turma, String titulo, Labels label, String descricao, int notaMaxima,
			GregorianCalendar dataInicio, GregorianCalendar data) {
		
		super(turma, titulo, label, descricao, notaMaxima, dataInicio, data);
		this.tamanhoGrupo = 4;
		this.submissoes = new ArrayList<Submissao>();
	}
	
	@SuppressWarnings("unused") //teste
	private String adicionarGrupo(Grupo equipe) {
		int verif = 1;
		
		for(Usuario u:equipe.getGrupo()) {
			if(!getTurma().getAlunos().contains(u)) {
				verif = -2;
				break;
			}
			
			if(getSubmissoes().size() > 0) {
				for(Submissao s : getSubmissoes()) {
					if(s.getEquipe().getGrupo().contains(u)) {
						verif = -1;
						break;
					}
				}
			}		
		}
		
		if(equipe.getGrupo().size() != getTamanhoGrupo()) 
			verif = 0;
		
		switch(verif) {
			case -2:
				return "Grupo não pode ser adicionado. Um ou mais alunos não pertencem a essa turma."; 
				
			case -1:
				return "Grupo não pode ser adicionado. um ou mais integrantes já pertencem a um outro grupo dessa atividade"; 
			
			case 0:
				return "Grupo não pode ser adicionado. Quantidade de integrantes diferente da solicitada.";

			default:
				getSubmissoes().add(new Submissao(equipe));
				return "Grupo adicionado!";		
		}		
	}
	
	public void submeterAtividade(Grupo grupo, String arquivo) {
		for(Submissao s: getSubmissoes()) {
			if(s.getEquipe() == grupo) {
				s.setArquivo(arquivo);
				break;
			}
			
		}
	}
	
	public String visualizarNota(Grupo grupo) {
		boolean verif = false;
		double aux = 0;
		
		for(Submissao s: getSubmissoes()) {
			if(s.getEquipe() == grupo) {
				verif = true;
				aux = s.getNota();
				break;
			}
		}
		
		return super.visualizarNota(verif, aux);	
	}
	
	public void atribuirNota(Usuario user, Grupo grupo, double nota) {
		if(super.atribuirNota(user)){
			for(Submissao s:getSubmissoes()) {
				if(s.getEquipe() == grupo) {
					s.setNota(nota);
					break;
				}
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

	
}
