package poo.conteudo.herancaepolimorfismo.exemplo3;

public class FormatadorXml implements Formatador {

	@Override
	public String formatar(Texto texto) {
		return ""
				+ "<texto>\n"
				+ "\t<titulo>" + texto.getTitulo() + "</titulo>\n"
				+ "\t<autor>" + texto.getAutor() + "</autor>\n"
				+ "\t<corpo>" + texto.getCorpo() + "</corpo>\n"
				+ "</texto>"
				+ "";
	}

}
