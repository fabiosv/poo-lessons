package poo.tarefas.tarefa08.implementacoes;

import poo.tarefas.tarefa08.interfaces.AmbienteDeExecucao;
import poo.tarefas.tarefa08.interfaces.Comando;

public class ComandoSomaDeValorInteiro implements Comando {

	private int valorInteiro;

	public ComandoSomaDeValorInteiro(int valorInteiro) {
		this.valorInteiro = valorInteiro;
	}

	@Override
	public void executar(AmbienteDeExecucao ambiente) {
		ambiente.escrever("c", ambiente.ler("c") + valorInteiro);
	}

}
