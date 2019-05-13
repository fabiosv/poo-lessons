package poo.provas.p2.armazenamento;

public class ResmaDePapel implements Armazenavel {
	
	int espacoOcupado;
	
	public ResmaDePapel() {
		this.espacoOcupado = 10;
	}
	
	public ResmaDePapel(int quantidadeDeFolhas) {
		this.espacoOcupado = calcularEspacoOcupado(quantidadeDeFolhas);
		
	}
	
	private int calcularEspacoOcupado(int quantidadeDeFolhas){
		return quantidadeDeFolhas / 10;
	}
	
	@Override
	public int espacoQueOcupa() {
		return espacoOcupado;
	}

}
