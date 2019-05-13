package poo.conteudo.membrosestaticos.exemplo4;

public class Main4 {

	public static void main(String[] args) {
		Caixa primeira = Caixa.criarPequena();
		Caixa segunda  = Caixa.criarMedia();
		Caixa terceira = Caixa.criarGrande();

		System.out.println("Capacidades:");
		System.out.println(primeira.getCapacidade());
		System.out.println(segunda.getCapacidade());
		System.out.println(terceira.getCapacidade());
	}

}
