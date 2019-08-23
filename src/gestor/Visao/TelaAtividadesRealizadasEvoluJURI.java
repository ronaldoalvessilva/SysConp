/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleEvolucaoJuridico;
import gestor.Controle.ControleItensAtividadeJuridico;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleMovJuridico;
import gestor.Controle.ControleRegistroAtendimentoInternoBio;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.AtendimentoJuridico;
import gestor.Modelo.EvolucaoJuridico;
import gestor.Modelo.ItensAtividadeJuridico;
import gestor.Modelo.LogSistema;
import gestor.Modelo.RegistroAtendimentoInternos;
import static gestor.Visao.TelaAtendimentoJuridico.jBtCancelarEvolucao;
import static gestor.Visao.TelaAtendimentoJuridico.codigoDepartamentoJURI;
import static gestor.Visao.TelaAtendimentoJuridico.jBtAlterarEvolucao;
import static gestor.Visao.TelaAtendimentoJuridico.jBtExcluirEvolucao;
import static gestor.Visao.TelaAtendimentoJuridico.jBtNovaEvolucao;
import static gestor.Visao.TelaAtendimentoJuridico.jBtSalvarEvolucao;
import static gestor.Visao.TelaAtendimentoJuridico.jComboBoxEncaminharSetorEvo;
import static gestor.Visao.TelaAtendimentoJuridico.jComboBoxRespostaEvo;
import static gestor.Visao.TelaAtendimentoJuridico.jComboBoxTipoAdvogadoEvo;
import static gestor.Visao.TelaAtendimentoJuridico.jDataEncaminhamentoEvo;
import static gestor.Visao.TelaAtendimentoJuridico.jDataEvolucao;
import static gestor.Visao.TelaAtendimentoJuridico.jEvolucao;
import static gestor.Visao.TelaAtendimentoJuridico.jHoraEnvioEvo;
import static gestor.Visao.TelaAtendimentoJuridico.jIDInternoJuridico;
import static gestor.Visao.TelaAtendimentoJuridico.jIDLanc;
import static gestor.Visao.TelaAtendimentoJuridico.jIdEvolucao;
import static gestor.Visao.TelaAtendimentoJuridico.jNomeInternoJuridico;
import static gestor.Visao.TelaAtendimentoJuridico.jTabelaEvolucaoJuridica;
import static gestor.Visao.TelaAtendimentoJuridico.jBtAgendarBeneficio;
import static gestor.Visao.TelaAtendimentoJuridico.pAcao;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloJuridico.codAbrirJURI;
import static gestor.Visao.TelaModuloJuridico.codAlterarJURI;
import static gestor.Visao.TelaModuloJuridico.codConsultarJURI;
import static gestor.Visao.TelaModuloJuridico.codExcluirJURI;
import static gestor.Visao.TelaModuloJuridico.codGravarJURI;
import static gestor.Visao.TelaModuloJuridico.codIncluirJURI;
import static gestor.Visao.TelaModuloJuridico.codUserAcessoJURI;
import static gestor.Visao.TelaModuloJuridico.codigoGrupoJURI;
import static gestor.Visao.TelaModuloJuridico.codigoUserGroupJURI;
import static gestor.Visao.TelaModuloJuridico.codigoUserJURI;
import static gestor.Visao.TelaModuloJuridico.nomeGrupoJURI;
import static gestor.Visao.TelaModuloJuridico.nomeTelaJURI;
import static gestor.Visao.TelaModuloJuridico.telaAtendimentoJuridicoaAtividadesJURI;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ronal
 */
