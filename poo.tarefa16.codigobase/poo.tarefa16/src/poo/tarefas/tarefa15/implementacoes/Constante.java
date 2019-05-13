package poo.tarefas.tarefa15.implementacoes;

import poo.tarefas.tarefa15.interfaces.AmbienteDeExecucao;
import poo.tarefas.tarefa15.interfaces.Expressao;

public class Constante implements Expressao {

	private int valor;

	public Constante(int valor) {
		this.valor = valor;
	}

	@Override
	public int avaliar(AmbienteDeExecucao ambiente) {
		return valor;
	}

}
