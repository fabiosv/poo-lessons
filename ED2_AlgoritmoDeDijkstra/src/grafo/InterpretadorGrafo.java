package grafo;

import grafo.implementacao.Grafos;
import grafo.implementacao.Vertice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class InterpretadorGrafo {
	
	private FileReader file;
	private Set<Vertice> vertices = new HashSet<Vertice>();
	private Grafos grafo = new Grafos();
	
	public InterpretadorGrafo(FileReader file) {
		this.file = file;
	}

	public void lerDocumento() throws IOException{
		BufferedReader reader = new BufferedReader(file);
		String currentLine;
		Scanner scanner;

		try {
			while (reader.ready()) {
				Vertice origem = null, destino = null;
				double valor = 0;
				
				currentLine = reader.readLine(); // Aqui é a linha de texto
				// A partir daqui são palavras
				scanner = new Scanner(currentLine);
				scanner.useDelimiter(Pattern.compile(" "));
				
				while(scanner.hasNext()){
					String word = scanner.next();
					if(word.equalsIgnoreCase("Vertice")){
						origem = criarVertice(scanner);
						origem = verificarAmbiguidadeVertice(origem);
						vertices.add(origem);
					}
					
					if(word.equalsIgnoreCase("-")){
						destino = criarVertice(scanner);
						destino = verificarAmbiguidadeVertice(destino);
						vertices.add(destino);
					}
					
					if(word.startsWith("=")){
						valor = Double.parseDouble(scanner.next());
						//System.out.println("valor: "+valor);
					}
					
				}
				
				grafo.adicionarVerticeAssociado(origem, destino, valor);
				scanner.close();
			}
			//grafo.imprimirListaAdjacencia();
			//imprimirVertices();
			reader.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void imprimirVertices(){
		int i = 0;
		for(Iterator<Vertice> interator = vertices.iterator(); interator.hasNext();){
			Vertice vertice = interator.next();
			System.out.println(i+" "+vertice.getDescricao());
			i++;
		}
		System.out.println("Consulta peso "+grafo.consultarPesoAresta(new Vertice("sp"), new Vertice("rj")));
		
	}
	
	private Vertice verificarAmbiguidadeVertice(Vertice verticeTeste){
		for(Iterator<Vertice> interator = vertices.iterator(); interator.hasNext();){
			Vertice vertice = interator.next();
			if(vertice.getDescricao().equalsIgnoreCase(verticeTeste.getDescricao())){
				verticeTeste = vertice;
			}
		}
		return verticeTeste;
	}
	
	private Vertice criarVertice(Scanner scanner){
		String nome = scanner.next();
		if(nome.endsWith(",")){
			nome = nome.substring(0, nome.length()-1);
		}
		//System.out.println(vertice);
		Vertice vertice = new Vertice(nome);
		//System.out.println(vertice.getDescricao());
		//System.out.println(existeVertice(vertice));
		return vertice;
	}
	
	public Grafos getGrafo() {
		return grafo;
	}
}
