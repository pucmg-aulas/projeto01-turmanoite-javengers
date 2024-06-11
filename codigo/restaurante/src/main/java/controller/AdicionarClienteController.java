package main.java.controller;

import main.java.dao.*;
import main.java.model.*;
import main.java.view.AdicionarClienteView;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

public class AdicionarClienteController {
    private final AdicionarClienteView view;
    private final Clientes clientes;
    private final FilaDeEspera filaDeEspera;
    private final Mesas mesas;

    public AdicionarClienteController() {
        this.view = new AdicionarClienteView();
        this.clientes = Clientes.getInstance();
        this.mesas = Mesas.getInstance();
        this.filaDeEspera = FilaDeEspera.getInstance();

        this.view.getBtnSalvar().addActionListener(e -> addCliente());
        this.view.getBtnVoltar().addActionListener(e -> cancelar());

        this.view.setTitle("Cadastrar Cliente");
        this.view.setVisible(true);
    }

    private void addCliente() {
        String nome = view.getTxtNomeCLiente().getText();
        String cpf = view.getNumCPFCliente().getText();
        Cliente cliente = new Cliente(nome, cpf);

        addAtendimento(cliente);
    }

    private void addAtendimento(Cliente cliente) {
        int quantidade = (Integer) view.getNumQuantidadePessoas().getValue();
        Atendimento atendimento = new Atendimento(cliente, quantidade);

        List<Mesa> mesasDisponiveis = mesasDisponiveis(quantidade);
        if (!mesasDisponiveis.isEmpty()) {
            new EscolherMesaController(atendimento, mesasDisponiveis);
        } else {
            clientes.addCliente(cliente);
            filaDeEspera.addAtendimento(atendimento);
            JOptionPane.showMessageDialog(view, "Nenhuma mesa disponível. Cliente na fila de espera!");
        }
        cancelar();
    }

    private void cancelar() {
        this.view.dispose();
    }

    private List<Mesa> mesasDisponiveis(int quantidade) {
        return mesas.getMesas().stream()
                .filter(mesa -> !mesa.isOcupada() && mesa.getQuantCadeiras() >= quantidade)
                .collect(Collectors.toList());
    }
}
