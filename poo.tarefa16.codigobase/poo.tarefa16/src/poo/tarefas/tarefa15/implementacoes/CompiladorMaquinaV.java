package poo.tarefas.tarefa15.implementacoes;

import java.util.Scanner;

import poo.tarefas.tarefa15.interfaces.Comando;
import poo.tarefas.tarefa15.interfaces.Compilador;
import poo.tarefas.tarefa15.interfaces.Programa;

public class CompiladorMaquinaV implements Compilador {

	@Override
	public Programa compilar(String codigoFonte) {
		Programa programa = new MeuPrograma();

		try (Scanner leitor = new Scanner(codigoFonte)) {
			while (leitor.hasNext()) {
				programa.adicionarComando(compilarLinha(leitor));
			}
		}

		return programa;
	}

	private Comando compilarLinha(Scanner leitor) {
		switch (leitor.next()) {
		case "repita":
			int numeroDeVezes = leitor.nextInt();
			leitor.nextLine();		// Apenas para consumir o '\n'
			String proximaLinha = leitor.nextLine();		// Esse realmente le a proxima linha

			return FabricaDeComandos.comandoRepeticao(numeroDeVezes, compilarLinha(new Scanner(proximaLinha)));

		case "ler":
			return FabricaDeComandos.comandoLeitura(leitor.next());

		case "#":
			leitor.nextLine();		// Ignora o resto da linha que contem o comentario
			return FabricaDeComandos.comentario();

		case "escrever":
			return FabricaDeComandos.comandoEscrita();

		case "a":
			return processarVariavel(leitor, "a");

		case "b":
			return processarVariavel(leitor, "b");

		case "c":
			return processarVariavel(leitor, "c");

		default:
			throw new IllegalStateException();
		}
	}

	private Comando processarVariavel(Scanner leitor, String nomeDaVariavel) {
		switch (leitor.next()) {
		case "=":
			return FabricaDeComandos.comandoAtribuicao(nomeDaVariavel, leitor.nextInt());

		case "+=":
			String valorADireita = leitor.next();
			switch (valorADireita) {
			case "a":
			case "b":
			case "c":
				return FabricaDeComandos.comandoSomaDeVariavel(nomeDaVariavel, valorADireita);

			default:
				return FabricaDeComandos.comandoSomaDeValorInteiro(nomeDaVariavel, Integer.parseInt(valorADireita));
			}

		default:
			throw new IllegalStateException();
		}
	}

}
