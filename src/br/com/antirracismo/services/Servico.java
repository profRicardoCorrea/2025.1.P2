package  br.com.antirracismo.services;

import br.com.antirracismo.interfaces.IRepositorio;

class Service<T> {
    private IRepositorio<T> repository;

    public Service(IRepositorio<T> repository) {
        this.repository = repository;
    }

    public void cadastrar(T obj) {
        repository.salvar(obj);
    }

    public void listar() {
        repository.listarTodas().forEach(System.out::println);
    }
}
