/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleGrupoUsuarios;
import gestor.Controle.ControleLogSistema;
import gestor.Controle.ControleModulosUsuariosGrupos;
import gestor.Controle.ControleTelaAcesso;
import gestor.Controle.ControleUsuarios;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ConexaoBancoDadosBAR;
import gestor.Dao.ConexaoBancoDadosITB;
import gestor.Dao.ConexaoBancoDadosLF;
import gestor.Dao.ConexaoBancoDadosSSA;
import gestor.Dao.ConexaoBancoDadosVC;
import Utilitarios.LimiteDigitos;
import Utilitarios.LimiteDigitosMin;
import Utilitarios.ModeloTabela;
import gestor.Controle.SenhaCriptografadaDao;
import gestor.Modelo.LogSistema;
import gestor.Modelo.TelaAcessos;
import gestor.Modelo.Usuarios;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Ronaldo
 */
public class TelaUsuarios extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    Usuarios objUser = new Usuarios();
    ControleUsuarios control = new ControleUsuarios();
    SenhaCriptografadaDao CRIPTOGRAFAR_senhas = new SenhaCriptografadaDao();
    ControleGrupoUsuarios controle = new ControleGrupoUsuarios();
    ControleModulosUsuariosGrupos controleMod = new ControleModulosUsuariosGrupos();
    //
    TelaAcessos objTelaAcesso = new TelaAcessos();
    ControleTelaAcesso controlaAcess = new ControleTelaAcesso();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    //CONEXÕES PARA GRAVAR DADOS GLOBAIS DO USUÁRIO
    ConexaoBancoDadosLF conectaLF = new ConexaoBancoDadosLF();
    ConexaoBancoDadosSSA conectaSSA = new ConexaoBancoDadosSSA();
    ConexaoBancoDadosITB conectaITB = new ConexaoBancoDadosITB();
    ConexaoBancoDadosVC conectaVC = new ConexaoBancoDadosVC();
    ConexaoBancoDadosBAR conectaBAR = new ConexaoBancoDadosBAR();
    // Variáveis para gravar o log
    String nomeModuloTela = "Configurações:Usuários do Sistema:Manutenção";
    String nomeModuloTela1 = "Configurações:Usuários do Sistema:Grupo Usuários";
    String nomeModuloTela2 = "Configurações:Usuários do Sistema:Módulos do Sistema";
    String nomeModuloTela3 = "Configurações:Usuários do Sistema:Telas do Sistema";
    String statusMov;
    String horaMov;
    String dataModFinal;

    int acao;
    int flag = 1;
    int codUser;
    int codGrupo;
    int count = 0;
    int codUserGroup, codModelGroup;
    String codigoUserGrupo, codigoGrupoModulo, codigoUsuarioGrupo, codigoUsuarioGrupoNovo;
    String codigoUserDel;
    int statusUser;
    String statusNome;
    //
    int pAbrir = 0;
    int pIncluir = 0;
    int pAlterar = 0;
    int pExcluir = 0;
    int pGravar = 0;
    int pConsultar = 0;
    String pAbrirAcesso = "";
    String pIncluirAcesso = "";
    String pAlterarAcesso = "";
    String pExcluirAcesso = "";
    String pGravarAcesso = "";
    String pConsultarAcesso = "";
    int codigoModulo = 0;
    int codigoTelaAcesso = 0;
    //
    public static TelaPesquisaModulos pesquisaModulos;
    public static TelaCopiaPerfilUsuario pesquisarPerfilUsuario;
    public static TelaAvisoMensagem pMENSAGEM;
    public static TelaAvisoMensagemGrupo pMENSAGEM_GRUPO;
    //
    String nomeTelaUsuario = "";
    String codigoUsuario = "";
    String nomeUsuario = "";
    String pLogin = "";
    //VARIAVEIS DE ACESSO AO CADASTRO DO USUARIO NAS OUTRAS UNIDADES
    String pLOGIN_USUARIO_LF = null;
    String pCODIGO_USUARIO_LF = null;
    //
    String pLOGIN_USUARIO_SSA = null;
    String pCODIGO_USUARIO_SSA = null;
    //
    String pLOGIN_USUARIO_ITB = null;
    String pCODIGO_USUARIO_ITB = null;
    //
    String pCODIGO_USUARIO_BAR = null;
    String pLOGIN_USUARIO_BAR = null;
    //
    String pCODIGO_USUARIO_VC = null;
    String pLOGIN_USUARIO_VC = null;

    /**
     * Creates new form TelaUsuarios
     */
    public TelaUsuarios() {
        initComponents();
        formatarCampos();
        corCampos();
        // Modificar a tecla tab por enter
        HashSet conj = new HashSet(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
    }

    public void mostrarTela() {
        pesquisaModulos = new TelaPesquisaModulos(this, true);
        pesquisaModulos.setVisible(true);
    }

    public void mostrarUsuario() {
        pesquisarPerfilUsuario = new TelaCopiaPerfilUsuario(this, true);
        pesquisarPerfilUsuario.setVisible(true);
    }

    public void mostrarMensagem() {
        pMENSAGEM = new TelaAvisoMensagem(this, true);
        pMENSAGEM.setVisible(true);
    }

    public void mostrarMensagemGrupo() {
        pMENSAGEM_GRUPO = new TelaAvisoMensagemGrupo(this, true);
        pMENSAGEM_GRUPO.setVisible(true);
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
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        JBtPesquisaNome = new javax.swing.JButton();
        jPesqNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel36 = new javax.swing.JLabel();
        jNomeGrupoUser = new javax.swing.JTextField();
        jBtPesquisaGrupo = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jDepartamento = new javax.swing.JTextField();
        jBtDepartamento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaUsuarios = new javax.swing.JTable();
        jPanel31 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jtotalRegistros = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxStatus = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        IdUsuario = new javax.swing.JTextField();
        jNomeUsuarioCompleto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jDataCadastro = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxDepartamento = new javax.swing.JComboBox();
        jComboBoxCargo = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jComboBoxAcessaTodasUnidades = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jBtNovo = new javax.swing.JButton();
        jBtAlterar = new javax.swing.JButton();
        jBtExcluir = new javax.swing.JButton();
        jBtSalvar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSenhaConf = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jSenha = new javax.swing.JPasswordField();
        jlogin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCodigoGrupo = new javax.swing.JTextField();
        jBtPesDepto = new javax.swing.JButton();
        jDescricaoGrupo = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jBtNovoGrupo = new javax.swing.JButton();
        jBtAlterarGrupo = new javax.swing.JButton();
        jBtExcluirGrupo = new javax.swing.JButton();
        jBtSalvarGrupo = new javax.swing.JButton();
        jBtCancelarGrupo = new javax.swing.JButton();
        jBtSairGrupo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabelaGrupo = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jCodigoModulo = new javax.swing.JTextField();
        jDescricaoModulo = new javax.swing.JTextField();
        jComboBoxPermissaoModulo = new javax.swing.JComboBox();
        jBtPesqModulo = new javax.swing.JButton();
        jComboBoxGrupoModulo = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jBtNovoModulo = new javax.swing.JButton();
        jBtAlterarModulo = new javax.swing.JButton();
        jBtExcluirModulo = new javax.swing.JButton();
        jBtSalvarModulo = new javax.swing.JButton();
        jBtCancelarModulo = new javax.swing.JButton();
        jBtSairModulo = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaModulos = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jNomeUsuarioAcesso = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jComboBoxTelaAcesso = new javax.swing.JComboBox();
        jBtPesquisarModulo = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jIdModulo = new javax.swing.JTextField();
        jComboBoxModuloAcesso = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaAcessos = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jBtAlterarAcesso = new javax.swing.JButton();
        jBtSalvarAcesso = new javax.swing.JButton();
        jBtCancelarAcesso = new javax.swing.JButton();
        jBtNovoAcesso = new javax.swing.JButton();
        jBtSairAcesso = new javax.swing.JButton();
        jBtExcluirAcesso = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jComboBoxGravar = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jComboBoxAbrir = new javax.swing.JComboBox();
        jComboBoxConsultar = new javax.swing.JComboBox();
        jComboBoxAlterar = new javax.swing.JComboBox();
        jComboBoxExcluir = new javax.swing.JComboBox();
        jComboBoxIncluir = new javax.swing.JComboBox();
        jBtCopiarPerfil = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Cadastro de Usuários :::...");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.blue)); // NOI18N

        JBtPesquisaNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        JBtPesquisaNome.setToolTipText("Pesquisa por Nome");
        JBtPesquisaNome.setContentAreaFilled(false);
        JBtPesquisaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtPesquisaNomeActionPerformed(evt);
            }
        });

        jPesqNome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Nome:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setText("Todos");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Grupo:");

        jNomeGrupoUser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtPesquisaGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisaGrupo.setContentAreaFilled(false);
        jBtPesquisaGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisaGrupoActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Setor:");

        jDepartamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jBtDepartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtDepartamento.setContentAreaFilled(false);
        jBtDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDepartamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPesqNome, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(jNomeGrupoUser)
                    .addComponent(jDepartamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JBtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisaGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jBtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPesqNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBtPesquisaNome)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel36)
                    .addComponent(jNomeGrupoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesquisaGrupo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCheckBox1)
                    .addComponent(jBtDepartamento)
                    .addComponent(jDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jTabelaUsuarios.setAutoCreateRowSorter(true);
        jTabelaUsuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Status", "Nome Completo do Usuário", "Login", "Nome do Grupo"
            }
        ));
        jTabelaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaUsuarios);
        if (jTabelaUsuarios.getColumnModel().getColumnCount() > 0) {
            jTabelaUsuarios.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaUsuarios.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaUsuarios.getColumnModel().getColumn(1).setMinWidth(50);
            jTabelaUsuarios.getColumnModel().getColumn(1).setMaxWidth(50);
            jTabelaUsuarios.getColumnModel().getColumn(2).setMinWidth(250);
            jTabelaUsuarios.getColumnModel().getColumn(2).setMaxWidth(250);
            jTabelaUsuarios.getColumnModel().getColumn(3).setMinWidth(100);
            jTabelaUsuarios.getColumnModel().getColumn(3).setMaxWidth(100);
            jTabelaUsuarios.getColumnModel().getColumn(4).setMinWidth(250);
            jTabelaUsuarios.getColumnModel().getColumn(4).setMaxWidth(250);
        }

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

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));

        jLabel67.setText("Total de Registros:");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel67))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel67)
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Listagem", jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Dados Cadastrais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), java.awt.Color.blue)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Status");

        jComboBoxStatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo" }));
        jComboBoxStatus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxStatus.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nome Completo");

        IdUsuario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        IdUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        IdUsuario.setEnabled(false);

        jNomeUsuarioCompleto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeUsuarioCompleto.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Data Cadastro");

        jDataCadastro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataCadastro.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Departamento");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Cargo");

        jComboBoxDepartamento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxDepartamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        jComboBoxDepartamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxDepartamento.setEnabled(false);
        jComboBoxDepartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxDepartamentoMouseEntered(evt);
            }
        });

        jComboBoxCargo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        jComboBoxCargo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCargo.setEnabled(false);
        jComboBoxCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxCargoMouseEntered(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 0, 0));
        jLabel16.setText("*");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("*");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(204, 0, 0));
        jLabel38.setText("Acessa todas Unidades");

        jComboBoxAcessaTodasUnidades.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAcessaTodasUnidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Sim", "Não" }));
        jComboBoxAcessaTodasUnidades.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAcessaTodasUnidades.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBoxCargo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(IdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel20))))
                            .addComponent(jNomeUsuarioCompleto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxDepartamento, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jComboBoxAcessaTodasUnidades, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(15, 15, 15))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeUsuarioCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel14)
                .addGap(3, 3, 3)
                .addComponent(jComboBoxDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel15)
                .addGap(3, 3, 3)
                .addComponent(jComboBoxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel38)
                .addGap(3, 3, 3)
                .addComponent(jComboBoxAcessaTodasUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.blue)); // NOI18N

        jBtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovo.setText("Novo");
        jBtNovo.setToolTipText("Novo Registro");
        jBtNovo.setContentAreaFilled(false);
        jBtNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoActionPerformed(evt);
            }
        });

        jBtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterar.setText("Alterar");
        jBtAlterar.setToolTipText("Alterar Registro");
        jBtAlterar.setContentAreaFilled(false);
        jBtAlterar.setEnabled(false);
        jBtAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarActionPerformed(evt);
            }
        });

        jBtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluir.setText("Excluir");
        jBtExcluir.setToolTipText("Exclur registro");
        jBtExcluir.setContentAreaFilled(false);
        jBtExcluir.setEnabled(false);
        jBtExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirActionPerformed(evt);
            }
        });

        jBtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvar.setText("Gravar");
        jBtSalvar.setToolTipText("Salvar Registro");
        jBtSalvar.setContentAreaFilled(false);
        jBtSalvar.setEnabled(false);
        jBtSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarActionPerformed(evt);
            }
        });

        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelar.setText("Cancelar");
        jBtCancelar.setToolTipText("Cancelar Operação");
        jBtCancelar.setContentAreaFilled(false);
        jBtCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.setToolTipText("Sair da Tela");
        jBtSair.setContentAreaFilled(false);
        jBtSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSair.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jBtNovo)
                .addGap(1, 1, 1)
                .addComponent(jBtAlterar)
                .addGap(1, 1, 1)
                .addComponent(jBtExcluir)
                .addGap(1, 1, 1)
                .addComponent(jBtSalvar)
                .addGap(1, 1, 1)
                .addComponent(jBtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtSair)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jBtSair)
                        .addComponent(jBtCancelar))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jBtAlterar)
                        .addComponent(jBtExcluir)
                        .addComponent(jBtSalvar)
                        .addComponent(jBtNovo)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterar, jBtCancelar, jBtExcluir, jBtNovo, jBtSair, jBtSalvar});

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de Acesso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 204, 0));
        jLabel6.setText("Confirmar a Senha");

        jSenhaConf.setToolTipText("Tamanho máximo de caracteres 21");
        jSenhaConf.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSenhaConf.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Senha:");

        jSenha.setToolTipText("Tamanho máximo de caracteres 21");
        jSenha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSenha.setEnabled(false);

        jlogin.setToolTipText("Tamnaho máximo 25 caracter");
        jlogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jlogin.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Login");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 0, 0));
        jLabel17.setText("*");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 0, 0));
        jLabel18.setText("*");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 0, 0));
        jLabel19.setText("*");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlogin)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel18))
                                    .addComponent(jSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel19))
                                    .addComponent(jSenhaConf, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel11Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jSenha, jSenhaConf});

        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSenhaConf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 0, 0));
        jLabel21.setText("(*) Campos Obrigatório");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Manutenção", jPanel3);

        jTabbedPane2.setForeground(new java.awt.Color(255, 0, 0));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Grupos de Usuários", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Nome do Grupo");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Código");

        jCodigoGrupo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoGrupo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoGrupo.setEnabled(false);

        jBtPesDepto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesDepto.setToolTipText("Pesquisar Departamento");
        jBtPesDepto.setContentAreaFilled(false);
        jBtPesDepto.setEnabled(false);
        jBtPesDepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesDeptoActionPerformed(evt);
            }
        });

        jDescricaoGrupo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoGrupo.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jCodigoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jDescricaoGrupo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtPesDepto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jBtPesDepto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCodigoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDescricaoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovoGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoGrupo.setEnabled(false);
        jBtNovoGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoGrupoActionPerformed(evt);
            }
        });

        jBtAlterarGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
        jBtAlterarGrupo.setEnabled(false);
        jBtAlterarGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarGrupoActionPerformed(evt);
            }
        });

        jBtExcluirGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirGrupo.setEnabled(false);
        jBtExcluirGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirGrupoActionPerformed(evt);
            }
        });

        jBtSalvarGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/save-document-icone-9010-16.png"))); // NOI18N
        jBtSalvarGrupo.setEnabled(false);
        jBtSalvarGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarGrupoActionPerformed(evt);
            }
        });

        jBtCancelarGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarGrupo.setEnabled(false);
        jBtCancelarGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarGrupoActionPerformed(evt);
            }
        });

        jBtSairGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairGrupoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarGrupo, jBtCancelarGrupo, jBtExcluirGrupo, jBtNovoGrupo, jBtSairGrupo, jBtSalvarGrupo});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtExcluirGrupo)
                .addComponent(jBtAlterarGrupo)
                .addComponent(jBtNovoGrupo)
                .addComponent(jBtSalvarGrupo)
                .addComponent(jBtCancelarGrupo)
                .addComponent(jBtSairGrupo))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAlterarGrupo, jBtCancelarGrupo, jBtExcluirGrupo, jBtNovoGrupo, jBtSairGrupo, jBtSalvarGrupo});

        jTabelaGrupo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaGrupo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "Nome do Grupo"
            }
        ));
        jTabelaGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaGrupoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabelaGrupo);
        if (jTabelaGrupo.getColumnModel().getColumnCount() > 0) {
            jTabelaGrupo.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaGrupo.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaGrupo.getColumnModel().getColumn(1).setMinWidth(80);
            jTabelaGrupo.getColumnModel().getColumn(1).setMaxWidth(80);
            jTabelaGrupo.getColumnModel().getColumn(2).setMinWidth(300);
            jTabelaGrupo.getColumnModel().getColumn(2).setMaxWidth(300);
        }

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Grupo de Usuários", jPanel15);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2))
        );

        jTabbedPane1.addTab("Grupos Usuários", jPanel7);

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Código");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("Permissão");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Descrição do Módulo");

        jCodigoModulo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCodigoModulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCodigoModulo.setEnabled(false);

        jDescricaoModulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDescricaoModulo.setEnabled(false);

        jComboBoxPermissaoModulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPermissaoModulo.setForeground(new java.awt.Color(153, 0, 153));
        jComboBoxPermissaoModulo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxPermissaoModulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPermissaoModulo.setEnabled(false);

        jBtPesqModulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtPesqModulo.setForeground(new java.awt.Color(0, 153, 0));
        jBtPesqModulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesqModulo.setToolTipText("Pesquisar Módulos");
        jBtPesqModulo.setContentAreaFilled(false);
        jBtPesqModulo.setEnabled(false);
        jBtPesqModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesqModuloActionPerformed(evt);
            }
        });

        jComboBoxGrupoModulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxGrupoModulo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        jComboBoxGrupoModulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxGrupoModulo.setEnabled(false);
        jComboBoxGrupoModulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxGrupoModuloMouseEntered(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 0, 0));
        jLabel24.setText("*");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Grupo do Usuário");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 0, 0));
        jLabel26.setText("*");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jCodigoModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel12)
                                    .addComponent(jComboBoxPermissaoModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jComboBoxGrupoModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtPesqModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel25)))
                            .addComponent(jDescricaoModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel26)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel25))
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxGrupoModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPermissaoModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCodigoModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtPesqModulo)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDescricaoModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtNovoModulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoModulo.setEnabled(false);
        jBtNovoModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoModuloActionPerformed(evt);
            }
        });

        jBtAlterarModulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-16.png"))); // NOI18N
        jBtAlterarModulo.setEnabled(false);
        jBtAlterarModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarModuloActionPerformed(evt);
            }
        });

        jBtExcluirModulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirModulo.setEnabled(false);
        jBtExcluirModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirModuloActionPerformed(evt);
            }
        });

        jBtSalvarModulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/save-document-icone-9010-16.png"))); // NOI18N
        jBtSalvarModulo.setEnabled(false);
        jBtSalvarModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarModuloActionPerformed(evt);
            }
        });

        jBtCancelarModulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarModulo.setEnabled(false);
        jBtCancelarModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarModuloActionPerformed(evt);
            }
        });

        jBtSairModulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairModuloActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 0, 0));
        jLabel27.setText("(*) Campos Obrigatório");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtNovoModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addGap(34, 34, 34))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAlterarModulo, jBtCancelarModulo, jBtExcluirModulo, jBtNovoModulo, jBtSairModulo, jBtSalvarModulo});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jBtExcluirModulo)
                .addComponent(jBtAlterarModulo)
                .addComponent(jBtNovoModulo)
                .addComponent(jBtSalvarModulo)
                .addComponent(jBtCancelarModulo)
                .addComponent(jBtSairModulo)
                .addComponent(jLabel27))
        );

        jTabelaModulos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaModulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Código", "Descrição do Módulo", "Permissão"
            }
        ));
        jTabelaModulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaModulosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTabelaModulos);
        if (jTabelaModulos.getColumnModel().getColumnCount() > 0) {
            jTabelaModulos.getColumnModel().getColumn(0).setMinWidth(60);
            jTabelaModulos.getColumnModel().getColumn(0).setMaxWidth(60);
            jTabelaModulos.getColumnModel().getColumn(1).setMinWidth(70);
            jTabelaModulos.getColumnModel().getColumn(1).setMaxWidth(70);
            jTabelaModulos.getColumnModel().getColumn(2).setMinWidth(280);
            jTabelaModulos.getColumnModel().getColumn(2).setMaxWidth(280);
            jTabelaModulos.getColumnModel().getColumn(3).setMinWidth(60);
            jTabelaModulos.getColumnModel().getColumn(3).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        jTabbedPane1.addTab("Módulos", jPanel12);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Nome do Usuário:");

        jNomeUsuarioAcesso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jNomeUsuarioAcesso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeUsuarioAcesso.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jNomeUsuarioAcesso.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Tela de Acesso");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Módulo");

        jComboBoxTelaAcesso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        jComboBoxTelaAcesso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxTelaAcesso.setEnabled(false);
        jComboBoxTelaAcesso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxTelaAcessoMouseClicked(evt);
            }
        });

        jBtPesquisarModulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lupas_1338_05.gif"))); // NOI18N
        jBtPesquisarModulo.setContentAreaFilled(false);
        jBtPesquisarModulo.setEnabled(false);
        jBtPesquisarModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPesquisarModuloActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Código");

        jIdModulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jIdModulo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdModulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdModulo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jIdModulo.setEnabled(false);

        jComboBoxModuloAcesso.setEditable(false);
        jComboBoxModuloAcesso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxModuloAcesso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxModuloAcesso.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jComboBoxModuloAcesso.setEnabled(false);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNomeUsuarioAcesso)
                            .addComponent(jComboBoxTelaAcesso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addComponent(jLabel23)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(jIdModulo))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel29)
                                            .addComponent(jComboBoxModuloAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(8, 8, 8)))
                                .addComponent(jBtPesquisarModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNomeUsuarioAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jBtPesquisarModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jIdModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxModuloAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTelaAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabelaAcessos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAcessos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome da Tela", "Abrir", "Incluir", "Alterar", "Excluir", "Consultar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaAcessos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaAcessosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTabelaAcessos);
        if (jTabelaAcessos.getColumnModel().getColumnCount() > 0) {
            jTabelaAcessos.getColumnModel().getColumn(0).setMinWidth(50);
            jTabelaAcessos.getColumnModel().getColumn(0).setMaxWidth(50);
            jTabelaAcessos.getColumnModel().getColumn(1).setMinWidth(400);
            jTabelaAcessos.getColumnModel().getColumn(1).setMaxWidth(400);
            jTabelaAcessos.getColumnModel().getColumn(2).setMinWidth(40);
            jTabelaAcessos.getColumnModel().getColumn(2).setMaxWidth(40);
            jTabelaAcessos.getColumnModel().getColumn(3).setMinWidth(40);
            jTabelaAcessos.getColumnModel().getColumn(3).setMaxWidth(40);
            jTabelaAcessos.getColumnModel().getColumn(4).setMinWidth(50);
            jTabelaAcessos.getColumnModel().getColumn(4).setMaxWidth(50);
            jTabelaAcessos.getColumnModel().getColumn(5).setMinWidth(50);
            jTabelaAcessos.getColumnModel().getColumn(5).setMaxWidth(50);
            jTabelaAcessos.getColumnModel().getColumn(6).setMinWidth(50);
            jTabelaAcessos.getColumnModel().getColumn(6).setMaxWidth(50);
        }

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jBtAlterarAcesso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/8437_16x16.png"))); // NOI18N
        jBtAlterarAcesso.setText("Alterar");
        jBtAlterarAcesso.setContentAreaFilled(false);
        jBtAlterarAcesso.setEnabled(false);
        jBtAlterarAcesso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlterarAcesso.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarAcesso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlterarAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlterarAcessoActionPerformed(evt);
            }
        });

        jBtSalvarAcesso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/1294_16x16.png"))); // NOI18N
        jBtSalvarAcesso.setText("Gravar");
        jBtSalvarAcesso.setContentAreaFilled(false);
        jBtSalvarAcesso.setEnabled(false);
        jBtSalvarAcesso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSalvarAcesso.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarAcesso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSalvarAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSalvarAcessoActionPerformed(evt);
            }
        });

        jBtCancelarAcesso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtCancelarAcesso.setText("Cancelar");
        jBtCancelarAcesso.setContentAreaFilled(false);
        jBtCancelarAcesso.setEnabled(false);
        jBtCancelarAcesso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCancelarAcesso.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarAcesso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCancelarAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarAcessoActionPerformed(evt);
            }
        });

        jBtNovoAcesso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/page_add.png"))); // NOI18N
        jBtNovoAcesso.setText("Novo");
        jBtNovoAcesso.setContentAreaFilled(false);
        jBtNovoAcesso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNovoAcesso.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNovoAcesso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtNovoAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNovoAcessoActionPerformed(evt);
            }
        });

        jBtSairAcesso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Log_Out_Icon_16.png"))); // NOI18N
        jBtSairAcesso.setText("Sair");
        jBtSairAcesso.setContentAreaFilled(false);
        jBtSairAcesso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairAcesso.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtSairAcesso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairAcessoActionPerformed(evt);
            }
        });

        jBtExcluirAcesso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/3630_16x16.png"))); // NOI18N
        jBtExcluirAcesso.setText("Excluir");
        jBtExcluirAcesso.setContentAreaFilled(false);
        jBtExcluirAcesso.setEnabled(false);
        jBtExcluirAcesso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtExcluirAcesso.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirAcesso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtExcluirAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtExcluirAcessoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jBtNovoAcesso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtAlterarAcesso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtExcluirAcesso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSalvarAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelarAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtSairAcesso)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jBtNovoAcesso)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtSalvarAcesso)
                    .addComponent(jBtCancelarAcesso)
                    .addComponent(jBtAlterarAcesso)))
            .addComponent(jBtSairAcesso)
            .addComponent(jBtExcluirAcesso)
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Acessos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Incluir");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Abrir");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Excluir");

        jComboBoxGravar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxGravar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxGravar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxGravar.setEnabled(false);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Alterar");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Consultar");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Gravar");

        jComboBoxAbrir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAbrir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxAbrir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAbrir.setEnabled(false);

        jComboBoxConsultar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxConsultar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxConsultar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxConsultar.setEnabled(false);

        jComboBoxAlterar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxAlterar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxAlterar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxAlterar.setEnabled(false);

        jComboBoxExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxExcluir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxExcluir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxExcluir.setEnabled(false);

        jComboBoxIncluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxIncluir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        jComboBoxIncluir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxIncluir.setEnabled(false);

        jBtCopiarPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Copy-16x16.png"))); // NOI18N
        jBtCopiarPerfil.setToolTipText("Copiar Pérfil de Usuário");
        jBtCopiarPerfil.setContentAreaFilled(false);
        jBtCopiarPerfil.setEnabled(false);
        jBtCopiarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCopiarPerfilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtCopiarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtCopiarPerfil))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Telas de Acesso", jPanel13);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(400, 50, 505, 491);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoActionPerformed

        if (nameUser.equals("ADMINISTRADOR DO SISTEMA")) {
            acao = 1;
            NovoAdm();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            acao = 1;
            Novo();
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        }
    }//GEN-LAST:event_jBtNovoActionPerformed

    private void jBtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarActionPerformed
        if (jlogin.getText().equals("admin")) {
            JOptionPane.showMessageDialog(null, "Alguns campos do usuário administrador não poderão ser modificados.\nSomente a senha poderá ser modificada. Dúvidas, informe ao Administrador do Sistema.");
            acao = 2;
            AlterarAdm();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        } else {
            acao = 2;
            Alterar();
            statusMov = "Alterou";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
        }
    }//GEN-LAST:event_jBtAlterarActionPerformed

    private void jBtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirActionPerformed
        verificarUsuarioGrupo(); // VERIFICAR SE O USUÁRIO PERTENCE A ALGUM GRUPO.
        if (jlogin.getText().equals("admin")) {
            JOptionPane.showMessageDialog(null, "O usuário administrador não pode ser excluído.");
        } else if (IdUsuario.getText().equals(codigoUsuarioGrupo)) {
            JOptionPane.showMessageDialog(rootPane, "Usuário não pode ser exclído, está sendo utilizado na tabela de grupos.");
        } else {
            statusMov = "Excluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir USUARIO selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objUser.setIdUsuario(Integer.valueOf(IdUsuario.getText()));
                control.excluirUsuarios(objUser);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                JOptionPane.showMessageDialog(null, "Exclusão do USUÁRIO com sucesso!!");
                Excluir();
            }
        }
    }//GEN-LAST:event_jBtExcluirActionPerformed

    private void jBtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarActionPerformed

        if (jNomeUsuarioCompleto.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome completo do usuário.");
        } else {
            if (jlogin.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe o login do usuário.");
            } else {
                if (jSenha.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe a senha do usuário.");
                } else {
                    if (jSenhaConf.getText().equals("")) {
                        JOptionPane.showMessageDialog(rootPane, "Informe a confirmação da senha do usuário.");
                    } else {
                        if (jDataCadastro.getDate() == null) {
                            JOptionPane.showMessageDialog(rootPane, "Informe a data cadastro do usuário.");
                        } else {
                            objUser.setDataCadastro(jDataCadastro.getDate());
                            objUser.setNomeUsuario(jNomeUsuarioCompleto.getText());
                            objUser.setNomeDepartamento((String) jComboBoxDepartamento.getSelectedItem());
                            objUser.setNomeCargo((String) jComboBoxCargo.getSelectedItem());
                            objUser.setAcessoTodasUnidades((String) jComboBoxAcessaTodasUnidades.getSelectedItem());
                            objUser.setStatus(objUser.getStatus());
                            if (jComboBoxStatus.getSelectedIndex() == 0) {
                                objUser.setStatus(true);
                            } else {
                                objUser.setStatus(false);
                            }
                            objUser.setNomeUsuario(jNomeUsuarioCompleto.getText());
                            objUser.setLogin(jlogin.getText());
                            objUser.setSenha1(jSenha.getText());
                            objUser.setSenha2(jSenhaConf.getText());
                            if (acao == 1) {
                                pesquisarNomeUsuario();
                                pesquisarLoginUsuario();
                                if (jNomeUsuarioCompleto.getText().equals(nomeUsuario)) {
                                    JOptionPane.showMessageDialog(rootPane, "Nome de usuário já cadastrado, tente outro.");
                                } else if (jlogin.getText().equals(pLogin)) {
                                    JOptionPane.showMessageDialog(rootPane, "Login de usuário já cadastrado, tente outro.");
                                } else {
                                    // Só inclui registro se os campo não for em branco e compara se as senhas são iguais
                                    if (jSenhaConf.getText() == null ? jSenha.getText() == null : jSenhaConf.getText().equals(jSenha.getText())) {
                                        objUser.setNomeGrupo(jDescricaoGrupo.getText());
                                        control.incluirUsuarios(objUser);
                                        buscarID();
                                        objLog();
                                        controlLog.incluirLogSistema(objLogSys); // Grava o log da operação      
                                        //GRAVAR OS DADOS DO USUÁRIO EM TODAS AS BASES DE DADOS DA SOCIALIZA.
                                        if (nameUser.equals("ADMINISTRADOR DO SISTEMA") && jComboBoxAcessaTodasUnidades.getSelectedItem().equals("Sim")) {
                                            mostrarMensagem();
                                        } else {
                                            JOptionPane.showMessageDialog(rootPane, "Cadastro Realizado com sucesso");
                                        }
                                        Salvar();
                                    } else {
                                        JOptionPane.showMessageDialog(rootPane, "Senhas não conferem !!!");
                                    }
                                }
                            }
                            if (acao == 2) {
                                if (jSenhaConf.getText() == null ? jSenha.getText() == null : jSenhaConf.getText().equals(jSenha.getText())) {
                                    objUser.setNomeGrupo(jDescricaoGrupo.getText());
                                    objUser.setIdUsuario(Integer.valueOf(IdUsuario.getText()));
                                    control.alterarUsuarios(objUser);
                                    //GRAVAR OS DADOS DO USUÁRIO EM TODAS AS BASES DE DADOS DA SOCIALIZA.
                                    if (nameUser.equals("ADMINISTRADOR DO SISTEMA") && jComboBoxAcessaTodasUnidades.getSelectedItem().equals("Sim")) {
                                        mostrarMensagem();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Usuario Alterado com sucesso!!");
                                    }
                                    //
                                    objLog();
                                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                                    Salvar();
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "Senhas não conferem !!!");
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jBtSalvarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:        
        Cancela();

    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:        
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed

    private void JBtPesquisaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtPesquisaNomeActionPerformed
        // TODO add your handling code here:
        flag = 1;
        count = 0;
        if (jPesqNome.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe dados para pesquisa");
            jPesqNome.requestFocus();
        } else {
            preencherTabelaNome("SELECT * FROM USUARIOS WHERE NomeUsuario LIKE'%" + jPesqNome.getText() + "%'");
        }
    }//GEN-LAST:event_JBtPesquisaNomeActionPerformed

    private void jTabelaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaUsuariosMouseClicked

        String nomeUser = "" + jTabelaUsuarios.getValueAt(jTabelaUsuarios.getSelectedRow(), 2);
        jPesqNome.setText(nomeUser);
        //
        jComboBoxDepartamento.removeAllItems();
        jComboBoxCargo.removeAllItems();
//        jComboBoxAcessaTodasUnidades.removeAllItems();
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
        //
        jBtNovoGrupo.setEnabled(true);
        jCodigoGrupo.setText("");
        jDescricaoGrupo.setText("");
        //        
        jComboBoxGrupoModulo.removeAllItems();
        jBtNovoModulo.setEnabled(true);
        jCodigoModulo.setText("");
        jComboBoxPermissaoModulo.setSelectedItem("Não");
        jComboBoxGrupoModulo.setSelectedItem("Selecione");
        jDescricaoModulo.setText("");
        //
        jBtCopiarPerfil.setEnabled(true);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nomeUser + "'");
            conecta.rs.first();
            IdUsuario.setText(String.valueOf(conecta.rs.getInt("IdUsuario")));
            jDataCadastro.setDate(conecta.rs.getDate("DataCadastro"));
            jNomeUsuarioCompleto.setText(conecta.rs.getString("NomeUsuario"));
            jComboBoxDepartamento.addItem(conecta.rs.getString("NomeDepartamento"));
            jComboBoxCargo.addItem(conecta.rs.getString("NomeCargo"));
            jComboBoxAcessaTodasUnidades.setSelectedItem(conecta.rs.getString("AcessoTodasUnidades"));
            if (jComboBoxAcessaTodasUnidades.getSelectedItem() == null) {
                jComboBoxAcessaTodasUnidades.setSelectedItem("Não");
            } else if (jComboBoxAcessaTodasUnidades.getSelectedItem().equals("")) {
                jComboBoxAcessaTodasUnidades.setSelectedItem("Não");
            } else {
                jComboBoxAcessaTodasUnidades.setSelectedItem(conecta.rs.getString("AcessoTodasUnidades"));
            }
            jlogin.setText(conecta.rs.getString("LoginUsuario"));
            jSenha.setText(conecta.rs.getString("SenhaUsuario"));
            jSenhaConf.setText(conecta.rs.getString("ConfirmaSenhaUsuario"));
            statusUser = conecta.rs.getInt("StatusUsuario");
            if (statusUser == 0) {
                statusNome = "Inativo";
            } else if (statusUser == 1) {
                statusNome = "Ativo";
            }
            jComboBoxStatus.setSelectedItem(statusNome);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível listar usuario\nERRO: " + ex);
        }
        conecta.desconecta();
        preencherTabelaAcessos("SELECT * FROM TELAS_ACESSO "
                + "WHERE IdUsuario='" + IdUsuario.getText() + "'");
        preencherTabelaGrupos("SELECT * FROM USUARIOS_GRUPOS "
                + "INNER JOIN GRUPOUSUARIOS "
                + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                + "WHERE USUARIOS_GRUPOS.IdUsuario='" + IdUsuario.getText() + "'");
        preencherTabelaModulos("SELECT * FROM USUARIOS_MODULOS "
                + "INNER JOIN MODULOS "
                + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                + "WHERE USUARIOS_MODULOS.IdUsuario='" + IdUsuario.getText() + "'");
    }//GEN-LAST:event_jTabelaUsuariosMouseClicked

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        count = 0;
        flag = 1;
        if (evt.getStateChange() == evt.SELECTED) {
            this.pesquisarTodos("SELECT * FROM USUARIOS ");
        } else {
            limparTabela();
            count = 0;
            jtotalRegistros.setText("");
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jComboBoxDepartamentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxDepartamentoMouseEntered
        // TODO add your handling code here:
        preencherComboDepartamento();
    }//GEN-LAST:event_jComboBoxDepartamentoMouseEntered

    private void jComboBoxCargoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxCargoMouseEntered
        // TODO add your handling code here:
        preencherComboCargo();
    }//GEN-LAST:event_jComboBoxCargoMouseEntered

    private void jBtPesqModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesqModuloActionPerformed
        // TODO add your handling code here:
        Integer rows = jTabelaGrupo.getModel().getRowCount();
        if (rows == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não existe grupo de acesso para o usuário.");
        } else {
            TelaPesqModulosUsuarios objPesqModuloUser = new TelaPesqModulosUsuarios();
            TelaModuloConfiguracoes.jPainelConfiguracoes.add(objPesqModuloUser);
            objPesqModuloUser.show();
        }
    }//GEN-LAST:event_jBtPesqModuloActionPerformed

    private void jBtNovoModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoModuloActionPerformed
        // TODO add your handling code here:
        acao = 5;
        NovoModulo();
        preencherComboBoxGrupo();
        statusMov = "Incluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtNovoModuloActionPerformed

    private void jBtAlterarModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarModuloActionPerformed
        // TODO add your handling code here:
        acao = 6;
        AlterarModulo();
        preencherComboBoxGrupo();
        statusMov = "Alterou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtAlterarModuloActionPerformed

    private void jBtExcluirModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirModuloActionPerformed
        // TODO add your handling code here:
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o módulo selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objUser.setIdModulo(codModelGroup);
            controleMod.excluirModuloUsuarios(objUser);
            ExcluirModulo();
            preencherTabelaModulos("SELECT * FROM USUARIOS_MODULOS "
                    + "INNER JOIN MODULOS "
                    + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                    + "WHERE USUARIOS_MODULOS.IdUsuario='" + IdUsuario.getText() + "'");
            JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
        }
    }//GEN-LAST:event_jBtExcluirModuloActionPerformed

    private void jBtSalvarModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarModuloActionPerformed
        // TODO add your handling code here:
        if (jDescricaoModulo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o módulo de acesso.");
        } else if (jComboBoxGrupoModulo.getSelectedItem().equals("Selecione")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o grupo a qual o módulo pertence.");
        } else {
            if (acao == 5) {
                objUser.setIdUsuario(Integer.valueOf(IdUsuario.getText()));
                objUser.setNomeGrupo((String) jComboBoxGrupoModulo.getSelectedItem());
                objUser.setNomeModulo(jDescricaoModulo.getText());
                objUser.setPermissaoModulo((String) jComboBoxPermissaoModulo.getSelectedItem());
                controleMod.incluirModuloUsuarios(objUser);
                objLog2();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação        
                SalvarModulo();
                preencherTabelaModulos("SELECT * FROM USUARIOS_MODULOS "
                        + "INNER JOIN MODULOS "
                        + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                        + "WHERE USUARIOS_MODULOS.IdUsuario='" + IdUsuario.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
            if (acao == 6) {
                objUser.setIdUsuario(Integer.valueOf(IdUsuario.getText()));
                objUser.setNomeGrupo((String) jComboBoxGrupoModulo.getSelectedItem());
                objUser.setNomeModulo(jDescricaoModulo.getText());
                objUser.setPermissaoModulo((String) jComboBoxPermissaoModulo.getSelectedItem());
                objUser.setIdMod(codModelGroup);
                controleMod.alterarModuloUsuarios(objUser);
                objLog2();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação            
                SalvarModulo();
                preencherTabelaModulos("SELECT * FROM USUARIOS_MODULOS "
                        + "INNER JOIN MODULOS "
                        + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                        + "WHERE USUARIOS_MODULOS.IdUsuario='" + IdUsuario.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
            }
        }
    }//GEN-LAST:event_jBtSalvarModuloActionPerformed

    private void jBtCancelarModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarModuloActionPerformed
        // TODO add your handling code here:
        CancelarModulo();
    }//GEN-LAST:event_jBtCancelarModuloActionPerformed

    private void jBtSairModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairModuloActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairModuloActionPerformed

    private void jTabelaModulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaModulosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        String idMod = "" + jTabelaModulos.getValueAt(jTabelaModulos.getSelectedRow(), 0);
        String idModulo = "" + jTabelaModulos.getValueAt(jTabelaModulos.getSelectedRow(), 1);
        jCodigoGrupo.setText(idModulo);
        //       
        jBtNovoModulo.setEnabled(true);
        jBtAlterarModulo.setEnabled(true);
        jBtExcluirModulo.setEnabled(true);
        jBtSalvarModulo.setEnabled(!true);
        jBtCancelarModulo.setEnabled(true);
        //
        //   jComboBoxPermissaoModulo.removeAllItems();
        jComboBoxGrupoModulo.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                    + "INNER JOIN MODULOS "
                    + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_MODULOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE USUARIOS_MODULOS.IdMod='" + idMod + "'");
            conecta.rs.first();
            codModelGroup = conecta.rs.getInt("IdMod");
            jCodigoModulo.setText(String.valueOf(conecta.rs.getInt("IdModulo")));
            jComboBoxPermissaoModulo.setSelectedItem(conecta.rs.getString("Permissao"));
            jComboBoxGrupoModulo.addItem(conecta.rs.getString("NomeGrupo"));
            jDescricaoModulo.setText(conecta.rs.getString("NomeModulo"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível listar grupo de usuário\nERRO: " + ex);
        }
    }//GEN-LAST:event_jTabelaModulosMouseClicked

    private void jComboBoxGrupoModuloMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxGrupoModuloMouseEntered
        // TODO add your handling code here:
//        if (acao == 5 || acao == 6) {
//            preencherComboBoxGrupo();
//        }
    }//GEN-LAST:event_jComboBoxGrupoModuloMouseEntered

    private void jTabelaGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaGrupoMouseClicked
        // TODO add your handling code here:
        String idGroup = "" + jTabelaGrupo.getValueAt(jTabelaGrupo.getSelectedRow(), 0);
        String idGrupo = "" + jTabelaGrupo.getValueAt(jTabelaGrupo.getSelectedRow(), 1);
        jCodigoGrupo.setText(idGrupo);
        //
        jBtNovoGrupo.setEnabled(true);
        jBtAlterarGrupo.setEnabled(true);
        jBtExcluirGrupo.setEnabled(true);
        jBtSalvarGrupo.setEnabled(!true);
        jBtCancelarGrupo.setEnabled(true);
        //
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo  "
                    + "WHERE USUARIOS_GRUPOS.IdUserGroup='" + idGroup + "'");
            conecta.rs.first();
            codUserGroup = conecta.rs.getInt("IdUserGroup");
            jCodigoGrupo.setText(String.valueOf(conecta.rs.getInt("IdGrupo")));
            jDescricaoGrupo.setText(conecta.rs.getString("NomeGrupo"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível listar grupo de usuário\nERRO: " + ex);
        }
    }//GEN-LAST:event_jTabelaGrupoMouseClicked

    private void jBtSairGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairGrupoActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairGrupoActionPerformed

    private void jBtCancelarGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarGrupoActionPerformed
        // TODO add your handling code here:
        CancelarGrupo();
    }//GEN-LAST:event_jBtCancelarGrupoActionPerformed

    private void jBtSalvarGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarGrupoActionPerformed
        // TODO add your handling code here:
        verificarGrupoCadastrado();
        if (jDescricaoGrupo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe o grupo do usuário.");
        } else {
            objUser.setNomeUsuario(jNomeUsuarioCompleto.getText());
            objUser.setIdUsuario(Integer.valueOf(IdUsuario.getText()));
            if (acao == 3) {
                if (jCodigoGrupo.getText().equals(codigoUserGrupo) && IdUsuario.getText().equals(codigoUsuarioGrupoNovo)) {
                    JOptionPane.showMessageDialog(rootPane, "Este grupo de usuário já foi cadastrado para esse Usuário.");
                } else {
                    objUser.setNomeGrupo(jDescricaoGrupo.getText());
                    controle.incluirGrupoUsuarios(objUser);
                    objLog1();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação                    
                    SalvarGrupo();
                    //
                    if (nameUser.equals("ADMINISTRADOR DO SISTEMA") && jComboBoxAcessaTodasUnidades.getSelectedItem().equals("Sim")) {
                        mostrarMensagemGrupo();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                    }
                    preencherTabelaGrupos("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE USUARIOS_GRUPOS.IdUsuario='" + IdUsuario.getText() + "'");
                }
            }
            if (acao == 4) {
                objUser.setNomeGrupo(jDescricaoGrupo.getText());
                objUser.setIdUserGroup(codUserGroup);
                controle.alterarGrupoUsuarios(objUser);
                objLog1();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
                SalvarGrupo();
                if (nameUser.equals("ADMINISTRADOR DO SISTEMA") && jComboBoxAcessaTodasUnidades.getSelectedItem().equals("Sim")) {
                    mostrarMensagemGrupo();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Registro gravado com sucesso.");
                }
                preencherTabelaGrupos("SELECT * FROM USUARIOS_GRUPOS "
                        + "INNER JOIN GRUPOUSUARIOS "
                        + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                        + "WHERE USUARIOS_GRUPOS.IdUsuario='" + IdUsuario.getText() + "'");
            }
        }
    }//GEN-LAST:event_jBtSalvarGrupoActionPerformed

    private void jBtExcluirGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirGrupoActionPerformed
        // TODO add your handling code here:
        verificarGrupoModulo(); // VERIFICAR SE O GRUPO PERTENCE A ALGUM MÓDULO.
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        if (jCodigoGrupo.getText().equals(codigoGrupoModulo) && IdUsuario.getText().equals(codigoUserDel)) {
            JOptionPane.showMessageDialog(rootPane, "Não é possível excluir esse grupo, esse registro está sendo utilizada na tabela de módulos");
        } else {
            int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o grupo selecionado?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                objUser.setIdUserGroup(codUserGroup);
                controle.excluirGrupoUsuarios(objUser);
                ExcluirGrupo();
                preencherTabelaGrupos("SELECT * FROM USUARIOS_GRUPOS "
                        + "INNER JOIN GRUPOUSUARIOS "
                        + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                        + "WHERE USUARIOS_GRUPOS.IdUsuario='" + IdUsuario.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Registro excluído com sucesso.");
            }
        }
    }//GEN-LAST:event_jBtExcluirGrupoActionPerformed

    private void jBtAlterarGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarGrupoActionPerformed
        // TODO add your handling code here:
        acao = 4;
        AlterarGrupo();
        statusMov = "Alterou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtAlterarGrupoActionPerformed

    private void jBtNovoGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoGrupoActionPerformed
        // TODO add your handling code here:
        acao = 3;
        NovoGrupo();
        statusMov = "Incluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
    }//GEN-LAST:event_jBtNovoGrupoActionPerformed

    private void jBtPesDeptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesDeptoActionPerformed
        // TODO add your handling code here:
        TelaPesqGrupoUsuarios objDepto = new TelaPesqGrupoUsuarios();
        TelaModuloConfiguracoes.jPainelConfiguracoes.add(objDepto);
        objDepto.show();
    }//GEN-LAST:event_jBtPesDeptoActionPerformed

    private void jBtNovoAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNovoAcessoActionPerformed
        // TODO add your handling code here:
        if (IdUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Não existe usuário selecionado para ser configurado o acesso.");
        } else {
            acao = 7;
            statusMov = "Incluiu";
            horaMov = jHoraSistema.getText();
            dataModFinal = jDataSistema.getText();
            NovoAcesso();
        }
    }//GEN-LAST:event_jBtNovoAcessoActionPerformed

    private void jBtAlterarAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlterarAcessoActionPerformed
        // TODO add your handling code here:
        acao = 8;
        statusMov = "Alterou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        AlterarAcesso();
