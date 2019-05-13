package poo.provas.p2.armazenamento;

import java.util.ArrayList;
import java.util.List;

public class EstanteDeLivros implements Armazem {
	
	private final List<Armazenavel> itens = new ArrayList<>();
	
	public EstanteDeLivros() {
		// TODO Auto-generated constructor stub
	}
	
	private boolean ehUmLivro(Armazenavel variavelDoTipoArmazenavel){
		return variavelDoTipoArmazenavel instanceof Livro;
	}

	@Override
	public void guardar(Armazenavel livro) {
		// TODO Auto-generated method stub
		if(ehUmLivro(livro)){
			itens.add(livro);
		}
	}

	@Override
	public boolean temEspacoLivre() {
		// TODO Auto-generated method stub
		return true;
	}

}
