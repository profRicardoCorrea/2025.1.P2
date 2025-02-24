package br.com.antirracismo.repositorios;
import java.util.ArrayList;
import java.util.List;

import br.com.antirracismo.interfaces.IRepositorio;
 

public class EmpresaRepositorio<T> implements IRepositorio<T> {
    private List<T> lista = new ArrayList<>();

    @Override
    public void salvar(T obj) {
        lista.add(obj);
        System.out.println("Objeto salvo: " + obj);
    }

    @Override
    public T buscarPorNome(String nome) {
        return lista.stream()
                .filter(obj -> obj.toString().contains(nome))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void atualizar(T obj) {
        System.out.println("Atualizar não implementado diretamente.");
    }

    @Override
    public void deletar(String nome) {
        lista.removeIf(obj -> obj.toString().contains(nome));
        System.out.println("Objeto deletado: " + nome);
    }

    @Override
    public List<T> listarTodas() {
        return new ArrayList<>(lista);
    }
}