//        pesquisarModuloUsuarios();
//        pesquisarModulo();
//        pesquisarTelaAcesso();
    }//GEN-LAST:event_jBtAlterarAcessoActionPerformed

    private void jBtExcluirAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtExcluirAcessoActionPerformed
        // TODO add your handling code here:
        statusMov = "Excluiu";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir Acesso selecionado?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            objTelaAcesso.setIdTela(Integer.valueOf(codigoTelaAcesso));
            controlaAcess.excluirTelaAcesso(objTelaAcesso);
            objLog();
            controlLog.incluirLogSistema(objLogSys); // Grava o log da operação
            ExcluirAcesso();
            preencherTabelaAcessos("SELECT * FROM TELAS_ACESSO "
                    + "WHERE IdUsuario='" + IdUsuario.getText() + "'");
            JOptionPane.showMessageDialog(null, "Registro excluído com sucesso.");

        }
    }//GEN-LAST:event_jBtExcluirAcessoActionPerformed

    private void jBtSalvarAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSalvarAcessoActionPerformed
        // TODO add your handling code here:
        verificarTelaAcesso();
        if (jComboBoxModuloAcesso.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o módulo de acesso.");
        } else if (jComboBoxTelaAcesso.getSelectedItem().equals("Selecione...") || jComboBoxTelaAcesso.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a tela de acesso do usuário...");
        } else if (jComboBoxAbrir.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a configuração para Abrir.");
        } else if (jComboBoxAlterar.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a configuração para Alterar.");
        } else if (jComboBoxExcluir.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a configuração para Excluir.");
        } else if (jComboBoxGravar.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a configuração para Gravar.");
        } else if (jComboBoxConsultar.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe a configuração para Consultar.");
        } else {
            if (jComboBoxAbrir.getSelectedItem().equals("Não")) {
                pAbrir = 0;
            } else if (jComboBoxAbrir.getSelectedItem().equals("Sim")) {
                pAbrir = 1;
            }
            if (jComboBoxIncluir.getSelectedItem().equals("Não")) {
                pIncluir = 0;
            } else if (jComboBoxIncluir.getSelectedItem().equals("Sim")) {
                pIncluir = 1;
            }
            if (jComboBoxAlterar.getSelectedItem().equals("Não")) {
                pAlterar = 0;
            } else if (jComboBoxAlterar.getSelectedItem().equals("Sim")) {
                pAlterar = 1;
            }
            if (jComboBoxExcluir.getSelectedItem().equals("Não")) {
                pExcluir = 0;
            } else if (jComboBoxExcluir.getSelectedItem().equals("Sim")) {
                pExcluir = 1;
            }
            if (jComboBoxGravar.getSelectedItem().equals("Não")) {
                pGravar = 0;
            } else if (jComboBoxGravar.getSelectedItem().equals("Sim")) {
                pGravar = 1;
            }
            if (jComboBoxConsultar.getSelectedItem().equals("Não")) {
                pConsultar = 0;
            } else if (jComboBoxConsultar.getSelectedItem().equals("Sim")) {
                pConsultar = 1;
            }
            objTelaAcesso.setIdUsuario(Integer.valueOf(IdUsuario.getText()));
            objTelaAcesso.setNomeUsuario(jNomeUsuarioCompleto.getText());
            objTelaAcesso.setNomeModulo(jComboBoxModuloAcesso.getText());
            objTelaAcesso.setNomeTela((String) jComboBoxTelaAcesso.getSelectedItem());
            objTelaAcesso.setIncluir(pIncluir);
            objTelaAcesso.setAbrir(pAbrir);
            objTelaAcesso.setAlterar(pAlterar);
            objTelaAcesso.setExcluir(pExcluir);
            objTelaAcesso.setGravar(pGravar);
            objTelaAcesso.setConsultar(pConsultar);
            if (acao == 7) {
                if (IdUsuario.getText().equals(codigoUsuario) && jComboBoxTelaAcesso.getSelectedItem().equals(nomeTelaUsuario)) {
                    JOptionPane.showMessageDialog(rootPane, "Esse acesso ja foi cadastrado para esse usuário!!!");
                } else {
                    objTelaAcesso.setUsuarioInsert(nameUser);
                    objTelaAcesso.setDataInsert(dataModFinal);
                    objTelaAcesso.setHorarioInsert(horaMov);
                    //
                    controlaAcess.incluirTelaAcesso(objTelaAcesso);
                    objLog();
                    controlLog.incluirLogSistema(objLogSys); // Grava o log da operação       
                    SalvarAcesso();
                    preencherTabelaAcessos("SELECT * FROM TELAS_ACESSO "
                            + "WHERE IdUsuario='" + IdUsuario.getText() + "'");
                    JOptionPane.showMessageDialog(rootPane, "Cadastro Realizado com sucesso");
                }
            }
            if (acao == 8) {
                objTelaAcesso.setUsuarioUp(nameUser);
                objTelaAcesso.setDataUp(dataModFinal);
                objTelaAcesso.setHorarioUp(horaMov);
                //                
                objTelaAcesso.setIdTela(codigoTelaAcesso);
                controlaAcess.alterarTelaAcesso(objTelaAcesso);
                objLog();
                controlLog.incluirLogSistema(objLogSys); // Grava o log da operação 
                SalvarAcesso();
                preencherTabelaAcessos("SELECT * FROM TELAS_ACESSO "
                        + "WHERE IdUsuario='" + IdUsuario.getText() + "'");
                JOptionPane.showMessageDialog(rootPane, "Cadastro Realizado com sucesso");
            }
        }
    }//GEN-LAST:event_jBtSalvarAcessoActionPerformed

    private void jBtCancelarAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarAcessoActionPerformed
        // TODO add your handling code here:
        CancelarAcesso();
    }//GEN-LAST:event_jBtCancelarAcessoActionPerformed

    private void jBtSairAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairAcessoActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBtSairAcessoActionPerformed

    private void jTabelaAcessosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaAcessosMouseClicked
        // TODO add your handling code here:
        flag = 1;
        String idTela = "" + jTabelaAcessos.getValueAt(jTabelaAcessos.getSelectedRow(), 0);
        //
        jBtNovoAcesso.setEnabled(true);
        jBtAlterarAcesso.setEnabled(true);
        jBtExcluirAcesso.setEnabled(true);
        jBtCancelarAcesso.setEnabled(true);
        //        
        jComboBoxTelaAcesso.removeAllItems();
        //
        jComboBoxAbrir.removeItem(evt);
        jComboBoxIncluir.removeItem(evt);
        jComboBoxAlterar.removeItem(evt);
        jComboBoxExcluir.removeItem(evt);
        jComboBoxGravar.removeItem(evt);
        jComboBoxConsultar.removeItem(evt);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "INNER JOIN USUARIOS "
                    + "ON TELAS_ACESSO.IdUsuario=USUARIOS.IdUsuario "
                    + "INNER JOIN USUARIOS_MODULOS "
                    + "ON USUARIOS.IdUsuario=USUARIOS_MODULOS.IdUsuario "
                    + "INNER JOIN MODULOS "
                    + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                    + "WHERE TELAS_ACESSO.IdTela='" + idTela + "'");
            conecta.rs.first();
            codigoTelaAcesso = conecta.rs.getInt("IdTela");
            jNomeUsuarioAcesso.setText(jNomeUsuarioCompleto.getText());
            jIdModulo.setText(conecta.rs.getString("IdModulo"));
            jComboBoxModuloAcesso.setText(conecta.rs.getString("NomeModulo"));
            jComboBoxTelaAcesso.addItem(conecta.rs.getString("NomeTela"));
            pAbrir = conecta.rs.getInt("Abrir");
            if (pAbrir == 0) {
                jComboBoxAbrir.setSelectedItem("Não");
            } else if (pAbrir == 1) {
                jComboBoxAbrir.setSelectedItem("Sim");
            }
            pIncluir = conecta.rs.getInt("Incluir");
            if (pIncluir == 0) {
                jComboBoxIncluir.setSelectedItem("Não");
            } else if (pIncluir == 1) {
                jComboBoxIncluir.setSelectedItem("Sim");
            }
            pAlterar = conecta.rs.getInt("Alterar");
            if (pAlterar == 0) {
                jComboBoxAlterar.setSelectedItem("Não");
            } else if (pAlterar == 1) {
                jComboBoxAlterar.setSelectedItem("Sim");
            }
            pExcluir = conecta.rs.getInt("Excluir");
            if (pExcluir == 0) {
                jComboBoxExcluir.setSelectedItem("Não");
            } else if (pExcluir == 1) {
                jComboBoxExcluir.setSelectedItem("Sim");
            }
            pGravar = conecta.rs.getInt("Gravar");
            if (pGravar == 0) {
                jComboBoxGravar.setSelectedItem("Não");
            } else if (pGravar == 1) {
                jComboBoxGravar.setSelectedItem("Sim");
            }
            pConsultar = conecta.rs.getInt("Consultar");
            if (pConsultar == 0) {
                jComboBoxConsultar.setSelectedItem("Não");
            } else if (pConsultar == 1) {
                jComboBoxConsultar.setSelectedItem("Sim");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível listar dados do usuário.\nERRO: " + ex);
        }
    }//GEN-LAST:event_jTabelaAcessosMouseClicked

    private void jBtPesquisarModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisarModuloActionPerformed
        // TODO add your handling code here:
        mostrarTela();
    }//GEN-LAST:event_jBtPesquisarModuloActionPerformed

    private void jBtCopiarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCopiarPerfilActionPerformed
        // TODO add your handling code here:
        Integer rowsm = jTabelaModulos.getModel().getRowCount();
        Integer prows = jTabelaGrupo.getModel().getRowCount();
        Integer rows = jTabelaAcessos.getModel().getRowCount();
        if (rows == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não existe registros de acesso a ser copiado.");
        } else if (rows != 0 && prows == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não existe módulo de acesso para o usuário.");
        } else if (rows != 0 && rowsm == 0) {
            JOptionPane.showMessageDialog(rootPane, "Não existe grupo de acesso para o usuário.");
        } else {
            mostrarUsuario();
        }
    }//GEN-LAST:event_jBtCopiarPerfilActionPerformed

    private void jComboBoxTelaAcessoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxTelaAcessoMouseClicked
        // TODO add your handling code here:
        pesquisarTelaAcesso();
    }//GEN-LAST:event_jComboBoxTelaAcessoMouseClicked

    private void jBtPesquisaGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPesquisaGrupoActionPerformed
        // TODO add your handling code here:
        flag = 1;
        count = 0;
        if (jNomeGrupoUser.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome do grupo para pesquisa.");
            jNomeGrupoUser.requestFocus();
        } else {
            preencherTabelaNome("SELECT * FROM USUARIOS "
                    + "INNER JOIN USUARIOS_GRUPOS "
                    + "ON USUARIOS.IdUsuario=USUARIOS_GRUPOS.IdUsuario "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo LIKE '%" + jNomeGrupoUser.getText() + "%'");
        }
    }//GEN-LAST:event_jBtPesquisaGrupoActionPerformed

    private void jBtDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDepartamentoActionPerformed
        // TODO add your handling code here:
        flag = 1;
        count = 0;
        if (jDepartamento.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe dados para pesquisa");
            jDepartamento.requestFocus();
        } else {
            preencherTabelaNome("SELECT * FROM USUARIOS "
                    + "WHERE NomeDepartamento LIKE'%" + jDepartamento.getText() + "%'");
        }
    }//GEN-LAST:event_jBtDepartamentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField IdUsuario;
    private javax.swing.JButton JBtPesquisaNome;
    private javax.swing.JButton jBtAlterar;
    private javax.swing.JButton jBtAlterarAcesso;
    private javax.swing.JButton jBtAlterarGrupo;
    private javax.swing.JButton jBtAlterarModulo;
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtCancelarAcesso;
    private javax.swing.JButton jBtCancelarGrupo;
    private javax.swing.JButton jBtCancelarModulo;
    private javax.swing.JButton jBtCopiarPerfil;
    private javax.swing.JButton jBtDepartamento;
    private javax.swing.JButton jBtExcluir;
    private javax.swing.JButton jBtExcluirAcesso;
    private javax.swing.JButton jBtExcluirGrupo;
    private javax.swing.JButton jBtExcluirModulo;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JButton jBtNovoAcesso;
    private javax.swing.JButton jBtNovoGrupo;
    private javax.swing.JButton jBtNovoModulo;
    private javax.swing.JButton jBtPesDepto;
    private javax.swing.JButton jBtPesqModulo;
    private javax.swing.JButton jBtPesquisaGrupo;
    private javax.swing.JButton jBtPesquisarModulo;
    private javax.swing.JButton jBtSair;
    private javax.swing.JButton jBtSairAcesso;
    private javax.swing.JButton jBtSairGrupo;
    private javax.swing.JButton jBtSairModulo;
    private javax.swing.JButton jBtSalvar;
    private javax.swing.JButton jBtSalvarAcesso;
    private javax.swing.JButton jBtSalvarGrupo;
    private javax.swing.JButton jBtSalvarModulo;
    private javax.swing.JCheckBox jCheckBox1;
    public static javax.swing.JTextField jCodigoGrupo;
    public static javax.swing.JTextField jCodigoModulo;
    private javax.swing.JComboBox jComboBoxAbrir;
    public static javax.swing.JComboBox<String> jComboBoxAcessaTodasUnidades;
    private javax.swing.JComboBox jComboBoxAlterar;
    public static javax.swing.JComboBox jComboBoxCargo;
    private javax.swing.JComboBox jComboBoxConsultar;
    public static javax.swing.JComboBox jComboBoxDepartamento;
    private javax.swing.JComboBox jComboBoxExcluir;
    private javax.swing.JComboBox jComboBoxGravar;
    private javax.swing.JComboBox jComboBoxGrupoModulo;
    private javax.swing.JComboBox jComboBoxIncluir;
    public static javax.swing.JTextField jComboBoxModuloAcesso;
    private javax.swing.JComboBox jComboBoxPermissaoModulo;
    public static javax.swing.JComboBox jComboBoxStatus;
    public static javax.swing.JComboBox jComboBoxTelaAcesso;
    public static com.toedter.calendar.JDateChooser jDataCadastro;
    private javax.swing.JTextField jDepartamento;
    public static javax.swing.JTextField jDescricaoGrupo;
    public static javax.swing.JTextField jDescricaoModulo;
    public static javax.swing.JTextField jIdModulo;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jNomeGrupoUser;
    private javax.swing.JTextField jNomeUsuarioAcesso;
    public static javax.swing.JTextField jNomeUsuarioCompleto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jPesqNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JPasswordField jSenha;
    public static javax.swing.JPasswordField jSenhaConf;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTabelaAcessos;
    public static javax.swing.JTable jTabelaGrupo;
    private javax.swing.JTable jTabelaModulos;
    private javax.swing.JTable jTabelaUsuarios;
    public static javax.swing.JTextField jlogin;
    private javax.swing.JLabel jtotalRegistros;
    // End of variables declaration//GEN-END:variables

    public void pesquisarUsuarioUnidadeLF() {
        conectaLF.abrirConexao();
        try {
            conectaLF.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE LoginUsuario='" + jlogin.getText().trim() + "'");
            conectaLF.rs.first();
            pCODIGO_USUARIO_LF = conectaLF.rs.getString("IdUsuario");
            pLOGIN_USUARIO_LF = conectaLF.rs.getString("LoginUsuario");
        } catch (Exception e) {
        }
        conectaLF.desconecta();
    }

    //VITORIA DA CONQUISTA
    public void pesquisarUsuarioUnidadeVC() {
        conectaVC.abrirConexao();
        try {
            conectaVC.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE LoginUsuario='" + jlogin.getText().trim() + "'");
            conectaVC.rs.first();
            pCODIGO_USUARIO_VC = conectaVC.rs.getString("IdUsuario");
            pLOGIN_USUARIO_VC = conectaVC.rs.getString("LoginUsuario");
        } catch (Exception e) {
        }
        conectaVC.desconecta();
    }

    //ITABUNA
    public void pesquisarUsuarioUnidadeITB() {
        conectaITB.abrirConexao();
        try {
            conectaITB.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE LoginUsuario='" + jlogin.getText().trim() + "'");
            conectaITB.rs.first();
            pCODIGO_USUARIO_ITB = conectaITB.rs.getString("IdUsuario");
            pLOGIN_USUARIO_ITB = conectaITB.rs.getString("LoginUsuario");
        } catch (Exception e) {
        }
        conectaITB.desconecta();
    }

    //SALVADOR
    public void pesquisarUsuarioUnidadeSSA() {
        conectaSSA.abrirConexao();
        try {
            conectaSSA.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE LoginUsuario='" + jlogin.getText().trim() + "'");
            conectaSSA.rs.first();
            pCODIGO_USUARIO_SSA = conectaSSA.rs.getString("IdUsuario");
            pLOGIN_USUARIO_SSA = conectaSSA.rs.getString("LoginUsuario");
        } catch (Exception e) {
        }
        conectaSSA.desconecta();
    }

    //BARREIRAS
    public void pesquisarUsuarioUnidadeBAR() {
        conectaBAR.abrirConexao();
        try {
            conectaBAR.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE LoginUsuario='" + jlogin.getText().trim() + "'");
            conectaBAR.rs.first();
            pCODIGO_USUARIO_BAR = conectaBAR.rs.getString("IdUsuario");
            pLOGIN_USUARIO_BAR = conectaBAR.rs.getString("LoginUsuario");
        } catch (Exception e) {
        }
        conectaBAR.desconecta();
    }
