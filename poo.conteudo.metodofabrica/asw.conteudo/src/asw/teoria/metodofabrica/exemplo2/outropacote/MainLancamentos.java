package asw.teoria.metodofabrica.exemplo2.outropacote;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import asw.teoria.metodofabrica.exemplo2.lancamentos.Lancamento;

public class MainLancamentos {

	public static void main(String[] args) {
		List<Lancamento> lancamentos = new ArrayList<>();

		// Laco infinito
		for (;;) {
			String stringLida = JOptionPane.showInputDialog(
					"Digite um valor de lancamento");

			if (stringLida == null) break;

			int valor = Integer.parseInt(stringLida);

			Lancamento lancamento = Lancamento.criar(valor);
			if (valor > 0) {
				System.out.println("Creditando " + lancamento.getValorAbsoluto());
			} else {
				System.out.println("Debitando " + lancamento.getValorAbsoluto());
			}
			lancamentos.add(lancamento);
		}

		int saldo = 0;
		for (Lancamento lancamento : lancamentos) {
			saldo += lancamento.getValorFinanceiro();
		}

		System.out.println("Saldo: " + saldo);
	}

}
