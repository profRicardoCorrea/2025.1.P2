package responsabilidade;

import java.util.ArrayList;

//Classe de repositório - responsável pelo armazenamento
public class PessoaFisicaRepository {
	private Pessoa[] pessoas;
	private ArrayList<PessoaFisica> pessoasL=new ArrayList();
	private int totalPessoas;

	public PessoaFisicaRepository() {
		this.pessoas = new PessoaFisica[100];
		this.totalPessoas = 0;
	}

	public void salvar(PessoaFisica pessoa) {
		//Array
		pessoas[totalPessoas] = pessoa;
		totalPessoas++;
		//ArrayList
		pessoasL.add(pessoa);
		
	}

	public Pessoa buscarPorId(int id) {
		for (int i = 0; i < totalPessoas; i++) {
			if (pessoas[i].getId() == id) {
				return pessoas[i];
			}
		}
		return null;
	}

	public void atualizar(PessoaFisica pessoa) {
		for (int i = 0; i < totalPessoas; i++) {
			if (pessoas[i].getId() == pessoa.getId()) {
				pessoas[i] = pessoa;
				break;
			}
		}
	}

	public int getProximoId() {
		return totalPessoas + 1;
	}
}
