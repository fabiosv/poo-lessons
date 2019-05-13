package poo.conteudo.herancaepolimorfismo.exemplo3;

public class FormatadorHtml implements Formatador {

	@Override
	public String formatar(Texto texto) {
		return ""
				+ "<html>\n"
				+ "<body>\n"
				+ "<h1>" + texto.getTitulo() + "</h1>\n"
				+ "<h2>" + texto.getAutor() + "</h2>\n"
				+ "<p>" + texto.getCorpo() + "</p>\n"
				+ "</body>\n"
				+ "</html>\n"
				+ "";
	}

}
