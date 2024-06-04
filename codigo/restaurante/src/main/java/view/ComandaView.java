package main.java.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

import main.java.model.Comanda;
import main.java.model.Pedido;

public class ComandaView extends JFrame {
    private JTable tabelaPedidos;
    private DefaultTableModel tableModel;

    public ComandaView() {
        setTitle("Comanda do Cliente");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[] { "Quantidade", "Item", "Valor" }, 0);
        tabelaPedidos = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabelaPedidos);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void setComanda(Comanda comanda) {
        tableModel.setRowCount(0); // limpa a tela

        for (Pedido pedido : comanda.getPedidos()) {
            Object[] row = { pedido.getQuantidade(), pedido.getAlimento(), pedido.getValorTotal() };
            tableModel.addRow(row);
        }
    }
}
