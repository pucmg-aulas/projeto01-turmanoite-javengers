package main.java.controller;

import javax.swing.*;
import main.java.dao.Mesas;
import main.java.model.Mesa;
import main.java.view.AdicionarMesaView;

public class AdicionarMesaController {
    private final AdicionarMesaView view;
    private final Mesas mesas;

    public AdicionarMesaController() {
        this.mesas = Mesas.getInstance();
        this.view = new AdicionarMesaView();

        this.view.getBtnSalvar().addActionListener(e -> addMesa());
        this.view.getBtnCancelar().addActionListener(e -> cancelar());

        this.view.setTitle("Cadastrar Mesa");
        this.view.setVisible(true);
    }

    private void addMesa() {
        try {
            int quantCadeiras = Integer.parseInt(view.getTxtQuantCadeirasMesa().getText());

            if (quantCadeiras <= 0) throw new NumberFormatException("Número de cadeiras deve ser positivo.");

            Mesa m = new Mesa(quantCadeiras);
            mesas.addMesa(m);
            JOptionPane.showMessageDialog(view, "Mesa salva com sucesso!");
            limparTela();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Entrada inválida: " + e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelar() {
        this.view.dispose();
    }

    private void limparTela() {
        this.view.getTxtQuantCadeirasMesa().setText("");
    }
}
