package poo.conteudo.herancaepolimorfismo.exemplo3;

public class FormatadorJson implements Formatador {

	@Override
	public String formatar(Texto texto) {
		return ""
				+ "{\n"
				+ "\ttitulo: \"" + texto.getTitulo() + "\"\n"
				+ "\tautor: \"" + texto.getAutor() + "\"\n"
				+ "\tcorpo: \"" + texto.getCorpo() + "\"\n"
				+ "}\n"
				+ "";
	}

}
