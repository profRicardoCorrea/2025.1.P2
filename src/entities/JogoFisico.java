package entities;
public class JogoFisico extends AbstractGame {
    private String midia;
    private boolean temManual;
    
    public JogoFisico() {}
    
    public JogoFisico(Long id, String nome, double preco, String desenvolvedora,
                      String midia, boolean temManual) {
        super(id, nome, preco, desenvolvedora);
        this.midia = midia;
        this.temManual = temManual;
    }
    
    @Override
    public String getTipoJogo() {
        return "Físico";
    }

	public String getMidia() {
		return midia;
	}

	public void setMidia(String midia) {
		this.midia = midia;
	}

	public boolean isTemManual() {
		return temManual;
	}

	public void setTemManual(boolean temManual) {
		this.temManual = temManual;
	}
    
    // Getters e Setters
    
    @Override
    public String toString() {
        return super.toString() + 
               ", Mídia: " + midia + 
               ", Tem Manual: " + (temManual ? "Sim" : "Não");
    }
} 