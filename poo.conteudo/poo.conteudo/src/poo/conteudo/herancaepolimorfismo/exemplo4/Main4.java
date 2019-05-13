package poo.conteudo.herancaepolimorfismo.exemplo4;

import javax.swing.JOptionPane;

import poo.conteudo.herancaepolimorfismo.exemplo3.Formatador;
import poo.conteudo.herancaepolimorfismo.exemplo3.Texto;

public class Main4 {

	public static void main(String[] args) {
		String titulo = JOptionPane.showInputDialog("Digite um titulo");
		String autor = JOptionPane.showInputDialog("Digite um autor");
		String corpo = JOptionPane.showInputDialog("Digite um corpo de texto");

		Texto texto = new Texto(titulo, autor, corpo);

		String opcaoDeFormatador;
		do {
			System.out.println("Escolha um formatador:");
			for (Formatador f : FormatadorFixo.values()) {
				System.out.println(f);
			}
			opcaoDeFormatador = JOptionPane.showInputDialog("Sua escolha:");

			if (opcaoDeFormatador != null) {
				System.out.println("Formatando com " + opcaoDeFormatador + ":");

				Formatador f = FormatadorFixo.valueOf(opcaoDeFormatador);

				System.out.println(f.formatar(texto));
				System.out.println();
			}
		} while (opcaoDeFormatador != null);
	}

}
