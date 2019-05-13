package asw.teoria.metodofabrica.exemplo2.lancamentos;

class Credito extends Lancamento {

	private final int valorAbsoluto;

	public Credito(int valorAbsoluto) {
		this.valorAbsoluto = valorAbsoluto;
	}

	@Override
	public int getValorFinanceiro() {
		return valorAbsoluto;
	}

	@Override
	public int getValorAbsoluto() {
		return valorAbsoluto;
	}

}
