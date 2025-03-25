package entities;
public abstract class AbstractGame {
    private Long id;
    private String nome;
    private double preco;
    private String desenvolvedora;
    
    public AbstractGame() {}
    
    public AbstractGame(Long id, String nome, double preco, String desenvolvedora) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.desenvolvedora = desenvolvedora;
    }
    
    // Getters e Setters
    
    public abstract String getTipoJogo();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDesenvolvedora() {
		return desenvolvedora;
	}

	public void setDesenvolvedora(String desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}
    
    @Override
    public String toString() {
        return "ID: " + id + 
               ", Nome: " + nome + 
               ", Preço: " + preco + 
               ", Desenvolvedora: " + desenvolvedora;
    }
} 