package main.java.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.text.ParseException;

public class HistoricoAtendimentoView extends JFrame {
    private JTable tabelaHistorico;
    private DefaultTableModel tableModel;
    private JFormattedTextField campoPesquisa;
    private JButton btnPesquisa;
    private JButton btnExportar;

    public HistoricoAtendimentoView() {
        setTitle("Histórico de Atendimentos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // barra com a pesquisa
        JToolBar barraFerramentas = new JToolBar();
        barraFerramentas.setFloatable(false);

        try {
            campoPesquisa = new JFormattedTextField(new javax.swing.text.MaskFormatter("####-##-##"));
            campoPesquisa.setColumns(10);
            campoPesquisa.setFont(new Font("Arial", Font.PLAIN, 14));
            campoPesquisa.setToolTipText("Digite a data no formato yyyy-mm-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JLabel dateLabel = new JLabel("Data (yyyy-mm-dd): ");
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        btnPesquisa = new JButton("Pesquisar");
        btnPesquisa.setFont(new Font("Arial", Font.BOLD, 14));

        btnExportar = new JButton("Exportar Historico");
        btnExportar.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.add(dateLabel);
        leftPanel.add(campoPesquisa);
        leftPanel.add(btnPesquisa);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.add(btnExportar);

        JPanel toolBarPanel = new JPanel(new BorderLayout());
        toolBarPanel.add(leftPanel, BorderLayout.WEST);
        toolBarPanel.add(rightPanel, BorderLayout.EAST);

        barraFerramentas.add(toolBarPanel);
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

    public JButton getBotaoExportar() {
        return btnExportar;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
