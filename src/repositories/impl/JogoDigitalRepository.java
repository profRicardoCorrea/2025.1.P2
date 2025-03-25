package repositories.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entities.JogoDigital;
import repositories.IJogoDigitalRepository;

public class JogoDigitalRepository implements IJogoDigitalRepository {
    private List<JogoDigital> jogos = new ArrayList<>();
    
    @Override
    public void salvar(JogoDigital jogo) {
        jogos.add(jogo);
    }
    
    @Override
    public void remover(Long id) {
        jogos.removeIf(jogo -> jogo.getId().equals(id));
    }
    
    @Override
    public void alterar(JogoDigital jogoAtualizado) {
        for (int i = 0; i < jogos.size(); i++) {
            if (jogos.get(i).getId().equals(jogoAtualizado.getId())) {
                jogos.set(i, jogoAtualizado);
                break;
            }
        }
    }
    
    @Override
    public List<JogoDigital> listar() {
        return new ArrayList<>(jogos);
    }
    
    @Override
    public JogoDigital buscarPorId(Long id) {
        return jogos.stream()
                   .filter(jogo -> jogo.getId().equals(id))
                   .findFirst()
                   .orElse(null);
    }
    
    @Override
    public List<JogoDigital> buscarPorPlataforma(String plataforma) {
        return jogos.stream()
                   .filter(jogo -> jogo.getPlataforma().equalsIgnoreCase(plataforma))
                   .collect(Collectors.toList());
    }

	 

	 
} 