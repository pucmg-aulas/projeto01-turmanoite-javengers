public class Bebida extends Alimento {
    private int tamanho;

    public Bebida(int tamanho, String nome, String descricao, double valor) {
        super(nome, descricao, valor);
        this.tamanho = tamanho;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String toString(){
        return this.getNome() + " - " + this.getDescricao() + " - " + this.getTamanho() + "ml - R$" + this.getValor();
    }

}
