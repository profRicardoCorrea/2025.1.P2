package responsabilidade;

public class PessoaFisica extends Pessoa{	 
	 
	private String cpf;
	private String email;
	private String endereco; 	  

	public PessoaFisica(String nome, int idade, String cpf, String email, String endereco) {
		super(nome, idade);
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
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

	@Override
	public void apresentacao() {
		System.out.println("Nome: " + getNome() + ", Idade: " + getIdade()+", CPF: "+getCpf());
	}

	@Override
	public void exibirId() {
		System.out.println("ID: " + getId());
	}

	 

	 

	 
}
