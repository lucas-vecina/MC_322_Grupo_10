package BackEnd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		ArrayList<Aluno> aux1 = new ArrayList<Aluno>();
                Turma.setarCWD();
		
		// Instancias de professores
		Professor prof1 = new Professor("Geraldo", Genero.NAO_BINARIO, "geraldo@hotmail.com", "senha123");
		Professor prof2 = new Professor("Yennefer", Genero.FEMININO, "yen@gmail.com", "123senha");

		// Instancias de alunos
		Aluno aluno1 = new Aluno("Ciri", Genero.NAO_BINARIO, "ciri@yahoo.com", "321senha", Permissoes.PUBLIC,
				"Eng. Alimentos", "12345");
		Aluno aluno2 = new Aluno("Dandelion", Genero.MASCULINO, "dan@uol.com", "senha321", Permissoes.DEFAULT,
				"Musica", "54321");
		Aluno aluno3 = new Aluno("Zoltan", Genero.NAO_IDENTIFICADO, "zoltan@dac.unicamp.br", "sen321ha", Permissoes.PRIVATE,
				"Eng. Mecanica", "00012");
		Aluno aluno4 = new Aluno("Triss", Genero.FEMININO, "triss@apple.mail.com", "sen123ha", Permissoes.DEFAULT,
				"Eng. Quimica", "00044");
		Aluno aluno5 = new Aluno("Fringila", Genero.NAO_BINARIO, "frin@usp.br", "sen000ha", Permissoes.PRIVATE,
				"Quimica", "00055");
		Aluno aluno6 = new Aluno("Emhyr", Genero.MASCULINO, "emhyr@unesp.br", "senha000", Permissoes.PUBLIC,
				"Economia", "99666");
		
		// Instancias de turmas
		HashMap<Integer, ArrayList<Integer>> horarios1 = new HashMap<Integer, ArrayList<Integer>>();
		HashMap<Integer, ArrayList<Integer>> horarios2 = new HashMap<Integer, ArrayList<Integer>>();

		ArrayList<Integer> aux00 = new ArrayList<Integer>();
		aux00.addAll(Arrays.asList(10, 11));
		horarios1.put(1, aux00);
                
		ArrayList<Integer> aux = new ArrayList<Integer>();
                aux.addAll(Arrays.asList(19, 20));
                horarios2.put(3, aux);
		
		Turma turma1 = prof1.criarTurma("Bruxos I", "BX111", horarios1,"");
		Turma turma2 = prof2.criarTurma("Alquimia I", "AQ101", horarios2, "");
		
		// Insercao dos alunos, peds e pads nas turmas
		aux1.addAll(Arrays.asList(aluno2, aluno4, aluno6));
		turma1.adicionaAluno(prof1, aux1);
		turma1.adicionaPed(prof1, aluno1);
		turma1.adicionaPad(prof1, aluno3);
	
		aux1.clear();	
		aux1.addAll(Arrays.asList(aluno1, aluno2, aluno3));
		turma2.adicionaAluno(prof2, aux1);
		turma2.adicionaPed(prof2, aluno5);
		turma2.adicionaPad(prof2, aluno4);
                
                //Pre setagem amigos aluno1
                ArrayList<Usuario> aux0 = new ArrayList<Usuario>();
                aux0.addAll(Arrays.asList(aluno2, aluno6));
                aluno1.setAmigos(aux0);

                //Teste solicitacoes
                aluno3.adicionarSolicitacao(aluno1);
                aluno4.adicionarSolicitacao(aluno1);
        

		// Criando um grupo
		ArrayList<Usuario> aux2 = new ArrayList<Usuario>(aux1);
		Grupo equipe1 = aluno2.criarGrupo("Estudo", aux2);
		
		// Criacao de nova aula para turma1
		turma1.criarTeoria(prof1, "Conteudo introdutorio a bruxos", "aula1.txt");
		turma1.criarTeoria(prof1, "Palestra para bruxos: como matar um Grifo", "seminario.mov");
		
		// Criacao duvidas
		Duvidas duvida1 = turma1.criarDuvida(aluno2, "Quais sao as propriedades fisicas de um Lobisomem?");
		duvida1.replicar(aluno4, "Tambem to na duvida");
		
		// Criacao Monitoria
		Monitoria monitoria1 = turma1.criarMonitoria(aluno1);
		monitoria1.abrirMonitoria(aluno1);
		monitoria1.entrarMonitoria(aluno2);
		monitoria1.entrarMonitoria(aluno4);
		
		// Nova atividade
		AtividadeIndividual atividade1 = (AtividadeIndividual) turma1.criarAtividade(prof1, "Apresentacao_1", Labels.ATIVIDADE_INDIVIDUAL, 
				"Matem um grifo", 10, new GregorianCalendar(2020, 03, 25, 22, 30), new GregorianCalendar(2020, 03, 31, 23, 59));
		atividade1.submeterAtividade(aluno4, null, "Triss.txt");
		atividade1.atribuirNota(prof1, aluno4, null, 10);
		atividade1.submeterAtividade(aluno2, null, "Dandelion.txt");
		atividade1.atribuirNota(prof1, aluno2, null,  0.1);
		
		AtividadeGrupo atividade2 = (AtividadeGrupo) turma1.criarAtividade(prof1, "Relatorio_1", Labels.ATIVIDADE_GRUPO, 
				"Facam a fusao de diferentes Runas", 10, new GregorianCalendar(2020, 04, 15, 22, 30), new GregorianCalendar(2020, 04, 29, 23, 59));
	
		// Criacao de nova aula para turma2
		turma2.criarTeoria(prof2, "Introcao a alquimia", "aula1.txt");
		turma2.criarTeoria(prof2, "Seminario: Transformar agua em vinho", "palestra.mov");
		
		// Criacao duvidas
		Duvidas duvida2 = turma2.criarDuvida(aluno3, "E possivel transformar um bruxo em ouro?");
		duvida2.replicar(prof1, "Posso te transformar em picadinho.");
		duvida2.resolver();
		
		// Criacao Monitoria
		Monitoria monitoria2 = turma2.criarMonitoria(aluno5);
		monitoria2.abrirMonitoria(aluno5);
		
		// Nova atividade
		AtividadeIndividual atividade3 = (AtividadeIndividual) turma2.criarAtividade(prof1, "Apresentacao_1", Labels.ATIVIDADE_INDIVIDUAL, 
				"Criar um arco-iris de fogo", 10, new GregorianCalendar(2020, 03, 25, 22, 30), new GregorianCalendar(2020, 03, 31, 23, 59));
		atividade3.submeterAtividade(aluno1, null, "instrucoes.txt");
		
		AtividadeGrupo atividade4 = (AtividadeGrupo) turma2.criarAtividade(prof1, "Relatorio_1", Labels.ATIVIDADE_GRUPO, 
				"Mostre que homunculus podem existir", 100, new GregorianCalendar(2020, 04, 15, 22, 30), new GregorianCalendar(2020, 04, 29, 23, 59));
		atividade4.adicionarGrupo(equipe1);
		atividade4.submeterAtividade(null, equipe1, "Eles_podem.txt");
		atividade4.atribuirNota(prof1, null, equipe1, 100);
		
		// Demonstrando conversa
		aux2.add(aluno5);
		Conversa conversa1 = aluno2.iniciarConversa(aux2);
		conversa1.enviarMensagem(aluno1, "oi");
		conversa1.enviarMensagem(aluno3, "ola");
	
		//Trancando disciplinas
		//aluno1.trancarDisciplina(turma2);
                //aluno1.trancarDisciplina(turma2);
		
		turma1.tirarMedia(prof1);
		turma2.tirarMedia(prof2);		
		
		monitoria1.getConversa().enviarMensagem(aluno2, "Ola galera");
		monitoria1.getConversa().enviarMensagem(aluno1, "Tchau");
		monitoria1.getConversa().enviarMensagem(aluno4, "hello");
	}
}
