package poo.provas.p2.armazenamento;

public class Main {

	public static void main(String[] args) {
		Armario a1 = Armario.criarPequeno();
		a1.guardar(new Livro());
		a1.guardar(new Caderno());
		a1.guardar(new Caderno());

		Armario a2 = Armario.criarMedio();
		a2.guardar(new Livro());
		a2.guardar(new Caderno());
		a2.guardar(new Livro());
		a2.guardar(new Caderno());

		Armario a3 = Armario.criarGrande();
		a2.guardar(new Livro());
		a2.guardar(new Caderno());
		a2.guardar(new Livro());
		a2.guardar(new Caderno());
		a2.guardar(new ResmaDePapel());

		System.out.printf("a1 ainda tem espaco? %b\n", a1.temEspacoLivre());
		System.out.printf("a2 ainda tem espaco? %b\n", a2.temEspacoLivre());
		System.out.printf("a3 ainda tem espaco? %b\n", a3.temEspacoLivre());
	}

}
