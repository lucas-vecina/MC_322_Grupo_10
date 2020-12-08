import java.util.ArrayList; 

public class Grupo {
	private String nomeGrupo;
	private ArrayList<Usuario> grupo; 
	private boolean status; 

	public Grupo(String nomeGrupo, ArrayList<Usuario> grupo) {
		this.nomeGrupo = nomeGrupo;
		this.grupo = grupo; 
		for(Usuario membro:grupo) {
			membro.getGrupos().add(this);
		}
		status = true;
	}
	
	public Grupo(ArrayList<Usuario> grupo) {
		nomeGrupo = "Default";
		this.grupo = grupo;
		status = true; 
	}

	public String getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

	public ArrayList<Usuario> getGrupo() {
		return grupo;
	}

	public void setGrupo(ArrayList<Usuario> grupo) {
		this.grupo = grupo;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void adicionarUsuario(Usuario integrante, Usuario forasteiro) {
		if(grupo.contains(integrante)) {
			if(!grupo.contains(forasteiro)) {
				grupo.add(forasteiro); 
				forasteiro.getGrupos().add(this);
			}
		}
	}
	
	public void removerUsuario(Usuario integrante, Usuario removido) {
		if(grupo.contains(integrante)) {
			if(grupo.contains(removido)) {
				grupo.remove(removido); 
			}
		}
	}
	
	public void eliminarGrupo(Usuario integrante) {
		if(grupo.contains(integrante)) {
			for(Usuario membro:grupo) {
				membro.getGrupos().remove(this); 
				grupo.remove(membro);
			}
			status = false; 
		}
	}
	
	public String toString() {
		String out = "Nome do grupo:" + nomeGrupo;
		out = out + "\nPessoas:";
		for(Usuario pessoa:grupo) 
			out = out + "\n" + pessoa.getNome() + ", Id:" + pessoa.getId(); 
		out = out + "\nStatus:" + status; 
		return out; 
	}
}
