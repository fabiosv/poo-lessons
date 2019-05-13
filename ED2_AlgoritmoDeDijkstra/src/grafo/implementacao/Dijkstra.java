package grafo.implementacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dijkstra {

	private Grafos grafo;
	private List<Vertice> menorCaminho = new ArrayList<Vertice>();
	private VerificarGrafo verificador = new VerificarGrafo();

	private double custoCaminhoTotal;

	public Dijkstra(Grafos grafo) {
		this.grafo = grafo;
	}

	private void imprimirVisitados(List<Vertice> verticesVisitados) {
		for (Vertice visit : verticesVisitados) {
			System.out.println("visitado:" + visit.getDescricao());
		}
	}
	
	private List<Vertice> clonarLista(List<Vertice> lista){
		List<Vertice> lista2 = new ArrayList<Vertice>();
		for (Vertice vertice : lista) {
			lista2.add(vertice);
		}
		return lista2;
	}

	private List<Vertice> buscarMenorCaminho(List<Vertice> caminho,List<Vertice> verticesVisitados, Vertice atual, Vertice destino) {		
		if (verticesVisitados == null) {
			verticesVisitados = new ArrayList<Vertice>();
		}
		verticesVisitados.add(atual);
		if (!atual.equals(destino)) { //Verifica se esse nóh é o destino
			if(atual.ehIncidente(destino)){ //verifica se esse noh é adjacente do destino
				List<Vertice> verticesAdjacentes = atual.getEntidadesAdjacentes();
				Vertice verticeAdjacenteQueIncideNoDestino = atual;
				
				for (Vertice vertice : verticesAdjacentes) {
					if(verificador.verificarSeHaTriangulacao(atual, vertice, destino)){
						verticeAdjacenteQueIncideNoDestino = verificador.verificarMenorPesoTriangulo(atual, vertice, destino);
					}
				}
				
				if(verticeAdjacenteQueIncideNoDestino == null || verticeAdjacenteQueIncideNoDestino.equals(atual)){
					caminho.add(destino);
				} else {
					caminho.add(verticeAdjacenteQueIncideNoDestino);
					caminho.add(destino);
				}
				caminho = buscarMenorCaminho(caminho, verticesVisitados, destino, destino);
			} else {
				VerticeDijkstra verticeDijkstra = new VerticeDijkstra(atual.getEntidadesAdjacentes(), atual);
				Vertice proximo = verificador.verificarVerticeMenorPeso(new VerticeDijkstra(atual.getEntidadesAdjacentes(), atual), verticesVisitados);
				List<Vertice> caminhoAlternativo = clonarLista(caminho);
				
				if(verticeDijkstra.verificarSeAlgumVerticeAdjacenteIncideNoDestino(verticesVisitados, destino) != null){ //verifica se possui algum noh que incide no destino
					Vertice verticeProximoDoDestino = verticeDijkstra.verificarSeAlgumVerticeAdjacenteIncideNoDestino(verticesVisitados, destino);
					int quantidadeVerticesIncidentes = 0;
					for(Vertice adjacentesDoVerticeAtual : atual.getEntidadesAdjacentes()){ //verifica caminhos alternativos e os controi apartir do vertice atual
						if(adjacentesDoVerticeAtual.ehIncidente(destino)&&!adjacentesDoVerticeAtual.equals(proximo)){
							quantidadeVerticesIncidentes++;
							if(quantidadeVerticesIncidentes<2){
								verticeProximoDoDestino = adjacentesDoVerticeAtual;									
							} else {
								if(quantidadeVerticesIncidentes >= 2){
									verticeProximoDoDestino = verificador.verificarMenorPesoTriangulo(adjacentesDoVerticeAtual, caminho.get(caminho.size()-1), destino);
								}
							}								
						}
					}
					caminho.add(verticeProximoDoDestino);
					caminho = buscarMenorCaminho(caminho, verticesVisitados, verticeProximoDoDestino, destino);
					
				} else {	//procurar o proximo caminho
					
					verticeDijkstra = new VerticeDijkstra(proximo.getEntidadesAdjacentes(),proximo);
					Vertice proximoDoProximo = verificador.verificarVerticeMenorPeso(verticeDijkstra, verticesVisitados);

					if(verificador.verificarSeHaTriangulacao(atual, proximo, proximoDoProximo)){ //verifica qual caminho é o mais indicado
						caminho.add(verificador.verificarMenorPesoTriangulo(atual, proximo, proximoDoProximo));
						caminho = buscarMenorCaminho(caminho, verticesVisitados, proximoDoProximo, destino);
					} else {
						if(!proximo.equals(destino)&&proximoDoProximo != null){
							caminho.add(proximo);
							caminho = buscarMenorCaminho(caminho, verticesVisitados, proximo, destino);
						} else {
							verticesVisitados.add(proximoDoProximo);
							verticesVisitados.remove(atual);
							if(caminho.contains(proximoDoProximo)){
								caminho.remove(caminho.size()-1);
							}
							return caminho;
						}
					}
					for (Vertice vertice : atual.getEntidadesAdjacentes()) {
						List<Vertice> verticesVisitados2 = new ArrayList<Vertice>();
						verticesVisitados2.add(atual);
						caminhoAlternativo = buscarMenorCaminho(caminhoAlternativo, verticesVisitados2, vertice, destino);
						if(caminhoAlternativo.contains(destino)){
							double pesoCaminhoAlternativo = verificador.calcularCaminho(caminhoAlternativo);
							double pesoCaminhoAtual = verificador.calcularCaminho(caminho);
							
							if(pesoCaminhoAtual <= pesoCaminhoAlternativo){
								if(caminho.contains(destino)){
									return caminho;
								} else {
									return caminhoAlternativo;
								}
							}
						}
					}
				}
			}			
		} else {
			imprimirVisitados(verticesVisitados);
		}
		return caminho;
	}

	public List<Vertice> definirCaminhoEntre(String origem, String destino) {
		List<Vertice> caminho = new ArrayList<Vertice>();
		Vertice verticeOrigem, verticeDestino;
		verticeOrigem = grafo.getVertice(origem);
		verticeDestino = grafo.getVertice(destino);
		if(verticeOrigem != null || verticeDestino != null){
			caminho.add(verticeOrigem);

			caminho = buscarMenorCaminho(caminho, null, verticeOrigem, verticeDestino);
			System.out.println("\ncusto final:");
			custoCaminhoTotal = verificador.calcularCaminho(caminho);
			menorCaminho = caminho;
		}

		return caminho;
	}

	public double getCustoCaminho() {
		return custoCaminhoTotal;
	}

	public static class VerticeDijkstra {
		private List<Vertice> adjacentes;
		private Map<Vertice, Double> valorVertice = new HashMap<Vertice, Double>();

		public VerticeDijkstra(List<Vertice> adjacentes, Vertice origem) {
			this.adjacentes = adjacentes;
			double valor = 0;
			for (Vertice vertice : adjacentes) {
				valor = vertice.getValorAresta(origem);
				valorVertice.put(vertice, valor);
			}
		}
		
		public Vertice verificarSeAlgumVerticeAdjacenteIncideNoDestino(List<Vertice> verticesVisitados, Vertice destino){
			Vertice verticeAdjacente = null;
			for(Vertice vertice : adjacentes){
				if(vertice.ehIncidente(destino)&&!verticesVisitados.contains(vertice)){
					verticeAdjacente = vertice;
				}
			}
			return verticeAdjacente;
		}

		public double pegarValorAresta(Vertice vertice) {
			return (Double) valorVertice.get(vertice);
		}

		public List<Vertice> getAdjacentes() {
			return adjacentes;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Caminho mínimo encontrado: ");
		
		for (Vertice vertice : menorCaminho) {
			sb.append(vertice.getDescricao());
			if(menorCaminho.indexOf(vertice) != (menorCaminho.size()-1)){
				sb.append("->");
			}
		}
		
		sb.append(" com peso de: " + custoCaminhoTotal);

		return sb.toString();
	}
}