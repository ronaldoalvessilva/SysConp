/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util.Produtividade;

import gestor.Controle.ControleListaTecnicosProdutividadePSP;
import gestor.Controle.ControleUpdatePSP;
import gestor.Controle.converterDataStringDataDate;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RegistroAtendimentoInternos;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ronaldo.silva7
 */
public class Produtividade extends javax.swing.JFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ControleListaTecnicosProdutividadePSP control = new ControleListaTecnicosProdutividadePSP();
    converterDataStringDataDate convertedata = new converterDataStringDataDate();
    RegistroAtendimentoInternos objProdKit = new RegistroAtendimentoInternos();
    ControleUpdatePSP pUPDATE_ATEND_PSP = new ControleUpdatePSP();
    //
    String dataEvolucao;
    public static int qtdTecnicosPSP = 0;
    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss"); // HORAIO DE 24 HORAS, PARA O DE 12 HORAS UTILIZAR hh:mm:ss
    SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
    public static String qtd;
    //QUANTIDADE A SER ATUALIZADA CASO O CAMPOS ATENDIDO ESTEJA COM "Sim"
    int pQUANTIDADE_ATEND = 1;

    //ConexaoDB con = new ConexaoDB();
    /**
     * Creates new form DisplayProdutividade
     */
    public Produtividade() {
        initComponents();
        mostrarDemostrativoPSP();
        setExtendedState(MAXIMIZED_BOTH); // Maximnizar a tela prinicpal
        Thread threadRelogio = new Thread() {

            @Override
            public void run() {
                rodaRelogio();
            }
        };
        threadRelogio.start();

        Thread threadTabela = new Thread() {

            @Override
            public void run() {
                atualizaTabela();
            }
        };
        threadTabela.start();

        Date data = new Date();
        String hora = formatter.format(data); // Data da conexão
        String date = formatter2.format(data); // Hora da conexão

        jHoraSistemaPSP.setText(String.valueOf(hora));    // no lugar do label, por seu JTextField    
        jDataSistemaPSP.setText(String.valueOf(date));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //Impedir que a janela seja fechada pelo X    
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                if (e.getID() == WindowEvent.WINDOW_CLOSING) {
                    int selectedOption = JOptionPane.showConfirmDialog(null, "Deseja realmente sair da Tela?", "Sistema informa:", JOptionPane.YES_NO_OPTION);
                    if (selectedOption == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCabecalho = new javax.swing.JPanel();
        jLabelCabecalho = new javax.swing.JLabel();
        jLabelLogoSocializa = new javax.swing.JLabel();
        jLabelLogoSisconp = new javax.swing.JLabel();
        jPanelTituloTela = new javax.swing.JPanel();
        RotulojPanel = new javax.swing.JPanel();
        jPanelDataTecSet = new javax.swing.JPanel();
        jPanelData = new javax.swing.JPanel();
        jPanelTecnico = new javax.swing.JPanel();
        jLabelTecnico = new javax.swing.JLabel();
        jPanelTSstDiaSemMes = new javax.swing.JPanel();
        jPanelSetor = new javax.swing.JPanel();
        jLabelSetor = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanelSetor1 = new javax.swing.JPanel();
        jLabelSetor1 = new javax.swing.JLabel();
        jPanelSetor2 = new javax.swing.JPanel();
        jLabelSetor2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelTabela = new javax.swing.JPanel();
        jScrollPaneTabela = new javax.swing.JScrollPane();
        jTabelaAtendimentoProdutivida = new javax.swing.JTable();
        jPanelRodape = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanelDataHora = new javax.swing.JPanel();
        jPanelNomeData = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanelExibeData = new javax.swing.JPanel();
        jDataSistemaPSP = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanelHoras = new javax.swing.JPanel();
        jHoraSistemaPSP = new javax.swing.JLabel();
        jPanelBotao = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISCONP - Sistema de Controle Prisional");
        setBackground(new java.awt.Color(0, 153, 204));

        jPanelCabecalho.setBackground(new java.awt.Color(255, 255, 255));

        jLabelCabecalho.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelCabecalho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCabecalho.setText("DEMONSTRATIVO DE ATENDIMENTO E PRODUTIVIDADE");

        jLabelLogoSocializa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/logoSocializa200.jpg"))); // NOI18N

        jLabelLogoSisconp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoSisconp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/ICONE70.png"))); // NOI18N

        javax.swing.GroupLayout jPanelCabecalhoLayout = new javax.swing.GroupLayout(jPanelCabecalho);
        jPanelCabecalho.setLayout(jPanelCabecalhoLayout);
        jPanelCabecalhoLayout.setHorizontalGroup(
            jPanelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCabecalhoLayout.createSequentialGroup()
                .addComponent(jLabelLogoSocializa, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLogoSisconp, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelCabecalhoLayout.setVerticalGroup(
            jPanelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelLogoSocializa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelCabecalhoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelCabecalho)
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(jLabelLogoSisconp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelTituloTela.setBackground(new java.awt.Color(0, 153, 204));
        jPanelTituloTela.setLayout(new java.awt.BorderLayout());

        RotulojPanel.setLayout(new javax.swing.BoxLayout(RotulojPanel, javax.swing.BoxLayout.LINE_AXIS));

        jPanelDataTecSet.setPreferredSize(new java.awt.Dimension(99, 80));
        jPanelDataTecSet.setLayout(new java.awt.BorderLayout());

        jPanelData.setMinimumSize(new java.awt.Dimension(150, 44));
        jPanelData.setLayout(new java.awt.BorderLayout());
        jPanelDataTecSet.add(jPanelData, java.awt.BorderLayout.LINE_START);

        jPanelTecnico.setLayout(new java.awt.BorderLayout());

        jLabelTecnico.setBackground(new java.awt.Color(0, 153, 153));
        jLabelTecnico.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelTecnico.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTecnico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTecnico.setText("TÉCNICO");
        jLabelTecnico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelTecnico.setMinimumSize(new java.awt.Dimension(150, 44));
        jLabelTecnico.setOpaque(true);
        jPanelTecnico.add(jLabelTecnico, java.awt.BorderLayout.CENTER);

        jPanelDataTecSet.add(jPanelTecnico, java.awt.BorderLayout.CENTER);

        RotulojPanel.add(jPanelDataTecSet);

        jPanelTSstDiaSemMes.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTSstDiaSemMes.setLayout(new java.awt.BorderLayout());

        jPanelSetor.setMinimumSize(new java.awt.Dimension(150, 44));
        jPanelSetor.setLayout(new java.awt.BorderLayout());

        jLabelSetor.setBackground(new java.awt.Color(51, 0, 51));
        jLabelSetor.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelSetor.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSetor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSetor.setText("          SETOR          ");
        jLabelSetor.setOpaque(true);
        jPanelSetor.add(jLabelSetor, java.awt.BorderLayout.CENTER);

        jPanelTSstDiaSemMes.add(jPanelSetor, java.awt.BorderLayout.LINE_START);

        jPanel1.setPreferredSize(new java.awt.Dimension(1, 80));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jPanelSetor1.setMinimumSize(new java.awt.Dimension(150, 44));
        jPanelSetor1.setLayout(new java.awt.BorderLayout());

        jLabelSetor1.setBackground(new java.awt.Color(255, 153, 0));
        jLabelSetor1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabelSetor1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSetor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSetor1.setText("DIÁRIO");
        jLabelSetor1.setOpaque(true);
        jPanelSetor1.add(jLabelSetor1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanelSetor1);

        jPanelSetor2.setMinimumSize(new java.awt.Dimension(150, 44));
        jPanelSetor2.setLayout(new java.awt.BorderLayout());

        jLabelSetor2.setBackground(new java.awt.Color(0, 51, 51));
        jLabelSetor2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabelSetor2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSetor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSetor2.setText("SEMANAL");
        jLabelSetor2.setToolTipText("");
        jLabelSetor2.setOpaque(true);
        jPanelSetor2.add(jLabelSetor2, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanelSetor2);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENSAL");
        jLabel1.setOpaque(true);
        jPanel2.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2);

        jPanelTSstDiaSemMes.add(jPanel1, java.awt.BorderLayout.CENTER);

        RotulojPanel.add(jPanelTSstDiaSemMes);

        jPanelTituloTela.add(RotulojPanel, java.awt.BorderLayout.NORTH);

        jPanelTabela.setBackground(new java.awt.Color(0, 153, 204));
        jPanelTabela.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelTabela.setForeground(new java.awt.Color(255, 255, 255));
        jPanelTabela.setLayout(new java.awt.BorderLayout());

        jTabelaAtendimentoProdutivida.setAutoCreateRowSorter(true);
        jTabelaAtendimentoProdutivida.setBackground(new java.awt.Color(255, 255, 204));
        jTabelaAtendimentoProdutivida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaAtendimentoProdutivida.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jTabelaAtendimentoProdutivida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabelaAtendimentoProdutivida.setRowHeight(35);
        jScrollPaneTabela.setViewportView(jTabelaAtendimentoProdutivida);
        if (jTabelaAtendimentoProdutivida.getColumnModel().getColumnCount() > 0) {
            jTabelaAtendimentoProdutivida.getColumnModel().getColumn(0).setPreferredWidth(550);
            jTabelaAtendimentoProdutivida.getColumnModel().getColumn(1).setPreferredWidth(340);
            jTabelaAtendimentoProdutivida.getColumnModel().getColumn(2).setPreferredWidth(130);
            jTabelaAtendimentoProdutivida.getColumnModel().getColumn(3).setPreferredWidth(155);
            jTabelaAtendimentoProdutivida.getColumnModel().getColumn(4).setPreferredWidth(160);
        }

        jPanelTabela.add(jScrollPaneTabela, java.awt.BorderLayout.CENTER);

        jPanelTituloTela.add(jPanelTabela, java.awt.BorderLayout.CENTER);

        jPanelRodape.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRodape.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelRodape.setPreferredSize(new java.awt.Dimension(603, 77));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Indicadores de Meta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 0))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("◙ Atendimento Médico Clínico e Psiquiátrico  > 30%  Mensal");
        jLabel2.setAlignmentX(0.5F);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("◙ Atendimento de Enfermagem                         > 30%  Mensal");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("◙ Procedimentos Odontológicos                        > 210    Mensal");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("◙ Assistência jurídica           > 35%  Trimestral");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("◙ Assistência Psicossocial   > 30%  Trimestral");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("◙ Assistência Laboral           >   3%   Mensal");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 101, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addGap(1, 1, 1))
        );

        jPanelNomeData.setBackground(new java.awt.Color(0, 102, 102));
        jPanelNomeData.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelNomeData.setForeground(new java.awt.Color(0, 0, 153));
        jPanelNomeData.setToolTipText("");
        jPanelNomeData.setLayout(new java.awt.BorderLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText(" Data: ");
        jPanelNomeData.add(jLabel15, java.awt.BorderLayout.CENTER);

        jPanelExibeData.setBackground(new java.awt.Color(0, 102, 102));
        jPanelExibeData.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelExibeData.setForeground(new java.awt.Color(0, 0, 153));
        jPanelExibeData.setToolTipText("");
        jPanelExibeData.setLayout(new java.awt.BorderLayout());

        jDataSistemaPSP.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jDataSistemaPSP.setForeground(new java.awt.Color(255, 255, 255));
        jDataSistemaPSP.setText(" dd/mm/aa ");
        jPanelExibeData.add(jDataSistemaPSP, java.awt.BorderLayout.CENTER);

        jPanel17.setBackground(new java.awt.Color(0, 102, 102));
        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel17.setForeground(new java.awt.Color(0, 0, 153));
        jPanel17.setToolTipText("");
        jPanel17.setLayout(new java.awt.BorderLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText(" Hora: ");
        jPanel17.add(jLabel9, java.awt.BorderLayout.CENTER);

        jPanelHoras.setBackground(new java.awt.Color(0, 102, 102));
        jPanelHoras.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelHoras.setForeground(new java.awt.Color(0, 0, 153));
        jPanelHoras.setToolTipText("");
        jPanelHoras.setLayout(new java.awt.BorderLayout());

        jHoraSistemaPSP.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jHoraSistemaPSP.setForeground(new java.awt.Color(255, 255, 255));
        jHoraSistemaPSP.setText(" 00:00:00 ");
        jPanelHoras.add(jHoraSistemaPSP, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanelDataHoraLayout = new javax.swing.GroupLayout(jPanelDataHora);
        jPanelDataHora.setLayout(jPanelDataHoraLayout);
        jPanelDataHoraLayout.setHorizontalGroup(
            jPanelDataHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataHoraLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanelNomeData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelExibeData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelDataHoraLayout.setVerticalGroup(
            jPanelDataHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNomeData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelExibeData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelHoras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelBotao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setBackground(new java.awt.Color(240, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Refresh_Icon_32.png"))); // NOI18N
        jButton1.setText("Atualizar");
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotaoLayout = new javax.swing.GroupLayout(jPanelBotao);
        jPanelBotao.setLayout(jPanelBotaoLayout);
        jPanelBotaoLayout.setHorizontalGroup(
            jPanelBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotaoLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanelBotaoLayout.setVerticalGroup(
            jPanelBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelRodapeLayout = new javax.swing.GroupLayout(jPanelRodape);
        jPanelRodape.setLayout(jPanelRodapeLayout);
        jPanelRodapeLayout.setHorizontalGroup(
            jPanelRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRodapeLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelRodapeLayout.setVerticalGroup(
            jPanelRodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelDataHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelRodapeLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanelBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        jPanelTituloTela.add(jPanelRodape, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelTituloTela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanelTituloTela, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpaTabela();
        mostrarDemostrativoPSP();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Produtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produtividade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Produtividade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel RotulojPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jDataSistemaPSP;
    private javax.swing.JLabel jHoraSistemaPSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCabecalho;
    private javax.swing.JLabel jLabelLogoSisconp;
    private javax.swing.JLabel jLabelLogoSocializa;
    private javax.swing.JLabel jLabelSetor;
    private javax.swing.JLabel jLabelSetor1;
    private javax.swing.JLabel jLabelSetor2;
    private javax.swing.JLabel jLabelTecnico;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelBotao;
    private javax.swing.JPanel jPanelCabecalho;
    private javax.swing.JPanel jPanelData;
    private javax.swing.JPanel jPanelDataHora;
    private javax.swing.JPanel jPanelDataTecSet;
    private javax.swing.JPanel jPanelExibeData;
    private javax.swing.JPanel jPanelHoras;
    private javax.swing.JPanel jPanelNomeData;
    private javax.swing.JPanel jPanelRodape;
    private javax.swing.JPanel jPanelSetor;
    private javax.swing.JPanel jPanelSetor1;
    private javax.swing.JPanel jPanelSetor2;
    private javax.swing.JPanel jPanelTSstDiaSemMes;
    private javax.swing.JPanel jPanelTabela;
    private javax.swing.JPanel jPanelTecnico;
    private javax.swing.JPanel jPanelTituloTela;
    private javax.swing.JScrollPane jScrollPaneTabela;
    private javax.swing.JTable jTabelaAtendimentoProdutivida;
    // End of variables declaration//GEN-END:variables

    public void limpaTabela() {

        ((DefaultTableModel) jTabelaAtendimentoProdutivida.getModel()).setRowCount(0);
    }

    public void mostrarDemostrativoPSP() {
        DefaultTableModel dadosProduto = (DefaultTableModel) jTabelaAtendimentoProdutivida.getModel();
        RegistroAtendimentoInternos p = new RegistroAtendimentoInternos();
        try {
            for (RegistroAtendimentoInternos pp : control.read()) {
                if (pp.getQtdAtend() != 0 || pp.getQtdAtendSem() != 0 || pp.getQtdAtendMes() != 0) {
                    dadosProduto.addRow(new Object[]{pp.getNomeFunc(), pp.getNomeDepartamento(), pp.getQtdAtend(), pp.getQtdAtendSem(), pp.getQtdAtendMes()});
                }
                // ALINHAR TEXTO DA TABELA CENTRALIZADO
                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);

                //
                jTabelaAtendimentoProdutivida.getColumnModel().getColumn(2).setCellRenderer(centralizado);
                jTabelaAtendimentoProdutivida.getColumnModel().getColumn(3).setCellRenderer(centralizado);
                jTabelaAtendimentoProdutivida.getColumnModel().getColumn(4).setCellRenderer(centralizado);
                int total = 0;
                for (int i = 0; i < dadosProduto.getRowCount(); i++) {
                    total += Integer.parseInt(dadosProduto.getValueAt(i, 2).toString());// 3rd column . row column indexes are 0 based   

                }
                jTabelaAtendimentoProdutivida.revalidate();
            }
        } catch (Exception ex) {
            Logger.getLogger(Produtividade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rodaRelogio() {
        try {
            while (true) {
                Date data = new Date();
                String hora = formatter.format(data);
                String date = formatter2.format(data);
                jHoraSistemaPSP.setText(String.valueOf(hora));    // no lugar do label, por seu JTextField    
                jDataSistemaPSP.setText(String.valueOf(date));
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
        }
    }

    public void atualizaTabela() {
        try {
            while (true) {
                limpaTabela();
                objProdKit.setQtdAtend(pQUANTIDADE_ATEND);
                pUPDATE_ATEND_PSP.alterar_QUANTIDADE_ATENDIDO(objProdKit);
                mostrarDemostrativoPSP();
                Thread.sleep(60000);
            }
        } catch (Exception e) {
        }
    }

}
