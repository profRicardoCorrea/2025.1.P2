class CampeonatoServico {
    private CampeonatoRepositorio campeonatoRepo;
    private TimeRepositorio timeRepo;

    public CampeonatoServico(CampeonatoRepositorio campeonatoRepo, TimeRepositorio timeRepo) {
        this.campeonatoRepo = campeonatoRepo;
        this.timeRepo = timeRepo;
    }

    public void adicionarTimeAoCampeonato(int campeonatoId, int timeId) {
        Campeonato campeonato = campeonatoRepo.buscarPorId(campeonatoId);
        Time time = timeRepo.buscarPorId(timeId);
        if (campeonato != null && time != null) {
            campeonato.adicionarTime(time);
            System.out.println("Time " + time.getNome() + " adicionado ao campeonato " + campeonato.getNome());
        }
    }

    public void registrarPartida(Time timeA, int golsA, Time timeB, int golsB) {
        int pontosTimeA = golsA > golsB ? 3 : (golsA == golsB ? 1 : 0);
        int pontosTimeB = golsB > golsA ? 3 : (golsA == golsB ? 1 : 0);
        timeA.atualizarPontuacao(pontosTimeA, golsA - golsB);
        timeB.atualizarPontuacao(pontosTimeB, golsB - golsA);
    }

    public void listarClassificacao(Campeonato campeonato) {
        campeonato.getTimesParticipantes().stream()
            .sorted(Comparator.comparingInt(Time::getPontos).reversed()
                .thenComparingInt(Time::getSaldoGols).reversed())
            .forEach(time -> System.out.println(time.getNome() + " - " + time.getPontos() + " pontos, Saldo: " + time.getSaldoGols()));
    }
}