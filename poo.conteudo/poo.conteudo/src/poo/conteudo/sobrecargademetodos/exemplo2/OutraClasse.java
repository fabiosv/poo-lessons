package poo.conteudo.sobrecargademetodos.exemplo2;

public class OutraClasse {

	public void umMetodo() {
		System.out.println("Eu sou um metodo");
	}

	public void umMetodo(int i) {
		System.out.println("Eu sou outro metodo. Recebi um int: " + i);
	}

	public void umMetodo(String s) {
		System.out.println("Eu sou outro metodo. Recebi uma String: " + s);
	}

	public void umMetodo(int i, String s) {
		System.out.printf("Eu sou outro metodo. Recebi dois parametros: %d, %s", i, s);
	}

}
