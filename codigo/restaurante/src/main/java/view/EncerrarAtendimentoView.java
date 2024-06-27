/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
*/
package main.java.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author delfi
 */
public class EncerrarAtendimentoView extends javax.swing.JFrame {

    /**
     * Creates new form EncerrarAtendimentoCliente
     */
    public EncerrarAtendimentoView() {
        initComponents();

    }

    public JToggleButton getBtnCalcularValor() {
        return btnCalcularValor;
    }

    public void setBtnCalcularValor(JToggleButton btnCalcularValor) {
        this.btnCalcularValor = btnCalcularValor;
    }

    public JToggleButton getBtnExcluirItemComanda() {
        return btnExcluirItemComanda;
    }

    public void setBtnExcluirItemComanda(JToggleButton btnExcluirItemComanda) {
        this.btnExcluirItemComanda = btnExcluirItemComanda;
    }

    public JButton getBtnFinalizarAtendimento() {
        return btnFinalizarAtendimento;
    }

    public JButton getBtnVoltar() {
        return btnVoltar;
    }

    public void setBtnFinalizarAtendimento(JButton btnFinalizarAtendimento) {
        this.btnFinalizarAtendimento = btnFinalizarAtendimento;
    }

    public JTextField getNumQuantidadePessoas() {
        return numQuantidadePessoas;
    }

    public void setNumQuantidadePessoas(JTextField numQuantidadePessoas) {
        this.numQuantidadePessoas = numQuantidadePessoas;
    }

    public JTextField getNumValorPessoa() {
        return numValorPessoa;
    }

    public void setNumValorPessoa(JTextField numValorPessoa) {
        this.numValorPessoa = numValorPessoa;
    }

    public JTextField getNumValorTotal() {
        return numValorTotal;
    }

    public void setNumValorTotal(JTextField numValorTotal) {
        this.numValorTotal = numValorTotal;
    }

    public JComboBox<String> getSelectPagamento() {
        return selectPagamento;
    }

    public void setSelectPagamento(JComboBox<String> selectPagamento) {
        this.selectPagamento = selectPagamento;
    }

    public JTable getTableContaCliente() {
        return tableContaCliente;
    }

    public void setTableContaCliente(JTable tableContaCliete) {
        this.tableContaCliente = tableContaCliete;
    }

    public JTextField getTxtNomeCliente() {
        return txtNomeCliente;
    }

    public void setTxtNomeCliente(JTextField txtNomeCliente) {
        this.txtNomeCliente = txtNomeCliente;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableContaCliente = new javax.swing.JTable();
        selectPagamento = new javax.swing.JComboBox<>();
        btnFinalizarAtendimento = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        numValorTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        numValorPessoa = new javax.swing.JTextField();
        txtNomeCliente = new javax.swing.JTextField();
        btnExcluirItemComanda = new javax.swing.JToggleButton();
        btnCalcularValor = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        numQuantidadePessoas = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableContaCliente.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        jScrollPane1.setViewportView(tableContaCliente);

        selectPagamento.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinheiro", "Pix", "Débito", "Crédito" }));
        selectPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectPagamentoActionPerformed(evt);
            }
        });

        btnFinalizarAtendimento.setText("Finalizar Atendimento");

        btnVoltar.setText("Voltar");

        jLabel1.setText("Forma de Pagamento");

        jLabel2.setText("Cliente:");

        numValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numValorTotalActionPerformed(evt);
            }
        });

        jLabel3.setText("Valor Total:");

        jLabel4.setText("Valor por pessoa:");

        numValorPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numValorPessoaActionPerformed(evt);
            }
        });

        txtNomeCliente.setEditable(false);
        txtNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeClienteActionPerformed(evt);
            }
        });

        btnExcluirItemComanda.setText("Excluir Item ");

        btnCalcularValor.setText("Calcular Valor");

        jLabel5.setText("Quantidade Pessoas:");

        numQuantidadePessoas.setEditable(false);
        numQuantidadePessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numQuantidadePessoasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(numQuantidadePessoas,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 71,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 10, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
                                                Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(selectPagamento,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 114,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1))
                                                .addComponent(numValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(numValorPessoa,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 102,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(14, 14, 14)))
                                .addGap(14, 14, 14))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCalcularValor, javax.swing.GroupLayout.PREFERRED_SIZE, 111,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcluirItemComanda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVoltar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnFinalizarAtendimento)
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)
                                        .addComponent(numQuantidadePessoas, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(selectPagamento, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96,
                                                        Short.MAX_VALUE)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(numValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(numValorPessoa, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(37, 37, 37))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnFinalizarAtendimento)
                                        .addComponent(btnVoltar)
                                        .addComponent(btnExcluirItemComanda)
                                        .addComponent(btnCalcularValor))
                                .addContainerGap()));

        pack();
    }// </editor-fold>

    private void selectPagamentoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void numValorTotalActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void numValorPessoaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void numQuantidadePessoasActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify
    private javax.swing.JToggleButton btnCalcularValor;
    private javax.swing.JToggleButton btnExcluirItemComanda;
    private javax.swing.JButton btnFinalizarAtendimento;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField numQuantidadePessoas;
    private javax.swing.JTextField numValorPessoa;
    private javax.swing.JTextField numValorTotal;
    private javax.swing.JComboBox<String> selectPagamento;
    private javax.swing.JTable tableContaCliente;
    private javax.swing.JTextField txtNomeCliente;
    // End of variables declaration
}
