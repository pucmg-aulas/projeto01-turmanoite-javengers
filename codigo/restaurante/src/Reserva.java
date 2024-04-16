import java.time.*;

public class Reserva {
    private Cliente cliente;
    private boolean estaNaEspera;
    private int quantPessoas;
    private LocalDateTime dataHoraEntrada;
    private LocalDateTime dataHoraSaida;

    public Reserva(Cliente cliente, boolean estaNaEspera, int quantPessoas, LocalDateTime dataHoraEntrada, LocalDateTime dataHoraSaida){
        this.cliente = cliente;
        this.estaNaEspera = estaNaEspera;
        this.quantPessoas = quantPessoas;
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = dataHoraSaida;
    }

    public void verificaQuantPessoas(int quantPessoas){

    }
}