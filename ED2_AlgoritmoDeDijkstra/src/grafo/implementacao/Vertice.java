package grafo.implementacao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Vertice{

	private List<Vertice> entidadesAdjacentes = new ArrayList<Vertice>();
	private String descricao;
	private Set<Aresta> arestas = new HashSet<Aresta>();


	public Vertice(String descricao) {
		this.descricao=descricao;
	}
	
	public Vertice(int descricao) {
		StringBuilder sb = new StringBuilder();
		sb.append(descricao);
		this.descricao= sb.toString();
	}
	
	public boolean ehAdjacente(Vertice proximo) {
		return entidadesAdjacentes.contains(proximo);
	}
	
	public boolean ehIncidente(Vertice entidade){
		boolean teste = false;
		for(Iterator<Aresta> interator = arestas.iterator(); interator.hasNext();){
			Aresta aresta = interator.next();
			if(aresta.incideNoVertice(entidade)){
				teste = true;
			}
		}
		return teste;
	}
	
	public double getValorAresta(Vertice destino){
		if(ehIncidente(destino)){
			for(Iterator<Aresta> interator = arestas.iterator(); interator.hasNext();){
				Aresta aresta = interator.next();
				
				if(aresta.incideNoVertice(destino)){
					//System.out.println(aresta.getPeso());
					return aresta.getPeso();
					
				}
			}
			return 999999999;
		}else{
			return 999999999;
		}
	}
	
	public void adicionarAdjacencia(Vertice entidade, Aresta aresta) {
		entidadesAdjacentes.add(entidade);
		arestas.add(aresta);
	}
	
	public Set<Aresta> getArestas() {
		return arestas;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public List<Vertice> getEntidadesAdjacentes() {
		return entidadesAdjacentes;
	}
	
	@Override
	public String toString() {
		String desc = "entidade: "+descricao;
		StringBuilder sb = new StringBuilder();
		sb.append("Entidades Adjacentes: ");
		for (Vertice entidades : entidadesAdjacentes) {
				sb.append(entidades.getDescricao()+" ");
		}
		return desc+" "+sb.toString();
	}
}