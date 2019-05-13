package poo.tarefas.tarefa15.implementacoes;

import javax.swing.JOptionPane;

import poo.tarefas.tarefa15.interfaces.AmbienteDeExecucao;
import poo.tarefas.tarefa15.interfaces.Comando;

public class ComandoLeitura implements Comando {

	private String nomeDaVariavel;

	public ComandoLeitura(String nomeDaVariavel) {
		this.nomeDaVariavel = nomeDaVariavel;
	}

	@Override
	public void executar(AmbienteDeExecucao ambiente) {
		String valorString = JOptionPane.showInputDialog("Entre com o valor de " + nomeDaVariavel);
		ambiente.escrever(nomeDaVariavel, Integer.parseInt(valorString));
	}

}
