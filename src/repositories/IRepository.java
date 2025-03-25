package repositories;

import java.util.List;

public interface IRepository<T> {
    void salvar(T entidade);
    void remover(Long id);
    void alterar(T entidade);
    List<T> listar();
    T buscarPorId(Long id);
} 