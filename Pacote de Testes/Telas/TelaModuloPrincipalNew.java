/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

//import gestor.Modelo.clsDataHora;
import gestor.Visao.*;
import gestor.Controle.ControleUsuarioConectado;
import gestor.Dao.ConexaoBancoDados;
import static gestor.Dao.ConexaoBancoDados.Computer;
import gestor.Modelo.UsuarioConectado;
import static gestor.Visao.TelaLoginSenha.descricaoUnidade;
import static gestor.Visao.TelaLoginSenha.idUserAcesso;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloBaseDois.LocacaoInternosBpa;
import static gestor.Visao.TelaModuloBaseDois.PavilhaoCelaBpa;
import static gestor.Visao.TelaModuloBaseDois.PopulacaoInternosAgentesBpa;
import static gestor.Visao.TelaModuloBaseDois.TransferenciaPavilhaoCelasBpa;
import static gestor.Visao.TelaModuloBaseUm.LocacaoInternos;
import static gestor.Visao.TelaModuloBaseUm.PavilhaoCela;
import static gestor.Visao.TelaModuloBaseUm.PopulacaoInternosAgentes;
import static gestor.Visao.TelaModuloBaseUm.TransferenciaPavilhaoCelas;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import org.opencv.core.Core;

/**
 *
 * @author Ronaldo
 */
// Inicio do desenvolvimento 20/03/2014
public class TelaModuloPrincipalNew extends javax.swing.JFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    UsuarioConectado userConectado = new UsuarioConectado();
    ControleUsuarioConectado control = new ControleUsuarioConectado();
    JProgressBar barraProgesso = new JProgressBar();
    public static String hostName;
    public static String ipHost;
    public static String usuarioConectado = "Conectado";
    public static String usuarioDesconectado = "Desconectado";
    String statusFlag = "Sim";
    String idUser;
    // VARIAVEIS PARA PERMISSÃO DE USUÁRIOS NOS MÓDULOS
    String loginUsusario = "ADMINISTRADOR DO SISTEMA";
    String nomeUsuario = "";
    String nomeGrupo = "";
    //GRUPO DE ADMINISTRADORES E DIRETORORES
    public static String grupoAdministrador = "ADMINISTRADORES";
    public static String grupoDiretores = "DIRETORES"; // AINDA NÃO FOI CRIADO A FUNCIONALIDADE (16/07/2016)
    String nomeModulo = "";
    String permissaoModulo = "";
    int idGrupo;
    int idModulo;
    int idGrupoModulo;
    // VARIAVEIS DE PARAMETRO PARAEXIBIÇÃO DE FUNCIONALIDADES DO BGP
    public static String parametroPopulcao;
    public static String parametroLocacao;
    public static String parametroTransferencia;
    public static String parametroPavilhao;
    //
    public static String parametroPopulcaoBpa;
    public static String parametroLocacaoBpa;
    public static String parametroTransferenciaBpa;
    public static String parametroPavilhaoBpa;
    //
//seuFrame.setTitle("Novo Título");
    // Capturar data e hora do sistema
    //  clsDataHora objDataHora = new clsDataHora();
    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss"); // HORAIO DE 24 HORAS, PARA O DE 12 HORAS UTILIZAR hh:mm:ss
    SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
    String moduloDiretor = "DIRETORES"; // Acesso igual ao administrador, menos o módulo configuração
    // Verificar essa consulta para liberar o modulo e depois as telas
    //SELECT NomeUsuario, GRUPOUSUARIOS.IdGrupo,NomeGrupo,ACESSOS.Permissao FROM ACESSOS INNER JOIN GRUPOUSUARIOS ON ACESSOS.IdGrupo=GRUPOUSUARIOS.IdGrupo INNER JOIN USUARIOS ON GRUPOUSUARIOS.IdGrupo=USUARIOS.IdGrupo WHERE NomeGrupo='CRC'
    public static TelaTrocaSenha telaTrocaSenha;
    
    /**
     * Creates new form TelaPrincipal
     *
     * @param user
     * @param username
     */
    // Informa para classe principal o usuário logado no sistema
    public TelaModuloPrincipalNew(String user, String username) {
        super();
        //  setResizable(false); // FOI RETIRADO POR QUE ESTAVA EM CIMA DA BARRA DE TAREFAS.
        initComponents();
        // NOME DA UNIDADE ONDE O SISTEMA ESTA ATUANDO, IRÁ PARA OS RELATÓRIOS TAMBÉM.
        jNomeUnidade.setText(descricaoUnidade);
        // SISTEMA OPERACIONAL DO COMPUTADOR
        jLabel6.setText(Computer);
        //Informa ususario logado no sistema (Nome)
        jLoginConectado.setText(nameUser);
        setExtendedState(MAXIMIZED_BOTH); // Maximnizar a tela prinicpal
        Thread threadRelogio = new Thread() {

            @Override
            public void run() {
                rodaRelogio();
            }
        };
        threadRelogio.start();
        // Verificar os usuários e computadores contectados no sistema
        buscarIpNome(); // Pega o ip e o nome do host conectado
        Date data = new Date();
        String hora = formatter.format(data); // Data da conexão
        String date = formatter2.format(data); // Hora da conexão
        jLabel10.setText(ipHost);
        jHoraSistema.setText(String.valueOf(hora));    // no lugar do label, por seu JTextField    
        jDataSistema.setText(String.valueOf(date));
        userConectado.setDataPlugado(jDataSistema.getText());
        userConectado.setHorarioPlugado(jHoraSistema.getText());
        userConectado.setNomeUsuario(nameUser);
        userConectado.setConectadoDesconectado(usuarioConectado);
        userConectado.setIpHost(ipHost);
        userConectado.setHostName(hostName);
        userConectado.setStatusFlag(statusFlag);
        control.incluirHostName(userConectado);
        //     
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //Impedir que a janela seja fechada pelo X    
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                if (e.getID() == WindowEvent.WINDOW_CLOSING) {
                    int selectedOption = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do Sistema?", "Sistema informa:", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_OPTION) {
                        buscarIdUsuario();
                        statusFlag = "Não";
                        userConectado.setDataDesconectado(jDataSistema.getText());
                        userConectado.setHorarioDesconectado(jHoraSistema.getText());
                        userConectado.setConectadoDesconectado(usuarioDesconectado);
                        userConectado.setStatusFlag(statusFlag);
                        userConectado.setIdUser(Integer.valueOf(idUser));
                        control.desconectarHostName(userConectado);
                        System.exit(0);
                    }
                }
            }
        });
    }    
    public void mostrarTelaTrocaSenha() {
        telaTrocaSenha = new TelaTrocaSenha(this, true);
        telaTrocaSenha.setVisible(true);
    }
