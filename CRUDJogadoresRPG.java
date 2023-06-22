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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
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
            System.out.println("1 - Adicionar Jogador");
            System.out.println("2 - Listar Jogadores");
            System.out.println("3 - Atualizar Jogador");
            System.out.println("4 - Remover Jogador");
            System.out.println("5 - Sair");
            opcao = lerOpcao(scanner);

            switch (opcao) {
                case 1:
                    if (adicionarJogador(scanner) == 1) {
                        System.out.println("Jogador adicionado com Sucesso!");
                    } else {
                        System.out.println("Erro ao adicionar Jogador.");
                    }
                    break;
                case 2:
                    listarJogadores();
                    break;
                case 3:
                    if (atualizarJogador(scanner) == 1) {
                        System.out.println("Jogador atualizado com Sucesso!");
                    } else {
                        System.out.println("ERRO! ao atualizar jogador.");
                    }
                    break;
                case 4:
                    if (removerJogador(scanner) == 1) {
                        System.out.println("Jogador removido com sucesso!");
                    } else {
                        System.out.println("ERRO! ao remover jogador.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
                    break;
            }
        } while (opcao != 5);

        scanner.close();
    }
    private static int lerOpcao(Scanner scanner) {
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
    private static int adicionarJogador(Scanner scanner) {
        System.out.println("Digite o nome do Jogador:");
        String nome = scanner.nextLine();

        System.out.println("Digite a classe do Jogador:");
        String classe = scanner.nextLine();

        System.out.println("Digite as habilidades do Jogador:");
        String habilidades = scanner.nextLine();

        Jogador jogador = new Jogador(proximoId, nome, classe, habilidades);
        jogadores.add(jogador);
        proximoId++;

        return 1; // Vai adicionar
    }
    private static void listarJogadores() {
        if (jogadores.isEmpty()) {
            System.out.println("Não há Jogadores cadastrados.");
        } else {
            System.out.println("Lista de Jogadores:");
            for (Jogador jogador : jogadores) {
                System.out.println("----------------------");
                System.out.println("ID: " + jogador.getId());
                System.out.println("Nome: " + jogador.getNome());
                System.out.println("Classe: " + jogador.getClasse());
                System.out.println("Habilidades: " + jogador.getHabilidades());
                System.out.println("----------------------");
            }
        }
    }
    private static int atualizarJogador(Scanner scanner) {
        System.out.println("Digite o ID do jogador que deseja atualizar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Jogador jogadorAtualizar = null;

        for (Jogador jogador : jogadores) {
            if (jogador.getId() == id) {
                jogadorAtualizar = jogador;
                break;
            }
        }
        if (jogadorAtualizar == null) {
            System.out.println("Jogador não encontrado.");
            return -1; // Deu ruim
        } else {
            System.out.println("Digite o novo nome do jogador:");
            String novoNome = scanner.nextLine();

            System.out.println("Digite a nova classe do jogador:");
            String novaClasse = scanner.nextLine();

            System.out.println("Digite as novas habilidades do jogador:");
            String novasHabilidades = scanner.nextLine();

            jogadorAtualizar.setNome(novoNome);
            jogadorAtualizar.setClasse(novaClasse);
            jogadorAtualizar.setHabilidades(novasHabilidades);

            return 1; // Deu bom
        }
    }
    private static int removerJogador(Scanner scanner) {
        System.out.println("Digite o ID do jogador que deseja remover:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Jogador jogadorRemover = null;

        for (Jogador jogador : jogadores) {
            if (jogador.getId() == id) {
                jogadorRemover = jogador;
                break;
            }
        }
        if (jogadorRemover == null) {
            System.out.println("Jogador não encontrado.");
            return -1; // Deu merda
        } else {
            jogadores.remove(jogadorRemover);
            return 1;
        }
    }
}
