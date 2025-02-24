package br.com.antirracismo.interfaces;

import java.util.List;

public interface IRepositorio<T> {
    void salvar(T obj);
    T buscarPorNome(String nome);
    void atualizar(T obj);
    void deletar(String nome);
    List<T> listarTodas();
}
