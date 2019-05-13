package poo.tarefa05;

public class MainTarefa05 {

	public static void main(String[] args) {
		Marcador preto    = new Marcador(Cor.PRETA,    2);
		Marcador azul     = new Marcador(Cor.AZUL,     3);
		Marcador vermelho = new Marcador(Cor.VERMELHA, 1);

		Marcador atual;

		atual = vermelho;
		atual.escrever("A");
		atual.escrever("B");

		atual = preto;
		atual.escrever("C");
		atual.destampar();

		atual = azul;
		atual.destampar();

		atual = preto;
		atual.escrever("D");

		atual = azul;
		atual.escrever("E");
		atual.escrever("F");

		vermelho.escrever("G");
		preto.escrever("H");
		preto.escrever("I");
	}

}
