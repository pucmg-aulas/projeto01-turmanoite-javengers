package main.java.controller;

import main.java.dao.Alimentos;
import main.java.model.Alimento;
import main.java.model.Bebida;
import main.java.model.Prato;
import main.java.view.AdicionarItemView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarItemController {
    private AdicionarItemView view;
    private Alimentos alimentos;

    public AdicionarItemController() {
        this.view = new AdicionarItemView();
        this.alimentos = Alimentos.getInstance();

        this.view.getSalvarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarItem();
            }
        });

        this.view.getCancelarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });

        this.view.setVisible(true);
    }

    private void salvarItem() {
        String nome = view.getNomeField().getText();
        String descricao = view.getDescricaoField().getText();
        double valor = Double.parseDouble(view.getValorField().getText());
        String tipo = view.getTipoComboBox().getSelectedItem().toString();
        int quantidade = Integer.parseInt(view.getQuantidadeField().getText());

        Alimento alimento;

        switch (tipo) {
            case "Prato":
                alimento = new Prato(quantidade, nome, descricao, valor);
                break;
            default:
                alimento = new Bebida(quantidade, nome, descricao, valor);
                break;
        }

        alimentos.addAlimento(alimento);
        
        cancelar();
    }

    private void cancelar() {
        this.view.dispose();
    }
}