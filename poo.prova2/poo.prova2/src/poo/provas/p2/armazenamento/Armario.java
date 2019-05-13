package poo.provas.p2.armazenamento;

import java.util.ArrayList;
import java.util.List;

public class Armario implements Armazem {

	private final int espacoTotal;
	private final List<Armazenavel> itens;

	private Armario(int espacoTotal) {
		this.espacoTotal = espacoTotal;
		this.itens = new ArrayList<>(espacoTotal);
	}

	public static Armario criarPequeno() {
		return new Armario(2);
	}

	public static Armario criarMedio() {
		return new Armario(4);
	}

	public static Armario criarGrande() {
		return new Armario(20);
	}

	@Override
	public void guardar(Armazenavel item) {
		if (temEspacoLivre()) itens.add(item);
	}

	@Override
	public boolean temEspacoLivre() {
		int espacoOcupado = 0;

		for (Armazenavel item : itens) {
			espacoOcupado += item.espacoQueOcupa();
		}

		return espacoOcupado < espacoTotal;
	}

}
