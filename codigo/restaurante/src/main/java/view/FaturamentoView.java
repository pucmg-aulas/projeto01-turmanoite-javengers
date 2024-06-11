package main.java.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FaturamentoView extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnPesquisa;
    private JFormattedTextField dateField;

    public FaturamentoView() {
        setTitle("Faturamento Diário");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // barra de pesquisa
        JToolBar barraFerramentas = new JToolBar();
        barraFerramentas.setFloatable(false);

        // adicionar uma máscara para evitar erros ao adicionar uma data
        try {
            dateField = new JFormattedTextField(new javax.swing.text.MaskFormatter("##/##/####"));
            dateField.setColumns(10);
            dateField.setFont(new Font("Arial", Font.PLAIN, 14));
            dateField.setToolTipText("Digite a data no formato dd/MM/yyyy");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JLabel dateLabel = new JLabel("Data (dd/MM/yyyy): ");
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        btnPesquisa = new JButton("Pesquisar");
        btnPesquisa.setFont(new Font("Arial", Font.BOLD, 14));
        barraFerramentas.add(dateLabel);
        barraFerramentas.add(dateField);
        barraFerramentas.add(btnPesquisa);
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

    public Date getSelectedDate() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/0yyyy", Locale.getDefault());
            return sdf.parse(dateField.getText());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setTableData(Object[][] data) {
        tableModel.setRowCount(0);
        for (Object[] row : data) {
            tableModel.addRow(row);
        }
    }
}
