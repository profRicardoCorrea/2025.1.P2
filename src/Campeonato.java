import java.time.LocalDate;
import java.util.*;
class Campeonato {
    private int id;
    private String nome;
    private List<Time> timesParticipantes = new ArrayList<>();

    public Campeonato(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public List<Time> getTimesParticipantes() { return timesParticipantes; }

    public void adicionarTime(Time time) { timesParticipantes.add(time); }
}