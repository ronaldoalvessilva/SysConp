/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovPrescricaoMedicaPsiquiatrica;
import gestor.Controle.ControlePrescricaoMedicaPsiquiatrica;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.AdmissaoMedica;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PrescricaoMedicaPsiquiatrica;
import static gestor.Visao.TelaAdmissaoMedica.jBtAlterarEvolPsiquiatrica;
import static gestor.Visao.TelaAdmissaoMedica.jBtAlterarEvolucao;
import static gestor.Visao.TelaAdmissaoMedica.jBtAuditoriaEvolPsiquiatrica;
import static gestor.Visao.TelaAdmissaoMedica.jBtAuditoriaEvolucao;
import static gestor.Visao.TelaAdmissaoMedica.jBtCancelarEvolPsiquiatrica;
import static gestor.Visao.TelaAdmissaoMedica.jBtCancelarEvolucao;
import static gestor.Visao.TelaAdmissaoMedica.jBtExcluirEvolPsiquiatrica;
import static gestor.Visao.TelaAdmissaoMedica.jBtExcluirEvolucao;
import static gestor.Visao.TelaAdmissaoMedica.jBtNovaEvolPsiquiatrica;
import static gestor.Visao.TelaAdmissaoMedica.jBtNovaEvolucao;
import static gestor.Visao.TelaAdmissaoMedica.jBtSalvarEvolPsiquiatrica;
import static gestor.Visao.TelaAdmissaoMedica.jBtSalvarEvolucao;
import static gestor.Visao.TelaAdmissaoMedica.jComboBoxPatologiaAdquirida;
import static gestor.Visao.TelaAdmissaoMedica.jDataEvolPsiquiatrica;
import static gestor.Visao.TelaAdmissaoMedica.jDataEvolucao;
import static gestor.Visao.TelaAdmissaoMedica.jIdAdm;
import static gestor.Visao.TelaAdmissaoMedica.jIdInternoAdm;
import static gestor.Visao.TelaAdmissaoMedica.jNomeInternoAdm;
import static gestor.Visao.TelaAdmissaoMedica.jTextoEvolucaoMedica;
import static gestor.Visao.TelaAdmissaoMedica.jTextoEvolucaoPsiquiatrica;
import static gestor.Visao.TelaEventoDisciplinar.jStatusLanc;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloEnfermaria.codAbrirENF;
import static gestor.Visao.TelaModuloEnfermaria.codAlterarENF;
import static gestor.Visao.TelaModuloEnfermaria.codConsultarENF;
import static gestor.Visao.TelaModuloEnfermaria.codExcluirENF;
import static gestor.Visao.TelaModuloEnfermaria.codGravarENF;
import static gestor.Visao.TelaModuloEnfermaria.codIncluirENF;
import static gestor.Visao.TelaModuloEnfermaria.codUserAcessoENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoGrupoENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoUserENF;
import static gestor.Visao.TelaModuloEnfermaria.codigoUserGroupENF;
import static gestor.Visao.TelaModuloEnfermaria.nomeGrupoENF;
import static gestor.Visao.TelaModuloEnfermaria.nomeTelaENF;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ronal
 */
