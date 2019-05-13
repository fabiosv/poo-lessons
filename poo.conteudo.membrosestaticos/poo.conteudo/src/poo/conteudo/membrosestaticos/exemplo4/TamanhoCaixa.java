package poo.conteudo.membrosestaticos.exemplo4;

public enum TamanhoCaixa {

	PEQUENO(1), MEDIO(2), GRANDE(3), EXTRA_GRANDE(4);

	private int capacidade;

	private TamanhoCaixa(int capacidade) {
		this.capacidade = capacidade;
	}

	public int getCapacidade() {
		return capacidade;
	}

}
