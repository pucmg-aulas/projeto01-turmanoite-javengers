package main.java.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import main.java.model.Atendimento;

public class Historico extends AbstractDao implements Serializable {

    private List<Atendimento> historico;
    private static Historico instance;

    private final String localArquivo = "./codigo/restaurante/src/main/java/data/Historico.dat";

    private Historico() {
        this.historico = new ArrayList<>();
        carregaAtendimentos();
    }

    public static Historico getInstance() {
        if (instance == null) {
            instance = new Historico();
        }
        return instance;
    }

    public void addAtendimento(Atendimento atendimento) {
        try {
            this.historico.add(atendimento);
            grava();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void carregaAtendimentos() {
        try {
            this.historico = super.leitura(localArquivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void grava() {
        try {
            super.grava(localArquivo, historico);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Atendimento> getAtendimentos() {
        return historico;
    }

    public void excluirAtendimento(Atendimento atendimento) {
        try {
            historico.remove(atendimento);
            grava();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Atendimento buscarAtendimentoPorCpf(String cpf) {
        try {
            return historico.stream()
                    .filter(atendimento -> atendimento.getCliente().getCpf().equals(cpf))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Atendimento buscarPagamentoPorData(LocalDate data) {
        try {
            return historico.stream()
                    .filter(atendimento -> atendimento.getData().equals(data))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean altera(Atendimento atendimentoExistente, String cpf) {
        try {
            ArrayList<Atendimento> listaTemp = new ArrayList<Atendimento>();

            listaTemp = historico.stream()
                    .filter(atendimento -> !atendimento.getCliente().getCpf().equals(cpf))
                    .collect(Collectors.toCollection(ArrayList::new));
            listaTemp.add(atendimentoExistente);

            historico.removeAll(historico);
            historico.addAll(listaTemp);
            grava();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
