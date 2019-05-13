package poo.conteudo.membrosestaticos.exemplo4;

public class Caixa {

	private TamanhoCaixa tamanho;

	private Caixa(TamanhoCaixa tamanho) {
		this.tamanho = tamanho;
	}

	// ----------- Metodos-fabrica -----------
	public static Caixa criarPequena() {
		return new Caixa(TamanhoCaixa.PEQUENO);
	}

	public static Caixa criarMedia() {
		return new Caixa(TamanhoCaixa.MEDIO);
	}

	public static Caixa criarGrande() {
		return new Caixa(TamanhoCaixa.GRANDE);
	}
	// ---------------------------------------

	public int getCapacidade() {
		return tamanho.getCapacidade();
	}

}
