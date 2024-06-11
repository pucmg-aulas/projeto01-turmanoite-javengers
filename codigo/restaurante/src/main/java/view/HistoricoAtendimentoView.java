package main.java.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HistoricoAtendimentoView extends JFrame {
    private JTable tabelaHistorico;
    private DefaultTableModel tableModel;
    private JFormattedTextField campoPesquisa;
    private JButton btnPesquisa;

    public HistoricoAtendimentoView() {
        setTitle("Histórico de Atendimentos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // barra com a pesquisa
        JToolBar barraFerramentas = new JToolBar();
        barraFerramentas.setFloatable(false);
        try {
            campoPesquisa = new JFormattedTextField(new javax.swing.text.MaskFormatter("##/##/####"));
            campoPesquisa.setColumns(20);
            campoPesquisa.setFont(new Font("Arial", Font.PLAIN, 14));
            campoPesquisa.setToolTipText("Digite a data no formato dd/MM/yyyy");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JLabel dateLabel = new JLabel("Data (dd/MM/yyyy): ");
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        btnPesquisa = new JButton("Pesquisar");
        btnPesquisa.setFont(new Font("Arial", Font.BOLD, 14));
        barraFerramentas.add(dateLabel);
        barraFerramentas.add(campoPesquisa);
        barraFerramentas.add(btnPesquisa);
        add(barraFerramentas, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"CPF", "Nome", "Data"}, 0);
        tabelaHistorico = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabelaHistorico);

        // "css" da tabela
        tabelaHistorico.setFillsViewportHeight(true);
        tabelaHistorico.setFont(new Font("Arial", Font.PLAIN, 14));
        tabelaHistorico.setRowHeight(30);

        JTableHeader header = tabelaHistorico.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBackground(Color.LIGHT_GRAY);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        add(tablePanel, BorderLayout.CENTER);

        setBackground(Color.WHITE);
        getContentPane().setBackground(Color.WHITE);
    }

    public JTable getTabelaHistorico() {
        return tabelaHistorico;
    }

    public JFormattedTextField getCampoPesquisa() {
        return campoPesquisa;
    }

    public JButton getBotaoPesquisar() {
        return btnPesquisa;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public Date getSelectedDate() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            return sdf.parse(campoPesquisa.getText());
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
