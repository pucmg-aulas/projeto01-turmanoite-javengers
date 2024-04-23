public class Mesa {
    private int quantCadeiras;
    private boolean ocupada;

    public Mesa(int quantCadeiras) {
        this.quantCadeiras = quantCadeiras;
        this.ocupada = false;
    }

    public int getQuantCadeiras() { // para outra classe conseguir identificar a capacidade da mesa
        return quantCadeiras;
    }

    public boolean isOcupada() { // retorna o status da mesa
        return ocupada;
    }

    public void setOcupada(boolean ocupada) { // mudar o status da mesa quando um cliente ocupa/libera
        this.ocupada = ocupada;
    }
}
