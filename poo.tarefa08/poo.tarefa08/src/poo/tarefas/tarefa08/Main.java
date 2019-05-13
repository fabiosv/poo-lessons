package poo.tarefas.tarefa08;

import poo.tarefas.tarefa08.implementacoes.MeuAmbienteDeExecucao;
import poo.tarefas.tarefa08.implementacoes.MeuCompilador;
import poo.tarefas.tarefa08.interfaces.AmbienteDeExecucao;
import poo.tarefas.tarefa08.interfaces.CompiladorMaquinaZ;
import poo.tarefas.tarefa08.interfaces.Programa;

public class Main {

	public static void main(String[] args) {
		String codigoFonte = "" +
				"escrever\n" +
				"a = 70\n" +
				"b = 30\n" +
				"c = 0\n" +
				"c += a\n" +
				"c += b\n" +
				"escrever\n" +
				"c += 30\n" +
				"escrever\n" +
				"";

		CompiladorMaquinaZ compilador = new MeuCompilador();

		Programa programa = compilador.compilar(codigoFonte);

		AmbienteDeExecucao ambiente = new MeuAmbienteDeExecucao();

		programa.executar(ambiente);
	}

}
