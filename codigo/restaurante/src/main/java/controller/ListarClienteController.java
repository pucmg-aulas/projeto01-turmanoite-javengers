package main.java.controller;

import main.java.dao.Atendimentos;
import main.java.dao.Clientes;
import main.java.model.Atendimento;
import main.java.view.ListarClienteView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListarClienteController {
    private final ListarClienteView view;
    private final Clientes clientes;
    private final Atendimentos atendimentos;

    public ListarClienteController() {
        this.clientes = Clientes.getInstance();
        this.atendimentos = Atendimentos.getInstance();
        this.view = new ListarClienteView();

        carregaTabela();

        this.view.getBtnExcluir().addActionListener(e -> excluirCliente());
        this.view.getBtnFazerPedido().addActionListener(e -> fazerPedido());
        this.view.getBtnComanda().addActionListener(e -> listarComanda());
        this.view.getBtnEncerrar().addActionListener(e -> fecharComanda());
        this.view.getBtnVoltar().addActionListener(e -> sair());

        this.view.setVisible(true);
    }

    private void sair() {
        this.view.dispose();
    }

    private void carregaTabela() {
        DefaultTableModel model = new DefaultTableModel(new Object[] { "Nome", "CPF" }, 0);

        clientes.getClientes().forEach(cliente -> model.addRow(new Object[] { cliente.getNome(), cliente.getCpf() }));
        view.getTbClientes().setModel(model);
    }

    private void excluirCliente() {
        int selectedRow = view.getTbClientes().getSelectedRow();

        if (selectedRow >= 0) {
            String cpf = (String) view.getTbClientes().getValueAt(selectedRow, 1);
            int option = JOptionPane.showConfirmDialog(view, "Deseja excluir o cliente com CPF " + cpf + "?");

            if (option == JOptionPane.YES_OPTION) {
                clientes.excluirCliente(clientes.buscarClientePorCpf(cpf));
                Atendimento atendimento = atendimentos.buscarAtendimentoPorCpf(cpf);
                if (atendimento != null) { // Check if the client has an ongoing service
                    atendimentos.excluirAtendimento(atendimento);
                }
                JOptionPane.showMessageDialog(view, "Cliente com CPF " + cpf + " excluído com sucesso!");
                carregaTabela();
            }
        } else {
            JOptionPane.showMessageDialog(view, "Selecione uma linha primeiro!");
        }
    }

    private void fazerPedido() {
        int linha = this.view.getTbClientes().getSelectedRow();
        String cpf = (String) this.view.getTbClientes().getValueAt(linha, 1);
        Atendimento atendimento = atendimentos.buscarAtendimentoPorCpf(cpf);
        new FazerPedidoController(atendimento);
    }

    private void listarComanda() {
        int linha = this.view.getTbClientes().getSelectedRow();
        String cpf = (String) this.view.getTbClientes().getValueAt(linha, 1);
        Atendimento atendimento = atendimentos.buscarAtendimentoPorCpf(cpf);
        new ListarComandaController(atendimento);
    }

    private void fecharComanda() {
        int linha = this.view.getTbClientes().getSelectedRow();
        String cpf = (String) this.view.getTbClientes().getValueAt(linha, 1);
        Atendimento atendimento = atendimentos.buscarAtendimentoPorCpf(cpf);
        new EncerrarAtendimentoController(atendimento);
    }
}