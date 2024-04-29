import java.time.LocalDateTime;

public class Reserva {

    private Cliente cliente;
    private int quantPessoas;
    private Mesa mesa;
    LocalDateTime dataHoraEntrada;
    LocalDateTime dataHoraSaida;
    
    public Reserva(Cliente cliente, int quantPessoas, LocalDateTime dataHoraEntrada, Mesa mesa){
        this.cliente = cliente;
        this.mesa
        this.quantPessoas = quantPessoas;
        this.dataHoraEntrada = dataHoraEntrada;
    }

}
