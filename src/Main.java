import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		ArrayList<Aluno> aux1 = new ArrayList<Aluno>();
		
		// Instancias de professores
		Professor prof1 = new Professor("Geraldo", Genero.NAO_BINARIO, "geraldo@hotmail.com", "senha123");
		Professor prof2 = new Professor("Yennefer", Genero.FEMININO, "yen@gmail.com", "123senha");
		
		// Instancias de alunos
		Aluno aluno1 = new Aluno("Ciri", Genero.NAO_BINARIO, "ciri@yahoo.com", "321senha", Permissoes.PUBLIC,
				"Eng. Alimentos", "12345");
		Aluno aluno2 = new Aluno("Dandelion", Genero.MASCULINO, "dan@uol.com", "senha321", Permissoes.DEFAULT,
				"Musica", "54321");
		Aluno aluno3 = new Aluno("Zoltan", Genero.NAO_IDENTIFICADO, "zoltan@dac.unicamp.br", "sen321ha", Permissoes.PRIVATE,
				"Eng. Mecânica", "00012");
		Aluno aluno4 = new Aluno("Triss", Genero.FEMININO, "triss@apple.mail.com", "sen123ha", Permissoes.DEFAULT,
				"Eng. Química", "00044");
		Aluno aluno5 = new Aluno("Fringila", Genero.NAO_BINARIO, "frin@usp.br", "sen000ha", Permissoes.PRIVATE,
				"Química", "00055");
		Aluno aluno6 = new Aluno("Emhyr", Genero.MASCULINO, "emhyr@unesp.br", "senha000", Permissoes.PUBLIC,
				"Economia", "99666");
		
		// Instancias de turmas
		Turma turma1 = prof1.criarTurma("Bruxos I", "BX111");
		Turma turma2 = prof2.criarTurma("Quimica I", "QG101");
		
		// Insercao dos alunos, peds e pads nas turmas
		aux1.addAll(Arrays.asList(aluno2, aluno4, aluno6));
		turma1.setAlunos(aux1);
		turma1.adicionaPed(prof1, aluno1);
		turma1.adicionaPad(prof1, aluno3);
		
		aux1.clear();	aux1.addAll(Arrays.asList(aluno1, aluno2, aluno3));
		turma2.setAlunos(aux1);
		turma2.adicionaPed(prof2, aluno5);
		turma2.adicionaPad(prof2, aluno4);

		// 
		
	}

}
