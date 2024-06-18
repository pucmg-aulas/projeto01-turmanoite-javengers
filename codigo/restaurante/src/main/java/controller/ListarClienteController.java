package main.java.controller;

import main.java.dao.Atendimentos;
import main.java.dao.Clientes;
import main.java.dao.Mesas;
import main.java.model.Atendimento;
import main.java.model.Cliente;
import main.java.view.ListarClienteView;

import java.util.List;
import java.util.Optional;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListarClienteController {
    private final ListarClienteView view;
    private final Clientes clientes;
    private final Atendimentos atendimentos;
    private final Mesas mesas;

    public ListarClienteController() {
        this.clientes = Clientes.getInstance();
        this.atendimentos = Atendimentos.getInstance();
        this.mesas = Mesas.getInstance();
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

        List<Cliente> clienteList = clientes.getClientes();
        clienteList.stream()
                .map(cliente -> new Object[] { cliente.getNome(), cliente.getCpf() })
                .forEach(model::addRow);

        view.getTbClientes().setModel(model);
    }

    private void excluirCliente() {
        int selectedRow = view.getTbClientes().getSelectedRow();

        if (selectedRow >= 0) {
            String cpf = (String) view.getTbClientes().getValueAt(selectedRow, 1);
            int option = JOptionPane.showConfirmDialog(view, "Deseja excluir o cliente com CPF " + cpf + "?");

            if (option == JOptionPane.YES_OPTION) {
                try {
                    Cliente cliente = clientes.buscarClientePorCpf(cpf)
                            .orElseThrow(() -> new Exception("Cliente não encontrado"));
                    clientes.excluirCliente(cliente);

                    Optional<Atendimento> atendimentoOpt = atendimentos.buscarAtendimentoPorCpf(cpf);
                    if (atendimentoOpt.isPresent()) {
                        Atendimento atendimento = atendimentoOpt.get();
                        mesas.buscarMesaPorNumero(atendimento.getMesa().getNumero()).setOcupada(false);
                        atendimentos.excluirAtendimento(atendimento);
                    }
                    JOptionPane.showMessageDialog(view, "Cliente com CPF " + cpf + " excluído com sucesso!");
                    carregaTabela();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(view, "Erro ao excluir cliente: " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(view, "Selecione uma linha primeiro!");
        }
    }

    private void fazerPedido() {
        int linha = this.view.getTbClientes().getSelectedRow();
        String cpf = (String) this.view.getTbClientes().getValueAt(linha, 1);
        Optional<Atendimento> atendimentoOpt = atendimentos.buscarAtendimentoPorCpf(cpf);
        if (atendimentoOpt.isPresent()) {
            new FazerPedidoController(atendimentoOpt.get());
        } else {
            JOptionPane.showMessageDialog(view, "Atendimento não encontrado para o CPF " + cpf);
        }
    }

    private void listarComanda() {
        int linha = this.view.getTbClientes().getSelectedRow();
        String cpf = (String) this.view.getTbClientes().getValueAt(linha, 1);
        Optional<Atendimento> atendimentoOpt = atendimentos.buscarAtendimentoPorCpf(cpf);
        if (atendimentoOpt.isPresent()) {
            new ListarComandaController(atendimentoOpt.get());
        } else {
            JOptionPane.showMessageDialog(view, "Atendimento não encontrado para o CPF " + cpf);
        }
    }

    private void fecharComanda() {
        int linha = this.view.getTbClientes().getSelectedRow();
        String cpf = (String) this.view.getTbClientes().getValueAt(linha, 1);
        Optional<Atendimento> atendimentoOpt = atendimentos.buscarAtendimentoPorCpf(cpf);
        if (atendimentoOpt.isPresent()) {
            new EncerrarAtendimentoController(atendimentoOpt.get());
            this.view.dispose();
        } else {
            JOptionPane.showMessageDialog(view, "Atendimento não encontrado para o CPF " + cpf);
        }
    }
}