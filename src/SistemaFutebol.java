public class SistemaFutebol {
    public static void main(String[] args) {
        TimeRepositorio timeRepo = new TimeRepositorio();
        CampeonatoRepositorio campeonatoRepo = new CampeonatoRepositorio();
        CampeonatoServico campeonatoServico = new CampeonatoServico(campeonatoRepo, timeRepo);

        Tecnico tecnico1 = new Tecnico(1, "Carlos", 50000);
        Time time1 = new Time(1, "Leões FC", tecnico1);
        timeRepo.salvar(time1);

        Tecnico tecnico2 = new Tecnico(2, "Paulo", 48000);
        Time time2 = new Time(2, "Águias FC", tecnico2);
        timeRepo.salvar(time2);

        Campeonato campeonato = new Campeonato(1, "Campeonato Nacional");
        campeonatoRepo.salvar(campeonato);

        campeonatoServico.adicionarTimeAoCampeonato(1, 1);
        campeonatoServico.adicionarTimeAoCampeonato(1, 2);

        campeonatoServico.registrarPartida(time1, 2, time2, 1);
        campeonatoServico.listarClassificacao(campeonato);
    }
}