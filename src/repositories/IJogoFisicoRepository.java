package repositories;

import java.util.List;

import entities.JogoFisico;

public interface IJogoFisicoRepository extends IRepository<JogoFisico> {
    List<JogoFisico> buscarPorMidia(String midia);
} 