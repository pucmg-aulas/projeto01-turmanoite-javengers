package main.java.controller;

import javax.swing.JOptionPane;

import main.java.dao.Clientes;
import main.java.model.Cliente;
import main.java.view.AdicionarClienteView;

public class AdicionarClienteController {
    private AdicionarClienteView view;
    private Clientes clientes;

    public AdicionarClienteController() {
        this.clientes = Clientes.getInstance();
        this.view = new AdicionarClienteView();

        this.view.getBtnSalvar().addActionListener((e) -> {
            addCliente();
        });

        this.view.getBtnCancelar().addActionListener((e) -> {
            cancelar();
        });

        this.view.setTitle("Cadastrar Cliente");
        this.view.setVisible(true);
    }

    public void addCliente(){
        String nome = view.getTxtNomeCliente().getText();
        String cpf = view.getTxtCpfCliente().getText();
        Cliente c = new Cliente(nome, cpf);
        clientes.addCliente(c);
        JOptionPane.showMessageDialog(view, "Cliente salvo com sucesso!");
        limparTela();
    }

    private void cancelar() {
        this.view.dispose();
    }

    private void limparTela(){
        this.view.getTxtNomeCliente().setText("");
        this.view.getTxtCpfCliente().setText("");
    }
}