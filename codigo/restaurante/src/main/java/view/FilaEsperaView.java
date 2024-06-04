package main.java.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.util.ArrayList;

import main.java.model.Atendimento;

public class FilaEsperaView extends JFrame {
    private JTable tabelaFilaEspera;
    private DefaultTableModel tableModel;

    public FilaEsperaView() {
        setTitle("Fila de Espera");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"Cliente", "Quantidade de Pessoas"}, 0);
        tabelaFilaEspera = new JTable(tableModel);
        tabelaFilaEspera.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tabelaFilaEspera);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void setFilaEspera(ArrayList<Atendimento> filaEspera) {
        tableModel.setRowCount(0);

        for (Atendimento atendimento : filaEspera) {
            Object[] row = {atendimento.getCliente().getNome(), atendimento.getQuantPessoas()};
            tableModel.addRow(row);
        }
    }
}
