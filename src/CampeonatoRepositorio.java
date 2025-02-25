class CampeonatoRepositorio {
    private List<Campeonato> campeonatos = new ArrayList<>();

    public void salvar(Campeonato campeonato) { campeonatos.add(campeonato); }
    public Campeonato buscarPorId(int id) {
        return campeonatos.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }
    public List<Campeonato> listarTodos() { return campeonatos; }
}