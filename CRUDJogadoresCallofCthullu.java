import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Jogador {
    private int id;
    private String nome;
    private String profissao;
    private String habilidades;
    private int vida;
    private List<String> inventario;

    public Jogador(int id, String nome, String profissao, String habilidades, int vida) {
        this.id = id;
        this.nome = nome;
        this.profissao = profissao;
        this.habilidades = habilidades;
        this.vida = vida;
        this.inventario = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public int getVida() {
        return vida;
    }

    public List<String> getInventario() {
        return inventario;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public void setHabilidades(String novasHabilidades) {
        this.habilidades = novasHabilidades;
    }

    public void setProfissao(String novaProfissao) {
        this.profissao = novaProfissao;
    }

    public void setVida(int novaVida) {
        this.vida = novaVida;
    }

    public void adicionarItemInventario(String item) {
        this.inventario.add(item);
    }

    public void removerItemInventario(String item) {
        this.inventario.remove(item);
    }
}

public class CRUDJogadoresCallofCthullu {
    private static List<Jogador> jogadores = new ArrayList<>();
    private static int proximoId = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 0;
        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Adicionar jogador");
            System.out.println("2 - Listar jogadores");
            System.out.println("3 - Atualizar vida do jogador");
            System.out.println("4 - Remover jogador");
            System.out.println("5 - Adicionar item ao inventário do jogador");
            System.out.println("6 - Remover item do inventário do jogador");
            System.out.println("7 - Sair");
            opcao = lerOpcao();
            switch (opcao) {
                case 1:
                    if (adicionarJogador() == 1) {
                        System.out.println("Jogador adicionado com sucesso!");
                    } else {
                        System.out.println("Erro ao adicionar jogador.");
                    }
                    break;
                case 2:
                    listarJogadores();
                    break;
                case 3:
                    if (atualizarVidaJogador() == 1) {
                        System.out.println("Vida do jogador atualizada com sucesso!");
                    } else {
                        System.out.println("Erro ao atualizar vida do jogador.");
                    }
                    break;
                case 4:
                    if (removerJogador() == 1) {
                        System.out.println("Jogador removido com sucesso!");
                    } else {
                        System.out.println("Erro ao remover jogador.");
                    }
                    break;
                case 5:
                    adicionarItemAoJogador();
                    break;
                case 6:
                    removerItemDoJogador();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 7);
        scanner.close();
    }
    private static int lerOpcao() {
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
    private static int adicionarJogador() {
        System.out.println("Digite o nome do jogador:");
        String nome = lerInformacao();

        System.out.println("Digite a profissão do jogador:");
        String profissao = lerInformacao();

        System.out.println("Digite as habilidades do jogador:");
        String habilidades = lerInformacao();

        System.out.println("Digite a vida do jogador:");
        int vida = scanner.nextInt();
        scanner.nextLine();

        Jogador jogador = new Jogador(proximoId, nome, profissao, habilidades, vida);
        jogadores.add(jogador);
        proximoId++;

        return 1;
    }
    private static void listarJogadores() {
        if (jogadores.isEmpty()) {
            System.out.println("Não há jogadores cadastrados.");
        } else {
            System.out.println("Lista de jogadores:");
            for (Jogador jogador : jogadores) {
                System.out.println("ID: " + jogador.getId());
                System.out.println("Nome: " + jogador.getNome());
                System.out.println("Profissão: " + jogador.getProfissao());
                System.out.println("Habilidades: " + jogador.getHabilidades());
                System.out.println("Vida: " + jogador.getVida());
                System.out.println("Inventário: " + jogador.getInventario());
                System.out.println("----------------------");
            }
        }
    }
    private static int atualizarVidaJogador() {
        System.out.println("Digite o ID do jogador que deseja atualizar a vida:");
        int id = lerOpcao();

        Jogador jogadorAtualizar = encontrarJogadorPorId(id);

        if (jogadorAtualizar == null) {
            System.out.println("Jogador não encontrado.");
            return -1;
        } else {
            System.out.println("Digite a nova vida do jogador:");
            int novaVida = scanner.nextInt();
            scanner.nextLine();

            jogadorAtualizar.setVida(novaVida);
            return 1;
        }
    }
    private static int removerJogador() {
        System.out.println("Digite o ID do jogador que deseja remover:");
        int id = lerOpcao();

        Jogador jogadorRemover = encontrarJogadorPorId(id);

        if (jogadorRemover == null) {
            System.out.println("Jogador não encontrado.");
            return -1;
        } else {
            jogadores.remove(jogadorRemover);
            return 1;
        }
    }
    private static void adicionarItemAoJogador() {
        System.out.println("Digite o ID do jogador:");
        int id = lerOpcao();

        Jogador jogador = encontrarJogadorPorId(id);

        if (jogador == null) {
            System.out.println("Jogador não encontrado.");
        } else {
            System.out.println("Digite o item a ser adicionado ao inventário do jogador:");
            String item = lerInformacao();
            jogador.adicionarItemInventario(item);
            System.out.println("Item adicionado ao inventário do jogador.");
        }
    }
    private static void removerItemDoJogador() {
        System.out.println("Digite o ID do jogador:");
        int id = lerOpcao();

        Jogador jogador = encontrarJogadorPorId(id);

        if (jogador == null) {
            System.out.println("Jogador não encontrado.");
        } else {
            System.out.println("Digite o item a ser removido do inventário do jogador:");
            String item = lerInformacao();
            jogador.removerItemInventario(item);
            System.out.println("Item removido do inventário do jogador.");
        }
    }
    private static Jogador encontrarJogadorPorId(int id) {
        for (Jogador jogador : jogadores) {
            if (jogador.getId() == id) {
                return jogador;
            }
        }
        return null;
    }
    private static String lerInformacao() {
        return scanner.nextLine();
    }
}
