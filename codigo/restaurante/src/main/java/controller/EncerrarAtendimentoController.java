package main.java.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import main.java.dao.Atendimentos;
import main.java.dao.Clientes;
import main.java.dao.Historico;
import main.java.dao.Mesas;
import main.java.dao.Pagamentos;
import main.java.model.Atendimento;
import main.java.model.Cliente;
import main.java.model.Comanda;
import main.java.model.Credito;
import main.java.model.Debito;
import main.java.model.Dinheiro;
import main.java.model.Mesa;
import main.java.model.MetodoPagamento;
import main.java.model.Pagamento;
import main.java.model.Pedido;
import main.java.model.Pix;
import main.java.view.EncerrarAtendimentoView;

public class EncerrarAtendimentoController {

    private EncerrarAtendimentoView view;
    private Atendimento atendimento;
    private Atendimentos atendimentos;
    private Historico historico;
    private Clientes clientes;
    private Mesas mesas;
    private Pagamentos pagamentos;

    public EncerrarAtendimentoController(Atendimento atendimento) {
        this.atendimento = atendimento;
        this.clientes = Clientes.getInstance();
        this.atendimentos = Atendimentos.getInstance();
        this.mesas = Mesas.getInstance();
        this.historico = Historico.getInstance();
        this.pagamentos = Pagamentos.getInstance();
        this.view = new EncerrarAtendimentoView();

        this.view.getBtnFinalizarAtendimento().addActionListener((e) -> {
            encerrarAtendimento();
        });

        this.view.getBtnVoltar().addActionListener((e) -> {
            cancelar();
        });

        this.view.getBtnExcluirItemComanda().addActionListener((e) -> {
            excluirItem();
        });

        this.view.getBtnCalcularValor().addActionListener((e) -> {
            getMetodoPagemento();
        });

        carregaTela();

        this.view.setVisible(true);

    }

    private void carregaTela() {
        this.view.getTxtNomeCliente().setText(atendimento.getCliente().getNome());
        this.view.getNumQuantidadePessoas().setText(String.valueOf(atendimento.getQuantPessoas()));
        this.view.getNumValorTotal().setText(String.valueOf(atendimento.getComanda().calculaValor()));

        carregaComanda();
    }

    private void carregaComanda() {
        Object colunas[] = { "Quantidade", "Item", "Valor", "Quantidade", "Valor Total" };
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);

        tm.setNumRows(0);
        Iterator<Pedido> it = atendimento.getComanda().getPedidos().iterator();
        while (it.hasNext()) {
            Pedido p = it.next();
            String pedido = p.toString();
            String linha[] = pedido.split("%");
            tm.addRow(new Object[] { linha[1], linha[2], linha[3], linha[4], linha[5] });
        }
        view.getTableContaCliente().setModel(tm);
    }

    private void excluirItem() {
        int linha = this.view.getTableContaCliente().getSelectedRow();
        Comanda comanda = atendimento.getComanda();
        comanda.getPedidos().remove(linha);
        String cpf = atendimento.getCliente().getCpf();
        atendimentos.altera(atendimento, cpf);

        carregaTela();
    }

    private void encerrarAtendimento() {
        String nome = atendimento.getCliente().getNome();

        int op = JOptionPane.showConfirmDialog(view, "Deseja encerrar o atendimento do cliente " + nome + "?");
        if (op == JOptionPane.YES_OPTION) {
            String cpf = atendimento.getCliente().getCpf();
            Cliente cliente = clientes.buscarClientePorCpf(cpf);
            clientes.excluirCliente(cliente);

            Atendimento atendimento = atendimentos.buscarAtendimentoPorCpf(cpf);

            int numero = atendimento.getMesa().getNumero();
            Mesa mesa = mesas.buscarMesaPorNumero(numero);
            mesa.setOcupada(false);
            mesas.altera(mesa, numero);

            atendimentos.excluirAtendimento(atendimento);

            atendimento.setHoraSaida(LocalTime.now());
            historico.addAtendimento(atendimento);
            
            Pagamento pagamento = new Pagamento(10, LocalDate.now());
            pagamentos.addPagamento(pagamento);

            JOptionPane.showMessageDialog(view, "Atendimento do cliente " + nome + " encerrado com sucesso!");
            carregaTela();
        }
    }

    private void getMetodoPagemento() {
        String pagamento = (String) this.view.getSelectPagamento().getSelectedItem();
        switch (pagamento) {
            case ("Dinheiro"):
                atendimento.getComanda().setMetodoPagamento(new Dinheiro());
                break;
            case ("Pix"):
                atendimento.getComanda().setMetodoPagamento(new Pix());
                break;
            case ("Crédito"):
                atendimento.getComanda().setMetodoPagamento(new Credito());
                break;
            case ("Débito"):
                atendimento.getComanda().setMetodoPagamento(new Debito());
                break;
        }
    }

    private void cancelar() {
        this.view.dispose();
    }
}