public class TelaAtividadesRealizadasEvoluJURI extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensAtividadeJuridico objAtivi = new ItensAtividadeJuridico();
    ControleItensAtividadeJuridico controleItens = new ControleItensAtividadeJuridico();
    //
    AtendimentoJuridico objAtendJuri = new AtendimentoJuridico();
    EvolucaoJuridico objEvolu = new EvolucaoJuridico();
    ControleEvolucaoJuridico controleJuri = new ControleEvolucaoJuridico();
    ControleMovJuridico controle = new ControleMovJuridico();
    // INFORMAR QUE O INTERNO FOI ATENDIDO NA ADMISSÃO E NA EVOLUÇÃO
    RegistroAtendimentoInternos objRegAtend = new RegistroAtendimentoInternos();
    ControleRegistroAtendimentoInternoBio controlRegAtend = new ControleRegistroAtendimentoInternoBio();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    //
    String statusMov;
    String horaMov;
    String dataModFinal;
    String nomeModuloTela2 = "Juridico:Atendimento:Atividades Realizadas - Evolução";
    String nomeModuloTela3 = "Juridico:Atendimento:Atividades Realizadas - Evolução";
    String dataRegistro;
    String idAtividade;
    public static int qtdAtividades = 0;
    String situacaoInternoCrc; // Situação do Interno, se ainda está na unidade
    String dataAtiv;
    //
    int codigoInterno;
    int codigoRegistro;
    int codigoAtividade;
    String codigoAtiva;
    //
    String atendido = "Sim";
    String opcao = "Não";
    String dataReg = "";
    String codigoInternoAtend = "";
    String dataInclusao;
    String pDataInicial;
    String tipoAtendimentoAtividade = "Atividades Jurídicas";
    String tipoAtendimentoEvol = "Evolução Juridico";
    Date dataFormatada;
    String pAtividade;
    String dataEvolucao;
    String codigoEvolucao;
    String statusEvolucao = "EVOLUINDO";
    String deptoTecnico = "JURIDICO";
    String pTextoEvolucao = "EVOLUÇÃO TEM COMO ORIGEM A(S) ATIVIDADE(S) JURIDICA(S) REALIZADA(S) PODENDO SER ALTERADA PELO ATENDENTE.";

    /**
     * Creates new form TelaAtividadesRealizadasADM
     */
    public static TelaAtendimentoJuridico atendimentoEvolJURI;

    public TelaAtividadesRealizadasEvoluJURI(TelaAtendimentoJuridico parent, boolean modal) {
        this.atendimentoEvolJURI = parent;
        this.setModal(modal);
        setLocationRelativeTo(atendimentoEvolJURI);
        initComponents();
        corCampos();
        iniciarDados();
        mostrarAtividades();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //Impedir que a janela seja fechada pelo X   
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
        jRegistro = new javax.swing.JTextField();
        jDataRegistro = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jIdAtividade = new javax.swing.JTextField();
        jComboBoxDescricaoAtividade = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaAtividades = new javax.swing.JTable();
        jPanel34 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jBtAdicionar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Atividades Jurídicas Realizadas :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Data");

        jRegistro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRegistro.setEnabled(false);

        jDataRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataRegistro.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Código");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Descrição da Atividade");

        jIdAtividade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jIdAtividade.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdAtividade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdAtividade.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdAtividade.setEnabled(false);

        jComboBoxDescricaoAtividade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDescricaoAtividade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxDescricaoAtividade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDescricaoAtividade.setEnabled(false);
        jComboBoxDescricaoAtividade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxDescricaoAtividadeItemStateChanged(evt);
            }
        });
        jComboBoxDescricaoAtividade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxDescricaoAtividadeMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jIdAtividade, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jRegistro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxDescricaoAtividade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jIdAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDescricaoAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabelaAtividades.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAtividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Descrição das Atividades"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaAtividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAtividadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaAtividades);
        if (jTabelaAtividades.getColumnModel().getColumnCount() > 0) {
            jTabelaAtividades.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaAtividades.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaAtividades.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaAtividades.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaAtividades.getColumnModel().getColumn(2).setMinWidth(420);
            jTabelaAtividades.getColumnModel().getColumn(2).setMaxWidth(420);
        }

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel67.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel67))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67)
        );

        jBtAdicionar.setForeground(new java.awt.Color(0, 51, 255));
        jBtAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtAdicionar.setText("ADICIONAR");
        jBtAdicionar.setToolTipText("Adicionar registro a tabela");
        jBtAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdicionarActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216104515_16.png"))); // NOI18N
        jBtExcluir.setText("EXCLUIR");
        jBtExcluir.setToolTipText("Excluir registro da tabela");
        jBtExcluir.setEnabled(false);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtConfirmar.setForeground(new java.awt.Color(0, 102, 0));
        jBtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/40_16x16.png"))); // NOI18N
        jBtConfirmar.setText("CONFIRMAR");
        jBtConfirmar.setEnabled(false);
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
            }
        });

        jBtSair.setForeground(new java.awt.Color(204, 0, 0));
        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair.setText("SAIR");
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addComponent(jBtSair)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAdicionar, jBtConfirmar, jBtExcluir, jBtSair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtAdicionar)
                    .addComponent(jBtExcluir)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAdicionar, jBtConfirmar, jBtExcluir, jBtSair});

        getAccessibleContext().setAccessibleName("...::: Atividades Jurídicas :::...");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxDescricaoAtividadeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxDescricaoAtividadeMouseEntered
        // TODO add your handling code here:
        preencherComboAtividades();
    }//GEN-LAST:event_jComboBoxDescricaoAtividadeMouseEntered

    private void jComboBoxDescricaoAtividadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxDescricaoAtividadeItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED) {
            preencherComboAtividadesClick();
        }
    }//GEN-LAST:event_jComboBoxDescricaoAtividadeItemStateChanged

    private void jBtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdicionarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoJuridicoaAtividadesJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtendimentoJuridicoaAtividadesJURI) && codIncluirJURI == 1) {
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            if (pAcao == 3) {
                NovoRegistro();
            } else {
                JOptionPane.showMessageDialog(rootPane, "É necessário está no modo de inserção da evolução para inserir um atividade.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtAdicionarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoJuridicoaAtividadesJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtendimentoJuridicoaAtividadesJURI) && codExcluirJURI == 1) {
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            if (jTabelaAtividades.getSelectedRow() != -1) {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir  a atividade selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objAtivi.setIdInternoCrc(Integer.valueOf(jIDInternoJuridico.getText()));
                    objAtivi.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                    objAtivi.setIdAtiv(Integer.valueOf(codigoAtiva));
                    controleItens.excluirAtividadeRealizadas(objAtivi);
                    qtdAtividades = qtdAtividades - 1;
                    jtotalRegistros.setText(Integer.toString(qtdAtividades));
                    Excluir();
                    preencherAtividadeJuri("SELECT * FROM ITENSATENDIMENTOJURI "
                            + "INNER JOIN ATIVIDADESJURIDICOS "
                            + "ON ITENSATENDIMENTOJURI.IdAtiv=ATIVIDADESJURIDICOS.IdAtiv "
                            + "INNER JOIN ATENDIMENTOJURIDICO "
                            + "ON ITENSATENDIMENTOJURI.IdLanc=ATENDIMENTOJURIDICO.IdLanc "
                            + "WHERE ITENSATENDIMENTOJURI.IdLanc='" + jIDLanc.getText() + "' "
                            + "AND ITENSATENDIMENTOJURI.IdInternoCrc='" + jIDInternoJuridico.getText() + "'");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Selecione o registro que deseja excluir.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaAtendimentoJuridicoaAtividadesJURI);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoJURI.equals("ADMINISTRADORES") || codigoUserJURI == codUserAcessoJURI && nomeTelaJURI.equals(telaAtendimentoJuridicoaAtividadesJURI) && codGravarJURI == 1) {
            verificarSituacaoInternoCrc();
            if (situacaoInternoCrc.equals("ENTRADA NA UNIDADE") || situacaoInternoCrc.equals("RETORNO A UNIDADE")) {
                objAtivi.setDataItem(jDataRegistro.getDate());
                objAtivi.setIdInternoCrc(Integer.valueOf(jIDInternoJuridico.getText()));
                objAtivi.setIdLanc(Integer.valueOf(jIDLanc.getText()));
                objAtivi.setDataItem(jDataRegistro.getDate());
                objAtivi.setDescricaoAtividade((String) jComboBoxDescricaoAtividade.getSelectedItem());
                objAtivi.setUsuarioInsert(nameUser);
                objAtivi.setDataInsert(dataModFinal);
                objAtivi.setHorarioInsert(horaMov);
                controleItens.incluirAtividade(objAtivi);
                buscarCodAtividade();
                objLog3();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação  
                preencherAtividadeJuri("SELECT * FROM ITENSATENDIMENTOJURI "
                        + "INNER JOIN ATIVIDADESJURIDICOS "
                        + "ON ITENSATENDIMENTOJURI.IdAtiv=ATIVIDADESJURIDICOS.IdAtiv "
                        + "INNER JOIN ATENDIMENTOJURIDICO "
                        + "ON ITENSATENDIMENTOJURI.IdLanc=ATENDIMENTOJURIDICO.IdLanc "
                        + "WHERE ITENSATENDIMENTOJURI.IdLanc='" + jIDLanc.getText() + "' "
                        + "AND ITENSATENDIMENTOJURI.IdInternoCrc='" + jIDInternoJuridico.getText() + "'");
                Confirmar();
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Esse interno não se encontra mais na unidade.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Acesso não autorizado, solicite liberação ao administrador.");
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        Integer row = jTabelaAtividades.getRowCount();
        if (row == 0 && pAcao == 3) {
            JOptionPane.showMessageDialog(rootPane, "É necessário informar um tipo de atividade realizada para o interno.");
        } else if (jEvolucao.getText().equals("") && pAcao == 3) {
            int resposta = JOptionPane.showConfirmDialog(this, "O texto da evolução está vazio, deseja preencher com um texto padrão?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                evolucaoAtividades();
                dispose();
                pAcao = 0;
            }
        } else {
            dispose();
        }
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jTabelaAtividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAtividadesMouseClicked
        // TODO add your handling code here:
        codigoAtiva = "" + jTabelaAtividades.getValueAt(jTabelaAtividades.getSelectedRow(), 0);
    }//GEN-LAST:event_jTabelaAtividadesMouseClicked

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
            java.util.logging.Logger.getLogger(TelaAtividadesRealizadasEvoluJURI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAtividadesRealizadasEvoluJURI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAtividadesRealizadasEvoluJURI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAtividadesRealizadasEvoluJURI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaAtividadesRealizadasEvoluJURI dialog = new TelaAtividadesRealizadasEvoluJURI(atendimentoEvolJURI, true);
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
    private javax.swing.JButton jBtAdicionar;
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtSair;
    private javax.swing.JComboBox<String> jComboBoxDescricaoAtividade;
    private com.toedter.calendar.JDateChooser jDataRegistro;
    private javax.swing.JTextField jIdAtividade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JTextField jRegistro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaAtividades;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void corCampos() {
        jRegistro.setBackground(Color.white);
        jIdAtividade.setBackground(Color.white);
    }

    public void iniciarDados() {
        jDataRegistro.setCalendar(Calendar.getInstance());
    }

    public void NovoRegistro() {
        jRegistro.setText("");
        jIdAtividade.setText("");
        jComboBoxDescricaoAtividade.setSelectedItem("Selecione...");
        jDataRegistro.setCalendar(Calendar.getInstance());
        jComboBoxDescricaoAtividade.setEnabled(true);
        jBtConfirmar.setEnabled(true);
    }

    public void Confirmar() {
        jComboBoxDescricaoAtividade.setEnabled(!true);
        jBtConfirmar.setEnabled(!true);
        jBtAdicionar.setEnabled(true);
    }

    public void Excluir() {
        jRegistro.setText("");
        jDataRegistro.setDate(null);
        jIdAtividade.setText("");
        jComboBoxDescricaoAtividade.setSelectedItem("Selecione...");
        jComboBoxDescricaoAtividade.setEnabled(!true);
        jBtConfirmar.setEnabled(!true);
        jBtAdicionar.setEnabled(true);
    }

    public void evolucaoAtividades() {
        objEvolu.setIdInternoCrc(Integer.valueOf(jIDInternoJuridico.getText()));
        objEvolu.setIdLanc(Integer.valueOf(jIDLanc.getText()));
        objEvolu.setEvolucao(jEvolucao.getText());
        objEvolu.setDataEvo(jDataRegistro.getDate());
        objEvolu.setTipoAdvogado((String) jComboBoxTipoAdvogadoEvo.getSelectedItem());
        objEvolu.setResposta((String) jComboBoxRespostaEvo.getSelectedItem());
        objEvolu.setHoraEnvio(jHoraEnvioEvo.getText());
        objEvolu.setSetorEncaminhamento((String) jComboBoxEncaminharSetorEvo.getSelectedItem());
        objEvolu.setEvolucao(pTextoEvolucao);
        controleJuri.incluirEvolucaoJuridico(objEvolu);
        //
        buscarIdEvolucao();
        //
        objAtendJuri.setIdLanc(Integer.valueOf(jIdEvolucao.getText()));
        objAtendJuri.setStatusLanc(statusEvolucao);
        objAtendJuri.setNomeInterno(jNomeInternoJuridico.getText());
        objAtendJuri.setDeptoJuridico(deptoTecnico);
        objAtendJuri.setDataLanc(jDataRegistro.getDate());
        controle.incluirMovTec(objAtendJuri);
        // MODIFICAR A TABELA REGISTRO_ATENDIMENTO_INTERNO_PSP INFORMANDO QUE JÁ FOI ATENDIDO     
        atendido = "Sim";
        objRegAtend.setIdInternoCrc(Integer.valueOf(jIDInternoJuridico.getText()));
        objRegAtend.setNomeInternoCrc(jNomeInternoJuridico.getText());
        objRegAtend.setIdDepartamento(codigoDepartamentoJURI);
        objRegAtend.setTipoAtemdimento(tipoAtendimentoEvol);
        objRegAtend.setAtendido(atendido);
        objRegAtend.setDataAtendimento(jDataRegistro.getDate());
        objRegAtend.setIdAtend(Integer.valueOf(jIDLanc.getText()));
        objRegAtend.setIdEvol(Integer.valueOf(jIdEvolucao.getText()));
        objRegAtend.setAtendeEvol(atendido);
        //
        objRegAtend.setUsuarioUp(nameUser);
        objRegAtend.setDataUp(dataModFinal);
        objRegAtend.setHorarioUp(horaMov);
        controlRegAtend.alterarRegEvol(objRegAtend);
        objLog2();
        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
        //
        jBtNovaEvolucao.setEnabled(true);
        jBtAlterarEvolucao.setEnabled(!true);
        jBtExcluirEvolucao.setEnabled(!true);
        jBtSalvarEvolucao.setEnabled(!true);
        jBtCancelarEvolucao.setEnabled(!true);
        //
        jDataEvolucao.setEnabled(!true);
        jComboBoxTipoAdvogadoEvo.setEnabled(!true);
        jComboBoxRespostaEvo.setEnabled(!true);
        jBtAgendarBeneficio.setEnabled(!true);
        jComboBoxEncaminharSetorEvo.setEnabled(!true);
        jDataEncaminhamentoEvo.setEnabled(!true);
        jHoraEnvioEvo.setEnabled(!true);
        jEvolucao.setEnabled(!true);
        pAcao = 0;
        preencherEvolucaoPsicologia("SELECT * FROM EVOLUCAOJURIDICO "
                + "WHERE IdLanc='" + jIDLanc.getText() + "'");
        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
    }

    public void buscarIdEvolucao() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EVOLUCAOJURIDICO");
            conecta.rs.last();
            jIdEvolucao.setText(conecta.rs.getString("IdEvo"));
            codigoEvolucao = conecta.rs.getString("IdEvo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível pegar o ID da evolução");
        }
    }

    public void preencherComboAtividades() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ATIVIDADESJURIDICOS "
                    + "ORDER BY DescricaoAtiv");
            conecta.rs.first();
            do {
                jComboBoxDescricaoAtividade.addItem(conecta.rs.getString("DescricaoAtiv"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void preencherComboAtividadesClick() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ATIVIDADESJURIDICOS "
                    + "WHERE DescricaoAtiv='" + jComboBoxDescricaoAtividade.getSelectedItem() + "'");
            conecta.rs.first();
            jComboBoxDescricaoAtividade.addItem(conecta.rs.getString("DescricaoAtiv"));
            jIdAtividade.setText(conecta.rs.getString("IdAtiv"));
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void verificarSituacaoInternoCrc() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "WHERE IdInternoCrc='" + jIDInternoJuridico.getText() + "'");
            conecta.rs.first();
            situacaoInternoCrc = conecta.rs.getString("SituacaoCrc");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível pegar verificar o Interno.");
        }
        conecta.desconecta();
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jIdEvolucao.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog3() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela3);
        objLogSys.setIdLancMov(Integer.valueOf(jRegistro.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarCodAtividade() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSATENDIMENTOJURI");
            conecta.rs.last();
            pAtividade = conecta.rs.getString("IdItem");
            jRegistro.setText(conecta.rs.getString("IdItem"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código da atividade.");
        }
    }

    public void mostrarAtividades() {
        qtdAtividades = 0;
        DefaultTableModel dadosProduto = (DefaultTableModel) jTabelaAtividades.getModel();
        ItensAtividadeJuridico b = new ItensAtividadeJuridico();
        try {
            for (ItensAtividadeJuridico bb : controleItens.read()) {
                qtdAtividades++;
                SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                dataAtiv = formatoAmerica.format(bb.getDataItem().getTime());
                jtotalRegistros.setText(Integer.toString(qtdAtividades)); // Converter inteiro em string para exibir na tela 
                dadosProduto.addRow(new Object[]{bb.getIdAtiv(), dataAtiv, bb.getDescricaoAtividade()});
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaAtividades.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaAtividades.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaAtividades.getColumnModel().getColumn(1).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAtividadesRealizadasEvoluJURI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void preencherAtividadeJuri(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Descrição das Atividades"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                // Formatar a data no formato Brasil
                dataAtiv = conecta.rs.getString("DataItem");
                String diap = dataAtiv.substring(8, 10);
                String mesp = dataAtiv.substring(5, 7);
                String anop = dataAtiv.substring(0, 4);
                dataAtiv = diap + "/" + mesp + "/" + anop;
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), dataAtiv, conecta.rs.getString("DescricaoAtiv")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAtividades.setModel(modelo);
        jTabelaAtividades.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaAtividades.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAtividades.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAtividades.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAtividades.getColumnModel().getColumn(2).setPreferredWidth(420);
        jTabelaAtividades.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAtividades.getTableHeader().setReorderingAllowed(false);
        jTabelaAtividades.setAutoResizeMode(jTabelaAtividades.AUTO_RESIZE_OFF);
        jTabelaAtividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaAtividades();
        conecta.desconecta();
    }

    public void alinharCamposTabelaAtividades() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaAtividades.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAtividades.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void limparTabelaAtividades() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Descrição das Atividades"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAtividades.setModel(modelo);
        jTabelaAtividades.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaAtividades.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAtividades.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAtividades.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAtividades.getColumnModel().getColumn(2).setPreferredWidth(420);
        jTabelaAtividades.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAtividades.getTableHeader().setReorderingAllowed(false);
        jTabelaAtividades.setAutoResizeMode(jTabelaAtividades.AUTO_RESIZE_OFF);
        jTabelaAtividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }
    // VERIFICAR SE O INTERNO JÁ FOI INCLUÍDO NO BANCO DE DADOS
    // PARA NÃO SER GRAVADO MAIS DE UMA VEZ NO MESMO KIT

    public void verificarAtividadesInternos(int codigoReg, int codigoAtiv, int codInternoCrc, Date dataCad) {

        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
        pDataInicial = formatoAmerica.format(dataCad.getTime());
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSATENDIMENTOJURI "
                    + "WHERE IdLanc='" + codigoReg + "' "
                    + "AND IdAtiv='" + codigoAtiv + "'"
                    + "AND IdInternoCrc='" + codInternoCrc + "'"
                    + "AND DataItem='" + dataCad + "'");
            conecta.rs.last();
            codigoInterno = conecta.rs.getInt("IdInternoCrc");
            codigoRegistro = conecta.rs.getInt("IdLanc");
            codigoAtividade = conecta.rs.getInt("IdAtiv");
            dataInclusao = conecta.rs.getString("DataItem");
            // CONVERTER DATA PARA PESQUISA.
            String diaI = dataInclusao.substring(8, 10);
            String mesI = dataInclusao.substring(5, 7);
            String anoI = dataInclusao.substring(0, 4);
            dataInclusao = diaI + "/" + mesI + "/" + anoI;
        } catch (Exception ERROR) {
        }
        conecta.desconecta();
    }

    public void preencherEvolucaoPsicologia(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Evolução"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                codigoEvolucao = conecta.rs.getString("IdEvo");
                // Formatar a data Entrada
                dataEvolucao = conecta.rs.getString("DataEvo");
                String diae = dataEvolucao.substring(8, 10);
                String mese = dataEvolucao.substring(5, 7);
                String anoe = dataEvolucao.substring(0, 4);
                dataEvolucao = diae + "/" + mese + "/" + anoe;
                dados.add(new Object[]{conecta.rs.getInt("IdEvo"), dataEvolucao, conecta.rs.getString("Evolucao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolucaoJuridica.setModel(modelo);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(2).setPreferredWidth(470);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolucaoJuridica.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolucaoJuridica.setAutoResizeMode(jTabelaEvolucaoJuridica.AUTO_RESIZE_OFF);
        jTabelaEvolucaoJuridica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaEvolucao();
        conecta.desconecta();
    }

    public void alinharTabelaEvolucao() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void limparTabelaEvolucao() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Evolução"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaEvolucaoJuridica.setModel(modelo);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(2).setPreferredWidth(470);
        jTabelaEvolucaoJuridica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaEvolucaoJuridica.getTableHeader().setReorderingAllowed(false);
        jTabelaEvolucaoJuridica.setAutoResizeMode(jTabelaEvolucaoJuridica.AUTO_RESIZE_OFF);
        jTabelaEvolucaoJuridica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserJURI = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserJURI + "'");
            conecta.rs.first();
            codigoUserGroupJURI = conecta.rs.getInt("IdUsuario");
            codigoGrupoJURI = conecta.rs.getInt("IdGrupo");
            nomeGrupoJURI = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserJURI + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoJURI = conecta.rs.getInt("IdUsuario");
            codAbrirJURI = conecta.rs.getInt("Abrir");
            codIncluirJURI = conecta.rs.getInt("Incluir");
            codAlterarJURI = conecta.rs.getInt("Alterar");
            codExcluirJURI = conecta.rs.getInt("Excluir");
            codGravarJURI = conecta.rs.getInt("Gravar");
            codConsultarJURI = conecta.rs.getInt("Consultar");
            nomeTelaJURI = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarInternoRegistradoAdm() {

        conecta.abrirConexao();
        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
        dataReg = formatoAmerica.format(jDataRegistro.getDate().getTime());
        try {
            conecta.executaSQL("SELECT * FROM REGISTRO_ATENDIMENTO_INTERNO_PSP "
                    + "WHERE IdInternoCrc='" + jIDInternoJuridico.getText() + "' "
                    + "AND Atendido='" + opcao + "'");
            conecta.rs.first();
            codigoInternoAtend = conecta.rs.getString("IdInternoCrc");
            codigoDepartamentoJURI = conecta.rs.getInt("IdDepartamento");
            atendido = conecta.rs.getString("Atendido");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
