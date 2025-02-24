package br.com.antirracismo.entidades;

import java.util.ArrayList;
import java.util.List;

// Entidade Empresa
public class Empresa {
    private String nome;
    private String endereco;
    private int anoFundacao;
    private String tipo;

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public int getAnoFundacao() { return anoFundacao; }
    public void setAnoFundacao(int anoFundacao) { this.anoFundacao = anoFundacao; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}