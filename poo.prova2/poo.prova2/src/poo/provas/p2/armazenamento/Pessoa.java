package poo.provas.p2.armazenamento;

import java.util.HashSet;
import java.util.Set;

public class Pessoa {
	
	private Set<Livro> livrosLidos = new HashSet<Livro>();

	public void lerLivro(Livro livro) {
		// TODO Auto-generated method stub
		livrosLidos.add(livro);

	}
	
	public boolean leuLivro(Livro livroX) {
		// TODO Auto-generated method stub
		return livrosLidos.contains(livroX);
	}
}
