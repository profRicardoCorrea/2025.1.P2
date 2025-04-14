package services;

import java.util.List;

import entities.JogoDigital;

public interface IJogoDigitalService {
    void cadastrarJogo(JogoDigital jogo);
    void removerJogo(Long id);
    void atualizarJogo(JogoDigital jogo);
    List<JogoDigital> listarJogos();
    List<JogoDigital> buscarPorPlataforma(String plataforma);
    JogoDigital buscarPorId(Long id);
	void sincronizarRepositorios();
} 