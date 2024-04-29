import java.util.ArrayList;

public class Restaurante {
    private ArrayList<Mesa> mesas = new ArrayList<>();
    private ArrayList<Reserva> filaDeEspera = new ArrayList<>();
    private ArrayList<Reserva> reservas = new ArrayList<>();

    public Restaurante() {
    }

    public Restaurante(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }

    public Restaurante(ArrayList<Mesa> mesas, ArrayList<Reserva> filaDeEspera, ArrayList<Reserva> reservas) {
        this.mesas = mesas;
        this.filaDeEspera = filaDeEspera;
        this.reservas = reservas;
    }

    public ArrayList<Reserva> getFilaDeEspera() {
        return filaDeEspera;
    }

    public void setFilaDeEspera(ArrayList<Reserva> filaDeEspera) {
        this.filaDeEspera = filaDeEspera;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void adicionaFilaDeEspera(Reserva reserva) {
        filaDeEspera.add(reserva);
    }

    public void removeFilaDeEspera(Reserva reserva) {
        filaDeEspera.remove(reserva);
    }

    public boolean fazReservaDeMesa(Reserva reserva) {
        for (Mesa mesa : this.mesas) {
            if (!mesa.isOcupada()) {
                if (mesa.getQuantCadeiras() >= reserva.getQuantPessoas()) {
                    reserva.setMesa(mesa);
                    mesa.setOcupada(true);
                    filaDeEspera.remove(reserva);
                    return true;
                }
            }
        }
        return false;
    }

    public void exibeMesasDisponiveis() {
        int indice = 1;

        System.out.println("Mesas disponíveis: \n");

        for (Mesa mesa : this.mesas) {
            if (!mesa.isOcupada()) {
                System.out.println("Mesa " + indice + " com " + mesa.getQuantCadeiras() + " cadeiras");
                indice++;
            }
        }
        System.out.println();
    }

    public void exibeReservas() {
        int indice = 1;
        
        if (reservas.size() == 0) {
            System.out.println("Não há clientes no momento.");
            return;
        }
        
        System.out.println("Clientes: \n");

        for (Reserva reserva : reservas) {
            System.out.println(indice + ": " + reserva.getCliente().getNome());
            indice++;
        }
        System.out.println();
    }

    public void exibeFilaDeEspera() {
        int indice = 1;

        if (reservas.size() == 0) {
            System.out.println("Não há clientes na fila de espera no momento.");
            return;
        }

        System.out.println("Clientes na fila de espera: \n");

        for (Reserva reserva : filaDeEspera) {
            System.out.println(indice + ": " + reserva.getCliente().getNome());
            indice++;
        }
        System.out.println();
    }

    public boolean verificaFilaDeEspera() {
        for (Reserva reserva : filaDeEspera) {
            if (fazReservaDeMesa(reserva)) {
                return true;
            }
        }
        return false;
    }

    public void removeReserva(Reserva reserva) {
        reserva.getMesa().setOcupada(false);
        reservas.remove(reserva);
    }

    public int quantidadeReservas(){
        return reservas.size();
    }

    public int quantidadeFilaDeEspera(){
        return filaDeEspera.size();
    }
}