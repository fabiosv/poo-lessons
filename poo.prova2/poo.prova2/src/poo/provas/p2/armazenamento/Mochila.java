package poo.provas.p2.armazenamento;

import java.util.ArrayList;
import java.util.List;

public class Mochila implements Armazem {

	private final List<Armazenavel> itens = new ArrayList<>();
	
	@Override
	public void guardar(Armazenavel item) {
		// TODO Auto-generated method stub
		itens.add(item);
	}

	@Override
	public boolean temEspacoLivre() {
		// TODO Auto-generated method stub
		return true;
	}

}
