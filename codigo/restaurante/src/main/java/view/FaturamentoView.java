package main.java.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class FaturamentoView extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnPesquisa;
    private JFormattedTextField dateField;

    public FaturamentoView() {
        setTitle("Faturamento");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // barra de pesquisa
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);

        // adicionar uma máscara para evitar erros ao adicionar uma data
        try {
            dateField = new JFormattedTextField(new javax.swing.text.MaskFormatter("####-##-##"));
            dateField.setColumns(10);
            dateField.setFont(new Font("Arial", Font.PLAIN, 14));
            dateField.setToolTipText("Digite a data no formato yyyy-mm-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JLabel dateLabel = new JLabel("Data (yyyy-mm-dd): ");
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        btnPesquisa = new JButton("Pesquisar");
        btnPesquisa.setFont(new Font("Arial", Font.BOLD, 14));
        toolBar.add(dateLabel);
        toolBar.add(dateField);
        toolBar.add(btnPesquisa);
        add(toolBar, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[] { "Data", "Faturamento" }, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // "css" da tabela
        table.setFillsViewportHeight(true);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(30);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBackground(Color.LIGHT_GRAY);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        add(tablePanel, BorderLayout.CENTER);

        setBackground(Color.WHITE);
        getContentPane().setBackground(Color.WHITE);
    }

    public JTable getTable() {
        return this.table;
    }

    public JButton getBtnPesquisa() {
        return this.btnPesquisa;
    }

    public JFormattedTextField getDateField() {
        return dateField;
    }

    public void setTableData(Object[][] data) {
        tableModel.setRowCount(0);
        for (Object[] row : data) {
            tableModel.addRow(row);
        }
    }
}
