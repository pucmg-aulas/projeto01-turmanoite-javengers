package main.java.controller;

import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import main.java.dao.Atendimentos;
import main.java.dao.Clientes;
import main.java.model.Atendimento;
import main.java.model.Cliente;
import main.java.view.AdicionarClienteView;

public class AdicionarClienteController {
    private AdicionarClienteView view;
    private Clientes clientes;
    private Atendimentos atendimentos;

    public AdicionarClienteController() {
        this.clientes = Clientes.getInstance();
        this.atendimentos = Atendimentos.getInstance();
        this.view = new AdicionarClienteView();

        this.view.getBtnSalvar().addActionListener((e) -> {
            addCliente();
        });

        this.view.getBtnVoltar().addActionListener((e) -> {
            cancelar();
        });

        this.view.setTitle("Cadastrar Cliente");
        this.view.setVisible(true);
    }

    public void addCliente() {
        String nome = view.getTxtNomeCLiente().getText();
        String cpf = view.getNumCPFCliente().getText();
        Cliente c = new Cliente(nome, cpf);
        clientes.addCliente(c);
        addAtendimento(c);
    }

    public void addAtendimento(Cliente c) {
        int quantidade = (Integer) view.getNumQuantidadePessoas().getValue();
        Atendimento a = new Atendimento(c, quantidade, LocalDateTime.now());
        System.out.println(a.toString());
        atendimentos.addAtendimento(a);
        JOptionPane.showMessageDialog(view, "Cliente salvo com sucesso!");
        limparTela();
    }

    private void cancelar() {
        this.view.dispose();
    }

    private void limparTela() {
        this.view.getTxtNomeCLiente().setText("");
        this.view.getNumCPFCliente().setText("");
    }
}