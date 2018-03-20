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
import static gestor.Visao.TelaModuloAlmoxarifado.jPainelAlmoxarifado;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static gestor.Visao.TelaRecadosAlmoxarifado.jBtAlterar;
import static gestor.Visao.TelaRecadosAlmoxarifado.jBtCancelar;
import static gestor.Visao.TelaRecadosAlmoxarifado.jBtConfirmar;
import static gestor.Visao.TelaRecadosAlmoxarifado.jBtExcluir;
import static gestor.Visao.TelaRecadosAlmoxarifado.jBtNovo;
import static gestor.Visao.TelaRecadosAlmoxarifado.jBtResponder;
import static gestor.Visao.TelaRecadosAlmoxarifado.jBtSalvar;
import static gestor.Visao.TelaRecadosAlmoxarifado.jComboBoxStatus;
import static gestor.Visao.TelaRecadosAlmoxarifado.jDataLanc;
import static gestor.Visao.TelaRecadosAlmoxarifado.jHoraRecado;
import static gestor.Visao.TelaRecadosAlmoxarifado.jIDLanc;
import static gestor.Visao.TelaRecadosAlmoxarifado.jNomeDestinatario;
import static gestor.Visao.TelaRecadosAlmoxarifado.jNomeRementente;
import static gestor.Visao.TelaRecadosAlmoxarifado.jRecado;
import static gestor.Visao.TelaRecadosAlmoxarifado.jTabelaTodosRecados;
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
public class TelaModuloAlmoxarifado extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    private TelaFornecedorAC objForn = null;
    private TelaGrupoProdutos objGrupoProdutos = null;
    private TelaLocalArmazenamentoAC objLocalAC = null;
    private TelaProdutosAC objProdAC = null;
    private TelaEntradaProdutosAC objNFE = null;
    private TelaInventarioProdutosAC objInvetAC = null;
    private TelaRecadosAlmoxarifado objRecadosAlmox = null;
    private TelaConsultaEstoqueAC objConsEstoqueAC = null;
    private TelaRequisicaoMateriaisInternosAC objReqInter = null;
    private TelaRequisicaoAvulsaAC objReqAvulsa = null;
    private TelaEstornoRequisicaoMateriaisAC objEstRequisicao = null;
    private TelaSolicitacaoComprasMateriaisAC objSolCompMat = null;
    private TelaAgendaCompromissos objAgEventos = null;
    //
    String dataLanc;
    int codUsuario;
    int flag;
    String statusAgenda = "Pendente";
    int tempo = (1000 * 60) * 5;   // 5 min.  
    int periodo = 1;  // quantidade de vezes a ser executado.  
    int count = 0;
    // VARIÁVEIS PARA AGENDA DE COMPROMISSO.
    String dataAgenda;
    String nomeUsuarioCompromisso; // USUÁRIO DA AGENDA DE COMPROMISSO.
    String horaLembrete;
    String usuarioAgenda;
    String codigoAgendaComp;
    //
    String modulo = "A";

    // TelaEntradaProdutos FAZER A MESMA QUE ESTÁ NO MODULO FARMACIA
    /**
     * Creates new form TelaAlmoxarifado
     */
    public TelaModuloAlmoxarifado() {
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

        jPainelAlmoxarifado = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Cadastros = new javax.swing.JMenu();
        Fornecedor = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        LocalArmazenamento = new javax.swing.JMenuItem();
        GrupoProdutos = new javax.swing.JMenuItem();
        Produtos = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        AgendaCompromisso = new javax.swing.JMenuItem();
        AgendaRecados = new javax.swing.JMenuItem();
        Sair = new javax.swing.JMenuItem();
        Movimentacao = new javax.swing.JMenu();
        EntradaMateriais = new javax.swing.JMenuItem();
        InventarioMateriais = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenu4 = new javax.swing.JMenu();
        RequisicaoMateriaisInternos = new javax.swing.JMenuItem();
        RequisicaoMateriaisAvulsa = new javax.swing.JMenuItem();
        EstornoRequisicao = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        SolicitacaoComprasMateriaisInternos = new javax.swing.JMenuItem();
        ConsultaEstoque = new javax.swing.JMenuItem();
        Relatorios = new javax.swing.JMenu();
        RelatorioCadastroProdutos = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        RelatorioProdutosConsumoInternos = new javax.swing.JMenuItem();
        RelatorioConsumoProduto = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        RelatorioProdutosConsumoAvulso = new javax.swing.JMenuItem();
        RelatorioAvulsoPorDepartamento = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        RelatorioEstoqueProdutos = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        RelatorioEntradaInternosUnidade = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("..::: Controle de Materiais {AC} :::...");

        jPainelAlmoxarifado.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/SISCONP 2.gif"))); // NOI18N

        javax.swing.GroupLayout jPainelAlmoxarifadoLayout = new javax.swing.GroupLayout(jPainelAlmoxarifado);
        jPainelAlmoxarifado.setLayout(jPainelAlmoxarifadoLayout);
        jPainelAlmoxarifadoLayout.setHorizontalGroup(
            jPainelAlmoxarifadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        jPainelAlmoxarifadoLayout.setVerticalGroup(
            jPainelAlmoxarifadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelAlmoxarifadoLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
        );
        jPainelAlmoxarifado.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Cadastros.setText("Cadastros");

        Fornecedor.setText("Fornecedor");
        Fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FornecedorActionPerformed(evt);
            }
        });
        Cadastros.add(Fornecedor);
        Cadastros.add(jSeparator1);

        LocalArmazenamento.setText("Local de Armazenamento");
        LocalArmazenamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalArmazenamentoActionPerformed(evt);
            }
        });
        Cadastros.add(LocalArmazenamento);

        GrupoProdutos.setText("Grupos Produtos");
        GrupoProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GrupoProdutosActionPerformed(evt);
            }
        });
        Cadastros.add(GrupoProdutos);

        Produtos.setText("Produtos");
        Produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdutosActionPerformed(evt);
            }
        });
        Cadastros.add(Produtos);
        Cadastros.add(jSeparator2);

        AgendaCompromisso.setText("Agenda de Compromissos Pessoal");
        AgendaCompromisso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaCompromissoActionPerformed(evt);
            }
        });
        Cadastros.add(AgendaCompromisso);

        AgendaRecados.setText("Agenda de Recados");
        AgendaRecados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaRecadosActionPerformed(evt);
            }
        });
        Cadastros.add(AgendaRecados);

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        Cadastros.add(Sair);

        jMenuBar1.add(Cadastros);

        Movimentacao.setText("Movimentação");

        EntradaMateriais.setText("Entrada de Materiais - NFE Compras");
        EntradaMateriais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntradaMateriaisActionPerformed(evt);
            }
        });
        Movimentacao.add(EntradaMateriais);

        InventarioMateriais.setText("Inventário de Materiais");
        InventarioMateriais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventarioMateriaisActionPerformed(evt);
            }
        });
        Movimentacao.add(InventarioMateriais);
        Movimentacao.add(jSeparator6);

        jMenu4.setText("Saída de Materiais");

        RequisicaoMateriaisInternos.setForeground(new java.awt.Color(255, 0, 0));
        RequisicaoMateriaisInternos.setText("(Kit de Internos) - Requisição de Materiais para Internos");
        RequisicaoMateriaisInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequisicaoMateriaisInternosActionPerformed(evt);
            }
        });
        jMenu4.add(RequisicaoMateriaisInternos);

        RequisicaoMateriaisAvulsa.setText("Requisição Avulsa de Materiais");
        RequisicaoMateriaisAvulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequisicaoMateriaisAvulsaActionPerformed(evt);
            }
        });
        jMenu4.add(RequisicaoMateriaisAvulsa);

        EstornoRequisicao.setText("Estorno de Requisição de Materiais");
        EstornoRequisicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstornoRequisicaoActionPerformed(evt);
            }
        });
        jMenu4.add(EstornoRequisicao);

        Movimentacao.add(jMenu4);
        Movimentacao.add(jSeparator7);

        SolicitacaoComprasMateriaisInternos.setText("Solicitação de Compras de Materiais");
        SolicitacaoComprasMateriaisInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolicitacaoComprasMateriaisInternosActionPerformed(evt);
            }
        });
        Movimentacao.add(SolicitacaoComprasMateriaisInternos);

        ConsultaEstoque.setText("Consulta de Estoque");
        ConsultaEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaEstoqueActionPerformed(evt);
            }
        });
        Movimentacao.add(ConsultaEstoque);

        jMenuBar1.add(Movimentacao);

        Relatorios.setText("Relatórios");

        RelatorioCadastroProdutos.setText("Relatórios de Cadastro de Produtos");
        RelatorioCadastroProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioCadastroProdutosActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioCadastroProdutos);
        Relatorios.add(jSeparator3);

        jMenu1.setText("Relatório de Produtos Consumido por Internos");

        RelatorioProdutosConsumoInternos.setText("Relatório de Produtos Consumido por Data");
        RelatorioProdutosConsumoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioProdutosConsumoInternosActionPerformed(evt);
            }
        });
        jMenu1.add(RelatorioProdutosConsumoInternos);

        RelatorioConsumoProduto.setText("Relatório de Consumo por Produto");
        RelatorioConsumoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioConsumoProdutoActionPerformed(evt);
            }
        });
        jMenu1.add(RelatorioConsumoProduto);

        Relatorios.add(jMenu1);
        Relatorios.add(jSeparator4);

        RelatorioProdutosConsumoAvulso.setText("Relatório de Produtos Consumo Aulso");
        RelatorioProdutosConsumoAvulso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioProdutosConsumoAvulsoActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioProdutosConsumoAvulso);

        RelatorioAvulsoPorDepartamento.setText("Relatório de Produtos Consumo Avuslo por Departamento");
        RelatorioAvulsoPorDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioAvulsoPorDepartamentoActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioAvulsoPorDepartamento);
        Relatorios.add(jSeparator5);

        jMenuItem1.setText("Relatório Geral de Estoque de Produtos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Relatorios.add(jMenuItem1);

        RelatorioEstoqueProdutos.setText("Relatório de Estoque de Produtos");
        RelatorioEstoqueProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEstoqueProdutosActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioEstoqueProdutos);
        Relatorios.add(jSeparator8);

        RelatorioEntradaInternosUnidade.setText("Relatório de Entrada de Internos na Unidade");
        RelatorioEntradaInternosUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaInternosUnidadeActionPerformed(evt);
            }
        });
        Relatorios.add(RelatorioEntradaInternosUnidade);

        jMenuBar1.add(Relatorios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelAlmoxarifado)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelAlmoxarifado)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FornecedorActionPerformed
        // TODO add your handling code here:
        if (objForn == null || objForn.isClosed()) {
            objForn = new TelaFornecedorAC();
            jPainelAlmoxarifado.add(objForn);
            objForn.setVisible(true);
        } else {
            if (objForn.isVisible()) {
                if (objForn.isIcon()) { // Se esta minimizado
                    try {
                        objForn.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objForn.toFront(); // traz para frente
                    objForn.pack();//volta frame 
                }
            } else {
                objForn = new TelaFornecedorAC();
                TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objForn);//adicona frame ao JDesktopPane  
                objForn.setVisible(true);
            }
        }
        try {
            objForn.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_FornecedorActionPerformed

    private void GrupoProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrupoProdutosActionPerformed
        // TODO add your handling code here:
        if (objGrupoProdutos == null || objGrupoProdutos.isClosed()) {
            objGrupoProdutos = new TelaGrupoProdutos();
            jPainelAlmoxarifado.add(objGrupoProdutos);
            objGrupoProdutos.setVisible(true);
        } else {
            if (objGrupoProdutos.isVisible()) {
                if (objGrupoProdutos.isIcon()) { // Se esta minimizado
                    try {
                        objGrupoProdutos.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objGrupoProdutos.toFront(); // traz para frente
                    objGrupoProdutos.pack();//volta frame 
                }
            } else {
                objGrupoProdutos = new TelaGrupoProdutos();
                TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objGrupoProdutos);//adicona frame ao JDesktopPane  
                objGrupoProdutos.setVisible(true);
            }
        }
        try {
            objGrupoProdutos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_GrupoProdutosActionPerformed

    private void LocalArmazenamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalArmazenamentoActionPerformed
        // TODO add your handling code here:
        if (objLocalAC == null || objLocalAC.isClosed()) {
            objLocalAC = new TelaLocalArmazenamentoAC();
            jPainelAlmoxarifado.add(objLocalAC);
            objLocalAC.setVisible(true);
        } else {
            if (objLocalAC.isVisible()) {
                if (objLocalAC.isIcon()) { // Se esta minimizado
                    try {
                        objLocalAC.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objLocalAC.toFront(); // traz para frente
                    objLocalAC.pack();//volta frame 
                }
            } else {
                objLocalAC = new TelaLocalArmazenamentoAC();
                TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objLocalAC);//adicona frame ao JDesktopPane  
                objLocalAC.setVisible(true);
            }
        }
        try {
            objLocalAC.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_LocalArmazenamentoActionPerformed

    private void ProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdutosActionPerformed
        // TODO add your handling code here:
        if (objProdAC == null || objProdAC.isClosed()) {
            objProdAC = new TelaProdutosAC();
            jPainelAlmoxarifado.add(objProdAC);
            objProdAC.setVisible(true);
        } else {
            if (objProdAC.isVisible()) {
                if (objProdAC.isIcon()) { // Se esta minimizado
                    try {
                        objProdAC.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objProdAC.toFront(); // traz para frente
                    objProdAC.pack();//volta frame 
                }
            } else {
                objProdAC = new TelaProdutosAC();
                TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objProdAC);//adicona frame ao JDesktopPane  
                objProdAC.setVisible(true);
            }
        }
        try {
            objProdAC.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ProdutosActionPerformed

    private void AgendaRecadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaRecadosActionPerformed
        // TODO add your handling code here:
        if (objRecadosAlmox == null || objRecadosAlmox.isClosed()) {
            objRecadosAlmox = new TelaRecadosAlmoxarifado();
            jPainelAlmoxarifado.add(objRecadosAlmox);
            objRecadosAlmox.setVisible(true);
        } else {
            if (objRecadosAlmox.isVisible()) {
                if (objRecadosAlmox.isIcon()) { // Se esta minimizado
                    try {
                        objRecadosAlmox.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRecadosAlmox.toFront(); // traz para frente
                    objRecadosAlmox.pack();//volta frame 
                }
            } else {
                objRecadosAlmox = new TelaRecadosAlmoxarifado();
                TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objRecadosAlmox);//adicona frame ao JDesktopPane  
                objRecadosAlmox.setVisible(true);
            }
        }
        try {
            objRecadosAlmox.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaRecadosActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_SairActionPerformed

    private void EntradaMateriaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradaMateriaisActionPerformed
        // TODO add your handling code here:
        if (objNFE == null || objNFE.isClosed()) {
            objNFE = new TelaEntradaProdutosAC();
            jPainelAlmoxarifado.add(objNFE);
            objNFE.setVisible(true);
        } else {
            if (objNFE.isVisible()) {
                if (objNFE.isIcon()) { // Se esta minimizado
                    try {
                        objNFE.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objNFE.toFront(); // traz para frente
                    objNFE.pack();//volta frame 
                }
            } else {
                objNFE = new TelaEntradaProdutosAC();
                TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objNFE);//adicona frame ao JDesktopPane  
                objNFE.setVisible(true);
            }
        }
        try {
            objNFE.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_EntradaMateriaisActionPerformed

    private void InventarioMateriaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventarioMateriaisActionPerformed
        // TODO add your handling code here:
        if (objInvetAC == null || objInvetAC.isClosed()) {
            objInvetAC = new TelaInventarioProdutosAC();
            jPainelAlmoxarifado.add(objInvetAC);
            objInvetAC.setVisible(true);
        } else {
            if (objInvetAC.isVisible()) {
                if (objInvetAC.isIcon()) { // Se esta minimizado
                    try {
                        objInvetAC.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objInvetAC.toFront(); // traz para frente
                    objInvetAC.pack();//volta frame 
                }
            } else {
                objInvetAC = new TelaInventarioProdutosAC();
                TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objInvetAC);//adicona frame ao JDesktopPane  
                objInvetAC.setVisible(true);
            }
        }
        try {
            objInvetAC.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_InventarioMateriaisActionPerformed

    private void RequisicaoMateriaisAvulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequisicaoMateriaisAvulsaActionPerformed
        // TODO add your handling code here:
        if (objReqAvulsa == null || objReqAvulsa.isClosed()) {
            objReqAvulsa = new TelaRequisicaoAvulsaAC();
            jPainelAlmoxarifado.add(objReqAvulsa);
            objReqAvulsa.setVisible(true);
        } else {
            if (objReqAvulsa.isVisible()) {
                if (objReqAvulsa.isIcon()) { // Se esta minimizado
                    try {
                        objReqAvulsa.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objReqAvulsa.toFront(); // traz para frente
                    objReqAvulsa.pack();//volta frame 
                }
            } else {
                objReqAvulsa = new TelaRequisicaoAvulsaAC();
                TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objReqAvulsa);//adicona frame ao JDesktopPane  
                objReqAvulsa.setVisible(true);
            }
        }
        try {
            objReqAvulsa.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_RequisicaoMateriaisAvulsaActionPerformed

    private void RequisicaoMateriaisInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequisicaoMateriaisInternosActionPerformed
        // TODO add your handling code here:
        if (objReqInter == null || objReqInter.isClosed()) {
            objReqInter = new TelaRequisicaoMateriaisInternosAC();
            jPainelAlmoxarifado.add(objReqInter);
            objReqInter.setVisible(true);
        } else {
            if (objReqInter.isVisible()) {
                if (objReqInter.isIcon()) { // Se esta minimizado
                    try {
                        objReqInter.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objReqInter.toFront(); // traz para frente
                    objReqInter.pack();//volta frame 
                }
            } else {
                objReqInter = new TelaRequisicaoMateriaisInternosAC();
                TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objReqInter);//adicona frame ao JDesktopPane  
                objReqInter.setVisible(true);
            }
        }
        try {
            objReqInter.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_RequisicaoMateriaisInternosActionPerformed

    private void EstornoRequisicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstornoRequisicaoActionPerformed
        // TODO add your handling code here:
        if (objEstRequisicao == null || objEstRequisicao.isClosed()) {
            objEstRequisicao = new TelaEstornoRequisicaoMateriaisAC();
            jPainelAlmoxarifado.add(objEstRequisicao);
            objEstRequisicao.setVisible(true);
        } else {
            if (objEstRequisicao.isVisible()) {
                if (objEstRequisicao.isIcon()) { // Se esta minimizado
                    try {
                        objEstRequisicao.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objEstRequisicao.toFront(); // traz para frente
                    objEstRequisicao.pack();//volta frame 
                }
            } else {
                objEstRequisicao = new TelaEstornoRequisicaoMateriaisAC();
                TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objEstRequisicao);//adicona frame ao JDesktopPane  
                objEstRequisicao.setVisible(true);
            }
        }
        try {
            objEstRequisicao.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_EstornoRequisicaoActionPerformed

    private void ConsultaEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaEstoqueActionPerformed
        // TODO add your handling code here:
        if (objConsEstoqueAC == null || objConsEstoqueAC.isClosed()) {
            objConsEstoqueAC = new TelaConsultaEstoqueAC();
            jPainelAlmoxarifado.add(objConsEstoqueAC);
            objConsEstoqueAC.setVisible(true);
        } else {
            if (objConsEstoqueAC.isVisible()) {
                if (objConsEstoqueAC.isIcon()) { // Se esta minimizado
                    try {
                        objConsEstoqueAC.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConsEstoqueAC.toFront(); // traz para frente
                    objConsEstoqueAC.pack();//volta frame 
                }
            } else {
                objConsEstoqueAC = new TelaConsultaEstoqueAC();
                TelaModuloPortarias.jPainelPortarias.add(objConsEstoqueAC);//adicona frame ao JDesktopPane  
                objConsEstoqueAC.setVisible(true);
            }
        }
        try {
            objConsEstoqueAC.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ConsultaEstoqueActionPerformed

    private void RelatorioCadastroProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioCadastroProdutosActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioProdutosCadastradosPorGrupo.jasper";
            conecta.executaSQL("SELECT * FROM PRODUTOS_AC "
                    + "INNER JOIN GRUPO_PRODUTOS_AC "
                    + "ON PRODUTOS_AC.IdGrupo=GRUPO_PRODUTOS_AC.IdGrupo "
                    + "ORDER BY GRUPO_PRODUTOS_AC.NomeGrupo,PRODUTOS_AC.DescricaoProd");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
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

    private void SolicitacaoComprasMateriaisInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolicitacaoComprasMateriaisInternosActionPerformed
        // TODO add your handling code here:
        if (objSolCompMat == null || objSolCompMat.isClosed()) {
            objSolCompMat = new TelaSolicitacaoComprasMateriaisAC();
            jPainelAlmoxarifado.add(objSolCompMat);
            objSolCompMat.setVisible(true);
        } else {
            if (objSolCompMat.isVisible()) {
                if (objSolCompMat.isIcon()) { // Se esta minimizado
                    try {
                        objSolCompMat.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objSolCompMat.toFront(); // traz para frente
                    objSolCompMat.pack();//volta frame 
                }
            } else {
                objSolCompMat = new TelaSolicitacaoComprasMateriaisAC();
                TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objSolCompMat);//adicona frame ao JDesktopPane  
                objSolCompMat.setVisible(true);
            }
        }
        try {
            objSolCompMat.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_SolicitacaoComprasMateriaisInternosActionPerformed

    private void RelatorioProdutosConsumoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioProdutosConsumoInternosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConsumoProdutosInternoPorData objPesqConsuProdData = new TelaRelatorioConsumoProdutosInternoPorData();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objPesqConsuProdData);
        objPesqConsuProdData.show();
    }//GEN-LAST:event_RelatorioProdutosConsumoInternosActionPerformed

    private void RelatorioConsumoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioConsumoProdutoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConsumoProdutosInterno objPesqConsuProd = new TelaRelatorioConsumoProdutosInterno();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objPesqConsuProd);
        objPesqConsuProd.show();
    }//GEN-LAST:event_RelatorioConsumoProdutoActionPerformed

    private void RelatorioProdutosConsumoAvulsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioProdutosConsumoAvulsoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConsumoProdutosAvulso objRelConsuProdAvul = new TelaRelatorioConsumoProdutosAvulso();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objRelConsuProdAvul);
        objRelConsuProdAvul.show();
    }//GEN-LAST:event_RelatorioProdutosConsumoAvulsoActionPerformed

    private void RelatorioEstoqueProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEstoqueProdutosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEstoqueProdutosAC objRelEstProd = new TelaRelatorioEstoqueProdutosAC();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objRelEstProd);
        objRelEstProd.show();
    }//GEN-LAST:event_RelatorioEstoqueProdutosActionPerformed

    private void RelatorioAvulsoPorDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioAvulsoPorDepartamentoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConsumoProdutosAvulsoDepartamento objRelConsProdAvDepto = new TelaRelatorioConsumoProdutosAvulsoDepartamento();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objRelConsProdAvDepto);
        objRelConsProdAvDepto.show();
    }//GEN-LAST:event_RelatorioAvulsoPorDepartamentoActionPerformed

    private void AgendaCompromissoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaCompromissoActionPerformed
        // TODO add your handling code here:
        if (objAgEventos == null || objAgEventos.isClosed()) {
            objAgEventos = new TelaAgendaCompromissos();
            jPainelAlmoxarifado.add(objAgEventos);
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
                TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objAgEventos);//adicona frame ao JDesktopPane  
                objAgEventos.setVisible(true);
            }
        }
        try {
            objAgEventos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaCompromissoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
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
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void RelatorioEntradaInternosUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaInternosUnidadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradas objRelEntradaInter = new TelaRelatorioEntradas();
        TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objRelEntradaInter);
        objRelEntradaInter.show();
    }//GEN-LAST:event_RelatorioEntradaInternosUnidadeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgendaCompromisso;
    private javax.swing.JMenuItem AgendaRecados;
    private javax.swing.JMenu Cadastros;
    private javax.swing.JMenuItem ConsultaEstoque;
    private javax.swing.JMenuItem EntradaMateriais;
    private javax.swing.JMenuItem EstornoRequisicao;
    private javax.swing.JMenuItem Fornecedor;
    private javax.swing.JMenuItem GrupoProdutos;
    private javax.swing.JMenuItem InventarioMateriais;
    private javax.swing.JMenuItem LocalArmazenamento;
    private javax.swing.JMenu Movimentacao;
    private javax.swing.JMenuItem Produtos;
    private javax.swing.JMenuItem RelatorioAvulsoPorDepartamento;
    private javax.swing.JMenuItem RelatorioCadastroProdutos;
    private javax.swing.JMenuItem RelatorioConsumoProduto;
    private javax.swing.JMenuItem RelatorioEntradaInternosUnidade;
    private javax.swing.JMenuItem RelatorioEstoqueProdutos;
    private javax.swing.JMenuItem RelatorioProdutosConsumoAvulso;
    private javax.swing.JMenuItem RelatorioProdutosConsumoInternos;
    private javax.swing.JMenu Relatorios;
    private javax.swing.JMenuItem RequisicaoMateriaisAvulsa;
    private javax.swing.JMenuItem RequisicaoMateriaisInternos;
    private javax.swing.JMenuItem Sair;
    private javax.swing.JMenuItem SolicitacaoComprasMateriaisInternos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JDesktopPane jPainelAlmoxarifado;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
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
                if (objRecadosAlmox == null || objRecadosAlmox.isClosed()) {
                    objRecadosAlmox = new TelaRecadosAlmoxarifado();
                    jPainelAlmoxarifado.add(objRecadosAlmox);
                    objRecadosAlmox.setVisible(true);
                } else {
                    if (objRecadosAlmox.isVisible()) {
                        if (objRecadosAlmox.isIcon()) { // Se esta minimizado
                            try {
                                objRecadosAlmox.setIcon(false); // maximiniza
                            } catch (PropertyVetoException ex) {
                            }
                        } else {
                            objRecadosAlmox.toFront(); // traz para frente
                            objRecadosAlmox.pack();//volta frame 
                        }
                    } else {
                        objRecadosAlmox = new TelaRecadosAlmoxarifado();
                        TelaModuloPortarias.jPainelPortarias.add(objRecadosAlmox);//adicona frame ao JDesktopPane  
                        objRecadosAlmox.setVisible(true);
                    }
                }
                try {
                    objRecadosAlmox.setSelected(true);
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
                TelaModuloAlmoxarifado.jPainelAlmoxarifado.add(objAgendaComp);
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
