import java.util.ArrayList;

public class Comanda {
    private double valor = 0;
    final static double TAXA = 10;
    private ArrayList<Alimento> listaAlimentos = new ArrayList<>();

    public double calculaValor() {
        for (Alimento alimento : listaAlimentos) {
            valor += alimento.getValor();
        }
        valor += valor * TAXA / 100;
        return valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ArrayList<Alimento> getListaAlimentos() {
        return listaAlimentos;
    }

    public void setListaAlimentos(ArrayList<Alimento> listaAlimentos) {
        this.listaAlimentos = listaAlimentos;
    }

    public void imprimeComanda() {
        System.out.println("\nComanda:\n");

        for (Alimento alimento : listaAlimentos) {
            System.out.println(alimento.toString());
        }

        System.out.println("\nValor total com taxa: R$" + calculaValor());
    }

}