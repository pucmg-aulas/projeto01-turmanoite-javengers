package main.java.controller;

import main.java.dao.Atendimentos;
import main.java.dao.Clientes;
import main.java.dao.Mesas;
import main.java.model.Atendimento;
import main.java.model.Mesa;
import main.java.view.EscolherMesaView;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class EscolherMesaController {
    private final EscolherMesaView view;
    private final Atendimento atendimento;
    private final Atendimentos atendimentos;
    private final Clientes clientes;
    private final List<Mesa> mesasDisponiveis;
    private final Mesas mesas;

    public EscolherMesaController(Atendimento atendimento, List<Mesa> mesasDisponiveis) {
        this.view = new EscolherMesaView();
        this.atendimento = atendimento;
        this.atendimentos = Atendimentos.getInstance();
        this.mesasDisponiveis = mesasDisponiveis;
        this.mesas = Mesas.getInstance();
        this.clientes = Clientes.getInstance();

        carregaTabela();

        this.view.getBtnEscolher().addActionListener(e -> escolherMesa());
        this.view.getBtnVoltar().addActionListener(e -> sair());

        this.view.setVisible(true);
    }

    private void sair() {
        this.view.dispose();
    }

    private void escolherMesa() {
        clientes.addCliente(atendimento.getCliente());
        atendimentos.addAtendimento(atendimento);
        int linha = this.view.getTbMesas().getSelectedRow();
        
        if (linha >= 0) {
            int numero = (Integer) this.view.getTbMesas().getValueAt(linha, 0);
            Mesa mesa = mesas.buscarMesaPorNumero(numero);
            mesa.setOcupada(true);
            mesas.altera(mesa, numero);
            atendimento.setMesa(mesa);
            atendimentos.addAtendimento(atendimento);
            this.view.dispose();
        }
    }

    private void carregaTabela() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Número", "Cadeiras" }, 0);

        for (Mesa m : mesasDisponiveis) {
            model.addRow(new Object[] { m.getNumero(), m.getQuantCadeiras() });
        }
        view.getTbMesas().setModel(model);
    }
}
