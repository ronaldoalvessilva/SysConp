/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import Util.SQL.TableExample;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaRecadosAdministrador.jIDLanc;
import static gestor.Visao.TelaRecadosAdministrador.jDataLanc;
import static gestor.Visao.TelaRecadosAdministrador.jHoraRecado;
import static gestor.Visao.TelaRecadosAdministrador.jComboBoxStatus;
import static gestor.Visao.TelaRecadosAdministrador.jNomeRementente;
import static gestor.Visao.TelaRecadosAdministrador.jNomeDestinatario;
import static gestor.Visao.TelaRecadosAdministrador.jRecado;
import static gestor.Visao.TelaRecadosAdministrador.jBtNovo;
import static gestor.Visao.TelaRecadosAdministrador.jBtAlterar;
import static gestor.Visao.TelaRecadosAdministrador.jBtExcluir;
import static gestor.Visao.TelaRecadosAdministrador.jBtSalvar;
import static gestor.Visao.TelaRecadosAdministrador.jBtCancelar;
import static gestor.Visao.TelaRecadosAdministrador.jBtResponder;
import static gestor.Visao.TelaRecadosAdministrador.jBtConfirmar;
import static gestor.Visao.TelaRecadosAdministrador.jTabelaTodosRecados;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Ronaldo
 */
