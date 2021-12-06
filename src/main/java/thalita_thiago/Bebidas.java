package thalita_thiago;

public class Bebidas extends ProdutosCardapio implements TempoEspera
{
    private boolean comGelo;
    private double tempo;
    private String fabricante;
    private String codigoBarra;

    public Bebidas(String nome, String descricao, double valor, boolean comGelo,double tempo) {
        super(nome, descricao, valor);
        this.comGelo = comGelo;
        this.tempo = tempo;
    }

    public Bebidas() {
        super("","",0);
    }

    public boolean isComGelo() {
        return comGelo;
    }

    public void setComGelo(boolean comGelo) {
        this.comGelo = comGelo;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    @Override
    public void tempoEspera(){
        System.out.println("Tempo de espera de " + getNome() + ": " + getTempo() +  " minutos ");
    }
}
