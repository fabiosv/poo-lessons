package grafo.implementacao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Grafos {
	private int[][] matrizDeAdjacencia;
	private int[][] matrizDeIncidencia;

	private List<Vertice> vertices;
	private Set<Vertice> verticesLidos = new HashSet<Vertice>();

	public final List<Vertice> getVertices() {
		if(vertices.isEmpty()){
			vertices = converterEmList();
		}
		return vertices;
	}
	
	private List<Vertice> converterEmList(){
		List<Vertice> vertices = new ArrayList<Vertice>();
		for(Iterator<Vertice> interator = verticesLidos.iterator(); interator.hasNext();){
			vertices.add(interator.next());
		}
		return vertices;
	}
	
	public Grafos(){
		
	}
	
	public Grafos(int lista[][]) {
		int quantidadeVertices = lista.length;
		int quantidadeAresta = this.contarAresta(lista);
		
		vertices = new ArrayList<Vertice>(quantidadeVertices);
		
		matrizDeAdjacencia = new int[quantidadeVertices][quantidadeVertices];
		matrizDeIncidencia = new int[quantidadeVertices][quantidadeAresta];
		
		gerarListaVertices(quantidadeVertices,lista);
		criarMatrizAdjacencia(lista);
		criarMatrizIncidencia(lista);
	}
	

	
	public void adicionarVerticeAssociado(Vertice origem, Vertice destino, double bandaGiga){
		origem = verificarAmbiguidadeVertice(origem);
		destino = verificarAmbiguidadeVertice(destino);
		
		verticesLidos.add(origem);
		verticesLidos.add(destino);
			
		associarVertices(origem, destino, bandaGiga);
	}
	
	private Vertice verificarAmbiguidadeVertice(Vertice verticeTeste){
		for(Iterator<Vertice> interator = verticesLidos.iterator(); interator.hasNext();){
			Vertice vertice = interator.next();
			if(vertice.getDescricao().equalsIgnoreCase(verticeTeste.getDescricao())){
				verticeTeste = vertice;
			}
		}
		return verticeTeste;
	}


	private void gerarListaVertices(int quantidadeVertices, int[][] lista) {
		for (int j = 0; j < lista.length; j++) {
			int num = j+1;
			vertices.add(new Vertice(num));
		}
		associarVertices(lista, 1);
	}
	
	private void associarVertices(int[][] lista, double bandaGiga) {
			int i = 0;
			Vertice origem, destino;
			Aresta aresta;
			for (int[] nohDaRodada : lista) {
				origem = vertices.get(i);
				for (int adjacentes : nohDaRodada) {
					destino = vertices.get(adjacentes-1);
					
					aresta = new Aresta(bandaGiga);
					aresta.adicionarExtremidade(origem);
					aresta.adicionarExtremidade(destino);
					
					origem.adicionarAdjacencia(destino,aresta);
					destino.adicionarAdjacencia(origem,aresta);
					//entidades.set(adj-1, destino);
				}
				i++;
			}
	}
	
	private void associarVertices(Vertice origem, Vertice destino, double bandaGiga) {
		Aresta aresta = new Aresta(bandaGiga);
		
		aresta.adicionarExtremidade(origem);
		aresta.adicionarExtremidade(destino);
		
		origem.adicionarAdjacencia(destino,aresta);
		destino.adicionarAdjacencia(origem,aresta);
	}

	private int contarAresta(int lista[][]) {
		int arestas = 0;
		for (int i = 0; i < lista.length; i++) {
			arestas += lista[i].length;
		}

		return arestas;
	}

	private void criarMatrizAdjacencia(int lista[][]) {
		for (int i = 0; i < vertices.size(); i++) {
			Vertice vertice = vertices.get(i);
			vertice.getEntidadesAdjacentes();
			
			for (Vertice verticeAdjacente : vertice.getEntidadesAdjacentes()) {
				matrizDeAdjacencia[i][(vertices.indexOf(verticeAdjacente))] = 1;
			}			
			
		}
	}
	
	private void criarMatrizIncidencia(int lista[][]) {
		int k = 0; //utilizado para achar a aresta na matriz de incidencia
		for (int i = 0; i < lista.length; i++) {
			for (int j = 0; j < lista[i].length; j++) {
				matrizDeIncidencia[i][k] = -1;
				matrizDeIncidencia[(lista[i][j]-1)][k] = 1;
				k++; 
			}
		}
	}
	
	public void imprimirMatrizAdjacencia() {
		if(matrizDeAdjacencia == null){
			
		}
		for (int i = 0; i < matrizDeAdjacencia.length; i++) {
			for (int j = 0; j < matrizDeAdjacencia[i].length; j++) {
				System.out.printf("%d\t",matrizDeAdjacencia[i][j]);
			}
			System.out.printf("\n");
		}
	}
	
	public void imprimirMatrizIncidencia() {
		for (int i = 0; i < matrizDeIncidencia.length; i++) {
			for (int j = 0; j < matrizDeIncidencia[i].length; j++) {
				if(matrizDeIncidencia[i][j] == 1){
					System.out.printf("+%d\t",matrizDeIncidencia[i][j]);
				} else {
					System.out.printf("%d\t",matrizDeIncidencia[i][j]);
				}				
			}
			System.out.printf("\n");
		}
	}

	public List<Integer> buscaEmLargura(Vertice origem, Vertice destino) {
		
		return null;
	}
	
	public List<Integer> buscaEmProfundidade(Vertice origem, Vertice destino) {
		
		return null;
	}
	
	public boolean ehIncidente(Vertice origem, Vertice destino) {
		return origem.ehIncidente(destino);
	}
	
	public void imprimirListaAdjacencia(){
		Set<Aresta> arestas;
		
		for (Vertice noh : verticesLidos) {
			arestas = noh.getArestas();
		
			for (Aresta aresta : arestas) {
				System.out.println(aresta.toString());
			}
		}
		for (Vertice entidade : verticesLidos) {
			System.out.println(entidade.toString());
		}
	}
	
	public List<Vertice> getListaAdjacencia(Vertice vertice){
		return vertice.getEntidadesAdjacentes();
	}
	
	public Vertice getVertice(String nomeVertice){
		if(vertices == null||vertices.isEmpty()){
			vertices = converterEmList();
		}
		for (Vertice vertice : vertices) {
			if(vertice.getDescricao().equalsIgnoreCase(nomeVertice)){
				System.out.println("encontrado vertice: "+nomeVertice);
				return vertice;
			}
		}
		System.out.println("Não encontrado");
		return null;
	}
	
	public double consultarPesoAresta(Vertice origem, Vertice destino){
		origem = verificarAmbiguidadeVertice(origem);
		destino = verificarAmbiguidadeVertice(destino);
		System.out.println(origem.getDescricao());
		return origem.getValorAresta(destino);
	}
	
	/*private List<Integer> listaPredecessor(int lista[][], int noh){
		return null;
	}
	
	private List<Integer> montarCaminho(){
		return null;
	}*/
}
