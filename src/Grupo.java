import java.util.ArrayList; 

// Permite unir diferentes usuarios
public class Grupo {	
	private String nomeGrupo;
	private ArrayList<Usuario> grupo; 
	private boolean status; 

	public Grupo(String nomeGrupo, ArrayList<Usuario> grupo) {
		this.nomeGrupo = nomeGrupo;
		this.grupo = grupo; 
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
	
	public void adicionarGrupo() {
		for(Usuario membro:getGrupo())
			membro.getGrupos().add(this);
	}
	
	public boolean adicionarUsuario(Usuario integrante, Usuario forasteiro) {
		if(grupo.contains(integrante)) {
			if(!grupo.contains(forasteiro)) {
				grupo.add(forasteiro); 
				forasteiro.getGrupos().add(this);
				
				return true;
			}
		}
		return false;
	}
	
	public boolean removerUsuario(Usuario integrante, Usuario removido) {
		if(grupo.contains(integrante)) {
			if(grupo.contains(removido)) {
				grupo.remove(removido); 
				removido.getGrupos().remove(this);
				
				return true;
			}
		}
		return false;
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
		String out = "\n* Nome do grupo:" + nomeGrupo;
		out = out + "\nPessoas:";
		for(Usuario pessoa:grupo) 
			out = out + "\n" + pessoa.getNome() + ", Id:" + pessoa.getId(); 
		out = out + "\nStatus:" + status + "\n"; 
		return out; 
	}
}