public class TelaPrescricaoMedicaEnfermaria extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AdmissaoMedica objAdmMedico = new AdmissaoMedica();
    PrescricaoMedicaPsiquiatrica objPrescricao = new PrescricaoMedicaPsiquiatrica();
    ControlePrescricaoMedicaPsiquiatrica controlePrescricao = new ControlePrescricaoMedicaPsiquiatrica();
    ControleMovPrescricaoMedicaPsiquiatrica controleMovPrescricao = new ControleMovPrescricaoMedicaPsiquiatrica();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    //
    int flag = 0;
    int acao = 0;
    int tipoPrescricao;
    String nomeModuloTela4 = "Movimentação:Admissão Médica de Internos:Prescrição Médica/Psiquiatrica";
    String statusMov;
    String horaMov;
    String dataModFinal;
    String nomeUserRegistro;
    String deptoTecnico = "ENFERMARIA";
    String dataPrescricao = "";
    int idItemPrescricao;

    /**
     * Creates new form TelaPrescricaoMedicaEnfermaria
     */
    
    public static TelaAdmissaoMedica telaAdmissaoMedica;
    
    public TelaPrescricaoMedicaEnfermaria(TelaAdmissaoMedica parent, boolean modal) {
         this.telaAdmissaoMedica = parent;
        this.setModal(modal);
        setLocationRelativeTo(telaAdmissaoMedica);
        initComponents();
        preencherTabelaPrescricaoMedica("SELECT * FROM PRESCRICAO_MEDICA_PSIQUIATRICA "
                + "WHERE IdLanc='" + jIdAdm.getText() + "'");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTabelaPrescricaoMedica = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jBtNovaPrescicao = new javax.swing.JButton();
        jBtAlterarPrescicao = new javax.swing.JButton();
        jBtExcluirPrescicao = new javax.swing.JButton();
        jBtSalvarPrescicao = new javax.swing.JButton();
        jBtCancelarPrescicao = new javax.swing.JButton();
        jBtImpressaoPrescricao = new javax.swing.JButton();
        jBtAuditoriaPrescicao = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextoPrescricaoMedica = new javax.swing.JTextArea();
        jRBPrescricaoMedica = new javax.swing.JRadioButton();
        jRBPrescricaoPsiquiatrica = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        jIdPrescricaoMedica = new javax.swing.JTextField();
        jNomeInternoCrcPM = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jDataPM = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Prescriçao Médica/Psiquiatrica");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTabelaPrescricaoMedica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaPrescricaoMedica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Prescrição Médica/Psquiatrica"
            }
        ));
        jTabelaPrescricaoMedica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaPrescricaoMedicaMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTabelaPrescricaoMedica);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovaPrescicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaPrescicao.setToolTipText("Novo");
        jBtNovaPrescicao.setEnabled(false);
        jBtNovaPrescicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaPrescicaoActionPerformed(evt);
            }
        });

        jBtAlterarPrescicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarPrescicao.setToolTipText("Alterar");
        jBtAlterarPrescicao.setEnabled(false);
        jBtAlterarPrescicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarPrescicaoActionPerformed(evt);
            }
        });

        jBtExcluirPrescicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirPrescicao.setToolTipText("Excluir");
        jBtExcluirPrescicao.setEnabled(false);
        jBtExcluirPrescicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirPrescicaoActionPerformed(evt);
            }
        });

        jBtSalvarPrescicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarPrescicao.setToolTipText("Gravar");
        jBtSalvarPrescicao.setEnabled(false);
        jBtSalvarPrescicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarPrescicaoActionPerformed(evt);
            }
        });

        jBtCancelarPrescicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarPrescicao.setToolTipText("Cancelar");
        jBtCancelarPrescicao.setEnabled(false);
        jBtCancelarPrescicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarPrescicaoActionPerformed(evt);
            }
        });

        jBtImpressaoPrescricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImpressaoPrescricao.setEnabled(false);
        jBtImpressaoPrescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImpressaoPrescricaoActionPerformed(evt);
            }
        });

        jBtAuditoriaPrescicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaPrescicao.setContentAreaFilled(false);
        jBtAuditoriaPrescicao.setEnabled(false);
        jBtAuditoriaPrescicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaPrescicaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovaPrescicao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarPrescicao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirPrescicao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarPrescicao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarPrescicao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jBtImpressaoPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAuditoriaPrescicao, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtAuditoriaPrescicao)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtNovaPrescicao)
                        .addComponent(jBtSalvarPrescicao)
                        .addComponent(jBtAlterarPrescicao)
                        .addComponent(jBtExcluirPrescicao)
                        .addComponent(jBtCancelarPrescicao))
                    .addComponent(jBtImpressaoPrescricao))
                .addGap(31, 31, 31))
        );

        jTextoPrescricaoMedica.setColumns(20);
        jTextoPrescricaoMedica.setRows(5);
        jTextoPrescricaoMedica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoPrescricaoMedica.setEnabled(false);
        jScrollPane7.setViewportView(jTextoPrescricaoMedica);

        jRBPrescricaoMedica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBPrescricaoMedica.setForeground(new java.awt.Color(255, 0, 0));
        jRBPrescricaoMedica.setSelected(true);
        jRBPrescricaoMedica.setText("Prescrição Médica");
        jRBPrescricaoMedica.setEnabled(false);

        jRBPrescricaoPsiquiatrica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBPrescricaoPsiquiatrica.setForeground(new java.awt.Color(0, 0, 255));
        jRBPrescricaoPsiquiatrica.setText("Prescrição Psiquiatrica");
        jRBPrescricaoPsiquiatrica.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Código");

        jIdPrescricaoMedica.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdPrescricaoMedica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdPrescricaoMedica.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdPrescricaoMedica.setEnabled(false);

        jNomeInternoCrcPM.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoCrcPM.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeInternoCrcPM.setEnabled(false);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Nome Completo do Interno");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Data");

        jDataPM.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPM.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jIdPrescricaoMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(0, 198, Short.MAX_VALUE))
                            .addComponent(jNomeInternoCrcPM))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jDataPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jRBPrescricaoMedica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRBPrescricaoPsiquiatrica)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPM, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jIdPrescricaoMedica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNomeInternoCrcPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBPrescricaoMedica)
                    .addComponent(jRBPrescricaoPsiquiatrica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTabelaPrescricaoMedicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaPrescricaoMedicaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idItemPresq = "" + jTabelaPrescricaoMedica.getValueAt(jTabelaPrescricaoMedica.getSelectedRow(), 0);
            // Habilitar os botões
            jBtNovaPrescicao.setEnabled(!true);
            jBtAlterarPrescicao.setEnabled(true);
            jBtExcluirPrescicao.setEnabled(true);
            jBtSalvarPrescicao.setEnabled(!true);
            jBtCancelarPrescicao.setEnabled(true);
            jBtAuditoriaPrescicao.setEnabled(true);
            jBtImpressaoPrescricao.setEnabled(true);
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PRESCRICAO_MEDICA_PSIQUIATRICA "
                        + "WHERE IdLanc='" + jIdAdm.getText() + "' "
                        + "AND IdItem='" + idItemPresq + "'");
                conecta.rs.first();
                jIdPrescricaoMedica.setText(conecta.rs.getString("IdItem")); //Coluna 0
                idItemPrescricao = conecta.rs.getInt("IdItem"); // Coluna 2
                jNomeInternoCrcPM.setText(jNomeInternoAdm.getText());
                jDataPM.setDate(conecta.rs.getDate("DataPres"));
                tipoPrescricao = conecta.rs.getInt("TipoP");
                if (tipoPrescricao == 0) {
                    jRBPrescricaoMedica.setSelected(true);
                } else if (tipoPrescricao == 1) {
                    jRBPrescricaoPsiquiatrica.setSelected(true);
                }
                jTextoPrescricaoMedica.setText(conecta.rs.getString("TextoPrescricao"));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não existe dados a serem alterado!!!" + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaPrescricaoMedicaMouseClicked

    private void jBtNovaPrescicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaPrescicaoActionPerformed
        // TODO add your handling code here:
        nomeModuloTela4 = "Movimentação:Admissão Médica de Internos:Prescrição Médica/Psiquiatrica";
        buscarAcessoUsuarioPrescricao();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela4) && codIncluirENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            acao = 1;
            NovaPrescricao();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a incluir prontuário médico.");
        }
    }//GEN-LAST:event_jBtNovaPrescicaoActionPerformed

    private void jBtAlterarPrescicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarPrescicaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuarioPrescricao();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela4) && codAlterarENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PRESCRICAO_MEDICA_PSIQUIATRICA "
                        + "WHERE IdItem='" + jIdPrescricaoMedica.getText() + "'");
                conecta.rs.first();
                nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
            }
            if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                acao = 2;
                AlterarPrescricao();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                conecta.desconecta();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a alterar o prontuário médico.");
        }
    }//GEN-LAST:event_jBtAlterarPrescicaoActionPerformed

    private void jBtExcluirPrescicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirPrescicaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuarioPrescricao();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela4) && codExcluirENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PRESCRICAO_MEDICA_PSIQUIATRICA "
                        + "WHERE IdItem='" + jIdPrescricaoMedica.getText() + "'");
                conecta.rs.first();
                nomeUserRegistro = conecta.rs.getString("UsuarioInsert");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Não foi possivel encontrar o usuário.");
            }
            if (nomeUserRegistro == null ? nameUser == null : nomeUserRegistro.equals(nameUser)) {
                objAdmMedico.setStatusLanc(jStatusLanc.getText());
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir a prescrição selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objPrescricao.setIdItem(Integer.parseInt(jIdPrescricaoMedica.getText()));
                    objPrescricao.setIdLanc(Integer.parseInt(jIdAdm.getText()));
                    controlePrescricao.excluirPrescricaoMedica(objPrescricao);
                    //
                    objPrescricao.setIdLanc(Integer.parseInt(jIdAdm.getText()));
                    objPrescricao.setIdItem(Integer.parseInt(jIdPrescricaoMedica.getText()));
                    objPrescricao.setDeptoMedico(deptoTecnico);
                    controleMovPrescricao.excluirMovTecPrescricao(objPrescricao); // Excluir movimento histórico.
                    objLog4();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaPrescricaoMedica("SELECT * FROM PRESCRICAO_MEDICA_PSIQUIATRICA "
                            + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    ExcluirPrescricao();
                    JOptionPane.showMessageDialog(rootPane, "Registro EXCLUIDO com sucesso !!!");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse registro foi inserido pelo " + nomeUserRegistro + " só esse usuário poderá modificar.");
                conecta.desconecta();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a excluir o prontuário médico.");
        }
    }//GEN-LAST:event_jBtExcluirPrescicaoActionPerformed

    private void jBtSalvarPrescicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarPrescicaoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuarioPrescricao();
        if (codigoUserENF == codUserAcessoENF && nomeTelaENF.equals(nomeModuloTela4) && codGravarENF == 1 || nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoENF.equals("ADMINISTRADORES")) {
            if (jDataPM.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data da Prescrição médica/psiquiatrica do interno.");
                jDataPM.requestFocus();
                jDataPM.setBackground(Color.red);
            } else if (jTextoPrescricaoMedica.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o texto da prescrição Médica/Psiquiatrica");
            } else {
                if (jRBPrescricaoMedica.isSelected()) {
                    tipoPrescricao = 0;
                } else if (jRBPrescricaoPsiquiatrica.isSelected()) {
                    tipoPrescricao = 1;
                }
                objPrescricao.setDataPrescricao(jDataPM.getDate());
                objPrescricao.setTipoPrescricaoMedica(tipoPrescricao);
                objPrescricao.setTextoPrescricao(jTextoPrescricaoMedica.getText());
                objPrescricao.setStatusLanc(jStatusLanc.getText());
                if (acao == 1) {
                    // log de usuario
                    objPrescricao.setUsuarioInsert(nameUser);
                    objPrescricao.setDataInsert(dataModFinal);
                    objPrescricao.setHoraInsert(horaMov);
                    objPrescricao.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                    objPrescricao.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    controlePrescricao.incluirPrescricaoMedica(objPrescricao);
                    //
                    buscarprescricaoMedica();
                    objPrescricao.setDeptoMedico(deptoTecnico);
                    objPrescricao.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objPrescricao.setIdLanc(Integer.valueOf(jIdPrescricaoMedica.getText()));
                    controleMovPrescricao.incluirMovTecPrescricao(objPrescricao); // Histórico de Movimento Técnico
                    //
                    objLog4();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaPrescricaoMedica("SELECT * FROM PRESCRICAO_MEDICA_PSIQUIATRICA "
                            + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    SalvarPrescricao();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                if (acao == 2) {
                    // log de usuario
                    objPrescricao.setUsuarioUp(nameUser);
                    objPrescricao.setDataUp(dataModFinal);
                    objPrescricao.setHoraUp(horaMov);
                    objPrescricao.setIdLanc(Integer.valueOf(jIdAdm.getText()));
                    objPrescricao.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objPrescricao.setIdItem(idItemPrescricao);
                    controlePrescricao.alterarPrescricaoMedica(objPrescricao);
                    //
                    objPrescricao.setDeptoMedico(deptoTecnico);
                    objPrescricao.setIdInternoCrc(Integer.valueOf(jIdInternoAdm.getText()));
                    objPrescricao.setIdLanc(Integer.valueOf(jIdPrescricaoMedica.getText()));
                    controleMovPrescricao.alterarMovTecPrescricao(objPrescricao);
                    //
                    objLog4();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    preencherTabelaPrescricaoMedica("SELECT * FROM PRESCRICAO_MEDICA_PSIQUIATRICA "
                            + "WHERE IdLanc='" + jIdAdm.getText() + "'");
                    SalvarPrescricao();
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso a gravar no prontuário médico.");
        }
    }//GEN-LAST:event_jBtSalvarPrescicaoActionPerformed

    private void jBtCancelarPrescicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarPrescicaoActionPerformed
        // TODO add your handling code here:
        CancelarPrescricao();
    }//GEN-LAST:event_jBtCancelarPrescicaoActionPerformed

    private void jBtImpressaoPrescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImpressaoPrescricaoActionPerformed
        // TODO add your handling code here:
        if (jIdPrescricaoMedica.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível imprimir prescrição médica.");
        } else {
            try {
                conecta.abrirConexao();
                String path = "reports/RelatorioPrescricaoMedica.jasper";
                conecta.executaSQL("SELECT * FROM ADMISSAOMEDICA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ADMISSAOMEDICA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN PRESCRICAO_MEDICA_PSIQUIATRICA "
                        + "ON ADMISSAOMEDICA.IdLanc=PRESCRICAO_MEDICA_PSIQUIATRICA.IdLanc "
                        + "WHERE PRESCRICAO_MEDICA_PSIQUIATRICA.IdLanc='" + jIdAdm.getText() + "' "
                        + "AND PRESCRICAO_MEDICA_PSIQUIATRICA.IdItem='" + jIdPrescricaoMedica.getText() + "'");
                HashMap parametros = new HashMap();
                parametros.put("codigoAdm", jIdAdm.getText());
                parametros.put("codigoPrescricao", jIdPrescricaoMedica.getText());
                parametros.put("nomeUsuario", nameUser);
                JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio
                JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
                jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                jv.setTitle("Prescrição Médica/Psiquiatrica");
                jv.setVisible(true); // Chama o relatorio para ser visualizado
                jv.toFront(); // Traz o relatorio para frente da aplicação
                conecta.desconecta();
            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
            }
        }
    }//GEN-LAST:event_jBtImpressaoPrescricaoActionPerformed

    private void jBtAuditoriaPrescicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaPrescicaoActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaPrescricaMedica objAudiPresMed = new TelaAuditoriaPrescricaMedica();
        TelaModuloEnfermaria.jPainelMedico.add(objAudiPresMed);
        objAudiPresMed.show();
    }//GEN-LAST:event_jBtAuditoriaPrescicaoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrescricaoMedicaEnfermaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrescricaoMedicaEnfermaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrescricaoMedicaEnfermaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrescricaoMedicaEnfermaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaPrescricaoMedicaEnfermaria dialog = new TelaPrescricaoMedicaEnfermaria(telaAdmissaoMedica, true);
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
    private javax.swing.JButton jBtAlterarPrescicao;
    private javax.swing.JButton jBtAuditoriaPrescicao;
    private javax.swing.JButton jBtCancelarPrescicao;
    private javax.swing.JButton jBtExcluirPrescicao;
    private javax.swing.JButton jBtImpressaoPrescricao;
    private javax.swing.JButton jBtNovaPrescicao;
    private javax.swing.JButton jBtSalvarPrescicao;
    private com.toedter.calendar.JDateChooser jDataPM;
    public static javax.swing.JTextField jIdPrescricaoMedica;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JTextField jNomeInternoCrcPM;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JRadioButton jRBPrescricaoMedica;
    private javax.swing.JRadioButton jRBPrescricaoPsiquiatrica;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaPrescricaoMedica;
    private javax.swing.JTextArea jTextoPrescricaoMedica;
    // End of variables declaration//GEN-END:variables

    public void NovaPrescricao() {
        jIdPrescricaoMedica.setText("");
        jNomeInternoCrcPM.setText(jNomeInternoAdm.getText());
        jDataPM.setCalendar(Calendar.getInstance());
        jTextoPrescricaoMedica.setText("");
        //        
        jDataPM.setEnabled(true);
        jRBPrescricaoMedica.setEnabled(true);
        jRBPrescricaoPsiquiatrica.setEnabled(true);
        jTextoPrescricaoMedica.setEnabled(true);
        //
        jBtNovaPrescicao.setEnabled(!true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(true);
        jBtCancelarPrescicao.setEnabled(true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(true);
        jRBPrescricaoPsiquiatrica.setEnabled(true);
        //
//        jBtNovo.setEnabled(!true);
//        jBtAlterar.setEnabled(!true);
//        jBtExcluir.setEnabled(!true);
//        jBtSalvar.setEnabled(!true);
//        jBtCancelar.setEnabled(!true);
//        jBtFinalizar.setEnabled(!true);
//        jBtAuditoria.setEnabled(!true);
//        //
//        jDataAdm.setEnabled(!true);
//        jBtPesqInternoAdm.setEnabled(!true);
//        jAR.setEnabled(!true);
//        jACV.setEnabled(!true);
//        jAGU.setEnabled(!true);
//        jCABPESC.setEnabled(!true);
//        jEXT.setEnabled(!true);
//        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
//        jCirurgiasPrevisas.setEnabled(!true);
//        jTratamentoCurso.setEnabled(!true);
//        jQualDrogas.setEnabled(!true);
//        jQualEtilismo.setEnabled(!true);
//        jQuantoTempoTabagismo.setEnabled(!true);
//        jComboBoxDrogas.setEnabled(!true);
//        jComboBoxEtilismo.setEnabled(!true);
//        jComboBoxTabagismo.setEnabled(!true);
//        jComboBoxVacinas.setEnabled(!true);
//        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // TELA DE EVOLUÇÃO MÉDICA
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //              
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
//        jHipotestesDiagnosticosMedico.setEnabled(!true);
//        jExamesSolcitadosMedicos.setEnabled(!true);
        //        
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        // BOTÕES DE EVOLUÇÃO PSIQUIATRICA
        jBtNovaEvolPsiquiatrica.setEnabled(!true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // Campos do diagnóstico
//        jHipotesesDiagnosticoPsi.setText("");
//        jExamesSolicitadosPsiq.setText("");
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
//        jHipotesesDiagnosticoPsi.setEnabled(!true);
//        jExamesSolicitadosPsiq.setEnabled(!true);
    }

    public void AlterarPrescricao() {
        // PRESCRIÇÃO MEDICA/PSICOLOGICA
        jDataPM.setEnabled(true);
        jRBPrescricaoMedica.setEnabled(true);
        jRBPrescricaoPsiquiatrica.setEnabled(true);
        jTextoPrescricaoMedica.setEnabled(true);
        //
        jBtNovaPrescicao.setEnabled(!true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(true);
        jBtCancelarPrescicao.setEnabled(true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        //
//        jBtNovo.setEnabled(!true);
//        jBtAlterar.setEnabled(!true);
//        jBtExcluir.setEnabled(!true);
//        jBtSalvar.setEnabled(!true);
//        jBtCancelar.setEnabled(!true);
//        jBtFinalizar.setEnabled(!true);
//        jBtAuditoria.setEnabled(!true);
        //
//        jDataAdm.setEnabled(!true);
//        jBtPesqInternoAdm.setEnabled(!true);
//        jAR.setEnabled(!true);
//        jACV.setEnabled(!true);
//        jAGU.setEnabled(!true);
//        jCABPESC.setEnabled(!true);
//        jEXT.setEnabled(!true);
//        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
//        jCirurgiasPrevisas.setEnabled(!true);
//        jTratamentoCurso.setEnabled(!true);
//        jQualDrogas.setEnabled(!true);
//        jQualEtilismo.setEnabled(!true);
//        jQuantoTempoTabagismo.setEnabled(!true);
//        jComboBoxDrogas.setEnabled(!true);
//        jComboBoxEtilismo.setEnabled(!true);
//        jComboBoxTabagismo.setEnabled(!true);
//        jComboBoxVacinas.setEnabled(!true);
//        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // TELA DE EVOLUÇÃO MÉDICA
        jBtNovaEvolucao.setEnabled(!true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //              
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
//        jHipotestesDiagnosticosMedico.setEnabled(!true);
//        jExamesSolcitadosMedicos.setEnabled(!true);
        //        
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        // BOTÕES DE EVOLUÇÃO PSIQUIATRICA
        jBtNovaEvolPsiquiatrica.setEnabled(!true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // Campos do diagnóstico
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
    }

    public void ExcluirPrescricao() {
        jIdPrescricaoMedica.setText("");
        jNomeInternoCrcPM.setText(jNomeInternoAdm.getText());
        jDataPM.setCalendar(Calendar.getInstance());
        jTextoPrescricaoMedica.setText("");
        // PRESCRIÇÃO MEDICA/PSICOLOGICA
        jDataPM.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        //
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        //
//        jBtNovo.setEnabled(true);
//        jBtAlterar.setEnabled(true);
//        jBtExcluir.setEnabled(true);
//        jBtSalvar.setEnabled(!true);
//        jBtCancelar.setEnabled(!true);
//        jBtFinalizar.setEnabled(true);
//        jBtAuditoria.setEnabled(true);
//        //
//        jDataAdm.setEnabled(!true);
//        jBtPesqInternoAdm.setEnabled(!true);
//        jAR.setEnabled(!true);
//        jACV.setEnabled(!true);
//        jAGU.setEnabled(!true);
//        jCABPESC.setEnabled(!true);
//        jEXT.setEnabled(!true);
//        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
//        jCirurgiasPrevisas.setEnabled(!true);
//        jTratamentoCurso.setEnabled(!true);
//        jQualDrogas.setEnabled(!true);
//        jQualEtilismo.setEnabled(!true);
//        jQuantoTempoTabagismo.setEnabled(!true);
//        jComboBoxDrogas.setEnabled(!true);
//        jComboBoxEtilismo.setEnabled(!true);
//        jComboBoxTabagismo.setEnabled(!true);
//        jComboBoxVacinas.setEnabled(!true);
//        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // TELA DE EVOLUÇÃO MÉDICA
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //              
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        //        
        jDataEvolPsiquiatrica.setEnabled(!true);
        jComboBoxPatologiaAdquirida.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
//        jHipotestesDiagnosticosMedico.setEnabled(!true);
//        jExamesSolcitadosMedicos.setEnabled(!true);
        // BOTÕES DE EVOLUÇÃO PSIQUIATRICA
        jBtNovaEvolPsiquiatrica.setEnabled(true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // Campos do diagnóstico
        jDataEvolPsiquiatrica.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
//        jHipotesesDiagnosticoPsi.setEnabled(!true);
//        jExamesSolicitadosPsiq.setEnabled(!true);
    }

    public void SalvarPrescricao() {
        jDataPM.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        // PRESCRIÇÃO MEDICA/PSICOLOGICA
        jDataPM.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        //
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        //
//        jBtNovo.setEnabled(true);
//        jBtAlterar.setEnabled(true);
//        jBtExcluir.setEnabled(true);
//        jBtSalvar.setEnabled(!true);
//        jBtCancelar.setEnabled(!true);
//        jBtFinalizar.setEnabled(true);
//        jBtAuditoria.setEnabled(true);
//        //
//        jDataAdm.setEnabled(!true);
//        jBtPesqInternoAdm.setEnabled(!true);
//        jAR.setEnabled(!true);
//        jACV.setEnabled(!true);
//        jAGU.setEnabled(!true);
//        jCABPESC.setEnabled(!true);
//        jEXT.setEnabled(!true);
//        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
//        jCirurgiasPrevisas.setEnabled(!true);
//        jTratamentoCurso.setEnabled(!true);
//        jQualDrogas.setEnabled(!true);
//        jQualEtilismo.setEnabled(!true);
//        jQuantoTempoTabagismo.setEnabled(!true);
//        jComboBoxDrogas.setEnabled(!true);
//        jComboBoxEtilismo.setEnabled(!true);
//        jComboBoxTabagismo.setEnabled(!true);
//        jComboBoxVacinas.setEnabled(!true);
//        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // TELA DE EVOLUÇÃO MÉDICA
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //              
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        //        
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
//        jHipotestesDiagnosticosMedico.setEnabled(!true);
//        jExamesSolcitadosMedicos.setEnabled(!true);
        // BOTÕES DE EVOLUÇÃO PSIQUIATRICA
        jBtNovaEvolPsiquiatrica.setEnabled(true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        // Campos do diagnóstico
        jDataEvolPsiquiatrica.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
//        jHipotesesDiagnosticoPsi.setEnabled(!true);
//        jExamesSolicitadosPsiq.setEnabled(!true);
    }

    public void CancelarPrescricao() {
        jIdPrescricaoMedica.setText("");
        jNomeInternoCrcPM.setText("");
        jDataPM.setDate(null);
        jTextoPrescricaoMedica.setText("");
        // PRESCRIÇÃO MEDICA/PSICOLOGICA
        jDataPM.setEnabled(!true);
        jTextoPrescricaoMedica.setEnabled(!true);
        //
        jBtNovaPrescicao.setEnabled(true);
        jBtAlterarPrescicao.setEnabled(!true);
        jBtExcluirPrescicao.setEnabled(!true);
        jBtSalvarPrescicao.setEnabled(!true);
        jBtCancelarPrescicao.setEnabled(!true);
        jBtAuditoriaPrescicao.setEnabled(!true);
        jBtImpressaoPrescricao.setEnabled(!true);
        jRBPrescricaoMedica.setEnabled(!true);
        jRBPrescricaoPsiquiatrica.setEnabled(!true);
        //
//        jBtNovo.setEnabled(true);
//        jBtAlterar.setEnabled(true);
//        jBtExcluir.setEnabled(true);
//        jBtSalvar.setEnabled(!true);
//        jBtCancelar.setEnabled(!true);
//        jBtFinalizar.setEnabled(true);
//        jBtAuditoria.setEnabled(true);
        //
//        jDataAdm.setEnabled(!true);
//        jBtPesqInternoAdm.setEnabled(!true);
//        jAR.setEnabled(!true);
//        jACV.setEnabled(!true);
//        jAGU.setEnabled(!true);
//        jCABPESC.setEnabled(!true);
//        jEXT.setEnabled(!true);
//        jABD.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
//        jCirurgiasPrevisas.setEnabled(!true);
//        jTratamentoCurso.setEnabled(!true);
//        jQualDrogas.setEnabled(!true);
//        jQualEtilismo.setEnabled(!true);
//        jQuantoTempoTabagismo.setEnabled(!true);
//        jComboBoxDrogas.setEnabled(!true);
//        jComboBoxEtilismo.setEnabled(!true);
//        jComboBoxTabagismo.setEnabled(!true);
//        jComboBoxVacinas.setEnabled(!true);
//        jComboBoxIgnoradoAtualizado.setEnabled(!true);
        // TELA DE EVOLUÇÃO MÉDICA
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        jBtAuditoriaEvolucao.setEnabled(!true);
        //              
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
        //        
        jDataEvolucao.setEnabled(!true);
        jTextoEvolucaoMedica.setEnabled(!true);
//        jHipotestesDiagnosticosMedico.setEnabled(!true);
//        jExamesSolcitadosMedicos.setEnabled(!true);
        // BOTÕES DE EVOLUÇÃO PSIQUIATRICA
        jBtNovaEvolPsiquiatrica.setEnabled(true);
        jBtAlterarEvolPsiquiatrica.setEnabled(!true);
        jBtExcluirEvolPsiquiatrica.setEnabled(!true);
        jBtSalvarEvolPsiquiatrica.setEnabled(!true);
        jBtCancelarEvolPsiquiatrica.setEnabled(!true);
        jBtAuditoriaEvolPsiquiatrica.setEnabled(!true);
        // Campos do diagnóstico
        jDataEvolPsiquiatrica.setEnabled(!true);
        jTextoEvolucaoPsiquiatrica.setEnabled(!true);
//        jHipotesesDiagnosticoPsi.setEnabled(!true);
//        jExamesSolicitadosPsiq.setEnabled(!true);
    }

    public void buscarprescricaoMedica() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRESCRICAO_MEDICA_PSIQUIATRICA");
            conecta.rs.last();
            jIdPrescricaoMedica.setText(conecta.rs.getString("IdItem"));
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void preencherTabelaPrescricaoMedica(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Prescrição Médica/Psquiatrica"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dataPrescricao = conecta.rs.getString("DataPres");
                String diap = dataPrescricao.substring(8, 10);
                String mesp = dataPrescricao.substring(5, 7);
                String anop = dataPrescricao.substring(0, 4);
                dataPrescricao = diap + "/" + mesp + "/" + anop;
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), dataPrescricao, conecta.rs.getString("TextoPrescricao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPrescricaoMedica.setModel(modelo);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(2).setPreferredWidth(400);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPrescricaoMedica.getTableHeader().setReorderingAllowed(false);
        jTabelaPrescricaoMedica.setAutoResizeMode(jTabelaPrescricaoMedica.AUTO_RESIZE_OFF);
        jTabelaPrescricaoMedica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaPrescricaoMedica();
        conecta.desconecta();
    }

    public void limparTabelaPrescricaoMedica() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Prescrição Médica/Psquiatrica"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaPrescricaoMedica.setModel(modelo);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(2).setPreferredWidth(400);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaPrescricaoMedica.getTableHeader().setReorderingAllowed(false);
        jTabelaPrescricaoMedica.setAutoResizeMode(jTabelaPrescricaoMedica.AUTO_RESIZE_OFF);
        jTabelaPrescricaoMedica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaPrescricaoMedica() {
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaPrescricaoMedica.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaPrescricaoMedica.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void buscarAcessoUsuarioPrescricao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserENF = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserENF + "'");
            conecta.rs.first();
            codigoUserGroupENF = conecta.rs.getInt("IdUsuario");
            codigoGrupoENF = conecta.rs.getInt("IdGrupo");
            nomeGrupoENF = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        //TELA DE PRESCRIÇÃO
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserENF + "' "
                    + "AND NomeTela='" + nomeModuloTela4 + "'");
            conecta.rs.first();
            codUserAcessoENF = conecta.rs.getInt("IdUsuario");
            codAbrirENF = conecta.rs.getInt("Abrir");
            codIncluirENF = conecta.rs.getInt("Incluir");
            codAlterarENF = conecta.rs.getInt("Alterar");
            codExcluirENF = conecta.rs.getInt("Excluir");
            codGravarENF = conecta.rs.getInt("Gravar");
            codConsultarENF = conecta.rs.getInt("Consultar");
            nomeTelaENF = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void objLog4() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela4);
        objLogSys.setIdLancMov(Integer.valueOf(jIdAdm.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
