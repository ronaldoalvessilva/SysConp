/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import Utilitarios.Criptografia;
import javax.swing.JOptionPane;
import Utilitarios.LimiteDigitosMin;
import gestor.Controle.ControlePesquisarEmpresaLogon;
import gestor.Controle.ControleVerificacaoAcessos;
import gestor.Modelo.ControleVersao;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static gestor.Dao.ConexaoBancoDados.caminhoConecta;
import gestor.Modelo.EmpresaUnidade;
import gestor.Modelo.ParametrosCrc;
import gestor.Modelo.Usuarios;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ronaldo
 */
// Inicio do desenvolvimento 20/03/2014
public class TelaLoginSenha extends javax.swing.JDialog {

    Usuarios objUsuarios = new Usuarios();
    ControleVersao versao = new ControleVersao();
    EmpresaUnidade objEmpresa = new EmpresaUnidade();
    ParametrosCrc objParametros = new ParametrosCrc();

    public static int Codstatus;
    public static String idUserAcesso; // CÓDIGO DO USUÁRIO PERMISSÕES DE ACESSO (24/04/2016)
    public static String nameUser; // Variavel para o nome do usuário logado
    public static long tamanhoOrigem, tamanhoDestino;
    public static long dataOrigem, dataDestino;
    // NOME DA EMPRESA E UNIDADE PENAL PARA SER UTILIZADO NA TELA PRINCIPAL E NOS RELATÓRIOS
    public static String razaoSocial;
    public static String descricaoUnidade;
    public static Double versaoAtualSistema;
    public static String enderecoUnidadePrisional;
    String bairroUnidade;
    String cidadeUnidade;
    String estadoUnidade;
    public static int codigoEmpresa = 0;
    //
    String caminhoExecutavel = "";
    String caminhoExecutavelAntigo = "";
    String dataVersao;
    String pSISTEMA_MANUTENCAO = "";
    //
    public static String hostNameSRV;
    public static String ipHostSRV;
    //
    String pUSUARIO_banco;
    String pSENHA_banco;
    String pSENHA1_CRIPTOGRAFA;
    //
    public static int pID_usuario = 0;
    String pLOGIN_usuario = "";
    String pNOME_usuario = "";
    String pSENHA_usuario = "";
    Date pDATA_cadastro;

    /**
     * Creates new form TelaLoginSenha
     *
     * @param parent
     * @param modal
     */
    public static TelaTrocaSenha_MD5 pSENHA_md5;

