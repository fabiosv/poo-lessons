package poo.conteudo.herancaepolimorfismo.exemplo1;

public class Programa1A {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// E' possivel fazer ainda do jeito antigo:

		PessoaFisica pf1 = new PessoaFisica();
		pf1.nome = "Joaquim Jose da Silva Xavier";

		PessoaJuridica pj1 = new PessoaJuridica();
		pj1.nome = "Empresas Associadas S/A";

		// E tambem e' possivel referenciar qualquer pessoa
		// usando uma variavel do tipo Pessoa,
		// sendo fisica ou juridica

		Pessoa umaPessoa = pf1;			// pode
		umaPessoa = pj1;				// pode, tambem

		Pessoa outraPessoa = pj1;	// pode
		outraPessoa = pf1;			// pode, tambem

	}

}
