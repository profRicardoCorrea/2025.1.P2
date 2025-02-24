package responsabilidade;

//Classe de serviço - contém regras de negócio
public class PessoaFisicaService {
	private PessoaFisicaRepository repository;

	public PessoaFisicaService(PessoaFisicaRepository repository) {
		this.repository = repository;
	}

	public boolean validarIdade(Pessoa pessoa) {
		return pessoa.getIdade() >= 18;
	}

	public void fazerAniversario(PessoaFisica pessoa) {
		pessoa.setIdade(pessoa.getIdade() + 1);
		repository.atualizar(pessoa);
	}

	public void cadastrarPessoa(PessoaFisica pessoa) {
		pessoa.setId(repository.getProximoId());
		repository.salvar(pessoa);
	}
}
