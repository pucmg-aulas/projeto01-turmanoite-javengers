package main.controller;

import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import main.java.dao.Mesas;
import main.java.model.Mesa;
import main.java.view.ListarMesaView;

public class ListarMesaController {
    
    private ListarMesaView view;
    private Mesas mesas;

    public ListarMesaController() {
    
        this.mesas = Mesas.getInstance();
        this.view = new ListarMesaView();
        
        carregaTabela();
        
        this.view.getBtnExcluir().addActionListener((e) -> {
            excluirMesa();
        });
        
        this.view.getBtnVoltar().addActionListener((e) -> {
            sair();
        });
        
        this.view.getBtnEditar().addActionListener((e) -> {
            editar();
        });
        
        this.view.setVisible(true);
        
    }

    private void sair() {
        this.view.dispose();
    }

    private void carregaTabela(){
        Object colunas[] = {"Quantidade de Cadeiras"};
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);

        tm.setNumRows(0);
        Iterator<Mesa> it = mesas.getMesas().iterator();
        while (it.hasNext()) {
            Mesa m = it.next();
            String mesa = m.toString();
            String linha[] = mesa.split("%");
            tm.addRow(new Object[]{linha[0]});
        }
        view.getTbMesas().setModel(tm);
    }

    private void excluirMesa(){
        
        if(view.getTbMesas().getSelectedRow() != -1){
            
            int linha = this.view.getTbMesas().getSelectedRow();
            String quantCadeiras = (String) this.view.getTbMesas().getValueAt(linha, 0);
            
            int op = JOptionPane.showConfirmDialog(view, "Deseja excluir a mesa com " + quantCadeiras + " cadeiras?");
            if(op == JOptionPane.YES_OPTION){
                Mesa mesa = mesas.buscarMesaPorQuantidadeCadeiras(Integer.parseInt(quantCadeiras));
                mesas.excluirMesa(mesa);
                JOptionPane.showMessageDialog(view, "Mesa com " + quantCadeiras + " cadeiras excluída com sucesso!");
                carregaTabela();
            }

        }
        else{
            JOptionPane.showMessageDialog(view, "Selecione uma linha primeiro!");
        }

    }

    private void editar() {
        JOptionPane.showInternalMessageDialog(view, "Não implementado ainda!");
    }
}