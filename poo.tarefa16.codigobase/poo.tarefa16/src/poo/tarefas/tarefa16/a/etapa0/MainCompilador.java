package poo.tarefas.tarefa16.a.etapa0;

import poo.tarefas.tarefa15.implementacoes.MeuAmbienteDeExecucao;
import poo.tarefas.tarefa15.implementacoes.CompiladorMaquinaV;
import poo.tarefas.tarefa15.interfaces.AmbienteDeExecucao;
import poo.tarefas.tarefa15.interfaces.Compilador;
import poo.tarefas.tarefa15.interfaces.Programa;

public class MainCompilador {

	public static void main(String[] args) {
		String codigoFonte = "" +
				""
				+ "ler a        \n"
				+ "a += 10      \n"
				+ "b = 0        \n"
				+ "c = 5        \n"
				+ "b += c       \n"
				+ "c = 0        \n"
				+ "c += a       \n"
				+ "c += b       \n"
				+ "repita 10    \n"
				+ "escrever     \n"
				+ "";

		Compilador compilador = new CompiladorMaquinaV();

		Programa programa = compilador.compilar(codigoFonte);

		AmbienteDeExecucao ambiente = new MeuAmbienteDeExecucao();

		programa.executar(ambiente);
	}

}
