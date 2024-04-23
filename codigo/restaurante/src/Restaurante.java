/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante;

import java.util.ArrayList;

/**
 *
 * @author dti Digital
 */
public class Restaurante {

    private ArrayList<Mesa> mesasDisponiveis;
    private ArrayList<Mesa> mesasOcupadas;
    private ArrayList<Reserva> listaDeEspera;

    public Restaurante(ArrayList<Mesa> mesasDisponiveis, ArrayList<Mesa> mesasOcupadas, ArrayList<Reserva> listaDeEspera) {
        this.mesasDisponiveis = mesasDisponiveis;
        this.mesasOcupadas = mesasOcupadas;
        this.listaDeEspera = listaDeEspera;
    }

    public ArrayList<Mesa> getMesasDisponiveis() {
        return mesasDisponiveis;
    }

    public void setMesasDisponiveis(ArrayList<Mesa> mesasDisponiveis) {
        this.mesasDisponiveis = mesasDisponiveis;
    }

    public ArrayList<Mesa> getMesasOcupadas() {
        return mesasOcupadas;
    }

    public void setMesasOcupadas(ArrayList<Mesa> mesasOcupadas) {
        this.mesasOcupadas = mesasOcupadas;
    }

    public ArrayList<Reserva> getListaDeEspera() {
        return listaDeEspera;
    }

    public void setListaDeEspera(ArrayList<Reserva> listaDeEspera) {
        this.listaDeEspera = listaDeEspera;
    }

    public void adicionaMesaOcupada(Mesa mesa) {
        mesasOcupadas.add(mesa); //adiciona a mesa a mesas ocupadas
    }

    public void liberaMesaOcupada(Mesa mesa) {
        mesasOcupadas.remove(mesa); //remove a mesa das mesas ocupadas
        adicionaMesaLivre(mesa); //adiciona a mesa as mesas livres
    }

    public void adicionaMesaLivre(Mesa mesa) {
        mesasDisponiveis.add(mesa); //adiciona a mesa as mesas livres
        verificaListaDeEspera(); //sempre que uma mesa ficar livre, faz a verificação da lista de espera
    }

    public boolean fazReservaDeMesa(Reserva reserva) {
        for (Mesa mesa : mesasDisponiveis) { //itera as mesas disponíveis
            if (mesa.getQuantCadeiras() >= reserva.getQuantPessoas()) { //se houver mesa disponível que atende a quantidade de pessoas:
                mesasOcupadas.add(mesa); //adiciona a mesa a mesas ocupadas
                mesasDisponiveis.remove(mesa); //remove a mesa de mesas disponíveis
                listaDeEspera.remove(reserva); //remove a reserva da lista de espera
                return true;
            }
        }
        return false; //retorna false se não tiver mesas disponíveis
    }

    public boolean verificaListaDeEspera() {
        for (Reserva reserva : listaDeEspera) { //itera as reservas da lista de espera
            if (fazReservaDeMesa(reserva)) { //verifica se alguma reserva da lista de espera pode ser alocada
                return true;
            }
        }
        return false; //retorna false se não tiver mesas disponíveis
    }
}
