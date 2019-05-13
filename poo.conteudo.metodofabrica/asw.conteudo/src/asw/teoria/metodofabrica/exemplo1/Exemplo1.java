package asw.teoria.metodofabrica.exemplo1;

public class Exemplo1 {

	// Construtor privado. So' a propria classe consegue chamar.
	private Exemplo1() {
	}

	// Metodo fabrica. Estatico e publico. Qualquer um consegue chamar.
	public static Exemplo1 criarMeuObjeto() {
		return new Exemplo1();
	}

}
