package poo.conteudo.herancaepolimorfismo.exemplo1;

import java.util.Date;

public class PessoaFisica extends Pessoa {

	// Campos exclusivos de PessoaFisica
	long cpf;
	Date dataNascimento;

	// Os outros campos são herdados da classe Pessoa
}
