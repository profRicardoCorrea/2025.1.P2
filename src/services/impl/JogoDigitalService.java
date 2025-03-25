package services.impl;

import java.util.List;

import entities.JogoDigital;
import repositories.IJogoDigitalRepository;
import services.IJogoDigitalService;
 

public class JogoDigitalService implements IJogoDigitalService {
    private final IJogoDigitalRepository repository;
    
    public JogoDigitalService(IJogoDigitalRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public void cadastrarJogo(JogoDigital jogo) {
        if (jogo.getPreco() <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero");
        }
        repository.salvar(jogo);
    }
    
    @Override
    public void removerJogo(Long id) {
        repository.remover(id);
    }
    
    @Override
    public void atualizarJogo(JogoDigital jogo) {
        if (jogo.getPreco() <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero");
        }
        repository.alterar(jogo);
    }
    
    @Override
    public List<JogoDigital> listarJogos() {
        return repository.listar();
    }
    
    @Override
    public List<JogoDigital> buscarPorPlataforma(String plataforma) {
        return repository.buscarPorPlataforma(plataforma);
    }

    @Override
    public JogoDigital buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }

	 
} 