package main.java.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import main.java.model.Atendimento;
import main.java.model.Cliente;

public class Atendimentos extends AbstractDao implements Serializable {

    private List<Atendimento> atendimentos;
    private static Atendimentos instance;

    private final String localArquivo = "./codigo/restaurante/src/main/java/data/Atendimentos.dat";

    private Atendimentos() {
        this.atendimentos = new ArrayList<>();
        carregaAtendimentos();
    }

    public static Atendimentos getInstance() {
        if (instance == null) {
            instance = new Atendimentos();
        }
        return instance;
    }

    public void addAtendimento(Atendimento atendimento) {
        this.atendimentos.add(atendimento);
        grava();
    }

    private void carregaAtendimentos() {
        this.atendimentos = super.leitura(localArquivo);
    }

    private void grava() {
        super.grava(localArquivo, atendimentos);
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void excluirAtendimento(Atendimento atendimento) {
        atendimentos.remove(atendimento);
        grava();
    }

    public Atendimento buscarAtendimentoPorCliente(Cliente cliente) {
        for (Atendimento atendimento : atendimentos) {
            if (atendimento.getCliente().equals(cliente))
                return atendimento;
        }
        return null;
    }
}
