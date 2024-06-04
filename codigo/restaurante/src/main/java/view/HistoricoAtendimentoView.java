package main.java.view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

public class HistoricoAtendimentoView extends JFrame{
    private JTable tabelaAtendimentos;
    private JScrollPane scrollPane;
    private JTextField campoPesquisa;
    private JButton botaoPesquisar;
    private JTable tabelaHistorico;
    private DefaultTableModel tableModel;
    
    public HistoricoAtendimentoView () {
        setTitle("Histórico de Atendimentos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        tabelaAtendimentos = new JTable();
        scrollPane = new JScrollPane(tabelaAtendimentos);
        add(scrollPane, BorderLayout.CENTER);

        JToolBar barraFerramentas = new JToolBar();
        campoPesquisa = new JTextField(20);
        botaoPesquisar = new JButton("Pesquisar");
        barraFerramentas.add(campoPesquisa);
        barraFerramentas.add(botaoPesquisar);
        add(barraFerramentas, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[] { "CPF", "Nome", "Data" }, 0);
        tabelaHistorico = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabelaHistorico);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        // Crie uma instância da view
        HistoricoAtendimentoView view = new HistoricoAtendimentoView(); // Crie um controller mock para teste

        // Defina a view como visível
        view.setVisible(true);
    }
}
