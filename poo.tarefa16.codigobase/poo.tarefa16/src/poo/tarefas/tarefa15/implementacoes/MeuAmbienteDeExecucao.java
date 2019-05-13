package poo.tarefas.tarefa15.implementacoes;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import poo.tarefas.tarefa15.interfaces.AmbienteDeExecucao;

public class MeuAmbienteDeExecucao implements AmbienteDeExecucao {

	private Map<String, Integer> mapa = new HashMap<>();

	public MeuAmbienteDeExecucao() {
		Random r = new Random();
		mapa.put("a", r.nextInt());
		mapa.put("b", r.nextInt());
		mapa.put("c", r.nextInt());
	}

	@Override
	public void escrever(String nomeDaVariavel, int valor) {
		mapa.put(nomeDaVariavel, valor);
	}

	@Override
	public int ler(String nomeDaVariavel) {
		return mapa.get(nomeDaVariavel);
	}

}
