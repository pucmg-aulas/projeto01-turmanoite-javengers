package main.java.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;

public class CardapioView extends JFrame {
    // tabela pra exibir o cardápio
    private JTable table;
    private DefaultTableModel tableModel;

    public JTable getTable() {
        return table;
    }

    public CardapioView() {
        setTitle("Cardápio");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        // criar a tabela pra mostrar o cardapio
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
}
