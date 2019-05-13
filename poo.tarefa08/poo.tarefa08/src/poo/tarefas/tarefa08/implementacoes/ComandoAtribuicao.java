package poo.tarefas.tarefa08.implementacoes;

import poo.tarefas.tarefa08.interfaces.AmbienteDeExecucao;
import poo.tarefas.tarefa08.interfaces.Comando;

public class ComandoAtribuicao implements Comando {

	private String nomeDaVariavel;
	private int valorASerAtribuido;

	public ComandoAtribuicao(String nomeDaVariavel, int valorASerAtribuido) {
		this.nomeDaVariavel = nomeDaVariavel;
		this.valorASerAtribuido = valorASerAtribuido;
	}

	@Override
	public void executar(AmbienteDeExecucao ambiente) {
		ambiente.escrever(nomeDaVariavel, valorASerAtribuido);
	}

}
