package responsabilidade;

//Classe de repositório - responsável pelo armazenamento
public class PessoaRepository {
	private Pessoa[] pessoas;
	private int totalPessoas;

	public PessoaRepository() {
		this.pessoas = new Pessoa[100];
		this.totalPessoas = 0;
	}

	public void salvar(Pessoa pessoa) {
		pessoas[totalPessoas] = pessoa;
		totalPessoas++;
	}

	public Pessoa buscarPorId(int id) {
		for (int i = 0; i < totalPessoas; i++) {
			if (pessoas[i].getId() == id) {
				return pessoas[i];
			}
		}
		return null;
	}

	public void atualizar(Pessoa pessoa) {
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
