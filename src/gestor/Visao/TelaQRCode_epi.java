/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import gestor.Controle.ControleAcessoGeral;
import gestor.Controle.ControleEquipamentoEPI;
import gestor.Controle.ControleLogSistema;
import gestor.Modelo.CamposAcessos;
import gestor.Modelo.EquipamentoSegurancaEPI;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaEquipamentosEPI.jCodigoEquipamento;
import static gestor.Visao.TelaEquipamentosEPI.jComprimentoEquipamento;
import static gestor.Visao.TelaEquipamentosEPI.jDescricaoEquipamento;
import static gestor.Visao.TelaEquipamentosEPI.jMarcaEquipamento;
import static gestor.Visao.TelaEquipamentosEPI.jModeloEquipamento;
import static gestor.Visao.TelaEquipamentosEPI.jNumeroCodigoBarras;
import static gestor.Visao.TelaEquipamentosEPI.jTipoMaterialEquipamento;
import static gestor.Visao.TelaEquipamentosEPI.jQRCodeEquipamento;
import static gestor.Visao.TelaEquipamentosEPI.pRESPOSTA_epi;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaModuloSeguranca.telaEquipamentosQRCode;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 *
 * @author ronaldo.silva7
 */
public class TelaQRCode_epi extends javax.swing.JDialog {

    EquipamentoSegurancaEPI objEquipa = new EquipamentoSegurancaEPI();
    ControleEquipamentoEPI CONTROL = new ControleEquipamentoEPI();
    //
    ControleAcessoGeral pPESQUISAR_acessos = new ControleAcessoGeral();
    CamposAcessos objCampos = new CamposAcessos();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Segurança:QRCode de EPI:Manutenção";
    //
    int acao = 0;
    String statusMov;
    String horaMov;
    String dataModFinal;
    public static String caminho = "";
    byte[] pQRCode_imagem = null;
    public static Integer pCODIGO_QRCode = 0;
    public static String pNUMERO_EQUIP_epi = "";

    /**
     * Creates new form TelaQRCode_Arama
     */
    public static TelaEquipamentosEPI pEPIS_epi;

