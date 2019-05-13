package poo.tarefas.tarefa15.implementacoes;

import java.util.ArrayList;
import java.util.List;

import poo.tarefas.tarefa15.interfaces.AmbienteDeExecucao;
import poo.tarefas.tarefa15.interfaces.Comando;
import poo.tarefas.tarefa15.interfaces.Programa;

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