public class TelaModuloConfiguracoes extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    //
    private TelaGrupoUsuarios tpu = null;
    private TelaUsuarios objUser = null;
    private TelaRecadosAdministrador objRecadoRoot = null;
    private TelaLogSistema objLogSys = null;
    private TelaUsuariosConectados objUserConecta = null;
    private TelaAbirMovimentoFinalizado objAbriMov = null;
    private TelaEmpresa objEmpresa = null;
    private TelaConsultaUsuariosGrupo objConsuGrupo = null;
    //
    int flag, codUsuario;
    String dataLanc;
    String statusAgenda = "Pendente";
    //
    int tempo = (1000 * 60) * 5;   // 5 min.  
    int periodo = 1;  // quantidade de vezes a ser executado.  
    //

    /**
     * Creates new form TelaConfiguracoes
     */
    public static TelaFechamentoSistema pFECHAR_SISTEMA;
    public static TelaAberturaRegistroSistema pABRIR_REGISTROS;

    public TelaModuloConfiguracoes() {
        initComponents();
        this.setSize(840, 640); // Tamanho da tela  
        threadMensagem();
    }

    public void mostrarFechamento() {
        pFECHAR_SISTEMA = new TelaFechamentoSistema(this, true);
        pFECHAR_SISTEMA.setVisible(true);
    }

    public void mostrarAberturaFechamento() {
        pABRIR_REGISTROS = new TelaAberturaRegistroSistema(this, true);
        pABRIR_REGISTROS.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPainelConfiguracoes = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Empresa = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemGrupos = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItemUsuarios = new javax.swing.JMenuItem();
        ConsultaGrupos = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItemLog = new javax.swing.JMenuItem();
        UsuariosConectados = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jAbrirMovimetacaoSistema = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        JMenuSQL = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jFechamentoSistema = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jAbrirTodosMovimentacaoSistema = new javax.swing.JMenuItem();
        jAbrirMovimentoIndividual = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jParamentosSistema = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("...::: Configurações do Sistema :::...");

        jPainelConfiguracoes.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/BrasaoFundo500Prata.png"))); // NOI18N

        jPainelConfiguracoes.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelConfiguracoesLayout = new javax.swing.GroupLayout(jPainelConfiguracoes);
        jPainelConfiguracoes.setLayout(jPainelConfiguracoesLayout);
        jPainelConfiguracoesLayout.setHorizontalGroup(
            jPainelConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
        );
        jPainelConfiguracoesLayout.setVerticalGroup(
            jPainelConfiguracoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );

        jMenu1.setText("Cadastrar");

        Empresa.setText("Empresa");
        Empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpresaActionPerformed(evt);
            }
        });
        jMenu1.add(Empresa);
        jMenu1.add(jSeparator2);

        jMenuItemGrupos.setText("Grupos de Usuários");
        jMenuItemGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGruposActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemGrupos);

        jMenu5.setText("Contas de Usuários e Permissões");

        jMenuItemUsuarios.setText("Contas de Usuários");
        jMenuItemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsuariosActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemUsuarios);

        ConsultaGrupos.setText("Consulta Usuários Por Grupos");
        ConsultaGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaGruposActionPerformed(evt);
            }
        });
        jMenu5.add(ConsultaGrupos);

        jMenu1.add(jMenu5);
        jMenu1.add(jSeparator3);

        jMenuItem1.setText("Agenda de Recados");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator4);

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSair);

        jMenuBar1.add(jMenu1);

        jMenu6.setText("Consultas");

        jMenuItemLog.setText("Log do Sistema");
        jMenuItemLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItemLog);

        UsuariosConectados.setText("Usuários Conectados/Desconectados no Sistema");
        UsuariosConectados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuariosConectadosActionPerformed(evt);
            }
        });
        jMenu6.add(UsuariosConectados);

        jMenuBar1.add(jMenu6);

        jMenu2.setText("Relatórios");
        jMenuBar1.add(jMenu2);

        jAbrirMovimetacaoSistema.setText("Utilitários");

        jMenuItem3.setText("Calculadora de Pena");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jAbrirMovimetacaoSistema.add(jMenuItem3);

        jMenuItem4.setText("Calculadora do Windows");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jAbrirMovimetacaoSistema.add(jMenuItem4);
        jAbrirMovimetacaoSistema.add(jSeparator1);

        JMenuSQL.setForeground(new java.awt.Color(204, 0, 0));
        JMenuSQL.setText("Consultas SQL");
        JMenuSQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuSQLActionPerformed(evt);
            }
        });
        jAbrirMovimetacaoSistema.add(JMenuSQL);
        jAbrirMovimetacaoSistema.add(jSeparator5);

        jFechamentoSistema.setForeground(new java.awt.Color(0, 0, 204));
        jFechamentoSistema.setText("Fechamento dos Registros do Sistema");
        jFechamentoSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFechamentoSistemaActionPerformed(evt);
            }
        });
        jAbrirMovimetacaoSistema.add(jFechamentoSistema);

        jMenu3.setForeground(new java.awt.Color(0, 102, 0));
        jMenu3.setText("Abrir Movimentos do Sistema");

        jAbrirTodosMovimentacaoSistema.setText("Abrir Todos Movimentos Fechado do Sistema por Módulos");
        jAbrirTodosMovimentacaoSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAbrirTodosMovimentacaoSistemaActionPerformed(evt);
            }
        });
        jMenu3.add(jAbrirTodosMovimentacaoSistema);

        jAbrirMovimentoIndividual.setText("Abrir Movimentos do Sistema Individual");
        jAbrirMovimentoIndividual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAbrirMovimentoIndividualActionPerformed(evt);
            }
        });
        jMenu3.add(jAbrirMovimentoIndividual);

        jAbrirMovimetacaoSistema.add(jMenu3);
        jAbrirMovimetacaoSistema.add(jSeparator6);

        jParamentosSistema.setText("Parâmetros do Sistema");
        jParamentosSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jParamentosSistemaActionPerformed(evt);
            }
        });
        jAbrirMovimetacaoSistema.add(jParamentosSistema);

        jMenuBar1.add(jAbrirMovimetacaoSistema);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelConfiguracoes, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelConfiguracoes)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGruposActionPerformed
        // TODO add your handling code here:
        if (tpu == null || tpu.isClosed()) {
            tpu = new TelaGrupoUsuarios();
            jPainelConfiguracoes.add(tpu);
            tpu.setVisible(true);
        } else {
            if (tpu.isVisible()) {
                if (tpu.isIcon()) { // Se esta minimizado
                    try {
                        tpu.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    tpu.toFront(); // traz para frente
                    tpu.pack();//volta frame 
                }
            } else {
                tpu = new TelaGrupoUsuarios();
                TelaModuloConfiguracoes.jPainelConfiguracoes.add(tpu);//adicona frame ao JDesktopPane  
                tpu.setVisible(true);
            }
        }
        try {
            tpu.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jMenuItemGruposActionPerformed

    private void jMenuItemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsuariosActionPerformed
        // TODO add your handling code here:
        if (objUser == null || objUser.isClosed()) {
            objUser = new TelaUsuarios();
            jPainelConfiguracoes.add(objUser);
            objUser.setVisible(true);
        } else {
            if (objUser.isVisible()) {
                if (objUser.isIcon()) { // Se esta minimizado
                    try {
                        objUser.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objUser.toFront(); // traz para frente
                    objUser.pack();//volta frame 
                }
            } else {
                objUser = new TelaUsuarios();
                TelaModuloConfiguracoes.jPainelConfiguracoes.add(objUser);//adicona frame ao JDesktopPane  
                objUser.setVisible(true);
            }
        }
        try {
            objUser.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jMenuItemUsuariosActionPerformed

    private void jMenuItemLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogActionPerformed
        // TODO add your handling code here: 
        if (objLogSys == null || objLogSys.isClosed()) {
            objLogSys = new TelaLogSistema();
            jPainelConfiguracoes.add(objLogSys);
            objLogSys.setVisible(true);
        } else {
            if (objLogSys.isVisible()) {
                if (objLogSys.isIcon()) { // Se esta minimizado
                    try {
                        objLogSys.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objLogSys.toFront(); // traz para frente
                    objLogSys.pack();//volta frame 
                }
            } else {
                objLogSys = new TelaLogSistema();
                TelaModuloConfiguracoes.jPainelConfiguracoes.add(objLogSys);//adicona frame ao JDesktopPane  
                objLogSys.setVisible(true);
            }
        }
        try {
            objLogSys.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jMenuItemLogActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        // O aplicativo tem que está no diretorio c:\windows\system ou C:\Windows\SysWOW64
        calcPena();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        CalcWindows();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        if (objRecadoRoot == null || objRecadoRoot.isClosed()) {
            objRecadoRoot = new TelaRecadosAdministrador();
            jPainelConfiguracoes.add(objRecadoRoot);
            objRecadoRoot.setVisible(true);
        } else {
            if (objRecadoRoot.isVisible()) {
                if (objRecadoRoot.isIcon()) { // Se esta minimizado
                    try {
                        objRecadoRoot.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRecadoRoot.toFront(); // traz para frente
                    objRecadoRoot.pack();//volta frame 
                }
            } else {
                objRecadoRoot = new TelaRecadosAdministrador();
                TelaModuloConfiguracoes.jPainelConfiguracoes.add(objRecadoRoot);//adicona frame ao JDesktopPane  
                objRecadoRoot.setVisible(true);
            }
        }
        try {
            objRecadoRoot.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void UsuariosConectadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuariosConectadosActionPerformed
        // TODO add your handling code here:
        if (objUserConecta == null || objUserConecta.isClosed()) {
            objUserConecta = new TelaUsuariosConectados();
            jPainelConfiguracoes.add(objUserConecta);
            objUserConecta.setVisible(true);
        } else {
            if (objUserConecta.isVisible()) {
                if (objUserConecta.isIcon()) { // Se esta minimizado
                    try {
                        objUserConecta.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objUserConecta.toFront(); // traz para frente
                    objUserConecta.pack();//volta frame 
                }
            } else {
                objUserConecta = new TelaUsuariosConectados();
                TelaModuloConfiguracoes.jPainelConfiguracoes.add(objUserConecta);//adicona frame ao JDesktopPane  
                objUserConecta.setVisible(true);
            }
        }
        try {
            objUserConecta.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_UsuariosConectadosActionPerformed

    private void EmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpresaActionPerformed
        // TODO add your handling code here:
        if (objEmpresa == null || objEmpresa.isClosed()) {
            objEmpresa = new TelaEmpresa();
            jPainelConfiguracoes.add(objEmpresa);
            objEmpresa.setVisible(true);
        } else {
            if (objEmpresa.isVisible()) {
                if (objEmpresa.isIcon()) { // Se esta minimizado
                    try {
                        objEmpresa.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objEmpresa.toFront(); // traz para frente
                    objEmpresa.pack();//volta frame 
                }
            } else {
                objEmpresa = new TelaEmpresa();
                TelaModuloConfiguracoes.jPainelConfiguracoes.add(objEmpresa);//adicona frame ao JDesktopPane  
                objEmpresa.setVisible(true);
            }
        }
        try {
            objEmpresa.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_EmpresaActionPerformed

    private void ConsultaGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaGruposActionPerformed
        // TODO add your handling code here:
        if (objConsuGrupo == null || objConsuGrupo.isClosed()) {
            objConsuGrupo = new TelaConsultaUsuariosGrupo();
            jPainelConfiguracoes.add(objConsuGrupo);
            objConsuGrupo.setVisible(true);
        } else {
            if (objConsuGrupo.isVisible()) {
                if (objConsuGrupo.isIcon()) { // Se esta minimizado
                    try {
                        objConsuGrupo.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConsuGrupo.toFront(); // traz para frente
                    objConsuGrupo.pack();//volta frame 
                }
            } else {
                objConsuGrupo = new TelaConsultaUsuariosGrupo();
                TelaModuloConfiguracoes.jPainelConfiguracoes.add(objConsuGrupo);//adicona frame ao JDesktopPane  
                objConsuGrupo.setVisible(true);
            }
        }
        try {
            objConsuGrupo.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ConsultaGruposActionPerformed

    private void JMenuSQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuSQLActionPerformed
        // TODO add your handling code here:
        TableExample objSQL = new TableExample();
        objSQL.createConnectionDialog();
    }//GEN-LAST:event_JMenuSQLActionPerformed

    private void jFechamentoSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFechamentoSistemaActionPerformed
        // TODO add your handling code here:
        mostrarFechamento();
    }//GEN-LAST:event_jFechamentoSistemaActionPerformed

    private void jAbrirTodosMovimentacaoSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAbrirTodosMovimentacaoSistemaActionPerformed
        // TODO add your handling code here:
        mostrarAberturaFechamento();
    }//GEN-LAST:event_jAbrirTodosMovimentacaoSistemaActionPerformed

    private void jAbrirMovimentoIndividualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAbrirMovimentoIndividualActionPerformed
        // TODO add your handling code here:
        if (objAbriMov == null || objAbriMov.isClosed()) {
            objAbriMov = new TelaAbirMovimentoFinalizado();
            jPainelConfiguracoes.add(objAbriMov);
            objAbriMov.setVisible(true);
        } else {
            if (objAbriMov.isVisible()) {
                if (objAbriMov.isIcon()) { // Se esta minimizado
                    try {
                        objAbriMov.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objAbriMov.toFront(); // traz para frente
                    objAbriMov.pack();//volta frame 
                }
            } else {
                objAbriMov = new TelaAbirMovimentoFinalizado();
                TelaModuloConfiguracoes.jPainelConfiguracoes.add(objAbriMov);//adicona frame ao JDesktopPane  
                objAbriMov.setVisible(true);
            }
        }
        try {
            objAbriMov.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jAbrirMovimentoIndividualActionPerformed

    private void jParamentosSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jParamentosSistemaActionPerformed
        // TODO add your handling code here:
        TelaParamentrosSistema objParSis = new TelaParamentrosSistema();
        TelaModuloConfiguracoes.jPainelConfiguracoes.add(objParSis);
        objParSis.show();
    }//GEN-LAST:event_jParamentosSistemaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ConsultaGrupos;
    private javax.swing.JMenuItem Empresa;
    private javax.swing.JMenuItem JMenuSQL;
    private javax.swing.JMenuItem UsuariosConectados;
    private javax.swing.JMenuItem jAbrirMovimentoIndividual;
    private javax.swing.JMenu jAbrirMovimetacaoSistema;
    private javax.swing.JMenuItem jAbrirTodosMovimentacaoSistema;
    private javax.swing.JMenuItem jFechamentoSistema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItemGrupos;
    private javax.swing.JMenuItem jMenuItemLog;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenuItem jMenuItemUsuarios;
    public static javax.swing.JDesktopPane jPainelConfiguracoes;
    private javax.swing.JMenuItem jParamentosSistema;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    // End of variables declaration//GEN-END:variables

    // Verificar a cada 5 minutos se o recado foi lido (10/01/2015)
    public void threadMensagem() {
        final Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                verificarRecado(); // Verificar recados a cada 5 minutos              
            }
        }, periodo, tempo);
    }
// Chama a calculadora de pena para o java

    public void calcPena() {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start calcpena.exe");
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
// Calculadora do Windows

    public void CalcWindows() {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start calc.exe");
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void verificarRecado() {
        buscarUsuario(nameUser);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AGENDARECADOS "
                    + "WHERE IdUsuario='" + codUsuario + "' "
                    + "AND StatusAgenda='" + statusAgenda + "'");
            conecta.rs.first();
            if (codUsuario == conecta.rs.getInt("IdUsuario")) {
                TelaRecadosAdministrador objRecados = new TelaRecadosAdministrador();
                TelaModuloConfiguracoes.jPainelConfiguracoes.add(objRecados);
                objRecados.show();
                flag = 1;
                preencherTabelaTodosRecados("SELECT * FROM AGENDARECADOS "
                        + "INNER JOIN USUARIOS "
                        + "ON AGENDARECADOS.IdUsuario=USUARIOS.IdUsuario "
                        + "WHERE NomeUsuario='" + nameUser + "' "
                        + "AND StatusAgenda='" + statusAgenda + "'");
                if (flag == 1) {
                    jBtNovo.setEnabled(true);
                    jBtAlterar.setEnabled(true);
                    jBtExcluir.setEnabled(true);
                    jBtSalvar.setEnabled(!true);
                    jBtCancelar.setEnabled(true);
                    jBtResponder.setEnabled(true);
                    jBtConfirmar.setEnabled(true);
                    conecta.abrirConexao();
                    try {
                        conecta.executaSQL("SELECT * FROM AGENDARECADOS "
                                + "INNER JOIN USUARIOS "
                                + "ON AGENDARECADOS.IdUsuario=USUARIOS.IdUsuario "
                                + "WHERE NomeUsuario='" + nameUser + "' "
                                + "AND StatusAgenda='" + statusAgenda + "'");
                        conecta.rs.last();
                        jIDLanc.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                        jDataLanc.setDate(conecta.rs.getDate("DataLanc"));
                        jHoraRecado.setText(conecta.rs.getString("Horario"));
                        jComboBoxStatus.setSelectedItem(conecta.rs.getString("StatusAgenda"));
                        jNomeRementente.setText(conecta.rs.getString("NomeUsuarioLogado"));
                        jNomeDestinatario.setText(conecta.rs.getString("NomeUsuario"));
                        jRecado.setText(conecta.rs.getString("Recados"));
                        conecta.desconecta();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados...\nERRO: " + e);
                    }
                    conecta.desconecta();
                }
            }
        } catch (SQLException ex) {
            //  JOptionPane.showMessageDialog(rootPane, "Não foi possível verificar mensagem.\nERRO:" + ex);
        }
    }

    public void buscarUsuario(String nomeUser) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nomeUser + "'");
            conecta.rs.first();
            codUsuario = conecta.rs.getInt("IdUsuario");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível encontrar o usuário.\nERRO: " + ex);
        }
    }

    public void preencherTabelaTodosRecados(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", " Data", " Remetente", " Destinatário"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.last();
            do {
                // Formatar a data Entrada
                dataLanc = conecta.rs.getString("DataLanc");
                String dia = dataLanc.substring(8, 10);
                String mes = dataLanc.substring(5, 7);
                String ano = dataLanc.substring(0, 4);
                dataLanc = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataLanc, conecta.rs.getString("NomeUsuarioLogado"), conecta.rs.getString("NomeUsuario")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe dados a ser exibido!!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaTodosRecados.setModel(modelo);
        jTabelaTodosRecados.getColumnModel().getColumn(0).setPreferredWidth(52);
        jTabelaTodosRecados.getColumnModel().getColumn(0).setResizable(false);
        jTabelaTodosRecados.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaTodosRecados.getColumnModel().getColumn(1).setResizable(false);
        jTabelaTodosRecados.getColumnModel().getColumn(2).setPreferredWidth(280);
        jTabelaTodosRecados.getColumnModel().getColumn(2).setResizable(false);
        jTabelaTodosRecados.getColumnModel().getColumn(3).setPreferredWidth(280);
        jTabelaTodosRecados.getColumnModel().getColumn(3).setResizable(false);
        jTabelaTodosRecados.getTableHeader().setReorderingAllowed(false);
        jTabelaTodosRecados.setAutoResizeMode(jTabelaTodosRecados.AUTO_RESIZE_OFF);
        jTabelaTodosRecados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }
}
