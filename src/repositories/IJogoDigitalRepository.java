package repositories; 
import java.util.List;

import entities.JogoDigital;

public interface IJogoDigitalRepository extends IRepository<JogoDigital> {
    List<JogoDigital> buscarPorPlataforma(String plataforma);
} 