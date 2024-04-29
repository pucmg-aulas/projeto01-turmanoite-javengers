import java.time.LocalDateTime;

public class Reserva {

    private Cliente cliente;
    private int quantPessoas;
    private Mesa mesa;
    private LocalDateTime dataHoraEntrada;
    private LocalDateTime dataHoraSaida;
    
    public Reserva(Cliente cliente, int quantPessoas, LocalDateTime dataHoraEntrada){
        this.cliente = cliente;
        this.quantPessoas = quantPessoas;
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getQuantPessoas() {
        return quantPessoas;
    }

    public void setQuantPessoas(int quantPessoas) {
        this.quantPessoas = quantPessoas;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public LocalDateTime getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

}
