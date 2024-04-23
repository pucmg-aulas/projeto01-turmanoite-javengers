/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.reserva;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Gustavo Delfino
 */
public class Reserva {

    private Cliente cliente;
    private int quantPessoas;
    Date dataHoraEntrada;
    Date dataHoraSaida;
    
    public Reserva(Cliente cliente, int quantPessoas, Date dataHoraEntrada){
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

    public Date getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(Date dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public Date getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(Date dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }
  
}
