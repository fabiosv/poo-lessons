package poo.conteudo.herancaepolimorfismo.exemplo3;

public class FormatadorEspacos implements Formatador {

	private final int quantidadeEspacos;

	public FormatadorEspacos(int quantidadeEspacos) {
		this.quantidadeEspacos = quantidadeEspacos;
	}

	@Override
	public String formatar(Texto texto) {
		return String.format(""
				+ "Titulo: %" + quantidadeEspacos + "s\n"
				+ "Autor:  %" + quantidadeEspacos + "s\n"
				+ "Corpo:  %" + quantidadeEspacos + "s\n"
				+ "",
				texto.getTitulo(), texto.getAutor(), texto.getCorpo());
	}

}
