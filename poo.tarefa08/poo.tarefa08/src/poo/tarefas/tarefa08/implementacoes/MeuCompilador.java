package poo.tarefas.tarefa08.implementacoes;

import java.util.Scanner;

import poo.tarefas.tarefa08.interfaces.Comando;
import poo.tarefas.tarefa08.interfaces.CompiladorMaquinaZ;
import poo.tarefas.tarefa08.interfaces.Programa;

public class MeuCompilador implements CompiladorMaquinaZ {

	@Override
	public Programa compilar(String codigoFonte) {
		Programa programa = new MeuPrograma();

		for (String linha : codigoFonte.split("\n")) {
			programa.adicionarComando(compilarLinha(linha));
		}

		return programa;
	}

	private Comando compilarLinha(String linha) {
		try (Scanner leitor = new Scanner(linha)) {
			switch (leitor.next()) {
			case "escrever":
				return new ComandoEscrita();

			case "a":
				if (!leitor.next().equals("=")) throw new IllegalStateException();
				return new ComandoAtribuicao("a", leitor.nextInt());

			case "b":
				if (!leitor.next().equals("=")) throw new IllegalStateException();
				return new ComandoAtribuicao("b", leitor.nextInt());

			case "c":
				switch (leitor.next()) {
				case "=":
					return new ComandoAtribuicao("c", leitor.nextInt());

				case "+=":
					String valorADireita = leitor.next();
					switch (valorADireita) {
					case "a":
						return new ComandoSomaDeVariavel("a");

					case "b":
						return new ComandoSomaDeVariavel("b");

					default:
						return new ComandoSomaDeValorInteiro(Integer.parseInt(valorADireita));
					}

				default:
					throw new IllegalStateException();
				}
			default:
				throw new IllegalStateException();
			}
		}
	}

}
