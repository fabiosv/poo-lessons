package poo.conteudo.herancaepolimorfismo.exemplo4;

import poo.conteudo.herancaepolimorfismo.exemplo3.Formatador;
import poo.conteudo.herancaepolimorfismo.exemplo3.Texto;

// Mesmo efeito que o exemplo anterior, agora usando enum.
// Isso evita ter que criar diversas classes.
public enum FormatadorFixo implements Formatador {

	ASCII {
		@Override
		public String formatar(Texto texto) {
			return ""
					+ "========= " + texto.getTitulo() + " =========\n"
					+ "---- Autor: " + texto.getAutor() + " ----\n"
					+ "\n"
					+ texto.getCorpo()
					+ "";
		}
	},

	HTML {
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
	},

	JSON {
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
	},

	XML {
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

}
