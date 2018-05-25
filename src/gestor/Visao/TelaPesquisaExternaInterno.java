/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.DadosFisicosInternos;
import gestor.Modelo.DadosPenaisCrc;
import gestor.Modelo.ProntuarioCrc;
import static gestor.Visao.TelaProntuarioCrc.jComboBoxEstadoCivil;
import static gestor.Visao.TelaProntuarioCrc.jAlcunha;
import static gestor.Visao.TelaProntuarioCrc.jAltura;
import static gestor.Visao.TelaProntuarioCrc.jArtigo1;
import static gestor.Visao.TelaProntuarioCrc.jArtigo2;
import static gestor.Visao.TelaProntuarioCrc.jArtigo3;
import static gestor.Visao.TelaProntuarioCrc.jBairro;
import static gestor.Visao.TelaProntuarioCrc.jCPFInterno;
import static gestor.Visao.TelaProntuarioCrc.jCalca;
import static gestor.Visao.TelaProntuarioCrc.jCamisa;
import static gestor.Visao.TelaProntuarioCrc.jCartaoSus;
import static gestor.Visao.TelaProntuarioCrc.jCidade;
import static gestor.Visao.TelaProntuarioCrc.jComboBoxBarba;
import static gestor.Visao.TelaProntuarioCrc.jComboBoxBigode;
import static gestor.Visao.TelaProntuarioCrc.jComboBoxBoca;
import static gestor.Visao.TelaProntuarioCrc.jComboBoxCabelos;
import static gestor.Visao.TelaProntuarioCrc.jComboBoxCompleicao;
import static gestor.Visao.TelaProntuarioCrc.jComboBoxCutis;
import static gestor.Visao.TelaProntuarioCrc.jComboBoxEdiondo;
import static gestor.Visao.TelaProntuarioCrc.jComboBoxEscolaridade;
import static gestor.Visao.TelaProntuarioCrc.jComboBoxLabios;
import static gestor.Visao.TelaProntuarioCrc.jComboBoxNariz;
import static gestor.Visao.TelaProntuarioCrc.jComboBoxOlhos;
import static gestor.Visao.TelaProntuarioCrc.jComboBoxOrelha;
import static gestor.Visao.TelaProntuarioCrc.jComboBoxParticipacao;
import static gestor.Visao.TelaProntuarioCrc.jComboBoxPescoco;
import static gestor.Visao.TelaProntuarioCrc.jComboBoxRegime;
import static gestor.Visao.TelaProntuarioCrc.jComboBoxRosto;
import static gestor.Visao.TelaProntuarioCrc.jComboBoxSexo;
import static gestor.Visao.TelaProntuarioCrc.jDataCadastro;
import static gestor.Visao.TelaProntuarioCrc.jDataCondenacao;
import static gestor.Visao.TelaProntuarioCrc.jDataCrime;
import static gestor.Visao.TelaProntuarioCrc.jDataEntrada;
import static gestor.Visao.TelaProntuarioCrc.jDataNascimento;
import static gestor.Visao.TelaProntuarioCrc.jDataNovaEntrada;
import static gestor.Visao.TelaProntuarioCrc.jDataPrisao;
import static gestor.Visao.TelaProntuarioCrc.jDataTerPena;
import static gestor.Visao.TelaProntuarioCrc.jEndereco;
import static gestor.Visao.TelaProntuarioCrc.jEstado;
import static gestor.Visao.TelaProntuarioCrc.jIdentificador;
import static gestor.Visao.TelaProntuarioCrc.jIdentificador1;
import static gestor.Visao.TelaProntuarioCrc.jIdentificador2;
import static gestor.Visao.TelaProntuarioCrc.jIdentificador3;
import static gestor.Visao.TelaProntuarioCrc.jLabelFotoInterno;
import static gestor.Visao.TelaProntuarioCrc.jMaeInterno;
import static gestor.Visao.TelaProntuarioCrc.jMatriculaPenal;
import static gestor.Visao.TelaProntuarioCrc.jNomeInterno;
import static gestor.Visao.TelaProntuarioCrc.jPaiInterno;
import static gestor.Visao.TelaProntuarioCrc.jParagrafo1;
import static gestor.Visao.TelaProntuarioCrc.jParagrafo2;
import static gestor.Visao.TelaProntuarioCrc.jParagrafo3;
import static gestor.Visao.TelaProntuarioCrc.jParticularidade;
import static gestor.Visao.TelaProntuarioCrc.jPena;
import static gestor.Visao.TelaProntuarioCrc.jPerfil;
import static gestor.Visao.TelaProntuarioCrc.jPeso;
import static gestor.Visao.TelaProntuarioCrc.jProfissao;
import static gestor.Visao.TelaProntuarioCrc.jRGInterno;
import static gestor.Visao.TelaProntuarioCrc.jRegiaoCorpo;
import static gestor.Visao.TelaProntuarioCrc.jRegiaoCorpo1;
import static gestor.Visao.TelaProntuarioCrc.jRegiaoCorpo2;
import static gestor.Visao.TelaProntuarioCrc.jReligiao;
import static gestor.Visao.TelaProntuarioCrc.jSapato;
import static gestor.Visao.TelaProntuarioCrc.jVaraCondenacao;
import static gestor.Visao.TelaProntuarioCrc.caminho;
import static gestor.Visao.TelaProntuarioCrc.jCNC;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ronaldo.silva7
 */
