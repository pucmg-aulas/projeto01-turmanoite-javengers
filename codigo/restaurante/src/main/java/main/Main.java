package main.java.main;

import javax.swing.JMenuItem;

import main.java.controller.AdicionarClienteController;
import main.java.controller.AdicionarMesaController;
import main.java.controller.FilaDeEsperaController;
import main.java.controller.ListarCardapioController;
import main.java.controller.ListarClienteController;
import main.java.controller.ListarHistoricoController;
import main.java.controller.ListarMesaController;
import main.java.controller.ListarPagamentosController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author danil
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        // Restaurante restaurante = Restaurante.getInstance();
        this.setVisible(true);

    }

    public JMenuItem getExibirAtendimentosMenuBtn() {
        return ExibirAtendimentosMenuBtn;
    }

    public void setExibirAtendimentosMenuBtn(JMenuItem ExibirAtendimentosMenuBtn) {
        this.ExibirAtendimentosMenuBtn = ExibirAtendimentosMenuBtn;
    }

    public JMenuItem getExibirHistoricoBtn() {
        return exibirHistoricoBtn;
    }

    public void setExibirHistoricoBtn(JMenuItem exibirHistoricoBtn) {
        this.exibirHistoricoBtn = exibirHistoricoBtn;
    }

    public JMenuItem getExibirPagamentosBtn() {
        return exibirPagamentosBtn;
    }

    public void setExibirPagamentosBtn(JMenuItem exibirPagamentosBtn) {
        this.exibirPagamentosBtn = exibirPagamentosBtn;
    }

    public JMenuItem getExibirListaDeEsperaMenuBtn() {
        return ExibirListaDeEsperaMenuBtn;
    }

    public void setExibirListaDeEsperaMenuBtn(JMenuItem ExibirListaDeEsperaMenuBtn) {
        this.ExibirListaDeEsperaMenuBtn = ExibirListaDeEsperaMenuBtn;
    }

    public JMenuItem getAdicionarMesaMenuBtn() {
        return adicionarMesaMenuBtn;
    }

    public void setAdicionarMesaMenuBtn(JMenuItem adicionarMesaMenuBtn) {
        this.adicionarMesaMenuBtn = adicionarMesaMenuBtn;
    }

    public JMenuItem getExibirCardapioMenuBtn() {
        return exibirCardapioMenuBtn;
    }

    public void setExibirCardapioMenuBtn(JMenuItem exibirCardapioMenuBtn) {
        this.exibirCardapioMenuBtn = exibirCardapioMenuBtn;
    }

    public JMenuItem getExibirMesasDisponiveisMenuBtn() {
        return exibirMesasDisponiveisMenuBtn;
    }

    public void setExibirMesasDisponiveisMenuBtn(JMenuItem exibirMesasDisponiveisMenuBtn) {
        this.exibirMesasDisponiveisMenuBtn = exibirMesasDisponiveisMenuBtn;
    }

    public JMenuItem getExitMenuBtn() {
        return exitMenuBtn;
    }

    public void setExitMenuBtn(JMenuItem exitMenuBtn) {
        this.exitMenuBtn = exitMenuBtn;
    }

    public JMenuItem getIniciarAtendimentoMenuBtn() {
        return iniciarAtendimentoMenuBtn;
    }

    public void setIniciarAtendimentoMenuBtn(JMenuItem iniciarAtendimentoMenuBtn) {
        this.iniciarAtendimentoMenuBtn = iniciarAtendimentoMenuBtn;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        atendimentoMenuBtn = new javax.swing.JMenu();
        iniciarAtendimentoMenuBtn = new javax.swing.JMenuItem();
        exitMenuBtn = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        ExibirAtendimentosMenuBtn = new javax.swing.JMenuItem();
        ExibirListaDeEsperaMenuBtn = new javax.swing.JMenuItem();
        exibirMesasDisponiveisMenuBtn = new javax.swing.JMenuItem();
        exibirCardapioMenuBtn = new javax.swing.JMenuItem();
        exibirHistoricoBtn = new javax.swing.JMenuItem();
        exibirPagamentosBtn = new javax.swing.JMenuItem();
        AcoesMenuBtn = new javax.swing.JMenu();
        adicionarMesaMenuBtn = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("JaVengers");

        atendimentoMenuBtn.setText("Atendimento");

        iniciarAtendimentoMenuBtn.setText("Iniciar Atendimento");
        iniciarAtendimentoMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarAtendimentoMenuBtnActionPerformed(evt);
            }
        });
        atendimentoMenuBtn.add(iniciarAtendimentoMenuBtn);

        exitMenuBtn.setText("Exit");
        exitMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuBtnActionPerformed(evt);
            }
        });
        atendimentoMenuBtn.add(exitMenuBtn);

        jMenuBar1.add(atendimentoMenuBtn);

        jMenu3.setText("View");

        ExibirAtendimentosMenuBtn.setText("Exibir Atendimento");
        ExibirAtendimentosMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExibirAtendimentosMenuBtnActionPerformed(evt);
            }
        });
        jMenu3.add(ExibirAtendimentosMenuBtn);

        ExibirListaDeEsperaMenuBtn.setText("Exibir Lista de Espera");
        ExibirListaDeEsperaMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExibirListaDeEsperaMenuBtnActionPerformed(evt);
            }
        });
        jMenu3.add(ExibirListaDeEsperaMenuBtn);

        exibirMesasDisponiveisMenuBtn.setText("Exibir Mesas");
        exibirMesasDisponiveisMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibirMesasDisponiveisMenuBtnActionPerformed(evt);
            }
        });
        jMenu3.add(exibirMesasDisponiveisMenuBtn);

        exibirCardapioMenuBtn.setText("Exibir Cardapio");
        exibirCardapioMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibirCardapioMenuBtnActionPerformed(evt);
            }
        });
        jMenu3.add(exibirCardapioMenuBtn);

        exibirHistoricoBtn.setText("Exibir Histórico");
        exibirHistoricoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibirHistoricoBtnActionPerformed(evt);
            }
        });

        exibirPagamentosBtn.setText("Exibir Pagamentos");
        exibirPagamentosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibirPagamentosBtnActionPerformed(evt);
            }
        });

        jMenu3.add(exibirHistoricoBtn);

        jMenu3.add(exibirPagamentosBtn);

        jMenuBar1.add(jMenu3);

        AcoesMenuBtn.setText("Ações");

        adicionarMesaMenuBtn.setText("Adicionar Mesa");
        adicionarMesaMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarMesaMenuBtnActionPerformed(evt);
            }
        });
        AcoesMenuBtn.add(adicionarMesaMenuBtn);

        jMenuBar1.add(AcoesMenuBtn);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 407, Short.MAX_VALUE)
                                .addComponent(jLabel1)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 304, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>

    private void iniciarAtendimentoMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new AdicionarClienteController();
    }

    private void exitMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {

        this.dispose();

    }

    private void ExibirAtendimentosMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {
        new ListarClienteController();
    }

    private void exibirCardapioMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new ListarCardapioController();

    }

    private void exibirMesasDisponiveisMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new ListarMesaController();

    }

    private void adicionarMesaMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new AdicionarMesaController();
    }

    private void exibirHistoricoBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new ListarHistoricoController();
    }

    private void exibirPagamentosBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new ListarPagamentosController();
    }

    private void ExibirListaDeEsperaMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        new FilaDeEsperaController();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JMenu AcoesMenuBtn;
    private javax.swing.JMenuItem ExibirAtendimentosMenuBtn;
    private javax.swing.JMenuItem ExibirListaDeEsperaMenuBtn;
    private javax.swing.JMenuItem adicionarMesaMenuBtn;
    private javax.swing.JMenu atendimentoMenuBtn;
    private javax.swing.JMenuItem exibirCardapioMenuBtn;
    private javax.swing.JMenuItem exibirHistoricoBtn;
    private javax.swing.JMenuItem exibirPagamentosBtn;
    private javax.swing.JMenuItem exibirMesasDisponiveisMenuBtn;
    private javax.swing.JMenuItem exitMenuBtn;
    private javax.swing.JMenuItem iniciarAtendimentoMenuBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    // End of variables declaration
}
