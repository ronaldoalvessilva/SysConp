/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleListaInternosPavilhaoAG_SS_DAO;
import gestor.Controle.ControleLogSistema;
import gestor.Dao.ConexaoBancoDados;
import gestor.Controle.ControleAtendimentoGrupoPsicologiaDAO;
import gestor.Controle.ControleListaInternosCelasAG_SS_DAO;
import gestor.Controle.ControleListaInternosGaleiraAG_SS_DAO;
import gestor.Controle.ControleListaInternosPavilhaoAG_II_SS_DAO;
import Utilitarios.ModeloTabela;
import gestor.Modelo.AtividadesGrupoPsicologia;
import gestor.Modelo.LogSistema;
import gestor.Modelo.PavilhaoInternoMontaKit;
import gestor.Modelo.PavilhaoInternosMontagemKit;
import static gestor.Visao.TelaAtendimentoGrupoSS.jBtAlterarParticipantes;
import static gestor.Visao.TelaAtendimentoGrupoSS.jBtAuditoriaParticipantes;
import static gestor.Visao.TelaAtendimentoGrupoSS.jBtCancelarParticipantes;
import static gestor.Visao.TelaAtendimentoGrupoSS.jBtExcluirParticipantes;
import static gestor.Visao.TelaAtendimentoGrupoSS.jBtNovoParticipantes;
import static gestor.Visao.TelaAtendimentoGrupoSS.jBtSalvarParticipantes;
import static gestor.Visao.TelaAtendimentoGrupoSS.jBtPesquisarPart;
import static gestor.Visao.TelaAtendimentoGrupoSS.jCNC;
import static gestor.Visao.TelaAtendimentoGrupoSS.jCela;
import static gestor.Visao.TelaAtendimentoGrupoSS.jCodigoAtend;
import static gestor.Visao.TelaAtendimentoGrupoSS.jComboBoxNivelPavilhao;
import static gestor.Visao.TelaAtendimentoGrupoSS.jComboBoxPavilhaoGaleria;
import static gestor.Visao.TelaAtendimentoGrupoSS.jDataNascimento;
import static gestor.Visao.TelaAtendimentoGrupoSS.jIdInternoGrp;
import static gestor.Visao.TelaAtendimentoGrupoSS.jNomeInternoGrp;
import static gestor.Visao.TelaAtendimentoGrupoSS.jNomeMae;
import static gestor.Visao.TelaAtendimentoGrupoSS.jPavilhao;
import static gestor.Visao.TelaAtendimentoGrupoSS.jRegime;
import static gestor.Visao.TelaAtendimentoGrupoSS.jTabelaInternos;
import static gestor.Visao.TelaAtendimentoGrupoSS.jtotalRegistrosInternos;
import static gestor.Visao.TelaAtendimentoGrupoSS.pCODIGO_ITEM_PARTICIPANTE;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.Color;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Socializa TI 02
 */
public class TelaSelecaoLoteInternosAGSS extends javax.swing.JDialog {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AtividadesGrupoPsicologia objAvalia = new AtividadesGrupoPsicologia();
    ControleAtendimentoGrupoPsicologiaDAO control = new ControleAtendimentoGrupoPsicologiaDAO();
    ControleListaInternosCelasAG_SS_DAO listaPorCelas = new ControleListaInternosCelasAG_SS_DAO();
    ControleListaInternosGaleiraAG_SS_DAO listaPorGaleira = new ControleListaInternosGaleiraAG_SS_DAO();
    ControleListaInternosPavilhaoAG_SS_DAO listaPorPavilhao = new ControleListaInternosPavilhaoAG_SS_DAO();
    ControleListaInternosPavilhaoAG_II_SS_DAO listaPorPavilhao_B = new ControleListaInternosPavilhaoAG_II_SS_DAO();
    PavilhaoInternosMontagemKit objPavInt = new PavilhaoInternosMontagemKit();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    //
    String nomeModuloTela3 = "Serviço Social:Atendimento em Grupo:Participantes";
    //
    public static int qtdInternos = 0;
    public static int codigoPavilhao = 0;
    String idInterno = "";
    public static int qtdInternosDestino = 0;
    public static int qtdInternosOrigem = 0;
    int count1 = 0; // PARA TABELA DE INTERNOS SELECIONADOS
    int count2 = 0;
    int count3 = 0;
    int qtdTotal = 0;
    //
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    int pTOTAL_REGISTROS = 0;
    int pTOTAL_REGISTROS_PRO = 0;

    /**
     * Creates new form TelaSelecaoLoteInternosAG
     */
    public static TelaAtendimentoGrupoSS pATENDIMENTO_GRUPO;

