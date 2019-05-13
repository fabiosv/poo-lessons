package poo.conteudo.herancaepolimorfismo.exemplo1;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Programa1B {

	public static void main(String[] args) {
		List<Pessoa> lista = lerPessoas();

		exibirPessoas(lista);
	}

	public static List<Pessoa> lerPessoas() {
		List<Pessoa> pessoas = new ArrayList<>();

		String opcao;
		for (;;) {
			opcao = JOptionPane.showInputDialog("Digite: fisica ou juridica.");

			if (opcao == null) break;

			Pessoa nova;

			if (opcao.equals("fisica")) nova = new PessoaFisica();
			else nova = new PessoaJuridica();

			nova.nome = JOptionPane.showInputDialog("Digite nome");
			nova.endereco = JOptionPane.showInputDialog("Digite endereco");
			// ...

			pessoas.add(nova);
		}

		return pessoas;
	}

	public static void exibirPessoas(List<Pessoa> pessoas) {
		System.out.println("*** LISTAGEM DE PESSOAS *** FORMULARIO V1.0 ***");
		for (Pessoa pessoa : pessoas) {
			System.out.printf("\t%10s %20s\n", "Nome:", pessoa.nome);
			System.out.printf("\t%10s %20s\n", "Endereco:", pessoa.endereco);
		}
		System.out.println("***********************************************");
	}

}
