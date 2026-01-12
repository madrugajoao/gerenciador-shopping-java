import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Shopping shopping = new Shopping();
        int opcao;

        do {
            System.out.println("\n====== GERENCIADOR DE LOJAS DO SHOPPING ======");
            System.out.println("1 - Alugar espaço");
            System.out.println("2 - Listar lojas");
            System.out.println("3 - Listar espaços livres");
            System.out.println("4 - Remover loja");
            System.out.println("5 - Alterar dados de loja");
            System.out.println("6 - Buscar loja por nome");
            System.out.println("7 - Exibir status do shopping");
            System.out.println("8 - Loja com MAIOR aluguel");
            System.out.println("9 - Loja com MENOR aluguel");
            System.out.println("10 - Soma total dos aluguéis");
            System.out.println("11 - Média dos aluguéis");
            System.out.println("12 - Listar lojas por segmento");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o número do espaço (0 a 19): ");
                    int espaco = entrada.nextInt();
                    entrada.nextLine();
                    System.out.print("Nome da loja: ");
                    String nome = entrada.nextLine();
                    System.out.print("Segmento: ");
                    String segmento = entrada.nextLine();
                    System.out.print("Valor do aluguel: ");
                    double aluguel = entrada.nextDouble();

                    Loja nova = new Loja(nome, segmento, aluguel);
                    shopping.alugarEspaco(espaco, nova);
                    break;

                case 2: shopping.listarLojas(); break;
                case 3: shopping.listarEspacosLivres(); break;
                case 4:
                    System.out.print("Informe o número do espaço da loja a remover: ");
                    shopping.removerLoja(entrada.nextInt());
                    break;

                case 5:
                    System.out.print("Informe o número do espaço da loja a alterar: ");
                    int indice = entrada.nextInt();
                    entrada.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = entrada.nextLine();
                    System.out.print("Novo segmento: ");
                    String novoSegmento = entrada.nextLine();
                    System.out.print("Novo valor de aluguel: ");
                    double novoAluguel = entrada.nextDouble();
                    shopping.alterarLoja(indice, novoNome, novoSegmento, novoAluguel);
                    break;

                case 6:
                    System.out.print("Digite o nome da loja a buscar: ");
                    shopping.buscarLoja(entrada.nextLine());
                    break;

                case 7: shopping.contarEspacos(); break;
                case 8: shopping.lojaMaiorAluguel(); break;
                case 9: shopping.lojaMenorAluguel(); break;
                case 10: shopping.somaTotalAlugueis(); break;
                case 11: shopping.mediaAlugueis(); break;

                case 12:
                    System.out.print("Digite o segmento: ");
                    shopping.listarPorSegmento(entrada.nextLine());
                    break;

                case 0:
                    System.out.println("Encerrando o sistema... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        entrada.close();
    }
}
