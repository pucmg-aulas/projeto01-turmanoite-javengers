package main.java.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Atendimento implements Serializable {

    private Cliente cliente;
    private int quantPessoas;
    private Mesa mesa;
    private Comanda comanda;
    private LocalDateTime dataHoraEntrada;
    private LocalDateTime dataHoraSaida;

    public Atendimento(Cliente cliente, int quantPessoas, LocalDateTime dataHoraEntrada) {
        this.cliente = cliente;
        this.quantPessoas = quantPessoas;
        this.dataHoraEntrada = dataHoraEntrada;
        this.comanda = new Comanda();
        this.mesa = null;
        this.dataHoraSaida = null;
    }

    public Atendimento(Cliente cliente, int quantPessoas, Mesa mesa, Comanda comanda, LocalDateTime dataHoraEntrada,
            LocalDateTime dataHoraSaida) {
        this.cliente = cliente;
        this.quantPessoas = quantPessoas;
        this.mesa = mesa;
        this.comanda = comanda;
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = dataHoraSaida;
    }

    @Override
    public String toString() {
        return cliente + "%" + quantPessoas + "%" + mesa + "%" + comanda + "%" + dataHoraEntrada + "%" + dataHoraSaida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getQuantPessoas() {
        return quantPessoas;
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

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

}
