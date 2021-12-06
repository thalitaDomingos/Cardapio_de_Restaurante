package thalita_thiago;

public class Sobremesas extends ProdutosCardapio implements TempoEspera
{
    private boolean diet;
    private double tempo;

    public Sobremesas(String nome, String descricao, double valor, boolean diet, double tempo) {
        super(nome, descricao, valor);
        this.diet = diet;
        this.tempo = tempo;
    }

    public Sobremesas() {
        super("","",0);
    }

    public boolean isDiet() {
        return diet;
    }

    public void setDiet(boolean diet) {
        this.diet = diet;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    @Override
    public void tempoEspera(){
        System.out.println("Tempo de espera de " + getNome() + ": " + getTempo() +  " minutos ");
    }

}
