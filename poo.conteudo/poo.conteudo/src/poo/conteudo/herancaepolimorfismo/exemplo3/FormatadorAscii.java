package poo.conteudo.herancaepolimorfismo.exemplo3;

public class FormatadorAscii implements Formatador {

	@Override
	public String formatar(Texto texto) {
		return ""
				+ "========= " + texto.getTitulo() + " =========\n"
				+ "---- Autor: " + texto.getAutor() + " ----\n"
				+ "\n"
				+ texto.getCorpo()
				+ "";
	}

}
