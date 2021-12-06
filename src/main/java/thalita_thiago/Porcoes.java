package thalita_thiago;

public class Porcoes extends ProdutosCardapio implements TempoEspera {

    private int quantidadePorcao;
    private double tempo;

    public Porcoes(String nome, String descricao, double valor, int quantidadePorcao, double tempo) {
        super(nome, descricao, valor);
        this.quantidadePorcao = quantidadePorcao;
        this.tempo = tempo;
    }

    public Porcoes() {
        super("","",0);
    }

    public int getQuantidadePorcao() {
        return quantidadePorcao;
    }

    public void setQuantidadePorcao(int quantidadePorcao) {
        this.quantidadePorcao = quantidadePorcao;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    @Override
    public void tempoEspera(){
        System.out.println("Tempo de espera de " + getNome() + ": " + getTempo() +  " minutos");
    }
}