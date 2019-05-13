package poo.conteudo.herancaepolimorfismo.exemplo0;

public class Programa0 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		PessoaFisica pf1 = new PessoaFisica();
		pf1.nome = "Joaquim Jose da Silva Xavier";

		PessoaJuridica pj1 = new PessoaJuridica();
		pj1.nome = "Empresas Associadas S/A";

		// Nao tem como referenciar pessoas em geral

		PessoaFisica umaPessoa = pf1;	// pode
//		umaPessoa = pj1;				// nao pode

		PessoaJuridica outraPessoa = pj1;	// pode
//		outraPessoa = pf1;					// nao pode

	}

}
