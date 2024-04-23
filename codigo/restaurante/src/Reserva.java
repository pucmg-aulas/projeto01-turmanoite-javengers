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
    private boolean estaNaEspera;
    private int quantPessoas;
    Date dataHoraEntrada;
    Date dataHoraSaida;
    
    public Reserva(Cliente cliente, boolean estaNaEspera, int quantPessoas, Date dataHoraEntrada){
        this.cliente = cliente;
        this.estaNaEspera = estaNaEspera;
        this.quantPessoas = quantPessoas;
        this.dataHoraEntrada = dataHoraEntrada;
        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isEstaNaEspera() {
        return estaNaEspera;
    }

    public void setEstaNaEspera(boolean estaNaEspera) {
        this.estaNaEspera = estaNaEspera;
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
