package entities;
public class JogoDigital extends AbstractGame {
    private String plataforma;
    private double tamanhoGB;
    
    public JogoDigital() {}
    
    public JogoDigital(Long id, String nome, double preco, String desenvolvedora, 
                       String plataforma, double tamanhoGB) {
        super(id, nome, preco, desenvolvedora);
        this.plataforma = plataforma;
        this.tamanhoGB = tamanhoGB;
    }
    
    @Override
    public String getTipoJogo() {
        return "Digital";
    }

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public double getTamanhoGB() {
		return tamanhoGB;
	}

	public void setTamanhoGB(double tamanhoGB) {
		this.tamanhoGB = tamanhoGB;
	}
    
    // Getters e Setters
    
    @Override
    public String toString() {
        return super.toString() + 
               ", Plataforma: " + plataforma + 
               ", Tamanho: " + tamanhoGB + "GB";
    }
} 