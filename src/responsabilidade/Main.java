package responsabilidade;

public class Main {
    public static void main(String[] args) {
        // Criando as instâncias necessárias
        PessoaFisicaRepository repository = new PessoaFisicaRepository();
        PessoaFisicaService service = new PessoaFisicaService(repository);

        // Criando uma pessoa
        PessoaFisica pessoa = new PessoaFisica(
            "João",
            25,
            "12345678901",
            "joao@email.com",
            "Rua ABC, 123"
        );

        try {
            // Cadastrando a pessoa
            service.cadastrarPessoa(pessoa);
            
            // Validações
            if (service.validarIdade(pessoa)) {
                System.out.println("Pessoa maior de idade");
            }

            // Buscando pessoa
            PessoaFisica pessoaEncontrada = repository.buscarPorId(1);
            if (pessoaEncontrada != null) {
                pessoaEncontrada.apresentacao();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
