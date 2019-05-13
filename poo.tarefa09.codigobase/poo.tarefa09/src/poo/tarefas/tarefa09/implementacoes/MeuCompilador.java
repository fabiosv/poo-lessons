package poo.tarefas.tarefa09.implementacoes;

import poo.tarefas.tarefa09.interfaces.Compilador;
import poo.tarefas.tarefa09.interfaces.Programa;

public class MeuCompilador implements Compilador {

	@Override
	public Programa compilar(String codigoFonte) {
		Programa p = null;

//		for (String linha : codigoFonte.split("\n")) {
//			p.adicionarComando(compilarLinha(linha));
//		}

		return p;
	}

//	private Comando compilarLinha(String linha) {
//		try (Scanner leitor = new Scanner(linha)) {
//			switch (leitor.next()) {
//			case "escrever":
//				return null;
//
//			case "...":
//				return null;
//
//			default:
//				throw new IllegalStateException();
//			}
//		}
//	}
}

