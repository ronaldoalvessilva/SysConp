/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

//import gestor.Modelo.clsDataHora;
import com.sun.glass.events.KeyEvent;
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

/**
 *
 * @author Ronaldo
 */
// Inicio do desenvolvimento 20/03/2014
public class TelaModuloPrincipal extends javax.swing.JFrame {

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
    public static TelaSobre telaSobre;

    /**
     * Creates new form TelaPrincipal
     *
     * @param user
     * @param username
     */
    // Informa para classe principal o usuário logado no sistema
    public TelaModuloPrincipal(String user, String username) {
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

    public void mostrarSobre() {
        telaSobre = new TelaSobre(this, true);
        telaSobre.setVisible(true);
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
    TelaModuloPrincipal() {
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

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPanielPrincipal = new javax.swing.JDesktopPane();
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
        jBtSindicancia = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jBtTrocarSenha = new javax.swing.JButton();
        jBtLogoff = new javax.swing.JButton();
        jBtSairSistema = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jNomeUnidade = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel3 = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        jLoginConectado = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jToolBar4 = new javax.swing.JToolBar();
        jToolBar3 = new javax.swing.JToolBar();
        jToolBar6 = new javax.swing.JToolBar();
        jDataSistema = new javax.swing.JTextField();
        jToolBar8 = new javax.swing.JToolBar();
        jHoraSistema = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuAdministracao = new javax.swing.JMenu();
        jMenuItemGerenciaAdministrativa = new javax.swing.JMenuItem();
        jMenuItemDiretoriaUnidade = new javax.swing.JMenuItem();
        jMenuItemCRC = new javax.swing.JMenuItem();
        jMenuItemAlmoxarifado = new javax.swing.JMenuItem();
        jMenuItemBancoVirtual = new javax.swing.JMenuItem();
        jMenuItemCompras = new javax.swing.JMenuItem();
        jMenuPSP = new javax.swing.JMenu();
        jMenuItemEnfermaria = new javax.swing.JMenuItem();
        jMenuItemServicoSocial = new javax.swing.JMenuItem();
        jMenuItemPsicologia = new javax.swing.JMenuItem();
        jMenuItemOdontologia = new javax.swing.JMenuItem();
        jMenuItemJuridico = new javax.swing.JMenuItem();
        jMenuItemTO = new javax.swing.JMenuItem();
        jMenuItemPedagogia = new javax.swing.JMenuItem();
        jMenuItemEducacaoFisica = new javax.swing.JMenuItem();
        jMenuItemNutricao = new javax.swing.JMenuItem();
        jMenuItemFarmacia = new javax.swing.JMenuItem();
        jMenuOperacional = new javax.swing.JMenu();
        jMenuItemBase1 = new javax.swing.JMenuItem();
        jMenuItemBase2 = new javax.swing.JMenuItem();
        jMenuItemGerenciaOperacional = new javax.swing.JMenuItem();
        jMenuItemPortariaInterna = new javax.swing.JMenuItem();
        jMenuItemPortariaExterna = new javax.swing.JMenuItem();
        jMenuItemTriagem = new javax.swing.JMenuItem();
        jMenuConfiguracoes = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuSobre = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar3.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar3.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("...::: SISCONP - Sistema de Controle Prisional :::...");
        setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        setForeground(new java.awt.Color(51, 255, 255));

        jPanielPrincipal.setBackground(new java.awt.Color(240, 240, 240));
        jPanielPrincipal.setAutoscrolls(true);
        jPanielPrincipal.setPreferredSize(new java.awt.Dimension(1000, 879));

        jToolBar5.setBackground(new java.awt.Color(51, 51, 255));
        jToolBar5.setRollover(true);
        jToolBar5.setMinimumSize(new java.awt.Dimension(1200, 66));

        jBtAdmPessoal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtAdmPessoal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Administração48.png"))); // NOI18N
        jBtAdmPessoal.setToolTipText("Administração");
        jBtAdmPessoal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAdmPessoal.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtAdmPessoal.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtAdmPessoal.setPreferredSize(new java.awt.Dimension(48, 48));
        jBtAdmPessoal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtAdmPessoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAdmPessoaljBtTriagemActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtAdmPessoal);

        jBtDiretoria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtDiretoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Diretoria48.png"))); // NOI18N
        jBtDiretoria.setToolTipText("Diretoria");
        jBtDiretoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtDiretoria.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtDiretoria.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtDiretoria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtDiretoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtDiretoriaActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtDiretoria);

        jBtCRC2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtCRC2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/CRC48.png"))); // NOI18N
        jBtCRC2.setToolTipText("CRC");
        jBtCRC2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCRC2.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtCRC2.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtCRC2.setPreferredSize(new java.awt.Dimension(48, 48));
        jBtCRC2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtCRC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCRC2jBtCRCActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtCRC2);
        jToolBar5.add(jSeparator1);

