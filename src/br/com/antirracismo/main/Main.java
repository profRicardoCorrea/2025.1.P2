package br.com.antirracismo.main;

import br.com.antirracismo.entidades.Empresa;
import br.com.antirracismo.interfaces.IRepositorio;
import br.com.antirracismo.repositorios.GenericRepository;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        empresa.setNome("Tech Antirracista");
        empresa.setEndereco("Rua da Igualdade, 100");
        empresa.setAnoFundacao(2023);
        empresa.setTipo("Tecnologia");

        IRepositorio<Empresa> empresaRepo = new GenericRepository<>();
        Servico<Empresa> empresaService = new Service<>(empresaRepo);

        empresaService.cadastrar(empresa);
        empresaService.listar();

        Ativista ativista = new Ativista();
        ativista.setNome("João da Paz");
        ativista.setIdade(30);
        ativista.setCausa("Igualdade racial");

        Repository<Ativista> ativistaRepo = new GenericRepositoryImpl<>();
        Service<Ativista> ativistaService = new Service<>(ativistaRepo);

        ativistaService.cadastrar(ativista);
        ativistaService.listar();
    }
}
