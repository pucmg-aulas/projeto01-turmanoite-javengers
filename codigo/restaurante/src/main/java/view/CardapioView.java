package main.java.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import main.java.model.Alimento;

import java.awt.BorderLayout;

import java.util.List;

public class CardapioView extends JFrame {
    // tabela pra exibir o cardápio
    private JTable table;
    private DefaultTableModel tableModel;

    public CardapioView() {
        setTitle("Cardápio");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        // criar a tabela pra mostrar o cardapio
        tableModel = new DefaultTableModel(new Object[] { "Nome", "Descrição", "Valor" }, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void setCardapio(List<Alimento> cardapio) {
        tableModel.setRowCount(0); // limpa a tela

        for (Alimento alimento : cardapio) {
            tableModel.addRow(new Object[] { alimento.getNome(), alimento.getDescricao(), alimento.getValor() });
        }
    }
}
