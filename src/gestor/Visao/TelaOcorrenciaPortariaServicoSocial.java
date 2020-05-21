/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleOcorrenciaIndisciplinarPortaria;
import gestor.Controle.ControleOcorrenciaVisitaPortaria;
import gestor.Controle.ControleOcorrenciaVisitas;
import gestor.Controle.ControleOcorrenciaVisitasInternas;
import gestor.Controle.ControleOcorrenciaVisitasInternasPortaria;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import gestor.Modelo.LogSistema;
import gestor.Modelo.OcorrenciaIndisciplinaPortaria;
import gestor.Modelo.RegistroIndisciplinarPortaria;
import gestor.Modelo.VisitasOcorrenciaPortaria;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPortarias.codigoUserGroupP1;
import static gestor.Visao.TelaModuloPortarias.codigoGrupoP1;
import static gestor.Visao.TelaModuloPortarias.codAbrirP1;
import static gestor.Visao.TelaModuloPortarias.codAlterarP1;
import static gestor.Visao.TelaModuloPortarias.codExcluirP1;
import static gestor.Visao.TelaModuloPortarias.codGravarP1;
import static gestor.Visao.TelaModuloPortarias.codConsultarP1;
import static gestor.Visao.TelaModuloPortarias.codIncluirP1;
import static gestor.Visao.TelaModuloPortarias.codUserAcessoP1;
import static gestor.Visao.TelaModuloPortarias.codigoUserP1;
import static gestor.Visao.TelaModuloPortarias.nomeGrupoP1;
import static gestor.Visao.TelaModuloPortarias.nomeTelaP1;
import static gestor.Visao.TelaModuloPortarias.telaOcorrenciaDisciplinaVisitasManuP1;
import static gestor.Visao.TelaModuloPortarias.telaOcorrenciaDisciplinaVisitasOcorP1;
import static gestor.Visao.TelaModuloPortarias.telaOcorrenciaDisciplinaVisitasVisiP1;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.ImageIcon;
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
 * @author ronaldo
 */
