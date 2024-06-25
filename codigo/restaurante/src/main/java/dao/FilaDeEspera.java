package main.java.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import main.java.model.Atendimento;

public class FilaDeEspera extends AbstractDao implements Serializable {

    private List<Atendimento> filaDeEspera;
    private static FilaDeEspera instance;

    private final String localArquivo = "./codigo/restaurante/src/main/java/data/FilaDeEspera.dat";

    private FilaDeEspera() {
        this.filaDeEspera = new ArrayList<>();
        carregaAtendimentos();
    }

    public static FilaDeEspera getInstance() {
        if (instance == null) {
            instance = new FilaDeEspera();
        }
        return instance;
    }

    public void addAtendimento(Atendimento atendimento) {
        try {
            this.filaDeEspera.add(atendimento);
            grava();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void carregaAtendimentos() {
        try {
            this.filaDeEspera = super.leitura(localArquivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void grava() {
        try {
            super.grava(localArquivo, filaDeEspera);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Atendimento> getAtendimentos() {
        return filaDeEspera;
    }

    public void excluirAtendimento(Atendimento atendimento) {
        try {
            filaDeEspera.remove(atendimento);
            grava();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Atendimento buscarAtendimentoPorCpf(String cpf) {
        try {
            return filaDeEspera.stream()
                    .filter(atendimento -> atendimento.getCliente().getCpf().equals(cpf))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean altera(Atendimento atendimentoExistente, String cpf) {
        try {
            List<Atendimento> listaTemp = new ArrayList<Atendimento>();

            listaTemp = filaDeEspera.stream()
                    .filter(atendimento -> !atendimento.getCliente().getCpf().equals(cpf))
                    .collect(Collectors.toList());
            listaTemp.add(atendimentoExistente);

            filaDeEspera.removeAll(filaDeEspera);
            filaDeEspera.addAll(listaTemp);
            grava();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
