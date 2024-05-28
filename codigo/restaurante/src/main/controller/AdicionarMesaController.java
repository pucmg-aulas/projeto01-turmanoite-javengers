package main.controller;

import javax.swing.JOptionPane;

import main.java.dao.Mesas;
import main.java.model.Mesa;
import main.java.view.AdicionarMesaView;

public class AdicionarMesaController {
    private AdicionarMesaView view;
    private Mesas mesas;

    public IncluirMesaController() {
        this.mesas = Mesas.getInstance();
        this.view = new AdicionarMesaView();

        this.view.getBtnSalvar().addActionListener((e) -> {
            addMesa();
        });

        this.view.getBtnCancelar().addActionListener((e) -> {
            cancelar();
        });

        this.view.setTitle("Cadastrar Mesa");
        this.view.setVisible(true);
    }

    public void addMesa(){
        int numero = Integer.parseInt(view.getTxtNumeroMesa().getText());
        Mesa m = new Mesa(numero);
        mesas.addMesa(m);
        JOptionPane.showMessageDialog(view, "Mesa salva com sucesso!");
        limparTela();
    }

    private void cancelar() {
        this.view.dispose();
    }

    private void limparTela(){
        this.view.getTxtNumeroMesa().setText("");
    }
}