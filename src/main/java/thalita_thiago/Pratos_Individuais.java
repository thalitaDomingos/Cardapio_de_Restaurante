package thalita_thiago;


public class Pratos_Individuais extends ProdutosCardapio implements TempoEspera
{
    private double tempo;

    public Pratos_Individuais(String nome, String descricao, double valor, double tempo) {
        super(nome, descricao, valor);
        this.tempo = tempo;
    }

    public Pratos_Individuais(){
        super("","", 0);
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
