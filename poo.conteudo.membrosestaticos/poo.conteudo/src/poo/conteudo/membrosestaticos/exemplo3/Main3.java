package poo.conteudo.membrosestaticos.exemplo3;

public class Main3 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Quantidade inicial de caixas
		System.out.println(Caixa.getQuantidadeCriada());

		// Criando uma
		Caixa c1 = new Caixa(TamanhoCaixa.PEQUENO);

		// Quantidade de caixas apos criar uma
		System.out.println(Caixa.getQuantidadeCriada());

		// Criando outra
		Caixa c2 = new Caixa(TamanhoCaixa.MEDIO);

		// Quantidade de caixas apos criar duas
		System.out.println(Caixa.getQuantidadeCriada());

		System.out.println(Caixa.getQuantidadeCriada());
	}

}
