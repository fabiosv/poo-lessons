package poo.tarefas.tarefa15.implementacoes;

import poo.tarefas.tarefa15.interfaces.Comando;

public class FabricaDeComandos {

	private static final Comando COMANDO_ESCRITA = new ComandoEscrita();
	private static final Comando COMANDO_COMENTARIO = new ComandoComentario();

	public static Comando comandoEscrita() {
		return COMANDO_ESCRITA;
	}

	public static Comando comentario() {
		return COMANDO_COMENTARIO;
	}

	public static Comando comandoAtribuicao(String nomeDaVariavel, int valor) {
		return new ComandoAtribuicao(nomeDaVariavel, valor);
	}

	public static Comando comandoSomaDeVariavel(String valorAEsquerda, String valorADireita) {
		return new ComandoSoma(valorAEsquerda, new Variavel(valorADireita));
	}

	public static Comando comandoSomaDeValorInteiro(String nomeDaVariavel, int valor) {
		return new ComandoSoma(nomeDaVariavel, new Constante(valor));
	}

	public static Comando comandoLeitura(String nomeDaVariavel) {
		return new ComandoLeitura(nomeDaVariavel);
	}

	public static Comando comandoRepeticao(int numeroDeVezes, Comando aSerRepetido) {
		return new ComandoRepeticao(numeroDeVezes, aSerRepetido);
	}

}
