package main.java.controller;

import main.java.dao.Historico;
import main.java.model.Atendimento;
import main.java.view.HistoricoAtendimentoView;

import java.time.LocalDate;

import javax.swing.table.DefaultTableModel;

public class ListarHistoricoController {
    private final HistoricoAtendimentoView view;
    private final Historico historico;

    public ListarHistoricoController() {
        this.historico = Historico.getInstance();
        this.view = new HistoricoAtendimentoView();
        this.view.getBotaoPesquisar().addActionListener(e -> pesquisa());
        carregaTabela();
        this.view.setVisible(true);
    }

    private void carregaTabela() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Nome", "CPF", "Data" }, 0);

        for (Atendimento atendimento : historico.getAtendimentos()) {
            model.addRow(new Object[] {
                    atendimento.getCliente().getNome(),
                    atendimento.getCliente().getCpf(),
                    atendimento.getData()
            });
        }

        view.getTabelaHistorico().setModel(model);
    }

    private void pesquisa() {
        String dateString = view.getCampoPesquisa().getText();

        LocalDate data = LocalDate.parse(dateString);

        DefaultTableModel model = new DefaultTableModel(
                new Object[] { "Nome", "CPF", "Data" }, 0);

        for (Atendimento atendimento : historico.getAtendimentos()) {
            if (atendimento.getData().equals(data)) {
                model.addRow(new Object[] {
                        atendimento.getCliente().getNome(),
                        atendimento.getCliente().getCpf(),
                        atendimento.getData()
                });
            }
        }

        view.getTabelaHistorico().setModel(model);
    }
}
