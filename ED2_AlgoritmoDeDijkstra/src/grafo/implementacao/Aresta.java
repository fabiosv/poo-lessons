package grafo.implementacao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Aresta{

	private final Set<Vertice> extremidades = new HashSet<Vertice>(2);
	private double peso = 0;
	
	public Aresta(double bandaGiga){
		peso = calcularPeso(bandaGiga);
	}
	
	private double calcularPeso(double bandaGiga){
		//return 1/bandaGiga;
		return bandaGiga;
	}
	
	public Set<Vertice> getExtremidades() {
		return extremidades;
	}
	
	public boolean incideNoVertice(Vertice destino){
		return extremidades.contains(destino);
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public void adicionarExtremidade(Vertice vertice) {
		extremidades.add(vertice);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("origem: ");
		 
		for(Iterator<Vertice> interator = extremidades.iterator(); interator.hasNext();){
			Vertice vertice = interator.next();
			sb.append(vertice.getDescricao());
			sb.append("|destino: ");
		}
		
		return sb.toString();
	}
}
