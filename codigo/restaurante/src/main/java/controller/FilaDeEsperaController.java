package main.java.controller;

import main.java.dao.FilaDeEspera;
import main.java.view.FilaEsperaView;
import javax.swing.table.DefaultTableModel;

public class FilaDeEsperaController {
    private final FilaEsperaView view;
    private final FilaDeEspera filaDeEspera;

    public FilaDeEsperaController() {
        this.filaDeEspera = FilaDeEspera.getInstance();
        this.view = new FilaEsperaView();

        carregaTabela();

        this.view.setVisible(true);
    }

    private void carregaTabela() {
        DefaultTableModel model = new DefaultTableModel(
            new Object[] { "Nome", "CPF", "Quantidade de Pessoas" }, 0);

        filaDeEspera.getAtendimentos().stream().forEach(atendimento -> {
            model.addRow(new Object[] {
                atendimento.getCliente().getNome(),
                atendimento.getCliente().getCpf(),
                atendimento.getQuantPessoas()
            });
        });

        view.getTabelaFilaEspera().setModel(model);
    }
}
