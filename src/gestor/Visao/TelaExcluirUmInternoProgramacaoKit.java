/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleKitDecendialNomeInternoTodos;
import gestor.Controle.ControleListaInternosKitDecendialIdInternos;
import gestor.Controle.ControleListaInternosProgramacaoKitTodos;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControlePagamentoKitAnualRealizado;
import gestor.Controle.ControlePagamentoKitDecendialRealizado;
import gestor.Controle.ControlePagamentoKitMensalRealizado;
import gestor.Controle.ControlePagamentoKitQuinzenalRealizado;
import gestor.Controle.ControlePagamentoKitSemestralRealizado;
import gestor.Controle.ControleProgramacaoKit;
import gestor.Controle.ControleProximoKitDecendial;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.GravarInternosKitCompleto;
import gestor.Modelo.LogSistema;
import gestor.Modelo.ProgramacaoKit;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloAlmoxarifado.codAbrirAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codAlterarAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codConsultarAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codExcluirAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codGravarAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codIncluirAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codUserAcessoAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codigoGrupoAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codigoUserAL;
import static gestor.Visao.TelaModuloAlmoxarifado.codigoUserGroupAL;
import static gestor.Visao.TelaModuloAlmoxarifado.nomeGrupoAL;
import static gestor.Visao.TelaModuloAlmoxarifado.nomeTelaAL;
import static gestor.Visao.TelaModuloAlmoxarifado.telaProgramacaoKitIndAL;
import static gestor.Visao.TelaProgramacaoKitsHigiene.idPROG;
import static gestor.Visao.TelaProgramacaoKitsHigiene.jTabelaOrigem;
import static gestor.Visao.TelaProgramacaoKitsHigiene.jTabelaDestino;
import static gestor.Visao.TelaProgramacaoKitsHigiene.jtotalDestino;
import static gestor.Visao.TelaProgramacaoKitsHigiene.jtotalOrigem;
import static gestor.Visao.TelaProgramacaoKitsHigiene.qtdInternos;
import static gestor.Visao.TelaProgramacaoKitsHigiene.tipoKit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ronal
 */
