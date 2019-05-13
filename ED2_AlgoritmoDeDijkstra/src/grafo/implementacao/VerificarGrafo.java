package grafo.implementacao;

import grafo.implementacao.Dijkstra.VerticeDijkstra;

import java.util.List;

public class VerificarGrafo {

	public double calcularCaminho(List<Vertice> caminho) {
		double total = 0;
		for (int i = 0; i < (caminho.size() - 1); i++) {// 3
			Vertice atual = caminho.get(i);
			System.out.print("origem>" + atual.getDescricao());
			Vertice destino = caminho.get((i + 1));
			System.out.print(" destino>" + destino.getDescricao());
			total += atual.getValorAresta(destino);
			System.out.println(" valor: "+total);
		}

		return total;
	}
	
	public boolean verificarSeHaTriangulacao(Vertice atual, Vertice proximo, Vertice alvo){
		if(atual.ehAdjacente(alvo)){
			if(proximo.ehAdjacente(alvo)){
				return true;
			}
		}		
		return false;
	}
	
	public Vertice verificarMenorPesoTriangulo(Vertice atual, Vertice proximo, Vertice alvo){
		double pesoCaminhoDireto = atual.getValorAresta(alvo);
		double pesoCaminhoAlternativo = atual.getValorAresta(proximo)+proximo.getValorAresta(alvo);
		
		if(pesoCaminhoDireto <= pesoCaminhoAlternativo){
			return atual;
		} else {
			return proximo;
		}
	}
	
	public Vertice verificarVerticeMenorPeso(VerticeDijkstra verticeAtual, List<Vertice> verticesVisitados) {
		double valor = 999999;
		List<Vertice> verticesAdjacentes = verticeAtual.getAdjacentes();
		Vertice verticeMaisPerto = null;

		for (Vertice proximoVertice : verticesAdjacentes) {
			double valorAresta = verticeAtual.pegarValorAresta(proximoVertice);
			if (valorAresta < valor) {
				if (!verticesVisitados.contains(proximoVertice)) {
					System.out.println(proximoVertice);
					verticeMaisPerto = proximoVertice;
					valor = valorAresta; 
				}
			}
		}
		System.out.println(valor);

		return verticeMaisPerto;
	}
}