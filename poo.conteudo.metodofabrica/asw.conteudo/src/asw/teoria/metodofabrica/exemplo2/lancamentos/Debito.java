package asw.teoria.metodofabrica.exemplo2.lancamentos;

class Debito extends Lancamento {

	private final int valorAbsoluto;

	public Debito(int valorAbsoluto) {
		this.valorAbsoluto = valorAbsoluto;
	}

	@Override
	public int getValorFinanceiro() {
		return -valorAbsoluto;
	}

	@Override
	public int getValorAbsoluto() {
		return valorAbsoluto;
	}

}
