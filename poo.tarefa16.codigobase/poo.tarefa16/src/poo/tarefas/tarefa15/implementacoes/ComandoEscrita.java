package poo.tarefas.tarefa15.implementacoes;

import poo.tarefas.tarefa15.interfaces.AmbienteDeExecucao;
import poo.tarefas.tarefa15.interfaces.Comando;

public class ComandoEscrita implements Comando {

	@Override
	public void executar(AmbienteDeExecucao ambiente) {
		System.out.println(ambiente.ler("c"));
	}

}
