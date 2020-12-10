import java.util.Calendar;
import java.util.GregorianCalendar;

public class Atividade extends Evento{
	
	/* A classe Atividade é mãe de duas outras especializadas, AtividadeIndividual e AtividadeGrupo.
	 * Aqui são reunidos alguns atributos e métodos comuns a elas.
	 * Atividade, por conseguinte, também é filha de Evento, pois toda atividade instanciada é diretamente
	 * associada a agenda do usuário e da turma. 
	 */
	
	private Calendar dataInicio = new GregorianCalendar();
	private int notaMaxima;
	private Evento agendaAluno;
	private Turma turma;
	
	public Atividade(Turma turma, String titulo, Labels label, String descricao, int notaMaxima,
			GregorianCalendar dataInicio, GregorianCalendar data) {
	
		// Como o construtor de Evento é sobrecerregado, optou-se por inicializar, por default, aquele associado a Turma
		super(titulo, label, descricao, data, false);
		
		// Evento é adicionado a agenda da turma. Um casting é necessário para se restringir a instância superior
		turma.getAgenda().add(0, (Evento) this);	
		
		// Novo objeto de Reunião é criado, agora para ser incluido a cada agenda de alunos da turma
		this.agendaAluno = new Evento(titulo, label, descricao, turma.getSigla(), turma.getCor(), data, false);
		for(Usuario u:turma.getAlunos()) {
			u.getAgenda().add(0, agendaAluno);
		}
		
		this.dataInicio = dataInicio;
		this.notaMaxima = notaMaxima;
		this.turma = turma;
	}
	
	/* Esse é um método que contém características em comum entre os respectivos metodos das classess filhas.
	 * É  simplismente uma comdicional que avalia se o usuário solicitante tem a permissao de atribuir nota a um
	 * aluno em específico ou a um grupo.
	 * Somente o professor e peds detém dessa permissao.
	 */
	protected boolean atribuirNota(Usuario user) {
		if (user instanceof Professor || turma.getPed().contains(user)) {
			return true;
		}
		return false;
	}
	
	/* Esse é um método que contém características em comum entre os respectivos metodos das classess filhas.
	 * Ele avalia as saídas comuns que ambos os métodos filhos podem ter ao um aluno solicitar para visualizar sua nota.
	 */	
	protected String visualizarNota(double aux) {
		switch((int) aux){
			case -2:
				return "Você não entregou essa atividade.";

			case -1:
				return "Nota ainda não atribuída.";
			
			default:
				return "Nota: " + Double.toString(aux);
		}
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public int getNotaMaxima() {
		return notaMaxima;
	}

	public void setNotaMaxima(int notaMaxima) {
		this.notaMaxima = notaMaxima;
	}

	public Evento getAgendaAluno() {
		return agendaAluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public String toString() {
		String out = super.toString();	
		out+= "# Data de início: " + getDataInicio().get(Calendar.DAY_OF_MONTH) + "/" + getDataInicio().get(Calendar.MONTH)
				+ " " + getDataInicio().get(Calendar.HOUR_OF_DAY) + ":" + getDataInicio().get(Calendar.MINUTE) + "\n";

		return out;
	}
}
