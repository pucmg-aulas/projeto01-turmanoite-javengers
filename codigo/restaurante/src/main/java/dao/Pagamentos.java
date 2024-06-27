package main.java.dao;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import main.java.model.Pagamento;

public class Pagamentos extends AbstractDao implements Serializable {

    private List<Pagamento> pagamentos;
    private static Pagamentos instance;

    private final String localArquivo = "./codigo/restaurante/src/main/java/data/Pagamentos.dat";

    private Pagamentos() {
        this.pagamentos = new ArrayList<>();
        carregaMesas();
    }

    public static Pagamentos getInstance() {
        if (instance == null)
            instance = new Pagamentos();
        return instance;
    }

    public void addPagamento(Pagamento pagamento) {
        try {
            Pagamento pagamentoPorData = buscarPagamentoPorData(pagamento.getData());
            if (pagamentoPorData != null) {
                double valorAtual = pagamentoPorData.getValor() + pagamento.getValor();
                pagamentoPorData.setValor(valorAtual);
            } else {
                pagamentos.add(pagamento);
            }
            grava();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void carregaMesas() {
        try {
            this.pagamentos = super.leitura(localArquivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void grava() {
        try {
            super.grava(localArquivo, pagamentos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Pagamento> getMesas() {
        return pagamentos;
    }

    public void excluirMesa(Pagamento pagamento) {
        try {
            pagamentos.remove(pagamento);
            grava();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pagamento buscarPagamentoPorData(LocalDate data) {
        try {
            return pagamentos.stream()
                    .filter(pagamento -> pagamento.getData().equals(data))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void gerarRelatorio() {
        LocalDate data = LocalDate.now();
        String local = "./codigo/restaurante/src/main/java/data/Faturamento-" + data + ".txt";

        try (PrintWriter writer = new PrintWriter(local)) {
            writer.println("Data\t\tValor");
            for (Pagamento pagamento : pagamentos) {
                String valor = String.format("R$%.2f", pagamento.getValor());
                writer.println(pagamento.getData() + "\t" + valor);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}