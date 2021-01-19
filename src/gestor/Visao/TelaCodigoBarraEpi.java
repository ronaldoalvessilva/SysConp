/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAcessoGeral;
import gestor.Controle.ControleEquipamentoEPI;
import gestor.Controle.ControleLogSistema;
import gestor.Modelo.CamposAcessos;
import gestor.Modelo.EquipamentoSegurancaEPI;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaEquipamentosEPI.caminho;
import static gestor.Visao.TelaEquipamentosEPI.jCodigoBarraEquipamento;
import static gestor.Visao.TelaEquipamentosEPI.jCodigoEquipamento;
import static gestor.Visao.TelaEquipamentosEPI.jDescricaoEquipamento;
import static gestor.Visao.TelaEquipamentosEPI.jNumeroCodigoBarras;
import static gestor.Visao.TelaEquipamentosEPI.pRESPOSTA_epi;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloSeguranca.telaArmasCODIGO_barras;
import static gestor.Visao.TelaModuloSeguranca.telaEquipamentosCODIGO_barras;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

/**
 *
 * @author ronaldo.silva7
 */
public class TelaCodigoBarraEpi extends javax.swing.JDialog {

    EquipamentoSegurancaEPI objEquipa = new EquipamentoSegurancaEPI();
    ControleEquipamentoEPI CONTROL = new ControleEquipamentoEPI();
    //
    ControleAcessoGeral pPESQUISAR_acessos = new ControleAcessoGeral();
    CamposAcessos objCampos = new CamposAcessos();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Segurança:Código de Barra de EPI:Manutenção";
    //
    byte[] pCODIGO_barra = null;
    int acao = 0;
    public static String pRESPOSTA_codigo = "";
    public static Integer pCODIGO_BArra = 0;
    public static String pNUMERO_equipamento = "";
    //
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    String pCAMINHO_barra = "";

    /**
     * Creates new form TelaCodigoBarraArma
     */
    public static TelaEquipamentosEPI pTELA_epis;

    public TelaCodigoBarraEpi(TelaEquipamentosEPI parent, boolean modal) {
        this.pTELA_epis = parent;
        this.setModal(modal);
        setLocationRelativeTo(pTELA_epis);
        initComponents();
        corCampos();
        pBUSCAR_DADOS_banco();
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
        jLabel3 = new javax.swing.JLabel();
        jCODIGO_barras = new javax.swing.JTextField();
        jNUMERO_serie = new javax.swing.JTextField();
        jDESCRICAO_arma = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jFOTO_CODIGO_barra = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jBtGerarCodigo = new javax.swing.JButton();
        jBtExcluirCodigo = new javax.swing.JButton();
        jBtAlterarCodigo = new javax.swing.JButton();
        jBtSalvarCodigo = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtCancelarCodigo = new javax.swing.JButton();
        jBtBuscarDados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Gerar  Código de Barras :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Número de Série");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Descrição da Arma");

        jCODIGO_barras.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCODIGO_barras.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCODIGO_barras.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jCODIGO_barras.setEnabled(false);

        jNUMERO_serie.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jNUMERO_serie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNUMERO_serie.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNUMERO_serie.setEnabled(false);

