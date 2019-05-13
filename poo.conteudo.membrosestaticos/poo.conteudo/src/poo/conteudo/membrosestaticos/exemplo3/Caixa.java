package poo.conteudo.membrosestaticos.exemplo3;

public class Caixa {

	// Campo de instancia
	private TamanhoCaixa tamanho;

	// Construtor
	public Caixa(TamanhoCaixa tamanho) {
		++quantidadeCriada;
		this.tamanho = tamanho;
	}

	// Metodo de instancia
	public TamanhoCaixa getTamanho() {
		return tamanho;
	}

	// -------------------------------------------

	// Campo estatico
	private static int quantidadeCriada = 0;

	// Metodo estatico
	public static int getQuantidadeCriada() {
		return quantidadeCriada;
	}

}
