package poo.tarefas.tarefa08.implementacoes;

import java.util.ArrayList;
import java.util.List;

import poo.tarefas.tarefa08.interfaces.AmbienteDeExecucao;
import poo.tarefas.tarefa08.interfaces.Comando;
import poo.tarefas.tarefa08.interfaces.Programa;

public class MeuPrograma implements Programa {

	private List<Comando> comandos = new ArrayList<>();

	@Override
	public void executar(AmbienteDeExecucao ambiente) {
		for (Comando comando : comandos) {
			comando.executar(ambiente);
		}
	}

	@Override
	public void adicionarComando(Comando c) {
		comandos.add(c);
	}

}
