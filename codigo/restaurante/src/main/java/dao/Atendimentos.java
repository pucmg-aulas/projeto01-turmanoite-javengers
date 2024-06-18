package main.java.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import main.java.model.Atendimento;

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

    public Optional<Atendimento> buscarAtendimentoPorCpf(String cpf) {
        return atendimentos.stream()
                           .filter(atendimento -> atendimento.getCliente().getCpf().equals(cpf))
                           .findFirst();
    }

    public boolean altera(Atendimento atendimentoExistente, String cpf) {
        try {
            atendimentos = atendimentos.stream()
                                       .map(atendimento -> atendimento.getCliente().getCpf().equals(cpf) ? atendimentoExistente : atendimento)
                                       .collect(Collectors.toList());
            grava();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
