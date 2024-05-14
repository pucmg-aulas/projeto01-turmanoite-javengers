public class Pratos extends Alimento{
    private int quantidade;

    public Pratos(int quantidade, String nome, String descricao, double valor) {
        super(nome, descricao, valor);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
