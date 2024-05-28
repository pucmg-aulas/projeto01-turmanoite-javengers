package main.java.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import main.java.model.Comanda;

public class Comandas extends AbstractDao implements Serializable {

    private List<Comanda> comandas;
    private static Comandas instance;

    private final String localArquivo = "./src/main/java/data/Comandas.dat";

    private Comandas() {
        this.comandas = new ArrayList<>();
        carregaComandas();
    }

    public static Comandas getInstance() {
        if (instance == null) {
            instance = new Comandas();
        }
        return instance;
    }

    public void addComanda(Comanda comanda) {
        this.comandas.add(comanda);
        grava();
    }

    private void carregaComandas() {
        this.comandas = super.leitura(localArquivo);
    }

    private void grava() {
        super.grava(localArquivo, comandas);
    }

    public List<Comanda> getComandas() {
        return comandas;
    }

    public void excluirComanda(Comanda comanda) {
        comandas.remove(comanda);
        grava();
    }
}
