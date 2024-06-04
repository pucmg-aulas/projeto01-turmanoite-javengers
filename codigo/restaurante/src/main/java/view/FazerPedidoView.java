package main.java.view;

import javax.swing.*;

import main.java.model.Alimento;

import java.awt.*;

public class FazerPedidoView extends JFrame {

    private JComboBox itemComboBox;
    private JTextField quantidadeTextField;
    private JButton salvarPedidoButton;;

    public FazerPedidoView() {

        setTitle("Fazer Pedido");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel selecaoItemPanel = new JPanel();
        selecaoItemPanel.setLayout(new FlowLayout());

        itemComboBox = new JComboBox<Alimento[]>();
        selecaoItemPanel.add(itemComboBox);

        JPanel quantidadeEBotaoPanel = new JPanel();
        quantidadeEBotaoPanel.setLayout(new FlowLayout());

        quantidadeTextField = new JTextField(10);
        quantidadeEBotaoPanel.add(quantidadeTextField);

        salvarPedidoButton = new JButton("Salvar Pedido");
        quantidadeEBotaoPanel.add(salvarPedidoButton);

        add(selecaoItemPanel, BorderLayout.NORTH);
        add(quantidadeEBotaoPanel, BorderLayout.CENTER);
    }

    public JComboBox getItemComboBox() {
        return this.itemComboBox;
    }

    public JTextField getQuantidadeTextField() {
        return this.quantidadeTextField;
    }

    public JButton getSalvarPedidoButton() {
        return this.salvarPedidoButton;
    }

    public void setQuantidade(int quantidade) {
        quantidadeTextField.setText(String.valueOf(quantidade));
    }
}