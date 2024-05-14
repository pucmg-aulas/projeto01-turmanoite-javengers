import java.util.ArrayList;

public class Comanda {
    private double valor;
    final static double TAXA = 10;
    private ArrayList<Alimento> listaAlimentos = new ArrayList<>();
    
    public double calculaValor(){
        for(Alimento alimento : listaAlimentos)
        {
            valor += alimento.getValor();
        }
        return valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}