        jDESCRICAO_arma.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDESCRICAO_arma.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jDESCRICAO_arma.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDESCRICAO_arma, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jCODIGO_barras, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jNUMERO_serie, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCODIGO_barras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNUMERO_serie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDESCRICAO_arma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Código Barras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 0))); // NOI18N

        jFOTO_CODIGO_barra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jFOTO_CODIGO_barra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jFOTO_CODIGO_barra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtGerarCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtGerarCodigo.setText("Gerar Código");
        jBtGerarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtGerarCodigoActionPerformed(evt);
            }
        });

        jBtExcluirCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluirCodigo.setText("Excluir");
        jBtExcluirCodigo.setEnabled(false);
        jBtExcluirCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirCodigoActionPerformed(evt);
            }
        });

        jBtAlterarCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarCodigo.setText("Alterar");
        jBtAlterarCodigo.setEnabled(false);
        jBtAlterarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarCodigoActionPerformed(evt);
            }
        });

        jBtSalvarCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarCodigo.setText("Gravar");
        jBtSalvarCodigo.setEnabled(false);
        jBtSalvarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarCodigoActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtCancelarCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarCodigo.setText("Cancelar");
        jBtCancelarCodigo.setEnabled(false);
        jBtCancelarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarCodigoActionPerformed(evt);
            }
        });

        jBtBuscarDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtBuscarDados.setText("Buscar Dados");
        jBtBuscarDados.setToolTipText("Buscar Dados");
        jBtBuscarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarDadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtBuscarDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtGerarCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jBtAlterarCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
                        .addComponent(jBtSair))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jBtExcluirCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSalvarCodigo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarCodigo, jBtExcluirCodigo, jBtGerarCodigo, jBtSair, jBtSalvarCodigo});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtExcluirCodigo)
                    .addComponent(jBtSalvarCodigo)
                    .addComponent(jBtBuscarDados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtAlterarCodigo)
                    .addComponent(jBtSair)
                    .addComponent(jBtCancelarCodigo)
                    .addComponent(jBtGerarCodigo))
                .addGap(4, 4, 4))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarCodigo, jBtExcluirCodigo, jBtGerarCodigo, jBtSair, jBtSalvarCodigo});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtGerarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtGerarCodigoActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaEquipamentosCODIGO_barras);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaEquipamentosCODIGO_barras) && objCampos.getCodigoIncluir() == 1) {
            acao = 1;
            Novo();
            statusMov = "Inclui";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            pGERAR_CODIGO_barra(jNumeroCodigoBarras.getText());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtGerarCodigoActionPerformed

    private void jBtBuscarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarDadosActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaEquipamentosCODIGO_barras);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaEquipamentosCODIGO_barras) && objCampos.getCodigoIncluir() == 1) {
            if (jCODIGO_barras.getText().equals("")) {
                pBUSCAR_dados();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Já existe um código de barra.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtBuscarDadosActionPerformed

    private void jBtAlterarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarCodigoActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaEquipamentosCODIGO_barras);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaEquipamentosCODIGO_barras) && objCampos.getCodigoAlterar() == 1) {
            acao = 2;
            pBUSCAR_dados();
            Alterar();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarCodigoActionPerformed

    private void jBtExcluirCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirCodigoActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaEquipamentosCODIGO_barras);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaEquipamentosCODIGO_barras) && objCampos.getCodigoExcluir() == 1) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                BloquearBotoes(!true);
                objEquipa.setIdEquipamento(Integer.valueOf(jCodigoEquipamento.getText()));
                CONTROL.excluirCODIGO_barra(objEquipa);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                if (pRESPOSTA_codigo.equals("Sim")) {
                    JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Não foi possível excluir os dados, tente novamente.");
                }
                BloquearBotoes(!true);
                limparCampos();
                Excluir();
                if (pRESPOSTA_codigo.equals("Sim")) {
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "não foi possível gravar o registro, tente novamente ou entre em contato com o administrador do sistema.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirCodigoActionPerformed

    private void jBtSalvarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarCodigoActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaEquipamentosCODIGO_barras);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaEquipamentosCODIGO_barras) && objCampos.getCodigoGravar() == 1) {
            if (jCODIGO_barras.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível gravar, o código do registro está em branco.");
            } else if (jNUMERO_serie.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível gravar, o número de série esta em branco.");
            } else if (jDESCRICAO_arma.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Não é possível gravar, a descrição do registro está em branco.");
            } else {
                objEquipa.setIdEquipamento(Integer.valueOf(jCodigoEquipamento.getText()));
                objEquipa.setNumeroCodigoBarras(jNumeroCodigoBarras.getText());
                objEquipa.setCodigoBarra(pCODIGO_barra);
                if (acao == 1) {
                    //VERIFICAR SE JÁ EXISTE UM REGISTRO GRAVADO
                    CONTROL.pVERIFICAR_CODIGO_barra(objEquipa);
                    if (jCodigoEquipamento.getText().equals(pNUMERO_equipamento)) {
                        JOptionPane.showMessageDialog(rootPane, "Já foi cadastrado um código de barras para esse EPI.");
                    } else {
                        CONTROL.incluirCODIGO_barra(objEquipa);
                        pBUSCAR_codigo();
                        CONTROL.alterarCodigoBarraEpi(objEquipa);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        Salvar();
                        if (pRESPOSTA_epi.equals("Sim")) {
                            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        } else if (pRESPOSTA_epi.equals("Não")) {
                            JOptionPane.showMessageDialog(rootPane, "não foi possível gravar o registro, tente novamente ou entre em contato com o administrador do sistema.");
                        }
                    }
                }
                if (acao == 2) {
                    objEquipa.setIdEquipamento(Integer.valueOf(jCodigoEquipamento.getText()));
                    CONTROL.alterarCODIGO_barra(objEquipa);
                    CONTROL.alterarCodigoBarraEpi(objEquipa);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    Salvar();
                    if (pRESPOSTA_codigo.equals("Sim")) {
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "não foi possível gravar o registro, tente novamente ou entre em contato com o administrador do sistema.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtSalvarCodigoActionPerformed

    private void jBtCancelarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarCodigoActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarCodigoActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCodigoBarraEpi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCodigoBarraEpi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCodigoBarraEpi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCodigoBarraEpi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCodigoBarraEpi dialog = new TelaCodigoBarraEpi(pTELA_epis, true);
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
    private javax.swing.JButton jBtAlterarCodigo;
    private javax.swing.JButton jBtBuscarDados;
    private javax.swing.JButton jBtCancelarCodigo;
    private javax.swing.JButton jBtExcluirCodigo;
    private javax.swing.JButton jBtGerarCodigo;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvarCodigo;
    private javax.swing.JTextField jCODIGO_barras;
    private javax.swing.JTextField jDESCRICAO_arma;
    public static javax.swing.JLabel jFOTO_CODIGO_barra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JTextField jNUMERO_serie;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jCODIGO_barras.setBackground(Color.white);
        jNUMERO_serie.setBackground(Color.white);
        jDESCRICAO_arma.setBackground(Color.white);
    }

    public void pBUSCAR_dados() {
        jCODIGO_barras.setText(jCodigoEquipamento.getText());
        jNUMERO_serie.setText(jNumeroCodigoBarras.getText());
        jDESCRICAO_arma.setText(jDescricaoEquipamento.getText());
    }

    public void BloquearBotoes(boolean opcao) {
        jBtGerarCodigo.setEnabled(opcao);
        jBtBuscarDados.setEnabled(opcao);
        jBtAlterarCodigo.setEnabled(opcao);
        jBtExcluirCodigo.setEnabled(opcao);
        jBtSalvarCodigo.setEnabled(opcao);
        jBtCancelarCodigo.setEnabled(opcao);
    }

    public void limparCampos() {
        jCODIGO_barras.setText("");
        jNUMERO_serie.setText("");
        jDESCRICAO_arma.setText("");
    }

    public void Novo() {
        jBtSalvarCodigo.setEnabled(true);
        jBtCancelarCodigo.setEnabled(true);
    }

    public void Alterar() {
        jBtSalvarCodigo.setEnabled(true);
        jBtCancelarCodigo.setEnabled(true);
    }

    public void Excluir() {
        jBtBuscarDados.setEnabled(true);
    }

    public void Salvar() {
        jBtExcluirCodigo.setEnabled(true);
        jBtAlterarCodigo.setEnabled(true);
    }

    public void Cancelar() {
        jBtBuscarDados.setEnabled(true);
        jBtCancelarCodigo.setEnabled(true);
    }

    public void pBUSCAR_codigo() {
        CONTROL.pBUSCAR_CODIGO_barra(objEquipa);
    }

    public void pBUSCAR_DADOS_banco() {
        try {
            for (EquipamentoSegurancaEPI cc : CONTROL.pPESQUISAR_CODIGO_barras_read()) {
                jCODIGO_barras.setText(String.valueOf(cc.getIdEquipamento()));
                jNUMERO_serie.setText(cc.getNumeroCodigoBarras());
                jDESCRICAO_arma.setText(cc.getDescricaoEquipamento());
                //
                byte[] imgBytes2 = ((byte[]) cc.getCodigoBarra());
                if (imgBytes2 != null) {
                    ImageIcon pic2 = null;
                    pic2 = new ImageIcon(imgBytes2);
                    Image scaled2 = pic2.getImage().getScaledInstance(jFOTO_CODIGO_barra.getWidth(), jFOTO_CODIGO_barra.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon2 = new ImageIcon(scaled2);
                    jFOTO_CODIGO_barra.setIcon(icon2);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaCodigoBarraEpi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pGERAR_CODIGO_barra(String value) {

        try {
            Barcode barcode = BarcodeFactory.createCode128(value);
            barcode.setDrawingText(true); //NÃO ESCREVE O CÓDIGO JUNTO COM AS BARRAS
            // CRIANDO O DESENHO DAS BARRAS
            BufferedImage image = new BufferedImage(100, 150, BufferedImage.TYPE_BYTE_GRAY);
            Graphics2D g = (Graphics2D) image.getGraphics();
            g.setBackground(Color.BLUE);
            barcode.draw(g, 10, 56);
            //SALVANDO ARQUIVO NO DISCO
            File f = new File("C:\\SysConp\\Fotos\\CodigoBarra\\" + jCodigoEquipamento.getText() + ".jpg");
            BarcodeImageHandler.savePNG(barcode, f);
            //MOSTRAR O CÓDIGO DE BARRA NA TELA
            caminho = f.getAbsolutePath();
            ImageIcon imagemicon = new ImageIcon(new ImageIcon(caminho).getImage().getScaledInstance(jFOTO_CODIGO_barra.getWidth(), jFOTO_CODIGO_barra.getHeight(), Image.SCALE_SMOOTH));
            jFOTO_CODIGO_barra.setIcon(imagemicon);
            //
            ImageIcon imagemicon1 = new ImageIcon(new ImageIcon(caminho).getImage().getScaledInstance(jCodigoBarraEquipamento.getWidth(), jCodigoBarraEquipamento.getHeight(), Image.SCALE_SMOOTH));
            jCodigoBarraEquipamento.setIcon(imagemicon1);
            try {
                File image1 = new File(caminho);
                FileInputStream fis = new FileInputStream(image1);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for (int readNum; (readNum = fis.read(buf)) != -1;) {
                    bos.write(buf, 0, readNum);
                }
                pCODIGO_barra = bos.toByteArray();
            } catch (Exception e) {
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    //IMPRESSÃO DE CÓDIGO DE BARRAS - CRIADO EM 09/01/2021 (AINDA NÃO FOI UTILIZADO)
    //        try {
//            Barcode barcode = BarcodeFactory.createCode128("1");
//            jCodigoBarraArma.setIcon((Icon) barcode);
//            PrinterJob printerJob = PrinterJob.getPrinterJob();
//            printerJob.setPrintable(barcode);
//            if(printerJob.printDialog()){
//                try {
//                    printerJob.print();
//                } catch (PrinterException ex) {
//                    Logger.getLogger(TelaArmas.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        } catch (BarcodeException ex) {
//            Logger.getLogger(TelaArmas.class.getName()).log(Level.SEVERE, null, ex);
//        }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(pCODIGO_BArra));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
