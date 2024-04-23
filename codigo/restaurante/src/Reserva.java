import java.time.*;

public class Reserva {
    private Cliente cliente;
    private boolean estaNaEspera;
    private int quantidadePessoas;
    private LocalDateTime dataHoraEntrada;
    private LocalDateTime dataHoraSaida;

    public Reserva(Cliente cliente, boolean estaNaEspera, int quantidadePessoas, LocalDateTime dataHoraEntrada, LocalDateTime dataHoraSaida){
        this.cliente = cliente;
        this.estaNaEspera = estaNaEspera;
        this.quantidadePessoas = quantidadePessoas;
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = dataHoraSaida;
    }

    public void verificaQuantPessoas(int quantidadePessoas){

    }
}
