package main.java.controller;

import main.java.dao.Pagamentos;
import main.java.view.HistoricoPagamentosView;

import javax.swing.table.DefaultTableModel;

public class ListarPagamentosController {
    private final HistoricoPagamentosView view;
    private final Pagamentos pagamentos;

    public ListarPagamentosController() {
        this.pagamentos = Pagamentos.getInstance();
        this.view = new HistoricoPagamentosView();
        carregaTabela();
        this.view.setVisible(true);
    }

    private void carregaTabela() {
        DefaultTableModel model = new DefaultTableModel(
            new Object[]{"Data", "Valor"}, 0);

        pagamentos.getPagamentos().forEach(pagamento ->
            model.addRow(new Object[]{
                pagamento.getData(), 
                String.format("%.2f", pagamento.getValor())
            })
        );

        view.getTabelaHistorico().setModel(model);
    }

    private void sair() {
        this.view.dispose();
    }
}
