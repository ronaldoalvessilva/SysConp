/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleDadosFisicos;
import gestor.Controle.ControleDadosPenais;
import gestor.Controle.ControleInternoCrc;
import gestor.Controle.ControleLogSistema;
import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ConexaoBancoDadosBAR;
import gestor.Dao.ConexaoBancoDadosITB;
import gestor.Dao.ConexaoBancoDadosLF;
import gestor.Dao.ConexaoBancoDadosSSA;
import gestor.Dao.ConexaoBancoDadosVC;
import Utilitarios.LimiteDigitos;
import Utilitarios.LimiteDigitosAlfa;
import Utilitarios.LimiteDigitosNum;
import Utilitarios.LimiteDigitosSoNum;
import gestor.Modelo.DadosFisicosInternos;
import gestor.Modelo.DadosPenaisCrc;
import gestor.Modelo.LogSistema;
import gestor.Modelo.ProntuarioCrc;
import static gestor.Visao.ConsultaGerencialInternosUnidade.jIdInternoExt;
import static gestor.Visao.ConsultaGerencialInternosUnidade.jTabelaInterno;
import static gestor.Visao.ConsultaGerencialInternosUnidade.nomeUnidadeBAR;
import static gestor.Visao.ConsultaGerencialInternosUnidade.nomeUnidadeITB;
import static gestor.Visao.ConsultaGerencialInternosUnidade.nomeUnidadeLF;
import static gestor.Visao.ConsultaGerencialInternosUnidade.nomeUnidadeSSA;
import static gestor.Visao.ConsultaGerencialInternosUnidade.nomeUnidadeVC;
import static gestor.Visao.TelaLoginSenha.nameUser;
import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author user
 */
