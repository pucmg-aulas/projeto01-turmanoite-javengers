public class Bebidas extends Alimento {
    private int tamanho;

    public Bebidas(int tamanho, String nome, String descricao, double valor) {
        super(nome, descricao, valor);
        this.tamanho = tamanho;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

}
