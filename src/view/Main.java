package view;
import java.util.List;
import java.util.Scanner;

import entities.JogoDigital;
import repositories.IJogoDigitalRepository;
import repositories.impl.JogoDigitalRepository;
import repositories.impl.JogoDigitalRepositoryJDBC;
import services.IJogoDigitalService;
import services.impl.JogoDigitalService;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IJogoDigitalRepository repositoryMemoria = new JogoDigitalRepository();
    private static final IJogoDigitalRepository repositoryJDBC = new JogoDigitalRepositoryJDBC();
    private static final IJogoDigitalService jogoDigitalService = new JogoDigitalService(repositoryMemoria, repositoryJDBC);
    
    public static void main(String[] args) {
    	
    	JogoDigitalRepositoryJDBC jdr=new JogoDigitalRepositoryJDBC();
		JogoDigital jd1=new JogoDigital();
		jd1.setNome("Teste");
		jd1.setDesenvolvedora("Teste Games");
		jd1.setPlataforma("Windows");
		jd1.setPreco(200);		
		jdr.salvar(jd1);
		
		
       /* int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer
            
            switch (opcao) {
                case 1:
                    cadastrarJogoDigital();
                    break;
                case 2:
                    listarJogosDigitais();
                    break;
                case 3:
                    removerJogoDigital();
                    break;
                case 4:
                    atualizarJogoDigital();
                    break;
                case 5:
                    buscarJogosPorPlataforma();
                    break;
                case 6:
                    sincronizarRepositorios();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
        
        scanner.close();*/
    }
    
    private static void exibirMenu() {
        System.out.println("\n=== SISTEMA DE GERENCIAMENTO DE JOGOS ===");
        System.out.println("1 - Cadastrar Jogo Digital");
        System.out.println("2 - Listar Jogos Digitais");
        System.out.println("3 - Remover Jogo Digital");
        System.out.println("4 - Atualizar Jogo Digital");
        System.out.println("5 - Buscar Jogos por Plataforma");
        System.out.println("6 - Sincronizar Repositórios");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opcao: ");
    }
    
    private static void cadastrarJogoDigital() {
        System.out.println("\n=== CADASTRAR JOGO DIGITAL ===");
        
        try {
            System.out.print("ID: ");
            Long id = scanner.nextLong();
            scanner.nextLine(); // Limpar buffer
            
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            
            System.out.print("Preco: ");
            double preco = scanner.nextDouble();
            scanner.nextLine();
            
            System.out.print("Desenvolvedora: ");
            String desenvolvedora = scanner.nextLine();
            
            System.out.print("Plataforma: ");
            String plataforma = scanner.nextLine();
            
            System.out.print("Tamanho (GB): ");
            double tamanhoGB = scanner.nextDouble();
            
            JogoDigital jogo = new JogoDigital(id, nome, preco, desenvolvedora, plataforma, tamanhoGB);
            jogoDigitalService.cadastrarJogo(jogo);
            System.out.println("Jogo cadastrado com sucesso!");
            
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado ao cadastrar o jogo.");
        }
    }
    
    private static void listarJogosDigitais() {
        System.out.println("\n=== LISTA DE JOGOS DIGITAIS ===");
        List<JogoDigital> jogos = jogoDigitalService.listarJogos();
        
        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado.");
            return;
        }
        
        for (JogoDigital jogo : jogos) {
            System.out.println(jogo.toString());
        }
    }
    
    private static void removerJogoDigital() {
        System.out.println("\n=== REMOVER JOGO DIGITAL ===");
        
        try {
            System.out.print("Digite o ID do jogo a ser removido: ");
            Long id = scanner.nextLong();
            
            JogoDigital jogo = jogoDigitalService.buscarPorId(id);
            if (jogo == null) {
                System.out.println("Jogo nao encontrado!");
                return;
            }
            
            System.out.println("Jogo a ser removido:");
            System.out.println(jogo);
            
            System.out.print("Confirma a remocao? (S/N): ");
            String confirmacao = scanner.next();
            
            if (confirmacao.equalsIgnoreCase("S")) {
                jogoDigitalService.removerJogo(id);
                System.out.println("Jogo removido com sucesso!");
            } else {
                System.out.println("Operacao cancelada.");
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao remover o jogo: " + e.getMessage());
        }
    }
    
    private static void atualizarJogoDigital() {
        System.out.println("\n=== ATUALIZAR JOGO DIGITAL ===");
        
        try {
            System.out.print("Digite o ID do jogo a ser atualizado: ");
            Long id = scanner.nextLong();
            scanner.nextLine();
            
            JogoDigital jogoExistente = jogoDigitalService.buscarPorId(id);
            if (jogoExistente == null) {
                System.out.println("Jogo não encontrado!");
                return;
            }
            
            System.out.println("Dados atuais do jogo:");
            System.out.println(jogoExistente);
            
            System.out.println("\nInsira os novos dados (pressione ENTER para manter o valor atual):");
            
            System.out.print("Nome [" + jogoExistente.getNome() + "]: ");
            String nome = scanner.nextLine();
            if (!nome.isEmpty()) {
                jogoExistente.setNome(nome);
            }
            
            System.out.print("Preço [" + jogoExistente.getPreco() + "]: ");
            String precoStr = scanner.nextLine();
            if (!precoStr.isEmpty()) {
                jogoExistente.setPreco(Double.parseDouble(precoStr));
            }
            
            System.out.print("Desenvolvedora [" + jogoExistente.getDesenvolvedora() + "]: ");
            String desenvolvedora = scanner.nextLine();
            if (!desenvolvedora.isEmpty()) {
                jogoExistente.setDesenvolvedora(desenvolvedora);
            }
            
            System.out.print("Plataforma [" + jogoExistente.getPlataforma() + "]: ");
            String plataforma = scanner.nextLine();
            if (!plataforma.isEmpty()) {
                jogoExistente.setPlataforma(plataforma);
            }
            
            System.out.print("Tamanho GB [" + jogoExistente.getTamanhoGB() + "]: ");
            String tamanhoStr = scanner.nextLine();
            if (!tamanhoStr.isEmpty()) {
                jogoExistente.setTamanhoGB(Double.parseDouble(tamanhoStr));
            }
            
            jogoDigitalService.atualizarJogo(jogoExistente);
            System.out.println("Jogo atualizado com sucesso!");
            
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado ao atualizar o jogo.");
        }
    }
    
    private static void sincronizarRepositorios() {
        System.out.println("\n=== SINCRONIZAR REPOSITÓRIOS ===");
        try {
            jogoDigitalService.sincronizarRepositorios();
            System.out.println("Repositórios sincronizados com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao sincronizar repositórios: " + e.getMessage());
        }
    }
    
    private static void buscarJogosPorPlataforma() {
        System.out.println("\n=== BUSCAR JOGOS POR PLATAFORMA ===");
        
        try {
            System.out.print("Digite a plataforma: ");
            String plataforma = scanner.nextLine();
            
            List<JogoDigital> jogos = jogoDigitalService.buscarPorPlataforma(plataforma);
            
            if (jogos.isEmpty()) {
                System.out.println("Nenhum jogo encontrado para a plataforma: " + plataforma);
                return;
            }
            
            System.out.println("\nJogos encontrados:");
            for (JogoDigital jogo : jogos) {
                System.out.println(jogo);
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar jogos: " + e.getMessage());
        }
    }
} 