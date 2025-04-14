package services.impl;

import java.util.List;
import java.util.ArrayList;

import entities.JogoDigital;
import repositories.IJogoDigitalRepository;
import services.IJogoDigitalService;

public class JogoDigitalService implements IJogoDigitalService {
    private final IJogoDigitalRepository repositoryMemoria;
    private final IJogoDigitalRepository repositoryJDBC;
    
    public JogoDigitalService(IJogoDigitalRepository repositoryMemoria, IJogoDigitalRepository repositoryJDBC) {
        this.repositoryMemoria = repositoryMemoria;
        this.repositoryJDBC = repositoryJDBC;
    }
    
    @Override
    public void cadastrarJogo(JogoDigital jogo) {
        if (jogo.getPreco() <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero");
        }
        
        try {
            // Salva em ambos os repositórios
            repositoryMemoria.salvar(jogo);
            repositoryJDBC.salvar(jogo);
        } catch (Exception e) {
            // Se houver erro, tenta reverter a operação no repositório em memória
            try {
                repositoryMemoria.remover(jogo.getId());
            } catch (Exception ex) {
                throw new RuntimeException("Erro ao reverter operação em memória", ex);
            }
            throw new RuntimeException("Erro ao cadastrar jogo", e);
        }
    }
    
    @Override
    public void removerJogo(Long id) {
        try {
            // Remove de ambos os repositórios
            repositoryMemoria.remover(id);
            repositoryJDBC.remover(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover jogo", e);
        }
    }
    
    @Override
    public void atualizarJogo(JogoDigital jogo) {
        if (jogo.getPreco() <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero");
        }
        
        try {
            // Atualiza em ambos os repositórios
            repositoryMemoria.alterar(jogo);
            repositoryJDBC.alterar(jogo);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar jogo", e);
        }
    }
    
    @Override
    public List<JogoDigital> listarJogos() {
        try {
            // Retorna a lista do banco de dados, que é a fonte primária
            return repositoryJDBC.listar();
        } catch (Exception e) {
            // Em caso de falha no banco, tenta retornar da memória
            return repositoryMemoria.listar();
        }
    }
    
    @Override
    public List<JogoDigital> buscarPorPlataforma(String plataforma) {
        try {
            // Busca do banco de dados
            return repositoryJDBC.buscarPorPlataforma(plataforma);
        } catch (Exception e) {
            // Em caso de falha no banco, busca da memória
            return repositoryMemoria.buscarPorPlataforma(plataforma);
        }
    }

    @Override
    public JogoDigital buscarPorId(Long id) {
        try {
            // Busca do banco de dados
            return repositoryJDBC.buscarPorId(id);
        } catch (Exception e) {
            // Em caso de falha no banco, busca da memória
            return repositoryMemoria.buscarPorId(id);
        }
    }
    
    // Método auxiliar para sincronizar os dados entre os repositórios
    public void sincronizarRepositorios() {
        try {
            List<JogoDigital> jogosJDBC = repositoryJDBC.listar();
            List<JogoDigital> jogosMemoria = repositoryMemoria.listar();
            
            // Adiciona na memória os jogos que estão apenas no banco
            for (JogoDigital jogoJDBC : jogosJDBC) {
                if (!jogosMemoria.stream().anyMatch(j -> j.getId().equals(jogoJDBC.getId()))) {
                    repositoryMemoria.salvar(jogoJDBC);
                }
            }
            
            // Adiciona no banco os jogos que estão apenas na memória
            for (JogoDigital jogoMemoria : jogosMemoria) {
                if (!jogosJDBC.stream().anyMatch(j -> j.getId().equals(jogoMemoria.getId()))) {
                    repositoryJDBC.salvar(jogoMemoria);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao sincronizar repositórios", e);
        }
    }
} 