package br.com.antirracismo.entidades;

public class PoliticaAntirracista {
    private String nome;
    private String descricao;
    private int anoImplementacao;
    private String efetividade;

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public int getAnoImplementacao() { return anoImplementacao; }
    public void setAnoImplementacao(int anoImplementacao) { this.anoImplementacao = anoImplementacao; }
    public String getEfetividade() { return efetividade; }
    public void setEfetividade(String efetividade) { this.efetividade = efetividade; }
}
