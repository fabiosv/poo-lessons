package poo.tarefas.tarefa04;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

//A Máquina Z é um computador capaz de executar as seguintes instruções:
//	Atribuição
//		Sintaxe:
//			(variável a | variável b | variável c) = (valor inteiro)
//	Soma
//		Sintaxe:
//			c += (valor inteiro | variável a | variável b)
//	Escrita
//		Sintaxe:
//			escrever
//			(ao fazer isso, é escrito o valor de c)
//
public class InterpretadorMaquinaZ {

	private int a;
	private int b;
	private int c;

	public InterpretadorMaquinaZ() {
		Random random = new Random();
		a = random.nextInt();
		b = random.nextInt();
		c = random.nextInt();
	}

	public void executar(String codigoFonte) {
		for (String linha : codigoFonte.split("\n")) {
			executarLinha(linha);
		}
	}

	public void executar(List<String> linhasDeCodigo) {
		for (String linha : linhasDeCodigo) {
			executarLinha(linha);
		}
	}

	private void executarLinha(String linha) {
		try (Scanner leitor = new Scanner(linha)) {
			switch (leitor.next()) {
			case "escrever":
				System.out.println(c);
				break;

			case "a":
				if (!leitor.next().equals("=")) throw new IllegalStateException();
				a = leitor.nextInt();
				break;

			case "b":
				if (!leitor.next().equals("=")) throw new IllegalStateException();
				b = leitor.nextInt();
				break;

			case "c":
				switch (leitor.next()) {
				case "=":
					String valorADireita = leitor.next();
					switch (valorADireita) {
					case "a":
						c = a;
						break;

					case "b":
						c = b;
						break;

					default:
						c = Integer.parseInt(valorADireita);
						break;
					}
					break;

				case "+=":
					valorADireita = leitor.next();
					switch (valorADireita) {
					case "a":
						c += a;
						break;

					case "b":
						c += b;
						break;

					default:
						c += Integer.parseInt(valorADireita);
						break;
					}
					break;

				default:
					throw new IllegalStateException();
				}
				break;
			}
		}
	}
}

