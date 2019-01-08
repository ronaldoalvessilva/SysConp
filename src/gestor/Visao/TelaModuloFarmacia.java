/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import gestor.Dao.ModeloTabela;
import static gestor.Visao.TelaAgendaCompromissos.jAssunto;
import static gestor.Visao.TelaAgendaCompromissos.jBtAlterarComp;
import static gestor.Visao.TelaAgendaCompromissos.jBtCancelarComp;
import static gestor.Visao.TelaAgendaCompromissos.jBtConfirmarCompromisso;
import static gestor.Visao.TelaAgendaCompromissos.jBtExcluirComp;
import static gestor.Visao.TelaAgendaCompromissos.jBtNovoComp;
import static gestor.Visao.TelaAgendaCompromissos.jBtSalvarComp;
import static gestor.Visao.TelaAgendaCompromissos.jCodigoAgendaComp;
import static gestor.Visao.TelaAgendaCompromissos.jComboBoxConclusao;
import static gestor.Visao.TelaAgendaCompromissos.jComboBoxPrioridade;
import static gestor.Visao.TelaAgendaCompromissos.jComboBoxStatusComp;
import static gestor.Visao.TelaAgendaCompromissos.jComboBoxTipoEvento;
import static gestor.Visao.TelaAgendaCompromissos.jDataEvento;
import static gestor.Visao.TelaAgendaCompromissos.jDataInicio;
import static gestor.Visao.TelaAgendaCompromissos.jDataLembrete;
import static gestor.Visao.TelaAgendaCompromissos.jDataTermino;
import static gestor.Visao.TelaAgendaCompromissos.jHoraInicio;
import static gestor.Visao.TelaAgendaCompromissos.jHoraLembrete;
import static gestor.Visao.TelaAgendaCompromissos.jHoraTermino;
import static gestor.Visao.TelaAgendaCompromissos.jNomeUsuarioAgenda;
import static gestor.Visao.TelaAgendaCompromissos.jTabelaAgendaEventos;
import static gestor.Visao.TelaAgendaCompromissos.jTextoEvento;
import static gestor.Visao.TelaAgendaCompromissos.jtotalRegistros;
import static gestor.Visao.TelaLoginSenha.nameUser;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaRecadosEnfermaria.jBtConfirmar;
import static gestor.Visao.TelaRecadosEnfermaria.jBtResponder;
import static gestor.Visao.TelaRecadosFarmacia.jBtAlterar;
import static gestor.Visao.TelaRecadosFarmacia.jBtCancelar;
import static gestor.Visao.TelaRecadosFarmacia.jBtExcluir;
import static gestor.Visao.TelaRecadosFarmacia.jBtNovo;
import static gestor.Visao.TelaRecadosFarmacia.jBtSalvar;
import static gestor.Visao.TelaRecadosFarmacia.jComboBoxStatus;
import static gestor.Visao.TelaRecadosFarmacia.jDataLanc;
import static gestor.Visao.TelaRecadosFarmacia.jHoraRecado;
import static gestor.Visao.TelaRecadosFarmacia.jIDLanc;
import static gestor.Visao.TelaRecadosFarmacia.jNomeDestinatario;
import static gestor.Visao.TelaRecadosFarmacia.jNomeRementente;
import static gestor.Visao.TelaRecadosFarmacia.jRecado;
import static gestor.Visao.TelaRecadosFarmacia.jTabelaTodosRecados;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
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
 * @author Ronaldo
 */
