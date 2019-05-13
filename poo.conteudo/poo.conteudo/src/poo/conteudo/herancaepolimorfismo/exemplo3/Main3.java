package poo.conteudo.herancaepolimorfismo.exemplo3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Main3 {

	public static void main(String[] args) {
		Map<String, Formatador> formatadores = new HashMap<>();
		formatadores.put("ascii", new FormatadorAscii());
		formatadores.put("espacos", new FormatadorEspacos(20));
		formatadores.put("html", new FormatadorHtml());
		formatadores.put("json", new FormatadorJson());
		formatadores.put("xml", new FormatadorXml());

		String titulo = JOptionPane.showInputDialog("Digite um titulo");
		String autor = JOptionPane.showInputDialog("Digite um autor");
		String corpo = JOptionPane.showInputDialog("Digite um corpo de texto");

		Texto texto = new Texto(titulo, autor, corpo);

		String opcaoDeFormatador;
		do {
			do {
				opcaoDeFormatador = JOptionPane.showInputDialog("Escolha um formatador:\n"
						+ "ascii\n"
						+ "espacos\n"
						+ "html\n"
						+ "json\n"
						+ "xml\n");
			} while (opcaoDeFormatador != null &&
					!Arrays.asList("ascii", "espacos", "html", "json", "xml")
					.contains(opcaoDeFormatador));

			if (opcaoDeFormatador != null) {
				System.out.println("Formatando com " + opcaoDeFormatador + ":");

				Formatador f = formatadores.get(opcaoDeFormatador);

				System.out.println(f.formatar(texto));
				System.out.println();
			}
		} while (opcaoDeFormatador != null);
	}

}
