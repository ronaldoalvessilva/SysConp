/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAlertasPortariaPavilhoes;
import gestor.Controle.ControleLogSistema;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import gestor.Modelo.AlertaVisitasPortariaPavilhoes;
import gestor.Modelo.LogSistema;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloBaseDois.codConsultarB2;
import static gestor.Visao.TelaModuloBaseDois.codGravarB2;
import static gestor.Visao.TelaModuloBaseDois.codUserAcessoB2;
import static gestor.Visao.TelaModuloBaseDois.codigoUserB2;
import static gestor.Visao.TelaModuloBaseDois.nomeGrupoB2;
import static gestor.Visao.TelaModuloBaseDois.nomeModuloB2;
import static gestor.Visao.TelaModuloBaseDois.nomeTelaB2;
import static gestor.Visao.TelaModuloBaseDois.telaAlertaVisitantesPortariaB2;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ronal
 */
public class TelaAlertaBasesPavilhoesBaseDois extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AlertaVisitasPortariaPavilhoes objAlertaPortPav = new AlertaVisitasPortariaPavilhoes();
    ControleAlertasPortariaPavilhoes controleOFPortPav = new ControleAlertasPortariaPavilhoes();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    //
    String nomeModuloTela1 = "Base Pavilhão:Confirmação Registro de Chegada de  Visitas de Internos:Base I";
    String nomeModuloTela2 = "Base Pavilhão:Confirmação Registro de Chegada de  Visitas de Internos:Base II";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    String dataEntrada;
    String dataEntradaAD;
    String dataEntradaOF;
    String dataReg;
    String dataInicial;
    String dataFinal;
    //
    public static String dataInicialRel;
    public static String dataFinalRel;
    //
    String caminhoVisita;
    String caminhoAdvogado;
    String caminhoOficial;
    String caminhoInterno;
    String codigoInternoReg;
    String idVisitaReg;
    //
    int flag;
    int count;
    int count1;
    int count2;
    //
    String confirmacao = "Não";
    String respostaConf = "Sim";
    public static int codigoPavilhao = 0;
    public static String descricaoPavilhao = "";
    String nivelPavilhao = "";
    public static String nomePavilhao1 = "PAVILHAO II";
    public static String nomePavilhao2 = "PAVILHAO B";
    public static String nomePavilhao3 = "TRIAGEM";
    int codigoInternoVI;
    int codigoInternoAD;
    int codigoInternoOF;
    //
    int opcaoVisita = 0;
    int opcaoAdvogado = 0;
    int opcaoOficial = 0;
    //  
    int codigoRegistroVI = 0;
    int codigoRegistroAD = 0;
    int codigoRegistroOF = 0;
    //
    int codigoAlertaVI = 0;
    int codigoAlertaAD = 0;
    int codigoAlertaOF = 0;
    //
    String idVisita;
    String idAdvogado;
    String idOficial;

    /**
     * Creates new form TelaAlertaBasesPavilhoes
     */
    public static TelaRelatorioVisitantesBasesPavilhoesB2 relVisitasBase2;

    public TelaAlertaBasesPavilhoesBaseDois() {
        initComponents();
        buscarPavilhao(nomePavilhao1, nomePavilhao2, nomePavilhao3);
        popularTabelaNomeVisita("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                + "INNER JOIN VISITASINTERNO "
                + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdVisita=VISITASINTERNO.IdVisita "
                + "INNER JOIN PAVILHAO "
                + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav=PAVILHAO.IdPav "
                + "WHERE Confirmacao='" + confirmacao + "' ");
//                + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav='" + codigoPavilhao + "'");
        popularTabelaAdvogado("SELECT DataChegada,HoraChegada,ADVOGADOS.IdAdvogado,ADVOGADOS.NomeAdvogado,PAVILHAO.DescricaoPav FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                + "INNER JOIN ADVOGADOS "
                + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdAdvogado=ADVOGADOS.IdAdvogado "
                + "INNER JOIN PAVILHAO "
                + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav=PAVILHAO.IdPav "
                + "WHERE Confirmacao='" + confirmacao + "' ");
//                + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav='" + codigoPavilhao + "' GROUP BY DataChegada,HoraChegada,ADVOGADOS.IdAdvogado,ADVOGADOS.NomeAdvogado ");
        popularTabelaOficialJustica("SELECT DataChegada,HoraChegada, OFICIAL_JUSTICA.IdOficial,OFICIAL_JUSTICA.NomeOficial,PAVILHAO.DescricaoPav FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                + "INNER JOIN OFICIAL_JUSTICA "
                + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdOficial=OFICIAL_JUSTICA.IdOficial "
                + "INNER JOIN PAVILHAO "
                + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav=PAVILHAO.IdPav "
                + "WHERE Confirmacao='" + confirmacao + "' ");
//                + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav='" + codigoPavilhao + "'GROUP BY DataChegada,HoraChegada,OFICIAL_JUSTICA.IdOficial,OFICIAL_JUSTICA.NomeOficial");
    }

    public void mostrarTelaRela() {
        relVisitasBase2 = new TelaRelatorioVisitantesBasesPavilhoesB2(this, true);
        relVisitasBase2.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotesPVAO = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCodigo = new javax.swing.JTextField();
        jNomeVisitante = new javax.swing.JTextField();
        jBtPesquisaCodigo = new javax.swing.JButton();
        jBtPesquisaNome = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jDataPesqChegada = new com.toedter.calendar.JDateChooser();
        jBtDataPesquisa = new javax.swing.JButton();
        jRBVisitas = new javax.swing.JRadioButton();
        jRBAdvogados = new javax.swing.JRadioButton();
        jRBOficialJustica = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jBtAtualizar = new javax.swing.JButton();
        jBtConfirmarVisitasInterno = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jBtConfirmarAdvogado = new javax.swing.JButton();
        jBtConfirmarOficialJustica = new javax.swing.JButton();
        jBtRelatorio = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        VisitasInternos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaVisitasInternos = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        Advogados = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaAdvogados = new javax.swing.JTable();
        jPanel33 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jtotalRegistros1 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        OficialJustica = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaOficialJustica = new javax.swing.JTable();
        jPanel36 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jtotalRegistros2 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jFotoVisitasInterno = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaInternos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jFotoOficialJustica = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jFotoAdvogado = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jFotoInterno = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Alerta de Chegada de Visitas/Advogados/Oficial Justiça aos Internos :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Pesquisas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome da Visita:");

        jCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jNomeVisitante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesquisaCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaCodigo.setToolTipText("Pesquisa por Código de Visitante");
        jBtPesquisaCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaCodigoActionPerformed(evt);
            }
        });

        jBtPesquisaNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaNome.setToolTipText("Pesquisa por Nome de Visitante");
        jBtPesquisaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaNomeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data:");

        jDataPesqChegada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPesqChegada.setMaxSelectableDate(new java.util.Date(253370775715000L));

        jBtDataPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtDataPesquisa.setToolTipText("Pesquisa por data de chegada");
        jBtDataPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDataPesquisaActionPerformed(evt);
            }
        });

        grupoBotesPVAO.add(jRBVisitas);
        jRBVisitas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBVisitas.setForeground(new java.awt.Color(204, 0, 0));
        jRBVisitas.setText("Visitas Interno");

        grupoBotesPVAO.add(jRBAdvogados);
        jRBAdvogados.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBAdvogados.setForeground(new java.awt.Color(0, 102, 0));
        jRBAdvogados.setText("Advogados");

        grupoBotesPVAO.add(jRBOficialJustica);
        jRBOficialJustica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRBOficialJustica.setForeground(new java.awt.Color(0, 0, 204));
        jRBOficialJustica.setText("Oficial Justiça");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Tipo pesquisa:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesquisaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDataPesqChegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtDataPesquisa))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jNomeVisitante)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRBVisitas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRBAdvogados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRBOficialJustica, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesquisaNome)))
                .addGap(5, 5, 5))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtDataPesquisa, jBtPesquisaCodigo, jBtPesquisaNome});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesquisaCodigo)
                    .addComponent(jBtDataPesquisa)
                    .addComponent(jDataPesqChegada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jNomeVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisaNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jRBOficialJustica)
                    .addComponent(jRBAdvogados)
                    .addComponent(jRBVisitas)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtDataPesquisa, jBtPesquisaCodigo, jBtPesquisaNome});

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jBtAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAtualizar.setText("Atualizar");
        jBtAtualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAtualizarActionPerformed(evt);
            }
        });

        jBtConfirmarVisitasInterno.setForeground(new java.awt.Color(204, 0, 0));
        jBtConfirmarVisitasInterno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtConfirmarVisitasInterno.setText("Confirmar");
        jBtConfirmarVisitasInterno.setToolTipText("Confirmar Chegada da Visita");
        jBtConfirmarVisitasInterno.setEnabled(false);
        jBtConfirmarVisitasInterno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtConfirmarVisitasInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarVisitasInternoActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        jBtConfirmarAdvogado.setForeground(new java.awt.Color(0, 0, 204));
        jBtConfirmarAdvogado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png"))); // NOI18N
        jBtConfirmarAdvogado.setText("Confirmar");
        jBtConfirmarAdvogado.setToolTipText("Confirmar Chegada de Advogado");
        jBtConfirmarAdvogado.setEnabled(false);
        jBtConfirmarAdvogado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtConfirmarAdvogado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarAdvogadoActionPerformed(evt);
            }
        });

        jBtConfirmarOficialJustica.setForeground(new java.awt.Color(153, 0, 102));
        jBtConfirmarOficialJustica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/40_16x16.png"))); // NOI18N
        jBtConfirmarOficialJustica.setText("Confirmar");
        jBtConfirmarOficialJustica.setToolTipText("Confirmar Chegada de Oficial de Justiça");
        jBtConfirmarOficialJustica.setEnabled(false);
        jBtConfirmarOficialJustica.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtConfirmarOficialJustica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarOficialJusticaActionPerformed(evt);
            }
        });

        jBtRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gtklp-icone-3770-16.png"))); // NOI18N
        jBtRelatorio.setText("Relatórios");
        jBtRelatorio.setToolTipText("Imprimir Relatório Geral dos Visitantes");
        jBtRelatorio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBtRelatorio)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBtSair, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jBtConfirmarOficialJustica, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jBtAtualizar)
                                        .addComponent(jBtConfirmarAdvogado)))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jBtConfirmarVisitasInterno)
                                .addContainerGap())))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAtualizar, jBtConfirmarAdvogado, jBtConfirmarOficialJustica, jBtConfirmarVisitasInterno, jBtRelatorio, jBtSair});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jBtAtualizar)
                .addGap(52, 52, 52)
                .addComponent(jBtConfirmarVisitasInterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtConfirmarAdvogado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtConfirmarOficialJustica)
                .addGap(77, 77, 77)
                .addComponent(jBtRelatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtSair)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAtualizar, jBtConfirmarAdvogado, jBtConfirmarOficialJustica, jBtConfirmarVisitasInterno, jBtRelatorio, jBtSair});

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        VisitasInternos.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jTabelaVisitasInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaVisitasInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Data Chegada", "Hora Chegada", "Código", "Nome da Visita", "Grau Parentesco"
            }
        ));
        jTabelaVisitasInternos.setToolTipText("Clique para Selecionar Visita e mostrar a foto da Visita e do Interno");
        jTabelaVisitasInternos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaVisitasInternosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaVisitasInternos);
        if (jTabelaVisitasInternos.getColumnModel().getColumnCount() > 0) {
            jTabelaVisitasInternos.getColumnModel().getColumn(0).setMinWidth(80);
            jTabelaVisitasInternos.getColumnModel().getColumn(0).setMaxWidth(80);
            jTabelaVisitasInternos.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaVisitasInternos.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaVisitasInternos.getColumnModel().getColumn(2).setMinWidth(70);
            jTabelaVisitasInternos.getColumnModel().getColumn(2).setMaxWidth(70);
            jTabelaVisitasInternos.getColumnModel().getColumn(3).setMinWidth(250);
            jTabelaVisitasInternos.getColumnModel().getColumn(3).setMaxWidth(250);
            jTabelaVisitasInternos.getColumnModel().getColumn(4).setMinWidth(150);
            jTabelaVisitasInternos.getColumnModel().getColumn(4).setMaxWidth(150);
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
            .addGap(0, 171, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout VisitasInternosLayout = new javax.swing.GroupLayout(VisitasInternos);
        VisitasInternos.setLayout(VisitasInternosLayout);
        VisitasInternosLayout.setHorizontalGroup(
            VisitasInternosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VisitasInternosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VisitasInternosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(VisitasInternosLayout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        VisitasInternosLayout.setVerticalGroup(
            VisitasInternosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VisitasInternosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(VisitasInternosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Visitas Interno", new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png")), VisitasInternos); // NOI18N

        Advogados.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jTabelaAdvogados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAdvogados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Data Chegada", "Hora Chegada", "Código", "Nome do Advogado"
            }
        ));
        jTabelaAdvogados.setToolTipText("Clique para Selecionar Advogado e mostrar a foto");
        jTabelaAdvogados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAdvogadosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaAdvogados);
        if (jTabelaAdvogados.getColumnModel().getColumnCount() > 0) {
            jTabelaAdvogados.getColumnModel().getColumn(0).setMinWidth(80);
            jTabelaAdvogados.getColumnModel().getColumn(0).setMaxWidth(80);
            jTabelaAdvogados.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaAdvogados.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaAdvogados.getColumnModel().getColumn(2).setMinWidth(70);
            jTabelaAdvogados.getColumnModel().getColumn(2).setMaxWidth(70);
            jTabelaAdvogados.getColumnModel().getColumn(3).setMinWidth(250);
            jTabelaAdvogados.getColumnModel().getColumn(3).setMaxWidth(250);
        }

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel64.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel64))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel64)
        );

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistros1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 171, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout AdvogadosLayout = new javax.swing.GroupLayout(Advogados);
        Advogados.setLayout(AdvogadosLayout);
        AdvogadosLayout.setHorizontalGroup(
            AdvogadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdvogadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdvogadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    .addGroup(AdvogadosLayout.createSequentialGroup()
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        AdvogadosLayout.setVerticalGroup(
            AdvogadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdvogadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AdvogadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Advogados", new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/tick.png")), Advogados); // NOI18N

        OficialJustica.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jTabelaOficialJustica.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaOficialJustica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Data Chegada", "Hora Chegada", "Código", "Nome do Oficial de Justiça"
            }
        ));
        jTabelaOficialJustica.setToolTipText("Clique para Selecionar Oficial Justiça e mostrar a foto");
        jTabelaOficialJustica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaOficialJusticaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTabelaOficialJustica);
        if (jTabelaOficialJustica.getColumnModel().getColumnCount() > 0) {
            jTabelaOficialJustica.getColumnModel().getColumn(0).setMinWidth(80);
            jTabelaOficialJustica.getColumnModel().getColumn(0).setMaxWidth(80);
            jTabelaOficialJustica.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaOficialJustica.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaOficialJustica.getColumnModel().getColumn(2).setMinWidth(70);
            jTabelaOficialJustica.getColumnModel().getColumn(2).setMaxWidth(70);
            jTabelaOficialJustica.getColumnModel().getColumn(3).setMinWidth(250);
            jTabelaOficialJustica.getColumnModel().getColumn(3).setMaxWidth(250);
        }

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel65.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel65))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel65)
        );

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalRegistros2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalRegistros2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 171, Short.MAX_VALUE)
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout OficialJusticaLayout = new javax.swing.GroupLayout(OficialJustica);
        OficialJustica.setLayout(OficialJusticaLayout);
        OficialJusticaLayout.setHorizontalGroup(
            OficialJusticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OficialJusticaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OficialJusticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    .addGroup(OficialJusticaLayout.createSequentialGroup()
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        OficialJusticaLayout.setVerticalGroup(
            OficialJusticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OficialJusticaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OficialJusticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Oficial Justiça", new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/40_16x16.png")), OficialJustica, ""); // NOI18N

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Foto Visita Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jFotoVisitasInterno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoVisitasInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoVisitasInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );

        jTabelaInternos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Registro", "Código", "Nome do Interno"
            }
        ));
        jTabelaInternos.setToolTipText("");
        jTabelaInternos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaInternosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaInternos);
        if (jTabelaInternos.getColumnModel().getColumnCount() > 0) {
            jTabelaInternos.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaInternos.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaInternos.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaInternos.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaInternos.getColumnModel().getColumn(2).setMinWidth(350);
            jTabelaInternos.getColumnModel().getColumn(2).setMaxWidth(350);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Foto Oficial Justiça", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        jFotoOficialJustica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoOficialJustica, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoOficialJustica, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Foto Advogado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jFotoAdvogado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoAdvogado, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoAdvogado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Foto Interno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(153, 0, 51))); // NOI18N

        jFotoInterno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFotoInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(99, 99, 99))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel3, jPanel4, jPanel5, jPanel6});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel3, jPanel4, jPanel5, jPanel6});

        setBounds(300, 30, 805, 534);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtPesquisaCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaCodigoActionPerformed
        // TODO add your handling code here:
        count = 0;
        if (jRBVisitas.isSelected()) {
            opcaoVisita = 1;
        } else if (!jRBVisitas.isSelected()) {
            opcaoVisita = 0;
        }
        if (jRBAdvogados.isSelected()) {
            opcaoAdvogado = 1;
        } else if (!jRBAdvogados.isSelected()) {
            opcaoAdvogado = 0;
        }
        if (jRBOficialJustica.isSelected()) {
            opcaoOficial = 1;
        } else if (!jRBOficialJustica.isSelected()) {
            opcaoOficial = 0;
        }
        if (jCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o código do visitante para pesquisa.");
        } else if (!jCodigo.getText().equals("") && opcaoVisita == 1) {
            buscarPavilhao(nomePavilhao1, nomePavilhao2, nomePavilhao3);
            popularTabelaNomeVisita("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdVisita=VISITASINTERNO.IdVisita "
                    + "INNER JOIN PAVILHAO "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav=PAVILHAO.IdPav "
                    + "WHERE Confirmacao='" + confirmacao + "' "
                    //                    + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav='" + codigoPavilhao + "' "
                    + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdVisita='" + jCodigo.getText() + "'");
        } else if (!jCodigo.getText().equals("") && opcaoAdvogado == 1) {
            buscarPavilhao(nomePavilhao1, nomePavilhao2, nomePavilhao3);
            popularTabelaAdvogado("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                    + "INNER JOIN ADVOGADOS "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdAdvogado=ADVOGADOS.IdAdvogado "
                    + "INNER JOIN PAVILHAO "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav=PAVILHAO.IdPav "
                    + "WHERE Confirmacao='" + confirmacao + "' "
                    //                    + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav='" + codigoPavilhao + "' "
                    + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdAdvogado='" + jCodigo.getText() + "'");
        } else if (!jCodigo.getText().equals("") && opcaoOficial == 1) {
            buscarPavilhao(nomePavilhao1, nomePavilhao2, nomePavilhao3);
            popularTabelaOficialJustica("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                    + "INNER JOIN OFICIAL_JUSTICA "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdOficial=OFICIAL_JUSTICA.IdOficial "
                    + "INNER JOIN PAVILHAO "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav=PAVILHAO.IdPav "
                    + "WHERE Confirmacao='" + confirmacao + "' "
                    //                    + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav='" + codigoPavilhao + "' "
                    + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdOficial='" + jCodigo.getText() + "'");
        } else {
            JOptionPane.showMessageDialog(rootPane, "É necessário selecionar o tipo de pesquisa.");
        }
    }//GEN-LAST:event_jBtPesquisaCodigoActionPerformed

    private void jBtDataPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDataPesquisaActionPerformed
        // TODO add your handling code here:
        count = 0;
        count1 = 0;
        count2 = 0;
        if (jRBVisitas.isSelected()) {
            opcaoVisita = 1;
        } else if (!jRBVisitas.isSelected()) {
            opcaoVisita = 0;
        }
        if (jRBAdvogados.isSelected()) {
            opcaoAdvogado = 1;
        } else if (!jRBAdvogados.isSelected()) {
            opcaoAdvogado = 0;
        }
        if (jRBOficialJustica.isSelected()) {
            opcaoOficial = 1;
        } else if (!jRBOficialJustica.isSelected()) {
            opcaoOficial = 0;
        }
        count = 0;
        if (jDataPesqChegada.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data para pesquisa.");
            jDataPesqChegada.requestFocus();
            jDataPesqChegada.setBackground(Color.red);
        } else {
            SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
            dataInicial = formatoAmerica.format(jDataPesqChegada.getDate().getTime());
            if (jDataPesqChegada.getDate() != null && opcaoVisita == 1) {
                buscarPavilhao(nomePavilhao1, nomePavilhao2, nomePavilhao3);
                popularTabelaNomeVisita("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                        + "INNER JOIN VISITASINTERNO "
                        + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdVisita=VISITASINTERNO.IdVisita "
                        + "INNER JOIN PAVILHAO "
                        + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav=PAVILHAO.IdPav "
                        + "WHERE Confirmacao='" + confirmacao + "' "
                        //                        + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav='" + codigoPavilhao + "' "
                        + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.DataChegada='" + dataInicial + "'");
            } else if (jDataPesqChegada.getDate() != null && opcaoAdvogado == 1) {
                buscarPavilhao(nomePavilhao1, nomePavilhao2, nomePavilhao3);
                popularTabelaAdvogado("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                        + "INNER JOIN ADVOGADOS "
                        + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdAdvogado=ADVOGADOS.IdAdvogado "
                        + "INNER JOIN PAVILHAO "
                        + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav=PAVILHAO.IdPav "
                        + "WHERE Confirmacao='" + confirmacao + "' "
                        //                        + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav='" + codigoPavilhao + "' "
                        + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.DataChegada='" + dataInicial + "'");
            } else if (jDataPesqChegada.getDate() != null && opcaoOficial == 1) {
                buscarPavilhao(nomePavilhao1, nomePavilhao2, nomePavilhao3);
                popularTabelaOficialJustica("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                        + "INNER JOIN OFICIAL_JUSTICA "
                        + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdOficial=OFICIAL_JUSTICA.IdOficial "
                        + "INNER JOIN PAVILHAO "
                        + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav=PAVILHAO.IdPav "
                        + "WHERE Confirmacao='" + confirmacao + "' "
                        //                        + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav='" + codigoPavilhao + "' "
                        + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.DataChegada='" + dataInicial + "'");
            } else {
                JOptionPane.showMessageDialog(rootPane, "É necessário selecionar o tipo de pesquisa.");
            }
        }
    }//GEN-LAST:event_jBtDataPesquisaActionPerformed

    private void jBtPesquisaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaNomeActionPerformed
        // TODO add your handling code here:
        count = 0;
        count1 = 0;
        count2 = 0;
        if (jRBVisitas.isSelected()) {
            opcaoVisita = 1;
        } else if (!jRBVisitas.isSelected()) {
            opcaoVisita = 0;
        }
        if (jRBAdvogados.isSelected()) {
            opcaoAdvogado = 1;
        } else if (!jRBAdvogados.isSelected()) {
            opcaoAdvogado = 0;
        }
        if (jRBOficialJustica.isSelected()) {
            opcaoOficial = 1;
        } else if (!jRBOficialJustica.isSelected()) {
            opcaoOficial = 0;
        }
        if (jNomeVisitante.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do visitante para pesquisa.");
        } else if (!jNomeVisitante.getText().equals("") && opcaoVisita == 1) {
            buscarPavilhao(nomePavilhao1, nomePavilhao2, nomePavilhao3);
            popularTabelaNomeVisita("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdVisita=VISITASINTERNO.IdVisita "
                    + "INNER JOIN PAVILHAO "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav=PAVILHAO.IdPav "
                    + "WHERE Confirmacao='" + confirmacao + "' "
                    //                    + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav='" + codigoPavilhao + "' "
                    + "AND NomeVisita LIKE'%" + jNomeVisitante.getText() + "%'");
        } else if (jNomeVisitante.getText().equals("") && opcaoAdvogado == 1) {
            buscarPavilhao(nomePavilhao1, nomePavilhao2, nomePavilhao3);
            popularTabelaAdvogado("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                    + "INNER JOIN ADVOGADOS "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdAdvogado=ADVOGADOS.IdAdvogado "
                    + "INNER JOIN PAVILHAO "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav=PAVILHAO.IdPav "
                    + "WHERE Confirmacao='" + confirmacao + "' "
                    //                    + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav='" + codigoPavilhao + "' "
                    + "AND NomeAdvogado LIKE'%" + jNomeVisitante.getText() + "%'");
        } else if (!jNomeVisitante.getText().equals("") && opcaoOficial == 1) {
            buscarPavilhao(nomePavilhao1, nomePavilhao2, nomePavilhao3);
            popularTabelaOficialJustica("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                    + "INNER JOIN OFICIAL_JUSTICA "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdOficial=OFICIAL_JUSTICA.IdOficial "
                    + "INNER JOIN PAVILHAO "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav=PAVILHAO.IdPav "
                    + "WHERE Confirmacao='" + confirmacao + "' "
                    //                    + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav='" + codigoPavilhao + "' "
                    + "AND NomeOficial LIKE'%" + jNomeVisitante.getText() + "%'");
        } else {
            JOptionPane.showMessageDialog(rootPane, "É necessário selecionar o tipo de pesquisa.");
        }
    }//GEN-LAST:event_jBtPesquisaNomeActionPerformed

    private void jBtAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAtualizarActionPerformed
        // TODO add your handling code here:
        count = 0;
        count1 = 0;
        count2 = 0;
        limparFotos();
        if (nomeModuloB2.equals("BASE PAVILHAO DOIS")) {
            buscarPavilhao(nomePavilhao1, nomePavilhao2, nomePavilhao3);
            popularTabelaNomeVisita("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdVisita=VISITASINTERNO.IdVisita "
                    + "INNER JOIN PAVILHAO "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav=PAVILHAO.IdPav "
                    + "WHERE Confirmacao='" + confirmacao + "' ");
//                    + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav='" + codigoPavilhao + "'");
            popularTabelaAdvogado("SELECT DataChegada,HoraChegada,ADVOGADOS.IdAdvogado,ADVOGADOS.NomeAdvogado FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                    + "INNER JOIN ADVOGADOS "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdAdvogado=ADVOGADOS.IdAdvogado "
                    + "INNER JOIN PAVILHAO "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav=PAVILHAO.IdPav "
                    + "WHERE Confirmacao='" + confirmacao + "' ");
//                    + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav='" + codigoPavilhao + "' GROUP BY DataChegada,HoraChegada,ADVOGADOS.IdAdvogado,ADVOGADOS.NomeAdvogado ");
            popularTabelaOficialJustica("SELECT DataChegada,HoraChegada, OFICIAL_JUSTICA.IdOficial, OFICIAL_JUSTICA.NomeOficial FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                    + "INNER JOIN OFICIAL_JUSTICA "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdOficial=OFICIAL_JUSTICA.IdOficial "
                    + "INNER JOIN PAVILHAO "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav=PAVILHAO.IdPav "
                    + "WHERE Confirmacao='" + confirmacao + "' ");
//                    + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav='" + codigoPavilhao + "'GROUP BY DataChegada,HoraChegada,OFICIAL_JUSTICA.IdOficial,OFICIAL_JUSTICA.NomeOficial");
        } else if (nomeModuloB2.equals("BASE PAVILHAO DOIS")) {

        }
    }//GEN-LAST:event_jBtAtualizarActionPerformed

    private void jBtConfirmarVisitasInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarVisitasInternoActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES") || codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaAlertaVisitantesPortariaB2) && codGravarB2 == 1) {
            objAlertaPortPav.setConfirmaReposta(confirmacao);
            objAlertaPortPav.setConfirmacao(respostaConf);
            objAlertaPortPav.setIdRegAlerta(codigoAlertaVI);
            controleOFPortPav.alterarConfirmaVisitaInternoPortariaPavilhoes(objAlertaPortPav);
            buscarPavilhao(nomePavilhao1, nomePavilhao2, nomePavilhao3);
            popularTabelaNomeVisita("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                    + "INNER JOIN VISITASINTERNO "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdVisita=VISITASINTERNO.IdVisita "
                    + "INNER JOIN PAVILHAO "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav=PAVILHAO.IdPav "
                    + "WHERE Confirmacao='" + confirmacao + "' "
                    + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav='" + codigoPavilhao + "'");
            popularTabelaInternosVisitas("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdVisita='" + idVisita + "' "
                    + "AND Confirmacao='" + confirmacao + "'");
            jBtConfirmarVisitasInterno.setEnabled(!true);
            limparFotos();
            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação do administrador.");
        }
    }//GEN-LAST:event_jBtConfirmarVisitasInternoActionPerformed

    private void jBtConfirmarAdvogadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarAdvogadoActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES") || codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaAlertaVisitantesPortariaB2) && codGravarB2 == 1) {
            objAlertaPortPav.setConfirmaReposta(confirmacao);
            objAlertaPortPav.setConfirmacao(respostaConf);
            objAlertaPortPav.setIdRegAlerta(codigoAlertaAD);
            controleOFPortPav.alterarConfirmaVisitaInternoPortariaPavilhoes(objAlertaPortPav);
            buscarPavilhao(nomePavilhao1, nomePavilhao2, nomePavilhao3);
            popularTabelaAdvogado("SELECT DataChegada,HoraChegada,ADVOGADOS.IdAdvogado,ADVOGADOS.NomeAdvogado FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                    + "INNER JOIN ADVOGADOS "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdAdvogado=ADVOGADOS.IdAdvogado "
                    + "INNER JOIN PAVILHAO "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav=PAVILHAO.IdPav "
                    + "WHERE Confirmacao='" + confirmacao + "' "
                    + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav='" + codigoPavilhao + "' GROUP BY DataChegada,HoraChegada,ADVOGADOS.IdAdvogado,ADVOGADOS.NomeAdvogado");
            popularTabelaInternosAdvogados("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdAdvogado='" + idAdvogado + "' "
                    + "AND Confirmacao='" + confirmacao + "'");
            jBtConfirmarAdvogado.setEnabled(!true);
            limparFotos();
            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação do administrador.");
        }
    }//GEN-LAST:event_jBtConfirmarAdvogadoActionPerformed

    private void jBtConfirmarOficialJusticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarOficialJusticaActionPerformed
        // TODO add your handling code here:
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES") || codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaAlertaVisitantesPortariaB2) && codGravarB2 == 1) {
            objAlertaPortPav.setConfirmaReposta(confirmacao);
            objAlertaPortPav.setConfirmacao(respostaConf);
            objAlertaPortPav.setIdRegAlerta(codigoAlertaOF);
            controleOFPortPav.alterarConfirmaVisitaInternoPortariaPavilhoes(objAlertaPortPav);
            buscarPavilhao(nomePavilhao1, nomePavilhao2, nomePavilhao3);
            popularTabelaOficialJustica("SELECT DataChegada,HoraChegada, OFICIAL_JUSTICA.IdOficial, OFICIAL_JUSTICA.NomeOficial FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                    + "INNER JOIN OFICIAL_JUSTICA "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdOficial=OFICIAL_JUSTICA.IdOficial "
                    + "INNER JOIN PAVILHAO "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav=PAVILHAO.IdPav "
                    + "WHERE Confirmacao='" + confirmacao + "' "
                    + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdPav='" + codigoPavilhao + "'GROUP BY DataChegada,HoraChegada,OFICIAL_JUSTICA.IdOficial,OFICIAL_JUSTICA.NomeOficial");
            popularTabelaInternosOficialJustica("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdOficial='" + idOficial + "' "
                    + "AND Confirmacao='" + confirmacao + "'");
            jBtConfirmarOficialJustica.setEnabled(!true);
            limparFotos();
            JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação do administrador.");
        }
    }//GEN-LAST:event_jBtConfirmarOficialJusticaActionPerformed

    private void jBtRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRelatorioActionPerformed
        // TODO add your handling code here:
        buscarPavilhao(nomePavilhao1, nomePavilhao2, nomePavilhao3);
        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") || nomeGrupoB2.equals("ADMINISTRADORES") || codigoUserB2 == codUserAcessoB2 && nomeTelaB2.equals(telaAlertaVisitantesPortariaB2) && codConsultarB2 == 1) {
            mostrarTelaRela();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, solicite liberação do administrador.");
        }
    }//GEN-LAST:event_jBtRelatorioActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void jTabelaVisitasInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaVisitasInternosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            idVisita = "" + jTabelaVisitasInternos.getValueAt(jTabelaVisitasInternos.getSelectedRow(), 2);
            //
            jBtConfirmarVisitasInterno.setEnabled(true);
            jBtConfirmarAdvogado.setEnabled(!true);
            jBtConfirmarOficialJustica.setEnabled(!true);
            limparFotos();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                        + "INNER JOIN VISITASINTERNO "
                        + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdVisita=VISITASINTERNO.IdVisita "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdVisita='" + idVisita + "' "
                        + "AND Confirmacao='" + confirmacao + "'");
                conecta.rs.first();
                codigoInternoVI = conecta.rs.getInt("IdInternoCrc");
                codigoRegistroVI = conecta.rs.getInt("IdRegistroVI");
                codigoAlertaVI = conecta.rs.getInt("IdRegAlerta");
                caminhoVisita = conecta.rs.getString("ImagemVisita");
                if (caminhoVisita != null) {
                    javax.swing.ImageIcon v = new javax.swing.ImageIcon(caminhoVisita);
                    jFotoVisitasInterno.setIcon(v);
                    jFotoVisitasInterno.setIcon(new ImageIcon(v.getImage().getScaledInstance(jFotoVisitasInterno.getWidth(), jFotoVisitasInterno.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] img1Bytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteVI"));
                if (img1Bytes != null) {
                    ImageIcon pic1 = null;
                    pic1 = new ImageIcon(img1Bytes);
                    Image scaled1 = pic1.getImage().getScaledInstance(jFotoVisitasInterno.getWidth(), jFotoVisitasInterno.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon1 = new ImageIcon(scaled1);
                    jFotoVisitasInterno.setIcon(icon1);
                }
                caminhoInterno = conecta.rs.getString("FotoInternoCrc");
                if (caminhoInterno != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoInterno);
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
            } catch (Exception e) {
            }
            conecta.desconecta();
            popularTabelaInternosVisitas("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdVisita='" + idVisita + "'");
        }
    }//GEN-LAST:event_jTabelaVisitasInternosMouseClicked

    private void jTabelaAdvogadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAdvogadosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            idAdvogado = "" + jTabelaAdvogados.getValueAt(jTabelaAdvogados.getSelectedRow(), 2);
            //
            jBtConfirmarVisitasInterno.setEnabled(!true);
            jBtConfirmarAdvogado.setEnabled(true);
            jBtConfirmarOficialJustica.setEnabled(!true);
            limparFotos();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                        + "INNER JOIN ADVOGADOS "
                        + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdAdvogado=ADVOGADOS.IdAdvogado "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdAdvogado='" + idAdvogado + "' "
                        + "AND Confirmacao='" + confirmacao + "'");
                conecta.rs.first();
                codigoInternoAD = conecta.rs.getInt("IdInternoCrc");
                codigoRegistroAD = conecta.rs.getInt("IdRegistroAD");
                codigoAlertaAD = conecta.rs.getInt("IdRegAlerta");
                caminhoAdvogado = conecta.rs.getString("FotoAdvogado");
                if (caminhoAdvogado != null) {
                    javax.swing.ImageIcon v = new javax.swing.ImageIcon(caminhoAdvogado);
                    jFotoAdvogado.setIcon(v);
                    jFotoAdvogado.setIcon(new ImageIcon(v.getImage().getScaledInstance(jFotoAdvogado.getWidth(), jFotoAdvogado.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] img2Bytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteAD"));
                if (img2Bytes != null) {
                    ImageIcon pic2 = null;
                    pic2 = new ImageIcon(img2Bytes);
                    Image scaled2 = pic2.getImage().getScaledInstance(jFotoAdvogado.getWidth(), jFotoAdvogado.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon2 = new ImageIcon(scaled2);
                    jFotoAdvogado.setIcon(icon2);
                }
                caminhoInterno = conecta.rs.getString("FotoInternoCrc");
                if (caminhoInterno != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoInterno);
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
            } catch (Exception e) {
            }
            conecta.desconecta();
            popularTabelaInternosAdvogados("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdAdvogado='" + idAdvogado + "' "
                    + "AND Confirmacao='" + confirmacao + "'");
        }
    }//GEN-LAST:event_jTabelaAdvogadosMouseClicked

    private void jTabelaOficialJusticaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaOficialJusticaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            idOficial = "" + jTabelaOficialJustica.getValueAt(jTabelaOficialJustica.getSelectedRow(), 2);
            //
            jBtConfirmarVisitasInterno.setEnabled(!true);
            jBtConfirmarAdvogado.setEnabled(!true);
            jBtConfirmarOficialJustica.setEnabled(true);
            limparFotos();
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                        + "INNER JOIN OFICIAL_JUSTICA "
                        + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdOficial=OFICIAL_JUSTICA.IdOficial "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdOficial='" + idOficial + "' "
                        + "AND Confirmacao='" + confirmacao + "'");
                conecta.rs.first();
                codigoInternoOF = conecta.rs.getInt("IdInternoCrc");
                codigoRegistroOF = conecta.rs.getInt("IdRegistroOF");
                codigoAlertaOF = conecta.rs.getInt("IdRegAlerta");
                caminhoOficial = conecta.rs.getString("FotoOficial");
                if (caminhoOficial != null) {
                    javax.swing.ImageIcon v = new javax.swing.ImageIcon(caminhoOficial);
                    jFotoOficialJustica.setIcon(v);
                    jFotoOficialJustica.setIcon(new ImageIcon(v.getImage().getScaledInstance(jFotoOficialJustica.getWidth(), jFotoOficialJustica.getHeight(), Image.SCALE_DEFAULT)));
                }
                // BUSCAR A FOTO DO ADVOGADO NO BANCO DE DADOS
                byte[] img4Bytes = ((byte[]) conecta.rs.getBytes("ImagemFrenteOF"));
                if (img4Bytes != null) {
                    ImageIcon pic4 = null;
                    pic4 = new ImageIcon(img4Bytes);
                    Image scaled4 = pic4.getImage().getScaledInstance(jFotoOficialJustica.getWidth(), jFotoOficialJustica.getHeight(), Image.SCALE_DEFAULT);
                    ImageIcon icon4 = new ImageIcon(scaled4);
                    jFotoOficialJustica.setIcon(icon4);
                }
                caminhoInterno = conecta.rs.getString("FotoInternoCrc");
                if (caminhoInterno != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoInterno);
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
            } catch (Exception e) {
            }
            conecta.desconecta();
            popularTabelaInternosOficialJustica("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdOficial='" + idOficial + "' "
                    + "AND Confirmacao='" + confirmacao + "'");
        }
    }//GEN-LAST:event_jTabelaOficialJusticaMouseClicked

    private void jTabelaInternosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaInternosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idInterno = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 1);
            String idRegistro = "" + jTabelaInternos.getValueAt(jTabelaInternos.getSelectedRow(), 0);
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA "
                        + "INNER JOIN PRONTUARIOSCRC "
                        + "ON ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                        + "WHERE ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdRegistroVI='" + idRegistro + "' "
                        + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdInternoCrc='" + idInterno + "' "
                        + "OR ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdRegistroAD='" + idRegistro + "' "
                        + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdInternoCrc='" + idInterno + "' "
                        + "OR ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdRegistroOF='" + idRegistro + "' "
                        + "AND ALERTA_BASE_CHEGADA_VISITAS_ADVOGADOS_OFICIAL_INTERNOS_PORTARIA.IdInternoCrc='" + idInterno + "'");
                conecta.rs.first();
                caminhoInterno = conecta.rs.getString("FotoInternoCrc");
                if (caminhoInterno != null) {
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminhoInterno);
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
            } catch (Exception e) {
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_jTabelaInternosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Advogados;
    private javax.swing.JPanel OficialJustica;
    private javax.swing.JPanel VisitasInternos;
    private javax.swing.ButtonGroup grupoBotesPVAO;
    private javax.swing.JButton jBtAtualizar;
    private javax.swing.JButton jBtConfirmarAdvogado;
    private javax.swing.JButton jBtConfirmarOficialJustica;
    private javax.swing.JButton jBtConfirmarVisitasInterno;
    private javax.swing.JButton jBtDataPesquisa;
    private javax.swing.JButton jBtPesquisaCodigo;
    private javax.swing.JButton jBtPesquisaNome;
    private javax.swing.JButton jBtRelatorio;
    private javax.swing.JButton jBtSair;
    private javax.swing.JTextField jCodigo;
    private com.toedter.calendar.JDateChooser jDataPesqChegada;
    private javax.swing.JLabel jFotoAdvogado;
    private javax.swing.JLabel jFotoInterno;
    private javax.swing.JLabel jFotoOficialJustica;
    private javax.swing.JLabel jFotoVisitasInterno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JTextField jNomeVisitante;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JRadioButton jRBAdvogados;
    private javax.swing.JRadioButton jRBOficialJustica;
    private javax.swing.JRadioButton jRBVisitas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaAdvogados;
    private javax.swing.JTable jTabelaInternos;
    private javax.swing.JTable jTabelaOficialJustica;
    private javax.swing.JTable jTabelaVisitasInternos;
    private javax.swing.JLabel jtotalRegistros;
    private javax.swing.JLabel jtotalRegistros1;
    private javax.swing.JLabel jtotalRegistros2;
    // End of variables declaration//GEN-END:variables

    public void limparFotos() {
        jFotoVisitasInterno.setIcon(null);
        jFotoAdvogado.setIcon(null);
        jFotoOficialJustica.setIcon(null);
        jFotoInterno.setIcon(null);
    }

    public void buscarPavilhao(String descricao, String descricao2, String descricao3) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO "
                    + "WHERE DescricaoPav LIKE'%" + descricao + "%' "
                    + "OR DescricaoPav LIKE'%" + descricao2 + "%' "
                    + "OR DescricaoPav LIKE'%" + descricao3 + "%'");
            conecta.rs.first();
            codigoPavilhao = conecta.rs.getInt("IdPav");
            descricaoPavilhao = conecta.rs.getString("DescricaoPav");
        } catch (SQLException ex) {
            Logger.getLogger(TelaAlertaBasesPavilhoesBaseDois.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
    }

    public void popularTabelaNomeVisita(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Data Chegada", "Hora Chegada", "Código", "Nome da Visita", "Grau Parentesco", "Pavilhão"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data Entrada
                dataEntrada = conecta.rs.getString("DataChegada");
                String diae = dataEntrada.substring(8, 10);
                String mese = dataEntrada.substring(5, 7);
                String anoe = dataEntrada.substring(0, 4);
                dataEntrada = diae + "/" + mese + "/" + anoe;
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{dataEntrada, conecta.rs.getString("HoraChegada"), conecta.rs.getInt("IdVisita"), conecta.rs.getString("NomeVisita"), conecta.rs.getString("ParentescoVisita"), conecta.rs.getString("DescricaoPav")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisitasInternos.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA  
        jTabelaVisitasInternos.setModel(modelo);
        jTabelaVisitasInternos.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaVisitasInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaVisitasInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTabelaVisitasInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaVisitasInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTabelaVisitasInternos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(5).setPreferredWidth(250);
        jTabelaVisitasInternos.getColumnModel().getColumn(5).setResizable(false);
        jTabelaVisitasInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaVisitasInternos.setAutoResizeMode(jTabelaVisitasInternos.AUTO_RESIZE_OFF);
        jTabelaVisitasInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaTodas();
        conecta.desconecta();
    }

    public void popularTabelaAdvogado(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Data Chegada", "Hora Chegada", "Código", "Nome do Advogado", "Pavilhão"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count1 = count1 + 1;
                // Formatar a data Entrada
                dataEntradaAD = conecta.rs.getString("DataChegada");
                String diae = dataEntradaAD.substring(8, 10);
                String mese = dataEntradaAD.substring(5, 7);
                String anoe = dataEntradaAD.substring(0, 4);
                dataEntradaAD = diae + "/" + mese + "/" + anoe;
                jtotalRegistros1.setText(Integer.toString(count1)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{dataEntradaAD, conecta.rs.getString("HoraChegada"), conecta.rs.getInt("IdAdvogado"), conecta.rs.getString("NomeAdvogado"), conecta.rs.getString("DescricaoPav")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAdvogados.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA  
        jTabelaAdvogados.setModel(modelo);
        jTabelaAdvogados.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaAdvogados.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAdvogados.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaAdvogados.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAdvogados.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaAdvogados.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAdvogados.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaAdvogados.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAdvogados.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTabelaAdvogados.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAdvogados.getTableHeader().setReorderingAllowed(false);
        jTabelaAdvogados.setAutoResizeMode(jTabelaAdvogados.AUTO_RESIZE_OFF);
        jTabelaVisitasInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaAD();
        conecta.desconecta();
    }

    public void popularTabelaOficialJustica(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Data Chegada", "Hora Chegada", "Código", "Nome do Oficial Justiça", "Pavilhão"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count2 = count2 + 1;
                // Formatar a data Entrada
                dataEntradaOF = conecta.rs.getString("DataChegada");
                String diae = dataEntradaOF.substring(8, 10);
                String mese = dataEntradaOF.substring(5, 7);
                String anoe = dataEntradaOF.substring(0, 4);
                dataEntradaOF = diae + "/" + mese + "/" + anoe;
                jtotalRegistros2.setText(Integer.toString(count2)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{dataEntradaOF, conecta.rs.getString("HoraChegada"), conecta.rs.getInt("IdOficial"), conecta.rs.getString("NomeOficial"), conecta.rs.getString("DescricaoPav")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaOficialJustica.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA  
        jTabelaOficialJustica.setModel(modelo);
        jTabelaOficialJustica.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaOficialJustica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaOficialJustica.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaOficialJustica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaOficialJustica.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaOficialJustica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaOficialJustica.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaOficialJustica.getColumnModel().getColumn(3).setResizable(false);
        jTabelaOficialJustica.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTabelaOficialJustica.getColumnModel().getColumn(4).setResizable(false);
        jTabelaOficialJustica.getTableHeader().setReorderingAllowed(false);
        jTabelaOficialJustica.setAutoResizeMode(jTabelaOficialJustica.AUTO_RESIZE_OFF);
        jTabelaOficialJustica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaOJ();
        conecta.desconecta();
    }

    public void popularTabelaInternosVisitas(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Registro", "Código", "Nome do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdRegistroVI"), conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA  
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaInterno();
        conecta.desconecta();
    }

    public void popularTabelaInternosAdvogados(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Registro", "Código", "Nome do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdRegistroAD"), conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA  
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaInterno();
        conecta.desconecta();
    }

    public void popularTabelaInternosOficialJustica(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Registro", "Código", "Nome do Interno"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdRegistroOF"), conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("NomeInternoCrc")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA  
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharTabelaInterno();
        conecta.desconecta();
    }

    public void limparTabelaEntradaVisitas() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Data Chegada", "Hora Chegada", "Código", "Nome da Visita", "Grau Parentesco", "Pavilhão"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaVisitasInternos.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA 
        jTabelaVisitasInternos.setModel(modelo);
        jTabelaVisitasInternos.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaVisitasInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaVisitasInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTabelaVisitasInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaVisitasInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTabelaVisitasInternos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaVisitasInternos.getColumnModel().getColumn(5).setPreferredWidth(250);
        jTabelaVisitasInternos.getColumnModel().getColumn(5).setResizable(false);
        jTabelaVisitasInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaVisitasInternos.setAutoResizeMode(jTabelaVisitasInternos.AUTO_RESIZE_OFF);
        jTabelaVisitasInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void limparTabelaAdvogado() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Data Chegada", "Hora Chegada", "Código", "Nome do Advogado", "Pavilhão"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAdvogados.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA  
        jTabelaAdvogados.setModel(modelo);
        jTabelaAdvogados.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaAdvogados.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAdvogados.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaAdvogados.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAdvogados.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaAdvogados.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAdvogados.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaAdvogados.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAdvogados.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTabelaAdvogados.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAdvogados.getTableHeader().setReorderingAllowed(false);
        jTabelaAdvogados.setAutoResizeMode(jTabelaAdvogados.AUTO_RESIZE_OFF);
        jTabelaVisitasInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void limparTabelaOficial() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Data Chegada", "Hora Chegada", "Código", "Nome do Oficial Justiça", "Pavilhão"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaOficialJustica.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA  
        jTabelaOficialJustica.setModel(modelo);
        jTabelaOficialJustica.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTabelaOficialJustica.getColumnModel().getColumn(0).setResizable(false);
        jTabelaOficialJustica.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaOficialJustica.getColumnModel().getColumn(1).setResizable(false);
        jTabelaOficialJustica.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaOficialJustica.getColumnModel().getColumn(2).setResizable(false);
        jTabelaOficialJustica.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaOficialJustica.getColumnModel().getColumn(3).setResizable(false);
        jTabelaOficialJustica.getTableHeader().setReorderingAllowed(false);
        jTabelaOficialJustica.setAutoResizeMode(jTabelaOficialJustica.AUTO_RESIZE_OFF);
        jTabelaOficialJustica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void limparTabelaInterno() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Registro", "Código", "Nome do Interno"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA  
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(350);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharTabelaTodas() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaVisitasInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaVisitasInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaVisitasInternos.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void alinharTabelaAD() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaAdvogados.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAdvogados.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaAdvogados.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void alinharTabelaOJ() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaOficialJustica.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaOficialJustica.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaOficialJustica.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }

    public void alinharTabelaInterno() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }
}
