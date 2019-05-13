package poo.tarefas.tarefa08.implementacoes;

import poo.tarefas.tarefa08.interfaces.AmbienteDeExecucao;
import poo.tarefas.tarefa08.interfaces.Comando;

public class ComandoSomaDeVariavel implements Comando {

	private String nomeDaVariavel;

	public ComandoSomaDeVariavel(String nomeDaVariavel) {
		this.nomeDaVariavel = nomeDaVariavel;
	}

	@Override
	public void executar(AmbienteDeExecucao ambiente) {
		ambiente.escrever("c", ambiente.ler("c") + ambiente.ler(nomeDaVariavel));
	}

}