        jBtControleValores2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtControleValores2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Banco248.png"))); // NOI18N
        jBtControleValores2.setToolTipText("Banco Virtual");
        jBtControleValores2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtControleValores2.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtControleValores2.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtControleValores2.setPreferredSize(new java.awt.Dimension(48, 48));
        jBtControleValores2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtControleValores2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtControleValores2jBtControleValoresActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtControleValores2);

        jBtAlmoxarifado2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtAlmoxarifado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Almoxarifado48.png"))); // NOI18N
        jBtAlmoxarifado2.setToolTipText("Almoxarifado");
        jBtAlmoxarifado2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtAlmoxarifado2.setMaximumSize(new java.awt.Dimension(53, 53));
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
        jBtCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Compras48.png"))); // NOI18N
        jBtCompras.setToolTipText("Compras");
        jBtCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtCompras.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtCompras.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtCompras.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtComprasjBtVazioActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtCompras);
        jToolBar5.add(jSeparator2);

        jBtJuridico2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtJuridico2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Juridico48.png"))); // NOI18N
        jBtJuridico2.setToolTipText("Jurídico");
        jBtJuridico2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtJuridico2.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtJuridico2.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtJuridico2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtJuridico2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtJuridico2jBtJuridicoActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtJuridico2);

        jBtServicoSocial2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtServicoSocial2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ServicoSocial48.png"))); // NOI18N
        jBtServicoSocial2.setToolTipText("Serviço Social");
        jBtServicoSocial2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtServicoSocial2.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtServicoSocial2.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtServicoSocial2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtServicoSocial2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtServicoSocial2jBtServicoSocialActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtServicoSocial2);

        jBtPedagogia2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtPedagogia2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Pedagogia.png"))); // NOI18N
        jBtPedagogia2.setToolTipText("Pedagogia");
        jBtPedagogia2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtPedagogia2.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtPedagogia2.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtPedagogia2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtPedagogia2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPedagogia2jBtPedagogiaActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtPedagogia2);

        jBtTerapeuta2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtTerapeuta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Terapia.png"))); // NOI18N
        jBtTerapeuta2.setToolTipText("Terapia");
        jBtTerapeuta2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtTerapeuta2.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtTerapeuta2.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtTerapeuta2.setPreferredSize(new java.awt.Dimension(64, 64));
        jBtTerapeuta2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtTerapeuta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtTerapeuta2jBtTerapeutaActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtTerapeuta2);

        jBtPsicologia2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtPsicologia2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Psicologia40.png"))); // NOI18N
        jBtPsicologia2.setToolTipText("Psicologia");
        jBtPsicologia2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtPsicologia2.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtPsicologia2.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtPsicologia2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtPsicologia2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPsicologia2jBtPsicologiaActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtPsicologia2);

        jBtOdontologia2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtOdontologia2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Odontologia48.png"))); // NOI18N
        jBtOdontologia2.setToolTipText("Odontológico");
        jBtOdontologia2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtOdontologia2.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtOdontologia2.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtOdontologia2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtOdontologia2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtOdontologia2jBtOdontologiaActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtOdontologia2);

        jBtServicoMedico2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtServicoMedico2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Enfermaria48.png"))); // NOI18N
        jBtServicoMedico2.setToolTipText("Enfermaria");
        jBtServicoMedico2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtServicoMedico2.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtServicoMedico2.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtServicoMedico2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtServicoMedico2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtServicoMedico2jBtServicoMedicoActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtServicoMedico2);

        jBtNutricao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtNutricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Nutricao48.png"))); // NOI18N
        jBtNutricao.setToolTipText("Nutrição");
        jBtNutricao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtNutricao.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtNutricao.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtNutricao.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtNutricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtNutricaojBtVazioActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtNutricao);

        jBtFarmacia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtFarmacia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Farmacia48.png"))); // NOI18N
        jBtFarmacia.setToolTipText("Farmácia");
        jBtFarmacia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtFarmacia.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtFarmacia.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtFarmacia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtFarmacia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFarmaciajBtVazioActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtFarmacia);

        jBtEducacaoFisica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtEducacaoFisica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Educacao fisica48.png"))); // NOI18N
        jBtEducacaoFisica.setToolTipText("Educação Fisíca");
        jBtEducacaoFisica.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtEducacaoFisica.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtEducacaoFisica.setMinimumSize(new java.awt.Dimension(74, 48));
        jBtEducacaoFisica.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtEducacaoFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtEducacaoFisicaActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtEducacaoFisica);
        jToolBar5.add(jSeparator3);

        jBtSeguranca2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtSeguranca2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Seguranca48.png"))); // NOI18N
        jBtSeguranca2.setToolTipText("Gerência OPeracional");
        jBtSeguranca2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSeguranca2.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtSeguranca2.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtSeguranca2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSeguranca2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSeguranca2jBtSegurancaActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtSeguranca2);

        jBtPortaria2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtPortaria2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/P148.png"))); // NOI18N
        jBtPortaria2.setToolTipText("Portaria Interna");
        jBtPortaria2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtPortaria2.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtPortaria2.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtPortaria2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtPortaria2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPortaria2jBtPortariaActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtPortaria2);

        jBtPortariaExterna.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtPortariaExterna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/P248.png"))); // NOI18N
        jBtPortariaExterna.setToolTipText("Portaria Externa");
        jBtPortariaExterna.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtPortariaExterna.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtPortariaExterna.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtPortariaExterna.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtPortariaExterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtPortariaExternaActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtPortariaExterna);

        jBtTriagem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtTriagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Triagem48.png"))); // NOI18N
        jBtTriagem.setToolTipText("Triagem");
        jBtTriagem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtTriagem.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtTriagem.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtTriagem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtTriagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtTriagemjBtUtilitariosActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtTriagem);

        jBtBasePavilhaoUm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtBasePavilhaoUm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/BaseI48.png"))); // NOI18N
        jBtBasePavilhaoUm.setToolTipText("Base I");
        jBtBasePavilhaoUm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtBasePavilhaoUm.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtBasePavilhaoUm.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtBasePavilhaoUm.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtBasePavilhaoUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBasePavilhaoUmActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtBasePavilhaoUm);

        jBtBasePavilhaoDois.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtBasePavilhaoDois.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/BaseII48.png"))); // NOI18N
        jBtBasePavilhaoDois.setToolTipText("Base do Pavilhão II");
        jBtBasePavilhaoDois.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtBasePavilhaoDois.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtBasePavilhaoDois.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtBasePavilhaoDois.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtBasePavilhaoDois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBasePavilhaoDoisActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtBasePavilhaoDois);
        jToolBar5.add(jSeparator4);

        jBtConfiguracoes2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtConfiguracoes2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Configuracao48.png"))); // NOI18N
        jBtConfiguracoes2.setToolTipText("Configurações");
        jBtConfiguracoes2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtConfiguracoes2.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtConfiguracoes2.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtConfiguracoes2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jBtConfiguracoes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfiguracoes2jBtConfiguracoesActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtConfiguracoes2);

        jBtSindicancia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtSindicancia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Lego Robot-48.png"))); // NOI18N
        jBtSindicancia.setToolTipText("Sindicancia");
        jBtSindicancia.setBorder(null);
        jBtSindicancia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSindicancia.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtSindicancia.setMinimumSize(new java.awt.Dimension(48, 48));
        jBtSindicancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSindicanciaActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtSindicancia);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Produtividade48.png"))); // NOI18N
        jButton1.setToolTipText("Produtividade");
        jButton1.setMaximumSize(new java.awt.Dimension(53, 53));
        jButton1.setMinimumSize(new java.awt.Dimension(48, 48));
        jToolBar5.add(jButton1);
        jToolBar5.add(jSeparator5);

        jBtTrocarSenha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtTrocarSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Refresh_Icon_32.png"))); // NOI18N
        jBtTrocarSenha.setToolTipText("Trocar Senha");
        jBtTrocarSenha.setFocusable(false);
        jBtTrocarSenha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtTrocarSenha.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtTrocarSenha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtTrocarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtTrocarSenhaActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtTrocarSenha);

        jBtLogoff.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtLogoff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/refresh-reload-icone-6258-32.png"))); // NOI18N
        jBtLogoff.setToolTipText("Fazer logoff");
        jBtLogoff.setFocusable(false);
        jBtLogoff.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtLogoff.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtLogoff.setName(""); // NOI18N
        jBtLogoff.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtLogoffActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtLogoff);

        jBtSairSistema.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtSairSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-32.png"))); // NOI18N
        jBtSairSistema.setToolTipText("Sair do Sistema");
        jBtSairSistema.setFocusable(false);
        jBtSairSistema.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtSairSistema.setMaximumSize(new java.awt.Dimension(53, 53));
        jBtSairSistema.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtSairSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairSistemaActionPerformed(evt);
            }
        });
        jToolBar5.add(jBtSairSistema);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/PanoDeFundo7.png"))); // NOI18N

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("SISCONP - Sistema de Controle Prisional ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("Versão: 5.9");

        jNomeUnidade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jNomeUnidade.setForeground(new java.awt.Color(0, 153, 0));
        jNomeUnidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jNomeUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(jLabel7)
                .addGap(51, 51, 51))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jLabel7)
                .addComponent(jLabel4)
                .addComponent(jNomeUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanielPrincipal.setLayer(jToolBar5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPanielPrincipal.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jPanielPrincipal.setLayer(jPanel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanielPrincipalLayout = new javax.swing.GroupLayout(jPanielPrincipal);
        jPanielPrincipal.setLayout(jPanielPrincipalLayout);
        jPanielPrincipalLayout.setHorizontalGroup(
            jPanielPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanielPrincipalLayout.createSequentialGroup()
                .addGroup(jPanielPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanielPrincipalLayout.createSequentialGroup()
                        .addGroup(jPanielPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToolBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 1365, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanielPrincipalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanielPrincipalLayout.setVerticalGroup(
            jPanielPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanielPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jToolBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jToolBar1.setBackground(new java.awt.Color(51, 51, 255));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuário:");
        jToolBar1.add(jLabel3);

        jToolBar2.setBackground(new java.awt.Color(51, 51, 255));
        jToolBar2.setRollover(true);
        jToolBar2.setToolTipText("");
        jToolBar2.setMaximumSize(new java.awt.Dimension(49, 16));
        jToolBar2.setMinimumSize(new java.awt.Dimension(49, 16));
        jToolBar2.setName(""); // NOI18N

        jLoginConectado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLoginConectado.setForeground(new java.awt.Color(255, 255, 255));
        jLoginConectado.setText("jLabel6");
        jToolBar2.add(jLoginConectado);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("OS:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("jLabel6");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("jLabel10");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("HOST:");

        jToolBar4.setBackground(new java.awt.Color(51, 51, 255));
        jToolBar4.setRollover(true);

        jToolBar3.setBackground(new java.awt.Color(51, 51, 255));
        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        jToolBar6.setBackground(new java.awt.Color(51, 51, 255));
        jToolBar6.setRollover(true);

        jDataSistema.setEditable(false);
        jDataSistema.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jDataSistema.setText("28/12/2018");
        jToolBar6.add(jDataSistema);

        jToolBar8.setBackground(new java.awt.Color(51, 51, 255));
        jToolBar8.setRollover(true);

        jHoraSistema.setBackground(new java.awt.Color(240, 240, 240));
        jHoraSistema.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jToolBar8.add(jHoraSistema);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hora:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Data:  ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(6, 6, 6)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToolBar6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToolBar8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuAdministracao.setMnemonic('A');
        jMenuAdministracao.setText("   Administração");
        jMenuAdministracao.setToolTipText("");
        jMenuAdministracao.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenuAdministracaoMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });

        jMenuItemGerenciaAdministrativa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemGerenciaAdministrativa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/GerenciaAdministrativa18.png"))); // NOI18N
        jMenuItemGerenciaAdministrativa.setMnemonic('g');
        jMenuItemGerenciaAdministrativa.setText("Gerência Administativa");
        jMenuItemGerenciaAdministrativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGerenciaAdministrativaActionPerformed(evt);
            }
        });
        jMenuAdministracao.add(jMenuItemGerenciaAdministrativa);

        jMenuItemDiretoriaUnidade.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemDiretoriaUnidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Diretoria18.png"))); // NOI18N
        jMenuItemDiretoriaUnidade.setMnemonic('D');
        jMenuItemDiretoriaUnidade.setText("Diretoria Da Unidade");
        jMenuItemDiretoriaUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDiretoriaUnidadeActionPerformed(evt);
            }
        });
        jMenuAdministracao.add(jMenuItemDiretoriaUnidade);

        jMenuItemCRC.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCRC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/crc18.png"))); // NOI18N
        jMenuItemCRC.setMnemonic('C');
        jMenuItemCRC.setText("CRC");
        jMenuItemCRC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCRCActionPerformed(evt);
            }
        });
        jMenuAdministracao.add(jMenuItemCRC);

        jMenuItemAlmoxarifado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemAlmoxarifado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Almoxarifado18.png"))); // NOI18N
        jMenuItemAlmoxarifado.setMnemonic('A');
        jMenuItemAlmoxarifado.setText("Almoxarifafdo");
        jMenuItemAlmoxarifado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAlmoxarifadoActionPerformed(evt);
            }
        });
        jMenuAdministracao.add(jMenuItemAlmoxarifado);

        jMenuItemBancoVirtual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemBancoVirtual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Banco218.png"))); // NOI18N
        jMenuItemBancoVirtual.setMnemonic('B');
        jMenuItemBancoVirtual.setText("Banco Virtual");
        jMenuItemBancoVirtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBancoVirtualActionPerformed(evt);
            }
        });
        jMenuAdministracao.add(jMenuItemBancoVirtual);

        jMenuItemCompras.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Compras18.png"))); // NOI18N
        jMenuItemCompras.setMnemonic('O');
        jMenuItemCompras.setText("Compras");
        jMenuItemCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemComprasActionPerformed(evt);
            }
        });
        jMenuAdministracao.add(jMenuItemCompras);

        jMenuBar1.add(jMenuAdministracao);

        jMenuPSP.setMnemonic('P');
        jMenuPSP.setText("PSP/Corpo Técnico");
        jMenuPSP.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenuPSPMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });

        jMenuItemEnfermaria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemEnfermaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Enfermaria18.png"))); // NOI18N
        jMenuItemEnfermaria.setMnemonic('E');
        jMenuItemEnfermaria.setText("Enfermaria");
        jMenuItemEnfermaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEnfermariaActionPerformed(evt);
            }
        });
        jMenuPSP.add(jMenuItemEnfermaria);

        jMenuItemServicoSocial.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemServicoSocial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ServicoSocial.png"))); // NOI18N
        jMenuItemServicoSocial.setMnemonic('S');
        jMenuItemServicoSocial.setText("Serviço Social");
        jMenuItemServicoSocial.setToolTipText("");
        jMenuItemServicoSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemServicoSocialActionPerformed(evt);
            }
        });
        jMenuPSP.add(jMenuItemServicoSocial);

        jMenuItemPsicologia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemPsicologia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Psicologia18.png"))); // NOI18N
        jMenuItemPsicologia.setMnemonic('P');
        jMenuItemPsicologia.setText("Psicologia");
        jMenuItemPsicologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPsicologiaActionPerformed(evt);
            }
        });
        jMenuPSP.add(jMenuItemPsicologia);

        jMenuItemOdontologia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemOdontologia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Odontologia18.png"))); // NOI18N
        jMenuItemOdontologia.setMnemonic('O');
        jMenuItemOdontologia.setText("Odontologia");
        jMenuItemOdontologia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOdontologiaActionPerformed(evt);
            }
        });
        jMenuPSP.add(jMenuItemOdontologia);

        jMenuItemJuridico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemJuridico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Juridico18.png"))); // NOI18N
        jMenuItemJuridico.setMnemonic('J');
        jMenuItemJuridico.setText("Jurídico");
        jMenuItemJuridico.setToolTipText("");
        jMenuItemJuridico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemJuridicoActionPerformed(evt);
            }
        });
        jMenuPSP.add(jMenuItemJuridico);

        jMenuItemTO.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemTO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/TO18.png"))); // NOI18N
        jMenuItemTO.setMnemonic('T');
        jMenuItemTO.setText("Terapia Ocupacional");
        jMenuItemTO.setToolTipText("");
        jMenuItemTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTOActionPerformed(evt);
            }
        });
        jMenuPSP.add(jMenuItemTO);

        jMenuItemPedagogia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemPedagogia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Pedagogia_18.png"))); // NOI18N
        jMenuItemPedagogia.setMnemonic('G');
        jMenuItemPedagogia.setText("Pedagogia");
        jMenuItemPedagogia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPedagogiaActionPerformed(evt);
            }
        });
        jMenuPSP.add(jMenuItemPedagogia);

        jMenuItemEducacaoFisica.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemEducacaoFisica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/EducacaoFisica18.png"))); // NOI18N
        jMenuItemEducacaoFisica.setMnemonic('D');
        jMenuItemEducacaoFisica.setText("Educação Física");
        jMenuItemEducacaoFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEducacaoFisicaActionPerformed(evt);
            }
        });
        jMenuPSP.add(jMenuItemEducacaoFisica);

        jMenuItemNutricao.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemNutricao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Nutricao18.png"))); // NOI18N
        jMenuItemNutricao.setMnemonic('N');
        jMenuItemNutricao.setText("Nutrição");
        jMenuItemNutricao.setToolTipText("");
        jMenuItemNutricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNutricaoActionPerformed(evt);
            }
        });
        jMenuPSP.add(jMenuItemNutricao);

        jMenuItemFarmacia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemFarmacia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Farmacia18.png"))); // NOI18N
        jMenuItemFarmacia.setMnemonic('F');
        jMenuItemFarmacia.setText("Farmácia");
        jMenuItemFarmacia.setToolTipText("");
        jMenuItemFarmacia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFarmaciaActionPerformed(evt);
            }
        });
        jMenuPSP.add(jMenuItemFarmacia);

        jMenuBar1.add(jMenuPSP);

        jMenuOperacional.setMnemonic('O');
        jMenuOperacional.setText("Operacional");
        jMenuOperacional.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenuOperacionalMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });

        jMenuItemBase1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemBase1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Base1-18.png"))); // NOI18N
        jMenuItemBase1.setMnemonic('A');
        jMenuItemBase1.setText("Base I");
        jMenuItemBase1.setToolTipText("");
        jMenuItemBase1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBase1ActionPerformed(evt);
            }
        });
        jMenuOperacional.add(jMenuItemBase1);

        jMenuItemBase2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemBase2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Base2-18.png"))); // NOI18N
        jMenuItemBase2.setMnemonic('B');
        jMenuItemBase2.setText("Base II");
        jMenuItemBase2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBase2ActionPerformed(evt);
            }
        });
        jMenuOperacional.add(jMenuItemBase2);

        jMenuItemGerenciaOperacional.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemGerenciaOperacional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/G.Operacional.png"))); // NOI18N
        jMenuItemGerenciaOperacional.setMnemonic('G');
        jMenuItemGerenciaOperacional.setText("Gerência Operacional");
        jMenuItemGerenciaOperacional.setToolTipText("");
        jMenuItemGerenciaOperacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGerenciaOperacionalActionPerformed(evt);
            }
        });
        jMenuOperacional.add(jMenuItemGerenciaOperacional);

        jMenuItemPortariaInterna.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemPortariaInterna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/PInterna18.png"))); // NOI18N
        jMenuItemPortariaInterna.setMnemonic('P');
        jMenuItemPortariaInterna.setText("Portaria Interna");
        jMenuItemPortariaInterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPortariaInternaActionPerformed(evt);
            }
        });
        jMenuOperacional.add(jMenuItemPortariaInterna);

        jMenuItemPortariaExterna.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemPortariaExterna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/PExterna18.png"))); // NOI18N
        jMenuItemPortariaExterna.setMnemonic('E');
        jMenuItemPortariaExterna.setText("Portaria Externa");
        jMenuItemPortariaExterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPortariaExternaActionPerformed(evt);
            }
        });
        jMenuOperacional.add(jMenuItemPortariaExterna);

        jMenuItemTriagem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemTriagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Triagem2-18.png"))); // NOI18N
        jMenuItemTriagem.setMnemonic('T');
        jMenuItemTriagem.setText("Triagem");
        jMenuItemTriagem.setToolTipText("");
        jMenuItemTriagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTriagemActionPerformed(evt);
            }
        });
        jMenuOperacional.add(jMenuItemTriagem);

        jMenuBar1.add(jMenuOperacional);

        jMenuConfiguracoes.setMnemonic('C');
        jMenuConfiguracoes.setText("Configurações");
        jMenuConfiguracoes.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenuConfiguracoesMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Configuração18.png"))); // NOI18N
        jMenuItem2.setMnemonic('C');
        jMenuItem2.setText("Configurações");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuConfiguracoes.add(jMenuItem2);

        jMenuBar1.add(jMenuConfiguracoes);

        jMenuSobre.setMnemonic('S');
        jMenuSobre.setText("Sobre");
        jMenuSobre.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenuSobreMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Ajuda.png"))); // NOI18N
        jMenuItem1.setText("Sobre");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuSobre.add(jMenuItem1);

        jMenuBar1.add(jMenuSobre);

        jMenuSair.setForeground(new java.awt.Color(204, 0, 0));
        jMenuSair.setText("Sair");
        jMenuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSairMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanielPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanielPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloSindicancia Sind = new TelaModuloSindicancia();
                this.jPanielPrincipal.add(Sind);
                Sind.show();
                try {
                    Sind.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtSindicanciaActionPerformed

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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloConfiguracoes tc = new TelaModuloConfiguracoes();
                this.jPanielPrincipal.add(tc);
                tc.show();
                try {
                    tc.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtConfiguracoes2jBtConfiguracoesActionPerformed

    private void jBtBasePavilhaoDoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBasePavilhaoDoisActionPerformed
        // TODO add your handling code here:
        String grupoB2 = "BASE PAVILHAO DOIS";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoB2 = "Sim";
        String moduloB2 = "BASE PAVILHAO DOIS";
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoB2 + "' "
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
                            + "WHERE MODULOS.NomeModulo='" + moduloB2 + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoB2)) {
                    TelaModuloBaseDois objTelaBaseAuxiliar = new TelaModuloBaseDois();
                    this.jPanielPrincipal.add(objTelaBaseAuxiliar);
                    verificarParametrosBpa();
                    objTelaBaseAuxiliar.show();
                    try {
                        objTelaBaseAuxiliar.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtBasePavilhaoDoisActionPerformed

    private void jBtBasePavilhaoUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBasePavilhaoUmActionPerformed
        // TODO add your handling code here:
        String grupoB1 = "BASE PAVILHAO UM";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoB1 = "Sim";
        String moduloB1 = "BASE PAVILHAO UM";
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoB1 + "' "
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
                            + "WHERE MODULOS.NomeModulo='" + moduloB1 + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoB1)) {
                    TelaModuloBaseUm objTelaBaseGeral = new TelaModuloBaseUm();
                    this.jPanielPrincipal.add(objTelaBaseGeral);
                    verificarParametros();
                    objTelaBaseGeral.show();
                    try {
                        objTelaBaseGeral.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtBasePavilhaoUmActionPerformed

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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdm)) {
                TelaModuloTriagem objTriagem = new TelaModuloTriagem();
                this.jPanielPrincipal.add(objTriagem);
                objTriagem.show();
                try {
                    objTriagem.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtTriagemjBtUtilitariosActionPerformed

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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloPortariaExterna TprtExt = new TelaModuloPortariaExterna();
                this.jPanielPrincipal.add(TprtExt);
                TprtExt.show();
                try {
                    TprtExt.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtPortariaExternaActionPerformed

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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloPortarias Tprt = new TelaModuloPortarias();
                this.jPanielPrincipal.add(Tprt);
                Tprt.show();
                try {
                    Tprt.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtPortaria2jBtPortariaActionPerformed

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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloSeguranca ts = new TelaModuloSeguranca();
                this.jPanielPrincipal.add(ts);
                ts.show();
                try {
                    ts.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtSeguranca2jBtSegurancaActionPerformed

    private void jBtEducacaoFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtEducacaoFisicaActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Em desenvolvimento");
    }//GEN-LAST:event_jBtEducacaoFisicaActionPerformed

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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloFarmacia objTelaFarma = new TelaModuloFarmacia();
                this.jPanielPrincipal.add(objTelaFarma);
                objTelaFarma.show();
                try {
                    objTelaFarma.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtFarmaciajBtVazioActionPerformed

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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloNutricao objTelaNutricao = new TelaModuloNutricao();
                this.jPanielPrincipal.add(objTelaNutricao);
                objTelaNutricao.show();
                try {
                    objTelaNutricao.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtNutricaojBtVazioActionPerformed

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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloEnfermaria tm = new TelaModuloEnfermaria();
                this.jPanielPrincipal.add(tm);
                tm.show();
                try {
                    tm.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtServicoMedico2jBtServicoMedicoActionPerformed

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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtOdontologia2jBtOdontologiaActionPerformed

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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloPsicologia tps = new TelaModuloPsicologia();
                this.jPanielPrincipal.add(tps);
                tps.show();
                try {
                    tps.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtPsicologia2jBtPsicologiaActionPerformed

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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloTerapiaOcupacional tpo = new TelaModuloTerapiaOcupacional();
                this.jPanielPrincipal.add(tpo);
                tpo.show();
                try {
                    tpo.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloPedagogia tpf = new TelaModuloPedagogia();
                this.jPanielPrincipal.add(tpf);
                tpf.show();
                try {
                    tpf.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtPedagogia2jBtPedagogiaActionPerformed

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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloServicoSocial tss = new TelaModuloServicoSocial();
                this.jPanielPrincipal.add(tss);
                tss.show();
                try {
                    tss.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtServicoSocial2jBtServicoSocialActionPerformed

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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloJuridico tj = new TelaModuloJuridico();
                this.jPanielPrincipal.add(tj);
                tj.show();
                try {
                    tj.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtJuridico2jBtJuridicoActionPerformed

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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloCompras fer = new TelaModuloCompras();
                this.jPanielPrincipal.add(fer);
                fer.show();
                try {
                    fer.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtComprasjBtVazioActionPerformed

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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloAlmoxarifado taf = new TelaModuloAlmoxarifado();
                this.jPanielPrincipal.add(taf);
                taf.show();
                try {
                    taf.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtAlmoxarifado2jBtAlmoxarifadoActionPerformed

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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloFinanceiro tfin = new TelaModuloFinanceiro();
                this.jPanielPrincipal.add(tfin);
                tfin.show();
                try {
                    tfin.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtControleValores2jBtControleValoresActionPerformed

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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloCRC trc = new TelaModuloCRC();
                this.jPanielPrincipal.add(trc);
                trc.show();
                try {
                    trc.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtCRC2jBtCRCActionPerformed

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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloDiretoria objTelaDiretor = new TelaModuloDiretoria();
                this.jPanielPrincipal.add(objTelaDiretor);
                objTelaDiretor.show();
                try {
                    objTelaDiretor.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtDiretoriaActionPerformed

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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloAdmPessoal objAdm = new TelaModuloAdmPessoal();
                this.jPanielPrincipal.add(objAdm);
                objAdm.show();
                try {
                    objAdm.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jBtAdmPessoaljBtTriagemActionPerformed

    private void jBtTrocarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtTrocarSenhaActionPerformed
        // TODO add your handling code here:
        mostrarTelaTrocaSenha();
    }//GEN-LAST:event_jBtTrocarSenhaActionPerformed

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

    private void jMenuAdministracaoMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenuAdministracaoMenuKeyPressed
        // TODO add your handling code here:
        String grupoAdm = "ADMINISTRADORES";
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_G:
                String grupoAdmPes = "ADMPESSOAL";
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (nomeGrupo.equals(grupoAdministrador)) {
                        TelaModuloAdmPessoal objAdm = new TelaModuloAdmPessoal();
                        this.jPanielPrincipal.add(objAdm);
                        objAdm.show();
                        try {
                            objAdm.setMaximum(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                        }
                    }
                }
                break;
            case KeyEvent.VK_D:
                String grupoNut = "DIRETORES";
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (nomeGrupo.equals(grupoAdministrador)) {
                        TelaModuloDiretoria objTelaDiretor = new TelaModuloDiretoria();
                        this.jPanielPrincipal.add(objTelaDiretor);
                        objTelaDiretor.show();
                        try {
                            objTelaDiretor.setMaximum(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                        }
                    }
                }
                break;
            case KeyEvent.VK_C:
                String grupoCrc = "CRC";
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (nomeGrupo.equals(grupoAdministrador)) {
                        TelaModuloCRC trc = new TelaModuloCRC();
                        this.jPanielPrincipal.add(trc);
                        trc.show();
                        try {
                            trc.setMaximum(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                        }
                    }
                }
                break;
            case KeyEvent.VK_A:
                String grupoAlm = "ALMOXARIFADO";
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (nomeGrupo.equals(grupoAdministrador)) {
                        TelaModuloAlmoxarifado taf = new TelaModuloAlmoxarifado();
                        this.jPanielPrincipal.add(taf);
                        taf.show();
                        try {
                            taf.setMaximum(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                        }
                    }
                }
                break;
            case KeyEvent.VK_B:
                String grupoFin = "FINANCEIRO";
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (nomeGrupo.equals(grupoAdministrador)) {
                        TelaModuloFinanceiro tfin = new TelaModuloFinanceiro();
                        this.jPanielPrincipal.add(tfin);
                        tfin.show();
                        try {
                            tfin.setMaximum(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                        }
                    }
                }
                break;
            case KeyEvent.VK_O:
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (nomeGrupo.equals(grupoAdministrador)) {
                        TelaModuloCompras fer = new TelaModuloCompras();
                        this.jPanielPrincipal.add(fer);
                        fer.show();
                        try {
                            fer.setMaximum(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                        }
                    }
                }
                break;
        }
    }//GEN-LAST:event_jMenuAdministracaoMenuKeyPressed

    private void jMenuPSPMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenuPSPMenuKeyPressed
        // TODO add your handling code here:
        String grupoAdm = "ADMINISTRADORES";
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_E:
                String grupoMed = "ENFERMARIA";
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (nomeGrupo.equals(grupoAdministrador)) {
                        TelaModuloEnfermaria tm = new TelaModuloEnfermaria();
                        this.jPanielPrincipal.add(tm);
                        tm.show();
                        try {
                            tm.setMaximum(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                        }
                    }
                }
                break;
            case KeyEvent.VK_S:
                String grupoSer = "SERVICO SOCIAL";
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (nomeGrupo.equals(grupoAdministrador)) {
                        TelaModuloServicoSocial tss = new TelaModuloServicoSocial();
                        this.jPanielPrincipal.add(tss);
                        tss.show();
                        try {
                            tss.setMaximum(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                        }
                    }
                }
                break;
            case KeyEvent.VK_P:
                String grupoPsi = "PSICOLOGIA";
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (nomeGrupo.equals(grupoAdministrador)) {
                        TelaModuloPsicologia tps = new TelaModuloPsicologia();
                        this.jPanielPrincipal.add(tps);
                        tps.show();
                        try {
                            tps.setMaximum(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                        }
                    }
                }
                break;
            case KeyEvent.VK_L:
                String grupoOdon = "ODONTOLOGIA";
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                        }
                    }
                }
                break;
            case KeyEvent.VK_J:
                String grupoJuri = "JURIDICO";
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (nomeGrupo.equals(grupoAdministrador)) {
                        TelaModuloJuridico tj = new TelaModuloJuridico();
                        this.jPanielPrincipal.add(tj);
                        tj.show();
                        try {
                            tj.setMaximum(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                        }
                    }
                }
                break;
            case KeyEvent.VK_T:
                String grupoTera = "TERAPIA OCUPACIONAL";
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (nomeGrupo.equals(grupoAdministrador)) {
                        TelaModuloTerapiaOcupacional tpo = new TelaModuloTerapiaOcupacional();
                        this.jPanielPrincipal.add(tpo);
                        tpo.show();
                        try {
                            tpo.setMaximum(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                        }
                    }
                }
                break;
            case KeyEvent.VK_M:
                String grupoProf = "PEDAGOGIA";
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (nomeGrupo.equals(grupoAdministrador)) {
                        TelaModuloPedagogia tpf = new TelaModuloPedagogia();
                        this.jPanielPrincipal.add(tpf);
                        tpf.show();
                        try {
                            tpf.setMaximum(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                        }
                    }
                }
                break;
            case KeyEvent.VK_K:
                JOptionPane.showMessageDialog(rootPane, "Em desenvolvimento");
                break;
            case KeyEvent.VK_N:
                String grupoNut = "NUTRICAO";
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (nomeGrupo.equals(grupoAdministrador)) {
                        TelaModuloNutricao objTelaNutricao = new TelaModuloNutricao();
                        this.jPanielPrincipal.add(objTelaNutricao);
                        objTelaNutricao.show();
                        try {
                            objTelaNutricao.setMaximum(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                        }
                    }
                }
                break;
            case KeyEvent.VK_F:
                String grupoFar = "FARMACIA";
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (nomeGrupo.equals(grupoAdministrador)) {
                        TelaModuloFarmacia objTelaFarma = new TelaModuloFarmacia();
                        this.jPanielPrincipal.add(objTelaFarma);
                        objTelaFarma.show();
                        try {
                            objTelaFarma.setMaximum(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                        }
                    }
                }
                break;
        }
    }//GEN-LAST:event_jMenuPSPMenuKeyPressed

    private void jMenuOperacionalMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenuOperacionalMenuKeyPressed
        // TODO add your handling code here:
        String grupoAdm = "ADMINISTRADORES";
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_U:
                String grupoB1 = "BASE PAVILHAO UM";
                String permissaoGrupoB1 = "Sim";
                String moduloB1 = "BASE PAVILHAO UM";
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                            Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        conecta.abrirConexao();
                        try {
                            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                                    + "INNER JOIN GRUPOUSUARIOS "
                                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoB1 + "' "
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
                                    + "WHERE MODULOS.NomeModulo='" + moduloB1 + "' "
                                    + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                            conecta.rs.first();
                            idModulo = conecta.rs.getInt("IdModulo");
                            idGrupoModulo = conecta.rs.getInt("IdGrupo");
                            permissaoModulo = conecta.rs.getString("Permissao");
                        } catch (Exception er) {
                        }
                        conecta.desconecta();
                        if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoB1)) {
                            TelaModuloBaseUm objTelaBaseGeral = new TelaModuloBaseUm();
                            this.jPanielPrincipal.add(objTelaBaseGeral);
                            verificarParametros();
                            objTelaBaseGeral.show();
                            try {
                                objTelaBaseGeral.setMaximum(true);
                            } catch (PropertyVetoException ex) {
                                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                        }
                    }
                }
                break;
            case KeyEvent.VK_V:
                String grupoB2 = "BASE PAVILHAO DOIS";
                String permissaoGrupoB2 = "Sim";
                String moduloB2 = "BASE PAVILHAO DOIS";
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                            Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        conecta.abrirConexao();
                        try {
                            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                                    + "INNER JOIN GRUPOUSUARIOS "
                                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoB2 + "' "
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
                                    + "WHERE MODULOS.NomeModulo='" + moduloB2 + "' "
                                    + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                            conecta.rs.first();
                            idModulo = conecta.rs.getInt("IdModulo");
                            idGrupoModulo = conecta.rs.getInt("IdGrupo");
                            permissaoModulo = conecta.rs.getString("Permissao");
                        } catch (Exception er) {
                        }
                        conecta.desconecta();
                        if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoB2)) {
                            TelaModuloBaseDois objTelaBaseAuxiliar = new TelaModuloBaseDois();
                            this.jPanielPrincipal.add(objTelaBaseAuxiliar);
                            verificarParametrosBpa();
                            objTelaBaseAuxiliar.show();
                            try {
                                objTelaBaseAuxiliar.setMaximum(true);
                            } catch (PropertyVetoException ex) {
                                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                        }
                    }
                }
                break;
            case KeyEvent.VK_R:
                String grupoSeg = "SEGURANCA";
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (nomeGrupo.equals(grupoAdministrador)) {
                        TelaModuloSeguranca ts = new TelaModuloSeguranca();
                        this.jPanielPrincipal.add(ts);
                        ts.show();
                        try {
                            ts.setMaximum(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                        }
                    }
                }
                break;
            case KeyEvent.VK_Y:
                String grupoPort = "PORTARIA";
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (nomeGrupo.equals(grupoAdministrador)) {
                        TelaModuloPortarias Tprt = new TelaModuloPortarias();
                        this.jPanielPrincipal.add(Tprt);
                        Tprt.show();
                        try {
                            Tprt.setMaximum(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                        }
                    }
                }
                break;
            case KeyEvent.VK_X:
                String grupoPortX = "PORTARIA EXTERNA";
                String permissaoGrupoPortX = "Sim";
                String moduloPortX = "PORTARIA EXTERNA";
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (nomeGrupo.equals(grupoAdministrador)) {
                        TelaModuloPortariaExterna TprtExt = new TelaModuloPortariaExterna();
                        this.jPanielPrincipal.add(TprtExt);
                        TprtExt.show();
                        try {
                            TprtExt.setMaximum(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        conecta.abrirConexao();
                        try {
                            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                                    + "INNER JOIN GRUPOUSUARIOS "
                                    + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                                    + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoPortX + "' "
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
                                    + "WHERE MODULOS.NomeModulo='" + moduloPortX + "' "
                                    + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                            conecta.rs.first();
                            idModulo = conecta.rs.getInt("IdModulo");
                            idGrupoModulo = conecta.rs.getInt("IdGrupo");
                            permissaoModulo = conecta.rs.getString("Permissao");
                        } catch (Exception er) {
                        }
                        conecta.desconecta();
                        if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoPortX)) {
                            TelaModuloPortariaExterna TprtExt = new TelaModuloPortariaExterna();
                            this.jPanielPrincipal.add(TprtExt);
                            TprtExt.show();
                            try {
                                TprtExt.setMaximum(true);
                            } catch (PropertyVetoException ex) {
                                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                        }
                    }
                }
                break;
            case KeyEvent.VK_Z:
                String grupoTri = "TRIAGEM";
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (nomeGrupo.equals(grupoAdm)) {
                        TelaModuloTriagem objTriagem = new TelaModuloTriagem();
                        this.jPanielPrincipal.add(objTriagem);
                        objTriagem.show();
                        try {
                            objTriagem.setMaximum(true);
                        } catch (PropertyVetoException ex) {
                            Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                        }
                    }
                }
                break;
        }
    }//GEN-LAST:event_jMenuOperacionalMenuKeyPressed

    private void jMenuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSairMouseClicked
        // TODO add your handling code here:
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
    }//GEN-LAST:event_jMenuSairMouseClicked

    private void jMenuItemGerenciaAdministrativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGerenciaAdministrativaActionPerformed
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloAdmPessoal objAdm = new TelaModuloAdmPessoal();
                this.jPanielPrincipal.add(objAdm);
                objAdm.show();
                try {
                    objAdm.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItemGerenciaAdministrativaActionPerformed

    private void jMenuItemDiretoriaUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDiretoriaUnidadeActionPerformed
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloDiretoria objTelaDiretor = new TelaModuloDiretoria();
                this.jPanielPrincipal.add(objTelaDiretor);
                objTelaDiretor.show();
                try {
                    objTelaDiretor.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItemDiretoriaUnidadeActionPerformed

    private void jMenuItemCRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCRCActionPerformed
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloCRC trc = new TelaModuloCRC();
                this.jPanielPrincipal.add(trc);
                trc.show();
                try {
                    trc.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItemCRCActionPerformed

    private void jMenuItemAlmoxarifadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAlmoxarifadoActionPerformed
        // TODO add your handling code here:
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloAlmoxarifado taf = new TelaModuloAlmoxarifado();
                this.jPanielPrincipal.add(taf);
                taf.show();
                try {
                    taf.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItemAlmoxarifadoActionPerformed

    private void jMenuItemBancoVirtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBancoVirtualActionPerformed
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloFinanceiro tfin = new TelaModuloFinanceiro();
                this.jPanielPrincipal.add(tfin);
                tfin.show();
                try {
                    tfin.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItemBancoVirtualActionPerformed

    private void jMenuItemComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemComprasActionPerformed
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloCompras fer = new TelaModuloCompras();
                this.jPanielPrincipal.add(fer);
                fer.show();
                try {
                    fer.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItemComprasActionPerformed

    private void jMenuItemEnfermariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEnfermariaActionPerformed
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloEnfermaria tm = new TelaModuloEnfermaria();
                this.jPanielPrincipal.add(tm);
                tm.show();
                try {
                    tm.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItemEnfermariaActionPerformed

    private void jMenuItemServicoSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemServicoSocialActionPerformed
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloServicoSocial tss = new TelaModuloServicoSocial();
                this.jPanielPrincipal.add(tss);
                tss.show();
                try {
                    tss.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItemServicoSocialActionPerformed

    private void jMenuItemPsicologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPsicologiaActionPerformed
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloPsicologia tps = new TelaModuloPsicologia();
                this.jPanielPrincipal.add(tps);
                tps.show();
                try {
                    tps.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItemPsicologiaActionPerformed

    private void jMenuItemOdontologiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOdontologiaActionPerformed
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItemOdontologiaActionPerformed

    private void jMenuItemJuridicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemJuridicoActionPerformed
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloJuridico tj = new TelaModuloJuridico();
                this.jPanielPrincipal.add(tj);
                tj.show();
                try {
                    tj.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItemJuridicoActionPerformed

    private void jMenuItemTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTOActionPerformed
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloJuridico tj = new TelaModuloJuridico();
                this.jPanielPrincipal.add(tj);
                tj.show();
                try {
                    tj.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItemTOActionPerformed

    private void jMenuItemPedagogiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPedagogiaActionPerformed
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloPedagogia tpf = new TelaModuloPedagogia();
                this.jPanielPrincipal.add(tpf);
                tpf.show();
                try {
                    tpf.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItemPedagogiaActionPerformed

    private void jMenuItemEducacaoFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEducacaoFisicaActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Em desenvolvimento");
    }//GEN-LAST:event_jMenuItemEducacaoFisicaActionPerformed

    private void jMenuItemNutricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNutricaoActionPerformed
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloNutricao objTelaNutricao = new TelaModuloNutricao();
                this.jPanielPrincipal.add(objTelaNutricao);
                objTelaNutricao.show();
                try {
                    objTelaNutricao.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItemNutricaoActionPerformed

    private void jMenuItemFarmaciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFarmaciaActionPerformed
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloFarmacia objTelaFarma = new TelaModuloFarmacia();
                this.jPanielPrincipal.add(objTelaFarma);
                objTelaFarma.show();
                try {
                    objTelaFarma.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItemFarmaciaActionPerformed

    private void jMenuItemBase1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBase1ActionPerformed
        // TODO add your handling code here:
        String grupoB1 = "BASE PAVILHAO UM";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoB1 = "Sim";
        String moduloB1 = "BASE PAVILHAO UM";
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoB1 + "' "
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
                            + "WHERE MODULOS.NomeModulo='" + moduloB1 + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoB1)) {
                    TelaModuloBaseUm objTelaBaseGeral = new TelaModuloBaseUm();
                    this.jPanielPrincipal.add(objTelaBaseGeral);
                    verificarParametros();
                    objTelaBaseGeral.show();
                    try {
                        objTelaBaseGeral.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItemBase1ActionPerformed

    private void jMenuItemBase2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBase2ActionPerformed
        // TODO add your handling code here:
        String grupoB2 = "BASE PAVILHAO DOIS";
        String grupoAdm = "ADMINISTRADORES";
        String permissaoGrupoB2 = "Sim";
        String moduloB2 = "BASE PAVILHAO DOIS";
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                conecta.abrirConexao();
                try {
                    conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS "
                            + "INNER JOIN GRUPOUSUARIOS "
                            + "ON USUARIOS_GRUPOS.IdGrupo=GRUPOUSUARIOS.IdGrupo "
                            + "WHERE GRUPOUSUARIOS.NomeGrupo='" + grupoB2 + "' "
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
                            + "WHERE MODULOS.NomeModulo='" + moduloB2 + "' "
                            + "AND USUARIOS_MODULOS.IdUsuario='" + idUserAcesso + "'");
                    conecta.rs.first();
                    idModulo = conecta.rs.getInt("IdModulo");
                    idGrupoModulo = conecta.rs.getInt("IdGrupo");
                    permissaoModulo = conecta.rs.getString("Permissao");
                } catch (Exception er) {
                }
                conecta.desconecta();
                if (idGrupo == idGrupoModulo && permissaoModulo.equals(permissaoGrupoB2)) {
                    TelaModuloBaseDois objTelaBaseAuxiliar = new TelaModuloBaseDois();
                    this.jPanielPrincipal.add(objTelaBaseAuxiliar);
                    verificarParametrosBpa();
                    objTelaBaseAuxiliar.show();
                    try {
                        objTelaBaseAuxiliar.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItemBase2ActionPerformed

    private void jMenuItemGerenciaOperacionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGerenciaOperacionalActionPerformed
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloSeguranca ts = new TelaModuloSeguranca();
                this.jPanielPrincipal.add(ts);
                ts.show();
                try {
                    ts.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItemGerenciaOperacionalActionPerformed

    private void jMenuItemPortariaInternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPortariaInternaActionPerformed
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloPortarias Tprt = new TelaModuloPortarias();
                this.jPanielPrincipal.add(Tprt);
                Tprt.show();
                try {
                    Tprt.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItemPortariaInternaActionPerformed

    private void jMenuItemPortariaExternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPortariaExternaActionPerformed
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloPortariaExterna TprtExt = new TelaModuloPortariaExterna();
                this.jPanielPrincipal.add(TprtExt);
                TprtExt.show();
                try {
                    TprtExt.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItemPortariaExternaActionPerformed

    private void jMenuItemTriagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTriagemActionPerformed
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdm)) {
                TelaModuloTriagem objTriagem = new TelaModuloTriagem();
                this.jPanielPrincipal.add(objTriagem);
                objTriagem.show();
                try {
                    objTriagem.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItemTriagemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        mostrarSobre();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuConfiguracoesMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenuConfiguracoesMenuKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_F2) {
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
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (nomeGrupo.equals(grupoAdministrador)) {
                    TelaModuloConfiguracoes tc = new TelaModuloConfiguracoes();
                    this.jPanielPrincipal.add(tc);
                    tc.show();
                    try {
                        tc.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                            Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                    }
                }
            }
        }
    }//GEN-LAST:event_jMenuConfiguracoesMenuKeyPressed

    private void jMenuSobreMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenuSobreMenuKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_F1) {
            mostrarSobre();
        }
    }//GEN-LAST:event_jMenuSobreMenuKeyPressed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
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
                Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (nomeGrupo.equals(grupoAdministrador)) {
                TelaModuloConfiguracoes tc = new TelaModuloConfiguracoes();
                this.jPanielPrincipal.add(tc);
                tc.show();
                try {
                    tc.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(TelaModuloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "" + nameUser + " você não tem acesso a esse módulo, solicite liberação.");
                }
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaModuloPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaModuloPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaModuloPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaModuloPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new TelaModuloPrincipal().setVisible(true);

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
    private javax.swing.JButton jButton1;
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
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenuAdministracao;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenu jMenuConfiguracoes;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemAlmoxarifado;
    private javax.swing.JMenuItem jMenuItemBancoVirtual;
    private javax.swing.JMenuItem jMenuItemBase1;
    private javax.swing.JMenuItem jMenuItemBase2;
    private javax.swing.JMenuItem jMenuItemCRC;
    private javax.swing.JMenuItem jMenuItemCompras;
    private javax.swing.JMenuItem jMenuItemDiretoriaUnidade;
    private javax.swing.JMenuItem jMenuItemEducacaoFisica;
    private javax.swing.JMenuItem jMenuItemEnfermaria;
    private javax.swing.JMenuItem jMenuItemFarmacia;
    private javax.swing.JMenuItem jMenuItemGerenciaAdministrativa;
    private javax.swing.JMenuItem jMenuItemGerenciaOperacional;
    private javax.swing.JMenuItem jMenuItemJuridico;
    private javax.swing.JMenuItem jMenuItemNutricao;
    private javax.swing.JMenuItem jMenuItemOdontologia;
    private javax.swing.JMenuItem jMenuItemPedagogia;
    private javax.swing.JMenuItem jMenuItemPortariaExterna;
    private javax.swing.JMenuItem jMenuItemPortariaInterna;
    private javax.swing.JMenuItem jMenuItemPsicologia;
    private javax.swing.JMenuItem jMenuItemServicoSocial;
    private javax.swing.JMenuItem jMenuItemTO;
    private javax.swing.JMenuItem jMenuItemTriagem;
    private javax.swing.JMenu jMenuOperacional;
    private javax.swing.JMenu jMenuPSP;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JMenu jMenuSobre;
    private javax.swing.JLabel jNomeUnidade;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    public static javax.swing.JDesktopPane jPanielPrincipal;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JToolBar jToolBar8;
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