// Metodo para executar a data e hora atualizado

    public void rodaRelogio() {
        try {
            while (true) {
                Date data = new Date();
                String hora = formatter.format(data);
                String date = formatter2.format(data);
                jHoraSistema.setText(String.valueOf(hora));    // no lugar do label, por seu JTextField    
                jDataSistema.setText(String.valueOf(date));
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
        }
    }

// Criado pelo java por cusa da String user na ela de loginsenha
    TelaModuloPrincipalNew() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanielPrincipal = new javax.swing.JDesktopPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jHoraSistema = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jNomeUnidade = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jBtLogoff = new javax.swing.JButton();
        jBtSairSistema = new javax.swing.JButton();
        jBtTrocarSenha = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jBtSindicancia = new javax.swing.JButton();
        jToolBar5 = new javax.swing.JToolBar();
        jBtAdmPessoal = new javax.swing.JButton();
        jBtDiretoria = new javax.swing.JButton();
        jBtCRC2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jBtControleValores2 = new javax.swing.JButton();
        jBtAlmoxarifado2 = new javax.swing.JButton();
        jBtCompras = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jBtJuridico2 = new javax.swing.JButton();
        jBtServicoSocial2 = new javax.swing.JButton();
        jBtPedagogia2 = new javax.swing.JButton();
        jBtTerapeuta2 = new javax.swing.JButton();
        jBtPsicologia2 = new javax.swing.JButton();
        jBtOdontologia2 = new javax.swing.JButton();
        jBtServicoMedico2 = new javax.swing.JButton();
        jBtNutricao = new javax.swing.JButton();
        jBtFarmacia = new javax.swing.JButton();
        jBtEducacaoFisica = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jBtSeguranca2 = new javax.swing.JButton();
        jBtPortaria2 = new javax.swing.JButton();
        jBtPortariaExterna = new javax.swing.JButton();
        jBtTriagem = new javax.swing.JButton();
        jBtBasePavilhaoUm = new javax.swing.JButton();
        jBtBasePavilhaoDois = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jBtConfiguracoes2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel3 = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        jLoginConectado = new javax.swing.JLabel();
        jToolBar3 = new javax.swing.JToolBar();
        jDataSistema = new javax.swing.JTextField();
        jToolBar4 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("...::: SISCONP - Sistema de Controle Prisional :::...");
        setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        setForeground(new java.awt.Color(51, 255, 255));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanielPrincipal.setBackground(new java.awt.Color(240, 240, 240));
        jPanielPrincipal.setAutoscrolls(true);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("SISCONP - Sistema de Controle Prisional ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Hora:");

        jHoraSistema.setBackground(new java.awt.Color(240, 240, 240));
        jHoraSistema.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("Versão: 5.9 - BETA");

        jNomeUnidade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jNomeUnidade.setForeground(new java.awt.Color(0, 153, 0));
        jNomeUnidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(jHoraSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNomeUnidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel7))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jNomeUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jHoraSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jBtLogoff.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtLogoff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-32.png"))); // NOI18N
        jBtLogoff.setText("Logoff");
        jBtLogoff.setToolTipText("Fazer logoff");
        jBtLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLogoffActionPerformed(evt);
            }
        });

        jBtSairSistema.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtSairSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-32.png"))); // NOI18N
        jBtSairSistema.setText("Sair");
        jBtSairSistema.setToolTipText("Sair do Sistema");
        jBtSairSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairSistemaActionPerformed(evt);
            }
        });

        jBtTrocarSenha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtTrocarSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Refresh_Icon_32.png"))); // NOI18N
        jBtTrocarSenha.setText("Trocar Senha");
        jBtTrocarSenha.setToolTipText("Trocar Senha");
        jBtTrocarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtTrocarSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtTrocarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtLogoff, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtSairSistema, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtLogoff)
                    .addComponent(jBtSairSistema)
                    .addComponent(jBtTrocarSenha))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtLogoff, jBtSairSistema, jBtTrocarSenha});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(489, 489, 489)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBtSindicancia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtSindicancia.setBorder(null);
        jBtSindicancia.setEnabled(false);
        jBtSindicancia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSindicancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSindicanciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(822, Short.MAX_VALUE)
                .addComponent(jBtSindicancia, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jBtSindicancia, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar5.setRollover(true);

        jBtAdmPessoal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtAdmPessoal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/new-user-group-icone-6256-48.png"))); // NOI18N
        jBtAdmPessoal.setToolTipText("Administração");
        jBtAdmPessoal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAdmPessoal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAdmPessoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdmPessoaljBtTriagemActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtAdmPessoal);

        jBtDiretoria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtDiretoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/system-preferences-icone-5383-48.png"))); // NOI18N
        jBtDiretoria.setToolTipText("Diretoria");
        jBtDiretoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtDiretoria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtDiretoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDiretoriaActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtDiretoria);

        jBtCRC2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtCRC2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/numbers-icone-9065-48.png"))); // NOI18N
        jBtCRC2.setToolTipText("CRC");
        jBtCRC2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCRC2.setMaximumSize(new java.awt.Dimension(64, 64));
        jBtCRC2.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtCRC2.setPreferredSize(new java.awt.Dimension(64, 64));
        jBtCRC2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCRC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCRC2jBtCRCActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtCRC2);
        jToolBar5.add(jSeparator1);

        jBtControleValores2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtControleValores2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/cash-money-purse-wallet-icone-5338-48.png"))); // NOI18N
        jBtControleValores2.setToolTipText("Banco Virtual");
        jBtControleValores2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtControleValores2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtControleValores2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtControleValores2jBtControleValoresActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtControleValores2);

        jBtAlmoxarifado2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtAlmoxarifado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/file-roller-icone-8360-48.png"))); // NOI18N
        jBtAlmoxarifado2.setToolTipText("Almoxarifado");
        jBtAlmoxarifado2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlmoxarifado2.setMaximumSize(new java.awt.Dimension(64, 64));
        jBtAlmoxarifado2.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtAlmoxarifado2.setPreferredSize(new java.awt.Dimension(64, 64));
        jBtAlmoxarifado2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAlmoxarifado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAlmoxarifado2jBtAlmoxarifadoActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtAlmoxarifado2);

        jBtCompras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Full_shopping_cart_Icon_48.png"))); // NOI18N
        jBtCompras.setToolTipText("Compras");
        jBtCompras.setEnabled(false);
        jBtCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCompras.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtComprasjBtVazioActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtCompras);
        jToolBar5.add(jSeparator2);

        jBtJuridico2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtJuridico2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/authors-texts-x-icone-9166-48.png"))); // NOI18N
        jBtJuridico2.setToolTipText("Jurídico");
        jBtJuridico2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtJuridico2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtJuridico2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtJuridico2jBtJuridicoActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtJuridico2);

        jBtServicoSocial2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtServicoSocial2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/dragonplayer-icone-4513-48.png"))); // NOI18N
        jBtServicoSocial2.setToolTipText("Serviço Social");
        jBtServicoSocial2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtServicoSocial2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtServicoSocial2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtServicoSocial2jBtServicoSocialActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtServicoSocial2);

        jBtPedagogia2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtPedagogia2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/composer-preferences-icone-5121-48.png"))); // NOI18N
        jBtPedagogia2.setToolTipText("Pedagogia");
        jBtPedagogia2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtPedagogia2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtPedagogia2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPedagogia2jBtPedagogiaActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtPedagogia2);

        jBtTerapeuta2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtTerapeuta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/terapia ocupacional.png"))); // NOI18N
        jBtTerapeuta2.setToolTipText("Terapia");
        jBtTerapeuta2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtTerapeuta2.setMaximumSize(new java.awt.Dimension(65, 64));
        jBtTerapeuta2.setMinimumSize(new java.awt.Dimension(65, 64));
        jBtTerapeuta2.setPreferredSize(new java.awt.Dimension(64, 64));
        jBtTerapeuta2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtTerapeuta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtTerapeuta2jBtTerapeutaActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtTerapeuta2);

        jBtPsicologia2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtPsicologia2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/PSICOLOGIA_LOGO.jpg"))); // NOI18N
        jBtPsicologia2.setToolTipText("Psicologia");
        jBtPsicologia2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtPsicologia2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtPsicologia2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPsicologia2jBtPsicologiaActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtPsicologia2);

        jBtOdontologia2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtOdontologia2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Temporary_tooth_Icon_48.png"))); // NOI18N
        jBtOdontologia2.setToolTipText("Odontológico");
        jBtOdontologia2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtOdontologia2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtOdontologia2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtOdontologia2jBtOdontologiaActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtOdontologia2);

        jBtServicoMedico2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtServicoMedico2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/nurse.png"))); // NOI18N
        jBtServicoMedico2.setToolTipText("Enfermaria");
        jBtServicoMedico2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtServicoMedico2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtServicoMedico2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtServicoMedico2jBtServicoMedicoActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtServicoMedico2);

        jBtNutricao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtNutricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/NUTRIÇÃO_III_1.jpg"))); // NOI18N
        jBtNutricao.setToolTipText("Nutrição");
        jBtNutricao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNutricao.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNutricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNutricaojBtVazioActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtNutricao);

        jBtFarmacia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtFarmacia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/snake_cup-032.png"))); // NOI18N
        jBtFarmacia.setToolTipText("Farmácia");
        jBtFarmacia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtFarmacia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtFarmacia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFarmaciajBtVazioActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtFarmacia);

        jBtEducacaoFisica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtEducacaoFisica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/icone_EF48.jpg"))); // NOI18N
        jBtEducacaoFisica.setToolTipText("Educação Fisíca");
        jBtEducacaoFisica.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtEducacaoFisica.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtEducacaoFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEducacaoFisicaActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtEducacaoFisica);
        jToolBar5.add(jSeparator3);

        jBtSeguranca2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtSeguranca2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/cryptography-desktop-preferences-icone-5560-48.png"))); // NOI18N
        jBtSeguranca2.setToolTipText("Segurança");
        jBtSeguranca2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSeguranca2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSeguranca2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSeguranca2jBtSegurancaActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtSeguranca2);

        jBtPortaria2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtPortaria2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/contact-icone-7151-48.png"))); // NOI18N
        jBtPortaria2.setToolTipText("Portaria Interna");
        jBtPortaria2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtPortaria2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtPortaria2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPortaria2jBtPortariaActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtPortaria2);

        jBtPortariaExterna.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtPortariaExterna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216091337_48.png"))); // NOI18N
        jBtPortariaExterna.setToolTipText("Portaria Externa");
        jBtPortariaExterna.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtPortariaExterna.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtPortariaExterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPortariaExternaActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtPortariaExterna);

        jBtTriagem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtTriagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gstreamer-properties-icone-4720-48.png"))); // NOI18N
        jBtTriagem.setToolTipText("Triagem");
        jBtTriagem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtTriagem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtTriagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtTriagemjBtUtilitariosActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtTriagem);

        jBtBasePavilhaoUm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtBasePavilhaoUm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/kljucevi-icone-8545-48.png"))); // NOI18N
        jBtBasePavilhaoUm.setToolTipText("Base I");
        jBtBasePavilhaoUm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtBasePavilhaoUm.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtBasePavilhaoUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBasePavilhaoUmActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtBasePavilhaoUm);

        jBtBasePavilhaoDois.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtBasePavilhaoDois.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/191216083256_48.png"))); // NOI18N
        jBtBasePavilhaoDois.setToolTipText("Base do Pavilhão II");
        jBtBasePavilhaoDois.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtBasePavilhaoDois.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtBasePavilhaoDois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBasePavilhaoDoisActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtBasePavilhaoDois);
        jToolBar5.add(jSeparator4);

        jBtConfiguracoes2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtConfiguracoes2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/gnome-network-preferences-icone-7510-48.png"))); // NOI18N
        jBtConfiguracoes2.setToolTipText("Configurações");
        jBtConfiguracoes2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtConfiguracoes2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtConfiguracoes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfiguracoes2jBtConfiguracoesActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtConfiguracoes2);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/SISCONP 2.gif"))); // NOI18N

        jPanielPrincipal.setLayer(jPanel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPanielPrincipal.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPanielPrincipal.setLayer(jPanel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPanielPrincipal.setLayer(jToolBar5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPanielPrincipal.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanielPrincipalLayout = new javax.swing.GroupLayout(jPanielPrincipal);
        jPanielPrincipal.setLayout(jPanielPrincipalLayout);
        jPanielPrincipalLayout.setHorizontalGroup(
            jPanielPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanielPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanielPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanielPrincipalLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jToolBar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanielPrincipalLayout.setVerticalGroup(
            jPanielPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanielPrincipalLayout.createSequentialGroup()
                .addComponent(jToolBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanielPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanielPrincipalLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 132, Short.MAX_VALUE))
                    .addGroup(jPanielPrincipalLayout.createSequentialGroup()
                        .addGroup(jPanielPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanielPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 1923;
        gridBagConstraints.ipady = 879;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanielPrincipal, gridBagConstraints);

        jToolBar1.setRollover(true);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Usuário:");
        jToolBar1.add(jLabel3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 0, 0);
        getContentPane().add(jToolBar1, gridBagConstraints);

        jToolBar2.setRollover(true);

        jLoginConectado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLoginConectado.setText("jLabel6");
        jToolBar2.add(jLoginConectado);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 450;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 0, 0);
        getContentPane().add(jToolBar2, gridBagConstraints);

        jToolBar3.setRollover(true);

        jDataSistema.setEditable(false);
        jDataSistema.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jToolBar3.add(jDataSistema);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 81;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        getContentPane().add(jToolBar3, gridBagConstraints);

        jToolBar4.setRollover(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Data:  ");
        jToolBar4.add(jLabel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 766, 0, 0);
        getContentPane().add(jToolBar4, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("jLabel6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 155;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 0, 0);
        getContentPane().add(jLabel6, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("OS:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 4, 0, 0);
        getContentPane().add(jLabel8, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("HOST:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 18, 0, 0);
        getContentPane().add(jLabel9, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("jLabel10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 79;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 6, 0, 0);
        getContentPane().add(jLabel10, gridBagConstraints);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtOdontologia2jBtOdontologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtOdontologia2jBtOdontologiaActionPerformed
        // TODO add your handling code here:        
        String grupoOdon = "ODONTOLOGIA";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoOdon = "Sim";
        String moduloOdon = "ODONTOLOGIA";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloOdontologia tod = new TelaModuloOdontologia();
            this.jPanielPrincipal.add(tod);
            tod.show();
            try { // Abrir JiternalFrame maximizado
                tod.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloOdontologia tod = new TelaModuloOdontologia();
                this.jPanielPrincipal.add(tod);
                tod.show();
                try { // Abrir JiternalFrame maximizado
                    tod.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    //  Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoOdon + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloOdon + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoOdon)) {
                    TelaModuloOdontologia tod = new TelaModuloOdontologia();
                    this.jPanielPrincipal.add(tod);
                    tod.show();
                    try { // Abrir JiternalFrame maximizado
                        tod.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtOdontologia2jBtOdontologiaActionPerformed

    private void jBtAdmPessoaljBtTriagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAdmPessoaljBtTriagemActionPerformed
        // TODO add your handling code here:
        String grupoAdmPes = "ADMPESSOAL";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoAdmPes = "Sim";
        String moduloAdmPes = "ADMPESSOAL";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloAdmPessoal objAdm = new TelaModuloAdmPessoal();
            this.jPanielPrincipal.add(objAdm);
            objAdm.show();
            try {
                objAdm.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloAdmPessoal objAdm = new TelaModuloAdmPessoal();
                this.jPanielPrincipal.add(objAdm);
                objAdm.show();
                try {
                    objAdm.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdmPes + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloAdmPes + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoAdmPes)) {
                    TelaModuloAdmPessoal objAdm = new TelaModuloAdmPessoal();
                    this.jPanielPrincipal.add(objAdm);
                    objAdm.show();
                    try {
                        objAdm.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtAdmPessoaljBtTriagemActionPerformed

    private void jBtSeguranca2jBtSegurancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSeguranca2jBtSegurancaActionPerformed
        // TODO add your handling code here:
        String grupoSeg = "SEGURANCA";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoSeg = "Sim";
        String moduloSeg = "SEGURANCA";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloSeguranca ts = new TelaModuloSeguranca();
            this.jPanielPrincipal.add(ts);
            ts.show();
            try {
                ts.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloSeguranca ts = new TelaModuloSeguranca();
                this.jPanielPrincipal.add(ts);
                ts.show();
                try {
                    ts.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoSeg + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloSeg + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoSeg)) {
                    TelaModuloSeguranca ts = new TelaModuloSeguranca();
                    this.jPanielPrincipal.add(ts);
                    ts.show();
                    try {
                        ts.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtSeguranca2jBtSegurancaActionPerformed

    private void jBtServicoSocial2jBtServicoSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtServicoSocial2jBtServicoSocialActionPerformed
        // TODO add your handling code here:
        String grupoSer = "SERVICO SOCIAL";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoSer = "Sim";
        String moduloSer = "SERVICO SOCIAL";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloServicoSocial tss = new TelaModuloServicoSocial();
            this.jPanielPrincipal.add(tss);
            tss.show();
            try {
                tss.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloServicoSocial tss = new TelaModuloServicoSocial();
                this.jPanielPrincipal.add(tss);
                tss.show();
                try {
                    tss.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoSer + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloSer + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoSer)) {
                    TelaModuloServicoSocial tss = new TelaModuloServicoSocial();
                    this.jPanielPrincipal.add(tss);
                    tss.show();
                    try {
                        tss.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtServicoSocial2jBtServicoSocialActionPerformed

    private void jBtServicoMedico2jBtServicoMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtServicoMedico2jBtServicoMedicoActionPerformed
        // TODO add your handling code here:
        String grupoMed = "ENFERMARIA";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoMed = "Sim";
        String moduloMed = "ENFERMARIA";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloEnfermaria tm = new TelaModuloEnfermaria();
            this.jPanielPrincipal.add(tm);
            tm.show();
            try {
                tm.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloEnfermaria tm = new TelaModuloEnfermaria();
                this.jPanielPrincipal.add(tm);
                tm.show();
                try {
                    tm.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoMed + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloMed + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoMed)) {
                    TelaModuloEnfermaria tm = new TelaModuloEnfermaria();
                    this.jPanielPrincipal.add(tm);
                    tm.show();
                    try {
                        tm.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtServicoMedico2jBtServicoMedicoActionPerformed

    private void jBtAlmoxarifado2jBtAlmoxarifadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAlmoxarifado2jBtAlmoxarifadoActionPerformed

        String grupoAlm = "ALMOXARIFADO";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoAlm = "Sim";
        String moduloAlm = "ALMOXARIFADO";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloAlmoxarifado taf = new TelaModuloAlmoxarifado();
            this.jPanielPrincipal.add(taf);
            taf.show();
            try {
                taf.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloAlmoxarifado taf = new TelaModuloAlmoxarifado();
                this.jPanielPrincipal.add(taf);
                taf.show();
                try {
                    taf.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAlm + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloAlm + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoAlm)) {
                    TelaModuloAlmoxarifado taf = new TelaModuloAlmoxarifado();
                    this.jPanielPrincipal.add(taf);
                    taf.show();
                    try {
                        taf.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtAlmoxarifado2jBtAlmoxarifadoActionPerformed

    private void jBtPortaria2jBtPortariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPortaria2jBtPortariaActionPerformed
        // TODO add your handling code here:
        String grupoPort = "PORTARIA";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoPort = "Sim";
        String moduloPort = "PORTARIA";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloPortarias Tprt = new TelaModuloPortarias();
            this.jPanielPrincipal.add(Tprt);
            Tprt.show();
            try {
                Tprt.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloPortarias Tprt = new TelaModuloPortarias();
                this.jPanielPrincipal.add(Tprt);
                Tprt.show();
                try {
                    Tprt.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoPort + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloPort + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoPort)) {
                    TelaModuloPortarias Tprt = new TelaModuloPortarias();
                    this.jPanielPrincipal.add(Tprt);
                    Tprt.show();
                    try {
                        Tprt.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtPortaria2jBtPortariaActionPerformed

    private void jBtCRC2jBtCRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCRC2jBtCRCActionPerformed
        // TODO add your handling code here:       
        String grupoCrc = "CRC";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupo = "Sim";
        String moduloCrc = "CRC";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloCRC trc = new TelaModuloCRC();
            this.jPanielPrincipal.add(trc);
            trc.show();
            try {
                trc.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloCRC trc = new TelaModuloCRC();
                this.jPanielPrincipal.add(trc);
                trc.show();
                try {
                    trc.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoCrc + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloCrc + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupo)) {
                    TelaModuloCRC trc = new TelaModuloCRC();
                    this.jPanielPrincipal.add(trc);
                    trc.show();
                    try {
                        trc.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtCRC2jBtCRCActionPerformed

    private void jBtJuridico2jBtJuridicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtJuridico2jBtJuridicoActionPerformed
        // TODO add your handling code here:
        String grupoJuri = "JURIDICO";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoJuri = "Sim";
        String moduloJuri = "JURIDICO";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloJuridico tj = new TelaModuloJuridico();
            this.jPanielPrincipal.add(tj);
            tj.show();
            try {
                tj.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloJuridico tj = new TelaModuloJuridico();
                this.jPanielPrincipal.add(tj);
                tj.show();
                try {
                    tj.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoJuri + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloJuri + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoJuri)) {
                    TelaModuloJuridico tj = new TelaModuloJuridico();
                    this.jPanielPrincipal.add(tj);
                    tj.show();
                    try {
                        tj.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtJuridico2jBtJuridicoActionPerformed

    private void jBtControleValores2jBtControleValoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtControleValores2jBtControleValoresActionPerformed
        // TODO add your handling code here:
        String grupoFin = "FINANCEIRO";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoFin = "Sim";
        String moduloFin = "FINANCEIRO";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloFinanceiro tfin = new TelaModuloFinanceiro();
            this.jPanielPrincipal.add(tfin);
            tfin.show();
            try {
                tfin.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloFinanceiro tfin = new TelaModuloFinanceiro();
                this.jPanielPrincipal.add(tfin);
                tfin.show();
                try {
                    tfin.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoFin + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloFin + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoFin)) {
                    TelaModuloFinanceiro tfin = new TelaModuloFinanceiro();
                    this.jPanielPrincipal.add(tfin);
                    tfin.show();
                    try {
                        tfin.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtControleValores2jBtControleValoresActionPerformed

    private void jBtTriagemjBtUtilitariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtTriagemjBtUtilitariosActionPerformed
        // TODO add your handling code here:
        String grupoTri = "TRIAGEM";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoTri = "Sim";
        String moduloTri = "TRIAGEM";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloTriagem objTriagem = new TelaModuloTriagem();
            this.jPanielPrincipal.add(objTriagem);
            objTriagem.show();
            try {
                objTriagem.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdm)) {
                TelaModuloTriagem objTriagem = new TelaModuloTriagem();
                this.jPanielPrincipal.add(objTriagem);
                objTriagem.show();
                try {
                    objTriagem.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoTri + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloTri + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoTri)) {
                    TelaModuloTriagem objTriagem = new TelaModuloTriagem();
                    this.jPanielPrincipal.add(objTriagem);
                    objTriagem.show();
                    try {
                        objTriagem.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtTriagemjBtUtilitariosActionPerformed

    private void jBtTerapeuta2jBtTerapeutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtTerapeuta2jBtTerapeutaActionPerformed
        // TODO add your handling code here:
        // String grupoTera = "TERAPAIA OCUPACIONAL";
        String grupoTera = "TERAPIA OCUPACIONAL";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoTera = "Sim";
        String moduloTera = "TERAPIA OCUPACIONAL";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloTerapiaOcupacional tpo = new TelaModuloTerapiaOcupacional();
            this.jPanielPrincipal.add(tpo);
            tpo.show();
            try {
                tpo.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloTerapiaOcupacional tpo = new TelaModuloTerapiaOcupacional();
                this.jPanielPrincipal.add(tpo);
                tpo.show();
                try {
                    tpo.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoTera + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloTera + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoTera)) {
                    TelaModuloTerapiaOcupacional tpo = new TelaModuloTerapiaOcupacional();
                    this.jPanielPrincipal.add(tpo);
                    tpo.show();
                    try {
                        tpo.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtTerapeuta2jBtTerapeutaActionPerformed

    private void jBtPedagogia2jBtPedagogiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPedagogia2jBtPedagogiaActionPerformed
        // TODO add your handling code here:
        String grupoProf = "PEDAGOGIA";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoProf = "Sim";
        String moduloProf = "PEDAGOGIA";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloPedagogia tpf = new TelaModuloPedagogia();
            this.jPanielPrincipal.add(tpf);
            tpf.show();
            try {
                tpf.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloPedagogia tpf = new TelaModuloPedagogia();
                this.jPanielPrincipal.add(tpf);
                tpf.show();
                try {
                    tpf.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoProf + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloProf + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoProf)) {
                    TelaModuloPedagogia tpf = new TelaModuloPedagogia();
                    this.jPanielPrincipal.add(tpf);
                    tpf.show();
                    try {
                        tpf.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtPedagogia2jBtPedagogiaActionPerformed

    private void jBtPsicologia2jBtPsicologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPsicologia2jBtPsicologiaActionPerformed
        // TODO add your handling code here:
        String grupoPsi = "PSICOLOGIA";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoPsi = "Sim";
        String moduloPsi = "PSICOLOGIA";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloPsicologia tps = new TelaModuloPsicologia();
            this.jPanielPrincipal.add(tps);
            tps.show();
            try {
                tps.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloPsicologia tps = new TelaModuloPsicologia();
                this.jPanielPrincipal.add(tps);
                tps.show();
                try {
                    tps.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoPsi + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloPsi + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoPsi)) {
                    TelaModuloPsicologia tps = new TelaModuloPsicologia();
                    this.jPanielPrincipal.add(tps);
                    tps.show();
                    try {
                        tps.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtPsicologia2jBtPsicologiaActionPerformed

    private void jBtConfiguracoes2jBtConfiguracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfiguracoes2jBtConfiguracoesActionPerformed
        // TODO add your handling code here:
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoAdm = "Sim";
        String moduloAdm = "CONFIGURACOES";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloConfiguracoes tc = new TelaModuloConfiguracoes();
            this.jPanielPrincipal.add(tc);
            tc.show();
            try {
                tc.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloConfiguracoes tc = new TelaModuloConfiguracoes();
                this.jPanielPrincipal.add(tc);
                tc.show();
                try {
                    tc.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloAdm + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoAdm)) {
                    TelaModuloConfiguracoes tc = new TelaModuloConfiguracoes();
                    this.jPanielPrincipal.add(tc);
                    tc.show();
                    try {
                        tc.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtConfiguracoes2jBtConfiguracoesActionPerformed

    private void jBtNutricaojBtVazioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtNutricaojBtVazioActionPerformed
        // TODO add your handling code here:
        String grupoNut = "NUTRICAO";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoNut = "Sim";
        String moduloNut = "NUTRICAO";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloNutricao objTelaNutricao = new TelaModuloNutricao();
            this.jPanielPrincipal.add(objTelaNutricao);
            objTelaNutricao.show();
            try {
                objTelaNutricao.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloNutricao objTelaNutricao = new TelaModuloNutricao();
                this.jPanielPrincipal.add(objTelaNutricao);
                objTelaNutricao.show();
                try {
                    objTelaNutricao.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoNut + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloNut + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoNut)) {
                    TelaModuloNutricao objTelaNutricao = new TelaModuloNutricao();
                    this.jPanielPrincipal.add(objTelaNutricao);
                    objTelaNutricao.show();
                    try {
                        objTelaNutricao.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtNutricaojBtVazioActionPerformed

    private void jBtLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtLogoffActionPerformed
        // Sair e voltar para troca de usuário
        // RETIRADO PARA VERIFICAR SE O ERRO DE SQL É PROVINIENTE DESSA ROTINA (02/05/2017)
//        buscarIdUsuario();
//        statusFlag = "Não";
//        userConectado.setDataDesconectado(jDataSistema.getText());
//        userConectado.setHorarioDesconectado(jHoraSistema.getText());
//        userConectado.setConectadoDesconectado(usuarioDesconectado);
//        userConectado.setStatusFlag(statusFlag);
//        userConectado.setIdUser(Integer.valueOf(idUser));
//        control.desconectarHostName(userConectado);
       // conecta.desconecta();
        dispose();
        TelaLoginSenha tls = new TelaLoginSenha(this, true);
        tls.setVisible(true);
    }//GEN-LAST:event_jBtLogoffActionPerformed

    private void jBtSairSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairSistemaActionPerformed
        // TODO add your handling code here:
        buscarIdUsuario();
        statusFlag = "Não";
        userConectado.setDataDesconectado(jDataSistema.getText());
        userConectado.setHorarioDesconectado(jHoraSistema.getText());
        userConectado.setConectadoDesconectado(usuarioDesconectado);
        userConectado.setStatusFlag(statusFlag);
        userConectado.setIdUser(Integer.valueOf(idUser));
        control.desconectarHostName(userConectado);
        System.exit(0);
    }//GEN-LAST:event_jBtSairSistemaActionPerformed

    private void jBtComprasjBtVazioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtComprasjBtVazioActionPerformed
        // TODO add your handling code here:
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoComp = "Sim";
        String moduloComp = "COMPRAS";
        String grupoComp = "COMPRAS";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloCompras fer = new TelaModuloCompras();
            this.jPanielPrincipal.add(fer);
            fer.show();
            try {
                fer.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloCompras fer = new TelaModuloCompras();
                this.jPanielPrincipal.add(fer);
                fer.show();
                try {
                    fer.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoComp + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloComp + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoComp)) {
                    TelaModuloCompras fer = new TelaModuloCompras();
                    this.jPanielPrincipal.add(fer);
                    fer.show();
                    try {
                        fer.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtComprasjBtVazioActionPerformed

    private void jBtFarmaciajBtVazioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFarmaciajBtVazioActionPerformed
        // TODO add your handling code here:
        String grupoFar = "FARMACIA";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoFar = "Sim";
        String moduloFar = "FARMACIA";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloFarmacia objTelaFarma = new TelaModuloFarmacia();
            this.jPanielPrincipal.add(objTelaFarma);
            objTelaFarma.show();
            try {
                objTelaFarma.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloFarmacia objTelaFarma = new TelaModuloFarmacia();
                this.jPanielPrincipal.add(objTelaFarma);
                objTelaFarma.show();
                try {
                    objTelaFarma.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoFar + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloFar + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoFar)) {
                    TelaModuloFarmacia objTelaFarma = new TelaModuloFarmacia();
                    this.jPanielPrincipal.add(objTelaFarma);
                    objTelaFarma.show();
                    try {
                        objTelaFarma.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtFarmaciajBtVazioActionPerformed

    private void jBtBasePavilhaoUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBasePavilhaoUmActionPerformed
        // TODO add your handling code here:
        String grupoNut = "BASE PAVILHAO UM";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoNut = "Sim";
        String moduloNut = "BASE PAVILHAO UM";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloBaseUm objTelaBaseGeral = new TelaModuloBaseUm();
            this.jPanielPrincipal.add(objTelaBaseGeral);
            verificarParametros();
            objTelaBaseGeral.show();
            try {
                objTelaBaseGeral.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloBaseUm objTelaBaseGeral = new TelaModuloBaseUm();
                this.jPanielPrincipal.add(objTelaBaseGeral);
                verificarParametros();
                objTelaBaseGeral.show();
                try {
                    objTelaBaseGeral.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoNut + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloNut + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoNut)) {
                    TelaModuloBaseUm objTelaBaseGeral = new TelaModuloBaseUm();
                    this.jPanielPrincipal.add(objTelaBaseGeral);
                    verificarParametros();
                    objTelaBaseGeral.show();
                    try {
                        objTelaBaseGeral.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtBasePavilhaoUmActionPerformed

    private void jBtDiretoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtDiretoriaActionPerformed
        // TODO add your handling code here:
        String grupoNut = "DIRETORES";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoNut = "Sim";
        String moduloNut = "DIRETORES";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloDiretoria objTelaDiretor = new TelaModuloDiretoria();
            this.jPanielPrincipal.add(objTelaDiretor);
            objTelaDiretor.show();
            try {
                objTelaDiretor.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloDiretoria objTelaDiretor = new TelaModuloDiretoria();
                this.jPanielPrincipal.add(objTelaDiretor);
                objTelaDiretor.show();
                try {
                    objTelaDiretor.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoNut + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloNut + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoNut)) {
                    TelaModuloDiretoria objTelaDiretor = new TelaModuloDiretoria();
                    this.jPanielPrincipal.add(objTelaDiretor);
                    objTelaDiretor.show();
                    try {
                        objTelaDiretor.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtDiretoriaActionPerformed

    private void jBtPortariaExternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtPortariaExternaActionPerformed
        // TODO add your handling code here:
        String grupoPort = "PORTARIA EXTERNA";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoPort = "Sim";
        String moduloPort = "PORTARIA EXTERNA";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloPortariaExterna TprtExt = new TelaModuloPortariaExterna();
            this.jPanielPrincipal.add(TprtExt);
            TprtExt.show();
            try {
                TprtExt.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloPortariaExterna TprtExt = new TelaModuloPortariaExterna();
                this.jPanielPrincipal.add(TprtExt);
                TprtExt.show();
                try {
                    TprtExt.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoPort + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloPort + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoPort)) {
                    TelaModuloPortariaExterna TprtExt = new TelaModuloPortariaExterna();
                    this.jPanielPrincipal.add(TprtExt);
                    TprtExt.show();
                    try {
                        TprtExt.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtPortariaExternaActionPerformed

    private void jBtTrocarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtTrocarSenhaActionPerformed
        // TODO add your handling code here:
        mostrarTelaTrocaSenha();
    }//GEN-LAST:event_jBtTrocarSenhaActionPerformed

    private void jBtEducacaoFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEducacaoFisicaActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Em desenvolvimento");
    }//GEN-LAST:event_jBtEducacaoFisicaActionPerformed

    private void jBtBasePavilhaoDoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBasePavilhaoDoisActionPerformed
        // TODO add your handling code here:
        String grupoNut = "BASE PAVILHAO DOIS";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoNut = "Sim";
        String moduloNut = "BASE PAVILHAO DOIS";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                    + "INNER JOIN GRUPOUSUARIOS "
                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                    + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloBaseDois objTelaBaseAuxiliar = new TelaModuloBaseDois();
            this.jPanielPrincipal.add(objTelaBaseAuxiliar);
            verificarParametrosBpa();
            objTelaBaseAuxiliar.show();
            try {
                objTelaBaseAuxiliar.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloBaseDois objTelaBaseAuxiliar = new TelaModuloBaseDois();
                this.jPanielPrincipal.add(objTelaBaseAuxiliar);
                verificarParametrosBpa();
                objTelaBaseAuxiliar.show();
                try {
                    objTelaBaseAuxiliar.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoNut + "' "
                            + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                            + "INNER JOIN MODULOS "
                            + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                            + "WHERE MODULOS.NomeModulo='" + moduloNut + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoNut)) {
                    TelaModuloBaseDois objTelaBaseAuxiliar = new TelaModuloBaseDois();
                    this.jPanielPrincipal.add(objTelaBaseAuxiliar);
                    verificarParametrosBpa();
                    objTelaBaseAuxiliar.show();
                    try {
                        objTelaBaseAuxiliar.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtBasePavilhaoDoisActionPerformed

    private void jBtSindicanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSindicanciaActionPerformed
        // TODO add your handling code here:
        String grupoPort = "SINDICANCIA";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoPort = "Sim";
        String moduloPort = "SINDICANCIA";
        idGrupo = 0;
        nomeGrupo = "";
        idModulo = 0;
        idGrupoModulo = 0;
        permissaoModulo = "";
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                + "INNER JOIN GRUPOUSUARIOS "
                + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoAdm + "' "
                + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
            conecta.rs.first();
            nomeGrupo = conecta.rs.getString("NomeGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
        // SE O FOR O ADMINISTRADOR DO SISTEMA
        if (loginUsusario.equals(nameUser)) {
            TelaModuloSindicancia Sind = new TelaModuloSindicancia();
            this.jPanielPrincipal.add(Sind);
            Sind.show();
            try {
                Sind.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloSindicancia Sind = new TelaModuloSindicancia();
                this.jPanielPrincipal.add(Sind);
                Sind.show();
                try {
                    Sind.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                        + "INNER JOIN GRUPOUSUARIOS "
                        + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                        + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoPort + "' "
                        + "AND USUARIOS_GRUPOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idGrupo = conecta.rs.getInt("IdGrupo");
                    nomeGrupo = conecta.rs.getString("NomeGrupo");
                } catch (Exception e) {
                }
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_MODULOS "
                        + "INNER JOIN MODULOS "
                        + "ON USUARIOS_MODULOS.IdModulo=MODULOS.IdModulo "
                        + "WHERE MODULOS.NomeModulo='" + moduloPort + "' "
                        + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoPort)) {
                    TelaModuloSindicancia Sind = new TelaModuloSindicancia();
                    this.jPanielPrincipal.add(Sind);
                    Sind.show();
                    try {
                        Sind.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtSindicanciaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaModuloPrincipalNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaModuloPrincipalNew().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtAdmPessoal;
    private javax.swing.JButton jBtAlmoxarifado2;
    private javax.swing.JButton jBtBasePavilhaoDois;
    private javax.swing.JButton jBtBasePavilhaoUm;
    private javax.swing.JButton jBtCRC2;
    private javax.swing.JButton jBtCompras;
    private javax.swing.JButton jBtConfiguracoes2;
    private javax.swing.JButton jBtControleValores2;
    private javax.swing.JButton jBtDiretoria;
    private javax.swing.JButton jBtEducacaoFisica;
    private javax.swing.JButton jBtFarmacia;
    private javax.swing.JButton jBtJuridico2;
    private javax.swing.JButton jBtLogoff;
    private javax.swing.JButton jBtNutricao;
    private javax.swing.JButton jBtOdontologia2;
    private javax.swing.JButton jBtPedagogia2;
    private javax.swing.JButton jBtPortaria2;
    private javax.swing.JButton jBtPortariaExterna;
    private javax.swing.JButton jBtPsicologia2;
    private javax.swing.JButton jBtSairSistema;
    private javax.swing.JButton jBtSeguranca2;
    private javax.swing.JButton jBtServicoMedico2;
    private javax.swing.JButton jBtServicoSocial2;
    private javax.swing.JButton jBtSindicancia;
    private javax.swing.JButton jBtTerapeuta2;
    private javax.swing.JButton jBtTriagem;
    private javax.swing.JButton jBtTrocarSenha;
    public static javax.swing.JTextField jDataSistema;
    public static javax.swing.JTextField jHoraSistema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLoginConectado;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel jNomeUnidade;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    public static javax.swing.JDesktopPane jPanielPrincipal;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    // End of variables declaration//GEN-END:variables

//    // Atualizar Versão do sistema quando existir
//    public void atualizarSistema() throws FileNotFoundException, IOException {
//        // Arquivos que iremos copiar
//        File origem = new File("R://SysConp//SysConp.jar");
//        long dataOrigem = origem.lastModified(); // Data do arquivo de origem
//        long tamanhoOrigem = origem.length();  // Tamanho do arquivo de origem        
//        File destino = new File("C://SysConp//SysConp.jar");
//        long dataDestino = destino.lastModified();
//        long tamanhoDestino = destino.length();
//        final File dirOrigem = new File("R://SysConp//");
//        final File dirDestino = new File("C://SysConp//");
//        if (dataOrigem > dataDestino || tamanhoOrigem > tamanhoDestino) {
//            int resposta = JOptionPane.showConfirmDialog(this, "Existe uma nova atualização do sistema a ser Realizada?", "Confirmação",
//                    JOptionPane.YES_NO_OPTION);
//            if (resposta == JOptionPane.YES_OPTION) {
//                jUsuario.setEnabled(!true);
//                jPassword.setEnabled(!true);
//                jBtAcessar.setEnabled(!true);
//                jBtCancelar.setEnabled(!true);  
////                TelaAtualizacao ta = new TelaAtualizacao();
////                TelaModuloPrincipal.jPanielPrincipal.add(ta);
////                ta.show();
////                ta.toFront();
//                copyDirectory(dirOrigem, dirDestino);
//                JOptionPane.showMessageDialog(rootPane, "O sistema foi atualizado e será fechado, abra novamente para poder utilizar.");
//                System.exit(0);
//            } else {
//                JOptionPane.showMessageDialog(rootPane, "Você optou por não atualizar o sistema, por isso não poderá usar até que o mesmo seja atualizado.");
//                System.exit(0);
//            }
//        }
//    }
    // Buscar o ip e o nome do host
    public void buscarIpNome() {

        InetAddress myself;
        try {
            myself = InetAddress.getLocalHost();
            ipHost = myself.getHostAddress();
            hostName = myself.getHostName();
        } catch (UnknownHostException ex) {
            Logger.getLogger(TelaLoginSenha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscarIdUsuario() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USERCONECTADOS "
                    + "WHERE NomeUsuario='" + nameUser + "' "
                    + "AND HorarioPlugado='" + userConectado.getHorarioPlugado() + "'");
            conecta.rs.first();
            idUser = conecta.rs.getString("IdUser");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void verificarParametros() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            parametroPopulcao = conecta.rs.getString("PopulacaoBgp");
            parametroLocacao = conecta.rs.getString("LocacaoBgp");
            parametroTransferencia = conecta.rs.getString("TransferenciaBgp");
            parametroPavilhao = conecta.rs.getString("PavilhaoCelaBgp");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Solicite ao ADMINISTRADOR DO SISTEMA que configure os parâmetros de acesso desse módulo.");
        }
        conecta.desconecta();
        if (parametroPopulcao.equals("Desabilitado")) {
            PopulacaoInternosAgentes.setEnabled(!true);
        } else {
            PopulacaoInternosAgentes.setEnabled(true);
        }
        if (parametroLocacao.equals("Desabilitado")) {
            LocacaoInternos.setEnabled(!true);
        } else {
            LocacaoInternos.setEnabled(true);
        }
        if (parametroTransferencia.equals("Desabilitado")) {
            TransferenciaPavilhaoCelas.setEnabled(!true);
        } else {
            TransferenciaPavilhaoCelas.setEnabled(true);
        }
        if (parametroPavilhao.equals("Desabilitado")) {
            PavilhaoCela.setEnabled(!true);
        } else {
            PavilhaoCela.setEnabled(true);
        }
    }

    public void verificarParametrosBpa() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            parametroPopulcaoBpa = conecta.rs.getString("PopulacaoBpa");
            parametroLocacaoBpa = conecta.rs.getString("LocacaoBpa");
            parametroTransferenciaBpa = conecta.rs.getString("TransferenciaBpa");
            parametroPavilhaoBpa = conecta.rs.getString("PavilhaoCelaBpa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Solicite ao ADMINISTRADOR DO SISTEMA que configure os parâmetros de acesso desse módulo.");
        }
        conecta.desconecta();
        if (parametroPopulcaoBpa.equals("Desabilitado")) {
            PopulacaoInternosAgentesBpa.setEnabled(!true);
        } else {
            PopulacaoInternosAgentesBpa.setEnabled(true);
        }
        if (parametroLocacaoBpa.equals("Desabilitado")) {
            LocacaoInternosBpa.setEnabled(!true);
        } else {
            LocacaoInternosBpa.setEnabled(true);
        }
        if (parametroTransferenciaBpa.equals("Desabilitado")) {
            TransferenciaPavilhaoCelasBpa.setEnabled(!true);
        } else {
            TransferenciaPavilhaoCelasBpa.setEnabled(true);
        }
        if (parametroPavilhaoBpa.equals("Desabilitado")) {
            PavilhaoCelaBpa.setEnabled(!true);
        } else {
            PavilhaoCelaBpa.setEnabled(true);
        }
    }
//    public void copyDirectory(File srcPath, File dstPath) throws IOException {
//
//        if (srcPath.isDirectory()) {
//            if (!dstPath.exists()) {
//                dstPath.mkdir();
//            }
//            String files[] = srcPath.list();
//            for (int i = 0; i < files.length; i++) {
//                copyDirectory(new File(srcPath, files[i]),
//                        new File(dstPath, files[i]));
//            }
//        } else {
//            if (!srcPath.exists()) {
//                System.out.println("File or directory does not exist." + srcPath);
//                System.exit(0);
//            } else {
//                InputStream in = new FileInputStream(srcPath);
//                OutputStream out = new FileOutputStream(dstPath);
//                // Transfer bytes from in to out
//                byte[] buf = new byte[1024];
//                int len;
//                while ((len = in.read(buf)) > 0) {
//                    out.write(buf, 0, len);
//                }
//                in.close();
//                out.close();
//            }
//        }
//        System.out.println("Directory copied." + srcPath);
//    }
    // abrimos os streams para leitura/escrita
//                FileInputStream fis = new FileInputStream(origem);
//                FileOutputStream fos = new FileOutputStream(destino);
//                int count = 0;
//                byte[] bytes = new byte[1024];
//                while ((count = fis.read(bytes)) >= 0) {
//                    fos.write(bytes, 0, count);
//                }  
    //                fis.close();
//                fos.close();
}