public class TelaOcorrenciaPortariaServicoSocial extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RegistroIndisciplinarPortaria objRegInd = new RegistroIndisciplinarPortaria();
    ControleOcorrenciaIndisciplinarPortaria control = new ControleOcorrenciaIndisciplinarPortaria();
    //
    VisitasOcorrenciaPortaria objOcrPort = new VisitasOcorrenciaPortaria();
    ControleOcorrenciaVisitas controle = new ControleOcorrenciaVisitas();
    ControleOcorrenciaVisitasInternas controleVisitas = new ControleOcorrenciaVisitasInternas();
    //
    OcorrenciaIndisciplinaPortaria objocrIndPorta = new OcorrenciaIndisciplinaPortaria();
    ControleOcorrenciaVisitaPortaria controleOcr = new ControleOcorrenciaVisitaPortaria();
    ControleOcorrenciaVisitasInternasPortaria controleOcrIn = new ControleOcorrenciaVisitasInternasPortaria();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    // Variáveis para gravar o log
    String nomeModuloTela = "Portaria:Ocorrência Disciplinar Visitas:Manutenção";
    String nomeModuloTela2 = "Portaria:Ocorrência Disciplinar Visitas:Visitantes";
    String nomeModuloTela3 = "Portaria:Ocorrência Disciplinar Visitas:Ocorrências";
    String statusMov;
    String horaMov;
    String dataModFinal;

    int flag, acao;
    int count = 0;
    int countItem = 0;
    int countItem1 = 0;
    String dataEntrada, dataValidade, dataRol, dataValiAnt;
    String caminho;
    String codigoReg, codigoRegOcr, dataInicial, dataFinal;
    String caminhoVisita;
    String idItem;
    public static int idItemVisita;
    int codigoVisita;
    int bloqueioLiberacao = 0;
    int tipoBloqueio = 0;
    String confirmacao = "Não";

    /**
     * Creates new form TelaOcorrenciaPortariaServicoSocial
     */
    public static TelaAprovacaoOcorrenciaVisitaPortariaSeguranca telaAprovaOcorrencia;

    public TelaOcorrenciaPortariaServicoSocial() {
        super();
        initComponents();
        setResizable(false);
        corCampos();
        formatarCampos();
    }

    public void mostrarTelaAprovacao() {
        telaAprovaOcorrencia = new TelaAprovacaoOcorrenciaVisitaPortariaSeguranca(this, true);
        telaAprovaOcorrencia.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jBtPesqData = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jDataPesqInicial = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jDataPesqFinal = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jIDPesqLanc = new javax.swing.JTextField();
        jBtPesqID = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jPesqNomeInternoVisitado = new javax.swing.JTextField();
        jBtPesqNomeInterno = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jPesqNomeVisitaInterno = new javax.swing.JTextField();
        jBtPesqVisitaInterno = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaOcorrenciaVisitasInternosPortaria = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jCodigoInternoCrc = new javax.swing.JTextField();
        jNomeInternoCrc = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jFotoInterno = new javax.swing.JLabel();
        jCela = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPavilhao = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jBtPesquisarInterno = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jStatusAprovacao = new javax.swing.JTextField();
        jBtPesqStatusAprovacao = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jCodigoRegistro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jStatusOcorrencia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jDataRegistro = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxTipoOcorrencia = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jComboBoxTipoVisita = new javax.swing.JComboBox();
        jBtSalvar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jBtFinalizar = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jDataAprovaSeg = new com.toedter.calendar.JDateChooser();
        jUsuarioAprovaSeg = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jUsuarioAprovaServicoSocial = new javax.swing.JTextField();
        jDataAprovaSS = new com.toedter.calendar.JDateChooser();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jObservacao = new javax.swing.JTextArea();
        jBtAuditoriaRegistro = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jBtPesquisarVisita = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCodigoVisita = new javax.swing.JTextField();
        jNomeVisita = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jFotoVisita = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jGrauParentescoVisita = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jStatusVisitaRol = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaVisita = new javax.swing.JTable();
        jBtNovaVisita = new javax.swing.JButton();
        jBtAlterarVisita = new javax.swing.JButton();
        jBtExcluirVisita = new javax.swing.JButton();
        jBtSalvarVisita = new javax.swing.JButton();
        jBtCancelarVisita = new javax.swing.JButton();
        jBtAuditoriaVisita = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jtotaItenslRegistrosVisitas = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextoOcorrencia = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTabelaOcorrencia = new javax.swing.JTable();
        jSeparator4 = new javax.swing.JSeparator();
        jBtNovaOcorrencia = new javax.swing.JButton();
        jBtAlterarOcorrencia = new javax.swing.JButton();
        jBtExcluirOcorrencia = new javax.swing.JButton();
        jBtSalvarOcorrencia = new javax.swing.JButton();
        jBtCancelarOcorrencia = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jComboBoxNomeVisita = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jCodigoOcorrencia = new javax.swing.JTextField();
        jBtAuditoriaOcorrencia = new javax.swing.JButton();
        jPanel36 = new javax.swing.JPanel();
        jtotalItensRegistrosOcr = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jBtImprimir = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Ocorrência Indisciplinar Portaria (Visitas Internos) :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jBtPesqData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqData.setContentAreaFilled(false);
        jBtPesqData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqDataActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Data Inicial:");

        jDataPesqInicial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Data Final:");

        jDataPesqFinal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Código:");

        jIDPesqLanc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIDPesqLanc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqID.setContentAreaFilled(false);
        jBtPesqID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqIDActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Nome Interno:");

        jPesqNomeInternoVisitado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqNomeInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqNomeInterno.setContentAreaFilled(false);
        jBtPesqNomeInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqNomeInternoActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Nome Visita:");

        jPesqNomeVisitaInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesqVisitaInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqVisitaInterno.setToolTipText("Pesquisar Visita");
        jBtPesqVisitaInterno.setContentAreaFilled(false);
        jBtPesqVisitaInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqVisitaInternoActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqData, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox1))))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(jPesqNomeInternoVisitado, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtPesqNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPesqNomeVisitaInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtPesqVisitaInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPesqNomeInternoVisitado, jPesqNomeVisitaInterno});

        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBox1)
                    .addComponent(jBtPesqID)
                    .addComponent(jIDPesqLanc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel17)
                    .addComponent(jDataPesqInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jDataPesqFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesqNomeInterno)
                    .addComponent(jPesqNomeInternoVisitado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel21)
                    .addComponent(jPesqNomeVisitaInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqVisitaInterno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabelaOcorrenciaVisitasInternosPortaria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaOcorrenciaVisitasInternosPortaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Código", "Data", "Status", "Nome do Interno"
            }
        ));
        jTabelaOcorrenciaVisitasInternosPortaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaOcorrenciaVisitasInternosPortariaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTabelaOcorrenciaVisitasInternosPortaria);
        if (jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumnCount() > 0) {
            jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(2).setMinWidth(80);
            jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(2).setMaxWidth(80);
            jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(3).setMinWidth(300);
            jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(3).setMaxWidth(300);
        }

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

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Código");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Nome Completo do Interno");

        jCodigoInternoCrc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoInternoCrc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoInternoCrc.setEnabled(false);

        jNomeInternoCrc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInternoCrc.setEnabled(false);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 0))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jCela.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCela.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Cela");

        jPavilhao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPavilhao.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Pavilhão");

        jBtPesquisarInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarInterno.setToolTipText("Pesquisar Internos");
        jBtPesquisarInterno.setContentAreaFilled(false);
        jBtPesquisarInterno.setEnabled(false);
        jBtPesquisarInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarInternoActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 153, 0));
        jLabel30.setText("Status da Aprovação");

        jStatusAprovacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusAprovacao.setForeground(new java.awt.Color(255, 0, 0));
        jStatusAprovacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusAprovacao.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        jStatusAprovacao.setEnabled(false);

        jBtPesqStatusAprovacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqStatusAprovacao.setToolTipText("Conulta de Aprovação");
        jBtPesqStatusAprovacao.setContentAreaFilled(false);
        jBtPesqStatusAprovacao.setEnabled(false);
        jBtPesqStatusAprovacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqStatusAprovacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jCela)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCodigoInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesquisarInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(jStatusAprovacao, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesqStatusAprovacao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10)
                            .addComponent(jNomeInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jStatusAprovacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCodigoInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtPesquisarInterno)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtPesqStatusAprovacao)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeInternoCrc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPavilhao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setToolTipText("Novo Registro");
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
        jBtAlterar.setToolTipText("Alterar Registro");
        jBtAlterar.setEnabled(false);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluir.setToolTipText("Excluir Registro");
        jBtExcluir.setEnabled(false);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setToolTipText("Cancelar Operação");
        jBtCancelar.setEnabled(false);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jCodigoRegistro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoRegistro.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jStatusOcorrencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusOcorrencia.setForeground(new java.awt.Color(204, 0, 153));
        jStatusOcorrencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusOcorrencia.setDisabledTextColor(new java.awt.Color(204, 0, 153));
        jStatusOcorrencia.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jDataRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataRegistro.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Tipo Ocorrência");

        jComboBoxTipoOcorrencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoOcorrencia.setForeground(new java.awt.Color(204, 0, 153));
        jComboBoxTipoOcorrencia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Drogas", "Indisciplina", "Outros" }));
        jComboBoxTipoOcorrencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoOcorrencia.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("Tipo Visita");

        jComboBoxTipoVisita.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTipoVisita.setForeground(new java.awt.Color(153, 0, 153));
        jComboBoxTipoVisita.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Externa", "Interna" }));
        jComboBoxTipoVisita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTipoVisita.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jCodigoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jStatusOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jComboBoxTipoVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxTipoOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCodigoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipoVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipoOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/save-document-icone-9010-16.png"))); // NOI18N
        jBtSalvar.setToolTipText("Gravar Registro");
        jBtSalvar.setEnabled(false);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setToolTipText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtFinalizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtFinalizar.setForeground(new java.awt.Color(0, 153, 0));
        jBtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtFinalizar.setText("Finalizar");
        jBtFinalizar.setEnabled(false);
        jBtFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarActionPerformed(evt);
            }
        });

        jTabbedPane2.setForeground(new java.awt.Color(0, 0, 255));
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Data Aprova.");

        jDataAprovaSeg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataAprovaSeg.setEnabled(false);

        jUsuarioAprovaSeg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jUsuarioAprovaSeg.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 153, 0));
        jLabel14.setText("Nome do Colaborador - Coordenação de Segurança");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 0, 153));
        jLabel16.setText("Nome do Colaborador - Assistencia Social");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Data Aprova.");

        jUsuarioAprovaServicoSocial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jUsuarioAprovaServicoSocial.setEnabled(false);

        jDataAprovaSS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataAprovaSS.setEnabled(false);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDataAprovaSeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(jDataAprovaSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(jUsuarioAprovaSeg, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                    .addComponent(jUsuarioAprovaServicoSocial))
                .addGap(23, 23, 23))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataAprovaSeg, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataAprovaSS, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jUsuarioAprovaSeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jUsuarioAprovaServicoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Aprovadores", jPanel14);

        jObservacao.setColumns(20);
        jObservacao.setRows(5);
        jObservacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jObservacao.setEnabled(false);
        jScrollPane2.setViewportView(jObservacao);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Observação", jPanel15);

        jBtAuditoriaRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaRegistro.setToolTipText("Auditoria");
        jBtAuditoriaRegistro.setContentAreaFilled(false);
        jBtAuditoriaRegistro.setEnabled(false);
        jBtAuditoriaRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jBtFinalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtSair)
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jBtNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtAuditoriaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtFinalizar, jBtSair});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSalvar});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtAuditoriaRegistro)
                    .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtFinalizar)
                    .addComponent(jBtSair))
                .addGap(115, 115, 115))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSalvar});

        jTabbedPane1.addTab("Manutenção", jPanel2);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtPesquisarVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarVisita.setContentAreaFilled(false);
        jBtPesquisarVisita.setEnabled(false);
        jBtPesquisarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarVisitaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Código");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nome do Visitante");

        jCodigoVisita.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoVisita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoVisita.setEnabled(false);

        jNomeVisita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeVisita.setEnabled(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoVisita, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoVisita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Grau de Parentesco");

        jGrauParentescoVisita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jGrauParentescoVisita.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Status Visita no Rol");

        jStatusVisitaRol.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jStatusVisitaRol.setForeground(new java.awt.Color(255, 0, 0));
        jStatusVisitaRol.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jStatusVisitaRol.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        jStatusVisitaRol.setEnabled(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jNomeVisita)
                    .addComponent(jGrauParentescoVisita)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jCodigoVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtPesquisarVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jStatusVisitaRol))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesquisarVisita)
                    .addComponent(jCodigoVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatusVisitaRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(8, 8, 8)
                .addComponent(jNomeVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jGrauParentescoVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabelaVisita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaVisita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Item", "Código", "Nome do Visitante", "Data Validade"
            }
        ));
        jTabelaVisita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaVisitaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaVisita);
        if (jTabelaVisita.getColumnModel().getColumnCount() > 0) {
            jTabelaVisita.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaVisita.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaVisita.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaVisita.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaVisita.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaVisita.getColumnModel().getColumn(2).setMaxWidth(300);
            jTabelaVisita.getColumnModel().getColumn(3).setMinWidth(150);
            jTabelaVisita.getColumnModel().getColumn(3).setMaxWidth(150);
        }

        jBtNovaVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_white_star.png"))); // NOI18N
        jBtNovaVisita.setToolTipText("Nova Visita");
        jBtNovaVisita.setEnabled(false);
        jBtNovaVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaVisitaActionPerformed(evt);
            }
        });

        jBtAlterarVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
        jBtAlterarVisita.setToolTipText("Alterar Visita");
        jBtAlterarVisita.setEnabled(false);
        jBtAlterarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarVisitaActionPerformed(evt);
            }
        });

        jBtExcluirVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirVisita.setToolTipText("Excluir Visita");
        jBtExcluirVisita.setEnabled(false);
        jBtExcluirVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirVisitaActionPerformed(evt);
            }
        });

        jBtSalvarVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/save-document-icone-9010-16.png"))); // NOI18N
        jBtSalvarVisita.setEnabled(false);
        jBtSalvarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarVisitaActionPerformed(evt);
            }
        });

        jBtCancelarVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarVisita.setToolTipText("Cancelar");
        jBtCancelarVisita.setEnabled(false);
        jBtCancelarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarVisitaActionPerformed(evt);
            }
        });

        jBtAuditoriaVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaVisita.setToolTipText("Auditoria");
        jBtAuditoriaVisita.setContentAreaFilled(false);
        jBtAuditoriaVisita.setEnabled(false);
        jBtAuditoriaVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaVisitaActionPerformed(evt);
            }
        });

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel64.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel64))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel64)
        );

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotaItenslRegistrosVisitas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotaItenslRegistrosVisitas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotaItenslRegistrosVisitas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jBtNovaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAlterarVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluirVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSalvarVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelarVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtAuditoriaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarVisita, jBtCancelarVisita, jBtExcluirVisita, jBtNovaVisita, jBtSalvarVisita});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtAlterarVisita)
                    .addComponent(jBtNovaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtExcluirVisita)
                        .addComponent(jBtSalvarVisita))
                    .addComponent(jBtAuditoriaVisita)
                    .addComponent(jBtCancelarVisita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarVisita, jBtCancelarVisita, jBtExcluirVisita, jBtNovaVisita, jBtSalvarVisita});

        jTabbedPane1.addTab("Visitantes", jPanel6);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Texto da Ocorrência", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 0, 102))); // NOI18N

        jTextoOcorrencia.setColumns(20);
        jTextoOcorrencia.setRows(5);
        jTextoOcorrencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTextoOcorrencia.setEnabled(false);
        jScrollPane3.setViewportView(jTextoOcorrencia);

        jTabelaOcorrencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaOcorrencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Item", "Código", "Nome da Visita do Interno"
            }
        ));
        jTabelaOcorrencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaOcorrenciaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTabelaOcorrencia);
        if (jTabelaOcorrencia.getColumnModel().getColumnCount() > 0) {
            jTabelaOcorrencia.getColumnModel().getColumn(0).setMinWidth(70);
            jTabelaOcorrencia.getColumnModel().getColumn(0).setMaxWidth(70);
            jTabelaOcorrencia.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaOcorrencia.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaOcorrencia.getColumnModel().getColumn(2).setMinWidth(350);
            jTabelaOcorrencia.getColumnModel().getColumn(2).setMaxWidth(350);
        }

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jBtNovaOcorrencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovaOcorrencia.setToolTipText("Novo Registro");
        jBtNovaOcorrencia.setEnabled(false);
        jBtNovaOcorrencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovaOcorrenciaActionPerformed(evt);
            }
        });

        jBtAlterarOcorrencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
        jBtAlterarOcorrencia.setToolTipText("Alterar Registro");
        jBtAlterarOcorrencia.setEnabled(false);
        jBtAlterarOcorrencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarOcorrenciaActionPerformed(evt);
            }
        });

        jBtExcluirOcorrencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirOcorrencia.setToolTipText("Excluir Registro");
        jBtExcluirOcorrencia.setEnabled(false);
        jBtExcluirOcorrencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirOcorrenciaActionPerformed(evt);
            }
        });

        jBtSalvarOcorrencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/save-document-icone-9010-16.png"))); // NOI18N
        jBtSalvarOcorrencia.setToolTipText("Gravar Registro");
        jBtSalvarOcorrencia.setEnabled(false);
        jBtSalvarOcorrencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarOcorrenciaActionPerformed(evt);
            }
        });

        jBtCancelarOcorrencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarOcorrencia.setToolTipText("Cancelar Operação");
        jBtCancelarOcorrencia.setEnabled(false);
        jBtCancelarOcorrencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarOcorrenciaActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jComboBoxNomeVisita.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxNomeVisita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxNomeVisita.setEnabled(false);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Nome do Visitante do Interno");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Código");

        jCodigoOcorrencia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoOcorrencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoOcorrencia.setEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jCodigoOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jComboBoxNomeVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxNomeVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCodigoOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jBtAuditoriaOcorrencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/book_open.png"))); // NOI18N
        jBtAuditoriaOcorrencia.setToolTipText("Auditoria");
        jBtAuditoriaOcorrencia.setContentAreaFilled(false);
        jBtAuditoriaOcorrencia.setEnabled(false);
        jBtAuditoriaOcorrencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAuditoriaOcorrenciaActionPerformed(evt);
            }
        });

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalItensRegistrosOcr.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalItensRegistrosOcr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalItensRegistrosOcr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel65.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel65))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel65)
        );

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jBtImprimir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtImprimir.setText("Imprimir");
        jBtImprimir.setToolTipText("Imprimir");
        jBtImprimir.setEnabled(false);
        jBtImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jBtNovaOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtAlterarOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtExcluirOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtSalvarOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtCancelarOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(jBtImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtAuditoriaOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator4)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtNovaOcorrencia)
                    .addComponent(jBtAlterarOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtExcluirOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtSalvarOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtCancelarOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAuditoriaOcorrencia)
                    .addComponent(jBtImprimir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarOcorrencia, jBtCancelarOcorrencia, jBtExcluirOcorrencia, jBtNovaOcorrencia, jBtSalvarOcorrencia});

        jTabbedPane1.addTab("Ocorrências", jPanel16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, Short.MAX_VALUE)
        );

        setBounds(300, 30, 541, 543);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesqDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqDataActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jDataPesqInicial.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data inicial para pesquisa.");
            jDataPesqInicial.requestFocus();
        } else {
            if (jDataPesqFinal.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data final para pesquisa.");
                jDataPesqFinal.requestFocus();
            } else {
                if (jDataPesqInicial.getDate().after(jDataPesqFinal.getDate())) {
                    JOptionPane.showMessageDialog(rootPane, "Data Inicial não pode ser maior que data final");
                } else {
                    SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
                    dataInicial = formatoAmerica.format(jDataPesqInicial.getDate().getTime());
                    dataFinal = formatoAmerica.format(jDataPesqFinal.getDate().getTime());
                    preencherTodasOcorrenciaVisitas("SELECT * FROM REGISTRO_INDISCIPLINA_PORTARIA WHERE DataReg BETWEEN'" + dataInicial + "'AND'" + dataFinal + "'");
                }
            }
        }
    }//GEN-LAST:event_jBtPesqDataActionPerformed

    private void jBtPesqIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqIDActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jIDPesqLanc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um ID para pesquisa.");
        } else {
            preencherTodasOcorrenciaVisitas("SELECT * FROM REGISTRO_INDISCIPLINA_PORTARIA WHERE IdReg='" + jIDPesqLanc.getText() + "'");
        }
    }//GEN-LAST:event_jBtPesqIDActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.preencherTodasOcorrenciaVisitas("SELECT * FROM REGISTRO_INDISCIPLINA_PORTARIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON REGISTRO_INDISCIPLINA_PORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc");
        } else {
            jtotalRegistros.setText("");
            limparTabelaOcorrenciaVisitas();
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jBtPesqNomeInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqNomeInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jPesqNomeInternoVisitado.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe um nome ou parte do nome para pesquisa.");
        } else {
            preencherTodasOcorrenciaVisitas("SELECT * FROM REGISTRO_INDISCIPLINA_PORTARIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON REGISTRO_INDISCIPLINA_PORTAIRA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE NomeInternoCrc LIKE'%" + jPesqNomeInternoVisitado.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqNomeInternoActionPerformed

    private void jBtPesqVisitaInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqVisitaInternoActionPerformed
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (jPesqNomeVisitaInterno.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome ou parte do nome da Visita.");
        } else {
            popularTabelaNomeVisita("SELECT * FROM REGISTRO_INDISCIPLINA_PORTARIA "
                    + "INNER JOIN VISITAS_OCORRENCIA_PORTAIRA "
                    + "ON REGISTRO_INDISCIPLINA_PORTARIA.IdReg=VISITAS_OCORRENCIA_PORTAIRA.IdReg "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON VISITAS_OCORRENCIA_PORTAIRA.IdVisita=VISITASINTERNO.IdVisita "
                    + "WHERE NomeVisita LIKE'%" + jPesqNomeVisitaInterno.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesqVisitaInternoActionPerformed

    private void jTabelaOcorrenciaVisitasInternosPortariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaOcorrenciaVisitasInternosPortariaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String codigoReg = "" + jTabelaOcorrenciaVisitasInternosPortaria.getValueAt(jTabelaOcorrenciaVisitasInternosPortaria.getSelectedRow(), 0);
            jIDPesqLanc.setText(codigoReg);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoriaRegistro.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            //
            if (jStatusAprovacao.getText().equals("Em Processamento")) {
                jBtPesqStatusAprovacao.setEnabled(!true);
            } else {
                jBtPesqStatusAprovacao.setEnabled(true);
            }
            bloquearCampos();
            // VISITANTES
            jCodigoVisita.setText("");
            jFotoVisita.setIcon(null);
            jStatusVisitaRol.setText("");
            jNomeVisita.setText("");
            jGrauParentescoVisita.setText("");
            //     
            jBtNovaVisita.setEnabled(true);
            // OCORRENCIAS
            jCodigoOcorrencia.setText("");
            jComboBoxNomeVisita.setSelectedItem(null);
            jTextoOcorrencia.setText("");
            //
            jBtNovaOcorrencia.setEnabled(true);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM REGISTRO_INDISCIPLINA_PORTARIA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON REGISTRO_INDISCIPLINA_PORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN ITENSLOCACAOINTERNO "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ITENSLOCACAOINTERNO.IdInternoCrc "
                        + "INNER JOIN CELAS ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                        + "INNER JOIN PAVILHAO ON CELAS.IdPav=PAVILHAO.IdPav "
                        + "WHERE REGISTRO_INDISCIPLINA_PORTARIA.IdReg='" + codigoReg + "'");
                conecta.rs.first();
                jCodigoRegistro.setText(String.valueOf(conecta.rs.getInt("IdReg")));
                jStatusOcorrencia.setText(conecta.rs.getString("StatusReg"));
                jComboBoxTipoVisita.setSelectedItem(conecta.rs.getString("TipoVisita"));
                jComboBoxTipoOcorrencia.setSelectedItem(conecta.rs.getString("TipoOcorrencia"));
                jDataRegistro.setDate(conecta.rs.getDate("DataReg"));
                jCodigoInternoCrc.setText(String.valueOf(conecta.rs.getInt("IdInternoCrc")));
                jStatusAprovacao.setText(conecta.rs.getString("StatusAprovacao"));
                jNomeInternoCrc.setText(conecta.rs.getString("NomeInternoCrc"));
                caminho = conecta.rs.getString("FotoInternoCrc");
                if (caminho != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
                    jFotoInterno.setIcon(i);
                    jFotoInterno.setIcon(new ImageIcon(i.getImage().getScaledInstance(jFotoInterno.getWidth(), jFotoInterno.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
                if (imgBytes != null) {
                    ImageIcon pic = null;
                    pic = new ImageIcon(imgBytes);
                    Image scaled = pic.getImage().getScaledInstance(jFotoInterno.getWidth(), jFotoInterno.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(scaled);
                    jFotoInterno.setIcon(icon);
                }
                jPavilhao.setText(conecta.rs.getString("DescricaoPav"));
                jCela.setText(conecta.rs.getString("EndCelaPav"));
                jDataAprovaSeg.setDate(conecta.rs.getDate("DataAprovacao"));
                jDataAprovaSS.setDate(conecta.rs.getDate("DataAprovacao1"));
                jUsuarioAprovaSeg.setText(conecta.rs.getString("UsuarioAutorizadorSeg"));
                jUsuarioAprovaServicoSocial.setText(conecta.rs.getString("UsuarioAutorizadorSS"));
                jObservacao.setText(conecta.rs.getString("Observacao"));
                conecta.desconecta();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados.\nERRO: " + ex);
            }
            if (jComboBoxTipoVisita.getSelectedItem().equals("Externa")) {
                preencherTabelaVisitas("SELECT * FROM VISITAS_OCORRENCIA_PORTARIA "
                        + "INNER JOIN REGISTRO_INDISCIPLINA_PORTARIA "
                        + "ON VISITAS_OCORRENCIA_PORTARIA.IdReg=REGISTRO_INDISCIPLINA_PORTARIA.IdReg "
                        + "INNER JOIN VISITASINTERNO "
                        + "ON VISITAS_OCORRENCIA_PORTARIA.IdVisita=VISITASINTERNO.IdVisita "
                        + "WHERE VISITAS_OCORRENCIA_PORTARIA.IdReg='" + jCodigoRegistro.getText() + "'");
                preencherTabelaOcorrencia("SELECT * FROM OCORRENCIA_INDISCIPLINA_PORTARIA "
                        + "INNER JOIN REGISTRO_INDISCIPLINA_PORTARIA "
                        + "ON REGISTRO_INDISCIPLINA_PORTARIA.IdReg=OCORRENCIA_INDISCIPLINA_PORTARIA.IdReg "
                        + "INNER JOIN VISITASINTERNO "
                        + "ON OCORRENCIA_INDISCIPLINA_PORTARIA.IdVisita=VISITASINTERNO.IdVisita "
                        + "WHERE OCORRENCIA_INDISCIPLINA_PORTARIA.IdReg='" + jCodigoRegistro.getText() + "'");
            } else if (jComboBoxTipoVisita.getSelectedItem().equals("Interna")) {
                preencherTabelaVisitasInterna("SELECT * FROM VISITAS_INTERNAS_OCORRENCIA_PORTARIA "
                        + "INNER JOIN REGISTRO_INDISCIPLINA_PORTARIA "
                        + "ON VISITAS_INTERNAS_OCORRENCIA_PORTARIA.IdReg=REGISTRO_INDISCIPLINA_PORTARIA.IdReg "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON VISITAS_INTERNAS_OCORRENCIA_PORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN ITENS_LISTA_ROL "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=ITENS_LISTA_ROL.IdInternoCrc "
                        + "WHERE VISITAS_INTERNAS_OCORRENCIA_PORTARIA.IdReg='" + jCodigoRegistro.getText() + "'");
                preencherTabelaOcorrenciaInternas("SELECT * FROM OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS "
                        + "INNER JOIN REGISTRO_INDISCIPLINA_PORTARIA "
                        + "ON REGISTRO_INDISCIPLINA_PORTARIA.IdReg=OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS.IdReg "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS.IdReg='" + jCodigoRegistro.getText() + "'");
            }
        }
    }//GEN-LAST:event_jTabelaOcorrenciaVisitasInternosPortariaMouseClicked

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaOcorrenciaDisciplinaVisitasManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaOcorrenciaDisciplinaVisitasManuP1) && codIncluirP1 == 1) {
            acao = 1;
            Novo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            limparTabelaVisitas();
            limparTabelaOcorrenciaVisitas();
            limparTabelaOcorrenciaInternas();
            limparTabelaOcorrencia();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaOcorrenciaDisciplinaVisitasManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaOcorrenciaDisciplinaVisitasManuP1) && codAlterarP1 == 1) {
            objRegInd.setStatusReg(jStatusOcorrencia.getText());
            if (jStatusOcorrencia.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa ocorrência não poderá ser alterado, o mesmo encontra-se FINALIZADO");
            } else {
                acao = 2;
                Alterar();
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaOcorrenciaDisciplinaVisitasManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaOcorrenciaDisciplinaVisitasManuP1) && codExcluirP1 == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            verificarVisitas(); // VERIFICAR REGISTRO NA TABELA (VISITAS_OCORRENCIA_PORTAIRA)
            verificarVisitasOcorrencia(); // VERIFICAR REGISTRO NA TABEKA (OCORRENCIA_INDISCIPLINA_PORTAIRA)
            objRegInd.setStatusReg(jStatusOcorrencia.getText());
            if (jStatusOcorrencia.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa ocorrência não poderá ser excluída, o mesmo encontra-se FINALIZADO");
            } else if (jCodigoRegistro.getText().equals(codigoReg)) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluído, pois, está sendo utilizado na aba visitantes.");
            } else if (jCodigoRegistro.getText().equals(codigoRegOcr)) {
                JOptionPane.showMessageDialog(rootPane, "Esse registro não poderá ser excluido, pois, está sendo utilizado na aba ocorrências.");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objRegInd.setIdReg(Integer.valueOf(jCodigoRegistro.getText()));
                    control.excluirRegistroVisitas(objRegInd);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
                    Excluir();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaOcorrenciaDisciplinaVisitasManuP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaOcorrenciaDisciplinaVisitasManuP1) && codGravarP1 == 1) {
            if (jDataRegistro.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe a data do registro.");
            } else if (jNomeInternoCrc.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome do Interno.");
            } else {
                objRegInd.setStatusReg(jStatusOcorrencia.getText());
                objRegInd.setTipoVisita((String) jComboBoxTipoVisita.getSelectedItem());
                objRegInd.setTipoOcorrencia((String) jComboBoxTipoOcorrencia.getSelectedItem());
                objRegInd.setDataReg(jDataRegistro.getDate());
                objRegInd.setStatusAprovacao(jStatusAprovacao.getText());
                objRegInd.setNomeInterno(jNomeInternoCrc.getText());
                objRegInd.setObservacao(jObservacao.getText());
                if (acao == 1) {
                    objRegInd.setUsuarioInsert(nameUser);
                    objRegInd.setDataInsert(dataModFinal);
                    objRegInd.setHorarioInsert(horaMov);
                    control.incluirRegistroVisitas(objRegInd);
                    buscarCodigo();
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    Salvar();
                }
                if (acao == 2) {
                    objRegInd.setUsuarioUp(nameUser);
                    objRegInd.setDataUp(dataModFinal);
                    objRegInd.setHorarioUp(horaMov);
                    objRegInd.setIdReg(Integer.valueOf(jCodigoRegistro.getText()));
                    control.alterarRegistroVisitas(objRegInd);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    Salvar();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jBtPesquisarInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarInternoActionPerformed
        // TODO add your handling code here:
        TelaPesqInternosOcorrenciaPortaria objPesqInt = new TelaPesqInternosOcorrenciaPortaria();
        TelaModuloPortarias.jPainelPortarias.add(objPesqInt);
        objPesqInt.show();
    }//GEN-LAST:event_jBtPesquisarInternoActionPerformed

    private void jBtPesqStatusAprovacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqStatusAprovacaoActionPerformed
        // TODO add your handling code here:
        mostrarTelaAprovacao();
    }//GEN-LAST:event_jBtPesqStatusAprovacaoActionPerformed

    private void jBtAuditoriaRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaRegistroActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaOcorrenciaVisitasPortaria objAudi = new TelaAuditoriaOcorrenciaVisitasPortaria();
        TelaModuloPortarias.jPainelPortarias.add(objAudi);
        objAudi.show();
    }//GEN-LAST:event_jBtAuditoriaRegistroActionPerformed

    private void jBtPesquisarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarVisitaActionPerformed
        // TODO add your handling code here:        
        if (jComboBoxTipoVisita.getSelectedItem().equals("Externa")) {
            TelaPesqVisitasInternoRolOcorrencia objPesqVis = new TelaPesqVisitasInternoRolOcorrencia();
            TelaModuloPortarias.jPainelPortarias.add(objPesqVis);
            objPesqVis.show();
        } else if (jComboBoxTipoVisita.getSelectedItem().equals("Interna")) {
            TelaPesqInternasVisitasRolOcorrencia objPesqIntVisita = new TelaPesqInternasVisitasRolOcorrencia();
            TelaModuloPortarias.jPainelPortarias.add(objPesqIntVisita);
            objPesqIntVisita.show();
        }
    }//GEN-LAST:event_jBtPesquisarVisitaActionPerformed

    private void jBtNovaVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaVisitaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaOcorrenciaDisciplinaVisitasVisiP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaOcorrenciaDisciplinaVisitasVisiP1) && codIncluirP1 == 1) {
            objRegInd.setStatusReg(jStatusOcorrencia.getText());
            if (jStatusOcorrencia.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa ocorrência não poderá ser alterada, a mesma encontra-se FINALIZADO");
            } else {
                acao = 3;
                NovaVisita();
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovaVisitaActionPerformed

    private void jBtAlterarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarVisitaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaOcorrenciaDisciplinaVisitasVisiP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaOcorrenciaDisciplinaVisitasVisiP1) && codAlterarP1 == 1) {
            objRegInd.setStatusReg(jStatusOcorrencia.getText());
            if (jStatusOcorrencia.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa ocorrência não poderá ser alterada, a mesma encontra-se FINALIZADO");
            } else {
                verificarVisitasOcorrencia();
                acao = 4;
                if (jCodigoRegistro.getText().equals(codigoRegOcr)) {
                    JOptionPane.showMessageDialog(rootPane, "Essa visita não poderá ser alterada, está sendo utilizada na aba ocorrência");
                } else {
                    AlterarVisita();
                }
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarVisitaActionPerformed

    private void jBtExcluirVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirVisitaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaOcorrenciaDisciplinaVisitasVisiP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaOcorrenciaDisciplinaVisitasVisiP1) && codExcluirP1 == 1) {
            objRegInd.setStatusReg(jStatusOcorrencia.getText());
            if (jStatusOcorrencia.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa ocorrência não poderá ser excluída, a mesma encontra-se FINALIZADO");
            } else {
                verificarVisitasOcorrencia();
                statusMov = "Excluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                if (jCodigoRegistro.getText().equals(codigoRegOcr)) {
                    JOptionPane.showMessageDialog(rootPane, "Essa visita não poderá ser alterada, está sendo utilizada na aba ocorrência");
                } else {
                    int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        objOcrPort.setIdItem(Integer.valueOf(idItem));
                        if (jComboBoxTipoVisita.getSelectedItem().equals("Externa")) {
                            controle.excluirVisitas(objOcrPort);
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            preencherTabelaVisitas("SELECT * FROM VISITAS_OCORRENCIA_PORTARIA "
                                    + "INNER JOIN REGISTRO_INDISCIPLINA_PORTARIA "
                                    + "ON VISITAS_OCORRENCIA_PORTARIA.IdReg=REGISTRO_INDISCIPLINA_PORTARIA.IdReg "
                                    + "INNER JOIN VISITASINTERNO "
                                    + "ON VISITAS_OCORRENCIA_PORTARIA.IdVisita=VISITASINTERNO.IdVisita "
                                    + "WHERE VISITAS_OCORRENCIA_PORTARIA.IdReg='" + jCodigoRegistro.getText() + "'");
                            ExcluirVisita();
                            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        } else if (jComboBoxTipoVisita.getSelectedItem().equals("Interna")) {
                            controleVisitas.excluirVisitasInterna(objOcrPort);
                            objLog2();
                            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                            preencherTabelaVisitasInterna("SELECT * FROM VISITAS_INTERNAS_OCORRENCIA_PORTARIA "
                                    + "INNER JOIN REGISTRO_INDISCIPLINA_PORTARIA "
                                    + "ON VISITAS_INTERNAS_OCORRENCIA_PORTARIA.IdReg=REGISTRO_INDISCIPLINA_PORTARIA.IdReg "
                                    + "INNER JOIN PRONTUARIOSCRC "
                                    + "ON VISITAS_INTERNAS_OCORRENCIA_PORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                    + "WHERE VISITAS_INTERNAS_OCORRENCIA_PORTARIA.IdReg='" + jCodigoRegistro.getText() + "'");
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirVisitaActionPerformed

    private void jBtSalvarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarVisitaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaOcorrenciaDisciplinaVisitasVisiP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaOcorrenciaDisciplinaVisitasVisiP1) && codGravarP1 == 1) {
            if (jNomeVisita.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome da visita do interno.");
            } else {
                objOcrPort.setIdReg(Integer.valueOf(jCodigoRegistro.getText()));
                objOcrPort.setBloqueioLiberacao(bloqueioLiberacao);
                objOcrPort.setTipoBloqueio(tipoBloqueio);
                objOcrPort.setConfirmar(confirmacao);
                objOcrPort.setNomeVisita(jNomeVisita.getText());
                objOcrPort.setNomeVisitaInterna(jNomeVisita.getText());
                if (acao == 3) {
                    objOcrPort.setUsuarioInsert(nameUser);
                    objOcrPort.setDataInsert(dataModFinal);
                    objOcrPort.setHorarioInsert(horaMov);
                    if (jComboBoxTipoVisita.getSelectedItem().equals("Externa")) {
                        controle.incluirVisitas(objOcrPort);
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        preencherTabelaVisitas("SELECT * FROM VISITAS_OCORRENCIA_PORTARIA "
                                + "INNER JOIN REGISTRO_INDISCIPLINA_PORTARIA "
                                + "ON VISITAS_OCORRENCIA_PORTARIA.IdReg=REGISTRO_INDISCIPLINA_PORTARIA.IdReg "
                                + "INNER JOIN VISITASINTERNO "
                                + "ON VISITAS_OCORRENCIA_PORTARIA.IdVisita=VISITASINTERNO.IdVisita "
                                + "WHERE VISITAS_OCORRENCIA_PORTARIA.IdReg='" + jCodigoRegistro.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        SalvarVisita();
                    } else if (jComboBoxTipoVisita.getSelectedItem().equals("Interna")) {
                        controleVisitas.incluirVisitasInterna(objOcrPort);
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        preencherTabelaVisitasInterna("SELECT * FROM VISITAS_INTERNAS_OCORRENCIA_PORTARIA "
                                + "INNER JOIN REGISTRO_INDISCIPLINA_PORTARIA "
                                + "ON VISITAS_INTERNAS_OCORRENCIA_PORTARIA.IdReg=REGISTRO_INDISCIPLINA_PORTARIA.IdReg "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON VISITAS_INTERNAS_OCORRENCIA_PORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "INNER JOIN ITENS_LISTA_ROL "
                                + "ON PRONTUARIOSCRC.IdInternoCrc=ITENS_LISTA_ROL.IdInternoCrc "
                                + "WHERE VISITAS_INTERNAS_OCORRENCIA_PORTARIA.IdReg='" + jCodigoRegistro.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        SalvarVisita();
                    }
                }
                if (acao == 4) {
                    objOcrPort.setUsuarioUp(nameUser);
                    objOcrPort.setDataUp(dataModFinal);
                    objOcrPort.setHorarioUp(horaMov);
                    objOcrPort.setIdReg(Integer.valueOf(jCodigoRegistro.getText()));
                    objOcrPort.setIdItem(Integer.valueOf(idItem));
                    if (jComboBoxTipoVisita.getSelectedItem().equals("Externa")) {
                        controle.alterarVisitas(objOcrPort);
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        preencherTabelaVisitas("SELECT * FROM VISITAS_OCORRENCIA_PORTARIA "
                                + "INNER JOIN REGISTRO_INDISCIPLINA_PORTARIA "
                                + "ON VISITAS_OCORRENCIA_PORTARIA.IdReg=REGISTRO_INDISCIPLINA_PORTARIA.IdReg "
                                + "INNER JOIN VISITASINTERNO "
                                + "ON VISITAS_OCORRENCIA_PORTARIA.IdVisita=VISITASINTERNO.IdVisita "
                                + "WHERE VISITAS_OCORRENCIA_PORTARIA.IdReg='" + jCodigoRegistro.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        SalvarVisita();
                    } else if (jComboBoxTipoVisita.getSelectedItem().equals("Interna")) {
                        controleVisitas.alterarVisitasInterna(objOcrPort);
                        objLog2();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        preencherTabelaVisitasInterna("SELECT * FROM VISITAS_INTERNAS_OCORRENCIA_PORTARIA "
                                + "INNER JOIN REGISTRO_INDISCIPLINA_PORTARIA "
                                + "ON VISITAS_INTERNAS_OCORRENCIA_PORTARIA.IdReg=REGISTRO_INDISCIPLINA_PORTARIA.IdReg "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON VISITAS_INTERNAS_OCORRENCIA_PORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "INNER JOIN ITENS_LISTA_ROL "
                                + "ON PRONTUARIOSCRC.IdInternoCrc=ITENS_LISTA_ROL.IdInternoCrc "
                                + "WHERE VISITAS_INTERNAS_OCORRENCIA_PORTARIA.IdReg='" + jCodigoRegistro.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                        SalvarVisita();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtSalvarVisitaActionPerformed

    private void jBtCancelarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarVisitaActionPerformed
        // TODO add your handling code here:
        CancelarVisita();
    }//GEN-LAST:event_jBtCancelarVisitaActionPerformed

    private void jBtAuditoriaVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaVisitaActionPerformed
        // TODO add your handling code here:
        TelaAuditoriaVisitasOcorrencia objAudiVisi = new TelaAuditoriaVisitasOcorrencia();
        TelaModuloPortarias.jPainelPortarias.add(objAudiVisi);
        objAudiVisi.show();
    }//GEN-LAST:event_jBtAuditoriaVisitaActionPerformed

    private void jTabelaVisitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaVisitaMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            idItem = "" + jTabelaVisita.getValueAt(jTabelaVisita.getSelectedRow(), 0);
            String idVisita = "" + jTabelaVisita.getValueAt(jTabelaVisita.getSelectedRow(), 1);
            jCodigoVisita.setText(idVisita);
            String nomeVisitante = "" + jTabelaVisita.getValueAt(jTabelaVisita.getSelectedRow(), 2);
            jNomeVisita.setText(nomeVisitante);
            // Habilitar os botões                       
            jBtNovaVisita.setEnabled(true);
            jBtAlterarVisita.setEnabled(true);
            jBtExcluirVisita.setEnabled(true);
            jBtSalvarVisita.setEnabled(!true);
            jBtCancelarVisita.setEnabled(true);
            jBtAuditoriaVisita.setEnabled(true);
            conecta.abrirConexao();
            if (jComboBoxTipoVisita.getSelectedItem().equals("Externa")) {
                try {
                    conecta.executaSQL("SELECT * FROM VISITAS_OCORRENCIA_PORTARIA "
                            + "INNER JOIN VISITASINTERNO "
                            + "ON VISITAS_OCORRENCIA_PORTARIA.IdVisita=VISITASINTERNO.IdVisita "
                            + "INNER JOIN ITENSROL "
                            + "ON VISITASINTERNO.IdVisita=ITENSROL.IdVisita "
                            + "WHERE VISITASINTERNO.NomeVisita='" + nomeVisitante + "' "
                            + "AND VISITASINTERNO.IdVisita='" + idVisita + "' ");
                    conecta.rs.first();
                    caminhoVisita = conecta.rs.getString("ImagemVisita");
                    if (caminhoVisita != null) {
                        javax.swing.ImageIcon v = new javax.swing.ImageIcon(caminhoVisita);
                        jFotoVisita.setIcon(v);
                        jFotoVisita.setIcon(new ImageIcon(v.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT)));
                    }
                    // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                    byte[] img2Bytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteVI"));
                    if (img2Bytes != null) {
                        ImageIcon pic2 = null;
                        pic2 = new ImageIcon(img2Bytes);
                        Image scaled2 = pic2.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT);
                        ImageIcon icon2 = new ImageIcon(scaled2);
                        jFotoVisita.setIcon(icon2);
                    }
                    jCodigoVisita.setText(conecta.rs.getString("IdVisita")); //Coluna 0
                    jNomeVisita.setText(conecta.rs.getString("NomeVisita")); // Coluna 1
                    jStatusVisitaRol.setText(conecta.rs.getString("StatusVisita"));
                    jGrauParentescoVisita.setText(conecta.rs.getString("ParentescoVisita"));
                    idItemVisita = conecta.rs.getInt("IdItem");
                } catch (SQLException ex) {
                }
            } else if (jComboBoxTipoVisita.getSelectedItem().equals("Interna")) {
                try {
                    conecta.executaSQL("SELECT * FROM VISITAS_INTERNAS_OCORRENCIA_PORTARIA "
                            + "INNER JOIN PRONTUARIOSCRC "
                            + "ON VISITAS_INTERNAS_OCORRENCIA_PORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                            + "INNER JOIN ITENS_LISTA_ROL "
                            + "ON PRONTUARIOSCRC.IdInternoCrc=ITENS_LISTA_ROL.IdInternoCrc "
                            + "WHERE PRONTUARIOSCRC.NomeInternoCrc='" + nomeVisitante + "' "
                            + "AND PRONTUARIOSCRC.IdInternoCrc='" + idVisita + "' ");
                    conecta.rs.first();
                    caminhoVisita = conecta.rs.getString("FotoInternoCrc");
                    javax.swing.ImageIcon v = new javax.swing.ImageIcon(caminhoVisita);
                    jFotoVisita.setIcon(v);
                    jFotoVisita.setIcon(new ImageIcon(v.getImage().getScaledInstance(jFotoVisita.getWidth(), jFotoVisita.getHeight(), Image.SCALE_DEFAULT)));
                    jCodigoVisita.setText(conecta.rs.getString("IdInternoCrc")); //Coluna 0
                    jNomeVisita.setText(conecta.rs.getString("NomeInternoCrc")); // Coluna 1
                    jStatusVisitaRol.setText(conecta.rs.getString("StatusInterna"));
                    // jGrauParentescoVisita.setText(conecta.rs.getString("ParentescoVisita"));
                    idItemVisita = conecta.rs.getInt("IdItem");
                } catch (SQLException ex) {
                }
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaVisitaMouseClicked

    private void jBtNovaOcorrenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovaOcorrenciaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaOcorrenciaDisciplinaVisitasOcorP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaOcorrenciaDisciplinaVisitasOcorP1) && codIncluirP1 == 1) {
            objRegInd.setStatusReg(jStatusOcorrencia.getText());
            if (jStatusOcorrencia.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa ocorrência não poderá ser alterada, a mesma encontra-se FINALIZADO");
            } else {
                acao = 5;
                statusMov = "Incluiu";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                NovaOcorrencia();
                if (jComboBoxTipoVisita.getSelectedItem().equals("Externa")) {
                    preencherComboBoxVisita();
                } else if (jComboBoxTipoVisita.getSelectedItem().equals("Interna")) {
                    preencherComboBoxVisitaInterna();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtNovaOcorrenciaActionPerformed

    private void jBtAlterarOcorrenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarOcorrenciaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaOcorrenciaDisciplinaVisitasOcorP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaOcorrenciaDisciplinaVisitasOcorP1) && codAlterarP1 == 1) {
            objRegInd.setStatusReg(jStatusOcorrencia.getText());
            if (jStatusOcorrencia.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa ocorrência não poderá ser alterada, a mesma encontra-se FINALIZADO");
            } else {
                acao = 6;
                statusMov = "Alterou";
                horaMov = jHoraSistema.getText();
                dataModFinal = jDataSistema.getText();
                AlterarOcorrencia();
                preencherComboBoxVisita();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtAlterarOcorrenciaActionPerformed

    private void jBtExcluirOcorrenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirOcorrenciaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaOcorrenciaDisciplinaVisitasOcorP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaOcorrenciaDisciplinaVisitasOcorP1) && codExcluirP1 == 1) {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            objRegInd.setStatusReg(jStatusOcorrencia.getText());
            if (jStatusOcorrencia.getText().equals("FINALIZADO")) {
                JOptionPane.showMessageDialog(rootPane, "Essa ocorrência não poderá ser alterada, a mesma encontra-se FINALIZADO");
            } else {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o registro selecionado?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    objocrIndPorta.setIdOcr(Integer.valueOf(jCodigoOcorrencia.getText()));
                    controleOcr.excluirOcorrenciaVisitas(objocrIndPorta);
                    //                
                    objLog3();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                    ExcluirOcorrencia();
                    preencherTabelaOcorrencia("SELECT * FROM OCORRENCIA_INDISCIPLINA_PORTARIA "
                            + "INNER JOIN REGISTRO_INDISCIPLINA_PORTARIA "
                            + "ON REGISTRO_INDISCIPLINA_PORTARIA.IdReg=OCORRENCIA_INDISCIPLINA_PORTARIA.IdReg "
                            + "INNER JOIN VISITASINTERNO "
                            + "ON OCORRENCIA_INDISCIPLINA_PORTARIA.IdVisita=VISITASINTERNO.IdVisita "
                            + "WHERE OCORRENCIA_INDISCIPLINA_PORTARIA.IdReg='" + jCodigoRegistro.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Registro excluído com successo.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtExcluirOcorrenciaActionPerformed

    private void jBtSalvarOcorrenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarOcorrenciaActionPerformed
        // TODO add your handling code here:
        buscarAcessoUsuario(telaOcorrenciaDisciplinaVisitasOcorP1);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoP1.equals("ADMINISTRADORES") || codigoUserP1 == codUserAcessoP1 && nomeTelaP1.equals(telaOcorrenciaDisciplinaVisitasOcorP1) && codGravarP1 == 1) {
            if (jComboBoxNomeVisita.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(rootPane, "Informe o nome da vista do interno para ocorrência.");
            } else if (jTextoOcorrencia.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o texto da ocorrência.");
            } else {
                objocrIndPorta.setNomeVisita((String) jComboBoxNomeVisita.getSelectedItem());
                objocrIndPorta.setNomeIntenoCrc((String) jComboBoxNomeVisita.getSelectedItem());
                objocrIndPorta.setIdReg(Integer.valueOf(jCodigoRegistro.getText()));
                objocrIndPorta.setTextoOcorrencia(jTextoOcorrencia.getText());
                if (acao == 5) {
                    objocrIndPorta.setUsuarioInsert(nameUser);
                    objocrIndPorta.setDataInsert(dataModFinal);
                    objocrIndPorta.setHorarioInsert(horaMov);
                    if (jComboBoxTipoVisita.getSelectedItem().equals("Externa")) {
                        controleOcr.incluirOcorrenciaVisitas(objocrIndPorta);
                        objLog3();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        SalvarOcorrencia();
                        preencherTabelaOcorrencia("SELECT * FROM OCORRENCIA_INDISCIPLINA_PORTARIA "
                                + "INNER JOIN REGISTRO_INDISCIPLINA_PORTARIA "
                                + "ON REGISTRO_INDISCIPLINA_PORTARIA.IdReg=OCORRENCIA_INDISCIPLINA_PORTARIA.IdReg "
                                + "INNER JOIN VISITASINTERNO "
                                + "ON OCORRENCIA_INDISCIPLINA_PORTARIA.IdVisita=VISITASINTERNO.IdVisita "
                                + "WHERE OCORRENCIA_INDISCIPLINA_PORTARIA.IdReg='" + jCodigoRegistro.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com successo.");
                    } else if (jComboBoxTipoVisita.getSelectedItem().equals("Interna")) {
                        controleOcrIn.incluirOcorrenciaVisitasInternos(objocrIndPorta);
                        objLog3();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        SalvarOcorrencia();
                        preencherTabelaOcorrenciaInternas("SELECT * FROM OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS "
                                + "INNER JOIN REGISTRO_INDISCIPLINA_PORTARIA "
                                + "ON REGISTRO_INDISCIPLINA_PORTARIA.IdReg=OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS.IdReg "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS.IdReg='" + jCodigoRegistro.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com successo.");
                    }
                }
                if (acao == 6) {
                    objocrIndPorta.setUsuarioUp(nameUser);
                    objocrIndPorta.setDataUp(dataModFinal);
                    objocrIndPorta.setHorarioUp(horaMov);
                    if (jComboBoxTipoVisita.getSelectedItem().equals("Externa")) {
                        objocrIndPorta.setIdOcr(Integer.valueOf(jCodigoOcorrencia.getText()));
                        controleOcr.alterarOcorrenciaVisitas(objocrIndPorta);
                        objLog3();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        SalvarOcorrencia();
                        preencherTabelaOcorrencia("SELECT * FROM OCORRENCIA_INDISCIPLINA_PORTARIA "
                                + "INNER JOIN REGISTRO_INDISCIPLINA_PORTARIA "
                                + "ON REGISTRO_INDISCIPLINA_PORTARIA.IdReg=OCORRENCIA_INDISCIPLINA_PORTARIA.IdReg "
                                + "INNER JOIN VISITASINTERNO "
                                + "ON OCORRENCIA_INDISCIPLINA_PORTARIA.IdVisita=VISITASINTERNO.IdVisita "
                                + "WHERE OCORRENCIA_INDISCIPLINA_PORTARIA.IdReg='" + jCodigoRegistro.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com successo.");
                    } else if (jComboBoxTipoVisita.getSelectedItem().equals("Interna")) {
                        objocrIndPorta.setIdOcr(Integer.valueOf(jCodigoOcorrencia.getText()));
                        controleOcrIn.alterarOcorrenciaVisitasInternos(objocrIndPorta);
                        objLog3();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        SalvarOcorrencia();
                        preencherTabelaOcorrenciaInternas("SELECT * FROM OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS "
                                + "INNER JOIN REGISTRO_INDISCIPLINA_PORTARIA "
                                + "ON REGISTRO_INDISCIPLINA_PORTARIA.IdReg=OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS.IdReg "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "WHERE OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS.IdReg='" + jCodigoRegistro.getText() + "'");
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com successo.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuário não tem acesso ao registro.");
        }
    }//GEN-LAST:event_jBtSalvarOcorrenciaActionPerformed

    private void jBtCancelarOcorrenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarOcorrenciaActionPerformed
        // TODO add your handling code here:
        CancelarOcorrencia();
    }//GEN-LAST:event_jBtCancelarOcorrenciaActionPerformed

    private void jBtAuditoriaOcorrenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAuditoriaOcorrenciaActionPerformed
        // TODO add your handling code here:
        if (jComboBoxTipoVisita.getSelectedItem().equals("Externa")) {
            TelaAuditoriaOcorrenciaVisitas objAudiOcrVisitas = new TelaAuditoriaOcorrenciaVisitas();
            TelaModuloPortarias.jPainelPortarias.add(objAudiOcrVisitas);
            objAudiOcrVisitas.show();
        } else if (jComboBoxTipoVisita.getSelectedItem().equals("Interna")) {
            TelaAuditoriaOcorrenciaVisitasInternas objAudiOcrVisitasInternas = new TelaAuditoriaOcorrenciaVisitasInternas();
            TelaModuloPortarias.jPainelPortarias.add(objAudiOcrVisitasInternas);
            objAudiOcrVisitasInternas.show();
        }

    }//GEN-LAST:event_jBtAuditoriaOcorrenciaActionPerformed

    private void jTabelaOcorrenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaOcorrenciaMouseClicked
        // TODO add your handling code here:
        if (flag == 1) {
            idItem = "" + jTabelaOcorrencia.getValueAt(jTabelaOcorrencia.getSelectedRow(), 0);
            String idVisita = "" + jTabelaOcorrencia.getValueAt(jTabelaOcorrencia.getSelectedRow(), 1);
            jCodigoVisita.setText(idVisita);
            String nomeVisitante = "" + jTabelaOcorrencia.getValueAt(jTabelaOcorrencia.getSelectedRow(), 2);
            jNomeVisita.setText(nomeVisitante);
            // Habilitar os botões                       
            jBtNovaOcorrencia.setEnabled(true);
            jBtAlterarOcorrencia.setEnabled(true);
            jBtExcluirOcorrencia.setEnabled(true);
            jBtSalvarOcorrencia.setEnabled(!true);
            jBtCancelarOcorrencia.setEnabled(true);
            jBtAuditoriaOcorrencia.setEnabled(true);
            jBtImprimir.setEnabled(true);
            //
            jComboBoxNomeVisita.removeAllItems();
            //
            conecta.abrirConexao();
            if (jComboBoxTipoVisita.getSelectedItem().equals("Externa")) {
                try {
                    conecta.executaSQL("SELECT * FROM VISITASINTERNO "
                            + "INNER JOIN OCORRENCIA_INDISCIPLINA_PORTARIA "
                            + "ON VISITASINTERNO.IdVisita=OCORRENCIA_INDISCIPLINA_PORTARIA.IdVisita "
                            + "WHERE VISITASINTERNO.NomeVisita='" + nomeVisitante + "' "
                            + "AND VISITASINTERNO.IdVisita='" + idVisita + "' ");
                    conecta.rs.first();
                    jCodigoOcorrencia.setText(conecta.rs.getString("IdOcr"));
                    codigoVisita = conecta.rs.getInt("IdVisita");
                    jComboBoxNomeVisita.addItem(conecta.rs.getString("NomeVisita")); // Coluna 1                
                    jTextoOcorrencia.setText(conecta.rs.getString("TextoOcorrencia"));
                } catch (SQLException ex) {
                }
            } else if (jComboBoxTipoVisita.getSelectedItem().equals("Interna")) {
                try {
                    conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                            + "INNER JOIN OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS "
                            + "ON PRONTUARIOSCRC.IdInternoCrc=OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS.IdInternoCrc "
                            + "WHERE PRONTUARIOSCRC.NomeInternoCrc='" + nomeVisitante + "' "
                            + "AND PRONTUARIOSCRC.IdInternoCrc='" + idVisita + "' ");
                    conecta.rs.first();
                    jCodigoOcorrencia.setText(conecta.rs.getString("IdOcr"));
                    codigoVisita = conecta.rs.getInt("IdInternoCrc");
                    jComboBoxNomeVisita.addItem(conecta.rs.getString("NomeInternoCrc")); // Coluna 1                
                    jTextoOcorrencia.setText(conecta.rs.getString("TextoOcorrencia"));
                } catch (SQLException ex) {
                }
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaOcorrenciaMouseClicked

    private void jBtFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarActionPerformed
        // TODO add your handling code here:
        if (jStatusOcorrencia.getText().equals("FINALIZADO")) {
            JOptionPane.showMessageDialog(rootPane, "Lançamento já foi finalizado");
        } else {
            Finalizar();
        }
    }//GEN-LAST:event_jBtFinalizarActionPerformed

    private void jBtImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtImprimirActionPerformed
        // TODO add your handling code here:
        if (jComboBoxTipoVisita.getSelectedItem().equals("Externa")) {
            try {
                conecta.abrirConexao();
                String path = "reports/RelatorioOcorrenciasIndisciplinarVisitasPortaria.jasper";
                conecta.executaSQL("SELECT * FROM REGISTRO_INDISCIPLINA_PORTARIA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON REGISTRO_INDISCIPLINA_PORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN VISITAS_OCORRENCIA_PORTARIA "
                        + "ON REGISTRO_INDISCIPLINA_PORTARIA.IdReg=VISITAS_OCORRENCIA_PORTARIA.IdReg "
                        + "INNER JOIN VISITASINTERNO "
                        + "ON VISITAS_OCORRENCIA_PORTARIA.IdVisita=VISITASINTERNO.IdVisita "
                        + "INNER JOIN OCORRENCIA_INDISCIPLINA_PORTARIA "
                        + "ON REGISTRO_INDISCIPLINA_PORTARIA.IdReg=OCORRENCIA_INDISCIPLINA_PORTARIA.IdReg "
                        + "WHERE REGISTRO_INDISCIPLINA_PORTARIA.IdReg='" + jCodigoRegistro.getText() + "' "
                        + "AND OCORRENCIA_INDISCIPLINA_PORTARIA.IdOcr='" + jCodigoOcorrencia.getText() + "' "
                        + "AND OCORRENCIA_INDISCIPLINA_PORTARIA.IdVisita='" + codigoVisita + "'");
                HashMap parametros = new HashMap();
                parametros.put("codigoRegistro", jCodigoRegistro.getText());
                parametros.put("codigoOcorrencia", jCodigoOcorrencia.getText());
                parametros.put("nomeVisitante", jComboBoxNomeVisita.getSelectedItem());
                parametros.put("nameUser", nameUser);
                JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                jv.setTitle("Relatório de Ocorrências Indisciplinar de Visitas"); // Titulo do relatório
                jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                jv.toFront(); // Traz o relatorio para frente da aplicação            
                conecta.desconecta();
            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
            }
        } else if (jComboBoxTipoVisita.getSelectedItem().equals("Interna")) {
            try {
                conecta.abrirConexao();
                String path = "reports/Portarias/RelatorioOcorrenciasIndisciplinarVisitasInternasPortaria.jasper";
                conecta.executaSQL("SELECT * FROM REGISTRO_INDISCIPLINA_PORTARIA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON REGISTRO_INDISCIPLINA_PORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "INNER JOIN VISITAS_INTERNAS_OCORRENCIA_PORTARIA "
                        + "ON REGISTRO_INDISCIPLINA_PORTARIA.IdReg=VISITAS_INTERNAS_OCORRENCIA_PORTARIA.IdReg "
                        + "INNER JOIN OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS "
                        + "ON REGISTRO_INDISCIPLINA_PORTARIA.IdReg=OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS.IdReg "
                        + "WHERE REGISTRO_INDISCIPLINA_PORTARIA.IdReg='" + jCodigoRegistro.getText() + "' "
                        + "AND OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS.IdOcr='" + jCodigoOcorrencia.getText() + "' "
                        + "AND OCORRENCIA_INDISCIPLINA_PORTARIA_INTERNOS.IdInternoCrc='" + codigoVisita + "'");
                HashMap parametros = new HashMap();
                parametros.put("codigoRegistro", jCodigoRegistro.getText());
                parametros.put("codigoOcorrencia", jCodigoOcorrencia.getText());
                parametros.put("nomeVisitante", jComboBoxNomeVisita.getSelectedItem());
                parametros.put("nameUser", nameUser);
                JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
                JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
                JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
                jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
                jv.setTitle("Relatório de Ocorrências Indisciplinar de Visitas"); // Titulo do relatório
                jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
                jv.toFront(); // Traz o relatorio para frente da aplicação            
                conecta.desconecta();
            } catch (JRException e) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
            }
        }
    }//GEN-LAST:event_jBtImprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarOcorrencia;
    private javax.swing.JButton jBtAlterarVisita;
    private javax.swing.JButton jBtAuditoriaOcorrencia;
    private javax.swing.JButton jBtAuditoriaRegistro;
    private javax.swing.JButton jBtAuditoriaVisita;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarOcorrencia;
    private javax.swing.JButton jBtCancelarVisita;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirOcorrencia;
    private javax.swing.JButton jBtExcluirVisita;
    private javax.swing.JButton jBtFinalizar;
    private javax.swing.JButton jBtImprimir;
    private javax.swing.JButton jBtNovaOcorrencia;
    private javax.swing.JButton jBtNovaVisita;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtPesqData;
    private javax.swing.JButton jBtPesqID;
    private javax.swing.JButton jBtPesqNomeInterno;
    private javax.swing.JButton jBtPesqStatusAprovacao;
    private javax.swing.JButton jBtPesqVisitaInterno;
    private javax.swing.JButton jBtPesquisarInterno;
    private javax.swing.JButton jBtPesquisarVisita;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarOcorrencia;
    private javax.swing.JButton jBtSalvarVisita;
    public static javax.swing.JTextField jCela;
    private javax.swing.JCheckBox jCheckBox1;
    public static javax.swing.JTextField jCodigoInternoCrc;
    public static javax.swing.JTextField jCodigoOcorrencia;
    public static javax.swing.JTextField jCodigoRegistro;
    public static javax.swing.JTextField jCodigoVisita;
    private javax.swing.JComboBox jComboBoxNomeVisita;
    private javax.swing.JComboBox jComboBoxTipoOcorrencia;
    public static javax.swing.JComboBox jComboBoxTipoVisita;
    private com.toedter.calendar.JDateChooser jDataAprovaSS;
    private com.toedter.calendar.JDateChooser jDataAprovaSeg;
    private com.toedter.calendar.JDateChooser jDataPesqFinal;
    private com.toedter.calendar.JDateChooser jDataPesqInicial;
    private com.toedter.calendar.JDateChooser jDataRegistro;
    public static javax.swing.JLabel jFotoInterno;
    public static javax.swing.JLabel jFotoVisita;
    public static javax.swing.JTextField jGrauParentescoVisita;
    private javax.swing.JTextField jIDPesqLanc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField jNomeInternoCrc;
    public static javax.swing.JTextField jNomeVisita;
    private javax.swing.JTextArea jObservacao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JTextField jPavilhao;
    private javax.swing.JTextField jPesqNomeInternoVisitado;
    private javax.swing.JTextField jPesqNomeVisitaInterno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jStatusAprovacao;
    private javax.swing.JTextField jStatusOcorrencia;
    public static javax.swing.JTextField jStatusVisitaRol;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaOcorrencia;
    private javax.swing.JTable jTabelaOcorrenciaVisitasInternosPortaria;
    private javax.swing.JTable jTabelaVisita;
    private javax.swing.JTextArea jTextoOcorrencia;
    private javax.swing.JTextField jUsuarioAprovaSeg;
    private javax.swing.JTextField jUsuarioAprovaServicoSocial;
    private javax.swing.JLabel jtotaItenslRegistrosVisitas;
    private javax.swing.JLabel jtotalItensRegistrosOcr;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        jObservacao.setLineWrap(true);
        jObservacao.setWrapStyleWord(true);
        //
        jTextoOcorrencia.setLineWrap(true);
        jTextoOcorrencia.setWrapStyleWord(true);
    }

    public void corCampos() {
        jCodigoRegistro.setBackground(Color.white);
        jStatusOcorrencia.setBackground(Color.white);
        jComboBoxTipoOcorrencia.setBackground(Color.white);
        jDataRegistro.setBackground(Color.white);
        jCodigoInternoCrc.setBackground(Color.white);
        jStatusAprovacao.setBackground(Color.white);
        jNomeInternoCrc.setBackground(Color.white);
        jPavilhao.setBackground(Color.white);
        jCela.setBackground(Color.white);
        jDataAprovaSeg.setBackground(Color.white);
        jUsuarioAprovaSeg.setBackground(Color.white);
        jDataAprovaSS.setBackground(Color.white);
        jUsuarioAprovaServicoSocial.setBackground(Color.white);
        jObservacao.setBackground(Color.white);
        //
        jCodigoVisita.setBackground(Color.white);
        jStatusVisitaRol.setBackground(Color.white);
        jNomeVisita.setBackground(Color.white);
        jGrauParentescoVisita.setBackground(Color.white);
        //
        jCodigoOcorrencia.setBackground(Color.white);
        jComboBoxNomeVisita.setBackground(Color.white);
        jTextoOcorrencia.setBackground(Color.white);
    }

    public void Novo() {
        // REGISTRO
        jCodigoRegistro.setText("");
        jStatusOcorrencia.setText("ABERTO");
        jComboBoxTipoVisita.setSelectedItem("Externa");
        jComboBoxTipoOcorrencia.setSelectedItem("Drogas");
        jDataRegistro.setCalendar(Calendar.getInstance());
        jFotoInterno.setIcon(null);
        jCodigoInternoCrc.setText("");
        jStatusAprovacao.setText("Em Processanto");
        jNomeInternoCrc.setText("");
        jPavilhao.setText("");
        jCela.setText("");
        jDataAprovaSeg.setDate(null);
        jUsuarioAprovaSeg.setText("");
        jDataAprovaSS.setDate(null);
        jUsuarioAprovaServicoSocial.setText("");
        jObservacao.setText("");
        // VISITANTES
        jCodigoVisita.setText("");
        jFotoVisita.setIcon(null);
        jStatusVisitaRol.setText("");
        jNomeVisita.setText("");
        jGrauParentescoVisita.setText("");
        // OCORRENCIAS
        jCodigoOcorrencia.setText("");
        jComboBoxNomeVisita.setSelectedItem(null);
        jTextoOcorrencia.setText("");
        // REGISTROS
        jComboBoxTipoVisita.setEnabled(true);
        jComboBoxTipoOcorrencia.setEnabled(true);
        jDataRegistro.setEnabled(true);
        jBtPesquisarInterno.setEnabled(true);
        jBtPesqStatusAprovacao.setEnabled(!true);
        jObservacao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtAuditoriaRegistro.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        // ABA VISITAS
        jBtPesquisarVisita.setEnabled(!true);
        jBtNovaVisita.setEnabled(!true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtAuditoriaVisita.setEnabled(!true);
        // ABA OCORRENCIA
        jComboBoxNomeVisita.setEnabled(!true);
        jTextoOcorrencia.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(!true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void Alterar() {
        // VISITANTES
        jCodigoVisita.setText("");
        jFotoVisita.setIcon(null);
        jStatusVisitaRol.setText("");
        jNomeVisita.setText("");
        jGrauParentescoVisita.setText("");
        // OCORRENCIAS
        jCodigoOcorrencia.setText("");
        jComboBoxNomeVisita.setSelectedItem(null);
        jTextoOcorrencia.setText("");
        // REGISTROS
        jComboBoxTipoVisita.setEnabled(true);
        jComboBoxTipoOcorrencia.setEnabled(true);
        jDataRegistro.setEnabled(true);
        jBtPesquisarInterno.setEnabled(true);
        jBtPesqStatusAprovacao.setEnabled(!true);
        jObservacao.setEnabled(true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtAuditoriaRegistro.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        // ABA VISITAS
        jBtPesquisarVisita.setEnabled(!true);
        jBtNovaVisita.setEnabled(!true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtAuditoriaVisita.setEnabled(!true);
        // ABA OCORRENCIA
        jComboBoxNomeVisita.setEnabled(!true);
        jTextoOcorrencia.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(!true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void Excluir() {
        // REGISTRO
        jCodigoRegistro.setText("");
        jStatusOcorrencia.setText("");
        jComboBoxTipoVisita.setSelectedItem("Externa");
        jComboBoxTipoOcorrencia.setSelectedItem("Drogas");
        jDataRegistro.setCalendar(Calendar.getInstance());
        jFotoInterno.setIcon(null);
        jCodigoInternoCrc.setText("");
        jStatusAprovacao.setText("");
        jNomeInternoCrc.setText("");
        jPavilhao.setText("");
        jCela.setText("");
        jDataAprovaSeg.setDate(null);
        jUsuarioAprovaSeg.setText("");
        jDataAprovaSS.setDate(null);
        jUsuarioAprovaServicoSocial.setText("");
        jObservacao.setText("");
        // VISITANTES
        jCodigoVisita.setText("");
        jFotoVisita.setIcon(null);
        jStatusVisitaRol.setText("");
        jNomeVisita.setText("");
        jGrauParentescoVisita.setText("");
        // OCORRENCIAS
        jCodigoOcorrencia.setText("");
        jComboBoxNomeVisita.setSelectedItem(null);
        jTextoOcorrencia.setText("");
        // REGISTROS
        jComboBoxTipoVisita.setEnabled(!true);
        jComboBoxTipoOcorrencia.setEnabled(!true);
        jDataRegistro.setEnabled(!true);
        jBtPesquisarInterno.setEnabled(!true);
        jBtPesqStatusAprovacao.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoriaRegistro.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        // ABA VISITAS
        jBtPesquisarVisita.setEnabled(!true);
        jBtNovaVisita.setEnabled(!true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtAuditoriaVisita.setEnabled(!true);
        // ABA OCORRENCIA
        jComboBoxNomeVisita.setEnabled(!true);
        jTextoOcorrencia.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(!true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void Salvar() {
        // REGISTROS
        jComboBoxTipoVisita.setEnabled(!true);
        jComboBoxTipoOcorrencia.setEnabled(!true);
        jDataRegistro.setEnabled(!true);
        jBtPesquisarInterno.setEnabled(!true);
        jBtPesqStatusAprovacao.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoriaRegistro.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        // ABA VISITAS       
        jBtNovaVisita.setEnabled(true);
        //
        jBtNovaOcorrencia.setEnabled(true);
    }

    public void Cancelar() {
        if (jCodigoRegistro.getText().equals("")) {
            jCodigoRegistro.setText("");
            jStatusOcorrencia.setText("");
            jComboBoxTipoVisita.setSelectedItem("Externa");
            jComboBoxTipoOcorrencia.setSelectedItem("Drogas");
            jDataRegistro.setCalendar(Calendar.getInstance());
            jFotoInterno.setIcon(null);
            jCodigoInternoCrc.setText("");
            jStatusAprovacao.setText("");
            jNomeInternoCrc.setText("");
            jPavilhao.setText("");
            jCela.setText("");
            jDataAprovaSeg.setDate(null);
            jUsuarioAprovaSeg.setText("");
            jDataAprovaSS.setDate(null);
            jUsuarioAprovaServicoSocial.setText("");
            jObservacao.setText("");
            //
            jComboBoxTipoVisita.setEnabled(!true);
            jComboBoxTipoOcorrencia.setEnabled(!true);
            jDataRegistro.setEnabled(!true);
            jBtPesquisarInterno.setEnabled(!true);
            jBtPesqStatusAprovacao.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoriaRegistro.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
        } else {
            jComboBoxTipoVisita.setEnabled(!true);
            jComboBoxTipoOcorrencia.setEnabled(!true);
            jDataRegistro.setEnabled(!true);
            jBtPesquisarInterno.setEnabled(!true);
            jBtPesqStatusAprovacao.setEnabled(!true);
            jObservacao.setEnabled(!true);
            //
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtAuditoriaRegistro.setEnabled(true);
            jBtFinalizar.setEnabled(true);
            //
            jBtNovaVisita.setEnabled(true);
            //
            jBtNovaOcorrencia.setEnabled(true);
        }
    }

    public void Finalizar() {
        String statusLanc = "FINALIZADO";
        statusMov = "Finalizou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        JOptionPane.showMessageDialog(rootPane, "Se esse Lançamento for finaliza,\nvocê não poderá mais excluir ou alterar.");
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente finalizar assim mesmo o lançamento selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objRegInd.setStatusReg(statusLanc);
            objRegInd.setIdReg(Integer.parseInt(jCodigoRegistro.getText()));
            control.finalizarRegistroVisitas(objRegInd);
            jStatusOcorrencia.setText("FINALIZADO");
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            JOptionPane.showMessageDialog(rootPane, "Registro FINALIZADO com sucesso !!!");
            // ABA REGISTRO
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            jBtFinalizar.setEnabled(!true);
            // ABA VISITA
            jBtNovaVisita.setEnabled(true);
            jBtAlterarVisita.setEnabled(!true);
            jBtExcluirVisita.setEnabled(!true);
            jBtSalvarVisita.setEnabled(!true);
            jBtCancelarVisita.setEnabled(!true);
            // ABA OCORRÊNCIA
            jBtNovaOcorrencia.setEnabled(true);
            jBtAlterarOcorrencia.setEnabled(!true);
            jBtExcluirOcorrencia.setEnabled(!true);
            jBtSalvarOcorrencia.setEnabled(!true);
            jBtCancelarOcorrencia.setEnabled(!true);
        }
    }

    public void buscarCodigo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM REGISTRO_INDISCIPLINA_PORTARIA");
            conecta.rs.last();
            jCodigoRegistro.setText(conecta.rs.getString("IdReg"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do registro.\nERRO: " + e);
        }
        conecta.desconecta();
    }

    public void verificarVisitas() {

        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITAS_OCORRENCIA_PORTARIA WHERE IdReg='" + jCodigoRegistro.getText() + "'");
            conecta.rs.first();
            codigoReg = conecta.rs.getString("IdReg");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarVisitasOcorrencia() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM OCORRENCIA_INDISCIPLINA_PORTARIA WHERE IdReg='" + jCodigoRegistro.getText() + "'");
            conecta.rs.first();
            codigoRegOcr = conecta.rs.getString("IdReg");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void bloquearCampos() {
        jComboBoxTipoVisita.setEnabled(!true);
        jComboBoxTipoOcorrencia.setEnabled(!true);
        jDataRegistro.setEnabled(!true);
        jBtPesquisarInterno.setEnabled(!true);
        if (jStatusAprovacao.getText().equals("Em Processamento")) {
            jBtPesqStatusAprovacao.setEnabled(!true);
        } else {
            jBtPesqStatusAprovacao.setEnabled(true);
        }
        jObservacao.setEnabled(!true);
    }

    public void NovaVisita() {
        // VISITANTES
        jCodigoVisita.setText("");
        jFotoVisita.setIcon(null);
        jStatusVisitaRol.setText("");
        jNomeVisita.setText("");
        jGrauParentescoVisita.setText("");
        // OCORRENCIAS
        jCodigoOcorrencia.setText("");
        jComboBoxNomeVisita.setSelectedItem(null);
        jTextoOcorrencia.setText("");
        // REGISTROS
        jComboBoxTipoVisita.setEnabled(!true);
        jComboBoxTipoOcorrencia.setEnabled(!true);
        jDataRegistro.setEnabled(!true);
        jBtPesquisarInterno.setEnabled(!true);
        jBtPesqStatusAprovacao.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoriaRegistro.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        // ABA VISITAS
        jBtPesquisarVisita.setEnabled(true);
        //
        jBtNovaVisita.setEnabled(!true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(true);
        jBtCancelarVisita.setEnabled(true);
        jBtAuditoriaVisita.setEnabled(!true);
        // ABA OCORRENCIA
        jComboBoxNomeVisita.setEnabled(!true);
        jTextoOcorrencia.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(!true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void AlterarVisita() {
        // OCORRENCIAS
        jCodigoOcorrencia.setText("");
        jComboBoxNomeVisita.setSelectedItem(null);
        jTextoOcorrencia.setText("");
        // REGISTROS
        jComboBoxTipoVisita.setEnabled(!true);
        jComboBoxTipoOcorrencia.setEnabled(!true);
        jDataRegistro.setEnabled(!true);
        jBtPesquisarInterno.setEnabled(!true);
        jBtPesqStatusAprovacao.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoriaRegistro.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        // ABA VISITAS
        jBtPesquisarVisita.setEnabled(true);
        //
        jBtNovaVisita.setEnabled(!true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(true);
        jBtCancelarVisita.setEnabled(true);
        jBtAuditoriaVisita.setEnabled(!true);
        // ABA OCORRENCIA
        jComboBoxNomeVisita.setEnabled(!true);
        jTextoOcorrencia.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(!true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void ExcluirVisita() {
        // VISITANTES
        jCodigoVisita.setText("");
        jFotoVisita.setIcon(null);
        jStatusVisitaRol.setText("");
        jNomeVisita.setText("");
        jGrauParentescoVisita.setText("");
        // OCORRENCIAS
        jCodigoOcorrencia.setText("");
        jComboBoxNomeVisita.setSelectedItem(null);
        jTextoOcorrencia.setText("");
        // REGISTROS
        jComboBoxTipoVisita.setEnabled(!true);
        jComboBoxTipoOcorrencia.setEnabled(!true);
        jDataRegistro.setEnabled(!true);
        jBtPesquisarInterno.setEnabled(!true);
        jBtPesqStatusAprovacao.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoriaRegistro.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        // ABA VISITAS
        jBtPesquisarVisita.setEnabled(!true);
        //
        jBtNovaVisita.setEnabled(true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtAuditoriaVisita.setEnabled(!true);
        // ABA OCORRENCIA
        jComboBoxNomeVisita.setEnabled(!true);
        jTextoOcorrencia.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void SalvarVisita() {
        // VISITANTES
        jCodigoVisita.setText("");
        jFotoVisita.setIcon(null);
        jStatusVisitaRol.setText("");
        jNomeVisita.setText("");
        jGrauParentescoVisita.setText("");
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoriaRegistro.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        // ABA VISITAS
        jBtPesquisarVisita.setEnabled(!true);
        //
        jBtNovaVisita.setEnabled(true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtAuditoriaVisita.setEnabled(!true);
        // ABA OCORRENCIA
        jComboBoxNomeVisita.setEnabled(!true);
        jTextoOcorrencia.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void CancelarVisita() {
        // VISITANTES
        jCodigoVisita.setText("");
        jFotoVisita.setIcon(null);
        jStatusVisitaRol.setText("");
        jNomeVisita.setText("");
        jGrauParentescoVisita.setText("");
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoriaRegistro.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        // ABA VISITAS
        jBtPesquisarVisita.setEnabled(!true);
        //
        jBtNovaVisita.setEnabled(true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtAuditoriaVisita.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void NovaOcorrencia() {
        // VISITANTES
        jCodigoVisita.setText("");
        jFotoVisita.setIcon(null);
        jStatusVisitaRol.setText("");
        jNomeVisita.setText("");
        jGrauParentescoVisita.setText("");
        // 
        jBtPesquisarVisita.setEnabled(!true);
        // REGISTROS
        jComboBoxTipoVisita.setEnabled(!true);
        jComboBoxTipoOcorrencia.setEnabled(!true);
        jDataRegistro.setEnabled(!true);
        jBtPesquisarInterno.setEnabled(!true);
        jBtPesqStatusAprovacao.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoriaRegistro.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        //
        jBtNovaVisita.setEnabled(!true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtAuditoriaVisita.setEnabled(!true);
        // ABA OCORRENCIA       
        jCodigoOcorrencia.setText("");
        jComboBoxNomeVisita.setSelectedItem(null);
        jTextoOcorrencia.setText("");
        //
        jComboBoxNomeVisita.setEnabled(true);
        jTextoOcorrencia.setEnabled(true);
        //
        jBtNovaOcorrencia.setEnabled(!true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(true);
        jBtCancelarOcorrencia.setEnabled(true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void AlterarOcorrencia() {
        // VISITANTES
        jCodigoVisita.setText("");
        jFotoVisita.setIcon(null);
        jStatusVisitaRol.setText("");
        jNomeVisita.setText("");
        jGrauParentescoVisita.setText("");
        // 
        jBtPesquisarVisita.setEnabled(!true);
        // REGISTROS
        jComboBoxTipoVisita.setEnabled(!true);
        jComboBoxTipoOcorrencia.setEnabled(!true);
        jDataRegistro.setEnabled(!true);
        jBtPesquisarInterno.setEnabled(!true);
        jBtPesqStatusAprovacao.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoriaRegistro.setEnabled(!true);
        jBtFinalizar.setEnabled(!true);
        //
        jBtNovaVisita.setEnabled(!true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtAuditoriaVisita.setEnabled(!true);
        // ABA OCORRENCIA               
        jComboBoxNomeVisita.setEnabled(true);
        jTextoOcorrencia.setEnabled(true);
        //
        jBtNovaOcorrencia.setEnabled(!true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(true);
        jBtCancelarOcorrencia.setEnabled(true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void ExcluirOcorrencia() {
        // VISITANTES
        jCodigoVisita.setText("");
        jFotoVisita.setIcon(null);
        jStatusVisitaRol.setText("");
        jNomeVisita.setText("");
        jGrauParentescoVisita.setText("");
        // 
        jBtPesquisarVisita.setEnabled(!true);
        // REGISTROS
        jComboBoxTipoVisita.setEnabled(!true);
        jComboBoxTipoOcorrencia.setEnabled(!true);
        jDataRegistro.setEnabled(!true);
        jBtPesquisarInterno.setEnabled(!true);
        jBtPesqStatusAprovacao.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoriaRegistro.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        //
        jBtNovaVisita.setEnabled(true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtAuditoriaVisita.setEnabled(!true);
        // ABA OCORRENCIA               
        jCodigoOcorrencia.setText("");
        jComboBoxNomeVisita.setSelectedItem(null);
        jTextoOcorrencia.setText("");
        //
        jComboBoxNomeVisita.setEnabled(!true);
        jTextoOcorrencia.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void SalvarOcorrencia() {
        // 
        jBtPesquisarVisita.setEnabled(!true);
        // REGISTROS
        jComboBoxTipoVisita.setEnabled(!true);
        jComboBoxTipoOcorrencia.setEnabled(!true);
        jDataRegistro.setEnabled(!true);
        jBtPesquisarInterno.setEnabled(!true);
        jBtPesqStatusAprovacao.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoriaRegistro.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        //
        jBtNovaVisita.setEnabled(true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtAuditoriaVisita.setEnabled(!true);
        // ABA OCORRENCIA               
        jCodigoOcorrencia.setText("");
        jComboBoxNomeVisita.setSelectedItem(null);
        jTextoOcorrencia.setText("");
        //
        jComboBoxNomeVisita.setEnabled(!true);
        jTextoOcorrencia.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void CancelarOcorrencia() {
        jBtPesquisarVisita.setEnabled(!true);
        // REGISTROS
        jComboBoxTipoVisita.setEnabled(!true);
        jComboBoxTipoOcorrencia.setEnabled(!true);
        jDataRegistro.setEnabled(!true);
        jBtPesquisarInterno.setEnabled(!true);
        jBtPesqStatusAprovacao.setEnabled(!true);
        jObservacao.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        jBtAuditoriaRegistro.setEnabled(true);
        jBtFinalizar.setEnabled(true);
        //
        jBtNovaVisita.setEnabled(true);
        jBtAlterarVisita.setEnabled(!true);
        jBtExcluirVisita.setEnabled(!true);
        jBtSalvarVisita.setEnabled(!true);
        jBtCancelarVisita.setEnabled(!true);
        jBtAuditoriaVisita.setEnabled(!true);
        // ABA OCORRENCIA               
        jCodigoOcorrencia.setText("");
        jComboBoxNomeVisita.setSelectedItem(null);
        jTextoOcorrencia.setText("");
        //
        jComboBoxNomeVisita.setEnabled(!true);
        jTextoOcorrencia.setEnabled(!true);
        //
        jBtNovaOcorrencia.setEnabled(true);
        jBtAlterarOcorrencia.setEnabled(!true);
        jBtExcluirOcorrencia.setEnabled(!true);
        jBtSalvarOcorrencia.setEnabled(!true);
        jBtCancelarOcorrencia.setEnabled(!true);
        jBtAuditoriaOcorrencia.setEnabled(!true);
    }

    public void preencherComboBoxVisita() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITAS_OCORRENCIA_PORTARIA "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON VISITAS_OCORRENCIA_PORTARIA.IdVisita=VISITASINTERNO.IdVisita "
                    + "WHERE VISITAS_OCORRENCIA_PORTARIA.IdReg='" + jCodigoRegistro.getText() + "'");
            conecta.rs.first();
            do {
                jComboBoxNomeVisita.addItem(conecta.rs.getString("NomeVisita"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void preencherComboBoxVisitaInterna() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM VISITAS_INTERNAS_OCORRENCIA_PORTARIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON VISITAS_INTERNAS_OCORRENCIA_PORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE VISITAS_INTERNAS_OCORRENCIA_PORTARIA.IdReg='" + jCodigoRegistro.getText() + "'");
            conecta.rs.first();
            do {
                jComboBoxNomeVisita.addItem(conecta.rs.getString("NomeInternoCrc"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void preencherTodasOcorrenciaVisitas(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataReg");
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdReg"), dataEntrada, conecta.rs.getString("StatusReg"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaOcorrenciaVisitasInternosPortaria.setModel(modelo);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(0).setResizable(false);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(1).setResizable(false);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(2).setResizable(false);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(3).setPreferredWidth(300);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(3).setResizable(false);
        jTabelaOcorrenciaVisitasInternosPortaria.getTableHeader().setReorderingAllowed(false);
        jTabelaOcorrenciaVisitasInternosPortaria.setAutoResizeMode(jTabelaOcorrenciaVisitasInternosPortaria.AUTO_RESIZE_OFF);
        jTabelaOcorrenciaVisitasInternosPortaria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaOcorrenciaVisitas();
        conecta.desconecta();
    }

    public void limparTabelaOcorrenciaVisitas() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome do Interno"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaOcorrenciaVisitasInternosPortaria.setModel(modelo);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(0).setResizable(false);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(1).setResizable(false);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(2).setResizable(false);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(3).setPreferredWidth(300);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(3).setResizable(false);
        jTabelaOcorrenciaVisitasInternosPortaria.getTableHeader().setReorderingAllowed(false);
        jTabelaOcorrenciaVisitasInternosPortaria.setAutoResizeMode(jTabelaOcorrenciaVisitasInternosPortaria.AUTO_RESIZE_OFF);
        jTabelaOcorrenciaVisitasInternosPortaria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharTabelaOcorrenciaVisitas() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void popularTabelaNomeVisita(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Status", "Nome da Visita do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataReg");
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdReg"), dataEntrada, conecta.rs.getString("StatusReg"), conecta.rs.getString("NomeVisita")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaOcorrenciaVisitasInternosPortaria.setModel(modelo);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(0).setResizable(false);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(1).setResizable(false);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(2).setResizable(false);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(3).setPreferredWidth(300);
        jTabelaOcorrenciaVisitasInternosPortaria.getColumnModel().getColumn(3).setResizable(false);
        jTabelaOcorrenciaVisitasInternosPortaria.getTableHeader().setReorderingAllowed(false);
        jTabelaOcorrenciaVisitasInternosPortaria.setAutoResizeMode(jTabelaOcorrenciaVisitasInternosPortaria.AUTO_RESIZE_OFF);
        jTabelaOcorrenciaVisitasInternosPortaria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaOcorrenciaVisitas();
        conecta.desconecta();
    }

    public void preencherTabelaVisitas(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Visitante", "Data Validade"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            countItem = 0;
            do {
                countItem = countItem + 1;
                dataValiAnt = conecta.rs.getString("DataValiAnte");
                String diae = dataValiAnt.substring(8, 10);
                String mese = dataValiAnt.substring(5, 7);
                String anoe = dataValiAnt.substring(0, 4);
                dataValiAnt = diae + "/" + mese + "/" + anoe;
                jtotaItenslRegistrosVisitas.setText(Integer.toString(countItem)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getString("IdItem"), conecta.rs.getString("IdVisita"), conecta.rs.getString("NomeVisita"), dataValiAnt});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisita.setModel(modelo);
        jTabelaVisita.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaVisita.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisita.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaVisita.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisita.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaVisita.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisita.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaVisita.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisita.getTableHeader().setReorderingAllowed(false);
        jTabelaVisita.setAutoResizeMode(jTabelaVisita.AUTO_RESIZE_OFF);
        jTabelaVisita.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaVisitas();
        conecta.desconecta();
    }

    public void limparTabelaVisitas() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Visitante", "Data Validade"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisita.setModel(modelo);
        jTabelaVisita.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaVisita.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisita.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaVisita.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisita.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaVisita.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisita.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaVisita.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisita.getTableHeader().setReorderingAllowed(false);
        jTabelaVisita.setAutoResizeMode(jTabelaVisita.AUTO_RESIZE_OFF);
        jTabelaVisita.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaVisitasInterna(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Visitante", "Data Validade"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            countItem = 0;
            do {
                countItem = countItem + 1;
                dataValidade = conecta.rs.getString("DataValidade");
                String diae = dataValidade.substring(8, 10);
                String mese = dataValidade.substring(5, 7);
                String anoe = dataValidade.substring(0, 4);
                dataValidade = diae + "/" + mese + "/" + anoe;
                jtotaItenslRegistrosVisitas.setText(Integer.toString(countItem)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getString("IdItem"), conecta.rs.getString("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc"), dataValidade});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisita.setModel(modelo);
        jTabelaVisita.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaVisita.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisita.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaVisita.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisita.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaVisita.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisita.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTabelaVisita.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisita.getTableHeader().setReorderingAllowed(false);
        jTabelaVisita.setAutoResizeMode(jTabelaVisita.AUTO_RESIZE_OFF);
        jTabelaVisita.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaVisitas();
        conecta.desconecta();
    }

    public void alinharTabelaVisitas() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaVisita.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaVisita.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaVisita.getColumnModel().getColumn(3).setCellRenderer(centralizado);
    }

    public void preencherTabelaOcorrencia(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome da Visita do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            countItem1 = 0;
            do {
                countItem1 = countItem1 + 1;
                jtotalItensRegistrosOcr.setText(Integer.toString(countItem1)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getString("IdOcr"), conecta.rs.getString("IdVisita"), conecta.rs.getString("NomeVisita")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaOcorrencia.setModel(modelo);
        jTabelaOcorrencia.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaOcorrencia.getColumnModel().getColumn(0).setResizable(false);
        jTabelaOcorrencia.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaOcorrencia.getColumnModel().getColumn(1).setResizable(false);
        jTabelaOcorrencia.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaOcorrencia.getColumnModel().getColumn(2).setResizable(false);
        jTabelaOcorrencia.getTableHeader().setReorderingAllowed(false);
        jTabelaOcorrencia.setAutoResizeMode(jTabelaOcorrencia.AUTO_RESIZE_OFF);
        jTabelaOcorrencia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaOcorrencia();
        conecta.desconecta();
    }

    public void preencherTabelaOcorrenciaInternas(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome da Visita do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            countItem1 = 0;
            do {
                countItem1 = countItem1 + 1;
                jtotalItensRegistrosOcr.setText(Integer.toString(countItem1)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getString("IdOcr"), conecta.rs.getString("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaOcorrencia.setModel(modelo);
        jTabelaOcorrencia.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaOcorrencia.getColumnModel().getColumn(0).setResizable(false);
        jTabelaOcorrencia.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaOcorrencia.getColumnModel().getColumn(1).setResizable(false);
        jTabelaOcorrencia.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaOcorrencia.getColumnModel().getColumn(2).setResizable(false);
        jTabelaOcorrencia.getTableHeader().setReorderingAllowed(false);
        jTabelaOcorrencia.setAutoResizeMode(jTabelaOcorrencia.AUTO_RESIZE_OFF);
        jTabelaOcorrencia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaOcorrencia();
        conecta.desconecta();
    }

    public void limparTabelaOcorrencia() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome da Visita do Interno"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaOcorrencia.setModel(modelo);
        jTabelaOcorrencia.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaOcorrencia.getColumnModel().getColumn(0).setResizable(false);
        jTabelaOcorrencia.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaOcorrencia.getColumnModel().getColumn(1).setResizable(false);
        jTabelaOcorrencia.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaOcorrencia.getColumnModel().getColumn(2).setResizable(false);
        jTabelaOcorrencia.getTableHeader().setReorderingAllowed(false);
        jTabelaOcorrencia.setAutoResizeMode(jTabelaOcorrencia.AUTO_RESIZE_OFF);
        jTabelaOcorrencia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void limparTabelaOcorrenciaInternas() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome da Visita do Interno"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaOcorrencia.setModel(modelo);
        jTabelaOcorrencia.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaOcorrencia.getColumnModel().getColumn(0).setResizable(false);
        jTabelaOcorrencia.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaOcorrencia.getColumnModel().getColumn(1).setResizable(false);
        jTabelaOcorrencia.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaOcorrencia.getColumnModel().getColumn(2).setResizable(false);
        jTabelaOcorrencia.getTableHeader().setReorderingAllowed(false);
        jTabelaOcorrencia.setAutoResizeMode(jTabelaOcorrencia.AUTO_RESIZE_OFF);
        jTabelaOcorrencia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaOcorrencia() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaOcorrencia.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaOcorrencia.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoRegistro.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoRegistro.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog3() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela3);
        objLogSys.setIdLancMov(Integer.valueOf(jCodigoRegistro.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarAcessoUsuario(String nomeTelaAcesso) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUserP1 = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE IdUsuario='" + codigoUserP1 + "'");
            conecta.rs.first();
            codigoUserGroupP1 = conecta.rs.getInt("IdUsuario");
            codigoGrupoP1 = conecta.rs.getInt("IdGrupo");
            nomeGrupoP1 = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + codigoUserP1 + "' "
                    + "AND NomeTela='" + nomeTelaAcesso + "'");
            conecta.rs.first();
            codUserAcessoP1 = conecta.rs.getInt("IdUsuario");
            codAbrirP1 = conecta.rs.getInt("Abrir");
            codIncluirP1 = conecta.rs.getInt("Incluir");
            codAlterarP1 = conecta.rs.getInt("Alterar");
            codExcluirP1 = conecta.rs.getInt("Excluir");
            codGravarP1 = conecta.rs.getInt("Gravar");
            codConsultarP1 = conecta.rs.getInt("Consultar");
            nomeTelaP1 = conecta.rs.getString("NomeTela");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
