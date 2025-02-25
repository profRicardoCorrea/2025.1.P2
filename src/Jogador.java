class Jogador {
    private int id;
    private String nome;
    private String posicao;
    private double salario;
    private Contrato contrato;

    public Jogador(int id, String nome, String posicao, double salario) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        this.salario = salario;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getPosicao() { return posicao; }
    public double getSalario() { return salario; }
    public Contrato getContrato() { return contrato; }
    public void setContrato(Contrato contrato) { this.contrato = contrato; }
}
