package BackEnd;
public enum Cor {
	VERMELHO ("vermelho"),
	AZUL ("azul"),
	AMARELO ("amarelo"),
	LARANJA ("laranja"),
	VERDE ("verde"),
	ROXO ("roxo"),
	PRETO ("preto");
	
	private final String cor;
	
	Cor(String cor){
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}
}
