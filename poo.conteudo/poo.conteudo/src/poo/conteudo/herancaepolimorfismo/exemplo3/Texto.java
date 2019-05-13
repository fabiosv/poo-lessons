package poo.conteudo.herancaepolimorfismo.exemplo3;

public class Texto {

	private final String titulo;
	private final String autor;
	private final String corpo;

	public Texto(String titulo, String autor, String corpo) {
		this.titulo = titulo;
		this.autor = autor;
		this.corpo = corpo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getCorpo() {
		return corpo;
	}

}
