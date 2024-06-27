package main.java.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.text.ParseException;

public class FaturamentoView extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnPesquisa;
    private JButton btnExportar;
    private JFormattedTextField dateField;

    public FaturamentoView() {
        setTitle("Faturamento");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // barra de pesquisa
        JToolBar barraFerramentas = new JToolBar();
        barraFerramentas.setFloatable(false);

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

        btnExportar = new JButton("Exportar Faturamento");
        btnExportar.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.add(dateLabel);
        leftPanel.add(dateField);
        leftPanel.add(btnPesquisa);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.add(btnExportar);

        JPanel toolBarPanel = new JPanel(new BorderLayout());
        toolBarPanel.add(leftPanel, BorderLayout.WEST);
        toolBarPanel.add(rightPanel, BorderLayout.EAST);

        barraFerramentas.add(toolBarPanel);
        add(barraFerramentas, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"Data", "Faturamento"}, 0);
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

    public JButton getBtnExportar() {
        return this.btnExportar;
    }

    public JFormattedTextField getDateField() {
        return dateField;
    }
}
