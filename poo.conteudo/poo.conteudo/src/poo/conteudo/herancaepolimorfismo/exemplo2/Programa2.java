package poo.conteudo.herancaepolimorfismo.exemplo2;

import javax.swing.JOptionPane;

public class Programa2 {

	public static void main(String[] args) {
		String opcao = JOptionPane.showInputDialog(""
				+ "Digite:\n"
				+ "    circulo [raio]\n"
				+ "ou:\n"
				+ "    quadrado [lado]"
				+ "");

		String[] dados = opcao.split(" ");
		String nomeDaForma = dados[0];
		double raioOuLado = Double.parseDouble(dados[1]);

		FormaGeometrica forma = criarForma(nomeDaForma, raioOuLado);

		System.out.printf("Area: %.2f   Perimetro: %.2f\n",
				forma.calcularArea(), forma.calcularPerimetro());
	}

	private static FormaGeometrica criarForma(String nomeDaForma,
			double raioOuLado) {
		switch (nomeDaForma) {
		case "circulo":  return new Circulo(raioOuLado);
		case "quadrado": return new Quadrado(raioOuLado);
		default:         throw new IllegalArgumentException(nomeDaForma);
		}
	}

}
