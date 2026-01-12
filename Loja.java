public class Loja {
    private String nome;
    private String segmento;
    private double aluguel;

//construtor
    public Loja(String nome, String segmento, double aluguel) {
        this.nome = nome;
        this.segmento = segmento;
        this.aluguel = aluguel;
    }

    public String getNome() { return nome; }
    public String getSegmento() { return segmento; }
    public double getAluguel() { return aluguel; }

    public void setNome(String nome) { this.nome = nome; }
    public void setSegmento(String segmento) { this.segmento = segmento; }
    public void setAluguel(double aluguel) { this.aluguel = aluguel; }
    
//método exibirinfo
    public void exibirInfo() {
        System.out.println("Loja: " + nome + " | Segmento: " + segmento + " | Aluguel: R$ " + aluguel);
    }
}