public class TelaModuloFarmacia extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    private TelaRecadosFarmacia objRecadoFar = null;
    private TelaFornecedor objForMed = null;
    private TelaMedicamentos objProdMed = null;
    private TelaGrupoMedicamentos objGrupoMed = null;
    private TelaLocalMaster objLocalMaster = null;
    private TelaConsultaEstoqueFAR objConEstoqueMed = null;
    private TelaInventarioProdutosMed objInvEstoque = null;
    private TelaTransferenciaEstoqueFarmacia objTransProd = null;
    private TelaEntradaProdutos objNfeCompras = null;
    private TelaRequisicaoAvulsaFAR objReqAvulFAR = null;
    private TelaEstornoRequisicaoMateriaisFAR objEstTransReqFAR = null;
    private TelaSolicitacaoComprasMateriaisFAR objCompraFAR = null;
    private TelaMotivoSaidaProdutosFAR objMotivo = null;
    private TelaAgendaCompromissos objAgEventos = null;
    private TelaConsultasPrescricao objConspes = null;
    //
    String dataLanc;
    int codUsuario;
    int flag;
    String statusAgenda = "Pendente";
    int tempo = (1000 * 60) * 5;   // 5 min.  
    int periodo = 1;  // quantidade de vezes a ser executado.  
    String modulo = "F";
    int count = 0;
    // VARIÁVEIS PARA AGENDA DE COMPROMISSO.
    String dataAgenda;
    String nomeUsuarioCompromisso; // USUÁRIO DA AGENDA DE COMPROMISSO.
    String horaLembrete;
    String usuarioAgenda;
    String codigoAgendaComp;

    /**
     * Creates new form TelaOdontologia
     */
    public TelaModuloFarmacia() {
        initComponents();
        this.setSize(840, 640); // Tamanho da tela 
        threadMensagem();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPainelFarmacia = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Fornecedores = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        LocalArmazenamento = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        GrupoProdutos = new javax.swing.JMenuItem();
        Produtos = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMotivoSaida = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        AgendaCompromissoPessoal = new javax.swing.JMenuItem();
        jAgendaRecados = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        ConsultaEstoque = new javax.swing.JMenuItem();
        PrescricaoMedicaPsiquiatricaOdonto = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        NFeEntradaProdutos = new javax.swing.JMenuItem();
        Inventario = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();
        TransferenciaProdutos = new javax.swing.JMenuItem();
        RequisicaoMaterialAvulsa = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        PedidoCompras = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        RelatorioCadastroProdutos = new javax.swing.JMenuItem();
        RelatorioProdutosConsumoAvulso = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        RelatorioEstoqueProdutos = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        RelatorioEntradaInternosUnidade = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("...::: Controle de Farmácia :::...");

        jPainelFarmacia.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/BrasaoFundo500Prata2.png"))); // NOI18N

        jPainelFarmacia.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelFarmaciaLayout = new javax.swing.GroupLayout(jPainelFarmacia);
        jPainelFarmacia.setLayout(jPainelFarmaciaLayout);
        jPainelFarmaciaLayout.setHorizontalGroup(
            jPainelFarmaciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
        );
        jPainelFarmaciaLayout.setVerticalGroup(
            jPainelFarmaciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelFarmaciaLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        jMenu1.setText("Cadastro");

        Fornecedores.setText("Fornecedores");
        Fornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FornecedoresActionPerformed(evt);
            }
        });
        jMenu1.add(Fornecedores);
        jMenu1.add(jSeparator1);

        LocalArmazenamento.setText("Local de Armazenamento");
        LocalArmazenamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalArmazenamentoActionPerformed(evt);
            }
        });
        jMenu1.add(LocalArmazenamento);
        jMenu1.add(jSeparator2);

        GrupoProdutos.setText("Grupos de Produtos/Medicamentos");
        GrupoProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GrupoProdutosActionPerformed(evt);
            }
        });
        jMenu1.add(GrupoProdutos);

        Produtos.setText("Produtos/Medicamentos");
        Produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdutosActionPerformed(evt);
            }
        });
        jMenu1.add(Produtos);
        jMenu1.add(jSeparator6);

        jMotivoSaida.setText("Motivo de Saída de Produtos/Medicamentos");
        jMotivoSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMotivoSaidaActionPerformed(evt);
            }
        });
        jMenu1.add(jMotivoSaida);
        jMenu1.add(jSeparator3);

        AgendaCompromissoPessoal.setText("Agenda de Compromissos Pessoal");
        AgendaCompromissoPessoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaCompromissoPessoalActionPerformed(evt);
            }
        });
        jMenu1.add(AgendaCompromissoPessoal);

        jAgendaRecados.setText("Agenda de Recados");
        jAgendaRecados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAgendaRecadosActionPerformed(evt);
            }
        });
        jMenu1.add(jAgendaRecados);
        jMenu1.add(jSeparator5);

        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu6.setText("Consultas");

        ConsultaEstoque.setText("Consulta de Estoque");
        ConsultaEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaEstoqueActionPerformed(evt);
            }
        });
        jMenu6.add(ConsultaEstoque);

        PrescricaoMedicaPsiquiatricaOdonto.setText("Prescrição Médica/Psiquiatrica/Odontologica");
        PrescricaoMedicaPsiquiatricaOdonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrescricaoMedicaPsiquiatricaOdontoActionPerformed(evt);
            }
        });
        jMenu6.add(PrescricaoMedicaPsiquiatricaOdonto);

        jMenuBar1.add(jMenu6);

        jMenu2.setText("Movimentação");

        NFeEntradaProdutos.setText("Compras de Produtos/Medicamentos - NFE Compras");
        NFeEntradaProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NFeEntradaProdutosActionPerformed(evt);
            }
        });
        jMenu2.add(NFeEntradaProdutos);

        Inventario.setText("Inventário de Estoque");
        Inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventarioActionPerformed(evt);
            }
        });
        jMenu2.add(Inventario);
        jMenu2.add(jSeparator4);

        jMenu4.setText("Saídas de Produtos");

        TransferenciaProdutos.setText("Transferências de Produtos entre Locais");
        TransferenciaProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransferenciaProdutosActionPerformed(evt);
            }
        });
        jMenu4.add(TransferenciaProdutos);

        RequisicaoMaterialAvulsa.setText("Requisição Avulsa de Produtos");
        RequisicaoMaterialAvulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequisicaoMaterialAvulsaActionPerformed(evt);
            }
        });
        jMenu4.add(RequisicaoMaterialAvulsa);

        jMenuItem2.setText("Estorno de Transferência/Requisição Avulsa de Produtos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenu2.add(jMenu4);
        jMenu2.add(jSeparator7);

        PedidoCompras.setText("Solicitação de Compras de Produtos");
        PedidoCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PedidoComprasActionPerformed(evt);
            }
        });
        jMenu2.add(PedidoCompras);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Relatórios");

        RelatorioCadastroProdutos.setText("Relatórios de Cadastro de Produtos");
        RelatorioCadastroProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioCadastroProdutosActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioCadastroProdutos);

        RelatorioProdutosConsumoAvulso.setText("Relatório de Produtos Consumo Avulso");
        RelatorioProdutosConsumoAvulso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioProdutosConsumoAvulsoActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioProdutosConsumoAvulso);
        jMenu3.add(jSeparator8);

        jMenuItem4.setText("Relatório Geral de Estoque de Produtos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        RelatorioEstoqueProdutos.setText("Relatório de Estoque de Produtos por Data");
        RelatorioEstoqueProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEstoqueProdutosActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioEstoqueProdutos);
        jMenu3.add(jSeparator9);

        jMenuItem3.setText("Relatório de Transferência de Produtos/Medicamentos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);
        jMenu3.add(jSeparator10);

        RelatorioEntradaInternosUnidade.setText("Relatório de Entrada de Internos na Unidade");
        RelatorioEntradaInternosUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaInternosUnidadeActionPerformed(evt);
            }
        });
        jMenu3.add(RelatorioEntradaInternosUnidade);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelFarmacia)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelFarmacia, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void GrupoProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrupoProdutosActionPerformed
        // TODO add your handling code here:
        if (objGrupoMed == null || objGrupoMed.isClosed()) {
            objGrupoMed = new TelaGrupoMedicamentos();
            jPainelFarmacia.add(objGrupoMed);
            objGrupoMed.setVisible(true);
        } else {
            if (objGrupoMed.isVisible()) {
                if (objGrupoMed.isIcon()) { // Se esta minimizado
                    try {
                        objGrupoMed.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objGrupoMed.toFront(); // traz para frente
                    objGrupoMed.pack();//volta frame 
                }
            } else {
                objGrupoMed = new TelaGrupoMedicamentos();
                TelaModuloFarmacia.jPainelFarmacia.add(objGrupoMed);//adicona frame ao JDesktopPane  
                objGrupoMed.setVisible(true);
            }
        }
        try {
            objGrupoMed.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_GrupoProdutosActionPerformed

    private void ProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdutosActionPerformed
        // TODO add your handling code here:
        if (objProdMed == null || objProdMed.isClosed()) {
            objProdMed = new TelaMedicamentos();
            jPainelFarmacia.add(objProdMed);
            objProdMed.setVisible(true);
        } else {
            if (objProdMed.isVisible()) {
                if (objProdMed.isIcon()) { // Se esta minimizado
                    try {
                        objProdMed.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objProdMed.toFront(); // traz para frente
                    objProdMed.pack();//volta frame 
                }
            } else {
                objProdMed = new TelaMedicamentos();
                TelaModuloFarmacia.jPainelFarmacia.add(objProdMed);//adicona frame ao JDesktopPane  
                objProdMed.setVisible(true);
            }
        }
        try {
            objProdMed.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ProdutosActionPerformed

    private void FornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FornecedoresActionPerformed
        // TODO add your handling code here:
        if (objForMed == null || objForMed.isClosed()) {
            objForMed = new TelaFornecedor();
            jPainelFarmacia.add(objForMed);
            objForMed.setVisible(true);
        } else {
            if (objForMed.isVisible()) {
                if (objForMed.isIcon()) { // Se esta minimizado
                    try {
                        objForMed.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objForMed.toFront(); // traz para frente
                    objForMed.pack();//volta frame 
                }
            } else {
                objForMed = new TelaFornecedor();
                TelaModuloFarmacia.jPainelFarmacia.add(objForMed);//adicona frame ao JDesktopPane  
                objForMed.setVisible(true);
            }
        }
        try {
            objForMed.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_FornecedoresActionPerformed

    private void LocalArmazenamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalArmazenamentoActionPerformed
        // TODO add your handling code here:
        if (objLocalMaster == null || objLocalMaster.isClosed()) {
            objLocalMaster = new TelaLocalMaster();
            jPainelFarmacia.add(objLocalMaster);
            objLocalMaster.setVisible(true);
        } else {
            if (objLocalMaster.isVisible()) {
                if (objLocalMaster.isIcon()) { // Se esta minimizado
                    try {
                        objLocalMaster.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objLocalMaster.toFront(); // traz para frente
                    objLocalMaster.pack();//volta frame 
                }
            } else {
                objLocalMaster = new TelaLocalMaster();
                TelaModuloFarmacia.jPainelFarmacia.add(objLocalMaster);//adicona frame ao JDesktopPane  
                objLocalMaster.setVisible(true);
            }
        }
        try {
            objLocalMaster.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_LocalArmazenamentoActionPerformed

    private void ConsultaEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaEstoqueActionPerformed
        // TODO add your handling code here:
        if (objConEstoqueMed == null || objConEstoqueMed.isClosed()) {
            objConEstoqueMed = new TelaConsultaEstoqueFAR();
            jPainelFarmacia.add(objConEstoqueMed);
            objConEstoqueMed.setVisible(true);
        } else {
            if (objConEstoqueMed.isVisible()) {
                if (objConEstoqueMed.isIcon()) { // Se esta minimizado
                    try {
                        objConEstoqueMed.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConEstoqueMed.toFront(); // traz para frente
                    objConEstoqueMed.pack();//volta frame 
                }
            } else {
                objConEstoqueMed = new TelaConsultaEstoqueFAR();
                TelaModuloFarmacia.jPainelFarmacia.add(objConEstoqueMed);//adicona frame ao JDesktopPane  
                objConEstoqueMed.setVisible(true);
            }
        }
        try {
            objConEstoqueMed.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ConsultaEstoqueActionPerformed

    private void InventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventarioActionPerformed
        // TODO add your handling code here:
        if (objInvEstoque == null || objInvEstoque.isClosed()) {
            objInvEstoque = new TelaInventarioProdutosMed();
            jPainelFarmacia.add(objInvEstoque);
            objInvEstoque.setVisible(true);
        } else {
            if (objInvEstoque.isVisible()) {
                if (objInvEstoque.isIcon()) { // Se esta minimizado
                    try {
                        objInvEstoque.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objInvEstoque.toFront(); // traz para frente
                    objInvEstoque.pack();//volta frame 
                }
            } else {
                objInvEstoque = new TelaInventarioProdutosMed();
                TelaModuloFarmacia.jPainelFarmacia.add(objInvEstoque);//adicona frame ao JDesktopPane  
                objInvEstoque.setVisible(true);
            }
        }
        try {
            objInvEstoque.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_InventarioActionPerformed

    private void TransferenciaProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransferenciaProdutosActionPerformed
        // TODO add your handling code here:
        if (objTransProd == null || objTransProd.isClosed()) {
            objTransProd = new TelaTransferenciaEstoqueFarmacia();
            jPainelFarmacia.add(objTransProd);
            objTransProd.setVisible(true);
        } else {
            if (objTransProd.isVisible()) {
                if (objTransProd.isIcon()) { // Se esta minimizado
                    try {
                        objTransProd.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objTransProd.toFront(); // traz para frente
                    objTransProd.pack();//volta frame 
                }
            } else {
                objTransProd = new TelaTransferenciaEstoqueFarmacia();
                TelaModuloFarmacia.jPainelFarmacia.add(objTransProd);//adicona frame ao JDesktopPane  
                objTransProd.setVisible(true);
            }
        }
        try {
            objTransProd.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_TransferenciaProdutosActionPerformed

    private void NFeEntradaProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NFeEntradaProdutosActionPerformed
        // TODO add your handling code here:
        if (objNfeCompras == null || objNfeCompras.isClosed()) {
            objNfeCompras = new TelaEntradaProdutos();
            jPainelFarmacia.add(objNfeCompras);
            objNfeCompras.setVisible(true);
        } else {
            if (objNfeCompras.isVisible()) {
                if (objNfeCompras.isIcon()) { // Se esta minimizado
                    try {
                        objNfeCompras.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objNfeCompras.toFront(); // traz para frente
                    objNfeCompras.pack();//volta frame 
                }
            } else {
                objNfeCompras = new TelaEntradaProdutos();
                TelaModuloFarmacia.jPainelFarmacia.add(objNfeCompras);//adicona frame ao JDesktopPane  
                objNfeCompras.setVisible(true);
            }
        }
        try {
            objNfeCompras.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_NFeEntradaProdutosActionPerformed

    private void RequisicaoMaterialAvulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequisicaoMaterialAvulsaActionPerformed
        // TODO add your handling code here:
        if (objReqAvulFAR == null || objReqAvulFAR.isClosed()) {
            objReqAvulFAR = new TelaRequisicaoAvulsaFAR();
            jPainelFarmacia.add(objReqAvulFAR);
            objReqAvulFAR.setVisible(true);
        } else {
            if (objReqAvulFAR.isVisible()) {
                if (objReqAvulFAR.isIcon()) { // Se esta minimizado
                    try {
                        objReqAvulFAR.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objReqAvulFAR.toFront(); // traz para frente
                    objReqAvulFAR.pack();//volta frame 
                }
            } else {
                objReqAvulFAR = new TelaRequisicaoAvulsaFAR();
                TelaModuloFarmacia.jPainelFarmacia.add(objReqAvulFAR);//adicona frame ao JDesktopPane  
                objReqAvulFAR.setVisible(true);
            }
        }
        try {
            objReqAvulFAR.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_RequisicaoMaterialAvulsaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        if (objEstTransReqFAR == null || objEstTransReqFAR.isClosed()) {
            objEstTransReqFAR = new TelaEstornoRequisicaoMateriaisFAR();
            jPainelFarmacia.add(objEstTransReqFAR);
            objEstTransReqFAR.setVisible(true);
        } else {
            if (objEstTransReqFAR.isVisible()) {
                if (objEstTransReqFAR.isIcon()) { // Se esta minimizado
                    try {
                        objEstTransReqFAR.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objEstTransReqFAR.toFront(); // traz para frente
                    objEstTransReqFAR.pack();//volta frame 
                }
            } else {
                objEstTransReqFAR = new TelaEstornoRequisicaoMateriaisFAR();
                TelaModuloFarmacia.jPainelFarmacia.add(objEstTransReqFAR);//adicona frame ao JDesktopPane  
                objEstTransReqFAR.setVisible(true);
            }
        }
        try {
            objEstTransReqFAR.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void PedidoComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PedidoComprasActionPerformed
        // TODO add your handling code here:
        if (objCompraFAR == null || objCompraFAR.isClosed()) {
            objCompraFAR = new TelaSolicitacaoComprasMateriaisFAR();
            jPainelFarmacia.add(objCompraFAR);
            objCompraFAR.setVisible(true);
        } else {
            if (objCompraFAR.isVisible()) {
                if (objCompraFAR.isIcon()) { // Se esta minimizado
                    try {
                        objCompraFAR.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objCompraFAR.toFront(); // traz para frente
                    objCompraFAR.pack();//volta frame 
                }
            } else {
                objCompraFAR = new TelaSolicitacaoComprasMateriaisFAR();
                TelaModuloFarmacia.jPainelFarmacia.add(objCompraFAR);//adicona frame ao JDesktopPane  
                objCompraFAR.setVisible(true);
            }
        }
        try {
            objCompraFAR.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_PedidoComprasActionPerformed

    private void jMotivoSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMotivoSaidaActionPerformed
        // TODO add your handling code here:
        if (objMotivo == null || objMotivo.isClosed()) {
            objMotivo = new TelaMotivoSaidaProdutosFAR();
            jPainelFarmacia.add(objMotivo);
            objMotivo.setVisible(true);
        } else {
            if (objMotivo.isVisible()) {
                if (objMotivo.isIcon()) { // Se esta minimizado
                    try {
                        objMotivo.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objMotivo.toFront(); // traz para frente
                    objMotivo.pack();//volta frame 
                }
            } else {
                objMotivo = new TelaMotivoSaidaProdutosFAR();
                TelaModuloFarmacia.jPainelFarmacia.add(objMotivo);//adicona frame ao JDesktopPane  
                objMotivo.setVisible(true);
            }
        }
        try {
            objMotivo.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jMotivoSaidaActionPerformed

    private void jAgendaRecadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgendaRecadosActionPerformed
        // TODO add your handling code here:
        if (objRecadoFar == null || objRecadoFar.isClosed()) {
            objRecadoFar = new TelaRecadosFarmacia();
            jPainelFarmacia.add(objRecadoFar);
            objRecadoFar.setVisible(true);
        } else {
            if (objRecadoFar.isVisible()) {
                if (objRecadoFar.isIcon()) { // Se esta minimizado
                    try {
                        objRecadoFar.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRecadoFar.toFront(); // traz para frente
                    objRecadoFar.pack();//volta frame 
                }
            } else {
                objRecadoFar = new TelaRecadosFarmacia();
                TelaModuloFarmacia.jPainelFarmacia.add(objRecadoFar);//adicona frame ao JDesktopPane  
                objRecadoFar.setVisible(true);
            }
        }
        try {
            objRecadoFar.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jAgendaRecadosActionPerformed

    private void RelatorioCadastroProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioCadastroProdutosActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioProdutosCadastradosPorGrupoFAR.jasper";
            conecta.executaSQL("SELECT * FROM PRODUTOS_AC "
                    + "INNER JOIN GRUPO_PRODUTOS_AC "
                    + "ON PRODUTOS_AC.IdGrupo=GRUPO_PRODUTOS_AC.IdGrupo WHERE PRODUTOS_AC.Modulo='" + modulo + "' "
                    + "ORDER BY GRUPO_PRODUTOS_AC.NomeGrupo,PRODUTOS_AC.DescricaoProd");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            parametros.put("modulo", modulo);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Produtos Cadastrados Por Grupo");
            jv.setVisible(true); // Chama o relatorio para ser visualizado
            jv.toFront(); // Traz o relatorio para frente da aplicação
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioCadastroProdutosActionPerformed

    private void RelatorioProdutosConsumoAvulsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioProdutosConsumoAvulsoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConsumoProdutosAvulsoFAR objRelConsuProdAvul = new TelaRelatorioConsumoProdutosAvulsoFAR();
        TelaModuloFarmacia.jPainelFarmacia.add(objRelConsuProdAvul);
        objRelConsuProdAvul.show();
    }//GEN-LAST:event_RelatorioProdutosConsumoAvulsoActionPerformed

    private void RelatorioEstoqueProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEstoqueProdutosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEstoqueProdutosFAR objRelEstProd = new TelaRelatorioEstoqueProdutosFAR();
        TelaModuloFarmacia.jPainelFarmacia.add(objRelEstProd);
        objRelEstProd.show();
    }//GEN-LAST:event_RelatorioEstoqueProdutosActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        TelaRelatorioTransferenciaEntreLocais objRelTranf = new TelaRelatorioTransferenciaEntreLocais();
        TelaModuloFarmacia.jPainelFarmacia.add(objRelTranf);
        objRelTranf.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void AgendaCompromissoPessoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaCompromissoPessoalActionPerformed
        // TODO add your handling code here:
        if (objAgEventos == null || objAgEventos.isClosed()) {
            objAgEventos = new TelaAgendaCompromissos();
            jPainelFarmacia.add(objAgEventos);
            objAgEventos.setVisible(true);
        } else {
            if (objAgEventos.isVisible()) {
                if (objAgEventos.isIcon()) { // Se esta minimizado
                    try {
                        objAgEventos.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objAgEventos.toFront(); // traz para frente
                    objAgEventos.pack();//volta frame 
                }
            } else {
                objAgEventos = new TelaAgendaCompromissos();
                TelaModuloFarmacia.jPainelFarmacia.add(objAgEventos);//adicona frame ao JDesktopPane  
                objAgEventos.setVisible(true);
            }
        }
        try {
            objAgEventos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaCompromissoPessoalActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioGeralEstoqueFarmacia.jasper";
            conecta.executaSQL("SELECT * FROM PRODUTOS_AC "
                    + "INNER JOIN LOTE_PRODUTOS_AC "
                    + "ON PRODUTOS_AC.IdProd=LOTE_PRODUTOS_AC.IdProd "
                    + "WHERE PRODUTOS_AC.Modulo='" + modulo + "'AND Qtd>'" + 0 + "'");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório Geral de Estoque de Produtos");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void RelatorioEntradaInternosUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaInternosUnidadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradas objRelEntradaInter = new TelaRelatorioEntradas();
        TelaModuloFarmacia.jPainelFarmacia.add(objRelEntradaInter);
        objRelEntradaInter.show();
    }//GEN-LAST:event_RelatorioEntradaInternosUnidadeActionPerformed

    private void PrescricaoMedicaPsiquiatricaOdontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrescricaoMedicaPsiquiatricaOdontoActionPerformed
        // TODO add your handling code here:
         if (objConspes == null || objConspes.isClosed()) {
            objConspes = new TelaConsultasPrescricao();
            jPainelFarmacia.add(objConspes);
            objConspes.setVisible(true);
        } else {
            if (objConspes.isVisible()) {
                if (objConspes.isIcon()) { // Se esta minimizado
                    try {
                        objConspes.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConspes.toFront(); // traz para frente
                    objConspes.pack();//volta frame 
                }
            } else {
                objConspes = new TelaConsultasPrescricao();
                TelaModuloFarmacia.jPainelFarmacia.add(objConspes);//adicona frame ao JDesktopPane  
                objConspes.setVisible(true);
            }
        }
        try {
            objConspes.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
//    private TelaConsultasPrescricao objConspes = null;
    }//GEN-LAST:event_PrescricaoMedicaPsiquiatricaOdontoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgendaCompromissoPessoal;
    private javax.swing.JMenuItem ConsultaEstoque;
    private javax.swing.JMenuItem Fornecedores;
    private javax.swing.JMenuItem GrupoProdutos;
    private javax.swing.JMenuItem Inventario;
    private javax.swing.JMenuItem LocalArmazenamento;
    private javax.swing.JMenuItem NFeEntradaProdutos;
    private javax.swing.JMenuItem PedidoCompras;
    private javax.swing.JMenuItem PrescricaoMedicaPsiquiatricaOdonto;
    private javax.swing.JMenuItem Produtos;
    private javax.swing.JMenuItem RelatorioCadastroProdutos;
    private javax.swing.JMenuItem RelatorioEntradaInternosUnidade;
    private javax.swing.JMenuItem RelatorioEstoqueProdutos;
    private javax.swing.JMenuItem RelatorioProdutosConsumoAvulso;
    private javax.swing.JMenuItem RequisicaoMaterialAvulsa;
    private javax.swing.JMenuItem TransferenciaProdutos;
    private javax.swing.JMenuItem jAgendaRecados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMotivoSaida;
    public static javax.swing.JDesktopPane jPainelFarmacia;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    // End of variables declaration//GEN-END:variables

    // Verificar a cada 5 minutos se o recado foi lido (10/01/2015)
    public void threadMensagem() {
        final Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                verificarRecado();
                verificarAgendaCompromisso();
            }
        }, periodo, tempo);
    }

    public void verificarRecado() {
        buscarUsuario(nameUser);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AGENDARECADOS WHERE IdUsuario='" + codUsuario + "'AND StatusAgenda='" + statusAgenda + "'");
            conecta.rs.first();
            if (codUsuario == conecta.rs.getInt("IdUsuario")) {
                // Abrir uma única tela, Tela de Recados Portaria
                if (objRecadoFar == null || objRecadoFar.isClosed()) {
                    objRecadoFar = new TelaRecadosFarmacia();
                    jPainelFarmacia.add(objRecadoFar);
                    objRecadoFar.setVisible(true);
                } else {
                    if (objRecadoFar.isVisible()) {
                        if (objRecadoFar.isIcon()) { // Se esta minimizado
                            try {
                                objRecadoFar.setIcon(false); // maximiniza
                            } catch (PropertyVetoException ex) {
                            }
                        } else {
                            objRecadoFar.toFront(); // traz para frente
                            objRecadoFar.pack();//volta frame 
                        }
                    } else {
                        objRecadoFar = new TelaRecadosFarmacia();
                        TelaModuloPortarias.jPainelPortarias.add(objRecadoFar);//adicona frame ao JDesktopPane  
                        objRecadoFar.setVisible(true);
                    }
                }
                try {
                    objRecadoFar.setSelected(true);
                } catch (java.beans.PropertyVetoException e) {
                }
                flag = 1;
                preencherTabelaTodosRecados("SELECT * FROM AGENDARECADOS "
                        + "INNER JOIN USUARIOS "
                        + "ON AGENDARECADOS.IdUsuario=USUARIOS.IdUsuario "
                        + "WHERE NomeUsuario='" + nameUser + "'AND StatusAgenda='" + statusAgenda + "'");
                if (flag == 1) {
                    jBtNovo.setEnabled(true);
                    jBtAlterar.setEnabled(true);
                    jBtExcluir.setEnabled(true);
                    jBtSalvar.setEnabled(!true);
                    jBtCancelar.setEnabled(true);
                    jBtResponder.setEnabled(true);
                    jBtConfirmar.setEnabled(true);
                    conecta.abrirConexao();
                    try {
                        conecta.executaSQL("SELECT * FROM AGENDARECADOS "
                                + "INNER JOIN USUARIOS "
                                + "ON AGENDARECADOS.IdUsuario=USUARIOS.IdUsuario "
                                + "WHERE NomeUsuario='" + nameUser + "'AND StatusAgenda='" + statusAgenda + "'");
                        conecta.rs.last();
                        jIDLanc.setText(String.valueOf(conecta.rs.getInt("IdLanc")));
                        jDataLanc.setDate(conecta.rs.getDate("DataLanc"));
                        jHoraRecado.setText(conecta.rs.getString("Horario"));
                        jComboBoxStatus.setSelectedItem(conecta.rs.getString("StatusAgenda"));
                        jNomeRementente.setText(conecta.rs.getString("NomeUsuarioLogado"));
                        jNomeDestinatario.setText(conecta.rs.getString("NomeUsuario"));
                        jRecado.setText(conecta.rs.getString("Recados"));
                        conecta.desconecta();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados...\nERRO: " + e);
                    }
                    conecta.desconecta();
                }
            }
        } catch (SQLException ex) {
        }
    }

    public void buscarUsuario(String nomeUser) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM USUARIOS WHERE NomeUsuario='" + nomeUser + "'");
            conecta.rs.first();
            codUsuario = conecta.rs.getInt("IdUsuario");
            nomeUsuarioCompromisso = conecta.rs.getString("NomeUsuario");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível encontrar o usuário.\nERRO: " + ex);
        }
    }

    public void preencherTabelaTodosRecados(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{" ID", " Data", " Remetente", " Destinatário"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.last();
            do {
                // Formatar a data Entrada
                dataLanc = conecta.rs.getString("DataLanc");
                String dia = dataLanc.substring(8, 10);
                String mes = dataLanc.substring(5, 7);
                String ano = dataLanc.substring(0, 4);
                dataLanc = dia + "/" + mes + "/" + ano;
                dados.add(new Object[]{conecta.rs.getInt("IdLanc"), dataLanc, conecta.rs.getString("NomeUsuarioLogado"), conecta.rs.getString("NomeUsuario")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe dados a ser exibido!!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaTodosRecados.setModel(modelo);
        jTabelaTodosRecados.getColumnModel().getColumn(0).setPreferredWidth(52);
        jTabelaTodosRecados.getColumnModel().getColumn(0).setResizable(false);
        jTabelaTodosRecados.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTabelaTodosRecados.getColumnModel().getColumn(1).setResizable(false);
        jTabelaTodosRecados.getColumnModel().getColumn(2).setPreferredWidth(280);
        jTabelaTodosRecados.getColumnModel().getColumn(2).setResizable(false);
        jTabelaTodosRecados.getColumnModel().getColumn(3).setPreferredWidth(280);
        jTabelaTodosRecados.getColumnModel().getColumn(3).setResizable(false);
        jTabelaTodosRecados.getTableHeader().setReorderingAllowed(false);
        jTabelaTodosRecados.setAutoResizeMode(jTabelaTodosRecados.AUTO_RESIZE_OFF);
        jTabelaTodosRecados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }

    public void verificarAgendaCompromisso() {
        buscarUsuario(nameUser);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AGENDA_COMPROMISSOS WHERE UsuarioAgenda='" + nameUser + "' "
                    + "AND StatusAgenda='" + statusAgenda + "' "
                    + "AND DataLembrete='" + jDataSistema.getText() + "' "
                    + "AND HoraLembrete<='" + jHoraSistema.getText().toString() + "'");
            conecta.rs.first();
            horaLembrete = conecta.rs.getString("HoraLembrete");
            usuarioAgenda = conecta.rs.getString("UsuarioAgenda");
            codigoAgendaComp = conecta.rs.getString("IdAgenda");
            //
            if (nomeUsuarioCompromisso.equals(usuarioAgenda)) {
                TelaAgendaCompromissos objAgendaComp = new TelaAgendaCompromissos();
                TelaModuloFarmacia.jPainelFarmacia.add(objAgendaComp);
                objAgendaComp.show();
                flag = 1;
                preencherTabelaAgendaCompromisso("SELECT * FROM AGENDA_COMPROMISSOS "
                        + "WHERE AGENDA_COMPROMISSOS.UsuarioAgenda='" + nameUser + "' "
                        + "AND AGENDA_COMPROMISSOS.StatusAgenda='" + statusAgenda + "' "
                        + "AND DataLembrete='" + jDataSistema.getText() + "' "
                        + "AND HoraLembrete<='" + jHoraSistema.getText().toString() + "' "
                        + "AND IdAgenda='" + codigoAgendaComp + "'");
                if (flag == 1) {
                    jBtNovoComp.setEnabled(true);
                    jBtAlterarComp.setEnabled(true);
                    jBtExcluirComp.setEnabled(true);
                    jBtSalvarComp.setEnabled(!true);
                    jBtCancelarComp.setEnabled(true);
                    jBtConfirmarCompromisso.setEnabled(true);
                    conecta.abrirConexao();
                    try {
                        conecta.executaSQL("SELECT * FROM AGENDA_COMPROMISSOS "
                                + "WHERE AGENDA_COMPROMISSOS.UsuarioAgenda='" + nomeUsuarioCompromisso + "'AND AGENDA_COMPROMISSOS.StatusAgenda='" + statusAgenda + "'AND HoraLembrete<='" + jHoraSistema.getText().toString() + "'AND IdAgenda='" + codigoAgendaComp + "'");
                        conecta.rs.first();
                        jCodigoAgendaComp.setText(String.valueOf(conecta.rs.getInt("IdAgenda")));
                        jComboBoxStatusComp.setSelectedItem(conecta.rs.getString("StatusAgenda"));
                        jComboBoxTipoEvento.setSelectedItem(conecta.rs.getString("TipoEvento"));
                        jDataEvento.setDate(conecta.rs.getDate("DataAgenda"));
                        jAssunto.setText(conecta.rs.getString("Assunto"));
                        jComboBoxPrioridade.setSelectedItem(conecta.rs.getString("Prioridade"));
                        jComboBoxConclusao.setSelectedItem(conecta.rs.getString("Conclusao"));
                        jDataInicio.setDate(conecta.rs.getDate("DataInicio"));
                        jDataTermino.setDate(conecta.rs.getDate("DataTermino"));
                        jHoraInicio.setText(conecta.rs.getString("HoraInicio"));
                        jHoraTermino.setText(conecta.rs.getString("HoraTermino"));
                        jDataLembrete.setDate(conecta.rs.getDate("DataLembrete"));
                        jHoraLembrete.setText(conecta.rs.getString("HoraLembrete"));
                        jTextoEvento.setText(conecta.rs.getString("Texto"));
                        jNomeUsuarioAgenda.setText(conecta.rs.getString("UsuarioAgenda"));
                        conecta.desconecta();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(rootPane, "ERRO na pesquisa dos dados...\nERRO: " + e);
                    }
                    conecta.desconecta();
                }
            }
        } catch (SQLException ex) {
        }
    }

    public void preencherTabelaAgendaCompromisso(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código ", "Data", "Status", "Assunto", "Usuário"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL(sql);
            conecta.rs.first();
            do {
                count = count + 1;
                // Formatar a data no formato Brasil
                dataAgenda = conecta.rs.getString("DataAgenda");
                String dia = dataAgenda.substring(8, 10);
                String mes = dataAgenda.substring(5, 7);
                String ano = dataAgenda.substring(0, 4);
                dataAgenda = dia + "/" + mes + "/" + ano;
                jtotalRegistros.setText(Integer.toString(count));
                dados.add(new Object[]{conecta.rs.getInt("IdAgenda"), dataAgenda, conecta.rs.getString("StatusAgenda"), conecta.rs.getString("Assunto"), conecta.rs.getString("UsuarioAgenda")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem dados a serem EXIBIDOS!!!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaAgendaEventos.setModel(modelo);
        jTabelaAgendaEventos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaAgendaEventos.getColumnModel().getColumn(0).setResizable(false);
        jTabelaAgendaEventos.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTabelaAgendaEventos.getColumnModel().getColumn(1).setResizable(false);
        jTabelaAgendaEventos.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTabelaAgendaEventos.getColumnModel().getColumn(2).setResizable(false);
        jTabelaAgendaEventos.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTabelaAgendaEventos.getColumnModel().getColumn(3).setResizable(false);
        jTabelaAgendaEventos.getColumnModel().getColumn(4).setPreferredWidth(300);
        jTabelaAgendaEventos.getColumnModel().getColumn(4).setResizable(false);
        jTabelaAgendaEventos.setAutoResizeMode(jTabelaAgendaEventos.AUTO_RESIZE_OFF);
        jTabelaAgendaEventos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        alinharCamposTabela();
        conecta.desconecta();
    }

    public void alinharCamposTabela() {
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        jTabelaAgendaEventos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaAgendaEventos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        jTabelaAgendaEventos.getColumnModel().getColumn(2).setCellRenderer(centralizado);
    }
}
