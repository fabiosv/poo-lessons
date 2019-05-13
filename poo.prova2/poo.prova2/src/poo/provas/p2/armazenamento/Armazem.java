package poo.provas.p2.armazenamento;

public interface Armazem {

	void guardar(Armazenavel a);

	boolean temEspacoLivre();

}
