package main.java.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class FazerPedidoView extends JFrame {
    private JTable cardapioTable;
    private DefaultTableModel tableModel;
    private JTextField quantidadeTextField;
    private JButton salvarPedidoButton;

    public FazerPedidoView() {
        setTitle("Fazer Pedido");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tabela do cardápio
        tableModel = new DefaultTableModel(new Object[]{"Nome", "Descrição", "Valor"}, 0);
        cardapioTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(cardapioTable);

        // "css" da tabela
        cardapioTable.setFillsViewportHeight(true);
        cardapioTable.setFont(new Font("Arial", Font.PLAIN, 14));
        cardapioTable.setRowHeight(30);

        // cabeçalho da tabela
        JTableHeader header = cardapioTable.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBackground(Color.LIGHT_GRAY);

        // Seção do botão e quantidade
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        quantidadeTextField = new JTextField(10);
        quantidadeTextField.setPreferredSize(new Dimension(100, 30));
        salvarPedidoButton = new JButton("Salvar Pedido");
        salvarPedidoButton.setFont(new Font("Arial", Font.BOLD, 14));
        salvarPedidoButton.setPreferredSize(new Dimension(150, 30));

        bottomPanel.add(new JLabel("Quantidade:"));
        bottomPanel.add(quantidadeTextField);
        bottomPanel.add(salvarPedidoButton);

        // Adicionar os componentes ao layout principal
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Cor do fundo
        setBackground(Color.WHITE);
        getContentPane().setBackground(Color.WHITE);
    }

    public JTable getCardapioTable() {
        return cardapioTable;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JTextField getQuantidadeTextField() {
        return quantidadeTextField;
    }

    public JButton getSalvarPedidoButton() {
        return salvarPedidoButton;
    }
}
