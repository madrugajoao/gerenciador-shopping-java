//array private loja
public class Shopping {
    private Loja[] espacos;

    public Shopping() {
        espacos = new Loja[20];
    }

   
//metodo alugar espaço
    public void alugarEspaco(int indice, Loja loja) {
        if (indice >= 0 && indice < espacos.length) {
            if (espacos[indice] == null) {
                espacos[indice] = loja;
                System.out.println("Espaço E" + indice + " alugado para " + loja.getNome());
            } else {
                System.out.println("Espaço E" + indice + " já está ocupado!");
            }
        } else {
            System.out.println("Espaço inválido!");
        }
    }

    public void listarLojas() {
        System.out.println("\n--- LOJAS DO SHOPPING ---");
        for (int i = 0; i < espacos.length; i++) {
            if (espacos[i] != null) {
                System.out.println("Espaço E" + i + ": " + espacos[i].getNome() + " (" + espacos[i].getSegmento() + ")");
            } else {
                System.out.println("Espaço E" + i + ": [vazio]");
            }
        }
    }

    public void listarEspacosLivres() {
        System.out.println("\n--- ESPAÇOS LIVRES ---");
        for (int i = 0; i < espacos.length; i++) {
            if (espacos[i] == null) {
                System.out.println("Espaço E" + i + " está livre.");
            }
        }
    }

    

    public void removerLoja(int indice) {
        if (indice >= 0 && indice < espacos.length) {
            if (espacos[indice] != null) {
                System.out.println("Loja " + espacos[indice].getNome() + " removida do espaço E" + indice);
                espacos[indice] = null;
            } else {
                System.out.println("Espaço E" + indice + " já está vazio!");
            }
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public void alterarLoja(int indice, String novoNome, String novoSegmento, double novoAluguel) {
        if (indice >= 0 && indice < espacos.length) {
            if (espacos[indice] != null) {
                Loja loja = espacos[indice];
                loja.setNome(novoNome);
                loja.setSegmento(novoSegmento);
                loja.setAluguel(novoAluguel);
                System.out.println("Dados da loja no espaço E" + indice + " atualizados!");
            } else {
                System.out.println("Não há loja no espaço E" + indice);
            }
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public void buscarLoja(String nome) {
        boolean encontrada = false;
        for (int i = 0; i < espacos.length; i++) {
            if (espacos[i] != null && espacos[i].getNome().equalsIgnoreCase(nome)) {
                System.out.println("Loja encontrada no espaço E" + i + ":");
                espacos[i].exibirInfo();
                encontrada = true;
                break;
            }
        }
        if (!encontrada) {
            System.out.println("Loja \"" + nome + "\" não encontrada!");
        }
    }

    public void contarEspacos() {
        int ocupados = 0;
        for (Loja espaco : espacos) {
            if (espaco != null) {
                ocupados++;
            }
        }
        int livres = espacos.length - ocupados;
        System.out.println("\n--- STATUS DO SHOPPING ---");
        System.out.println("Espaços ocupados: " + ocupados);
        System.out.println("Espaços livres: " + livres);
    }

    

    public void lojaMaiorAluguel() {
        Loja maior = null;
        for (Loja loja : espacos) {
            if (loja != null) {
                if (maior == null || loja.getAluguel() > maior.getAluguel()) {
                    maior = loja;
                }
            }
        }
        if (maior != null) {
            System.out.println("\nLoja com o maior aluguel:");
            maior.exibirInfo();
        } else {
            System.out.println("Nenhuma loja cadastrada!");
        }
    }

    public void lojaMenorAluguel() {
        Loja menor = null;
        for (Loja loja : espacos) {
            if (loja != null) {
                if (menor == null || loja.getAluguel() < menor.getAluguel()) {
                    menor = loja;
                }
            }
        }
        if (menor != null) {
            System.out.println("\nLoja com o menor aluguel:");
            menor.exibirInfo();
        } else {
            System.out.println("Nenhuma loja cadastrada!");
        }
    }

    public void somaTotalAlugueis() {
        double soma = 0;
        for (Loja loja : espacos) {
            if (loja != null) {
                soma += loja.getAluguel();
            }
        }
        System.out.println("\nSoma total dos aluguéis: R$ " + soma);
    }

    public void mediaAlugueis() {
        double soma = 0;
        int count = 0;
        for (Loja loja : espacos) {
            if (loja != null) {
                soma += loja.getAluguel();
                count++;
            }
        }
        if (count > 0) {
            double media = soma / count;
            System.out.println("Média dos aluguéis: R$ " + media);
        } else {
            System.out.println("Nenhuma loja cadastrada!");
        }
    }

    public void listarPorSegmento(String segmento) {
        System.out.println("\n--- Lojas do segmento: " + segmento + " ---");
        boolean achou = false;
        for (Loja loja : espacos) {
            if (loja != null && loja.getSegmento().equalsIgnoreCase(segmento)) {
                loja.exibirInfo();
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("Nenhuma loja desse segmento encontrada.");
        }
    }
}