public final class TelaConsultaProntuarioInternoCrcExt extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ConexaoBancoDadosSSA conectaSSA = new ConexaoBancoDadosSSA();
    ConexaoBancoDadosITB conectaITB = new ConexaoBancoDadosITB();
    ConexaoBancoDadosVC conectaVC = new ConexaoBancoDadosVC();
    ConexaoBancoDadosBAR conectaBAR = new ConexaoBancoDadosBAR();
    ConexaoBancoDadosLF conectaLF = new ConexaoBancoDadosLF();
    //
    ProntuarioCrc objProCrc = new ProntuarioCrc();
    DadosPenaisCrc objDadosPena = new DadosPenaisCrc();
    DadosFisicosInternos objDadosFis = new DadosFisicosInternos();
    ControleInternoCrc control = new ControleInternoCrc();
    ControleDadosFisicos controlFisicos = new ControleDadosFisicos();
    ControleDadosPenais controlPenais = new ControleDadosPenais();
    //
    ControleLogSistema controlLog = new ControleLogSistema();
    LogSistema objLogSys = new LogSistema();
    //
    int acao;
    int flag;
    String codInternoCrc; // Verificar se existe movimentação do intero para não ser excluído
    String nomePais;
    String dataEntrada;
    String dataCadastro;
    String caminho;
    String caminhoFotoPerfil;
    String caminhoFotoCorpo;
    String caminhoFotoCorpo1;
    String caminhoFotoCorpo2;
    String caminhoFotoCorpo3;
    String caminhoPolegarDireito;
    String caminhoIndicadorDireito;
    String caminhoMedioDireito;
    String caminhoAnularDireito;
    String caminhoMininoDireito;
    String caminhoPolegarEsquerdo;
    String caminhoIndicadorEsquerdo;
    String caminhoMedioEsquerdo;
    String caminhoAnularEsquerdo;
    String caminhoMininoEsquerdo;
    //
    String nomeInternoCrc;
    String nomeMaeInterno;
    // Variáveis para gravar o log
    String nomeModuloTela = "CRC:Prontuário de Internos";
    String statusMov;
    String horaMov;
    String dataModFinal;
    //
    String nomeUsuarioCrc = "ADMINISTRADOR DO SISTEMA"; // Para poder alterar a situação do interno
    String usuarioAutorizado;
    String nomeInterno; // Para pesquisa do interno no registroda portaria, bloquear.
    String confirmaEntrada = "Sim"; // Confirma a utilização do registro do interno iniciado na portaria.
    String codParametrosEntrada;
    int count = 0;
    // LIBERAÇÃO DA OBSERVAÇÃO PARA GRUPO DE ADMINISTRADORES
    int codigoUsuario;
    int codigoGrupo;
    int codigoGrupoAdm = 1;
    // CAMINHO DAS IMAGENS DA MÃO DIREITA
    String caminhoBiometria1 = "";
    String caminhoBiometria2 = "";
    String caminhoBiometria3 = "";
    String caminhoBiometria4 = "";
    String caminhoBiometria5 = "";
    // CAMINHO DAS IMAGENS DA MÃO ESQUERDA
    String caminhoBiometria6 = "";
    String caminhoBiometria7 = "";
    String caminhoBiometria8 = "";
    String caminhoBiometria9 = "";
    String caminhoBiometria10 = "";
    //
    String caminhoFotoExterna;

    /**
     * Creates new form TelaTriagem
     */
    public TelaConsultaProntuarioInternoCrcExt() {
        super();
        initComponents();
        setResizable(false);
        corCampos();
        formatarCampos();
        pesquisarDadosInterno();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jIdInterno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jNomeInterno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jMatriculaPenal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jMaeInterno = new javax.swing.JTextField();
        jPaiInterno = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jAlcunha = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jCPFInterno = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxSexo = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxEscolaridade = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxEstadoCivil = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jReligiao = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jProfissao = new javax.swing.JTextField();
        jRGInterno = new javax.swing.JFormattedTextField();
        jLabel60 = new javax.swing.JLabel();
        jSituacao = new javax.swing.JTextField();
        jDataCadastro = new com.toedter.calendar.JDateChooser();
        jDataNascimento = new com.toedter.calendar.JDateChooser();
        jComboBoxPais = new javax.swing.JTextField();
        jComboBoxCidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jCartaoSus = new javax.swing.JTextField();
        jLabel162 = new javax.swing.JLabel();
        jCNC = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jEndereco = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jBairro = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jCidade = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jEstado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTelefone = new javax.swing.JFormattedTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTelefone1 = new javax.swing.JFormattedTextField();
        jCelular = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jComboBoxCutis = new javax.swing.JComboBox();
        jComboBoxOlhos = new javax.swing.JComboBox();
        jComboBoxCabelos = new javax.swing.JComboBox();
        jComboBoxBarba = new javax.swing.JComboBox();
        jComboBoxBigode = new javax.swing.JComboBox();
        jLabel35 = new javax.swing.JLabel();
        jComboBoxNariz = new javax.swing.JComboBox();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jComboBoxBoca = new javax.swing.JComboBox();
        jComboBoxRosto = new javax.swing.JComboBox();
        jComboBoxLabios = new javax.swing.JComboBox();
        jLabel39 = new javax.swing.JLabel();
        jCamisa = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jCalca = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jSapato = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jPeso = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jAltura = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jParticularidade = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jComboBoxOrelha = new javax.swing.JComboBox();
        jComboBoxPescoco = new javax.swing.JComboBox();
        jLabel62 = new javax.swing.JLabel();
        jComboBoxCompleicao = new javax.swing.JComboBox();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jDataEntrada = new com.toedter.calendar.JDateChooser();
        jLabel46 = new javax.swing.JLabel();
        jDataCrime = new com.toedter.calendar.JDateChooser();
        jLabel49 = new javax.swing.JLabel();
        jComboBoxParticipacao = new javax.swing.JComboBox();
        jLabel45 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jDataPrisao = new com.toedter.calendar.JDateChooser();
        jComboBoxRegime = new javax.swing.JComboBox();
        jLabel50 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jDataCondenacao = new com.toedter.calendar.JDateChooser();
        jLabel51 = new javax.swing.JLabel();
        jPena = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jArtigo1 = new javax.swing.JTextField();
        jArtigo2 = new javax.swing.JTextField();
        jArtigo3 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jParagrafo1 = new javax.swing.JTextField();
        jParagrafo2 = new javax.swing.JTextField();
        jParagrafo3 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jComboBoxEdiondo = new javax.swing.JComboBox();
        jLabel59 = new javax.swing.JLabel();
        jDataTerPena = new com.toedter.calendar.JDateChooser();
        jComboBoxUnid = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jVaraCondenacao = new javax.swing.JTextField();
        jLabel159 = new javax.swing.JLabel();
        jDataNovaEntrada = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Prontuário de Interno {PRONTUÁRIO EXTERNO} ::: ...");
        setToolTipText("");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Código:");

        jIdInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jIdInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jIdInterno.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Data Cadastro:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Nome:");

        jNomeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jNomeInterno.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("M.P.");

        jMatriculaPenal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jMatriculaPenal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMatriculaPenal.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Mãe:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Pai:");

        jMaeInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jMaeInterno.setEnabled(false);

        jPaiInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPaiInterno.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Alcunha:");

        jAlcunha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAlcunha.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Data Nascimento:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("R.G.:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("C.P.F.:");

        jCPFInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCPFInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCPFInterno.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Sexo:");

        jComboBoxSexo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Masculino", "Feminino" }));
        jComboBoxSexo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxSexo.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Escolaridade:");

        jComboBoxEscolaridade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEscolaridade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Não Alfabetizado", "Alfabetizado", "Fundamental Completo", "Fundamental Incompleto", "1º Grau Completo", "1º Grau Incompleto", "2º Grau Completo", "2º Grau Incompleto", "Superior Completo", "Superior Incompleto" }));
        jComboBoxEscolaridade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEscolaridade.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("E.Civil:");

        jComboBoxEstadoCivil.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Casado", "Casada", "Solteiro", "Solteira", "Outros" }));
        jComboBoxEstadoCivil.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEstadoCivil.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Nacionalidade:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Naturalidade:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Religião:");

        jReligiao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jReligiao.setEnabled(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Profissão:");

        jProfissao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jProfissao.setEnabled(false);
        jProfissao.setPreferredSize(new java.awt.Dimension(4, 17));

        jRGInterno.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jRGInterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jRGInterno.setEnabled(false);

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 51, 51));
        jLabel60.setText("Situação do Interno");

        jSituacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSituacao.setEnabled(false);

        jDataCadastro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataCadastro.setEnabled(false);

        jDataNascimento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataNascimento.setEnabled(false);

        jComboBoxPais.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPais.setEnabled(false);

        jComboBoxCidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCidade.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Cartão SUS:");

        jCartaoSus.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCartaoSus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCartaoSus.setEnabled(false);

        jLabel162.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel162.setText("CNC:");

        jCNC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCNC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCNC.setEnabled(false);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 161, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 174, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jAlcunha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jRGInterno, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addComponent(jLabel14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jComboBoxEscolaridade, 0, 0, Short.MAX_VALUE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel17)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxEstadoCivil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCPFInterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCartaoSus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jReligiao, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jProfissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSituacao)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel60)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jComboBoxPais, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jNomeInterno)
                            .addComponent(jMaeInterno)
                            .addComponent(jPaiInterno)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jMatriculaPenal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel162)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCNC, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jAlcunha, jRGInterno});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCPFInterno, jCartaoSus, jComboBoxEstadoCivil});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(jCNC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel162)
                                .addComponent(jMatriculaPenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jIdInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel9)))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7)
                            .addComponent(jDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(jDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jNomeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jMaeInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jPaiInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jAlcunha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(jCartaoSus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jRGInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel14)
                            .addComponent(jCPFInterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16)
                    .addComponent(jComboBoxEscolaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jComboBoxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18)
                    .addComponent(jComboBoxPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel19)
                    .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20)
                    .addComponent(jReligiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCPFInterno, jCartaoSus, jComboBoxEscolaridade, jComboBoxEstadoCivil, jLabel16, jLabel17});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jProfissao, jSituacao});

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Logradouro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Endereço:");

        jEndereco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEndereco.setEnabled(false);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Bairro:");

        jBairro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jBairro.setEnabled(false);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Cidade:");

        jCidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCidade.setEnabled(false);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("Estado:");

        jEstado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jEstado.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Telefone:");

        jTelefone.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTelefone.setEnabled(false);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Telefone:");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("Celular:");

        jTelefone1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTelefone1.setEnabled(false);

        jCelular.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCelular.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBairro, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jEndereco)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCelular))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(jCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCelular, jTelefone, jTelefone1});

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manutenção", jPanel2);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Fisicos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Cutis:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Olhos:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("Cabelos:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Barba:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Bigode:");

        jComboBoxCutis.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCutis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Parda", "Negra", "Branca", "Amarela", "Indigina" }));
        jComboBoxCutis.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCutis.setEnabled(false);

        jComboBoxOlhos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxOlhos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Azul", "Preto", "Castanho Escuro", "Castanho Claro", "Verdes" }));
        jComboBoxOlhos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxOlhos.setEnabled(false);

        jComboBoxCabelos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCabelos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Carapinha", "Lisos", "Ondulados", "Encaracolados", "Crespos" }));
        jComboBoxCabelos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCabelos.setEnabled(false);

        jComboBoxBarba.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxBarba.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Rala", "Cheia", "Rapada", "Sem Barba" }));
        jComboBoxBarba.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxBarba.setEnabled(false);

        jComboBoxBigode.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxBigode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Ralo", "Cheio", "Rapado", "Sem Bigode" }));
        jComboBoxBigode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxBigode.setEnabled(false);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Nariz:");

        jComboBoxNariz.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxNariz.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Achatado", "Afilado", "Arrebitado", "Comprido", "Curvo", "Adunco", "Pequeno", "Fino" }));
        jComboBoxNariz.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxNariz.setEnabled(false);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Boca:");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Rosto:");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Lábios:");

        jComboBoxBoca.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxBoca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Média", "Pequena", "Grande" }));
        jComboBoxBoca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxBoca.setEnabled(false);

        jComboBoxRosto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRosto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Comprido", "Oval", "Quadrado", "Redondo", "Médios" }));
        jComboBoxRosto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRosto.setEnabled(false);

        jComboBoxLabios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxLabios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Finos", "Grossos", "Grande", "Pequeno", "Leporinos", "Médios" }));
        jComboBoxLabios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxLabios.setEnabled(false);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Camisa:");

        jCamisa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCamisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCamisa.setEnabled(false);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Calça:");

        jCalca.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jCalca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jCalca.setEnabled(false);

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel41.setText("Sapato:");

        jSapato.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jSapato.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jSapato.setEnabled(false);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Peso:");

        jPeso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPeso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPeso.setEnabled(false);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel33.setText("Altura:");

        jAltura.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jAltura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jAltura.setEnabled(false);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Particu:");

        jParticularidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParticularidade.setEnabled(false);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Pescoço");

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setText("Orelha:");

        jComboBoxOrelha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxOrelha.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Abertas", "Coladas", "Grandes", "Médias", "Pequenas" }));
        jComboBoxOrelha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxOrelha.setEnabled(false);

        jComboBoxPescoco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxPescoco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Comprido", "Curto", "Fino", "Grosso", "Médio" }));
        jComboBoxPescoco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxPescoco.setEnabled(false);

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setText("Comple:");

        jComboBoxCompleicao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxCompleicao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Gordo", "Magro", "Médio", "Raquitico", "Trocudo" }));
        jComboBoxCompleicao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxCompleicao.setEnabled(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCamisa, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(jComboBoxBoca, 0, 104, Short.MAX_VALUE)
                    .addComponent(jComboBoxBarba, 0, 111, Short.MAX_VALUE)
                    .addComponent(jComboBoxCutis, 0, 111, Short.MAX_VALUE)
                    .addComponent(jPeso)
                    .addComponent(jComboBoxPescoco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jAltura, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCalca, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxRosto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxBigode, 0, 120, Short.MAX_VALUE)
                    .addComponent(jComboBoxOlhos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxOrelha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jParticularidade, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSapato, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addComponent(jComboBoxLabios, javax.swing.GroupLayout.Alignment.TRAILING, 0, 106, Short.MAX_VALUE)
                        .addComponent(jComboBoxNariz, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxCabelos, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jComboBoxCompleicao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCamisa, jComboBoxBarba, jComboBoxBoca, jComboBoxCutis});

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxBigode, jComboBoxOlhos, jComboBoxRosto});

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBoxCabelos, jComboBoxLabios, jComboBoxNariz, jParticularidade, jSapato});

        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jComboBoxCutis, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxOlhos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCabelos, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jComboBoxBarba, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jComboBoxBigode, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(jComboBoxNariz, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38)
                    .addComponent(jComboBoxBoca, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRosto, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxLabios, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jCamisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(jCalca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jSapato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(jAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(jParticularidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel61)
                    .addComponent(jComboBoxOrelha, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPescoco, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(jComboBoxCompleicao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCamisa, jComboBoxBarba, jComboBoxBoca, jComboBoxCutis});

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBoxBigode, jComboBoxOlhos, jComboBoxRosto});

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBoxCabelos, jComboBoxLabios, jComboBoxNariz, jParticularidade, jSapato});

        jTabbedPane2.setForeground(new java.awt.Color(255, 0, 0));
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("Data Entrada:");

        jDataEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataEntrada.setEnabled(false);

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setText("Data Crime:");

        jDataCrime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataCrime.setEnabled(false);

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("Participação:");

        jComboBoxParticipacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxParticipacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Autor", "Co-Autor" }));
        jComboBoxParticipacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxParticipacao.setEnabled(false);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("Procedência:");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel47.setText("Data Prisão:");

        jDataPrisao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataPrisao.setEnabled(false);

        jComboBoxRegime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxRegime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Fechado", "Aberto", "Semi-Aberto", "Provisório" }));
        jComboBoxRegime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxRegime.setEnabled(false);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setText("Regime:");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setText("Data Conden:");

        jDataCondenacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataCondenacao.setEnabled(false);

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setText("Pena:");

        jPena.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPena.setEnabled(false);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Artigos e Parágrafos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("Artigo 1:");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setText("Artigo 2:");

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("Artigo 3:");

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setText("Parágrafo 1:");

        jArtigo1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jArtigo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jArtigo1.setEnabled(false);

        jArtigo2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jArtigo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jArtigo2.setEnabled(false);

        jArtigo3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jArtigo3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jArtigo3.setEnabled(false);

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setText("Parágrafo 2:");

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel57.setText("Parágrafo 3:");

        jParagrafo1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jParagrafo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParagrafo1.setEnabled(false);

        jParagrafo2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jParagrafo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParagrafo2.setEnabled(false);

        jParagrafo3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jParagrafo3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jParagrafo3.setEnabled(false);

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setText("Crime Hediondo:");

        jComboBoxEdiondo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEdiondo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Sim", "Não" }));
        jComboBoxEdiondo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxEdiondo.setEnabled(false);

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setText("Término Pena:");

        jDataTerPena.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataTerPena.setEnabled(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel54)
                    .addComponent(jLabel52)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jArtigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jParagrafo1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jArtigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jArtigo3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jParagrafo2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jParagrafo3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDataTerPena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxEdiondo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52)
                            .addComponent(jLabel55)
                            .addComponent(jArtigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jParagrafo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jParagrafo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jArtigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53)
                            .addComponent(jLabel56))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jArtigo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel57)
                                .addComponent(jParagrafo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel58)
                            .addComponent(jComboBoxEdiondo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jDataTerPena, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel59))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jComboBoxUnid.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jComboBoxUnid.setEnabled(false);

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel72.setText("Vara Condenação:");

        jVaraCondenacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jVaraCondenacao.setEnabled(false);

        jLabel159.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(0, 0, 255));
        jLabel159.setText("Nova Entrada:");

        jDataNovaEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDataNovaEntrada.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jVaraCondenacao, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxParticipacao, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDataCrime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel50)
                            .addComponent(jLabel47)
                            .addComponent(jLabel159))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jDataPrisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel48)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDataCondenacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jComboBoxRegime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPena, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDataNovaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jComboBoxUnid))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel46)
                    .addComponent(jDataCrime, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel44)
                            .addComponent(jDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel159)
                            .addComponent(jDataNovaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel47)
                            .addComponent(jDataPrisao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48)
                            .addComponent(jDataCondenacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jComboBoxParticipacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50)
                            .addComponent(jComboBoxRegime, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51)
                            .addComponent(jPena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel72)
                    .addComponent(jVaraCondenacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel45)
                    .addComponent(jComboBoxUnid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Dados Penais", jPanel5);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados Fisicos/Penais", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(300, 15, 666, 588);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAlcunha;
    private javax.swing.JTextField jAltura;
    private javax.swing.JTextField jArtigo1;
    private javax.swing.JTextField jArtigo2;
    private javax.swing.JTextField jArtigo3;
    private javax.swing.JTextField jBairro;
    private javax.swing.JTextField jCNC;
    private javax.swing.JFormattedTextField jCPFInterno;
    private javax.swing.JTextField jCalca;
    private javax.swing.JTextField jCamisa;
    private javax.swing.JTextField jCartaoSus;
    private javax.swing.JFormattedTextField jCelular;
    public static javax.swing.JTextField jCidade;
    private javax.swing.JComboBox jComboBoxBarba;
    private javax.swing.JComboBox jComboBoxBigode;
    private javax.swing.JComboBox jComboBoxBoca;
    private javax.swing.JComboBox jComboBoxCabelos;
    public static javax.swing.JTextField jComboBoxCidade;
    private javax.swing.JComboBox jComboBoxCompleicao;
    private javax.swing.JComboBox jComboBoxCutis;
    private javax.swing.JComboBox jComboBoxEdiondo;
    private javax.swing.JComboBox jComboBoxEscolaridade;
    private javax.swing.JComboBox jComboBoxEstadoCivil;
    private javax.swing.JComboBox jComboBoxLabios;
    private javax.swing.JComboBox jComboBoxNariz;
    private javax.swing.JComboBox jComboBoxOlhos;
    private javax.swing.JComboBox jComboBoxOrelha;
    public static javax.swing.JTextField jComboBoxPais;
    private javax.swing.JComboBox jComboBoxParticipacao;
    private javax.swing.JComboBox jComboBoxPescoco;
    private javax.swing.JComboBox jComboBoxRegime;
    private javax.swing.JComboBox jComboBoxRosto;
    private javax.swing.JComboBox jComboBoxSexo;
    public static javax.swing.JTextField jComboBoxUnid;
    private com.toedter.calendar.JDateChooser jDataCadastro;
    private com.toedter.calendar.JDateChooser jDataCondenacao;
    private com.toedter.calendar.JDateChooser jDataCrime;
    private com.toedter.calendar.JDateChooser jDataEntrada;
    private com.toedter.calendar.JDateChooser jDataNascimento;
    private com.toedter.calendar.JDateChooser jDataNovaEntrada;
    private com.toedter.calendar.JDateChooser jDataPrisao;
    private com.toedter.calendar.JDateChooser jDataTerPena;
    private javax.swing.JTextField jEndereco;
    private javax.swing.JTextField jEstado;
    public static javax.swing.JTextField jIdInterno;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jMaeInterno;
    private javax.swing.JTextField jMatriculaPenal;
    public static javax.swing.JTextField jNomeInterno;
    private javax.swing.JTextField jPaiInterno;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jParagrafo1;
    private javax.swing.JTextField jParagrafo2;
    private javax.swing.JTextField jParagrafo3;
    private javax.swing.JTextField jParticularidade;
    private javax.swing.JTextField jPena;
    private javax.swing.JTextField jPeso;
    private javax.swing.JTextField jProfissao;
    private javax.swing.JFormattedTextField jRGInterno;
    private javax.swing.JTextField jReligiao;
    private javax.swing.JTextField jSapato;
    public static javax.swing.JTextField jSituacao;
    private javax.swing.JSplitPane jSplitPane1;
    public static javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JFormattedTextField jTelefone;
    private javax.swing.JFormattedTextField jTelefone1;
    private javax.swing.JTextField jVaraCondenacao;
    // End of variables declaration//GEN-END:variables

    public void buscarUsuario() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS WHERE NomeUsuario='" + nameUser + "'");
            conecta.rs.first();
            codigoUsuario = conecta.rs.getInt("IdUsuario");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void buscarCodigoGrupo() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS_GRUPOS WHERE IdUsuario='" + codigoUsuario + "'");
            conecta.rs.first();
            codigoGrupo = conecta.rs.getInt("IdGrupo");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void corCampos() {
        jIdInterno.setBackground(Color.white);
        jMatriculaPenal.setBackground(Color.white);
        jCNC.setBackground(Color.white);
        jDataCadastro.setBackground(Color.white);
        jDataNascimento.setBackground(Color.white);
        jDataEntrada.setBackground(Color.white);
        jDataCrime.setBackground(Color.white);
        jDataPrisao.setBackground(Color.white);
        jDataCondenacao.setBackground(Color.white);
        jDataTerPena.setBackground(Color.white);
        jNomeInterno.setBackground(Color.white);
        jMaeInterno.setBackground(Color.white);
        jPaiInterno.setBackground(Color.white);
        jAlcunha.setBackground(Color.white);
        jRGInterno.setBackground(Color.white);
        jCartaoSus.setBackground(Color.white);
        jCPFInterno.setBackground(Color.white);
        jComboBoxEscolaridade.setBackground(Color.white);
        jComboBoxEstadoCivil.setBackground(Color.white);
        jComboBoxSexo.setBackground(Color.white);
        jSituacao.setBackground(Color.white);
        jComboBoxCutis.setBackground(Color.white);
        jComboBoxOlhos.setBackground(Color.white);
        jComboBoxCabelos.setBackground(Color.white);
        jComboBoxBarba.setBackground(Color.white);
        jComboBoxBigode.setBackground(Color.white);
        jComboBoxNariz.setBackground(Color.white);
        jComboBoxBoca.setBackground(Color.white);
        jComboBoxRosto.setBackground(Color.white);
        jComboBoxLabios.setBackground(Color.white);
        jComboBoxParticipacao.setBackground(Color.white);
        jComboBoxRegime.setBackground(Color.white);
        jComboBoxEdiondo.setBackground(Color.white);
        jComboBoxPais.setBackground(Color.white);
        jComboBoxCidade.setBackground(Color.white);
        jComboBoxUnid.setBackground(Color.white);
        jReligiao.setBackground(Color.white);
        jProfissao.setBackground(Color.white);
        jEndereco.setBackground(Color.white);
        jBairro.setBackground(Color.white);
        jCidade.setBackground(Color.white);
        jEstado.setBackground(Color.white);
        jTelefone.setBackground(Color.white);
        jTelefone1.setBackground(Color.white);
        jCelular.setBackground(Color.white);
        jCamisa.setBackground(Color.white);
        jCalca.setBackground(Color.white);
        jSapato.setBackground(Color.white);
        jPeso.setBackground(Color.white);
        jAltura.setBackground(Color.white);
        jComboBoxOrelha.setBackground(Color.white);
        jComboBoxPescoco.setBackground(Color.white);
        jComboBoxCompleicao.setBackground(Color.white);
        jParticularidade.setBackground(Color.white);
        jPena.setBackground(Color.white);
        jArtigo1.setBackground(Color.white);
        jArtigo2.setBackground(Color.white);
        jArtigo3.setBackground(Color.white);
        jParagrafo1.setBackground(Color.white);
        jParagrafo2.setBackground(Color.white);
        jParagrafo3.setBackground(Color.white);
        jVaraCondenacao.setBackground(Color.white);
    }

    public void formatarCampos() {

        try {
            MaskFormatter telefone = new MaskFormatter("(###)####-####");
            jTelefone.setFormatterFactory(new DefaultFormatterFactory(telefone));
            MaskFormatter telefone1 = new MaskFormatter("(###)####-####");
            jTelefone1.setFormatterFactory(new DefaultFormatterFactory(telefone1));
            MaskFormatter celular = new MaskFormatter("(###)####-####");
            jCelular.setFormatterFactory(new DefaultFormatterFactory(celular));
            jCartaoSus.setDocument(new LimiteDigitosSoNum(20));
            jNomeInterno.setDocument(new LimiteDigitos(50));
            jMatriculaPenal.setDocument(new LimiteDigitosAlfa(16));
            jMaeInterno.setDocument(new LimiteDigitos(50));
            jPaiInterno.setDocument(new LimiteDigitos(50));
            jAlcunha.setDocument(new LimiteDigitosAlfa(30));
            jSituacao.setDocument(new LimiteDigitos(50));
            jReligiao.setDocument(new LimiteDigitos(18));
            jProfissao.setDocument(new LimiteDigitos(35));
            jEndereco.setDocument(new LimiteDigitosAlfa(50));
            jBairro.setDocument(new LimiteDigitosAlfa(24));
            jCidade.setDocument(new LimiteDigitosAlfa(24));
            jEstado.setDocument(new LimiteDigitos(17));
            jCamisa.setDocument(new LimiteDigitosAlfa(3));
            jCalca.setDocument(new LimiteDigitosNum(2));
            jSapato.setDocument(new LimiteDigitosNum(2));
            jPeso.setDocument(new LimiteDigitosNum(8));
            jAltura.setDocument(new LimiteDigitosAlfa(4));
            jParticularidade.setDocument(new LimiteDigitosAlfa(13));
            jPena.setDocument(new LimiteDigitosAlfa(13));
            jArtigo1.setDocument(new LimiteDigitosNum(8));
            jArtigo2.setDocument(new LimiteDigitosNum(8));
            jArtigo3.setDocument(new LimiteDigitosNum(8));
            jParagrafo1.setDocument(new LimiteDigitosNum(8));
            jParagrafo2.setDocument(new LimiteDigitosNum(8));
            jParagrafo3.setDocument(new LimiteDigitosNum(8));
            jVaraCondenacao.setDocument(new LimiteDigitosAlfa(70));
        } catch (Exception e) {
        }
    }

    public void objLog() {
        objLogSys.setDataMov(dataModFinal);
        objLogSys.setHorarioMov(horaMov);
        objLogSys.setNomeModuloTela(nomeModuloTela);
        objLogSys.setIdLancMov(Integer.valueOf(jIdInterno.getText()));
        objLogSys.setNomeUsuarioLogado(nameUser);
        objLogSys.setStatusMov(statusMov);
    }

    public void buscarCaminhoTempleteImagem() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PARAMETROSCRC");
            conecta.rs.first();
            // CAMINHOS DAS IMAGENS
            caminhoBiometria1 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria2 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria3 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria4 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria5 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria6 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria7 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria8 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria9 = conecta.rs.getString("CaminhoImagemCRCInterno");
            caminhoBiometria10 = conecta.rs.getString("CaminhoImagemCRCInterno");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }

    public void pesquisarDadosInterno() {
        // LAURO DE FREITAS
        if (nomeUnidadeLF == jTabelaInterno.getValueAt(jTabelaInterno.getSelectedRow(), 5)) {
            //
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                        + "INNER JOIN DADOSFISICOSINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                        + "INNER JOIN PAISES "
                        + "ON PRONTUARIOSCRC.IdPais=PAISES.IdPais "
                        + "INNER JOIN CIDADES "
                        + "ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN UNIDADE "
                        + "ON DADOSPENAISINTERNOS.IdUnid=UNIDADE.IdUnid "
                        + "WHERE PRONTUARIOSCRC.IdInternoCrc='" + jIdInternoExt.getText() + "'");
                conecta.rs.first();
                jIdInterno.setText(String.valueOf(conecta.rs.getInt("IdInternoCrc")));
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
                jComboBoxEscolaridade.setSelectedItem(conecta.rs.getString("EscolaridadeCrc"));
                jComboBoxEstadoCivil.setSelectedItem(conecta.rs.getString("EstadoCivilCrc"));
                jComboBoxSexo.setSelectedItem(conecta.rs.getString("SexoCrc"));
                jSituacao.setText(conecta.rs.getString("SituacaoCrc"));
                jComboBoxPais.setText(conecta.rs.getString("NomePais"));
                jComboBoxCidade.setText(conecta.rs.getString("NomeCidade"));
                jReligiao.setText(conecta.rs.getString("ReligiaoCrc"));
                jProfissao.setText(conecta.rs.getString("ProfissaoCrc"));
                jEndereco.setText(conecta.rs.getString("EnderecoCrc"));
                jBairro.setText(conecta.rs.getString("BairroCrc"));
                jCidade.setText(conecta.rs.getString("CidadeCrc"));
                jEstado.setText(conecta.rs.getString("EstadoCrc"));
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
                jComboBoxUnid.setText(conecta.rs.getString("DescricaoUnid"));
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
                caminhoFotoPerfil = conecta.rs.getString("FotoPerfil");
                caminho = conecta.rs.getString("FotoInternoCrc");
//                if (caminho != null) {
//                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
//                    FotoInternoExt.setIcon(i);
//                    FotoInternoExt.setIcon(new ImageIcon(i.getImage().getScaledInstance(FotoInternoExt.getWidth(), FotoInternoExt.getHeight(), Image.SCALE_SMOOTH)));
//                }
//                // FOTO DE FRENTE - BANCO DE DADOS
//                byte[] imgBytes = ((byte[]) conecta.rs.getBytes("ImagemFrente"));
//                if (imgBytes != null) {
//                    ImageIcon pic = null;
//                    pic = new ImageIcon(imgBytes);
//                    Image scaled = pic.getImage().getScaledInstance(FotoInternoExt.getWidth(), FotoInternoExt.getHeight(), Image.SCALE_SMOOTH);
//                    ImageIcon icon = new ImageIcon(scaled);
//                    FotoInternoExt.setIcon(icon);
//                }
                conecta.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por nome" + e);
            }
        } else if (nomeUnidadeSSA == jTabelaInterno.getValueAt(jTabelaInterno.getSelectedRow(), 5)) {
            //
            conectaSSA.abrirConexao();
            try {
                conectaSSA.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                        + "INNER JOIN DADOSFISICOSINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                        + "INNER JOIN PAISES "
                        + "ON PRONTUARIOSCRC.IdPais=PAISES.IdPais "
                        + "INNER JOIN CIDADES "
                        + "ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN UNIDADE "
                        + "ON DADOSPENAISINTERNOS.IdUnid=UNIDADE.IdUnid "
                        + "WHERE PRONTUARIOSCRC.IdInternoCrc='" + jIdInternoExt.getText() + "'");
                conectaSSA.rs.first();
                jIdInterno.setText(String.valueOf(conectaSSA.rs.getInt("IdInternoCrc")));
                jMatriculaPenal.setText(conectaSSA.rs.getString("MatriculaCrc"));
                jCNC.setText(conectaSSA.rs.getString("Cnc"));
                jDataCadastro.setDate(conectaSSA.rs.getDate("DataCadastCrc"));
                jDataNascimento.setDate(conectaSSA.rs.getDate("DataNasciCrc"));
                jNomeInterno.setText(conectaSSA.rs.getString("NomeInternoCrc"));
                jMaeInterno.setText(conectaSSA.rs.getString("MaeInternoCrc"));
                jPaiInterno.setText(conectaSSA.rs.getString("PaiInternoCrc"));
                jAlcunha.setText(conectaSSA.rs.getString("AlcunhaCrc"));
                jRGInterno.setText(conectaSSA.rs.getString("RgInternoCrc"));
                jCPFInterno.setText(conectaSSA.rs.getString("CpfInternoCrc"));
                jCartaoSus.setText(conectaSSA.rs.getString("CartaoSus"));
                jComboBoxEscolaridade.setSelectedItem(conectaSSA.rs.getString("EscolaridadeCrc"));
                jComboBoxEstadoCivil.setSelectedItem(conectaSSA.rs.getString("EstadoCivilCrc"));
                jComboBoxSexo.setSelectedItem(conectaSSA.rs.getString("SexoCrc"));
                jSituacao.setText(conectaSSA.rs.getString("SituacaoCrc"));
                jComboBoxPais.setText(conectaSSA.rs.getString("NomePais"));
                jComboBoxCidade.setText(conectaSSA.rs.getString("NomeCidade"));
                jReligiao.setText(conectaSSA.rs.getString("ReligiaoCrc"));
                jProfissao.setText(conectaSSA.rs.getString("ProfissaoCrc"));
                jEndereco.setText(conectaSSA.rs.getString("EnderecoCrc"));
                jBairro.setText(conectaSSA.rs.getString("BairroCrc"));
                jCidade.setText(conectaSSA.rs.getString("CidadeCrc"));
                jEstado.setText(conectaSSA.rs.getString("EstadoCrc"));
                // Tabela Dados Fisicos
                jComboBoxCutis.setSelectedItem(conectaSSA.rs.getString("Cutis"));
                jComboBoxOlhos.setSelectedItem(conectaSSA.rs.getString("Olhos"));
                jComboBoxCabelos.setSelectedItem(conectaSSA.rs.getString("Cabelos"));
                jComboBoxBarba.setSelectedItem(conectaSSA.rs.getString("Barba"));
                jComboBoxBigode.setSelectedItem(conectaSSA.rs.getString("Bigode"));
                jComboBoxNariz.setSelectedItem(conectaSSA.rs.getString("Nariz"));
                jComboBoxBoca.setSelectedItem(conectaSSA.rs.getString("Boca"));
                jComboBoxRosto.setSelectedItem(conectaSSA.rs.getString("Rosto"));
                jComboBoxLabios.setSelectedItem(conectaSSA.rs.getString("Labios"));
                jCamisa.setText(conectaSSA.rs.getString("Camisa"));
                jCalca.setText(conectaSSA.rs.getString("Calca"));
                jSapato.setText(conectaSSA.rs.getString("Sapato"));
                jPeso.setText(conectaSSA.rs.getString("Peso"));
                jAltura.setText(conectaSSA.rs.getString("Altura"));
                jParticularidade.setText(conectaSSA.rs.getString("Sinais"));
                jComboBoxOrelha.setSelectedItem(conectaSSA.rs.getString("Orelhas"));
                jComboBoxPescoco.setSelectedItem(conectaSSA.rs.getString("Pescoco"));
                jComboBoxCompleicao.setSelectedItem(conectaSSA.rs.getString("Compleicao"));
                // Tabela Dados Penais
                jDataEntrada.setDate(conectaSSA.rs.getDate("DataEntrada"));
                jComboBoxUnid.setText(conectaSSA.rs.getString("DescricaoUnid"));
                jDataCrime.setDate(conectaSSA.rs.getDate("DataCrime"));
                jDataPrisao.setDate(conectaSSA.rs.getDate("DataPrisao"));
                jDataCondenacao.setDate(conectaSSA.rs.getDate("DataCondenacao"));
                jComboBoxParticipacao.setSelectedItem(conectaSSA.rs.getString("Participacao"));
                jComboBoxRegime.setSelectedItem(conectaSSA.rs.getString("Regime"));
                jPena.setText(conectaSSA.rs.getString("Pena"));
                jArtigo1.setText(conectaSSA.rs.getString("Artigo1"));
                jArtigo2.setText(conectaSSA.rs.getString("Artigo2"));
                jArtigo3.setText(conectaSSA.rs.getString("Artigo3"));
                jParagrafo1.setText(conectaSSA.rs.getString("Paragrafo1"));
                jParagrafo2.setText(conectaSSA.rs.getString("Paragrafo2"));
                jParagrafo3.setText(conectaSSA.rs.getString("Paragrafo3"));
                jComboBoxEdiondo.setSelectedItem(conectaSSA.rs.getString("CrimeEdiondo"));
                jDataTerPena.setDate(conectaSSA.rs.getDate("TerminoPena"));
                jVaraCondenacao.setText(conectaSSA.rs.getString("VaraCondenatoria"));
                jDataNovaEntrada.setDate(conectaSSA.rs.getDate("DataNovaEntrada"));
                caminhoFotoPerfil = conectaSSA.rs.getString("FotoPerfil");
                caminho = conectaSSA.rs.getString("FotoInternoCrc");
//                if (caminho != null) {
//                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
//                    FotoInternoExt.setIcon(i);
//                    FotoInternoExt.setIcon(new ImageIcon(i.getImage().getScaledInstance(FotoInternoExt.getWidth(), FotoInternoExt.getHeight(), Image.SCALE_SMOOTH)));
//                }
//                // FOTO DE FRENTE - BANCO DE DADOS
//                byte[] imgBytes = ((byte[]) conectaSSA.rs.getBytes("ImagemFrente"));
//                if (imgBytes != null) {
//                    ImageIcon pic = null;
//                    pic = new ImageIcon(imgBytes);
//                    Image scaled = pic.getImage().getScaledInstance(FotoInternoExt.getWidth(), FotoInternoExt.getHeight(), Image.SCALE_SMOOTH);
//                    ImageIcon icon = new ImageIcon(scaled);
//                    FotoInternoExt.setIcon(icon);
//                }
                conectaSSA.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por nome" + e);
            }
        } else if (nomeUnidadeITB == jTabelaInterno.getValueAt(jTabelaInterno.getSelectedRow(), 5)) {
            //
            conectaITB.abrirConexao();
            try {
                conectaITB.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                        + "INNER JOIN DADOSFISICOSINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                        + "INNER JOIN PAISES "
                        + "ON PRONTUARIOSCRC.IdPais=PAISES.IdPais "
                        + "INNER JOIN CIDADES "
                        + "ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN UNIDADE "
                        + "ON DADOSPENAISINTERNOS.IdUnid=UNIDADE.IdUnid "
                        + "WHERE PRONTUARIOSCRC.IdInternoCrc='" + jIdInternoExt.getText() + "'");
                conectaITB.rs.first();
                jIdInterno.setText(String.valueOf(conectaITB.rs.getInt("IdInternoCrc")));
                jMatriculaPenal.setText(conectaITB.rs.getString("MatriculaCrc"));
                jCNC.setText(conectaITB.rs.getString("Cnc"));
                jDataCadastro.setDate(conectaITB.rs.getDate("DataCadastCrc"));
                jDataNascimento.setDate(conectaITB.rs.getDate("DataNasciCrc"));
                jNomeInterno.setText(conectaITB.rs.getString("NomeInternoCrc"));
                jMaeInterno.setText(conectaITB.rs.getString("MaeInternoCrc"));
                jPaiInterno.setText(conectaITB.rs.getString("PaiInternoCrc"));
                jAlcunha.setText(conectaITB.rs.getString("AlcunhaCrc"));
                jRGInterno.setText(conectaITB.rs.getString("RgInternoCrc"));
                jCPFInterno.setText(conectaITB.rs.getString("CpfInternoCrc"));
                jCartaoSus.setText(conectaITB.rs.getString("CartaoSus"));
                jComboBoxEscolaridade.setSelectedItem(conectaITB.rs.getString("EscolaridadeCrc"));
                jComboBoxEstadoCivil.setSelectedItem(conectaITB.rs.getString("EstadoCivilCrc"));
                jComboBoxSexo.setSelectedItem(conectaITB.rs.getString("SexoCrc"));
                jSituacao.setText(conectaITB.rs.getString("SituacaoCrc"));
                jComboBoxPais.setText(conectaITB.rs.getString("NomePais"));
                jComboBoxCidade.setText(conectaITB.rs.getString("NomeCidade"));
                jReligiao.setText(conectaITB.rs.getString("ReligiaoCrc"));
                jProfissao.setText(conectaITB.rs.getString("ProfissaoCrc"));
                jEndereco.setText(conectaITB.rs.getString("EnderecoCrc"));
                jBairro.setText(conectaITB.rs.getString("BairroCrc"));
                jCidade.setText(conectaITB.rs.getString("CidadeCrc"));
                jEstado.setText(conectaITB.rs.getString("EstadoCrc"));
                // Tabela Dados Fisicos
                jComboBoxCutis.setSelectedItem(conectaITB.rs.getString("Cutis"));
                jComboBoxOlhos.setSelectedItem(conectaITB.rs.getString("Olhos"));
                jComboBoxCabelos.setSelectedItem(conectaITB.rs.getString("Cabelos"));
                jComboBoxBarba.setSelectedItem(conectaITB.rs.getString("Barba"));
                jComboBoxBigode.setSelectedItem(conectaITB.rs.getString("Bigode"));
                jComboBoxNariz.setSelectedItem(conectaITB.rs.getString("Nariz"));
                jComboBoxBoca.setSelectedItem(conectaITB.rs.getString("Boca"));
                jComboBoxRosto.setSelectedItem(conectaITB.rs.getString("Rosto"));
                jComboBoxLabios.setSelectedItem(conectaITB.rs.getString("Labios"));
                jCamisa.setText(conectaITB.rs.getString("Camisa"));
                jCalca.setText(conectaITB.rs.getString("Calca"));
                jSapato.setText(conectaITB.rs.getString("Sapato"));
                jPeso.setText(conectaITB.rs.getString("Peso"));
                jAltura.setText(conectaITB.rs.getString("Altura"));
                jParticularidade.setText(conectaITB.rs.getString("Sinais"));
                jComboBoxOrelha.setSelectedItem(conectaITB.rs.getString("Orelhas"));
                jComboBoxPescoco.setSelectedItem(conectaITB.rs.getString("Pescoco"));
                jComboBoxCompleicao.setSelectedItem(conectaITB.rs.getString("Compleicao"));
                // Tabela Dados Penais
                jDataEntrada.setDate(conectaITB.rs.getDate("DataEntrada"));
                jComboBoxUnid.setText(conectaITB.rs.getString("DescricaoUnid"));
                jDataCrime.setDate(conectaITB.rs.getDate("DataCrime"));
                jDataPrisao.setDate(conectaITB.rs.getDate("DataPrisao"));
                jDataCondenacao.setDate(conectaITB.rs.getDate("DataCondenacao"));
                jComboBoxParticipacao.setSelectedItem(conectaITB.rs.getString("Participacao"));
                jComboBoxRegime.setSelectedItem(conectaITB.rs.getString("Regime"));
                jPena.setText(conectaITB.rs.getString("Pena"));
                jArtigo1.setText(conectaITB.rs.getString("Artigo1"));
                jArtigo2.setText(conectaITB.rs.getString("Artigo2"));
                jArtigo3.setText(conectaITB.rs.getString("Artigo3"));
                jParagrafo1.setText(conectaITB.rs.getString("Paragrafo1"));
                jParagrafo2.setText(conectaITB.rs.getString("Paragrafo2"));
                jParagrafo3.setText(conectaITB.rs.getString("Paragrafo3"));
                jComboBoxEdiondo.setSelectedItem(conectaITB.rs.getString("CrimeEdiondo"));
                jDataTerPena.setDate(conectaITB.rs.getDate("TerminoPena"));
                jVaraCondenacao.setText(conectaITB.rs.getString("VaraCondenatoria"));
                jDataNovaEntrada.setDate(conectaITB.rs.getDate("DataNovaEntrada"));
                caminhoFotoPerfil = conectaITB.rs.getString("FotoPerfil");
                caminho = conectaITB.rs.getString("FotoInternoCrc");
//                if (caminho != null) {
//                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
//                    FotoInternoExt.setIcon(i);
//                    FotoInternoExt.setIcon(new ImageIcon(i.getImage().getScaledInstance(FotoInternoExt.getWidth(), FotoInternoExt.getHeight(), Image.SCALE_SMOOTH)));
//                }
//                // FOTO DE FRENTE - BANCO DE DADOS
//                byte[] imgBytes = ((byte[]) conectaITB.rs.getBytes("ImagemFrente"));
//                if (imgBytes != null) {
//                    ImageIcon pic = null;
//                    pic = new ImageIcon(imgBytes);
//                    Image scaled = pic.getImage().getScaledInstance(FotoInternoExt.getWidth(), FotoInternoExt.getHeight(), Image.SCALE_SMOOTH);
//                    ImageIcon icon = new ImageIcon(scaled);
//                    FotoInternoExt.setIcon(icon);
//                }
                conectaITB.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa por nome" + e);
            }
        } else if (nomeUnidadeVC == jTabelaInterno.getValueAt(jTabelaInterno.getSelectedRow(), 5)) {
            //
            conectaVC.abrirConexao();
            try {
                conectaVC.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                        + "INNER JOIN DADOSFISICOSINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                        + "INNER JOIN PAISES "
                        + "ON PRONTUARIOSCRC.IdPais=PAISES.IdPais "
                        + "INNER JOIN CIDADES "
                        + "ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN UNIDADE "
                        + "ON DADOSPENAISINTERNOS.IdUnid=UNIDADE.IdUnid "
                        + "WHERE PRONTUARIOSCRC.IdInternoCrc='" + jIdInternoExt.getText() + "'");
                conectaVC.rs.first();
                jIdInterno.setText(String.valueOf(conectaVC.rs.getInt("IdInternoCrc")));
                jMatriculaPenal.setText(conectaVC.rs.getString("MatriculaCrc"));
                jCNC.setText(conectaVC.rs.getString("Cnc"));
                jDataCadastro.setDate(conectaVC.rs.getDate("DataCadastCrc"));
                jDataNascimento.setDate(conectaVC.rs.getDate("DataNasciCrc"));
                jNomeInterno.setText(conectaVC.rs.getString("NomeInternoCrc"));
                jMaeInterno.setText(conectaVC.rs.getString("MaeInternoCrc"));
                jPaiInterno.setText(conectaVC.rs.getString("PaiInternoCrc"));
                jAlcunha.setText(conectaVC.rs.getString("AlcunhaCrc"));
                jRGInterno.setText(conectaVC.rs.getString("RgInternoCrc"));
                jCPFInterno.setText(conectaVC.rs.getString("CpfInternoCrc"));
                jCartaoSus.setText(conectaVC.rs.getString("CartaoSus"));
                jComboBoxEscolaridade.setSelectedItem(conectaVC.rs.getString("EscolaridadeCrc"));
                jComboBoxEstadoCivil.setSelectedItem(conectaVC.rs.getString("EstadoCivilCrc"));
                jComboBoxSexo.setSelectedItem(conectaVC.rs.getString("SexoCrc"));
                jSituacao.setText(conectaVC.rs.getString("SituacaoCrc"));
                jComboBoxPais.setText(conectaVC.rs.getString("NomePais"));
                jComboBoxCidade.setText(conectaVC.rs.getString("NomeCidade"));
                jReligiao.setText(conectaVC.rs.getString("ReligiaoCrc"));
                jProfissao.setText(conectaVC.rs.getString("ProfissaoCrc"));
                jEndereco.setText(conectaVC.rs.getString("EnderecoCrc"));
                jBairro.setText(conectaVC.rs.getString("BairroCrc"));
                jCidade.setText(conectaVC.rs.getString("CidadeCrc"));
                jEstado.setText(conectaVC.rs.getString("EstadoCrc"));
                // Tabela Dados Fisicos
                jComboBoxCutis.setSelectedItem(conectaVC.rs.getString("Cutis"));
                jComboBoxOlhos.setSelectedItem(conectaVC.rs.getString("Olhos"));
                jComboBoxCabelos.setSelectedItem(conectaVC.rs.getString("Cabelos"));
                jComboBoxBarba.setSelectedItem(conectaVC.rs.getString("Barba"));
                jComboBoxBigode.setSelectedItem(conectaVC.rs.getString("Bigode"));
                jComboBoxNariz.setSelectedItem(conectaVC.rs.getString("Nariz"));
                jComboBoxBoca.setSelectedItem(conectaVC.rs.getString("Boca"));
                jComboBoxRosto.setSelectedItem(conectaVC.rs.getString("Rosto"));
                jComboBoxLabios.setSelectedItem(conectaVC.rs.getString("Labios"));
                jCamisa.setText(conectaVC.rs.getString("Camisa"));
                jCalca.setText(conectaVC.rs.getString("Calca"));
                jSapato.setText(conectaVC.rs.getString("Sapato"));
                jPeso.setText(conectaVC.rs.getString("Peso"));
                jAltura.setText(conectaVC.rs.getString("Altura"));
                jParticularidade.setText(conectaVC.rs.getString("Sinais"));
                jComboBoxOrelha.setSelectedItem(conectaVC.rs.getString("Orelhas"));
                jComboBoxPescoco.setSelectedItem(conectaVC.rs.getString("Pescoco"));
                jComboBoxCompleicao.setSelectedItem(conectaVC.rs.getString("Compleicao"));
                // Tabela Dados Penais
                jDataEntrada.setDate(conectaVC.rs.getDate("DataEntrada"));
                jComboBoxUnid.setText(conectaVC.rs.getString("DescricaoUnid"));
                jDataCrime.setDate(conectaVC.rs.getDate("DataCrime"));
                jDataPrisao.setDate(conectaVC.rs.getDate("DataPrisao"));
                jDataCondenacao.setDate(conectaVC.rs.getDate("DataCondenacao"));
                jComboBoxParticipacao.setSelectedItem(conectaVC.rs.getString("Participacao"));
                jComboBoxRegime.setSelectedItem(conectaVC.rs.getString("Regime"));
                jPena.setText(conectaVC.rs.getString("Pena"));
                jArtigo1.setText(conectaVC.rs.getString("Artigo1"));
                jArtigo2.setText(conectaVC.rs.getString("Artigo2"));
                jArtigo3.setText(conectaVC.rs.getString("Artigo3"));
                jParagrafo1.setText(conectaVC.rs.getString("Paragrafo1"));
                jParagrafo2.setText(conectaVC.rs.getString("Paragrafo2"));
                jParagrafo3.setText(conectaVC.rs.getString("Paragrafo3"));
                jComboBoxEdiondo.setSelectedItem(conectaVC.rs.getString("CrimeEdiondo"));
                jDataTerPena.setDate(conectaVC.rs.getDate("TerminoPena"));
                jVaraCondenacao.setText(conectaVC.rs.getString("VaraCondenatoria"));
                jDataNovaEntrada.setDate(conectaVC.rs.getDate("DataNovaEntrada"));
                caminhoFotoPerfil = conectaVC.rs.getString("FotoPerfil");
                caminho = conectaVC.rs.getString("FotoInternoCrc");
//                if (caminho != null) {
//                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
//                    FotoInternoExt.setIcon(i);
//                    FotoInternoExt.setIcon(new ImageIcon(i.getImage().getScaledInstance(FotoInternoExt.getWidth(), FotoInternoExt.getHeight(), Image.SCALE_SMOOTH)));
//                }
//                // FOTO DE FRENTE - BANCO DE DADOS
//                byte[] imgBytes = ((byte[]) conectaVC.rs.getBytes("ImagemFrente"));
//                if (imgBytes != null) {
//                    ImageIcon pic = null;
//                    pic = new ImageIcon(imgBytes);
//                    Image scaled = pic.getImage().getScaledInstance(FotoInternoExt.getWidth(), FotoInternoExt.getHeight(), Image.SCALE_SMOOTH);
//                    ImageIcon icon = new ImageIcon(scaled);
//                    FotoInternoExt.setIcon(icon);
//                }
                conectaVC.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados.\nERROR: " + e);
            }
        } else if (nomeUnidadeBAR == jTabelaInterno.getValueAt(jTabelaInterno.getSelectedRow(), 5)) {
            conectaBAR.abrirConexao();
            try {
                conectaBAR.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                        + "INNER JOIN DADOSFISICOSINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSFISICOSINTERNOS.IdInternoCrc "
                        + "INNER JOIN PAISES "
                        + "ON PRONTUARIOSCRC.IdPais=PAISES.IdPais "
                        + "INNER JOIN CIDADES "
                        + "ON PRONTUARIOSCRC.IdCidade=CIDADES.IdCidade "
                        + "INNER JOIN DADOSPENAISINTERNOS "
                        + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                        + "INNER JOIN UNIDADE "
                        + "ON DADOSPENAISINTERNOS.IdUnid=UNIDADE.IdUnid "
                        + "WHERE PRONTUARIOSCRC.IdInternoCrc='" + jIdInternoExt.getText() + "'");
                conectaBAR.rs.first();
                jIdInterno.setText(String.valueOf(conectaBAR.rs.getInt("IdInternoCrc")));
                jMatriculaPenal.setText(conectaBAR.rs.getString("MatriculaCrc"));
                jCNC.setText(conectaBAR.rs.getString("Cnc"));
                jDataCadastro.setDate(conectaBAR.rs.getDate("DataCadastCrc"));
                jDataNascimento.setDate(conectaBAR.rs.getDate("DataNasciCrc"));
                jNomeInterno.setText(conectaBAR.rs.getString("NomeInternoCrc"));
                jMaeInterno.setText(conectaBAR.rs.getString("MaeInternoCrc"));
                jPaiInterno.setText(conectaBAR.rs.getString("PaiInternoCrc"));
                jAlcunha.setText(conectaBAR.rs.getString("AlcunhaCrc"));
                jRGInterno.setText(conectaBAR.rs.getString("RgInternoCrc"));
                jCPFInterno.setText(conectaBAR.rs.getString("CpfInternoCrc"));
                jCartaoSus.setText(conectaBAR.rs.getString("CartaoSus"));
                jComboBoxEscolaridade.setSelectedItem(conectaBAR.rs.getString("EscolaridadeCrc"));
                jComboBoxEstadoCivil.setSelectedItem(conectaBAR.rs.getString("EstadoCivilCrc"));
                jComboBoxSexo.setSelectedItem(conectaBAR.rs.getString("SexoCrc"));
                jSituacao.setText(conectaBAR.rs.getString("SituacaoCrc"));
                jComboBoxPais.setText(conectaBAR.rs.getString("NomePais"));
                jComboBoxCidade.setText(conectaBAR.rs.getString("NomeCidade"));
                jReligiao.setText(conectaBAR.rs.getString("ReligiaoCrc"));
                jProfissao.setText(conectaBAR.rs.getString("ProfissaoCrc"));
                jEndereco.setText(conectaBAR.rs.getString("EnderecoCrc"));
                jBairro.setText(conectaBAR.rs.getString("BairroCrc"));
                jCidade.setText(conectaBAR.rs.getString("CidadeCrc"));
                jEstado.setText(conectaBAR.rs.getString("EstadoCrc"));
                // Tabela Dados Fisicos
                jComboBoxCutis.setSelectedItem(conectaBAR.rs.getString("Cutis"));
                jComboBoxOlhos.setSelectedItem(conectaBAR.rs.getString("Olhos"));
                jComboBoxCabelos.setSelectedItem(conectaBAR.rs.getString("Cabelos"));
                jComboBoxBarba.setSelectedItem(conectaBAR.rs.getString("Barba"));
                jComboBoxBigode.setSelectedItem(conectaBAR.rs.getString("Bigode"));
                jComboBoxNariz.setSelectedItem(conectaBAR.rs.getString("Nariz"));
                jComboBoxBoca.setSelectedItem(conectaBAR.rs.getString("Boca"));
                jComboBoxRosto.setSelectedItem(conectaBAR.rs.getString("Rosto"));
                jComboBoxLabios.setSelectedItem(conectaBAR.rs.getString("Labios"));
                jCamisa.setText(conectaBAR.rs.getString("Camisa"));
                jCalca.setText(conectaBAR.rs.getString("Calca"));
                jSapato.setText(conectaBAR.rs.getString("Sapato"));
                jPeso.setText(conectaBAR.rs.getString("Peso"));
                jAltura.setText(conectaBAR.rs.getString("Altura"));
                jParticularidade.setText(conectaBAR.rs.getString("Sinais"));
                jComboBoxOrelha.setSelectedItem(conectaBAR.rs.getString("Orelhas"));
                jComboBoxPescoco.setSelectedItem(conectaBAR.rs.getString("Pescoco"));
                jComboBoxCompleicao.setSelectedItem(conectaBAR.rs.getString("Compleicao"));
                // Tabela Dados Penais
                jDataEntrada.setDate(conectaBAR.rs.getDate("DataEntrada"));
                jComboBoxUnid.setText(conectaBAR.rs.getString("DescricaoUnid"));
                jDataCrime.setDate(conectaBAR.rs.getDate("DataCrime"));
                jDataPrisao.setDate(conectaBAR.rs.getDate("DataPrisao"));
                jDataCondenacao.setDate(conectaBAR.rs.getDate("DataCondenacao"));
                jComboBoxParticipacao.setSelectedItem(conectaBAR.rs.getString("Participacao"));
                jComboBoxRegime.setSelectedItem(conectaBAR.rs.getString("Regime"));
                jPena.setText(conectaBAR.rs.getString("Pena"));
                jArtigo1.setText(conectaBAR.rs.getString("Artigo1"));
                jArtigo2.setText(conectaBAR.rs.getString("Artigo2"));
                jArtigo3.setText(conectaBAR.rs.getString("Artigo3"));
                jParagrafo1.setText(conectaBAR.rs.getString("Paragrafo1"));
                jParagrafo2.setText(conectaBAR.rs.getString("Paragrafo2"));
                jParagrafo3.setText(conectaBAR.rs.getString("Paragrafo3"));
                jComboBoxEdiondo.setSelectedItem(conectaBAR.rs.getString("CrimeEdiondo"));
                jDataTerPena.setDate(conectaBAR.rs.getDate("TerminoPena"));
                jVaraCondenacao.setText(conectaBAR.rs.getString("VaraCondenatoria"));
                jDataNovaEntrada.setDate(conectaBAR.rs.getDate("DataNovaEntrada"));
                caminhoFotoPerfil = conectaBAR.rs.getString("FotoPerfil");
                caminho = conectaBAR.rs.getString("FotoInternoCrc");
//                if (caminho != null) {
//                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(caminho);
//                    FotoInternoExt.setIcon(i);
//                    FotoInternoExt.setIcon(new ImageIcon(i.getImage().getScaledInstance(FotoInternoExt.getWidth(), FotoInternoExt.getHeight(), Image.SCALE_SMOOTH)));
//                }
//                // FOTO DE FRENTE - BANCO DE DADOS
//                byte[] imgBytes = ((byte[]) conectaBAR.rs.getBytes("ImagemFrente"));
//                if (imgBytes != null) {
//                    ImageIcon pic = null;
//                    pic = new ImageIcon(imgBytes);
//                    Image scaled = pic.getImage().getScaledInstance(FotoInternoExt.getWidth(), FotoInternoExt.getHeight(), Image.SCALE_SMOOTH);
//                    ImageIcon icon = new ImageIcon(scaled);
//                    FotoInternoExt.setIcon(icon);
//                }
                conectaBAR.desconecta();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados.\nERROR: " + e);
            }
        }
    }
}
