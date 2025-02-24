package responsabilidade;

//Classe de serviço - contém regras de negócio
public class PessoaService {
	private PessoaRepository repository;

	public PessoaService(PessoaRepository repository) {
		this.repository = repository;
	}

	public boolean validarIdade(Pessoa pessoa) {
		return pessoa.getIdade() >= 18;
	}

	public void fazerAniversario(Pessoa pessoa) {
		pessoa.setIdade(pessoa.getIdade() + 1);
		repository.atualizar(pessoa);
	}

	public void cadastrarPessoa(Pessoa pessoa) {
		pessoa.setId(repository.getProximoId());
		repository.salvar(pessoa);
	}
}
