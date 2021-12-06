package thalita_thiago;

public abstract class ProdutosCardapio {

    public static int cont = 0;

    private int id;
    private String nome;
    private String descricao;
    private double valor;

    public ProdutosCardapio(String nome, String descricao, double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        cont++;
        id = cont;
    }

    public static int getCont() {
        return cont;
    }

    public static void setCont(int cont) {
        ProdutosCardapio.cont = cont;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}