package main.java.controller;

import main.java.dao.Pagamentos;
import main.java.view.FaturamentoView;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListarFaturamentoController {
    private final FaturamentoView view;
    private final Pagamentos pagamentos;

    public ListarFaturamentoController() {
        this.pagamentos = Pagamentos.getInstance();
        this.view = new FaturamentoView();

        carregaTabela();

        this.view.getBtnPesquisa().addActionListener(e -> pesquisa());
        this.view.getBtnExportar().addActionListener(e -> exportar());

        this.view.setVisible(true);
    }

    private void carregaTabela() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Data", "Valor" }, 0);

        pagamentos.getPagamentos().stream().forEach(pagamento -> {
            model.addRow(new Object[] {
                    pagamento.getData(),
                    String.format("%.2f", pagamento.getValor())
            });
        });

        view.getTable().setModel(model);
    }

    private void pesquisa() {
        String dateString = view.getDateField().getText();

        LocalDate data;
        try {
            data = LocalDate.parse(dateString);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(view, "Data inválida");
            return;
        }

        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Data", "Valor" }, 0);

        pagamentos.getPagamentos().stream()
                .filter(pagamento -> pagamento.getData().equals(data))
                .forEach(pagamento -> {
                    model.addRow(new Object[] {
                            pagamento.getData(),
                            String.format("%.2f", pagamento.getValor())
                    });
                });

        view.getTable().setModel(model);
    }

    private void exportar() {
        pagamentos.gerarRelatorio();
    }
}
