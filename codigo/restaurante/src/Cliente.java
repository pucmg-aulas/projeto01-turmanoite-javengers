public class Cliente {

    private String nome;
    private Reserva reservaAtual;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void fazerReserva(Reserva reserva) {
        if (reservaAtual != null) {
            throw new IllegalStateException("Cliente já possui uma reserva ativa.");
        }

        this.reservaAtual = reserva;
    }

    public void cancelarReserva() {
        this.reservaAtual = null;
    }

    public Reserva getReservaAtual() {
        return reservaAtual;
    }
}
