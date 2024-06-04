package main.java.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

public class ComandaView extends JFrame {
    private JTable tabelaPedidos;
    private DefaultTableModel tableModel;

    public JTable getTabelaPedidos() {
        return tabelaPedidos;
    }

    public ComandaView() {
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        tabelaPedidos = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabelaPedidos);
        add(scrollPane, BorderLayout.CENTER);
    }

}