    public TelaSelecaoLoteInternosAGSS(TelaAtendimentoGrupoSS parent, boolean modal) {
        this.pATENDIMENTO_GRUPO = parent;
        this.setModal(modal);
        setLocationRelativeTo(pATENDIMENTO_GRUPO);
        initComponents();
        corCampos();
        preencherGaleria();
        preencherCelas();
        bloquearHabilitarCamposTela(true);
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
        jComboBoxCelas = new javax.swing.JComboBox<>();
        jBtConfirmarSelecao = new javax.swing.JButton();
        jComboBoxPGC = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxGaleria = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jBtAdicionarSelecao = new javax.swing.JButton();
        jBtAdicionarTodos = new javax.swing.JButton();
        jBtRetornarUm = new javax.swing.JButton();
        jBtRetornarTodos = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaInternosOrigem = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalInternosOrigem = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaInternosDestino = new javax.swing.JTable();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jtotalInternosDestino = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jBtConfirmarOperacao = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        jTOTAL_REG_GRAVADO = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTOTAL_REG_COPIADO = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Seleção de Internos - AG :::..");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Pavilhão/Galeira/Cela");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cela");

        jComboBoxCelas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", " " }));
        jComboBoxCelas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtConfirmarSelecao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/overlays.png"))); // NOI18N
        jBtConfirmarSelecao.setContentAreaFilled(false);
        jBtConfirmarSelecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarSelecaoActionPerformed(evt);
            }
        });

        jComboBoxPGC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPGC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Pavilhão", "Galeria", "Cela" }));
        jComboBoxPGC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Galeria");

        jComboBoxGaleria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxGaleria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        jComboBoxGaleria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxPGC, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBoxGaleria, 0, 167, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBoxCelas, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtConfirmarSelecao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtConfirmarSelecao)
                    .addComponent(jComboBoxCelas, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxGaleria, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPGC, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "BTN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jBtAdicionarSelecao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/250718131515_16.png"))); // NOI18N
        jBtAdicionarSelecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdicionarSelecaoActionPerformed(evt);
            }
        });

        jBtAdicionarTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/250718131115_16.png"))); // NOI18N
        jBtAdicionarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdicionarTodosActionPerformed(evt);
            }
        });

        jBtRetornarUm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/250718131526_16.png"))); // NOI18N
        jBtRetornarUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtRetornarUmActionPerformed(evt);
            }
        });

        jBtRetornarTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/250718131210_16.png"))); // NOI18N
        jBtRetornarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtRetornarTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtRetornarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtRetornarUm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAdicionarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtAdicionarSelecao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAdicionarSelecao, jBtAdicionarTodos, jBtRetornarTodos, jBtRetornarUm});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jBtAdicionarSelecao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAdicionarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtRetornarUm, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtRetornarTodos)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAdicionarSelecao, jBtAdicionarTodos, jBtRetornarTodos, jBtRetornarUm});

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Origem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 0))); // NOI18N

        jTabelaInternosOrigem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternosOrigem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "CNC", "Nome do Interno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTabelaInternosOrigem);
        if (jTabelaInternosOrigem.getColumnModel().getColumnCount() > 0) {
            jTabelaInternosOrigem.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaInternosOrigem.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaInternosOrigem.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaInternosOrigem.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaInternosOrigem.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaInternosOrigem.getColumnModel().getColumn(2).setMaxWidth(300);
        }

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel67.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67)
        );

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalInternosOrigem.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalInternosOrigem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalInternosOrigem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 82, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Destino", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jTabelaInternosDestino.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaInternosDestino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "CNC", "Nome do Interno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTabelaInternosDestino);
        if (jTabelaInternosDestino.getColumnModel().getColumnCount() > 0) {
            jTabelaInternosDestino.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaInternosDestino.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaInternosDestino.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaInternosDestino.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaInternosDestino.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaInternosDestino.getColumnModel().getColumn(2).setMaxWidth(300);
        }

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 82, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
        );

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel68.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel68)
        );

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jtotalInternosDestino.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalInternosDestino, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtotalInternosDestino, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jBtConfirmarOperacao.setForeground(new java.awt.Color(0, 102, 0));
        jBtConfirmarOperacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/061218140238_16.png"))); // NOI18N
        jBtConfirmarOperacao.setText("Confirmar");
        jBtConfirmarOperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarOperacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtConfirmarOperacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtConfirmarOperacao)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));

        jProgressBar1.setStringPainted(true);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Registros Gravados:");

        jTOTAL_REG_GRAVADO.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTOTAL_REG_GRAVADO.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTOTAL_REG_GRAVADO.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTOTAL_REG_GRAVADO.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTOTAL_REG_GRAVADO.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("Registros Verificados:");

        jTOTAL_REG_COPIADO.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTOTAL_REG_COPIADO.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTOTAL_REG_COPIADO.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTOTAL_REG_COPIADO.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTOTAL_REG_COPIADO.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTOTAL_REG_COPIADO, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTOTAL_REG_GRAVADO, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jTOTAL_REG_COPIADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTOTAL_REG_GRAVADO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel2, jPanel3, jPanel4});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConfirmarSelecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarSelecaoActionPerformed
        // TODO add your handling code here:
        if (jComboBoxPGC.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "É necessario informar a uma opção <Pavilhao/Galeria/Cela>.");
        } else if (jComboBoxPGC.getSelectedItem().equals("Pavilhão")) {
            //LIMPAR A TABELA
            while (jTabelaInternosOrigem.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaInternosOrigem.getModel()).removeRow(0);
            }
            jtotalInternosOrigem.setText(Integer.toString(qtdInternos));
            qtdInternos = 0;
            //PAVILHÃO I/A
            if (jComboBoxNivelPavilhao.getSelectedItem().equals("A")) {
                DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternosOrigem.getModel();
                PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
                try {
                    for (PavilhaoInternoMontaKit dd : listaPorPavilhao.read()) {
                        codigoPavilhao = dd.getIdPav();
                        jtotalInternosOrigem.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                        dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaInternosOrigem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaInternosOrigem.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        jTabelaInternosOrigem.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaMontagemPagamentoKitInterno.class.getName()).log(Level.SEVERE, null, ex);
                }
                //PAVILHÃO II/B 
            } else if (jComboBoxNivelPavilhao.getSelectedItem().equals("B")) {
                DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternosOrigem.getModel();
                PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
                try {
                    for (PavilhaoInternoMontaKit dd : listaPorPavilhao_B.read()) {
                        codigoPavilhao = dd.getIdPav();
                        jtotalInternosOrigem.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                        dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaInternosOrigem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaInternosOrigem.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        jTabelaInternosOrigem.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaMontagemPagamentoKitInterno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //GALERIA
        } else if (jComboBoxPGC.getSelectedItem().equals("Galeria")) {
            //LIMPAR A TABELA
            while (jTabelaInternosOrigem.getModel().getRowCount() > 0) {
                ((DefaultTableModel) jTabelaInternosOrigem.getModel()).removeRow(0);
            }
            jtotalInternosOrigem.setText(Integer.toString(qtdInternos));
            qtdInternos = 0;
            DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternosOrigem.getModel();
            PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
            try {
                for (PavilhaoInternoMontaKit dd : listaPorGaleira.read()) {
                    codigoPavilhao = dd.getIdPav();
                    jtotalInternosOrigem.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                    dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                    // BARRA DE ROLAGEM HORIZONTAL
                    jTabelaInternosOrigem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    // ALINHAR TEXTO DA TABELA CENTRALIZADO
                    DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                    centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                    //
                    jTabelaInternosOrigem.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                    jTabelaInternosOrigem.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                }
            } catch (Exception ex) {
                Logger.getLogger(TelaMontagemPagamentoKitInterno.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (jComboBoxPGC.getSelectedItem().equals("Cela")) {
            if (jComboBoxCelas.getSelectedItem() == null || jComboBoxCelas.getSelectedItem().equals("Selecione...")) {
                JOptionPane.showMessageDialog(rootPane, "É necessario informar a cela para incluir os internos.");
            } else {
                //LIMPAR A TABELA
                while (jTabelaInternosOrigem.getModel().getRowCount() > 0) {
                    ((DefaultTableModel) jTabelaInternosOrigem.getModel()).removeRow(0);
                }
                jtotalInternosOrigem.setText(Integer.toString(qtdInternos));
                qtdInternos = 0;
                DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternosOrigem.getModel();
                PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
                try {
                    for (PavilhaoInternoMontaKit dd : listaPorCelas.read()) {
                        codigoPavilhao = dd.getIdPav();
                        jtotalInternosOrigem.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                        dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                        // BARRA DE ROLAGEM HORIZONTAL
                        jTabelaInternosOrigem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                        // ALINHAR TEXTO DA TABELA CENTRALIZADO
                        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                        //
                        jTabelaInternosOrigem.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                        jTabelaInternosOrigem.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(TelaMontagemPagamentoKitInterno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jBtConfirmarSelecaoActionPerformed

    private void jBtConfirmarOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarOperacaoActionPerformed
        // TODO add your handling code here:
        int resposta = JOptionPane.showConfirmDialog(this, "Confirmar a gravação dos dados selecionados?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            //BLOQUEAR CAMPOS E BOTÕES
            bloquearHabilitarCamposTela(!true);
            //BLOQUEAR A TELA NO X PARA NÃO FECHAR ANTES DE CONCLUIR A OPERAÇÃO
            setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE); //Impedir que a janela seja fechada pelo X 
            gravarDadosBanco();
        }
    }//GEN-LAST:event_jBtConfirmarOperacaoActionPerformed

    private void jBtAdicionarSelecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdicionarSelecaoActionPerformed
        // TODO add your handling code here:
        Integer row = jTabelaInternosDestino.getRowCount();
        boolean encontrou = !true;
        if (jTabelaInternosOrigem.getSelectedRowCount() != 0 && row == 0) {
            DefaultTableModel modelOrigem = (DefaultTableModel) jTabelaInternosOrigem.getModel();
            DefaultTableModel modelDestino = (DefaultTableModel) jTabelaInternosDestino.getModel();
            //Cria uma linha para ser incluida na tabela de destino, no meu caso tem duas colunas, adapte para as suas tabelas
            Object[] obj = {jTabelaInternosOrigem.getValueAt(jTabelaInternosOrigem.getSelectedRow(), 0), jTabelaInternosOrigem.getValueAt(jTabelaInternosOrigem.getSelectedRow(), 1), jTabelaInternosOrigem.getValueAt(jTabelaInternosOrigem.getSelectedRow(), 2)};
            // BARRA DE ROLAGEM HORIZONTAL
            jtotalInternosDestino.setText(Integer.toString(qtdInternosDestino)); // Converter inteiro em string para exibir na tela 
            jTabelaInternosDestino.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            // ALINHAR TEXTO DA TABELA CENTRALIZADO
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            //
            jTabelaInternosDestino.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            //Adiciona no destino e remove da origem
            modelDestino.addRow(obj);
            modelOrigem.removeRow(jTabelaInternosOrigem.getSelectedRow());
            qtdInternosDestino = qtdInternosDestino + 1;
            qtdInternos = qtdInternos - 1;
            jtotalInternosDestino.setText(Integer.toString(qtdInternosDestino)); // Converter inteiro em string para exibir na tela 
            jtotalInternosOrigem.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
        } else if (jTabelaInternosOrigem.getSelectedRowCount() != 0 && row != 0) {
            DefaultTableModel modelOrigem = (DefaultTableModel) jTabelaInternosOrigem.getModel();
            DefaultTableModel modelDestino = (DefaultTableModel) jTabelaInternosDestino.getModel();
            // VERIFICAR SE O PRODUTO JÁ EXISTE NA TABELA, SE EXITIR AVISA.
            for (int i = 0; i < jTabelaInternosDestino.getRowCount(); i++) {
                String codInter = "" + jTabelaInternosDestino.getValueAt(i, 0).toString();
                if (idInterno.equals(codInter)) {
                    encontrou = true;
                    break;
                } else {
                    encontrou = !true;
                }
            }
            if (encontrou == true) {
                JOptionPane.showMessageDialog(rootPane, "Interno já foi selecionado, escolha outro.");
            } else if (encontrou == !true) {
                qtdInternosDestino = qtdInternosDestino + 1;
                qtdInternos = qtdInternos - 1;
                //Adiciona no destino e remove da origem
                Object[] obj = {jTabelaInternosOrigem.getValueAt(jTabelaInternosOrigem.getSelectedRow(), 0), jTabelaInternosOrigem.getValueAt(jTabelaInternosOrigem.getSelectedRow(), 1), jTabelaInternosOrigem.getValueAt(jTabelaInternosOrigem.getSelectedRow(), 2)};
                modelDestino.addRow(obj);
                modelOrigem.removeRow(jTabelaInternosOrigem.getSelectedRow());
            }
            jtotalInternosDestino.setText(Integer.toString(qtdInternosDestino)); // Converter inteiro em string para exibir na tela 
            jtotalInternosOrigem.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
            // BARRA DE ROLAGEM HORIZONTAL
            jTabelaInternosDestino.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            // ALINHAR TEXTO DA TABELA CENTRALIZADO
            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            //
            jTabelaInternosDestino.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um registro.");
        }
    }//GEN-LAST:event_jBtAdicionarSelecaoActionPerformed

    private void jBtAdicionarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdicionarTodosActionPerformed
        // TODO add your handling code here:
        Integer rows = jTabelaInternosDestino.getRowCount();
        Integer row = jTabelaInternosOrigem.getRowCount();
        if (row == 0) {
            JOptionPane.showMessageDialog(rootPane, "É necessário pesquisar os internos primeiro.");
        } else {
            if (rows == 0) {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente confirmar essa operação?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    // APAGAR DADOS DA TABELA
                    while (jTabelaInternosOrigem.getModel().getRowCount() > 0) {
                        ((DefaultTableModel) jTabelaInternosOrigem.getModel()).removeRow(0);
                    }
                    if (jComboBoxPGC.getSelectedItem().equals("Cela")) {
                        preencherTabelaInternosPorCela();
                    } else if (jComboBoxPGC.getSelectedItem().equals("Galeria")) {
                        preencherTabelaInternosPorGaleria();
                    } else if (jComboBoxPGC.getSelectedItem().equals("Pavilhão")) {
                        if (jComboBoxNivelPavilhao.getSelectedItem().equals("A")) {
                            preencherTabelaInternosPorPavilhao();
                        } else if (jComboBoxNivelPavilhao.getSelectedItem().equals("B")) {
                            preencherTabelaInternosPorPavilhao_II();
                        }
                    }
                    qtdInternosDestino = qtdInternos;
                    qtdInternos = 0;
                    jtotalInternosDestino.setText(Integer.toString(qtdInternosDestino)); // Converter inteiro em string para exibir na tela 
                    jtotalInternosOrigem.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Já foram transferido todos os internos.");
            }
        }
    }//GEN-LAST:event_jBtAdicionarTodosActionPerformed

    private void jBtRetornarUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRetornarUmActionPerformed
        // TODO add your handling code here:
        Integer rows = jTabelaInternosDestino.getModel().getRowCount();
        Integer row0 = jTabelaInternosOrigem.getModel().getRowCount();
        if (rows != 0) {
            if (jTabelaInternosDestino.getSelectedRowCount() != 0) { //Verifica se existe linha selecionada para não dar erro na hora de pegar os valores               
                if (row0 == 0) {
                    qtdInternos++;
                    count2 = count2 - 1;
                    jtotalInternosDestino.setText(Integer.toString(count2)); // Converter inteiro em string para exibir na tela 
                    jtotalInternosOrigem.setText(Integer.toString(qtdInternos));
                } else if (row0 != 0) {
                    qtdInternos++;
                    qtdInternosDestino = qtdInternosDestino - 1;
                    jtotalInternosDestino.setText(Integer.toString(qtdInternosDestino)); // Converter inteiro em string para exibir na tela 
                    jtotalInternosOrigem.setText(Integer.toString(qtdInternos));
                }
                //Pega os models das listas, para fazer as inserções e remoções
                DefaultTableModel modelOrigem = (DefaultTableModel) jTabelaInternosDestino.getModel();
                DefaultTableModel modelDestino = (DefaultTableModel) jTabelaInternosOrigem.getModel();
                //Cria uma linha para ser incluida na tabela de destino, no meu caso tem duas colunas, adapte para as suas tabelas
                Object[] obj = {jTabelaInternosDestino.getValueAt(jTabelaInternosDestino.getSelectedRow(), 0), jTabelaInternosDestino.getValueAt(jTabelaInternosDestino.getSelectedRow(), 1), jTabelaInternosDestino.getValueAt(jTabelaInternosDestino.getSelectedRow(), 2)};
                // BARRA DE ROLAGEM HORIZONTAL
                jTabelaInternosOrigem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaInternosOrigem.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                jTabelaInternosOrigem.getColumnModel().getColumn(1).setCellRenderer(centralizado);
                //Adiciona no destino e remove da origem
                modelDestino.addRow(obj);
                modelOrigem.removeRow(jTabelaInternosDestino.getSelectedRow());
            } else {
                JOptionPane.showMessageDialog(rootPane, "Selecione pelo menos uma linha para transferir todos registros da tabela.");
                //Não tem nenhuma linha selecionada na tabela de origem, faça um aviso para o usuário ou algo do tipo.            
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Não existe dados a ser excluído.");
        }
    }//GEN-LAST:event_jBtRetornarUmActionPerformed

    private void jBtRetornarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtRetornarTodosActionPerformed
        // TODO add your handling code here:
        Integer rows = jTabelaInternosOrigem.getRowCount();
        Integer row = jTabelaInternosDestino.getRowCount();
        if (row == 0) {
            JOptionPane.showMessageDialog(rootPane, "É necessário pesquisar os internos primeiro.");
        } else {
            if (rows == 0) {
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente confirmar essa operação?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    // APAGAR DADOS DA TABELA
                    while (jTabelaInternosDestino.getModel().getRowCount() > 0) {
                        ((DefaultTableModel) jTabelaInternosDestino.getModel()).removeRow(0);
                    }
                    if (jComboBoxPGC.getSelectedItem().equals("Cela")) {
                        preencherTabelaInternosRetornoPorCela();
                    } else if (jComboBoxPGC.getSelectedItem().equals("Galeria")) {
                        preencherTabelaInternosRetornoPorGaleria();
                    } else if (jComboBoxPGC.getSelectedItem().equals("Pavilhão")) {
                        if (jComboBoxNivelPavilhao.getSelectedItem().equals("A")) {
                            preencherTabelaInternosRetornoPorPavilhao();
                        } else if (jComboBoxNivelPavilhao.getSelectedItem().equals("B")) {
                            preencherTabelaInternosRetornoPorPavilhao_II();
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Já foram transferido todos os internos.");
            }
        }
    }//GEN-LAST:event_jBtRetornarTodosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaSelecaoLoteInternosAGSS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaSelecaoLoteInternosAGSS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaSelecaoLoteInternosAGSS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaSelecaoLoteInternosAGSS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaSelecaoLoteInternosAGSS dialog = new TelaSelecaoLoteInternosAGSS(pATENDIMENTO_GRUPO, true);
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
    private javax.swing.JButton jBtAdicionarSelecao;
    private javax.swing.JButton jBtAdicionarTodos;
    private javax.swing.JButton jBtConfirmarOperacao;
    private javax.swing.JButton jBtConfirmarSelecao;
    private javax.swing.JButton jBtRetornarTodos;
    private javax.swing.JButton jBtRetornarUm;
    public static javax.swing.JComboBox<String> jComboBoxCelas;
    public static javax.swing.JComboBox<String> jComboBoxGaleria;
    public static javax.swing.JComboBox<String> jComboBoxPGC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTOTAL_REG_COPIADO;
    private javax.swing.JTextField jTOTAL_REG_GRAVADO;
    public static javax.swing.JTable jTabelaInternosDestino;
    public static javax.swing.JTable jTabelaInternosOrigem;
    public static javax.swing.JLabel jtotalInternosDestino;
    public static javax.swing.JLabel jtotalInternosOrigem;
    // End of variables declaration//GEN-END:variables

    public void bloquearHabilitarCamposTela(boolean opcao) {
        jComboBoxPGC.setEnabled(opcao);
        jComboBoxGaleria.setEnabled(opcao);
        jComboBoxCelas.setEnabled(opcao);
        jBtConfirmarSelecao.setEnabled(opcao);
        jBtConfirmarOperacao.setEnabled(opcao);
        //
        jBtAdicionarSelecao.setEnabled(opcao);
        jBtAdicionarTodos.setEnabled(opcao);
        jBtRetornarUm.setEnabled(opcao);
        jBtRetornarTodos.setEnabled(opcao);
    }

    public void preencherCelas() {
        jComboBoxCelas.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CELAS "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav "
                    + "WHERE PAVILHAO.DescricaoPav='" + jComboBoxPavilhaoGaleria.getSelectedItem() + "'");
            conecta.rs.first();
            do {
                jComboBoxCelas.addItem(conecta.rs.getString("EndCelaPav"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void preencherGaleria() {
        jComboBoxGaleria.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PAVILHAO "
                    + "WHERE PAVILHAO.NivelPav='" + jComboBoxNivelPavilhao.getSelectedItem() + "'");
            conecta.rs.first();
            do {
                jComboBoxGaleria.addItem(conecta.rs.getString("DescricaoPav"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    // PREENCHER A TABELA DE INTERNOS POR CELA
    public void preencherTabelaInternosPorCela() {
        qtdInternos = 0;
        qtdInternosOrigem = 0;
        PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
        try {
            for (PavilhaoInternoMontaKit dd : listaPorCelas.read()) {
                DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternosDestino.getModel();
                jtotalInternosOrigem.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                jtotalInternosDestino.setText(Integer.toString(qtdInternosOrigem)); // Converter inteiro em string para exibir na tela 
                dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL, dd.getNomeInternoCrc()
                jTabelaInternosDestino.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaInternosDestino.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaSelecaoInternosKitCompleto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // PREENCHER TABELA DE INTERNOS POR CELA
    public void preencherTabelaInternosRetornoPorCela() {
        qtdInternos = 0;
        qtdInternosOrigem = 0;
        PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
        try {
            for (PavilhaoInternoMontaKit dd : listaPorCelas.read()) {
                DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternosOrigem.getModel();
                jtotalInternosOrigem.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                jtotalInternosDestino.setText(Integer.toString(qtdInternosOrigem)); // Converter inteiro em string para exibir na tela 
                dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL, dd.getNomeInternoCrc()
                jTabelaInternosOrigem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaInternosOrigem.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaSelecaoInternosKitCompleto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //PREENCHER TABELA DE INTERNOS POR GALERIA
    public void preencherTabelaInternosPorGaleria() {
        qtdInternos = 0;
        qtdInternosOrigem = 0;
        PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
        try {
            for (PavilhaoInternoMontaKit dd : listaPorGaleira.read()) {
                DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternosDestino.getModel();
                jtotalInternosOrigem.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                jtotalInternosDestino.setText(Integer.toString(qtdInternosOrigem)); // Converter inteiro em string para exibir na tela 
                dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL, dd.getNomeInternoCrc()
                jTabelaInternosDestino.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaInternosDestino.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaSelecaoInternosKitCompleto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // PREENCHER TABELA DE INTERNOS POR GALERIA
    public void preencherTabelaInternosRetornoPorGaleria() {
        qtdInternos = 0;
        qtdInternosOrigem = 0;
        PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
        try {
            for (PavilhaoInternoMontaKit dd : listaPorGaleira.read()) {
                DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternosOrigem.getModel();
                jtotalInternosOrigem.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                jtotalInternosDestino.setText(Integer.toString(qtdInternosOrigem)); // Converter inteiro em string para exibir na tela 
                dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL, dd.getNomeInternoCrc()
                jTabelaInternosOrigem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaInternosOrigem.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaSelecaoInternosKitCompleto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //PREENCHER TABELA DE INTERNOS POR PAVILHÃO I
    public void preencherTabelaInternosPorPavilhao() {
        qtdInternos = 0;
        qtdInternosOrigem = 0;
        PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
        try {
            for (PavilhaoInternoMontaKit dd : listaPorPavilhao.read()) {
                DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternosDestino.getModel();
                jtotalInternosOrigem.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                jtotalInternosDestino.setText(Integer.toString(qtdInternosOrigem)); // Converter inteiro em string para exibir na tela 
                dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL, dd.getNomeInternoCrc()
                jTabelaInternosDestino.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaInternosDestino.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaSelecaoInternosKitCompleto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // PREENCHER TABELA DE INTERNOS POR PAVILHÃO I
    public void preencherTabelaInternosRetornoPorPavilhao() {
        qtdInternos = 0;
        qtdInternosOrigem = 0;
        PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
        try {
            for (PavilhaoInternoMontaKit dd : listaPorPavilhao.read()) {
                DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternosOrigem.getModel();
                jtotalInternosOrigem.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                jtotalInternosDestino.setText(Integer.toString(qtdInternosOrigem)); // Converter inteiro em string para exibir na tela 
                dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL, dd.getNomeInternoCrc()
                jTabelaInternosOrigem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaInternosOrigem.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaSelecaoInternosKitCompleto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //PREENCHER TABELA DE INTERNOS POR PAVILHÃO II
    public void preencherTabelaInternosPorPavilhao_II() {
        qtdInternos = 0;
        qtdInternosOrigem = 0;
        PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
        try {
            for (PavilhaoInternoMontaKit dd : listaPorPavilhao_B.read()) {
                DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternosDestino.getModel();
                jtotalInternosOrigem.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                jtotalInternosDestino.setText(Integer.toString(qtdInternosOrigem)); // Converter inteiro em string para exibir na tela 
                dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL, dd.getNomeInternoCrc()
                jTabelaInternosDestino.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaInternosDestino.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaSelecaoInternosKitCompleto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // PREENCHER TABELA DE INTERNOS POR PAVILHÃO II
    public void preencherTabelaInternosRetornoPorPavilhao_II() {
        qtdInternos = 0;
        qtdInternosOrigem = 0;
        PavilhaoInternoMontaKit d = new PavilhaoInternoMontaKit();
        try {
            for (PavilhaoInternoMontaKit dd : listaPorPavilhao_B.read()) {
                DefaultTableModel dadosOrigem = (DefaultTableModel) jTabelaInternosOrigem.getModel();
                jtotalInternosOrigem.setText(Integer.toString(qtdInternos)); // Converter inteiro em string para exibir na tela 
                jtotalInternosDestino.setText(Integer.toString(qtdInternosOrigem)); // Converter inteiro em string para exibir na tela 
                dadosOrigem.addRow(new Object[]{dd.getIdInternoCrc(), dd.getCncInternoCrc(), dd.getNomeInternoCrc()});
                // BARRA DE ROLAGEM HORIZONTAL, dd.getNomeInternoCrc()
                jTabelaInternosOrigem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                //
                jTabelaInternosOrigem.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaSelecaoInternosKitCompleto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
///-------------------------------------------

    public void corCampos() {
        jTOTAL_REG_COPIADO.setBackground(Color.white);
        jTOTAL_REG_GRAVADO.setBackground(Color.white);
    }

    public void bloquearTodosBotoes() {
        // ABA PARTICIPANTES
        jBtNovoParticipantes.setEnabled(!true);
        jBtAlterarParticipantes.setEnabled(!true);
        jBtExcluirParticipantes.setEnabled(!true);
        jBtSalvarParticipantes.setEnabled(!true);
        jBtCancelarParticipantes.setEnabled(!true);
        jBtAuditoriaParticipantes.setEnabled(!true);
        jBtPesquisarPart.setEnabled(!true);
    }
//

    public void bloquearTodosCampos() {
        // ABA PARTICIPANTES
        jIdInternoGrp.setEnabled(!true);
        jCNC.setEnabled(!true);
        jRegime.setEnabled(!true);
        jDataNascimento.setEnabled(!true);
        jNomeInternoGrp.setEnabled(!true);
        jNomeMae.setEnabled(!true);
        jPavilhao.setEnabled(!true);
        jCela.setEnabled(!true);
    }

    public void buscarCodigoParticipantes() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARTICIPANTES_ATENDIMENTO_GRUPO_SS");
            conecta.rs.last();
            pCODIGO_ITEM_PARTICIPANTE = conecta.rs.getInt("IdItemPartSS");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter código do registro.");
        }
        conecta.desconecta();
    }

    public void gravarDadosBanco() {

        try {
            Thread t0 = new Thread() {
                public void run() {
                    statusMov = "Incluiu";
                    horaMov = jHoraSistema.getText();
                    dataModFinal = jDataSistema.getText();
                    for (int i = 0; i < jTabelaInternosDestino.getRowCount(); i++) {//  
                        objAvalia.setIdAtGrupoPsi(Integer.valueOf(jCodigoAtend.getText()));
                        objAvalia.setIdInternoCrc((int) jTabelaInternosDestino.getValueAt(i, 0));
                        // log de usuario
                        objAvalia.setUsuarioInsert(nameUser);
                        objAvalia.setDataInsert(dataModFinal);
                        objAvalia.setHorarioInsert(horaMov);
                        //
                        control.incluirAGrupoPP(objAvalia);
                        buscarCodigoParticipantes();
                        objLog3();
                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                        preencherTabelaParticipantes("SELECT * FROM PARTICIPANTES_ATENDIMENTO_GRUPO_SS "
                                + "INNER JOIN ATENDIMENTO_GRUPO_SS "
                                + "ON PARTICIPANTES_ATENDIMENTO_GRUPO_SS.IdAtGrupoSS=ATENDIMENTO_GRUPO_SS.IdAtGrupoSS "
                                + "INNER JOIN PRONTUARIOSCRC "
                                + "ON PARTICIPANTES_ATENDIMENTO_GRUPO_SS.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                                + "INNER JOIN DADOSPENAISINTERNOS "
                                + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                                + "WHERE PARTICIPANTES_ATENDIMENTO_GRUPO_SS.IdAtGrupoSS='" + jCodigoAtend.getText() + "'");
                        pTOTAL_REGISTROS_PRO = i + 1;
                        jTOTAL_REG_GRAVADO.setText(String.valueOf(pTOTAL_REGISTROS_PRO));
                        jProgressBar1.setValue(i);
                        if (pTOTAL_REGISTROS_PRO == pTOTAL_REGISTROS) {
                            jProgressBar1.setValue(100);
                            JOptionPane.showMessageDialog(rootPane, "Operação Concluída com sucesso...");
                            bloquearTodosBotoes();
                            bloquearTodosCampos();
                            dispose();
                        }
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                    }
                }
            };
            t0.start();
        } catch (Exception e) {
        }
        // THREAD DA BARRA DE EXECUÇÃO
        try {
            Thread t = new Thread() {
                public void run() {
                    jProgressBar1.setMaximum(jTabelaInternosDestino.getRowCount());
                    Rectangle rect;
                    for (int i = 0; i < jTabelaInternosDestino.getRowCount(); i++) {
                        rect = jTabelaInternosDestino.getCellRect(i, 0, true);
                        try {
                            jTabelaInternosDestino.scrollRectToVisible(rect);
                        } catch (java.lang.ClassCastException e) {
                        }
                        if (i == 0) {
                            jTabelaInternosDestino.setRowSelectionInterval(i, 0);
                            jProgressBar1.setValue((i + 1));
                        } else if (i > 0) {
                            jTabelaInternosDestino.setRowSelectionInterval(i, 1);
                            jProgressBar1.setValue((i + 1));
                            pTOTAL_REGISTROS = i + 1;
                            jTOTAL_REG_COPIADO.setText(String.valueOf(pTOTAL_REGISTROS));
                            jProgressBar1.setValue(i);
                        }
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {
                        }
                    }
                    try {
                    } catch (Exception e) {
                    }
                }
            };
            t.start();
        } catch (Exception e) {
        }
    }

    //ABA PARTICIPANTES
    public void preencherTabelaParticipantes(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "CNC", "Nome do Interno", "Regime"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            count1 = 0;
            do {
                count1 = count1 + 1;
                jtotalRegistrosInternos.setText(Integer.toString(count1)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdItemPartSS"), conecta.rs.getInt("IdInternoCrc"), conecta.rs.getString("Cnc"), conecta.rs.getString("NomeInternoCrc"), conecta.rs.getString("Regime")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(3).setPreferredWidth(350);
        jTabelaInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTabelaInternos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaParticipantes();
        conecta.desconecta();
    }

    public void alinharCamposTabelaParticipantes() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaInternos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaInternos.getColumnModel().getColumn(2).setCellRenderer(direita);
    }

    public void limparTabelaParticipantes() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "CNC", "Nome do Interno", "Regime"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaInternos.setModel(modelo);
        jTabelaInternos.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaInternos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaInternos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(3).setPreferredWidth(350);
        jTabelaInternos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaInternos.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTabelaInternos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaInternos.getTableHeader().setReorderingAllowed(false);
        jTabelaInternos.setAutoResizeMode(jTabelaInternos.AUTO_RESIZE_OFF);
        jTabelaInternos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void objLog3() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela3);
        objLogSys.setIdLancMov(pCODIGO_ITEM_PARTICIPANTE);
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }
}
