package poo.tarefas.tarefa15.implementacoes;

import poo.tarefas.tarefa15.interfaces.AmbienteDeExecucao;
import poo.tarefas.tarefa15.interfaces.Comando;
import poo.tarefas.tarefa15.interfaces.Expressao;

public class ComandoSoma implements Comando {

	private String nomeDaVariavel;
	private Expressao expressao;

	public ComandoSoma(String nomeDaVariavel, Expressao expressao) {
		this.nomeDaVariavel = nomeDaVariavel;
		this.expressao = expressao;
	}

	@Override
	public void executar(AmbienteDeExecucao ambiente) {
		ambiente.escrever(nomeDaVariavel, ambiente.ler(nomeDaVariavel) + expressao.avaliar(ambiente));
	}

}