    public TelaQRCode_epi(TelaEquipamentosEPI parent, boolean modal) {
        this.pEPIS_epi = parent;
        this.setModal(modal);
        setLocationRelativeTo(pEPIS_epi);
        initComponents();
        corCampos();
        pPESQUISAR_dados();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextoQRCode = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jQRCode = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jBtSalvarQRCode = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtAlterarTexto = new javax.swing.JButton();
        jBtExcluirQRCode = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jBtCodificarTexto = new javax.swing.JButton();
        jBtGerarArquivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: QRCode :::...");
        setIconImage(Toolkit.getDefaultToolkit().getImage("/gestor/Imagens/codigo-qr_16.png"));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jTextoQRCode.setColumns(20);
        jTextoQRCode.setRows(5);
        jTextoQRCode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoQRCode.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextoQRCode.setEnabled(false);
        jScrollPane1.setViewportView(jTextoQRCode);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1)
                .addGap(3, 3, 3))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jQRCode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jQRCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jQRCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código - (QRCode)");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtSalvarQRCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarQRCode.setText("Gravar QRCode");
        jBtSalvarQRCode.setEnabled(false);
        jBtSalvarQRCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarQRCodeActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtAlterarTexto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarTexto.setText("Alterar Texto");
        jBtAlterarTexto.setEnabled(false);
        jBtAlterarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarTextoActionPerformed(evt);
            }
        });

        jBtExcluirQRCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluirQRCode.setText("Excluir QRCode");
        jBtExcluirQRCode.setEnabled(false);
        jBtExcluirQRCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirQRCodeActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setText("Cancelar Operação");
        jBtCancelar.setEnabled(false);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAlterarTexto)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelar)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluirQRCode)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvarQRCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtSair)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarTexto, jBtCancelar, jBtExcluirQRCode, jBtSair, jBtSalvarQRCode});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAlterarTexto)
                    .addComponent(jBtExcluirQRCode)
                    .addComponent(jBtSalvarQRCode)
                    .addComponent(jBtSair)
                    .addComponent(jBtCancelar))
                .addGap(4, 4, 4))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarTexto, jBtExcluirQRCode, jBtSair, jBtSalvarQRCode});

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtCodificarTexto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtCodificarTexto.setText("Buscar Texto");
        jBtCodificarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCodificarTextoActionPerformed(evt);
            }
        });

        jBtGerarArquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/codigo-qr_16.png"))); // NOI18N
        jBtGerarArquivo.setText("Gerar Arquivo");
        jBtGerarArquivo.setEnabled(false);
        jBtGerarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtGerarArquivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtCodificarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtGerarArquivo)
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtCodificarTexto, jBtGerarArquivo});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtGerarArquivo)
                    .addComponent(jBtCodificarTexto))
                .addGap(4, 4, 4))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtCodificarTexto, jBtGerarArquivo});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtCodificarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCodificarTextoActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaEquipamentosQRCode);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaEquipamentosQRCode) && objCampos.getCodigoConsultar() == 1) {
            acao = 3;
            jTextoQRCode.setText("");
            BloquearBotoes(!true);
            jTextoQRCode.setText("Código " + jNumeroCodigoBarras.getText() + "\n" + jDescricaoEquipamento.getText() + "  " + jMarcaEquipamento.getText() + "  " + jModeloEquipamento.getText() + " " + jComprimentoEquipamento.getText() + "\nTipo de Material " + jTipoMaterialEquipamento.getText());
            BuscarTexto();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtCodificarTextoActionPerformed

    private void jBtGerarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtGerarArquivoActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaEquipamentosQRCode);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaEquipamentosQRCode) && objCampos.getCodigoAlterar() == 1) {
            if (jTextoQRCode.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe os dados para geraro QRCode da arma.");
            } else {
                statusMov = "Inclui";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                //
                int size = 125; //TAMANHO DEFAULT DO QRCode
                ByteArrayOutputStream out = QRCode.from(jTextoQRCode.getText()).to(ImageType.PNG).withSize(size, size).stream();
                pQRCode_imagem = out.toByteArray();
                byte[] imgBytes = ((byte[]) pQRCode_imagem);
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jQRCode.getWidth(), jQRCode.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon(scaled);
                    jQRCode.setIcon(icon);
                }
                //MOSTRAR A IMAGEM TAMBÉM NO FOMULÁRIO 
                mMOSTRAR_QRCode();
                BloquearBotoes(!true);
                GerarQRCode();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtGerarArquivoActionPerformed

    private void jBtAlterarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarTextoActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaEquipamentosQRCode);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaEquipamentosQRCode) && objCampos.getCodigoAlterar() == 1) {
            acao = 4;
            BloquearBotoes(!true);
            AlterarTexto();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarTextoActionPerformed

    private void jBtExcluirQRCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirQRCodeActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaEquipamentosQRCode);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaEquipamentosQRCode) && objCampos.getCodigoExcluir() == 1) {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                bloquearCampos();
                BloquearBotoes(!true);
                objEquipa.setIdEquipamento(Integer.valueOf(jCodigoEquipamento.getText()));
                CONTROL.excluirQRCode(objEquipa);
                if (pRESPOSTA_epi.equals("Sim")) {
                    JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Não foi possível excluir os dados, tente novamente.");
                }
                limparCampos();
                ExcluirQRCode();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirQRCodeActionPerformed

    private void jBtSalvarQRCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarQRCodeActionPerformed
        // TODO add your handling code here:
        objCampos.setNomeUsuario(nameUser);
        objCampos.setNomeTelaAcesso(telaEquipamentosQRCode);
        pPESQUISAR_acessos.pesquisarUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarGrupoUsuario(objCampos);
        pPESQUISAR_acessos.pesquisarTelasAcesso(objCampos);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || objCampos.getNomeGrupo().equals("ADMINISTRADORES") || objCampos.getCodigoUsuario() == objCampos.getCodigoUsuarioAcesso() && objCampos.getNomeTelaAcesso().equals(telaEquipamentosQRCode) && objCampos.getCodigoGravar() == 1) {
            if (jTextoQRCode.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "É necessário ter um código gerado para gravar o QRCode.");
            } else {
                objEquipa.setIdEquipamento(Integer.valueOf(jCodigoEquipamento.getText()));
                objEquipa.setTextoQRCode(jTextoQRCode.getText());
                objEquipa.setqRCodeEquipamento(pQRCode_imagem);
                if (acao == 3) {
                    //VERIFICAR A EXISTÊNCIA OU NÃO DO QRCODE
                    CONTROL.pVERIFICAR_QRCode_codigo(objEquipa);
                    if (jCodigoEquipamento.getText().equals(pNUMERO_EQUIP_epi)) {
                        JOptionPane.showMessageDialog(rootPane, "Já existe um QRCode para esse material.");
                    } else {
                        BloquearBotoes(!true);
                        CONTROL.incluirQRCode(objEquipa);
                        pBUSCAR_QRCode();
                        CONTROL.alterarQRCodeEpi(objEquipa);
                        objLog();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        if (pRESPOSTA_epi.equals("Sim")) {
                            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        } else if (pRESPOSTA_epi.equals("Não")) {
                            JOptionPane.showMessageDialog(rootPane, "Não foi possível gravar o registro, tente novamente.");
                        }
                        SalvarQRCode();
                    }
                }
                if (acao == 4) {
                    BloquearBotoes(!true);
                    CONTROL.alterarQRCode(objEquipa);
                    CONTROL.alterarQRCodeEpi(objEquipa);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    if (pRESPOSTA_epi.equals("Sim")) {
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    } else if (pRESPOSTA_epi.equals("Não")) {
                        JOptionPane.showMessageDialog(rootPane, "Não foi possível gravar o registro, tente novamente.");
                    }
                    SalvarQRCode();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtSalvarQRCodeActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        BloquearBotoes(!true);
        CancelarOperacao();
    }//GEN-LAST:event_jBtCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaQRCode_epi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaQRCode_epi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaQRCode_epi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaQRCode_epi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaQRCode_epi dialog = new TelaQRCode_epi(pEPIS_epi, true);
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
    private javax.swing.JButton jBtAlterarTexto;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCodificarTexto;
    private javax.swing.JButton jBtExcluirQRCode;
    private javax.swing.JButton jBtGerarArquivo;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvarQRCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jQRCode;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextoQRCode;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jTextoQRCode.setBackground(Color.white);
    }

    //MÉTODO PARA LER O QRCode (NÃO ESTÁ SENDO APLICADO NESSA TELA)
    public void QRCodeReader() {

        String nomeArquivoQRCode = "ARQUIVO_QRCode.png";
        try {
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(nomeArquivoQRCode)))));
            Result decodificador = new MultiFormatReader().decode(bitmap);
            System.out.println("QRCode: " + decodificador.getText());
            jTextoQRCode.setText(decodificador.getText());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void BloquearBotoes(boolean opcao) {
        jBtCodificarTexto.setEnabled(opcao);
        jBtGerarArquivo.setEnabled(opcao);
        jBtAlterarTexto.setEnabled(opcao);
        jBtCancelar.setEnabled(opcao);
        jBtExcluirQRCode.setEnabled(opcao);
        jBtSalvarQRCode.setEnabled(opcao);
    }

    public void bloquearCampos() {
        jTextoQRCode.setEnabled(!true);
    }

    public void limparCampos() {
        jTextoQRCode.setText("");
        jQRCode.setIcon(null);
        jQRCodeEquipamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/codigo-qr_64.png")));
        jQRCodeEquipamento.setEnabled(!true);
        //
        jQRCode.setIcon(null);
        jQRCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/codigo-qr_64.png")));
        jQRCode.setEnabled(!true);
    }

    public void BuscarTexto() {
        jTextoQRCode.setEnabled(!true);
        //
        jBtAlterarTexto.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtGerarArquivo.setEnabled(true);
    }

    public void AlterarTexto() {
        jTextoQRCode.setEnabled(true);
        //
        jBtCancelar.setEnabled(true);
    }

    public void ExcluirQRCode() {
        jTextoQRCode.setEnabled(!true);
        //
        jBtCodificarTexto.setEnabled(true);
    }

    public void GerarQRCode() {
        jTextoQRCode.setEnabled(!true);
        //
        jBtSalvarQRCode.setEnabled(true);
    }

    public void SalvarQRCode() {
        jBtCodificarTexto.setEnabled(true);
    }

    public void CancelarOperacao() {
        if (!jTextoQRCode.getText().equals("")) {
            jTextoQRCode.setEnabled(!true);
            //
            jBtCodificarTexto.setEnabled(true);
            jBtGerarArquivo.setEnabled(true);
        } else {
            jBtCodificarTexto.setEnabled(true);
        }
    }

    public void pBUSCAR_QRCode() {
        CONTROL.pBUSCAR_QRCode_codigo(objEquipa);
    }

    public void mMOSTRAR_QRCode() {
        byte[] imgBytes0 = ((byte[]) pQRCode_imagem);
        if (imgBytes0 != null) {
            ImageIcon pic0 = null;
            pic0 = new ImageIcon(imgBytes0);
            Image scaled0 = pic0.getImage().getScaledInstance(jQRCodeEquipamento.getWidth(), jQRCodeEquipamento.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon0 = new ImageIcon(scaled0);
            jQRCodeEquipamento.setIcon(icon0);
            jQRCodeEquipamento.setEnabled(true);
        }
    }

    public void pPESQUISAR_dados() {
        try {
            for (EquipamentoSegurancaEPI qq : CONTROL.pPESQUISAR_QRCode_read()) {
                qq.getIdEquipamento();
                jTextoQRCode.setText(qq.getTextoQRCode());
                //
                byte[] imgBytes0 = ((byte[]) qq.getqRCodeEquipamento());
                if (imgBytes0 != null) {
                    ImageIcon pic0 = null;
                    pic0 = new ImageIcon(imgBytes0);
                    Image scaled0 = pic0.getImage().getScaledInstance(jQRCode.getWidth(), jQRCode.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon icon0 = new ImageIcon(scaled0);
                    jQRCode.setIcon(icon0);
                    jQRCode.setEnabled(true);
                }
                if (!jTextoQRCode.getText().equals("")) {
                    jBtAlterarTexto.setEnabled(true);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaQRCode_epi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(pCODIGO_QRCode));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
