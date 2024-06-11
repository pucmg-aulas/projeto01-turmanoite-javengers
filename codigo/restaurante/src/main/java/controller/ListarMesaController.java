package main.java.controller;

import main.java.dao.Mesas;
import main.java.model.Mesa;
import main.java.view.ListarMesaView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListarMesaController {
    private final ListarMesaView view;
    private final Mesas mesas;

    public ListarMesaController() {
        this.mesas = Mesas.getInstance();
        this.view = new ListarMesaView();

        carregaTabela();

        this.view.getBtnExcluir().addActionListener(e -> excluirMesa());
        this.view.getBtnVoltar().addActionListener(e -> sair());

        this.view.setVisible(true);
    }

    private void sair() {
        this.view.dispose();
    }

    private void carregaTabela() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Número", "Cadeiras", "Ocupada" }, 0);

        for (Mesa mesa : mesas.getMesas()) {
            model.addRow(new Object[] {
                    mesa.getNumero(),
                    mesa.getQuantCadeiras(),
                    mesa.isOcupada() ? "Sim" : "Não" // Convert boolean to string
            });
        }

        view.getTbMesas().setModel(model);
    }

    private void excluirMesa() {
        int selectedRow = view.getTbMesas().getSelectedRow();
        if (selectedRow >= 0) {
            int numero = (int) view.getTbMesas().getValueAt(selectedRow, 0); // Get number directly as int
            int option = JOptionPane.showConfirmDialog(view, "Deseja excluir a mesa " + numero + "?");

            if (option == JOptionPane.YES_OPTION) {
                Mesa mesa = mesas.buscarMesaPorNumero(numero);
                if (mesa != null && !mesa.isOcupada()) { // Check if mesa exists and is not occupied
                    mesas.excluirMesa(mesa);
                    JOptionPane.showMessageDialog(view, "Mesa " + numero + " excluída com sucesso!");
                    carregaTabela();
                } else {
                    JOptionPane.showMessageDialog(view, "Não é possível excluir uma mesa ocupada.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(view, "Selecione uma linha primeiro!");
        }
    }
}
