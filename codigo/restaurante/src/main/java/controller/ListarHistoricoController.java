package main.java.controller;

import main.java.dao.Historico;
import main.java.view.HistoricoAtendimentoView;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListarHistoricoController {
    private final HistoricoAtendimentoView view;
    private final Historico historico;

    public ListarHistoricoController() {
        this.historico = Historico.getInstance();
        this.view = new HistoricoAtendimentoView();
        this.view.getBotaoPesquisar().addActionListener(e -> pesquisar());
        this.view.getBotaoExportar().addActionListener(e -> exportar());
        carregaTabela();
        this.view.setVisible(true);
    }

    private void carregaTabela() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Nome", "CPF", "Data", "Valor" }, 0);

        historico.getAtendimentos().stream()
                .forEach(atendimento -> model.addRow(new Object[] {
                        atendimento.getCliente().getNome(),
                        atendimento.getCliente().getCpf(),
                        atendimento.getData(),
                        String.format("%.2f", atendimento.getComanda().calculaValor())
                }));

        view.getTabelaHistorico().setModel(model);
    }

    private void pesquisar() {
        String dateString = view.getCampoPesquisa().getText();

        LocalDate data;
        try {
            data = LocalDate.parse(dateString);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(view, "Data inválida");
            return;
        }

        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Nome", "CPF", "Data", "Valor" }, 0);

        historico.getAtendimentos().stream()
                .filter(atendimento -> atendimento.getData().equals(data))
                .forEach(atendimento -> model.addRow(new Object[] {
                        atendimento.getCliente().getNome(),
                        atendimento.getCliente().getCpf(),
                        atendimento.getData(),
                        String.format("%.2f", atendimento.getComanda().calculaValor())
                }));

        view.getTabelaHistorico().setModel(model);
    }

    private void exportar() {
        historico.gerarRelatorio();
    }
}
