package responsabilidade;

//Classe de entidade - apenas dados e comportamentos básicos
public class Pessoa implements IPessoa {
	private int id;
	private String nome;
	private int idade;

	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	// Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public void apresentacao() {
		System.out.println("Nome: " + nome + ", Idade: " + idade);
	}

	@Override
	public void exibirId() {
		System.out.println("ID: " + id);
	}
}