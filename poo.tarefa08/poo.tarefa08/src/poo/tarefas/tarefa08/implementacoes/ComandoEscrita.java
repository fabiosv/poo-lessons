package poo.tarefas.tarefa08.implementacoes;

import poo.tarefas.tarefa08.interfaces.AmbienteDeExecucao;
import poo.tarefas.tarefa08.interfaces.Comando;

public class ComandoEscrita implements Comando {

	@Override
	public void executar(AmbienteDeExecucao ambiente) {
		System.out.println(ambiente.ler("c"));
	}

}
