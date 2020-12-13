import java.util.Calendar;
import java.util.GregorianCalendar;

public class Atividade extends Evento{
	
	/* A classe Atividade e mae de duas outras especializadas, AtividadeIndividual e AtividadeGrupo.
	 * Aqui sao reunidos alguns atributos e metodos comuns a elas.
	 * Atividade, por conseguinte, tambem e filha de Evento, pois toda atividade instanciada e diretamente
	 * associada a agenda do usuario e da turma. 
	 */
	//Ainda nao utilizamos a heranca com Evento, sera feito na continuacao do trabalho
	
	private Calendar dataInicio = new GregorianCalendar();
	private int notaMaxima;
	private Evento agendaTurma;
	private Evento agendaAluno;
	private Turma turma;
	
	public Atividade(Turma turma, String titulo, Labels label, String descricao, int notaMaxima,
			GregorianCalendar dataInicio, GregorianCalendar data) {
	
		// Como o construtor de Evento e sobrecerregado, optou-se por inicializar, por default, aquele associado a Turma
		super(titulo, label, descricao, data, false);
		
		// Evento e adicionado a agenda da turma. Um casting e necessario para se restringir a instancia superior
		this.agendaTurma = new Evento(titulo, label, descricao, data, false);
		turma.getAgenda().add(0, agendaTurma);	
		
		// Novo objeto de Reuniao e criado, agora para ser incluido a cada agenda de alunos da turma
		this.agendaAluno = new Evento(titulo, label, descricao, turma.getSigla(), turma.getCor(), data, false);
		for(Usuario u:turma.getAlunos()) {
			u.getAgenda().add(0, agendaAluno);
		}
		
		this.dataInicio = dataInicio;
		this.notaMaxima = notaMaxima;
		this.turma = turma;
	}
	
	/* Esse e um metodo que contem caracteristicas em comum entre os respectivos metodos das classess filhas.
	 * E simplismente uma comdicional que avalia se o usuario solicitante tem a permissao de atribuir nota a um
	 * aluno em especifico ou a um grupo.
	 * Somente o professor e peds detem dessa permissao.
	 */
	protected boolean atribuirNota(Usuario user) {
		if (user instanceof Professor || turma.getPed().contains(user)) {
			return true;
		}
		return false;
	}
	
	/* Esse e um metodo que contem caracteristicas em comum entre os respectivos metodos das classess filhas.
	 * Ele avalia as saidas comuns que ambos os metodos filhos podem ter ao um aluno solicitar para visualizar sua nota.
	 */	
	protected String visualizarNota(double aux) {
		switch((int) aux){
			case -3:
				return "Seu grupo ainda nao foi adicionado a lista dessa atividade";
		
			case -2:
				return "Voce nao entregou essa atividade.";

			case -1:
				return "Sua nota ainda nao foi atribuida.";
			
			default:
				return "Sua nota foi: " + Double.toString(aux) + "/" + getNotaMaxima();
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
	
	public Evento getAgendaTurma() {
		return agendaTurma;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public String toString() {
		String out = super.toString();	
		out+= "# Data de inicio: " + getDataInicio().get(Calendar.DAY_OF_MONTH) + "/" + getDataInicio().get(Calendar.MONTH)
				+ " " + getDataInicio().get(Calendar.HOUR_OF_DAY) + ":" + getDataInicio().get(Calendar.MINUTE) + "\n";

		return out;
	}
}
