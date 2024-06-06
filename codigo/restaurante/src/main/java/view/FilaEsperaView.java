package main.java.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

public class FilaEsperaView extends JFrame {
    private JTable tabelaFilaEspera;
    private DefaultTableModel tableModel;

    public JTable getTabelaFilaEspera() {
        return tabelaFilaEspera;
    }

    public void setTabelaFilaEspera(JTable tabelaFilaEspera) {
        this.tabelaFilaEspera = tabelaFilaEspera;
    }

    public FilaEsperaView() {
        setTitle("Fila de Espera");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[] { "Cliente", "Quantidade de Pessoas" }, 0);
        tabelaFilaEspera = new JTable(tableModel);
        tabelaFilaEspera.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tabelaFilaEspera);
        add(scrollPane, BorderLayout.CENTER);
    }
}
