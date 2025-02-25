class JogadorRepositorio {
    private List<Jogador> jogadores = new ArrayList<>();

    public void salvar(Jogador jogador) { jogadores.add(jogador); }
    public Jogador buscarPorId(int id) {
        return jogadores.stream().filter(j -> j.getId() == id).findFirst().orElse(null);
    }
    public List<Jogador> listarTodos() { return jogadores; }
}