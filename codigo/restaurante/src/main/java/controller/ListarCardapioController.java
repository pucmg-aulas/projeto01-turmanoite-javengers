package main.java.controller;

import main.java.dao.Alimentos;
import main.java.view.CardapioView;

import javax.swing.table.DefaultTableModel;

public class ListarCardapioController {
    private final CardapioView view;
    private final Alimentos alimentos;

    public ListarCardapioController() {
        this.alimentos = Alimentos.getInstance();
        this.view = new CardapioView();
        carregaTabela();
        this.view.setVisible(true);
    }

    private void carregaTabela() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Nome", "Descrição", "Valor" }, 0);

        alimentos.getAlimentos().forEach(alimento -> model.addRow(new Object[] {
                alimento.getNome(),
                alimento.getDescricao(),
                alimento.getValor()
        }));

        view.getTable().setModel(model);
    }
}
