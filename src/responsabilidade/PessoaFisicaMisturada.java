package responsabilidade;

public class PessoaFisicaMisturada {
	private int id;
	private String nome;
	private int idade;
	private String cpf;
	private String email;
	private String endereco; 
	private static PessoaFisicaMisturada[] pessoas = new PessoaFisica[100];
	private static int totalPessoas = 0;	 
 
	public PessoaFisicaMisturada(int id, String nome, int idade, String cpf, String email, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}



	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public static PessoaFisicaMisturada[] getPessoas() {
		return pessoas;
	}

	public static void setPessoas(PessoaFisicaMisturada[] pessoas) {
		PessoaFisicaMisturada.pessoas = pessoas;
	}

	public static int getTotalPessoas() {
		return totalPessoas;
	}



	public static void setTotalPessoas(int totalPessoas) {
		PessoaFisicaMisturada.totalPessoas = totalPessoas;
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

	public static PessoaFisicaMisturada buscarPorId(int id) {
		for (int i = 0; i < totalPessoas; i++) {
			if (pessoas[i].id == id) {
				return pessoas[i];
			}
		}
		return null;
	}
}