    public TelaLoginSenha(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        // Modelo de resolução de tela no Windows
        try {
//             JFrame.setDefaultLookAndFeelDecorated(true);      
//            SkinLookAndFeel.setSkin(SkinLookAndFeel.loadThemePack("/skins/coronaHthemepack.zip"));
//            UIManager.setLookAndFeel("com.l2fprod.gui.plaf.skin.SkinLookAndFeel");
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel ");
//            UIManager.setLookAndFeel("javax.swing.plaf.mac.MacLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
        initComponents();
        formatarCampos();
        // Modificar a tecla tab por enter
//        HashSet conj = new HashSet(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
//        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
//        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
    }

    public void mostrarTrocaSenha() {
        pSENHA_md5 = new TelaTrocaSenha_MD5(this, true);
        pSENHA_md5.setVisible(true);
    }

    public void acessarSistema() {
        if (jComboBoxUnidadePrisional.getSelectedItem().equals("Selecione...")) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma unidade prisional para acessar.");
        } else if (jComboBoxUnidadePrisional.getSelectedItem().equals("localhost")) {
            caminhoConecta = "C:\\SysConp\\Conecta.properties";
            BUSCAR_usuarios();
            BUSCAR_data();
            if(objUsuarios.getLogin() == null){
                JOptionPane.showMessageDialog(null, "ERROR: Não Foi possível localizar o LOGIN DO USUÁRIO, verifique se foi digitado o LOGIN correto do usuário.");
            }
            if (pDATA_cadastro == null && jUsuario.getText().equals(objUsuarios.getLogin())) {
                mostrarTrocaSenha();
            } else {
                pSENHA1_CRIPTOGRAFA = Criptografia.criptografar(jPassword.getText());
                if (jUsuario.getText().equals(pLOGIN_usuario)
                        && (pSENHA_usuario).equals(pSENHA1_CRIPTOGRAFA)
                        && Codstatus == 0) {
                    JOptionPane.showMessageDialog(null, "Usuário INATIVO !!!");
                } else {
                    if (jUsuario.getText().equals(pLOGIN_usuario)
                            && (pSENHA_usuario).equals(pSENHA1_CRIPTOGRAFA)
                            && (Codstatus == 1)) {
                        buscarEmpresa();
                        // COMPARAR O ARQUIVO EXECUTAVEL PARA REALIZAR ATUALIZAÇÃO
                        if (caminhoExecutavelAntigo == null) {
                            JOptionPane.showMessageDialog(rootPane, "O caminho do arquivo executável antigo não existe, solicite ajuda ao Administrador do Sistema.");
                        } else if (pSISTEMA_MANUTENCAO.equals("Sim") && !jUsuario.getText().equals("admin")) {
                            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, o sistema está temporariamente em manutenção, favor aguardar...");
                        } else {
                            File origem = new File(caminhoExecutavelAntigo);
                            dataOrigem = origem.lastModified(); // Data do arquivo de origem
                            tamanhoOrigem = origem.length();  // Tamanho do arquivo de origem        
                            File destino = new File("C://SysConp//SysConp.jar");
                            dataDestino = destino.lastModified();
                            tamanhoDestino = destino.length();
                            if (origem.exists() && destino.exists()) {
                                if (dataOrigem > dataDestino || tamanhoOrigem > tamanhoDestino) {
                                    int resposta = JOptionPane.showConfirmDialog(this, "Existe uma nova atualização, deseja fazer isso agora?", "Confirmação",
                                            JOptionPane.YES_NO_OPTION);
                                    if (resposta == JOptionPane.YES_OPTION) {
                                        // CHAMA O EXECUTAVEL DE INSTALAÇÃO
                                        Install_Sisconp();
                                        // UPDATE NO BANCO PARA ATUALIZAR A VERSÃO.
                                        versao.setVersao(Double.parseDouble(jNumeroVersao.getText()));
                                        versao.setDataVersao(dataVersao);
                                        ControlePesquisarEmpresaLogon control = new ControlePesquisarEmpresaLogon();
                                        control.alterarVersao(versao);
                                        System.exit(0);
                                    } else {
                                        versao.setVersao(Double.parseDouble(jNumeroVersao.getText()));
                                        if (versaoAtualSistema > versao.getVersao()) {
                                            JOptionPane.showMessageDialog(rootPane, "Não é possível acessar o sistema, seu sistema está desatualizado. Faça a atualização e só assim você poderá acessar o sistema.");
                                        } else {
                                            idUserAcesso = String.valueOf(pID_usuario);
                                            nameUser = pNOME_usuario;
                                            TelaModuloPrincipal tp = new TelaModuloPrincipal(jUsuario.getText(), nameUser);
                                            tp.setVisible(true);
                                            this.dispose();
                                        }
                                    }
                                } else {
                                    idUserAcesso = String.valueOf(pID_usuario);
                                    nameUser = pNOME_usuario;
                                    TelaModuloPrincipal tp = new TelaModuloPrincipal(jUsuario.getText(), nameUser);
                                    tp.setVisible(true);
                                    this.dispose();
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Usuario ou senha Inváldo, tente novamente !!!");
                        jUsuario.setText("");
                        jPassword.setText("");
                    }
                }
            }
        } else if (jComboBoxUnidadePrisional.getSelectedItem().equals("CPLF - Conjunto Penal de lauro de Freitas")) {
            caminhoConecta = "C:\\SysConp\\ConectaLF.properties";
            BUSCAR_usuarios();
            BUSCAR_data();
            if(objUsuarios.getLogin() == null){
                JOptionPane.showMessageDialog(null, "ERROR: Não Foi possível localizar o LOGIN DO USUÁRIO, verifique se foi digitado o LOGIN correto do usuário.");
            }
            if (pDATA_cadastro == null && jUsuario.getText().equals(objUsuarios.getLogin())) {
                mostrarTrocaSenha();
            } else {
                pSENHA1_CRIPTOGRAFA = Criptografia.criptografar(jPassword.getText());
                if (jUsuario.getText().equals(pLOGIN_usuario)
                        && (pSENHA_usuario).equals(pSENHA1_CRIPTOGRAFA)
                        && Codstatus == 0) {
                    JOptionPane.showMessageDialog(null, "Usuário INATIVO !!!");
                } else {
                    if (jUsuario.getText().equals(pLOGIN_usuario)
                            && (pSENHA_usuario).equals(pSENHA1_CRIPTOGRAFA)
                            && (Codstatus == 1)) {
                        buscarEmpresa();
                        // COMPARAR O ARQUIVO EXECUTAVEL PARA REALIZAR ATUALIZAÇÃO
                        if (caminhoExecutavelAntigo == null) {
                            JOptionPane.showMessageDialog(rootPane, "O caminho do arquivo executável antigo não existe, solicite ajuda ao Administrador do Sistema.");
                        } else if (pSISTEMA_MANUTENCAO.equals("Sim") && !jUsuario.getText().equals("admin")) {
                            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, o sistema está temporariamente em manutenção, favor aguardar...");
                        } else {
                            File origem = new File(caminhoExecutavelAntigo);
                            dataOrigem = origem.lastModified(); // Data do arquivo de origem
                            tamanhoOrigem = origem.length();  // Tamanho do arquivo de origem        
                            File destino = new File("C://SysConp//SysConp.jar");
                            dataDestino = destino.lastModified();
                            tamanhoDestino = destino.length();
                            if (origem.exists() && destino.exists()) {
                                if (dataOrigem > dataDestino || tamanhoOrigem > tamanhoDestino) {
                                    int resposta = JOptionPane.showConfirmDialog(this, "Existe uma nova atualização, deseja fazer isso agora?", "Confirmação",
                                            JOptionPane.YES_NO_OPTION);
                                    if (resposta == JOptionPane.YES_OPTION) {
                                        // CHAMA O EXECUTAVEL DE INSTALAÇÃO
                                        Install_Sisconp();
                                        // UPDATE NO BANCO PARA ATUALIZAR A VERSÃO.
                                        versao.setVersao(Double.parseDouble(jNumeroVersao.getText()));
                                        versao.setDataVersao(dataVersao);
                                        ControlePesquisarEmpresaLogon control = new ControlePesquisarEmpresaLogon();
                                        control.alterarVersao(versao);
                                        System.exit(0);
                                    } else {
                                        versao.setVersao(Double.parseDouble(jNumeroVersao.getText()));
                                        if (versaoAtualSistema > versao.getVersao()) {
                                            JOptionPane.showMessageDialog(rootPane, "Não é possível acessar o sistema, seu sistema está desatualizado. Faça a atualização e só assim você poderá acessar o sistema.");
                                        } else {
                                            idUserAcesso = String.valueOf(pID_usuario);
                                            nameUser = pNOME_usuario;
                                            TelaModuloPrincipal tp = new TelaModuloPrincipal(jUsuario.getText(), nameUser);
                                            tp.setVisible(true);
                                            this.dispose();
                                        }
                                    }
                                } else {
                                    idUserAcesso = String.valueOf(pID_usuario);
                                    nameUser = pNOME_usuario;
                                    TelaModuloPrincipal tp = new TelaModuloPrincipal(jUsuario.getText(), nameUser);
                                    tp.setVisible(true);
                                    this.dispose();
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Usuario ou senha Inváldo, tente novamente !!!");
                        jUsuario.setText("");
                        jPassword.setText("");
                    }
                }
            }
        } else if (jComboBoxUnidadePrisional.getSelectedItem().equals("CPMS - Conjunto Penal Masculino de Salvador")) {
            caminhoConecta = "C:\\SysConp\\ConectaSSA.properties";
            BUSCAR_usuarios();
            BUSCAR_data();
            if(objUsuarios.getLogin() == null){
                JOptionPane.showMessageDialog(null, "ERROR: Não Foi possível localizar o LOGIN DO USUÁRIO, verifique se foi digitado o LOGIN correto do usuário.");
            }
            if (pDATA_cadastro == null && jUsuario.getText().equals(objUsuarios.getLogin())) {
                mostrarTrocaSenha();
            } else {
                pSENHA1_CRIPTOGRAFA = Criptografia.criptografar(jPassword.getText());
                if (jUsuario.getText().equals(pLOGIN_usuario)
                        && (pSENHA_usuario).equals(pSENHA1_CRIPTOGRAFA)
                        && Codstatus == 0) {
                    JOptionPane.showMessageDialog(null, "Usuário INATIVO !!!");
                } else {
                    if (jUsuario.getText().equals(pLOGIN_usuario)
                            && (pSENHA_usuario).equals(pSENHA1_CRIPTOGRAFA)
                            && (Codstatus == 1)) {
                        buscarEmpresa();
                        // COMPARAR O ARQUIVO EXECUTAVEL PARA REALIZAR ATUALIZAÇÃO
                        if (caminhoExecutavelAntigo == null) {
                            JOptionPane.showMessageDialog(rootPane, "O caminho do arquivo executável antigo não existe, solicite ajuda ao Administrador do Sistema.");
                        } else if (pSISTEMA_MANUTENCAO.equals("Sim") && !jUsuario.getText().equals("admin")) {
                            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, o sistema está temporariamente em manutenção, favor aguardar...");
                        } else {
                            File origem = new File(caminhoExecutavelAntigo);
                            dataOrigem = origem.lastModified(); // Data do arquivo de origem
                            tamanhoOrigem = origem.length();  // Tamanho do arquivo de origem        
                            File destino = new File("C://SysConp//SysConp.jar");
                            dataDestino = destino.lastModified();
                            tamanhoDestino = destino.length();
                            if (origem.exists() && destino.exists()) {
                                if (dataOrigem > dataDestino || tamanhoOrigem > tamanhoDestino) {
                                    int resposta = JOptionPane.showConfirmDialog(this, "Existe uma nova atualização, deseja fazer isso agora?", "Confirmação",
                                            JOptionPane.YES_NO_OPTION);
                                    if (resposta == JOptionPane.YES_OPTION) {
                                        // CHAMA O EXECUTAVEL DE INSTALAÇÃO
                                        Install_Sisconp();
                                        // UPDATE NO BANCO PARA ATUALIZAR A VERSÃO.
                                        versao.setVersao(Double.parseDouble(jNumeroVersao.getText()));
                                        versao.setDataVersao(dataVersao);
                                        ControlePesquisarEmpresaLogon control = new ControlePesquisarEmpresaLogon();
                                        control.alterarVersao(versao);
                                        System.exit(0);
                                    } else {
                                        versao.setVersao(Double.parseDouble(jNumeroVersao.getText()));
                                        if (versaoAtualSistema > versao.getVersao()) {
                                            JOptionPane.showMessageDialog(rootPane, "Não é possível acessar o sistema, seu sistema está desatualizado. Faça a atualização e só assim você poderá acessar o sistema.");
                                        } else {
                                            idUserAcesso = String.valueOf(pID_usuario);
                                            nameUser = pNOME_usuario;
                                            TelaModuloPrincipal tp = new TelaModuloPrincipal(jUsuario.getText(), nameUser);
                                            tp.setVisible(true);
                                            this.dispose();
                                        }
                                    }
                                } else {
                                    idUserAcesso = String.valueOf(pID_usuario);
                                    nameUser = pNOME_usuario;
                                    TelaModuloPrincipal tp = new TelaModuloPrincipal(jUsuario.getText(), nameUser);
                                    tp.setVisible(true);
                                    this.dispose();
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Usuario ou senha Inváldo, tente novamente !!!");
                        jUsuario.setText("");
                        jPassword.setText("");
                    }
                }
            }
        } else if (jComboBoxUnidadePrisional.getSelectedItem().equals("CPIT - Conjunto Penal de Itabuna")) {
            caminhoConecta = "C:\\SysConp\\ConectaITB.properties";
            BUSCAR_usuarios();
            BUSCAR_data();
            if(objUsuarios.getLogin() == null){
                JOptionPane.showMessageDialog(null, "ERROR: Não Foi possível localizar o LOGIN DO USUÁRIO, verifique se foi digitado o LOGIN correto do usuário.");
            }
            if (pDATA_cadastro == null && jUsuario.getText().equals(objUsuarios.getLogin())) {
                mostrarTrocaSenha();
            } else {
                pSENHA1_CRIPTOGRAFA = Criptografia.criptografar(jPassword.getText());
                if (jUsuario.getText().equals(pLOGIN_usuario)
                        && (pSENHA_usuario).equals(pSENHA1_CRIPTOGRAFA)
                        && Codstatus == 0) {
                    JOptionPane.showMessageDialog(null, "Usuário INATIVO !!!");
                } else {
                    if (jUsuario.getText().equals(pLOGIN_usuario)
                            && (pSENHA_usuario).equals(pSENHA1_CRIPTOGRAFA)
                            && (Codstatus == 1)) {
                        buscarEmpresa();
                        // COMPARAR O ARQUIVO EXECUTAVEL PARA REALIZAR ATUALIZAÇÃO
                        if (caminhoExecutavelAntigo == null) {
                            JOptionPane.showMessageDialog(rootPane, "O caminho do arquivo executável antigo não existe, solicite ajuda ao Administrador do Sistema.");
                        } else if (pSISTEMA_MANUTENCAO.equals("Sim") && !jUsuario.getText().equals("admin")) {
                            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, o sistema está temporariamente em manutenção, favor aguardar...");
                        } else {
                            File origem = new File(caminhoExecutavelAntigo);
                            dataOrigem = origem.lastModified(); // Data do arquivo de origem
                            tamanhoOrigem = origem.length();  // Tamanho do arquivo de origem        
                            File destino = new File("C://SysConp//SysConp.jar");
                            dataDestino = destino.lastModified();
                            tamanhoDestino = destino.length();
                            if (origem.exists() && destino.exists()) {
                                if (dataOrigem > dataDestino || tamanhoOrigem > tamanhoDestino) {
                                    int resposta = JOptionPane.showConfirmDialog(this, "Existe uma nova atualização, deseja fazer isso agora?", "Confirmação",
                                            JOptionPane.YES_NO_OPTION);
                                    if (resposta == JOptionPane.YES_OPTION) {
                                        // CHAMA O EXECUTAVEL DE INSTALAÇÃO
                                        Install_Sisconp();
                                        // UPDATE NO BANCO PARA ATUALIZAR A VERSÃO.
                                        versao.setVersao(Double.parseDouble(jNumeroVersao.getText()));
                                        versao.setDataVersao(dataVersao);
                                        ControlePesquisarEmpresaLogon control = new ControlePesquisarEmpresaLogon();
                                        control.alterarVersao(versao);
                                        System.exit(0);
                                    } else {
                                        versao.setVersao(Double.parseDouble(jNumeroVersao.getText()));
                                        if (versaoAtualSistema > versao.getVersao()) {
                                            JOptionPane.showMessageDialog(rootPane, "Não é possível acessar o sistema, seu sistema está desatualizado. Faça a atualização e só assim você poderá acessar o sistema.");
                                        } else {
                                            idUserAcesso = String.valueOf(pID_usuario);
                                            nameUser = pNOME_usuario;
                                            TelaModuloPrincipal tp = new TelaModuloPrincipal(jUsuario.getText(), nameUser);
                                            tp.setVisible(true);
                                            this.dispose();
                                        }
                                    }
                                } else {
                                    idUserAcesso = String.valueOf(pID_usuario);
                                    nameUser = pNOME_usuario;
                                    TelaModuloPrincipal tp = new TelaModuloPrincipal(jUsuario.getText(), nameUser);
                                    tp.setVisible(true);
                                    this.dispose();
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Usuario ou senha Inváldo, tente novamente !!!");
                        jUsuario.setText("");
                        jPassword.setText("");
                    }
                }
            }
        } else if (jComboBoxUnidadePrisional.getSelectedItem().equals("CPVC - Conjunto Penal de Vitória da Conquista")) {
            caminhoConecta = "C:\\SysConp\\ConectaVC.properties";
            BUSCAR_usuarios();
            BUSCAR_data();
            if(objUsuarios.getLogin() == null){
                JOptionPane.showMessageDialog(null, "ERROR: Não Foi possível localizar o LOGIN DO USUÁRIO, verifique se foi digitado o LOGIN correto do usuário.");
            }
            if (pDATA_cadastro == null && jUsuario.getText().equals(objUsuarios.getLogin())) {
                mostrarTrocaSenha();
            } else {
                pSENHA1_CRIPTOGRAFA = Criptografia.criptografar(jPassword.getText());
                if (jUsuario.getText().equals(pLOGIN_usuario)
                        && (pSENHA_usuario).equals(pSENHA1_CRIPTOGRAFA)
                        && Codstatus == 0) {
                    JOptionPane.showMessageDialog(null, "Usuário INATIVO !!!");
                } else {
                    if (jUsuario.getText().equals(pLOGIN_usuario)
                            && (pSENHA_usuario).equals(pSENHA1_CRIPTOGRAFA)
                            && (Codstatus == 1)) {
                        buscarEmpresa();
                        // COMPARAR O ARQUIVO EXECUTAVEL PARA REALIZAR ATUALIZAÇÃO
                        if (caminhoExecutavelAntigo == null) {
                            JOptionPane.showMessageDialog(rootPane, "O caminho do arquivo executável antigo não existe, solicite ajuda ao Administrador do Sistema.");
                        } else if (pSISTEMA_MANUTENCAO.equals("Sim") && !jUsuario.getText().equals("admin")) {
                            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, o sistema está temporariamente em manutenção, favor aguardar...");
                        } else {
                            File origem = new File(caminhoExecutavelAntigo);
                            dataOrigem = origem.lastModified(); // Data do arquivo de origem
                            tamanhoOrigem = origem.length();  // Tamanho do arquivo de origem        
                            File destino = new File("C://SysConp//SysConp.jar");
                            dataDestino = destino.lastModified();
                            tamanhoDestino = destino.length();
                            if (origem.exists() && destino.exists()) {
                                if (dataOrigem > dataDestino || tamanhoOrigem > tamanhoDestino) {
                                    int resposta = JOptionPane.showConfirmDialog(this, "Existe uma nova atualização, deseja fazer isso agora?", "Confirmação",
                                            JOptionPane.YES_NO_OPTION);
                                    if (resposta == JOptionPane.YES_OPTION) {
                                        // CHAMA O EXECUTAVEL DE INSTALAÇÃO
                                        Install_Sisconp();
                                        // UPDATE NO BANCO PARA ATUALIZAR A VERSÃO.
                                        versao.setVersao(Double.parseDouble(jNumeroVersao.getText()));
                                        versao.setDataVersao(dataVersao);
                                        ControlePesquisarEmpresaLogon control = new ControlePesquisarEmpresaLogon();
                                        control.alterarVersao(versao);
                                        System.exit(0);
                                    } else {
                                        versao.setVersao(Double.parseDouble(jNumeroVersao.getText()));
                                        if (versaoAtualSistema > versao.getVersao()) {
                                            JOptionPane.showMessageDialog(rootPane, "Não é possível acessar o sistema, seu sistema está desatualizado. Faça a atualização e só assim você poderá acessar o sistema.");
                                        } else {
                                            idUserAcesso = String.valueOf(pID_usuario);
                                            nameUser = pNOME_usuario;
                                            TelaModuloPrincipal tp = new TelaModuloPrincipal(jUsuario.getText(), nameUser);
                                            tp.setVisible(true);
                                            this.dispose();
                                        }
                                    }
                                } else {
                                    idUserAcesso = String.valueOf(pID_usuario);
                                    nameUser = pNOME_usuario;
                                    TelaModuloPrincipal tp = new TelaModuloPrincipal(jUsuario.getText(), nameUser);
                                    tp.setVisible(true);
                                    this.dispose();
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Usuario ou senha Inváldo, tente novamente !!!");
                        jUsuario.setText("");
                        jPassword.setText("");
                    }
                }
            }
        } else if (jComboBoxUnidadePrisional.getSelectedItem().equals("CPBA - Conjunto Penal de Barreiras")) {
            caminhoConecta = "C:\\SysConp\\ConectaBAR.properties";
            BUSCAR_usuarios();
            BUSCAR_data();
            if(objUsuarios.getLogin() == null){
                JOptionPane.showMessageDialog(null, "ERROR: Não Foi possível localizar o LOGIN DO USUÁRIO, verifique se foi digitado o LOGIN correto do usuário.");
            }
            if (pDATA_cadastro == null && jUsuario.getText().equals(objUsuarios.getLogin())) {
                mostrarTrocaSenha();
            } else {
                pSENHA1_CRIPTOGRAFA = Criptografia.criptografar(jPassword.getText());
                if (jUsuario.getText().equals(pLOGIN_usuario)
                        && (pSENHA_usuario).equals(pSENHA1_CRIPTOGRAFA)
                        && Codstatus == 0) {
                    JOptionPane.showMessageDialog(null, "Usuário INATIVO !!!");
                } else {
                    if (jUsuario.getText().equals(pLOGIN_usuario)
                            && (pSENHA_usuario).equals(pSENHA1_CRIPTOGRAFA)
                            && (Codstatus == 1)) {
                        buscarEmpresa();
                        // COMPARAR O ARQUIVO EXECUTAVEL PARA REALIZAR ATUALIZAÇÃO
                        if (caminhoExecutavelAntigo == null) {
                            JOptionPane.showMessageDialog(rootPane, "O caminho do arquivo executável antigo não existe, solicite ajuda ao Administrador do Sistema.");
                        } else if (pSISTEMA_MANUTENCAO.equals("Sim") && !jUsuario.getText().equals("admin")) {
                            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, o sistema está temporariamente em manutenção, favor aguardar...");
                        } else {
                            File origem = new File(caminhoExecutavelAntigo);
                            dataOrigem = origem.lastModified(); // Data do arquivo de origem
                            tamanhoOrigem = origem.length();  // Tamanho do arquivo de origem        
                            File destino = new File("C://SysConp//SysConp.jar");
                            dataDestino = destino.lastModified();
                            tamanhoDestino = destino.length();
                            if (origem.exists() && destino.exists()) {
                                if (dataOrigem > dataDestino || tamanhoOrigem > tamanhoDestino) {
                                    int resposta = JOptionPane.showConfirmDialog(this, "Existe uma nova atualização, deseja fazer isso agora?", "Confirmação",
                                            JOptionPane.YES_NO_OPTION);
                                    if (resposta == JOptionPane.YES_OPTION) {
                                        // CHAMA O EXECUTAVEL DE INSTALAÇÃO
                                        Install_Sisconp();
                                        // UPDATE NO BANCO PARA ATUALIZAR A VERSÃO.
                                        versao.setVersao(Double.parseDouble(jNumeroVersao.getText()));
                                        versao.setDataVersao(dataVersao);
                                        ControlePesquisarEmpresaLogon control = new ControlePesquisarEmpresaLogon();
                                        control.alterarVersao(versao);
                                        System.exit(0);
                                    } else {
                                        versao.setVersao(Double.parseDouble(jNumeroVersao.getText()));
                                        if (versaoAtualSistema > versao.getVersao()) {
                                            JOptionPane.showMessageDialog(rootPane, "Não é possível acessar o sistema, seu sistema está desatualizado. Faça a atualização e só assim você poderá acessar o sistema.");
                                        } else {
                                            idUserAcesso = String.valueOf(pID_usuario);
                                            nameUser = pNOME_usuario;
                                            TelaModuloPrincipal tp = new TelaModuloPrincipal(jUsuario.getText(), nameUser);
                                            tp.setVisible(true);
                                            this.dispose();
                                        }
                                    }
                                } else {
                                    idUserAcesso = String.valueOf(pID_usuario);
                                    nameUser = pNOME_usuario;
                                    TelaModuloPrincipal tp = new TelaModuloPrincipal(jUsuario.getText(), nameUser);
                                    tp.setVisible(true);
                                    this.dispose();
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Usuario ou senha Inváldo, tente novamente !!!");
                        jUsuario.setText("");
                        jPassword.setText("");
                    }
                }
            }
        } else if (jComboBoxUnidadePrisional.getSelectedItem().equals("CPLF - Conjunto Penal de lauro de Freitas")) {
            caminhoConecta = "C:\\SysConp\\ConectaLF.properties";
            BUSCAR_usuarios();
            BUSCAR_data();
            if(objUsuarios.getLogin() == null){
                JOptionPane.showMessageDialog(null, "ERROR: Não Foi possível localizar o LOGIN DO USUÁRIO, verifique se foi digitado o LOGIN correto do usuário.");
            }
            if (pDATA_cadastro == null && jUsuario.getText().equals(objUsuarios.getLogin())) {
                mostrarTrocaSenha();
            } else {
                pSENHA1_CRIPTOGRAFA = Criptografia.criptografar(jPassword.getText());
                if (jUsuario.getText().equals(pLOGIN_usuario)
                        && (pSENHA_usuario).equals(pSENHA1_CRIPTOGRAFA)
                        && Codstatus == 0) {
                    JOptionPane.showMessageDialog(null, "Usuário INATIVO !!!");
                } else {
                    if (jUsuario.getText().equals(pLOGIN_usuario)
                            && (pSENHA_usuario).equals(pSENHA1_CRIPTOGRAFA)
                            && (Codstatus == 1)) {
                        buscarEmpresa();
                        // COMPARAR O ARQUIVO EXECUTAVEL PARA REALIZAR ATUALIZAÇÃO
                        if (caminhoExecutavelAntigo == null) {
                            JOptionPane.showMessageDialog(rootPane, "O caminho do arquivo executável antigo não existe, solicite ajuda ao Administrador do Sistema.");
                        } else if (pSISTEMA_MANUTENCAO.equals("Sim") && !jUsuario.getText().equals("admin")) {
                            JOptionPane.showMessageDialog(rootPane, "Acesso não autorizado, o sistema está temporariamente em manutenção, favor aguardar...");
                        } else {
                            File origem = new File(caminhoExecutavelAntigo);
                            dataOrigem = origem.lastModified(); // Data do arquivo de origem
                            tamanhoOrigem = origem.length();  // Tamanho do arquivo de origem        
                            File destino = new File("C://SysConp//SysConp.jar");
                            dataDestino = destino.lastModified();
                            tamanhoDestino = destino.length();
                            if (origem.exists() && destino.exists()) {
                                if (dataOrigem > dataDestino || tamanhoOrigem > tamanhoDestino) {
                                    int resposta = JOptionPane.showConfirmDialog(this, "Existe uma nova atualização, deseja fazer isso agora?", "Confirmação",
                                            JOptionPane.YES_NO_OPTION);
                                    if (resposta == JOptionPane.YES_OPTION) {
                                        // CHAMA O EXECUTAVEL DE INSTALAÇÃO
                                        Install_Sisconp();
                                        // UPDATE NO BANCO PARA ATUALIZAR A VERSÃO.
                                        versao.setVersao(Double.parseDouble(jNumeroVersao.getText()));
                                        versao.setDataVersao(dataVersao);
                                        ControlePesquisarEmpresaLogon control = new ControlePesquisarEmpresaLogon();
                                        control.alterarVersao(versao);
                                        System.exit(0);
                                    } else {
                                        versao.setVersao(Double.parseDouble(jNumeroVersao.getText()));
                                        if (versaoAtualSistema > versao.getVersao()) {
                                            JOptionPane.showMessageDialog(rootPane, "Não é possível acessar o sistema, seu sistema está desatualizado. Faça a atualização e só assim você poderá acessar o sistema.");
                                        } else {
                                            idUserAcesso = String.valueOf(pID_usuario);
                                            nameUser = pNOME_usuario;
                                            TelaModuloPrincipal tp = new TelaModuloPrincipal(jUsuario.getText(), nameUser);
                                            tp.setVisible(true);
                                            this.dispose();
                                        }
                                    }
                                } else {
                                    idUserAcesso = String.valueOf(pID_usuario);
                                    nameUser = pNOME_usuario;
                                    TelaModuloPrincipal tp = new TelaModuloPrincipal(jUsuario.getText(), nameUser);
                                    tp.setVisible(true);
                                    this.dispose();
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Usuario ou senha Inváldo, tente novamente !!!");
                        jUsuario.setText("");
                        jPassword.setText("");
                    }
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jNumeroVersao = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jUsuario = new javax.swing.JTextField();
        jBtCancelar = new javax.swing.JButton();
        jBtAcessar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxUnidadePrisional = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("...::: Tela de Acesso :::...");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/gestor/Imagens/FavonIconJFrame100.png")));
        setResizable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "SISCONP - Sistema de Controle Prisional", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 0, 204))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Logomarcas do sistema", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 0))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Brasao96.png"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/logoSocializa200RAS.png"))); // NOI18N
        jLabel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Versão do Sistema:");

        jNumeroVersao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jNumeroVersao.setForeground(new java.awt.Color(255, 0, 0));
        jNumeroVersao.setText("6.2-8.2020-F");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Copyright ©  2014 - by R.A.S/S.L.S");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jNumeroVersao)))
                        .addGap(0, 28, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jNumeroVersao, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Login e Senha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Senha:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Usuário:");

        jPassword.setToolTipText("Informe Senha de no máximo 21 caracteres");
        jPassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });
        jPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordKeyPressed(evt);
            }
        });

        jUsuario.setToolTipText("Informe Nome de Usuário");
        jUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUsuarioActionPerformed(evt);
            }
        });
        jUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jUsuarioKeyPressed(evt);
            }
        });

        jBtCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/shutdown-icone-6920-32.png"))); // NOI18N
        jBtCancelar.setText("Cancelar");
        jBtCancelar.setToolTipText("Cancelar operação");
        jBtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCancelarActionPerformed(evt);
            }
        });

        jBtAcessar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtAcessar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ok-icon32.png"))); // NOI18N
        jBtAcessar.setText("Acessar");
        jBtAcessar.setToolTipText("Acessar sistema");
        jBtAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAcessarActionPerformed(evt);
            }
        });
        jBtAcessar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBtAcessarKeyPressed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/User_login_Icon_64.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("Unidade:");

        jComboBoxUnidadePrisional.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxUnidadePrisional.setForeground(new java.awt.Color(204, 0, 0));
        jComboBoxUnidadePrisional.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "localhost", "CPLF - Conjunto Penal de lauro de Freitas", "CPMS - Conjunto Penal Masculino de Salvador", "CPIT - Conjunto Penal de Itabuna", "CPVC - Conjunto Penal de Vitória da Conquista", "CPBA - Conjunto Penal de Barreiras" }));
        jComboBoxUnidadePrisional.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxUnidadePrisional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUnidadePrisionalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jUsuario)
                            .addComponent(jPassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBoxUnidadePrisional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtAcessar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtCancelar)
                .addGap(30, 30, 30))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtAcessar, jBtCancelar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBoxUnidadePrisional, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtAcessar)
                    .addComponent(jBtCancelar))
                .addGap(13, 13, 13))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtAcessar, jBtCancelar});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAcessarActionPerformed
        // TODO add your handling code here:        
        acessarSistema();
    }//GEN-LAST:event_jBtAcessarActionPerformed

    private void jBtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCancelarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jBtCancelarActionPerformed

    private void jBtAcessarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBtAcessarKeyPressed
