import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Jogador {
    private int id;
    private String nome;
    private String classe;
    private String habilidades;
    
    public Jogador(int id, String nome, String classe, String habilidades) {
        this.id = id;
        this.nome = nome;
        this.classe = classe;
        this.habilidades = habilidades;
    }
    
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getClasse() {
        return classe;
    }
    
    public String getHabilidades() {
        return habilidades;
    }

    public void setClasse(String novaClasse) {
    }

    public void setNome(String novoNome) {
    }

    public void setHabilidades(String novasHabilidades) {
    }
}

public class CRUDJogadoresRPG {
    private static List<Jogador> jogadores = new ArrayList<>();
    private static int proximoId = 1; 
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        
        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Adicionar jogador");
            System.out.println("2 - Listar jogadores");
            System.out.println("3 - Atualizar jogador");
            System.out.println("4 - Remover jogador");
            System.out.println("5 - Sair");
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    adicionarJogador(scanner);
                    break;
                case 2:
                    listarJogadores();
                    break;
                case 3:
                    atualizarJogador(scanner);
                    break;
                case 4:
                    removerJogador(scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 5);
        
        scanner.close();
    }
    
    private static void adicionarJogador(Scanner scanner) {
        System.out.println("Digite o nome do jogador:");
        String nome = scanner.next();
        
        System.out.println("Digite a classe do jogador:");
        String classe = scanner.next();
        
        System.out.println("Digite as habilidades do jogador:");
        String habilidades = scanner.next();
        
        Jogador jogador = new Jogador(proximoId, nome, classe, habilidades);
        jogadores.add(jogador);
        proximoId++;
        
        System.out.println("Jogador adicionado com sucesso!");
    }
    
    private static void listarJogadores() {
        if (jogadores.isEmpty()) {
            System.out.println("Não há jogadores cadastrados.");
        } else {
            System.out.println("Lista de jogadores:");
            for (Jogador jogador : jogadores) {
                System.out.println("ID: " + jogador.getId());
                System.out.println("Nome: " + jogador.getNome());
                System.out.println("Classe: " + jogador.getClasse());
                System.out.println("Habilidades: " + jogador.getHabilidades());
                System.out.println("----------------------");
            }
        }
    }
    
    private static void atualizarJogador(Scanner scanner) {
        System.out.println("Digite o ID do jogador que deseja atualizar:");
        int id = scanner.nextInt();
        
        Jogador jogadorAtualizar = null;
        
        for (Jogador jogador : jogadores) {
            if (jogador.getId() == id) {
                jogadorAtualizar = jogador;
                break;
            }
        }
        
        if (jogadorAtualizar == null) {
            System.out.println("Jogador não encontrado.");
        } else {
            System.out.println("Digite o novo nome do jogador:");
            String novoNome = scanner.next();
            
            System.out.println("Digite a nova classe do jogador:");
            String novaClasse = scanner.next();
            
            System.out.println("Digite as novas habilidades do jogador:");
            String novasHabilidades = scanner.next();
            
            jogadorAtualizar.setNome(novoNome);
            jogadorAtualizar.setClasse(novaClasse);
            jogadorAtualizar.setHabilidades(novasHabilidades);
            
            System.out.println("Jogador atualizado com sucesso!");
        }
    }
    
    private static void removerJogador(Scanner scanner) {
        System.out.println("Digite o ID do jogador que deseja remover:");
        int id = scanner.nextInt();
        
        Jogador jogadorRemover = null;
        
        for (Jogador jogador : jogadores) {
            if (jogador.getId() == id) {
                jogadorRemover = jogador;
                break;
            }
        }
        
        if (jogadorRemover == null) {
            System.out.println("Jogador não encontrado.");
        } else {
            jogadores.remove(jogadorRemover);
            System.out.println("Jogador removido com sucesso!");
        }
    }
}
