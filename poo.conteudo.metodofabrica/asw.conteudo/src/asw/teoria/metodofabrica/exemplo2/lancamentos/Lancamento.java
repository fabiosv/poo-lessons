package asw.teoria.metodofabrica.exemplo2.lancamentos;

public abstract class Lancamento {

	public abstract int getValorFinanceiro();

	public abstract int getValorAbsoluto();

	public static Lancamento criar(int valorFinanceiro) {
		if (valorFinanceiro == 0) {
			throw new IllegalArgumentException("Zero nao e' permitido");
		}

		if (valorFinanceiro > 0) return new Credito(valorFinanceiro);
		else return new Debito(-valorFinanceiro);
	}

}
