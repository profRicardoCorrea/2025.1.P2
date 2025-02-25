import java.time.LocalDate;
import java.util.*;
class Time {
    private int id;
    private String nome;
    private Tecnico tecnico;
    private List<Jogador> jogadores = new ArrayList<>();
    private int pontos;
    private int saldoGols;

    public Time(int id, String nome, Tecnico tecnico) {
        this.id = id;
        this.nome = nome;
        this.tecnico = tecnico;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public List<Jogador> getJogadores() { return jogadores; }
    public int getPontos() { return pontos; }
    public int getSaldoGols() { return saldoGols; }

    public void adicionarJogador(Jogador jogador) { jogadores.add(jogador); }
    public void atualizarPontuacao(int pontos, int saldoGols) {
        this.pontos += pontos;
        this.saldoGols += saldoGols;
    }
}