//       if(evt.getKeyCode() == KeyEvent.VK_ENTER)
//            acessarSistema();

    }//GEN-LAST:event_jBtAcessarKeyPressed

    private void jPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            acessarSistema();
        }
    }//GEN-LAST:event_jPasswordKeyPressed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        jComboBoxUnidadePrisional.requestFocus();
    }//GEN-LAST:event_jPasswordActionPerformed

    private void jUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jPassword.requestFocus();
        }
    }//GEN-LAST:event_jUsuarioKeyPressed

    private void jUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUsuarioActionPerformed

    private void jComboBoxUnidadePrisionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUnidadePrisionalActionPerformed
        jBtAcessar.requestFocus();
    }//GEN-LAST:event_jComboBoxUnidadePrisionalActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLoginSenha.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLoginSenha.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLoginSenha.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLoginSenha.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaLoginSenha dialog = new TelaLoginSenha(new javax.swing.JFrame(), true);
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
    public static javax.swing.JButton jBtAcessar;
    public static javax.swing.JButton jBtCancelar;
    public static javax.swing.JComboBox<String> jComboBoxUnidadePrisional;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jNumeroVersao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JPasswordField jPassword;
    public static javax.swing.JTextField jUsuario;
    // End of variables declaration//GEN-END:variables

    public void formatarCampos() {
        jUsuario.setDocument(new LimiteDigitosMin(21));
        jPassword.setDocument(new LimiteDigitosMin(21));
    }

    public void BUSCAR_data() {
        ControlePesquisarEmpresaLogon p = new ControlePesquisarEmpresaLogon();
        p.PESQUISAR_data(objUsuarios);
        pDATA_cadastro = objUsuarios.getDataCadastro();
    }

    public void BUSCAR_usuarios() {
        ControleVerificacaoAcessos VERIFICAR_usuario = new ControleVerificacaoAcessos();
        try {
            for (Usuarios dd : VERIFICAR_usuario.read()) {
                pID_usuario = dd.getIdUsuario();
                pLOGIN_usuario = dd.getLogin();
                pNOME_usuario = dd.getNomeUsuario();
                pSENHA_usuario = dd.getSenha1();
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaLoginSenha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizarSistema() throws FileNotFoundException, IOException {
        // Arquivos que iremos copiar
        File origem = new File("R://SysConp//SysConp.jar");
        dataOrigem = origem.lastModified(); // Data do arquivo de origem
        tamanhoOrigem = origem.length();  // Tamanho do arquivo de origem        
        File destino = new File("C://SysConp//SysConp.jar");
        dataDestino = destino.lastModified();
        tamanhoDestino = destino.length();
        if (origem.exists() && destino.exists()) {
            final File dirOrigem = new File("R://SysConp//");
            final File dirDestino = new File("C://SysConp//");
            if (dataOrigem > dataDestino || tamanhoOrigem > tamanhoDestino) {
                this.dispose();
                FormAtualizaSistema ta = new FormAtualizaSistema();
                ta.setVisible(true);
                ta.toFront();
            }
        }
    }

    public void buscarEmpresa() {
        SimpleDateFormat formatoAmerica = new SimpleDateFormat("dd/MM/yyyy");
        //PESQUISAR DADOS DA EMPRESA
        ControlePesquisarEmpresaLogon pPESQUISAS_empresa = new ControlePesquisarEmpresaLogon();
        pPESQUISAS_empresa.PESQUISAR_empresa(objEmpresa);
        codigoEmpresa = objEmpresa.getIdEmpresa();
        razaoSocial = objEmpresa.getDescricaoEmpresa();
        descricaoUnidade = objEmpresa.getDescricaoUnidade();
        versaoAtualSistema = objEmpresa.getVersaoAtual();
        //ENDEREÇO PARA O RELATÓRIO DE CUMPRIMENTO E NÃO CUMPRIMENTO DE ALVARÁ. (02/03/2018) - BARREIRAS.
        pPESQUISAS_empresa.PESQUISAR_unidade(objEmpresa);
        enderecoUnidadePrisional = objEmpresa.getEndereco();
        bairroUnidade = objEmpresa.getBairro();
        cidadeUnidade = objEmpresa.getCidade();
        estadoUnidade = objEmpresa.getEstado();
        enderecoUnidadePrisional = enderecoUnidadePrisional + " " + cidadeUnidade + " " + estadoUnidade;
        //PESQUISAR DADOS DO PARAMÊTRO
        pPESQUISAS_empresa.PESQUISAR_parametros(objParametros);
        caminhoExecutavel = objParametros.getCaminhoAtualizaSis();
        caminhoExecutavelAntigo = objParametros.getCaminhoExecAntigo();
        dataVersao = formatoAmerica.format(objParametros.getDataVersao().getTime());
        pSISTEMA_MANUTENCAO = objParametros.getSistemaManutencao();
    }

    public void Install_Sisconp() {
        try {
            Process p = Runtime.getRuntime().exec(caminhoExecutavel);
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void buscarIpNomeSRV() {

        InetAddress myself;
        try {
            myself = InetAddress.getLocalHost();
            ipHostSRV = myself.getHostAddress();
            hostNameSRV = myself.getHostName();
        } catch (UnknownHostException ex) {
            Logger.getLogger(TelaLoginSenha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
