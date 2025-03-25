package repositories.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entities.JogoFisico;
import repositories.IJogoFisicoRepository;

public class JogoFisicoRepository implements IJogoFisicoRepository {
    private List<JogoFisico> jogos = new ArrayList<>();
    
    @Override
    public void salvar(JogoFisico jogo) {
        jogos.add(jogo);
    }
    
    @Override
    public void remover(Long id) {
        jogos.removeIf(jogo -> jogo.getId().equals(id));
    }
    
    @Override
    public void alterar(JogoFisico jogoAtualizado) {
        for (int i = 0; i < jogos.size(); i++) {
            if (jogos.get(i).getId().equals(jogoAtualizado.getId())) {
                jogos.set(i, jogoAtualizado);
                break;
            }
        }
    }
    
    @Override
    public List<JogoFisico> listar() {
        return new ArrayList<>(jogos);
    }
    
    @Override
    public JogoFisico buscarPorId(Long id) {
        return jogos.stream()
                   .filter(jogo -> jogo.getId().equals(id))
                   .findFirst()
                   .orElse(null);
    }
    
    @Override
    public List<JogoFisico> buscarPorMidia(String midia) {
        return jogos.stream()
                   .filter(jogo -> jogo.getMidia().equalsIgnoreCase(midia))
                   .collect(Collectors.toList());
    }
} 