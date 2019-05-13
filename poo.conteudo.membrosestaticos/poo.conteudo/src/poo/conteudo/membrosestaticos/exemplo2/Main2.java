package poo.conteudo.membrosestaticos.exemplo2;

public class Main2 {

	public static void main(String[] args) {
		// Acesso estatico
		Exemplo2.campoEstatico = 10;
		System.out.println(Exemplo2.campoEstatico);


		// Instanciacao de objeto
		Exemplo2 objeto = new Exemplo2();

		// Acesso de instancia
		objeto.campoDeInstancia = 20;
		System.out.println(objeto.campoDeInstancia);
	}

}