//--------------------------------------------

    public void pesquisarNomeUsuario() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + jNomeUsuarioCompleto.getText() + "'");
            conecta.rs.first();
            nomeUsuario = conecta.rs.getString("NomeUsuario");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void pesquisarLoginUsuario() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE LoginUsuario='" + jlogin.getText() + "'");
            conecta.rs.first();
            pLogin = conecta.rs.getString("LoginUsuario");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void formatarCampos() {
        jNomeUsuarioCompleto.setDocument(new LimiteDigitos(67));
        jlogin.setDocument(new LimiteDigitosMin(25));
        jSenha.setDocument(new LimiteDigitosMin(100));
        jSenhaConf.setDocument(new LimiteDigitosMin(100));
    }

    public void corCampos() {
        IdUsuario.setBackground(Color.white);
        jNomeUsuarioCompleto.setBackground(Color.white);
        jlogin.setBackground(Color.white);
        jSenha.setBackground(Color.white);
        jSenhaConf.setBackground(Color.white);
        //
        jNomeUsuarioAcesso.setBackground(Color.white);
        jIdModulo.setBackground(Color.white);
        jComboBoxModuloAcesso.setBackground(Color.white);
    }

    public void Novo() {
        // Limpa os campos
        IdUsuario.setText("");
        jDataCadastro.setCalendar(Calendar.getInstance());
        jNomeUsuarioCompleto.setText("");
        jComboBoxDepartamento.setSelectedItem("Selecione");
        jComboBoxCargo.setSelectedItem("Selecione");
        jlogin.setText("");
        jSenha.setText("");
        jSenhaConf.setText("");
        // Habilita os campos        
        jComboBoxStatus.setEnabled(true);
        jNomeUsuarioCompleto.setEnabled(true);
        jDataCadastro.setEnabled(true);
        jComboBoxDepartamento.setEnabled(true);
        jComboBoxCargo.setEnabled(true);
        jlogin.setEnabled(true);
        jSenha.setEnabled(true);
        jSenhaConf.setEnabled(true);
        // Habilta os botões de manutenção
        jBtAlterar.setEnabled(false);
        jBtExcluir.setEnabled(false);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtPesDepto.setEnabled(true);
        //
        limparTabelaGrupo();
        limparTabelaModulos();
        limparTabelaAcessos();
    }

    public void NovoAdm() {
        // Limpa os campos
        IdUsuario.setText("");
        jDataCadastro.setCalendar(Calendar.getInstance());
        jNomeUsuarioCompleto.setText("");
        jComboBoxDepartamento.setSelectedItem("Selecione");
        jComboBoxCargo.setSelectedItem("Selecione");
        jlogin.setText("");
        jSenha.setText("");
        jSenhaConf.setText("");
        // Habilita os campos        
        jComboBoxStatus.setEnabled(true);
        jNomeUsuarioCompleto.setEnabled(true);
        jDataCadastro.setEnabled(true);
        jComboBoxDepartamento.setEnabled(true);
        jComboBoxCargo.setEnabled(true);
        jComboBoxAcessaTodasUnidades.setEnabled(true);
        jlogin.setEnabled(true);
        jSenha.setEnabled(true);
        jSenhaConf.setEnabled(true);
        // Habilta os botões de manutenção
        jBtAlterar.setEnabled(false);
        jBtExcluir.setEnabled(false);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtPesDepto.setEnabled(true);
        //
        limparTabelaGrupo();
        limparTabelaModulos();
        limparTabelaAcessos();
    }

    public void Alterar() {
        // Habilita os campos        
        jComboBoxStatus.setEnabled(true);
        jNomeUsuarioCompleto.setEnabled(true);
        jDataCadastro.setEnabled(true);
        jComboBoxDepartamento.setEnabled(true);
        jComboBoxCargo.setEnabled(true);
        jlogin.setEnabled(true);
        jSenha.setEnabled(true);
        jSenhaConf.setEnabled(true);
        // Habilta os botões de manutenção
        jBtAlterar.setEnabled(false);
        jBtExcluir.setEnabled(false);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtPesDepto.setEnabled(true);
    }

    public void AlterarAdm() {
        // Habilita os campos        
        jComboBoxStatus.setEnabled(!true);
        jNomeUsuarioCompleto.setEnabled(!true);
        jDataCadastro.setEnabled(!true);
        jComboBoxDepartamento.setEnabled(!true);
        jComboBoxCargo.setEnabled(!true);
        jlogin.setEnabled(!true);
        jComboBoxAcessaTodasUnidades.setEnabled(true);
        jSenha.setEnabled(true);
        jSenhaConf.setEnabled(true);
        // Habilta os botões de manutenção
        jBtAlterar.setEnabled(false);
        jBtExcluir.setEnabled(false);
        jBtSalvar.setEnabled(true);
        jBtCancelar.setEnabled(true);
        jBtPesDepto.setEnabled(!true);
    }

    public void Excluir() {
        //
        IdUsuario.setText("");
        jDataCadastro.setDate(null);
        jNomeUsuarioCompleto.setText("");
        jComboBoxDepartamento.setSelectedItem("Selecione...");
        jComboBoxCargo.setSelectedItem("Selecione...");
        jComboBoxAcessaTodasUnidades.setSelectedItem("Selecione...");
        jlogin.setText("");
        jSenha.setText("");
        jSenhaConf.setText("");
        //Botões
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(false);
        jBtExcluir.setEnabled(false);
        jBtSalvar.setEnabled(false);
        jBtSair.setEnabled(true);
        jBtCancelar.setEnabled(true);
        // Habilitar os campos
        jComboBoxStatus.setEnabled(!true);
        jNomeUsuarioCompleto.setEnabled(!true);
        jDataCadastro.setEnabled(!true);
        jComboBoxDepartamento.setEnabled(!true);
        jComboBoxCargo.setEnabled(!true);
        jComboBoxAcessaTodasUnidades.setEnabled(!true);
        jlogin.setEnabled(!true);
        jSenha.setEnabled(!true);
        jSenhaConf.setEnabled(!true);
    }

    public void Salvar() {
        // Habilitar os campos
        jComboBoxStatus.setEnabled(!true);
        jNomeUsuarioCompleto.setEnabled(!true);
        jDataCadastro.setEnabled(!true);
        jComboBoxDepartamento.setEnabled(!true);
        jComboBoxCargo.setEnabled(!true);
        jComboBoxAcessaTodasUnidades.setEnabled(!true);
        jlogin.setEnabled(!true);
        jSenha.setEnabled(!true);
        jSenhaConf.setEnabled(!true);
        //
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
        //
        jBtNovoGrupo.setEnabled(true);
        jBtNovoModulo.setEnabled(true);
    }

    public void Cancela() {
        if (IdUsuario.getText().equals("")) {
            jComboBoxStatus.setEnabled(!true);
            jNomeUsuarioCompleto.setEnabled(!true);
            jDataCadastro.setEnabled(!true);
            jComboBoxDepartamento.setEnabled(!true);
            jComboBoxCargo.setEnabled(!true);
            jComboBoxAcessaTodasUnidades.setEnabled(!true);
            jlogin.setEnabled(!true);
            jSenha.setEnabled(!true);
            jSenhaConf.setEnabled(!true);
            // Habilta os botões de manutenção
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(!true);
            jBtExcluir.setEnabled(!true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
        } else {
            // Habilita os campos        
            jComboBoxStatus.setEnabled(!true);
            jNomeUsuarioCompleto.setEnabled(!true);
            jDataCadastro.setEnabled(!true);
            jComboBoxDepartamento.setEnabled(!true);
            jComboBoxCargo.setEnabled(!true);
            jComboBoxAcessaTodasUnidades.setEnabled(!true);
            jlogin.setEnabled(!true);
            jSenha.setEnabled(!true);
            jSenhaConf.setEnabled(!true);
            // Habilta os botões de manutenção
            jBtNovo.setEnabled(true);
            jBtAlterar.setEnabled(true);
            jBtExcluir.setEnabled(true);
            jBtSalvar.setEnabled(!true);
            jBtCancelar.setEnabled(!true);
            //
            jBtNovoGrupo.setEnabled(true);
            jBtNovoModulo.setEnabled(true);
        }
    }

    public void buscarID() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS");
            conecta.rs.last();
            IdUsuario.setText(conecta.rs.getString("IdUsuario"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível obter o código do usuário.\nERRO: " + ex);
        }
    }

    public void NovoGrupo() {
        jCodigoGrupo.setText("");
        jDescricaoGrupo.setText("");
        //
        jBtPesDepto.setEnabled(true);
        //
        jBtNovoGrupo.setEnabled(!true);
        jBtAlterarGrupo.setEnabled(!true);
        jBtExcluirGrupo.setEnabled(!true);
        jBtSalvarGrupo.setEnabled(true);
        jBtCancelarGrupo.setEnabled(true);
        //
        jComboBoxStatus.setEnabled(!true);
        jNomeUsuarioCompleto.setEnabled(!true);
        jDataCadastro.setEnabled(!true);
        jComboBoxDepartamento.setEnabled(!true);
        jComboBoxCargo.setEnabled(!true);
        jlogin.setEnabled(!true);
        jSenha.setEnabled(!true);
        jSenhaConf.setEnabled(!true);
        // Habilta os botões de manutenção
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
    }

    public void AlterarGrupo() {
        jBtPesDepto.setEnabled(true);
        //
        jBtNovoGrupo.setEnabled(!true);
        jBtAlterarGrupo.setEnabled(!true);
        jBtExcluirGrupo.setEnabled(!true);
        jBtSalvarGrupo.setEnabled(true);
        jBtCancelarGrupo.setEnabled(true);
        //
        jComboBoxStatus.setEnabled(!true);
        jNomeUsuarioCompleto.setEnabled(!true);
        jDataCadastro.setEnabled(!true);
        jComboBoxDepartamento.setEnabled(!true);
        jComboBoxCargo.setEnabled(!true);
        jlogin.setEnabled(!true);
        jSenha.setEnabled(!true);
        jSenhaConf.setEnabled(!true);
        // Habilta os botões de manutenção
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
    }

    public void ExcluirGrupo() {
        jCodigoGrupo.setText("");
        jDescricaoGrupo.setText("");
        //
        jBtPesDepto.setEnabled(!true);
        //
        jBtNovoGrupo.setEnabled(true);
        jBtAlterarGrupo.setEnabled(!true);
        jBtExcluirGrupo.setEnabled(!true);
        jBtSalvarGrupo.setEnabled(!true);
        jBtCancelarGrupo.setEnabled(!true);
        //
        jComboBoxStatus.setEnabled(!true);
        jNomeUsuarioCompleto.setEnabled(!true);
        jDataCadastro.setEnabled(!true);
        jComboBoxDepartamento.setEnabled(!true);
        jComboBoxCargo.setEnabled(!true);
        jlogin.setEnabled(!true);
        jSenha.setEnabled(!true);
        jSenhaConf.setEnabled(!true);
        // Habilta os botões de manutenção
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
    }

    public void SalvarGrupo() {
        jBtPesDepto.setEnabled(!true);
        //
        jBtNovoGrupo.setEnabled(true);
        jBtAlterarGrupo.setEnabled(!true);
        jBtExcluirGrupo.setEnabled(!true);
        jBtSalvarGrupo.setEnabled(!true);
        jBtCancelarGrupo.setEnabled(!true);
        //
        jComboBoxStatus.setEnabled(!true);
        jNomeUsuarioCompleto.setEnabled(!true);
        jDataCadastro.setEnabled(!true);
        jComboBoxDepartamento.setEnabled(!true);
        jComboBoxCargo.setEnabled(!true);
        jlogin.setEnabled(!true);
        jSenha.setEnabled(!true);
        jSenhaConf.setEnabled(!true);
        // Habilta os botões de manutenção
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
    }

    public void CancelarGrupo() {
        jCodigoGrupo.setText("");
        jDescricaoGrupo.setText("");
        //
        jBtPesDepto.setEnabled(!true);
        //
        jBtNovoGrupo.setEnabled(true);
        jBtAlterarGrupo.setEnabled(!true);
        jBtExcluirGrupo.setEnabled(!true);
        jBtSalvarGrupo.setEnabled(!true);
        jBtCancelarGrupo.setEnabled(!true);
        //
        jComboBoxStatus.setEnabled(!true);
        jNomeUsuarioCompleto.setEnabled(!true);
        jDataCadastro.setEnabled(!true);
        jComboBoxDepartamento.setEnabled(!true);
        jComboBoxCargo.setEnabled(!true);
        jlogin.setEnabled(!true);
        jSenha.setEnabled(!true);
        jSenhaConf.setEnabled(!true);
        // Habilta os botões de manutenção
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
    }

    public void NovoModulo() {
        jCodigoModulo.setText("");
        jComboBoxPermissaoModulo.setSelectedItem("Não");
        jComboBoxGrupoModulo.setSelectedItem("Selecione");
        jDescricaoModulo.setText("");
        //
        jComboBoxPermissaoModulo.setEnabled(true);
        jComboBoxGrupoModulo.setEnabled(true);
        jBtPesqModulo.setEnabled(true);
        //
        jBtNovoModulo.setEnabled(!true);
        jBtAlterarModulo.setEnabled(!true);
        jBtExcluirModulo.setEnabled(!true);
        jBtSalvarModulo.setEnabled(true);
        jBtCancelarModulo.setEnabled(true);
        //
        jBtPesDepto.setEnabled(!true);
        //
        jBtNovoGrupo.setEnabled(!true);
        jBtAlterarGrupo.setEnabled(!true);
        jBtExcluirGrupo.setEnabled(!true);
        jBtSalvarGrupo.setEnabled(!true);
        jBtCancelarGrupo.setEnabled(!true);
        //
        jComboBoxStatus.setEnabled(!true);
        jNomeUsuarioCompleto.setEnabled(!true);
        jDataCadastro.setEnabled(!true);
        jComboBoxDepartamento.setEnabled(!true);
        jComboBoxCargo.setEnabled(!true);
        jlogin.setEnabled(!true);
        jSenha.setEnabled(!true);
        jSenhaConf.setEnabled(!true);
        // Habilta os botões de manutenção
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
    }

    public void AlterarModulo() {
        jComboBoxPermissaoModulo.setEnabled(true);
        jComboBoxGrupoModulo.setEnabled(true);
        jBtPesqModulo.setEnabled(true);
        //
        jBtNovoModulo.setEnabled(!true);
        jBtAlterarModulo.setEnabled(!true);
        jBtExcluirModulo.setEnabled(!true);
        jBtSalvarModulo.setEnabled(true);
        jBtCancelarModulo.setEnabled(true);
        //
        jBtPesDepto.setEnabled(!true);
        //
        jBtNovoGrupo.setEnabled(!true);
        jBtAlterarGrupo.setEnabled(!true);
        jBtExcluirGrupo.setEnabled(!true);
        jBtSalvarGrupo.setEnabled(!true);
        jBtCancelarGrupo.setEnabled(!true);
        //
        jComboBoxStatus.setEnabled(!true);
        jNomeUsuarioCompleto.setEnabled(!true);
        jDataCadastro.setEnabled(!true);
        jComboBoxDepartamento.setEnabled(!true);
        jComboBoxCargo.setEnabled(!true);
        jlogin.setEnabled(!true);
        jSenha.setEnabled(!true);
        jSenhaConf.setEnabled(!true);
        // Habilta os botões de manutenção
        jBtNovo.setEnabled(!true);
        jBtAlterar.setEnabled(!true);
        jBtExcluir.setEnabled(!true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(!true);
    }

    public void ExcluirModulo() {
        jCodigoModulo.setText("");
        jComboBoxPermissaoModulo.setSelectedItem("Não");
        jComboBoxGrupoModulo.setSelectedItem("Selecione");
        jDescricaoModulo.setText("");
        //
        jComboBoxPermissaoModulo.setEnabled(!true);
        jComboBoxGrupoModulo.setEnabled(!true);
        jBtPesqModulo.setEnabled(!true);
        //
        jBtNovoModulo.setEnabled(true);
        jBtAlterarModulo.setEnabled(!true);
        jBtExcluirModulo.setEnabled(!true);
        jBtSalvarModulo.setEnabled(!true);
        jBtCancelarModulo.setEnabled(!true);
        //
        jBtPesDepto.setEnabled(!true);
        //
        jBtNovoGrupo.setEnabled(true);
        jBtAlterarGrupo.setEnabled(!true);
        jBtExcluirGrupo.setEnabled(!true);
        jBtSalvarGrupo.setEnabled(!true);
        jBtCancelarGrupo.setEnabled(!true);
        //
        jComboBoxStatus.setEnabled(!true);
        jNomeUsuarioCompleto.setEnabled(!true);
        jDataCadastro.setEnabled(!true);
        jComboBoxDepartamento.setEnabled(!true);
        jComboBoxCargo.setEnabled(!true);
        jlogin.setEnabled(!true);
        jSenha.setEnabled(!true);
        jSenhaConf.setEnabled(!true);
        // Habilta os botões de manutenção
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
    }

    public void SalvarModulo() {
        jCodigoModulo.setText("");
        jComboBoxPermissaoModulo.setSelectedItem("Não");
        jComboBoxGrupoModulo.setSelectedItem("Selecione");
        jDescricaoModulo.setText("");
        //
        jComboBoxPermissaoModulo.setEnabled(!true);
        jComboBoxGrupoModulo.setEnabled(!true);
        jBtPesqModulo.setEnabled(!true);
        //
        jBtNovoModulo.setEnabled(true);
        jBtAlterarModulo.setEnabled(!true);
        jBtExcluirModulo.setEnabled(!true);
        jBtSalvarModulo.setEnabled(!true);
        jBtCancelarModulo.setEnabled(!true);
        //
        jBtPesDepto.setEnabled(!true);
        //
        jBtNovoGrupo.setEnabled(true);
        jBtAlterarGrupo.setEnabled(!true);
        jBtExcluirGrupo.setEnabled(!true);
        jBtSalvarGrupo.setEnabled(!true);
        jBtCancelarGrupo.setEnabled(!true);
        // Habilta os botões de manutenção
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
    }

    public void CancelarModulo() {
        jCodigoModulo.setText("");
        jComboBoxPermissaoModulo.setSelectedItem("Não");
        jComboBoxGrupoModulo.setSelectedItem("Selecione");
        jDescricaoModulo.setText("");
        //
        jComboBoxPermissaoModulo.setEnabled(!true);
        jComboBoxGrupoModulo.setEnabled(!true);
        jBtPesqModulo.setEnabled(!true);
        //
        jBtNovoModulo.setEnabled(true);
        jBtAlterarModulo.setEnabled(!true);
        jBtExcluirModulo.setEnabled(!true);
        jBtSalvarModulo.setEnabled(!true);
        jBtCancelarModulo.setEnabled(!true);
        //
        jBtPesDepto.setEnabled(!true);
        //
        jBtNovoGrupo.setEnabled(true);
        jBtAlterarGrupo.setEnabled(!true);
        jBtExcluirGrupo.setEnabled(!true);
        jBtSalvarGrupo.setEnabled(!true);
        jBtCancelarGrupo.setEnabled(!true);
        // Habilta os botões de manutenção
        jBtNovo.setEnabled(true);
        jBtAlterar.setEnabled(true);
        jBtExcluir.setEnabled(true);
        jBtSalvar.setEnabled(!true);
        jBtCancelar.setEnabled(true);
    }

    public void NovoAcesso() {
        jNomeUsuarioAcesso.setText(jNomeUsuarioCompleto.getText());
        jComboBoxModuloAcesso.setEnabled(true);
        jComboBoxTelaAcesso.setEnabled(true);
        //
        jComboBoxAbrir.setEnabled(true);
        jComboBoxIncluir.setEnabled(true);
        jComboBoxAlterar.setEnabled(true);
        jComboBoxExcluir.setEnabled(true);
        jComboBoxGravar.setEnabled(true);
        jComboBoxConsultar.setEnabled(true);
        jBtCopiarPerfil.setEnabled(true);
        //
        jBtNovoAcesso.setEnabled(!true);
        jBtAlterarAcesso.setEnabled(!true);
        jBtExcluirAcesso.setEnabled(!true);
        jBtSalvarAcesso.setEnabled(true);
        jBtCancelarAcesso.setEnabled(true);
        //
        jBtPesquisarModulo.setEnabled(true);
        jBtCopiarPerfil.setEnabled(!true);
    }

    public void AlterarAcesso() {
        jComboBoxModuloAcesso.setEnabled(true);
        jComboBoxTelaAcesso.setEnabled(true);
        //
        jComboBoxAbrir.setEnabled(true);
        jComboBoxIncluir.setEnabled(true);
        jComboBoxAlterar.setEnabled(true);
        jComboBoxExcluir.setEnabled(true);
        jComboBoxGravar.setEnabled(true);
        jComboBoxConsultar.setEnabled(true);
        //
        jBtNovoAcesso.setEnabled(!true);
        jBtAlterarAcesso.setEnabled(!true);
        jBtExcluirAcesso.setEnabled(!true);
        jBtSalvarAcesso.setEnabled(true);
        jBtCancelarAcesso.setEnabled(true);
        //
        jBtPesquisarModulo.setEnabled(true);
        jBtCopiarPerfil.setEnabled(!true);
    }

    public void ExcluirAcesso() {
        jComboBoxModuloAcesso.setEnabled(!true);
        jComboBoxTelaAcesso.setEnabled(!true);
        //
        jComboBoxAbrir.setEnabled(!true);
        jComboBoxIncluir.setEnabled(!true);
        jComboBoxAlterar.setEnabled(!true);
        jComboBoxExcluir.setEnabled(!true);
        jComboBoxGravar.setEnabled(!true);
        jComboBoxConsultar.setEnabled(!true);
        //
        jBtNovoAcesso.setEnabled(true);
        jBtAlterarAcesso.setEnabled(!true);
        jBtExcluirAcesso.setEnabled(!true);
        jBtSalvarAcesso.setEnabled(!true);
        jBtCancelarAcesso.setEnabled(!true);
        //
        jBtPesquisarModulo.setEnabled(!true);
        jBtCopiarPerfil.setEnabled(!true);
    }

    public void SalvarAcesso() {
        jComboBoxModuloAcesso.setEnabled(!true);
        jComboBoxTelaAcesso.setEnabled(!true);
        //
        jComboBoxAbrir.setEnabled(!true);
        jComboBoxIncluir.setEnabled(!true);
        jComboBoxAlterar.setEnabled(!true);
        jComboBoxExcluir.setEnabled(!true);
        jComboBoxGravar.setEnabled(!true);
        jComboBoxConsultar.setEnabled(!true);
        //
        jBtNovoAcesso.setEnabled(true);
        jBtAlterarAcesso.setEnabled(true);
        jBtExcluirAcesso.setEnabled(!true);
        jBtSalvarAcesso.setEnabled(!true);
        jBtCancelarAcesso.setEnabled(!true);
        //
        jBtPesquisarModulo.setEnabled(!true);
        jBtCopiarPerfil.setEnabled(true);
    }

    public void CancelarAcesso() {
        jComboBoxModuloAcesso.setEnabled(!true);
        jComboBoxTelaAcesso.setEnabled(!true);
        //
        jComboBoxAbrir.setEnabled(!true);
        jComboBoxIncluir.setEnabled(!true);
        jComboBoxAlterar.setEnabled(!true);
        jComboBoxExcluir.setEnabled(!true);
        jComboBoxGravar.setEnabled(!true);
        jComboBoxConsultar.setEnabled(!true);
        //
        jBtNovoAcesso.setEnabled(true);
        jBtAlterarAcesso.setEnabled(!true);
        jBtExcluirAcesso.setEnabled(!true);
        jBtSalvarAcesso.setEnabled(!true);
        jBtCancelarAcesso.setEnabled(!true);
        //
        jBtPesquisarModulo.setEnabled(!true);
        Integer rows = jTabelaAcessos.getModel().getRowCount();
        if (rows != 0) {
            jBtCopiarPerfil.setEnabled(true);
        }
    }

    //PESQUISA O CÓDIGO DO MÓDULO DO USUÁRIO
    public void pesquisarModuloUsuarios() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                    + "WHERE IdUsuario='" + IdUsuario.getText() + "'");
            conecta.rs.first();
            codigoModulo = conecta.rs.getInt("IdModulo");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    public void pesquisarModulo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM MODULOS "
                    + "WHERE IdModulo='" + codigoModulo + "'");
            conecta.rs.first();
            do {
                jComboBoxModuloAcesso.setText(conecta.rs.getString("NomeModulo"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    public void pesquisarTelaAcesso() {
        jComboBoxTelaAcesso.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TELAS "
                    + "WHERE IdModulo='" + jIdModulo.getText() + "'");
            conecta.rs.first();
            do {
                jComboBoxTelaAcesso.addItem(conecta.rs.getString("NomeTela"));
            } while (conecta.rs.next());
            jComboBoxTelaAcesso.updateUI();
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    public void preencherComboDepartamento() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS ORDER BY NomeDepartamento");
            conecta.rs.first();
            do {
                jComboBoxDepartamento.addItem(conecta.rs.getString("NomeDepartamento"));
            } while (conecta.rs.next());
            jComboBoxDepartamento.updateUI();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void preencherComboCargo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM CARGOS ORDER BY NomeCargo");
            conecta.rs.first();
            do {
                jComboBoxCargo.addItem(conecta.rs.getString("NomeCargo"));
            } while (conecta.rs.next());
            jComboBoxCargo.updateUI();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void preencherComboBoxGrupo() {
        jComboBoxGrupoModulo.removeAllItems();
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE USUARIOS_GRUPOS.IdUsuario='" + IdUsuario.getText() + "'");
            conecta.rs.first();
            do {
                jComboBoxGrupoModulo.addItem(conecta.rs.getString("NomeGrupo"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados a serem exibidos !!!");
        }
        conecta.desconecta();
    }

    public void verificarUsuarioGrupo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "WHERE IdUsuario='" + IdUsuario.getText() + "'");
            conecta.rs.first();
            codigoUsuarioGrupo = conecta.rs.getString("IdUsuario");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarGrupoCadastrado() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS");
            conecta.rs.first();
            codigoUserGrupo = conecta.rs.getString("IdGrupo");
            codigoUsuarioGrupoNovo = conecta.rs.getString("IdUsuario");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarGrupoModulo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                    + "WHERE IdGrupo='" + jCodigoGrupo.getText() + "'");
            conecta.rs.first();
            codigoGrupoModulo = conecta.rs.getString("IdGrupo");
            codigoUserDel = conecta.rs.getString("IdUsuario");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void pesquisarTodos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Status", "Nome Completo do Usuário", "Login", "Nome Departamento"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                statusUser = conecta.rs.getInt("StatusUsuario");
                if (statusUser == 0) {
                    statusNome = "Inativo";
                } else if (statusUser == 1) {
                    statusNome = "Ativo";
                }
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdUsuario"), statusNome, conecta.rs.getString("NomeUsuario"), conecta.rs.getString("LoginUsuario"), conecta.rs.getString("NomeDepartamento")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS !!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaUsuarios.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA  
        jTabelaUsuarios.setModel(modelo);
        jTabelaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaUsuarios.getColumnModel().getColumn(0).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTabelaUsuarios.getColumnModel().getColumn(1).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaUsuarios.getColumnModel().getColumn(2).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTabelaUsuarios.getColumnModel().getColumn(3).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTabelaUsuarios.getColumnModel().getColumn(4).setResizable(false);
        jTabelaUsuarios.getTableHeader().setReorderingAllowed(false);
        jTabelaUsuarios.setAutoResizeMode(jTabelaUsuarios.AUTO_RESIZE_OFF);
        jTabelaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaUsuario();
        conecta.desconecta();
    }

    public void preencherTabelaNome(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Status", "Nome Completo do Usuário", "Login", "Nome Departamento"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                statusUser = conecta.rs.getInt("StatusUsuario");
                if (statusUser == 0) {
                    statusNome = "Inativo";
                } else if (statusUser == 1) {
                    statusNome = "Ativo";
                }
                jtotalRegistros.setText(Integer.toString(count)); // Converter inteiro em string para exibir na tela
                dados.add(new Object[]{conecta.rs.getInt("IdUsuario"), statusNome, conecta.rs.getString("NomeUsuario"), conecta.rs.getString("LoginUsuario"), conecta.rs.getString("NomeDepartamento")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Dados não encontrado, use o botão TODOS \nPara pesquisar TODOS OS REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaUsuarios.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA  
        jTabelaUsuarios.setModel(modelo);
        jTabelaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaUsuarios.getColumnModel().getColumn(0).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTabelaUsuarios.getColumnModel().getColumn(1).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaUsuarios.getColumnModel().getColumn(2).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTabelaUsuarios.getColumnModel().getColumn(3).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTabelaUsuarios.getColumnModel().getColumn(4).setResizable(false);
        jTabelaUsuarios.getTableHeader().setReorderingAllowed(false);
        jTabelaUsuarios.setAutoResizeMode(jTabelaUsuarios.AUTO_RESIZE_OFF);
        jTabelaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaUsuario();
        conecta.desconecta();
    }

    public void limparTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Status", "Nome Completo do Usuário", "Login", "Nome Departamento"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaUsuarios.setRowSorter(new TableRowSorter(modelo)); //FAZER ORDENAMENTO NA TABLEA  
        jTabelaUsuarios.setModel(modelo);
        jTabelaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaUsuarios.getColumnModel().getColumn(0).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTabelaUsuarios.getColumnModel().getColumn(1).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTabelaUsuarios.getColumnModel().getColumn(2).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTabelaUsuarios.getColumnModel().getColumn(3).setResizable(false);
        jTabelaUsuarios.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTabelaUsuarios.getColumnModel().getColumn(4).setResizable(false);
        jTabelaUsuarios.getTableHeader().setReorderingAllowed(false);
        jTabelaUsuarios.setAutoResizeMode(jTabelaUsuarios.AUTO_RESIZE_OFF);
        jTabelaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaUsuario() {
        //
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaUsuarios.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaUsuarios.getColumnModel().getColumn(1).setCellRenderer(centralizado);
    }

    public void preencherTabelaGrupos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Grupo"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdUserGroup"), conecta.rs.getInt("IdGrupo"), conecta.rs.getString("NomeGrupo")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaGrupo.setModel(modelo);
        jTabelaGrupo.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaGrupo.getColumnModel().getColumn(0).setResizable(false);
        jTabelaGrupo.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaGrupo.getColumnModel().getColumn(1).setResizable(false);
        jTabelaGrupo.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaGrupo.getColumnModel().getColumn(2).setResizable(false);
        jTabelaGrupo.getTableHeader().setReorderingAllowed(false);
        jTabelaGrupo.setAutoResizeMode(jTabelaGrupo.AUTO_RESIZE_OFF);
        jTabelaGrupo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaGrupo();
        conecta.desconecta();
    }

    public void limparTabelaGrupo() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Grupo"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaGrupo.setModel(modelo);
        jTabelaGrupo.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaGrupo.getColumnModel().getColumn(0).setResizable(false);
        jTabelaGrupo.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaGrupo.getColumnModel().getColumn(1).setResizable(false);
        jTabelaGrupo.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTabelaGrupo.getColumnModel().getColumn(2).setResizable(false);
        jTabelaGrupo.getTableHeader().setReorderingAllowed(false);
        jTabelaGrupo.setAutoResizeMode(jTabelaGrupo.AUTO_RESIZE_OFF);
        jTabelaGrupo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaGrupo() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaGrupo.getColumnModel().getColumn(0).setCellRenderer(centralizado);
    }

    public void preencherTabelaModulos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Modulo", "Permissão"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("IdMod"), conecta.rs.getInt("IdModulo"), conecta.rs.getString("NomeModulo"), conecta.rs.getString("Permissao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaModulos.setModel(modelo);
        jTabelaModulos.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaModulos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaModulos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaModulos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaModulos.getColumnModel().getColumn(2).setPreferredWidth(270);
        jTabelaModulos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaModulos.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTabelaModulos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaModulos.getTableHeader().setReorderingAllowed(false);
        jTabelaModulos.setAutoResizeMode(jTabelaModulos.AUTO_RESIZE_OFF);
        jTabelaModulos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaModulo();
        conecta.desconecta();
    }

    public void limparTabelaModulos() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Item", "Código", "Nome do Modulo", "Permissão"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaModulos.setModel(modelo);
        jTabelaModulos.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTabelaModulos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaModulos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaModulos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaModulos.getColumnModel().getColumn(2).setPreferredWidth(280);
        jTabelaModulos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaModulos.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTabelaModulos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaModulos.getTableHeader().setReorderingAllowed(false);
        jTabelaModulos.setAutoResizeMode(jTabelaModulos.AUTO_RESIZE_OFF);
        jTabelaModulos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void alinharCamposTabelaModulo() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaModulos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaModulos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaModulos.getColumnModel().getColumn(3).setCellRenderer(centralizado);
    }

    public void limparTabelaAcessos() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Tela", "Abrir", "Incluir", "Alterar", "Excluir", "Gravar", "Consultar"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAcessos.setModel(modelo);
        jTabelaAcessos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAcessos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(1).setPreferredWidth(400);
        jTabelaAcessos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTabelaAcessos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTabelaAcessos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(4).setPreferredWidth(60);
        jTabelaAcessos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(5).setPreferredWidth(60);
        jTabelaAcessos.getColumnModel().getColumn(5).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(6).setPreferredWidth(60);
        jTabelaAcessos.getColumnModel().getColumn(6).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(7).setPreferredWidth(60);
        jTabelaAcessos.getColumnModel().getColumn(7).setResizable(false);
        jTabelaAcessos.getTableHeader().setReorderingAllowed(false);
        jTabelaAcessos.setAutoResizeMode(jTabelaAcessos.AUTO_RESIZE_OFF);
        jTabelaAcessos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo.getLinhas().clear();
    }

    public void preencherTabelaAcessos(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Tela", "Abrir", "Incluir", "Alterar", "Excluir", "Gravar", "Consultar"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                pAbrir = conecta.rs.getInt("Abrir");
                if (pAbrir == 0) {
                    pAbrirAcesso = "Não";
                } else if (pAbrir == 1) {
                    pAbrirAcesso = "Sim";
                }
                pIncluir = conecta.rs.getInt("Incluir");
                if (pIncluir == 0) {
                    pIncluirAcesso = "Não";
                } else if (pIncluir == 1) {
                    pIncluirAcesso = "Sim";
                }
                pAlterar = conecta.rs.getInt("Alterar");
                if (pAlterar == 0) {
                    pAlterarAcesso = "Não";
                } else if (pAlterar == 1) {
                    pAlterarAcesso = "Sim";
                }
                pExcluir = conecta.rs.getInt("Excluir");
                if (pExcluir == 0) {
                    pExcluirAcesso = "Não";
                } else if (pExcluir == 1) {
                    pExcluirAcesso = "Sim";
                }
                pGravar = conecta.rs.getInt("Gravar");
                if (pGravar == 0) {
                    pGravarAcesso = "Não";
                } else if (pGravar == 1) {
                    pGravarAcesso = "Sim";
                }
                pConsultar = conecta.rs.getInt("Consultar");
                if (pConsultar == 0) {
                    pConsultarAcesso = "Não";
                } else if (pConsultar == 1) {
                    pConsultarAcesso = "Sim";
                }
                dados.add(new Object[]{conecta.rs.getString("IdTela"), conecta.rs.getString("NomeTela"), pAbrirAcesso, pIncluirAcesso, pAlterarAcesso, pExcluirAcesso, pGravarAcesso, pConsultarAcesso});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAcessos.setModel(modelo);
        jTabelaAcessos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAcessos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(1).setPreferredWidth(400);
        jTabelaAcessos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTabelaAcessos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTabelaAcessos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(4).setPreferredWidth(60);
        jTabelaAcessos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(5).setPreferredWidth(60);
        jTabelaAcessos.getColumnModel().getColumn(5).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(6).setPreferredWidth(60);
        jTabelaAcessos.getColumnModel().getColumn(6).setResizable(false);
        jTabelaAcessos.getColumnModel().getColumn(7).setPreferredWidth(60);
        jTabelaAcessos.getColumnModel().getColumn(7).setResizable(false);
        jTabelaAcessos.getTableHeader().setReorderingAllowed(false);
        jTabelaAcessos.setAutoResizeMode(jTabelaAcessos.AUTO_RESIZE_OFF);
        jTabelaAcessos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabelaAcessos();
        conecta.desconecta();
    }

    public void alinharCamposTabelaAcessos() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //       
        jTabelaAcessos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAcessos.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaAcessos.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        jTabelaAcessos.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        jTabelaAcessos.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        jTabelaAcessos.getColumnModel().getColumn(6).setCellRenderer(centralizado);
        jTabelaAcessos.getColumnModel().getColumn(7).setCellRenderer(centralizado);
    }

    public void editarCelulas() {

//        jTabelaAcessos.isCellEditable(dados, Colunas);
        jTabelaAcessos.isCellEditable(1, 1);
        jTabelaAcessos.isCellEditable(2, 2);
        jTabelaAcessos.isCellEditable(3, 3);
        jTabelaAcessos.isCellEditable(4, 4);
        jTabelaAcessos.isCellEditable(5, 5);
        jTabelaAcessos.isCellEditable(6, 6);
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(IdUsuario.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog1() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela1);
        objLogSys.setIdLancMov(Integer.valueOf(IdUsuario.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void objLog2() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela2);
        objLogSys.setIdLancMov(Integer.valueOf(IdUsuario.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void verificarTelaAcesso() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM TELAS_ACESSO "
                    + "WHERE NomeTela='" + jComboBoxTelaAcesso.getSelectedItem() + "' "
                    + "AND IdUsuario='" + IdUsuario.getText() + "'");
            conecta.rs.first();
            nomeTelaUsuario = conecta.rs.getString("NomeTela");
            codigoUsuario = conecta.rs.getString("IdUsuario");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
