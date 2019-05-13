package poo.tarefas.tarefa15.implementacoes;

import poo.tarefas.tarefa15.interfaces.AmbienteDeExecucao;
import poo.tarefas.tarefa15.interfaces.Expressao;

public class Variavel implements Expressao {

	private String nome;

	public Variavel(String nome) {
		this.nome = nome;
	}

	@Override
	public int avaliar(AmbienteDeExecucao ambiente) {
		return ambiente.ler(nome);
	}

}