public class TelaExcluirUmInternoProgramacaoKit extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ControleProgramacaoKit controlPagtoKit = new ControleProgramacaoKit();
    GravarInternosKitCompleto objGravaIntComp = new GravarInternosKitCompleto();
    ControleListaInternosProgramacaoKitTodos controleKDTodos = new ControleListaInternosProgramacaoKitTodos();
    ControleListaInternosKitDecendialIdInternos controleKD = new ControleListaInternosKitDecendialIdInternos();
    ControleKitDecendialNomeInternoTodos controlNome = new ControleKitDecendialNomeInternoTodos();
    ControlePagamentoKitDecendialRealizado controlListKD = new ControlePagamentoKitDecendialRealizado();  //LISTAR KIT DECENDIAL PARA SER CONSULTADO OU EXCLUÍDO.
    ControleProximoKitDecendial controleExcluirKD = new ControleProximoKitDecendial(); // EXCLUIR TODOS OS INTERNOS
    //
    ControlePagamentoKitQuinzenalRealizado controlListKQ = new ControlePagamentoKitQuinzenalRealizado();
    ControlePagamentoKitMensalRealizado controlListKM = new ControlePagamentoKitMensalRealizado();
    ControlePagamentoKitSemestralRealizado controlListKS = new ControlePagamentoKitSemestralRealizado();
    ControlePagamentoKitAnualRealizado controlListKA = new ControlePagamentoKitAnualRealizado();
    //
    ProgramacaoKit objProg = new ProgramacaoKit();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    //

    /**
     * Creates new form TelaExcluirUmInternoProgramacaoKit
     */
    public static TelaProgramacaoKitsHigiene progKIT;

    public TelaExcluirUmInternoProgramacaoKit(TelaProgramacaoKitsHigiene parent, boolean modal) {
        this.progKIT = parent;
        this.setModal(modal);
        setLocationRelativeTo(progKIT);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jIdInterno = new javax.swing.JTextField();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jNomeInternoPesquisa = new javax.swing.JTextField();
        jBtPesqCodigo = new javax.swing.JButton();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Excluir Interno Individual :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome do Interno");

        jIdInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setToolTipText("Pesquisar pelo Nome do Interno");
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        jNomeInternoPesquisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCodigo.setToolTipText("Pesquisar pelo Código do Interno");
        jBtPesqCodigo.setContentAreaFilled(false);
        jBtPesqCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jNomeInternoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jNomeInternoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqCodigo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jBtPesqNomeInterno)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jBtConfirmar.setForeground(new java.awt.Color(0, 102, 51));
        jBtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtConfirmar.setText("Confirmar");
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
            }
        });

        jBtSair.setForeground(new java.awt.Color(204, 0, 0));
        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSair)
                        .addGap(0, 271, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaProgramacaoKitIndAL);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoAL.equals("ADMINISTRADORES") || codigoUserAL == codUserAcessoAL && nomeTelaAL.equals(telaProgramacaoKitIndAL) && codExcluirAL == 1) {
            pesquisarInterno();
            if (jIdInterno.getText().equals("") && jNomeInternoPesquisa.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessario informar o código do interno ou parte do nome do interno para poder realizar a exclusão.");
            } else {
                switch (tipoKit) {
                    case 1:
                        tipoKit = 1;
                        int resposta0 = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta0 == JOptionPane.YES_OPTION) {
                            objGravaIntComp.setIDREG_PROG(idPROG);
                            objGravaIntComp.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                            controleExcluirKD.excluirInternoKitDecendial(objGravaIntComp);
                            limparTabelaInternos();
                            mostraSelecaoInternosKDExcluir();
                        }
                        break;
                    case 2:
                        tipoKit = 2;
                        int resposta1 = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta1 == JOptionPane.YES_OPTION) {
                            objGravaIntComp.setIDREG_PROG(idPROG);
                            objGravaIntComp.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                            controleExcluirKD.excluirInternoKitQuinzenal(objGravaIntComp);
                            limparTabelaInternos();
                            mostraSelecaoInternosKQExcluir();
                        }
                        break;
                    case 3:
                        tipoKit = 3;
                        int resposta2 = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta2 == JOptionPane.YES_OPTION) {
                            objGravaIntComp.setIDREG_PROG(idPROG);
                            objGravaIntComp.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                            controleExcluirKD.excluirInternoKitMensal(objGravaIntComp);
                            limparTabelaInternos();
                            mostraSelecaoInternosKMExcluir();
                        }
                        break;
                    case 4:
                        tipoKit = 4;
                        int resposta3 = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta3 == JOptionPane.YES_OPTION) {
                            objGravaIntComp.setIDREG_PROG(idPROG);
                            objGravaIntComp.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                            controleExcluirKD.excluirInternoKitSemestral(objGravaIntComp);
                            limparTabelaInternos();
                            mostraSelecaoInternosKSExcluir();
                        }
                        break;
                    case 5:
                        tipoKit = 5;
                        int resposta4 = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o LANÇAMENTO selecionado?", "Confirmação",
                                JOptionPane.YES_NO_OPTION);
                        if (resposta4 == JOptionPane.YES_OPTION) {
                            objGravaIntComp.setIDREG_PROG(idPROG);
                            objGravaIntComp.setIdInternoCrc(Integer.valueOf(jIdInterno.getText()));
                            controleExcluirKD.excluirInternoKitAnual(objGravaIntComp);
                            limparTabelaInternos();
                            mostraSelecaoInternosKAExcluir();
                        }
                        break;
                    default:
                        break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação ao administrador do sistema.");
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtPesqCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCodigoActionPerformed
        // TODO add your handling code here:
        pesquisarInterno();
    }//GEN-LAST:event_jBtPesqCodigoActionPerformed

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        pesquisarInterno();
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaExcluirUmInternoProgramacaoKit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaExcluirUmInternoProgramacaoKit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaExcluirUmInternoProgramacaoKit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaExcluirUmInternoProgramacaoKit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaExcluirUmInternoProgramacaoKit dialog = new TelaExcluirUmInternoProgramacaoKit(progKIT, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtPesqCodigo;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtSair;
    private javax.swing.JTextField jIdInterno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jNomeInternoPesquisa;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public void limparTabelaInternos() {
        // APAGAR DADOS DA TABELA PRODUTOS
        while (jTabelaOrigem.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaOrigem.getModel()).removeRow(0);
        }
        // LIMPAR O TOTALIZADOR DA TABELA PRODUTOS
        jtotalOrigem.setText("");
        // APAGAR DADOS DA TABELA INTERNOS SELECIONADOS
        while (jTabelaDestino.getModel().getRowCount() > 0) {
            ((DefaultTableModel) jTabelaDestino.getModel()).removeRow(0);
        }
        // LIMPAR O TOTALIZADOR DA TABELA PRODUTOS SELECIONADOS PARA BAIXA
        jtotalDestino.setText("");
        qtdInternos = 0;
        jtotalOrigem.setText(Integer.toString(qtdInternos));
        jtotalDestino.setText(Integer.toString(qtdInternos));
    }

    public void pesquisarInterno() {
        conecta.abrirConexao();
        if (jIdInterno.getText().equals("") && !jNomeInternoPesquisa.getText().equals("")) {
            //PESQUISAR PELO NOME
            try {
                conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + jNomeInternoPesquisa.getText() + "'");
                conecta.rs.first();
                jIdInterno.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInternoPesquisa.setText(conecta.rs.getString("NomeInternoCrc"));
            } catch (Exception e) {
            }
            // PESQUISAR PELO CÓDIGO
        } else if (!jIdInterno.getText().equals("") && jNomeInternoPesquisa.getText().equals("")) {
            try {
                conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE IdInternoCrc='" + jIdInterno.getText() + "'");
                conecta.rs.first();
                jIdInterno.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInternoPesquisa.setText(conecta.rs.getString("NomeInternoCrc"));
            } catch (Exception e) {
            }
            //PRIORIZA PESQUISA PELO CÓDIGO
        } else if (!jIdInterno.getText().equals("") && !jNomeInternoPesquisa.getText().equals("")) {
            try {
                conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE IdInternoCrc='" + jIdInterno.getText() + "'");
                conecta.rs.first();
                jIdInterno.setText(conecta.rs.getString("IdInternoCrc"));
                jNomeInternoPesquisa.setText(conecta.rs.getString("NomeInternoCrc"));
            } catch (Exception e) {
            }
        }
        conecta.desconecta();
    }
    //KIT DECENDIAL

    public void mostraSelecaoInternosKDExcluir() {
        qtdInternos = 0;
        DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaDestino.getModel();
        GravarInternosKitCompleto d = new GravarInternosKitCompleto();
        try {
            for (GravarInternosKitCompleto dd : controlListKD.read()) {
                jtotalDestino.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaDestino.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaDestino.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPrevisaoKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //KIT QUINZENAL
    public void mostraSelecaoInternosKQExcluir() {
        qtdInternos = 0;
        DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaDestino.getModel();
        GravarInternosKitCompleto d = new GravarInternosKitCompleto();
        try {
            for (GravarInternosKitCompleto dd : controlListKQ.read()) {
                jtotalDestino.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaDestino.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaDestino.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPrevisaoKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //KIT MENSAL
    public void mostraSelecaoInternosKMExcluir() {
        qtdInternos = 0;
        DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaDestino.getModel();
        GravarInternosKitCompleto d = new GravarInternosKitCompleto();
        try {
            for (GravarInternosKitCompleto dd : controlListKM.read()) {
                jtotalDestino.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaDestino.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaDestino.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPrevisaoKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //KIT SEMESTRAL
    public void mostraSelecaoInternosKSExcluir() {
        qtdInternos = 0;
        DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaDestino.getModel();
        GravarInternosKitCompleto d = new GravarInternosKitCompleto();
        try {
            for (GravarInternosKitCompleto dd : controlListKS.read()) {
                jtotalDestino.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaDestino.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaDestino.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPrevisaoKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //KIT ANUAL
    public void mostraSelecaoInternosKAExcluir() {
        qtdInternos = 0;
        DefaultTableModel dadosDestino = (DefaultTableModel) jTabelaDestino.getModel();
        GravarInternosKitCompleto d = new GravarInternosKitCompleto();
        try {
            for (GravarInternosKitCompleto dd : controlListKA.read()) {
                jtotalDestino.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                dadosDestino.addRow(new Object[]{dd.getIdInternoCrc(), dd.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaDestino.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaDestino.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaPrevisaoKitHigiene.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserAL = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserAL + "'");
            conecta.rs.first();
            codigoUserGroupAL = conecta.rs.getInt("IdUsuario");
            codigoGrupoAL = conecta.rs.getInt("IdGrupo");
            nomeGrupoAL = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserAL + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoAL = conecta.rs.getInt("IdUsuario");
            codAbrirAL = conecta.rs.getInt("Abrir");
            codIncluirAL = conecta.rs.getInt("Incluir");
            codAlterarAL = conecta.rs.getInt("Alterar");
            codExcluirAL = conecta.rs.getInt("Excluir");
            codGravarAL = conecta.rs.getInt("Gravar");
            codConsultarAL = conecta.rs.getInt("Consultar");
            nomeTelaAL = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
