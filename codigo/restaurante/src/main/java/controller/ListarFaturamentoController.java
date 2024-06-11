package main.java.controller;

import main.java.dao.Pagamentos;
import main.java.model.Pagamento;
import main.java.view.FaturamentoView;

import java.time.LocalDate;

import javax.swing.table.DefaultTableModel;

public class ListarFaturamentoController {
    private final FaturamentoView view;
    private final Pagamentos pagamentos;

    public ListarFaturamentoController() {
        this.pagamentos = Pagamentos.getInstance();
        this.view = new FaturamentoView();

        carregaTabela();

        this.view.getBtnPesquisa().addActionListener(e -> pesquisa());
        this.view.setVisible(true);
    }

    private void carregaTabela() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Data", "Valor" }, 0);

        for (Pagamento pagamento : pagamentos.getPagamentos()) {
            model.addRow(new Object[] {
            pagamento.getData(),
            String.format("%.2f", pagamento.getValor())
            });
        }

        view.getTable().setModel(model);
    }

    private void pesquisa() {
        String dateString = view.getDateField().getText();
        
        LocalDate data = LocalDate.parse(dateString);

        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Data", "Valor" }, 0);

        for (Pagamento pagamento : pagamentos.getPagamentos()) {
            if (pagamento.getData().equals(data)) {
                model.addRow(new Object[] {
                    pagamento.getData(),
                    String.format("%.2f", pagamento.getValor())
                });
            }
        }

        view.getTable().setModel(model);
    }
}
