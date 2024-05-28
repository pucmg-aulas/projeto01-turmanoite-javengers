package main.java.view;

import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class AdicionarClienteView extends javax.swing.JFrame {

    public AdicionarClienteView() {
        initComponents();
    }

    public JToggleButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JToggleButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JToggleButton getBtnSalvar() {
        return btnSalvar;
    }

    public void setBtnSalvar(JToggleButton btnSalvar) {
        this.btnSalvar = btnSalvar;
    }

    public JTextField getTxtNomeCliente() {
        return txtNomeCliente;
    }

    public void setTxtNomeCliente(JTextField txtNomeCliente) {
        this.txtNomeCliente = txtNomeCliente;
    }

    public JTextField getTxtCpfCliente() {
        return txtCpfCliente;
    }

    public void setTxtCpfCliente(JTextField txtCpfCliente) {
        this.txtCpfCliente = txtCpfCliente;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        btnVoltar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnVoltar.setText("Voltar");

        btnEditar.setText("Editar");

        btnExcluir.setText("Excluir");

        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 123, Short.MAX_VALUE)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVoltar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        pack();
    }

    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbClientes;
}