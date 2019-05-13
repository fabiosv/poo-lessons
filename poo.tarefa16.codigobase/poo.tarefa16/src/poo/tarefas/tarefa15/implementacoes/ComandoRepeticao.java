package poo.tarefas.tarefa15.implementacoes;

import poo.tarefas.tarefa15.interfaces.AmbienteDeExecucao;
import poo.tarefas.tarefa15.interfaces.Comando;

public class ComandoRepeticao implements Comando {

	private int numeroDeVezes;
	private Comando aSerRepetido;

	public ComandoRepeticao(int numeroDeVezes, Comando aSerRepetido) {
		this.numeroDeVezes = numeroDeVezes;
		this.aSerRepetido = aSerRepetido;
	}

	@Override
	public void executar(AmbienteDeExecucao ambiente) {
		for (int i = 0; i < numeroDeVezes; ++i) {
			aSerRepetido.executar(ambiente);
		}
	}

}
