package main.java.controller;

import main.java.dao.*;
import main.java.model.*;
import main.java.view.EncerrarAtendimentoView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.LocalTime;

public class EncerrarAtendimentoController {
    private final EncerrarAtendimentoView view;
    private final Atendimento atendimento;
    private final Atendimentos atendimentos;
    private final Historico historico;
    private final Clientes clientes;
    private final Mesas mesas;
    private final Pagamentos pagamentos;

    public EncerrarAtendimentoController(Atendimento atendimento) {
        this.atendimento = atendimento;
        this.view = new EncerrarAtendimentoView();
        this.clientes = Clientes.getInstance();
        this.atendimentos = Atendimentos.getInstance();
        this.mesas = Mesas.getInstance();
        this.historico = Historico.getInstance();
        this.pagamentos = Pagamentos.getInstance();

        this.view.getBtnFinalizarAtendimento().addActionListener(e -> encerrarAtendimento());
        this.view.getBtnVoltar().addActionListener(e -> cancelar());
        this.view.getBtnExcluirItemComanda().addActionListener(e -> excluirItem());
        this.view.getBtnCalcularValor().addActionListener(e -> calcularValorTotal());

        carregaTela();
        this.view.setVisible(true);
    }

    private void carregaTela() {
        view.getTxtNomeCliente().setText(atendimento.getCliente().getNome());
        view.getNumQuantidadePessoas().setText(String.valueOf(atendimento.getQuantPessoas()));
        view.getNumValorTotal().setText(String.format("%.2f", atendimento.getComanda().calculaValor())); // Format with
                                                                                                         // 2 decimal
                                                                                                         // places
        carregaComanda();
    }

    private void carregaComanda() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Quantidade", "Item", "Valor Unitário", "Quantidade", "Valor Total" }, 0);

        atendimento.getComanda().getPedidos().forEach(p -> {
            String[] linha = p.toString().split("%");
            model.addRow(new Object[] { linha[1], linha[2], linha[3], linha[4], linha[5] });
        });

        view.getTableContaCliente().setModel(model);
    }

    private void excluirItem() {
        int linha = view.getTableContaCliente().getSelectedRow();
        if (linha >= 0) { // Check if a row is selected
            atendimento.getComanda().getPedidos().remove(linha);
            atendimentos.altera(atendimento, atendimento.getCliente().getCpf());
            carregaTela();
        }
    }

    private void encerrarAtendimento() {
        String nome = atendimento.getCliente().getNome();
        int option = JOptionPane.showConfirmDialog(view, "Deseja encerrar o atendimento do cliente " + nome + "?");

        if (option == JOptionPane.YES_OPTION) {
            String cpf = atendimento.getCliente().getCpf();
            clientes.excluirCliente(clientes.buscarClientePorCpf(cpf));
            mesas.buscarMesaPorNumero(atendimento.getMesa().getNumero()).setOcupada(false);
            atendimentos.excluirAtendimento(atendimento);

            atendimento.setHoraSaida(LocalTime.now());
            atendimento.setMetodoPagamento(getMetodoPagamento());
            historico.addAtendimento(atendimento);

            double valorFinal = atendimento.getComanda().calculaValor() -
                    atendimento.getMetodoPagamento().calcularDesconto(atendimento.getComanda().calculaValor());
            pagamentos.addPagamento(new Pagamento(valorFinal, LocalDate.now()));

            JOptionPane.showMessageDialog(view, "Atendimento do cliente " + nome + " encerrado com sucesso!");
            cancelar(); // Close the view after ending the service
        }
    }

    private MetodoPagamento getMetodoPagamento() {
        String pagamento = (String) this.view.getSelectPagamento().getSelectedItem();
        switch (pagamento) {
            case ("Dinheiro"):
                return new Dinheiro();
            case ("Pix"):
                return new Pix();
            case ("Crédito"):
                return new Credito();
            case ("Débito"):
                return new Debito();
            default:
                return new Dinheiro();
        }
    }

    private void calcularValorTotal() {
        this.view.getNumValorTotal().setText(String.valueOf(atendimento.getComanda().calculaValor()));
    }

    private void cancelar() {
        this.view.dispose();
    }
}
