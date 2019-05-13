package poo.tarefa05;

public class Marcador {

	private Cor cor;
	private int carga;
	private boolean tampado;

	public Marcador(Cor cor, int carga) {
		this.cor = cor;
		this.carga = carga;
		tampado = true;
	}

	public void destampar() {
		tampado = false;
	}

	public void escrever(String texto) {
		if (tampado || carga <= 0) {
			System.out.println("...");
		} else {
			System.out.println(cor + ": " + texto);
			--carga;
		}
	}

}
