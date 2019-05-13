package poo.conteudo.sobrecargademetodos.exemplo1;

public class Exemplo1 {

	// Um metodo chamado x
	public void x() {
		System.out.println();
	}

	// Outro metodo com mesmo nome,
	// mas lista de parametros diferente
	public void x(int i) {
		System.out.println(i);
	}

	// Resultado: a classe possui dois metodos:
	//		+ x()
	//		+ x(int)

}
