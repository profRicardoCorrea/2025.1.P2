package responsabilidade;

public class PessoaFisica {
	private int id;
	private String nome;
	private int idade;
	private String cpf;
	private String email;
	private String endereco;

	private static PessoaFisica[] pessoas = new PessoaFisica[100];
	private static int totalPessoas = 0;

	public PessoaFisica(String nome, int idade, String cpf, String email, String endereco) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;

	}

	public PessoaFisica() {
	}

	public void setNome(String novoNome) {
		this.nome = novoNome;

	}

	public String getNome() {
		return this.nome;

	}

	public void setIdade(int novoIdade) {
		this.idade = novoIdade;

	}

	public int getIdade() {
		return this.idade;

	}

	public void setCpf(String novoCpf) {
		this.cpf = novoCpf;

	}

	public String getCpf() {
		return this.cpf;

	}

	public void setEmail(String novoEmail) {
		this.email = novoEmail;

	}

	public String getEmail() {
		return this.email;

	}

	public void setEndereco(String novoEndereco) {
		this.endereco = novoEndereco;

	}

	public String getEndereco() {
		return this.endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void apresentacao() {
		System.out.println("Nome: " + getNome() + ", Idade: " + getIdade());
	}

	public void exibirId() {
		System.out.println("ID: " + id);
	}

	// Regras de negócio misturadas na entidade
	public boolean validarCpf() {
		return getCpf().length() == 11;
	}

	public boolean validarIdade() {
		return getIdade() >= 18;
	}

	// Métodos de repositório misturados na entidade
	public void salvar() {
		pessoas[totalPessoas] = this;
		totalPessoas++;
	}

	public static PessoaFisica buscarPorId(int id) {
		for (int i = 0; i < totalPessoas; i++) {
			if (pessoas[i].id == id) {
				return pessoas[i];
			}
		}
		return null;
	}
}
