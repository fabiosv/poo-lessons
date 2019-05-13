package grafo;

import grafo.implementacao.Dijkstra;
import grafo.implementacao.Grafos;
import grafo.implementacao.Vertice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.swing.JOptionPane;

public class Programa {
	public static void main(String[] args) throws URISyntaxException, IOException {
		InterpretadorGrafo interpretador;
		Dijkstra dijkstra;
		Grafos grafo = new Grafos();
		//URI uri = Programa.class.getResource("BackboneRNP.txt").toURI();
		URI uri = Programa.class.getResource("testeComNumeros.txt").toURI();
		//URI uri = Programa.class.getResource("testeRNP.txt").toURI();
		try {
			interpretador = new InterpretadorGrafo(new FileReader(new File(uri)));
			interpretador.lerDocumento();
			grafo = interpretador.getGrafo();
			grafo.imprimirListaAdjacencia();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		dijkstra = new Dijkstra(grafo);
		lerTela(dijkstra);
	}

	private static void lerTela(Dijkstra dijkstra) {
		String origem = JOptionPane.showInputDialog("Insira o Servidor Origem");
		String destino = JOptionPane.showInputDialog("Insira o Servidor Destino");
		List<Vertice> caminho = dijkstra.definirCaminhoEntre(origem, destino);
		
		System.out.println("\nCaminho traçado: ");
		for (Vertice vertice : caminho) {
			System.out.println(vertice.getDescricao()+"|");
		}
		JOptionPane.showMessageDialog(null, dijkstra.toString());
	}
}