public class TelaPesquisaExternaInterno extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    DadosPenaisCrc objDadosPena = new DadosPenaisCrc();
    DadosFisicosInternos objDadosFis = new DadosFisicosInternos();
    //
    int flag;
    String dataNascimento = "";
    int count = 0;
    //
    String cnc = "";
    String nomeInterno = "";
    String nomeMaeInterno = "";
    String transfConf = "Não";

    /**
     * Creates new form TelaPesquisaExternaInterno
     */
    public static TelaProntuarioCrc telaProntuarioInt;

    public TelaPesquisaExternaInterno(TelaProntuarioCrc parent, boolean modal) {
        this.telaProntuarioInt = parent;
        this.setModal(modal);
        setLocationRelativeTo(telaProntuarioInt);
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
        jLabel3 = new javax.swing.JLabel();
        jCNC_Pesq = new javax.swing.JTextField();
        jNomeInternoExt = new javax.swing.JTextField();
        jNomeMaeInterno = new javax.swing.JTextField();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jBtPesqNomeMaeInterno = new javax.swing.JButton();
        jBtPesqCNC = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaInterno = new javax.swing.JTable();
        jBtEnviar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Pesquisa Externa de Interno :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("CNC:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome do Interno:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nome da Mãe:");

        jCNC_Pesq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jNomeInternoExt.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jNomeMaeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        jBtPesqNomeMaeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeMaeInterno.setContentAreaFilled(false);
        jBtPesqNomeMaeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeMaeInternoActionPerformed(evt);
            }
        });

        jBtPesqCNC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqCNC.setContentAreaFilled(false);
        jBtPesqCNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqCNCActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNomeInternoExt)
                            .addComponent(jNomeMaeInterno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtPesqNomeMaeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCNC_Pesq, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesqCNC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jCNC_Pesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqCNC)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jNomeInternoExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNomeInterno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jNomeMaeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqNomeMaeInterno))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jNomeInternoExt, jNomeMaeInterno});

        jTabelaInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInterno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "CNC", "Data Nasc.", "Nome Completo do Interno", "Nome da Mãe do Interno", "Unidade Origem"
            }
        ));
        jTabelaInterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaInterno);
        if (jTabelaInterno.getColumnModel().getColumnCount() > 0) {
            jTabelaInterno.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaInterno.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaInterno.getColumnModel().getColumn(1).setMinWidth(100);
            jTabelaInterno.getColumnModel().getColumn(1).setMaxWidth(100);
            jTabelaInterno.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaInterno.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaInterno.getColumnModel().getColumn(3).setMinWidth(300);
            jTabelaInterno.getColumnModel().getColumn(3).setMaxWidth(300);
            jTabelaInterno.getColumnModel().getColumn(4).setMinWidth(250);
            jTabelaInterno.getColumnModel().getColumn(4).setMaxWidth(250);
            jTabelaInterno.getColumnModel().getColumn(5).setMinWidth(350);
            jTabelaInterno.getColumnModel().getColumn(5).setMaxWidth(350);
        }

        jBtEnviar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtEnviar.setForeground(new java.awt.Color(0, 102, 0));
        jBtEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtEnviar.setText("Enviar");
        jBtEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEnviarActionPerformed(evt);
            }
        });

        jBtSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtSair.setForeground(new java.awt.Color(204, 0, 0));
        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel63.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel63))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel63)
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Importação dos dados dos Internos oriundo de outras unidades");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBtEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtSair))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtEnviar, jBtSair});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtEnviar)
                    .addComponent(jBtSair)
                    .addComponent(jLabel4))
                .addGap(6, 6, 6))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtEnviar, jBtSair});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqCNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqCNCActionPerformed
        // TODO add your handling code here:
        flag = 1;
        count = 0;
        if (jCNC_Pesq.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o número do CNC para pesquisar o interno.");
        } else {
            pesquisarDadosInternos("SELECT * FROM PRONTUARIOSCRC_TRANSFERENCIA_UNIDADES "
                    + "WHERE Cnc='" + jCNC_Pesq.getText() + "' "
                    + "AND TransConf='" + transfConf + "'");
        }
    }//GEN-LAST:event_jBtPesqCNCActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.pesquisarDadosInternos("SELECT * FROM PRONTUARIOSCRC_TRANSFERENCIA_UNIDADES "
                    + "WHERE TransfConf='" + transfConf + "'"
                    + "ORDER BY PRONTUARIOSCRC_TRANSFERENCIA_UNIDADES.IdInternoCrc");
        } else {
            jtotalRegistros.setText("");
            limparCamposTabela();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jNomeInternoExt.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do interno para pesquisar.");
        } else {
            pesquisarDadosInternos("SELECT * FROM PRONTUARIOSCRC_TRANSFERENCIA_UNIDADES "
                    + "WHERE NomeInternoCrc LIKE'%" + jNomeInternoExt.getText() + "%' "
                    + "AND TransfConf='" + transfConf + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jBtPesqNomeMaeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeMaeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jNomeMaeInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome da mãe para pesquisar o interno.");
        } else {
            pesquisarDadosInternos("SELECT * FROM PRONTUARIOSCRC_TRANSFERENCIA_UNIDADES "
                    + "WHERE MaeInternoCrc LIKE'%" + jNomeMaeInterno.getText() + "%' "
                    + "AND TransfConf='" + transfConf + "'");
        }
    }//GEN-LAST:event_jBtPesqNomeMaeInternoActionPerformed

    private void jTabelaInternoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternoMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            cnc = "" + jTabelaInterno.getValueAt(jTabelaInterno.getSelectedRow(), 1);
            jCNC_Pesq.setText(cnc);
            nomeInterno = "" + jTabelaInterno.getValueAt(jTabelaInterno.getSelectedRow(), 3);
            jNomeInternoExt.setText(nomeInterno);
            nomeMaeInterno = "" + jTabelaInterno.getValueAt(jTabelaInterno.getSelectedRow(), 4);
            jNomeInternoExt.setText(nomeMaeInterno);
        }
    }//GEN-LAST:event_jTabelaInternoMouseClicked

    private void jBtEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEnviarActionPerformed
        // TODO add your handling code here:
        flag = 1;
        if (jCNC_Pesq.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um interno para exportar os dados.");
        } else {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC_TRANSFERENCIA_UNIDADES "
                        + "WHERE Cnc='" + jCNC_Pesq.getText() + "'");
                conecta.rs.first();
                jMatriculaPenal.setText(conecta.rs.getString("MatriculaCrc"));
                jCNC.setText(conecta.rs.getString("Cnc"));
                jDataCadastro.setDate(conecta.rs.getDate("DataCadastCrc"));
                jDataNascimento.setDate(conecta.rs.getDate("DataNasciCrc"));
                jNomeInterno.setText(conecta.rs.getString("NomeInternoCrc"));
                jMaeInterno.setText(conecta.rs.getString("MaeInternoCrc"));
                jPaiInterno.setText(conecta.rs.getString("PaiInternoCrc"));
                jAlcunha.setText(conecta.rs.getString("AlcunhaCrc"));
                jRGInterno.setText(conecta.rs.getString("RgInternoCrc"));
                jCPFInterno.setText(conecta.rs.getString("CpfInternoCrc"));
                jCartaoSus.setText(conecta.rs.getString("CartaoSus"));
                // Capturando foto
                caminho = conecta.rs.getString("FotoInternoCrc");
                javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                jLabelFotoInterno.setIcon(i);
                jLabelFotoInterno.setIcon(new ImageIcon(i.getImage().getScaledInstance(jLabelFotoInterno.getWidth(), jLabelFotoInterno.getHeight(), Image.SCALE_DEFAULT)));
                //
                jComboBoxEscolaridade.setSelectedItem(conecta.rs.getString("EscolaridadeCrc"));
                jComboBoxEstadoCivil.setSelectedItem(conecta.rs.getString("EstadoCivilCrc"));
                jComboBoxSexo.setSelectedItem(conecta.rs.getString("SexoCrc"));
                jReligiao.setText(conecta.rs.getString("ReligiaoCrc"));
                jProfissao.setText(conecta.rs.getString("ProfissaoCrc"));
                jEndereco.setText(conecta.rs.getString("EnderecoCrc"));
                jBairro.setText(conecta.rs.getString("BairroCrc"));
                jCidade.setText(conecta.rs.getString("CidadeCrc"));
                jEstado.setText(conecta.rs.getString("EstadoCrc"));
                jCNC_Pesq.setText(conecta.rs.getString("Cnc"));
                // Tabela Dados Fisicos
                jComboBoxCutis.setSelectedItem(conecta.rs.getString("Cutis"));
                jComboBoxOlhos.setSelectedItem(conecta.rs.getString("Olhos"));
                jComboBoxCabelos.setSelectedItem(conecta.rs.getString("Cabelos"));
                jComboBoxBarba.setSelectedItem(conecta.rs.getString("Barba"));
                jComboBoxBigode.setSelectedItem(conecta.rs.getString("Bigode"));
                jComboBoxNariz.setSelectedItem(conecta.rs.getString("Nariz"));
                jComboBoxBoca.setSelectedItem(conecta.rs.getString("Boca"));
                jComboBoxRosto.setSelectedItem(conecta.rs.getString("Rosto"));
                jComboBoxLabios.setSelectedItem(conecta.rs.getString("Labios"));
                jCamisa.setText(conecta.rs.getString("Camisa"));
                jCalca.setText(conecta.rs.getString("Calca"));
                jSapato.setText(conecta.rs.getString("Sapato"));
                jPeso.setText(conecta.rs.getString("Peso"));
                jAltura.setText(conecta.rs.getString("Altura"));
                jParticularidade.setText(conecta.rs.getString("Sinais"));
                jComboBoxOrelha.setSelectedItem(conecta.rs.getString("Orelhas"));
                jComboBoxPescoco.setSelectedItem(conecta.rs.getString("Pescoco"));
                jComboBoxCompleicao.setSelectedItem(conecta.rs.getString("Compleicao"));
                // Tabela Dados Penais
                jDataEntrada.setDate(conecta.rs.getDate("DataEntrada"));
                jDataCrime.setDate(conecta.rs.getDate("DataCrime"));
                jDataPrisao.setDate(conecta.rs.getDate("DataPrisao"));
                jDataCondenacao.setDate(conecta.rs.getDate("DataCondenacao"));
                jComboBoxParticipacao.setSelectedItem(conecta.rs.getString("Participacao"));
                jComboBoxRegime.setSelectedItem(conecta.rs.getString("Regime"));
                jPena.setText(conecta.rs.getString("Pena"));
                jArtigo1.setText(conecta.rs.getString("Artigo1"));
                jArtigo2.setText(conecta.rs.getString("Artigo2"));
                jArtigo3.setText(conecta.rs.getString("Artigo3"));
                jParagrafo1.setText(conecta.rs.getString("Paragrafo1"));
                jParagrafo2.setText(conecta.rs.getString("Paragrafo2"));
                jParagrafo3.setText(conecta.rs.getString("Paragrafo3"));
                jComboBoxEdiondo.setSelectedItem(conecta.rs.getString("CrimeEdiondo"));
                jDataTerPena.setDate(conecta.rs.getDate("TerminoPena"));
                jVaraCondenacao.setText(conecta.rs.getString("VaraCondenatoria"));
                jDataNovaEntrada.setDate(conecta.rs.getDate("DataNovaEntrada"));
                //
                jIdentificador.setText(conecta.rs.getString("Identificador"));
                jIdentificador1.setText(conecta.rs.getString("Identificador1"));
                jIdentificador2.setText(conecta.rs.getString("Identificador2"));
                jIdentificador3.setText(conecta.rs.getString("Identificador3"));
                jPerfil.setText(conecta.rs.getString("Perfil"));
                jRegiaoCorpo.setText(conecta.rs.getString("RegiaoCorpo"));
                jRegiaoCorpo1.setText(conecta.rs.getString("RegiaoCorpo1"));
                jRegiaoCorpo2.setText(conecta.rs.getString("RegiaoCorpo2"));
                conecta.desconecta();
            } catch (SQLException e) {
            }
            dispose();
        }
    }//GEN-LAST:event_jBtEnviarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPesquisaExternaInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaExternaInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaExternaInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaExternaInterno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaPesquisaExternaInterno dialog = new TelaPesquisaExternaInterno(telaProntuarioInt, true);
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
    private javax.swing.JButton jBtEnviar;
    private javax.swing.JButton jBtPesqCNC;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtPesqNomeMaeInterno;
    private javax.swing.JButton jBtSair;
    private javax.swing.JTextField jCNC_Pesq;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JTextField jNomeInternoExt;
    private javax.swing.JTextField jNomeMaeInterno;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTabelaInterno;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void pesquisarDadosInternos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "CNC", "Data Nasc.", "Nome Completo do Interno", "Nome da Mãe do Interno", "Unidade Origem"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1; // Contador de registros
                // Formatar a data Entrada
                dataNascimento = conecta.rs.getString("DataNasciCrc");
                String dia = dataNascimento.substring(8, 10);
                String mes = dataNascimento.substring(5, 7);
                String ano = dataNascimento.substring(0, 4);
                dataNascimento = dia + "/" + mes + "/" + ano;
                //                        
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("Cnc"), dataNascimento, conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("MaeInternoCrc"), conecta.rs.getString("UnidadeOrigem")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInterno.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA        
        jTabelaInterno.setModel(modelo);
        jTabelaInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTabelaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(3).setPreferredWidth(300);
        jTabelaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTabelaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(5).setPreferredWidth(350);
        jTabelaInterno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaInterno.setAutoResizeMode(jTabelaInterno.AUTO_RESIZE_OFF);
        jTabelaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaProntuario();
        conecta.desconecta();
    }

    public void limparCamposTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "CNC", "Data Nasc.", "Nome Completo do Interno", "Nome da Mãe do Interno", "Unidade Origem"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInterno.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA        
        jTabelaInterno.setModel(modelo);
        jTabelaInterno.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaInterno.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTabelaInterno.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaInterno.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(3).setPreferredWidth(300);
        jTabelaInterno.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTabelaInterno.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInterno.getColumnModel().getColumn(5).setPreferredWidth(350);
        jTabelaInterno.getColumnModel().getColumn(5).setResizable(false);
        jTabelaInterno.getTableHeader().setReorderingAllowed(false);
        jTabelaInterno.setAutoResizeMode(jTabelaInterno.AUTO_RESIZE_OFF);
        jTabelaInterno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaProntuario() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInterno.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInterno.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaInterno.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }
}
