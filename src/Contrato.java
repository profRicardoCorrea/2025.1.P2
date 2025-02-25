import java.time.LocalDate;
import java.util.*;
class Contrato {
    private int id;
    private Jogador jogador;
    private Time time;
    private double salarioMensal;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Contrato(int id, Jogador jogador, Time time, double salarioMensal, LocalDate dataInicio, LocalDate dataFim) {
        this.id = id;
        this.jogador = jogador;
        this.time = time;
        this.salarioMensal = salarioMensal;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public int getId() { return id; }
    public Jogador getJogador() { return jogador; }
    public Time getTime() { return time; }
    public double getSalarioMensal() { return salarioMensal; }
}