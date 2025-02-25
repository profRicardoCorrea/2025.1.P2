import java.time.LocalDate;
import java.util.*;
class TimeRepositorio {
    private List<Time> times = new ArrayList<>();

    public void salvar(Time time) { times.add(time); }
    public List<Time> listarTodos() { return times; }
    public Time buscarPorId(int id) {
        return times.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }
}