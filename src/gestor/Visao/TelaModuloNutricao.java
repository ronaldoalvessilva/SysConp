/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.converterDataStringDataDate;
import static gestor.Controle.converterDataStringDataDate.dataSisConvert;
import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
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
import static gestor.Visao.TelaModuloPrincipal.tipoServidor;
import static gestor.Visao.TelaRecadosCrc.jBtAlterar;
import static gestor.Visao.TelaRecadosCrc.jBtCancelar;
import static gestor.Visao.TelaRecadosCrc.jBtConfirmar;
import static gestor.Visao.TelaRecadosCrc.jBtExcluir;
import static gestor.Visao.TelaRecadosCrc.jBtNovo;
import static gestor.Visao.TelaRecadosCrc.jBtResponder;
import static gestor.Visao.TelaRecadosCrc.jBtSalvar;
import static gestor.Visao.TelaRecadosCrc.jComboBoxStatus;
import static gestor.Visao.TelaRecadosCrc.jDataLanc;
import static gestor.Visao.TelaRecadosCrc.jHoraRecado;
import static gestor.Visao.TelaRecadosCrc.jIDLanc;
import static gestor.Visao.TelaRecadosCrc.jNomeDestinatario;
import static gestor.Visao.TelaRecadosCrc.jNomeRementente;
import static gestor.Visao.TelaRecadosCrc.jRecado;
import static gestor.Visao.TelaRecadosCrc.jTabelaTodosRecados;
import java.beans.PropertyVetoException;
import java.io.IOException;
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
 * @author user
 */
public class TelaModuloNutricao extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    converterDataStringDataDate convertedata = new converterDataStringDataDate();
    //    
    private TelaRecadosNutricao objRecadosNUTRI = null;
    private TelaFornecedorCOMPRASNUTRI objForCOMPRASNUTRI = null;
    private TelaGrupoProdutosNUTRI objGrupoProdutosNUTRI = null;
    private TelaLocalArmazenamentoNUTRI objLocalNUTRI = null;
    private TelaProdutosNUTRI objProdNUTRI = null;
    private TelaCategoriasReceitas objCategoria = null;
    private TelaFichaTecnica objFichaTecnica = null;
    private TelaEntradaProdutosNUTRI objNFE = null;
    private TelaInventarioProdutosNUTRI objInvetNUTRI = null;
    private TelaConsultaEstoqueNUTRI objConsEstoqueNUTRI = null;
    private TelaRequisicaoMateriaisNUTRI objReqNUTRI = null;
    private TelaRequisicaoAvulsaNUTRI objReqAvulsaNUTRI = null;
    private TelaEstornoRequisicaoMateriaisNUTRI objEstRequisicaoNUTRI = null;
    private TelaSolicitacaoComprasMateriaisNUTRI objSolCompMatNUTRI = null;
    private TelaRequisicaoMateriaisCardapioNUTRI objReqCardapio = null;
    private TelaAgendaCompromissos objAgEventos = null;
    //
    String dataLanc;
    int codUsuario;
    int flag;
    String statusAgenda = "Pendente";
    String situacaoEnt = "ENTRADA NA UNIDADE"; // Todas as Entradas
    String situacaoRet = "RETORNO A UNIDADE"; // Todos os Retornos
    //
    int tempo = (1000 * 60) * 5;   // 5 min.  
    int periodo = 1;  // quantidade de vezes a ser executado. 
    String tipoEmpresa = "Interna";
    String statusInterno = "Ativo";
    String modulo = "N";
    int count = 0;
    // VARIÁVEIS PARA AGENDA DE COMPROMISSO.
    String dataAgenda;
    String nomeUsuarioCompromisso; // USUÁRIO DA AGENDA DE COMPROMISSO.
    String horaLembrete;
    String usuarioAgenda;
    String codigoAgendaComp;

    /**
     * Creates new form TelaDiretoria
     */
    public TelaModuloNutricao() {
        initComponents();
        threadMensagem(); // A cada 5 minutos verifica mensagem 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPainelNutricao = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jCadastros = new javax.swing.JMenu();
        FornecedoresCompras = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        GrupoProdutos = new javax.swing.JMenuItem();
        LocaisArmazenamento = new javax.swing.JMenuItem();
        Produtos = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        TiposReceitas = new javax.swing.JMenuItem();
        Receitas = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        AgendaCompromissos = new javax.swing.JMenuItem();
        AgendaRecados = new javax.swing.JMenuItem();
        jSair = new javax.swing.JMenuItem();
        Movimentacao = new javax.swing.JMenu();
        ComprasMercadorias = new javax.swing.JMenuItem();
        InventarioEstoque = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu1 = new javax.swing.JMenu();
        RequisicaoMateriais = new javax.swing.JMenuItem();
        RequisicaoMateriaisCardapio = new javax.swing.JMenuItem();
        RequisicaoMateriaisAvulsa = new javax.swing.JMenuItem();
        EstornoRequisicao = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        SolicitacaoCompras = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jRelatorios = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        RelatorioCadastroProdutos = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        RelatorioProdutosConsumoInternos = new javax.swing.JMenuItem();
        RelatorioConsumoProduto = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        RelatorioProdutosConsumoAvulso = new javax.swing.JMenuItem();
        RelatorioEstoqueProdutos = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenu7 = new javax.swing.JMenu();
        RelatorioGeralPavilhaoCelas = new javax.swing.JMenuItem();
        ListagemConfere = new javax.swing.JMenuItem();
        MapaConfere = new javax.swing.JMenuItem();
        RelatorioListasPassagens = new javax.swing.JMenu();
        ListaPassagemInterna = new javax.swing.JMenuItem();
        ListaPassagemExterna = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        RelatorioEntradaInternosUnidade = new javax.swing.JMenuItem();
        Utilitarios = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Controle de Refeitorio :::...");
        setToolTipText("");

        jPainelNutricao.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/BrasaoFundo500Prata2.png"))); // NOI18N

        jPainelNutricao.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelNutricaoLayout = new javax.swing.GroupLayout(jPainelNutricao);
        jPainelNutricao.setLayout(jPainelNutricaoLayout);
        jPainelNutricaoLayout.setHorizontalGroup(
            jPainelNutricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE)
        );
        jPainelNutricaoLayout.setVerticalGroup(
            jPainelNutricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );

        jCadastros.setText("Cadastros");

        FornecedoresCompras.setText("Fornecedores");
        FornecedoresCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FornecedoresComprasActionPerformed(evt);
            }
        });
        jCadastros.add(FornecedoresCompras);
        jCadastros.add(jSeparator4);

        GrupoProdutos.setText("Grupo de Produtos");
        GrupoProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GrupoProdutosActionPerformed(evt);
            }
        });
        jCadastros.add(GrupoProdutos);

        LocaisArmazenamento.setText("Locais de Armazenamentos");
        LocaisArmazenamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocaisArmazenamentoActionPerformed(evt);
            }
        });
        jCadastros.add(LocaisArmazenamento);

        Produtos.setText("Produtos");
        Produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdutosActionPerformed(evt);
            }
        });
        jCadastros.add(Produtos);
        jCadastros.add(jSeparator1);

        TiposReceitas.setText("Categorias - Tipos de Receitas");
        TiposReceitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TiposReceitasActionPerformed(evt);
            }
        });
        jCadastros.add(TiposReceitas);

        Receitas.setText("Ficha Técnica de Trabalho - Receitas");
        Receitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReceitasActionPerformed(evt);
            }
        });
        jCadastros.add(Receitas);
        jCadastros.add(jSeparator5);

        AgendaCompromissos.setText("Agenda de Compromissos Pessoal");
        AgendaCompromissos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaCompromissosActionPerformed(evt);
            }
        });
        jCadastros.add(AgendaCompromissos);

        AgendaRecados.setText("Agenda de Recados");
        AgendaRecados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaRecadosActionPerformed(evt);
            }
        });
        jCadastros.add(AgendaRecados);

        jSair.setText("Sair");
        jSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSairActionPerformed(evt);
            }
        });
        jCadastros.add(jSair);

        jMenuBar1.add(jCadastros);

        Movimentacao.setText("Movimentação");

        ComprasMercadorias.setText("Entrada de Materiais - NFE Compras");
        ComprasMercadorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprasMercadoriasActionPerformed(evt);
            }
        });
        Movimentacao.add(ComprasMercadorias);

        InventarioEstoque.setText("Inventário de Materiais");
        InventarioEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventarioEstoqueActionPerformed(evt);
            }
        });
        Movimentacao.add(InventarioEstoque);
        Movimentacao.add(jSeparator2);

        jMenu1.setText("Saída de Materiais");

        RequisicaoMateriais.setText("Requisição de Materiais para Internos");
        RequisicaoMateriais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequisicaoMateriaisActionPerformed(evt);
            }
        });
        jMenu1.add(RequisicaoMateriais);

        RequisicaoMateriaisCardapio.setForeground(new java.awt.Color(0, 0, 255));
        RequisicaoMateriaisCardapio.setText("Requisição de Materiais para Cardápio");
        RequisicaoMateriaisCardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequisicaoMateriaisCardapioActionPerformed(evt);
            }
        });
        jMenu1.add(RequisicaoMateriaisCardapio);

        RequisicaoMateriaisAvulsa.setText("Requisição Avulsa de Materiais");
        RequisicaoMateriaisAvulsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequisicaoMateriaisAvulsaActionPerformed(evt);
            }
        });
        jMenu1.add(RequisicaoMateriaisAvulsa);

        EstornoRequisicao.setText("Estorno de Requisição de Materiais");
        EstornoRequisicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstornoRequisicaoActionPerformed(evt);
            }
        });
        jMenu1.add(EstornoRequisicao);

        Movimentacao.add(jMenu1);
        Movimentacao.add(jSeparator3);

        SolicitacaoCompras.setText("Solicitação de Compras Produtos");
        SolicitacaoCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolicitacaoComprasActionPerformed(evt);
            }
        });
        Movimentacao.add(SolicitacaoCompras);

        jMenuItem9.setText("Consulta de Estoque");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        Movimentacao.add(jMenuItem9);

        jMenuBar1.add(Movimentacao);

        jRelatorios.setText("Relatórios");

        jMenuItem7.setText("Relatório de População de Internos ");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jRelatorios.add(jMenuItem7);

        RelatorioCadastroProdutos.setText("Relatórios de Cadastro de Produtos");
        RelatorioCadastroProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioCadastroProdutosActionPerformed(evt);
            }
        });
        jRelatorios.add(RelatorioCadastroProdutos);
        jRelatorios.add(jSeparator7);

        jMenu2.setText("Relatório de Produtos Consumido por Internos");

        RelatorioProdutosConsumoInternos.setText("Relatório de Produtos Consumido por Data");
        RelatorioProdutosConsumoInternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioProdutosConsumoInternosActionPerformed(evt);
            }
        });
        jMenu2.add(RelatorioProdutosConsumoInternos);

        RelatorioConsumoProduto.setText("Relatório de Consumo por Produto");
        RelatorioConsumoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioConsumoProdutoActionPerformed(evt);
            }
        });
        jMenu2.add(RelatorioConsumoProduto);

        jRelatorios.add(jMenu2);
        jRelatorios.add(jSeparator8);

        RelatorioProdutosConsumoAvulso.setText("Relatório de Produtos Consumo Avulso");
        RelatorioProdutosConsumoAvulso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioProdutosConsumoAvulsoActionPerformed(evt);
            }
        });
        jRelatorios.add(RelatorioProdutosConsumoAvulso);

        RelatorioEstoqueProdutos.setText("Relatório de Estoque de Produtos");
        RelatorioEstoqueProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEstoqueProdutosActionPerformed(evt);
            }
        });
        jRelatorios.add(RelatorioEstoqueProdutos);
        jRelatorios.add(jSeparator6);

        jMenu7.setText("Relatórios de Confere");

        RelatorioGeralPavilhaoCelas.setText("Relatório Geral de Internos no Pavilhão/Celas");
        RelatorioGeralPavilhaoCelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioGeralPavilhaoCelasActionPerformed(evt);
            }
        });
        jMenu7.add(RelatorioGeralPavilhaoCelas);

        ListagemConfere.setText("Listagem de Confere");
        ListagemConfere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListagemConfereActionPerformed(evt);
            }
        });
        jMenu7.add(ListagemConfere);

        MapaConfere.setText("Mapa de Confere");
        MapaConfere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MapaConfereActionPerformed(evt);
            }
        });
        jMenu7.add(MapaConfere);

        jRelatorios.add(jMenu7);

        RelatorioListasPassagens.setText("Relatório de Listas de Passagem");

        ListaPassagemInterna.setText("Relatório de Lista de Passagem Interna");
        ListaPassagemInterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaPassagemInternaActionPerformed(evt);
            }
        });
        RelatorioListasPassagens.add(ListaPassagemInterna);

        ListaPassagemExterna.setText("Relatório de Lista de Passagem Externa");
        ListaPassagemExterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaPassagemExternaActionPerformed(evt);
            }
        });
        RelatorioListasPassagens.add(ListaPassagemExterna);

        jRelatorios.add(RelatorioListasPassagens);
        jRelatorios.add(jSeparator9);

        RelatorioEntradaInternosUnidade.setText("Relatório de Entrada de Internos na Unidade");
        RelatorioEntradaInternosUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradaInternosUnidadeActionPerformed(evt);
            }
        });
        jRelatorios.add(RelatorioEntradaInternosUnidade);

        jMenuBar1.add(jRelatorios);

        Utilitarios.setText("Utilitários");

        jMenuItem13.setText("Calculador do Windows");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        Utilitarios.add(jMenuItem13);

        jMenuBar1.add(Utilitarios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelNutricao)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelNutricao, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jSairActionPerformed

    private void AgendaRecadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaRecadosActionPerformed
        // TODO add your handling code here:
        if (objRecadosNUTRI == null || objRecadosNUTRI.isClosed()) {
            objRecadosNUTRI = new TelaRecadosNutricao();
            jPainelNutricao.add(objRecadosNUTRI);
            objRecadosNUTRI.setVisible(true);
        } else {
            if (objRecadosNUTRI.isVisible()) {
                if (objRecadosNUTRI.isIcon()) { // Se esta minimizado
                    try {
                        objRecadosNUTRI.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRecadosNUTRI.toFront(); // traz para frente
                    objRecadosNUTRI.pack();//volta frame 
                }
            } else {
                objRecadosNUTRI = new TelaRecadosNutricao();
                TelaModuloNutricao.jPainelNutricao.add(objRecadosNUTRI);//adicona frame ao JDesktopPane  
                objRecadosNUTRI.setVisible(true);
            }
        }
        try {
            objRecadosNUTRI.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaRecadosActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        CalcWindows();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void FornecedoresComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FornecedoresComprasActionPerformed
        // TODO add your handling code here:      
        if (objForCOMPRASNUTRI == null || objForCOMPRASNUTRI.isClosed()) {
            objForCOMPRASNUTRI = new TelaFornecedorCOMPRASNUTRI();
            jPainelNutricao.add(objForCOMPRASNUTRI);
            objForCOMPRASNUTRI.setVisible(true);
        } else {
            if (objForCOMPRASNUTRI.isVisible()) {
                if (objForCOMPRASNUTRI.isIcon()) { // Se esta minimizado
                    try {
                        objForCOMPRASNUTRI.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objForCOMPRASNUTRI.toFront(); // traz para frente
                    objForCOMPRASNUTRI.pack();//volta frame 
                }
            } else {
                objForCOMPRASNUTRI = new TelaFornecedorCOMPRASNUTRI();
                TelaModuloNutricao.jPainelNutricao.add(objForCOMPRASNUTRI);//adicona frame ao JDesktopPane  
                objForCOMPRASNUTRI.setVisible(true);
            }
        }
        try {
            objForCOMPRASNUTRI.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
        // TelaFornecedorCOMPRASNUTRI objForCOMPRAS
    }//GEN-LAST:event_FornecedoresComprasActionPerformed

    private void GrupoProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrupoProdutosActionPerformed
        // TODO add your handling code here:
        if (objGrupoProdutosNUTRI == null || objGrupoProdutosNUTRI.isClosed()) {
            objGrupoProdutosNUTRI = new TelaGrupoProdutosNUTRI();
            jPainelNutricao.add(objGrupoProdutosNUTRI);
            objGrupoProdutosNUTRI.setVisible(true);
        } else {
            if (objGrupoProdutosNUTRI.isVisible()) {
                if (objGrupoProdutosNUTRI.isIcon()) { // Se esta minimizado
                    try {
                        objGrupoProdutosNUTRI.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objGrupoProdutosNUTRI.toFront(); // traz para frente
                    objGrupoProdutosNUTRI.pack();//volta frame 
                }
            } else {
                objGrupoProdutosNUTRI = new TelaGrupoProdutosNUTRI();
                TelaModuloNutricao.jPainelNutricao.add(objGrupoProdutosNUTRI);//adicona frame ao JDesktopPane  
                objGrupoProdutosNUTRI.setVisible(true);
            }
        }
        try {
            objGrupoProdutosNUTRI.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_GrupoProdutosActionPerformed

    private void LocaisArmazenamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocaisArmazenamentoActionPerformed
        // TODO add your handling code here:
        if (objLocalNUTRI == null || objLocalNUTRI.isClosed()) {
            objLocalNUTRI = new TelaLocalArmazenamentoNUTRI();
            jPainelNutricao.add(objLocalNUTRI);
            objLocalNUTRI.setVisible(true);
        } else {
            if (objLocalNUTRI.isVisible()) {
                if (objLocalNUTRI.isIcon()) { // Se esta minimizado
                    try {
                        objLocalNUTRI.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objLocalNUTRI.toFront(); // traz para frente
                    objLocalNUTRI.pack();//volta frame 
                }
            } else {
                objLocalNUTRI = new TelaLocalArmazenamentoNUTRI();
                TelaModuloNutricao.jPainelNutricao.add(objLocalNUTRI);//adicona frame ao JDesktopPane  
                objLocalNUTRI.setVisible(true);
            }
        }
        try {
            objLocalNUTRI.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_LocaisArmazenamentoActionPerformed

    private void ProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdutosActionPerformed
        // TODO add your handling code here:
        if (objProdNUTRI == null || objProdNUTRI.isClosed()) {
            objProdNUTRI = new TelaProdutosNUTRI();
            jPainelNutricao.add(objProdNUTRI);
            objProdNUTRI.setVisible(true);
        } else {
            if (objProdNUTRI.isVisible()) {
                if (objProdNUTRI.isIcon()) { // Se esta minimizado
                    try {
                        objProdNUTRI.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objProdNUTRI.toFront(); // traz para frente
                    objProdNUTRI.pack();//volta frame 
                }
            } else {
                objProdNUTRI = new TelaProdutosNUTRI();
                TelaModuloNutricao.jPainelNutricao.add(objProdNUTRI);//adicona frame ao JDesktopPane  
                objProdNUTRI.setVisible(true);
            }
        }
        try {
            objProdNUTRI.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ProdutosActionPerformed

    private void TiposReceitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TiposReceitasActionPerformed
        // TODO add your handling code here:
        if (objCategoria == null || objCategoria.isClosed()) {
            objCategoria = new TelaCategoriasReceitas();
            jPainelNutricao.add(objCategoria);
            objCategoria.setVisible(true);
        } else {
            if (objCategoria.isVisible()) {
                if (objCategoria.isIcon()) { // Se esta minimizado
                    try {
                        objCategoria.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objCategoria.toFront(); // traz para frente
                    objCategoria.pack();//volta frame 
                }
            } else {
                objCategoria = new TelaCategoriasReceitas();
                TelaModuloNutricao.jPainelNutricao.add(objCategoria);//adicona frame ao JDesktopPane  
                objCategoria.setVisible(true);
            }
        }
        try {
            objCategoria.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_TiposReceitasActionPerformed

    private void ReceitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReceitasActionPerformed
        // TODO add your handling code here:
        if (objFichaTecnica == null || objFichaTecnica.isClosed()) {
            objFichaTecnica = new TelaFichaTecnica();
            jPainelNutricao.add(objFichaTecnica);
            objFichaTecnica.setVisible(true);
        } else {
            if (objFichaTecnica.isVisible()) {
                if (objFichaTecnica.isIcon()) { // Se esta minimizado
                    try {
                        objFichaTecnica.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objFichaTecnica.toFront(); // traz para frente
                    objFichaTecnica.pack();//volta frame 
                }
            } else {
                objFichaTecnica = new TelaFichaTecnica();
                TelaModuloNutricao.jPainelNutricao.add(objFichaTecnica);//adicona frame ao JDesktopPane  
                objFichaTecnica.setVisible(true);
            }
        }
        try {
            objFichaTecnica.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ReceitasActionPerformed

    private void ComprasMercadoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprasMercadoriasActionPerformed
        // TODO add your handling code here:
        if (objNFE == null || objNFE.isClosed()) {
            objNFE = new TelaEntradaProdutosNUTRI();
            jPainelNutricao.add(objNFE);
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
                objNFE = new TelaEntradaProdutosNUTRI();
                TelaModuloNutricao.jPainelNutricao.add(objNFE);//adicona frame ao JDesktopPane  
                objNFE.setVisible(true);
            }
        }
        try {
            objNFE.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ComprasMercadoriasActionPerformed

    private void InventarioEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventarioEstoqueActionPerformed
        // TODO add your handling code here:
        if (objInvetNUTRI == null || objInvetNUTRI.isClosed()) {
            objInvetNUTRI = new TelaInventarioProdutosNUTRI();
            jPainelNutricao.add(objInvetNUTRI);
            objInvetNUTRI.setVisible(true);
        } else {
            if (objInvetNUTRI.isVisible()) {
                if (objInvetNUTRI.isIcon()) { // Se esta minimizado
                    try {
                        objInvetNUTRI.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objInvetNUTRI.toFront(); // traz para frente
                    objInvetNUTRI.pack();//volta frame 
                }
            } else {
                objInvetNUTRI = new TelaInventarioProdutosNUTRI();
                TelaModuloNutricao.jPainelNutricao.add(objInvetNUTRI);//adicona frame ao JDesktopPane  
                objInvetNUTRI.setVisible(true);
            }
        }
        try {
            objInvetNUTRI.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_InventarioEstoqueActionPerformed

    private void RequisicaoMateriaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequisicaoMateriaisActionPerformed
        // TODO add your handling code here:
        if (objReqNUTRI == null || objReqNUTRI.isClosed()) {
            objReqNUTRI = new TelaRequisicaoMateriaisNUTRI();
            jPainelNutricao.add(objReqNUTRI);
            objReqNUTRI.setVisible(true);
        } else {
            if (objReqNUTRI.isVisible()) {
                if (objReqNUTRI.isIcon()) { // Se esta minimizado
                    try {
                        objReqNUTRI.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objReqNUTRI.toFront(); // traz para frente
                    objReqNUTRI.pack();//volta frame 
                }
            } else {
                objReqNUTRI = new TelaRequisicaoMateriaisNUTRI();
                TelaModuloNutricao.jPainelNutricao.add(objReqNUTRI);//adicona frame ao JDesktopPane  
                objReqNUTRI.setVisible(true);
            }
        }
        try {
            objReqNUTRI.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_RequisicaoMateriaisActionPerformed

    private void RequisicaoMateriaisAvulsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequisicaoMateriaisAvulsaActionPerformed
        // TODO add your handling code here:
        if (objReqAvulsaNUTRI == null || objReqAvulsaNUTRI.isClosed()) {
            objReqAvulsaNUTRI = new TelaRequisicaoAvulsaNUTRI();
            jPainelNutricao.add(objReqAvulsaNUTRI);
            objReqAvulsaNUTRI.setVisible(true);
        } else {
            if (objReqAvulsaNUTRI.isVisible()) {
                if (objReqAvulsaNUTRI.isIcon()) { // Se esta minimizado
                    try {
                        objReqAvulsaNUTRI.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objReqAvulsaNUTRI.toFront(); // traz para frente
                    objReqAvulsaNUTRI.pack();//volta frame 
                }
            } else {
                objReqAvulsaNUTRI = new TelaRequisicaoAvulsaNUTRI();
                TelaModuloNutricao.jPainelNutricao.add(objReqAvulsaNUTRI);//adicona frame ao JDesktopPane  
                objReqAvulsaNUTRI.setVisible(true);
            }
        }
        try {
            objReqAvulsaNUTRI.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_RequisicaoMateriaisAvulsaActionPerformed

    private void EstornoRequisicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstornoRequisicaoActionPerformed
        // TODO add your handling code here:
        if (objEstRequisicaoNUTRI == null || objEstRequisicaoNUTRI.isClosed()) {
            objEstRequisicaoNUTRI = new TelaEstornoRequisicaoMateriaisNUTRI();
            jPainelNutricao.add(objEstRequisicaoNUTRI);
            objEstRequisicaoNUTRI.setVisible(true);
        } else {
            if (objEstRequisicaoNUTRI.isVisible()) {
                if (objEstRequisicaoNUTRI.isIcon()) { // Se esta minimizado
                    try {
                        objEstRequisicaoNUTRI.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objEstRequisicaoNUTRI.toFront(); // traz para frente
                    objEstRequisicaoNUTRI.pack();//volta frame 
                }
            } else {
                objEstRequisicaoNUTRI = new TelaEstornoRequisicaoMateriaisNUTRI();
                TelaModuloNutricao.jPainelNutricao.add(objEstRequisicaoNUTRI);//adicona frame ao JDesktopPane  
                objEstRequisicaoNUTRI.setVisible(true);
            }
        }
        try {
            objEstRequisicaoNUTRI.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_EstornoRequisicaoActionPerformed

    private void SolicitacaoComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolicitacaoComprasActionPerformed
        // TODO add your handling code here:
        if (objSolCompMatNUTRI == null || objSolCompMatNUTRI.isClosed()) {
            objSolCompMatNUTRI = new TelaSolicitacaoComprasMateriaisNUTRI();
            jPainelNutricao.add(objSolCompMatNUTRI);
            objSolCompMatNUTRI.setVisible(true);
        } else {
            if (objSolCompMatNUTRI.isVisible()) {
                if (objSolCompMatNUTRI.isIcon()) { // Se esta minimizado
                    try {
                        objSolCompMatNUTRI.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objSolCompMatNUTRI.toFront(); // traz para frente
                    objSolCompMatNUTRI.pack();//volta frame 
                }
            } else {
                objSolCompMatNUTRI = new TelaSolicitacaoComprasMateriaisNUTRI();
                TelaModuloNutricao.jPainelNutricao.add(objSolCompMatNUTRI);//adicona frame ao JDesktopPane  
                objSolCompMatNUTRI.setVisible(true);
            }
        }
        try {
            objSolCompMatNUTRI.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_SolicitacaoComprasActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        if (objConsEstoqueNUTRI == null || objConsEstoqueNUTRI.isClosed()) {
            objConsEstoqueNUTRI = new TelaConsultaEstoqueNUTRI();
            jPainelNutricao.add(objConsEstoqueNUTRI);
            objConsEstoqueNUTRI.setVisible(true);
        } else {
            if (objConsEstoqueNUTRI.isVisible()) {
                if (objConsEstoqueNUTRI.isIcon()) { // Se esta minimizado
                    try {
                        objConsEstoqueNUTRI.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConsEstoqueNUTRI.toFront(); // traz para frente
                    objConsEstoqueNUTRI.pack();//volta frame 
                }
            } else {
                objConsEstoqueNUTRI = new TelaConsultaEstoqueNUTRI();
                TelaModuloNutricao.jPainelNutricao.add(objConsEstoqueNUTRI);//adicona frame ao JDesktopPane  
                objConsEstoqueNUTRI.setVisible(true);
            }
        }
        try {
            objConsEstoqueNUTRI.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void RelatorioCadastroProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioCadastroProdutosActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioProdutosCadastradosPorGrupo.jasper";
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

    private void RelatorioProdutosConsumoInternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioProdutosConsumoInternosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConsumoProdutosInternoPorDataNUTRI objPesqConsuProdDataNUTRI = new TelaRelatorioConsumoProdutosInternoPorDataNUTRI();
        TelaModuloNutricao.jPainelNutricao.add(objPesqConsuProdDataNUTRI);
        objPesqConsuProdDataNUTRI.show();
    }//GEN-LAST:event_RelatorioProdutosConsumoInternosActionPerformed

    private void RelatorioConsumoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioConsumoProdutoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConsumoProdutosInternoNUTRI objPesqConsuProdNUTRI = new TelaRelatorioConsumoProdutosInternoNUTRI();
        TelaModuloNutricao.jPainelNutricao.add(objPesqConsuProdNUTRI);
        objPesqConsuProdNUTRI.show();
    }//GEN-LAST:event_RelatorioConsumoProdutoActionPerformed

    private void RelatorioProdutosConsumoAvulsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioProdutosConsumoAvulsoActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConsumoProdutosAvulsoNUTRI objRelConsuProdAvulNUTRI = new TelaRelatorioConsumoProdutosAvulsoNUTRI();
        TelaModuloNutricao.jPainelNutricao.add(objRelConsuProdAvulNUTRI);
        objRelConsuProdAvulNUTRI.show();
    }//GEN-LAST:event_RelatorioProdutosConsumoAvulsoActionPerformed

    private void RelatorioEstoqueProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEstoqueProdutosActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEstoqueProdutosNUTRI objRelEstProdNUTRI = new TelaRelatorioEstoqueProdutosNUTRI();
        TelaModuloNutricao.jPainelNutricao.add(objRelEstProdNUTRI);
        objRelEstProdNUTRI.show();
    }//GEN-LAST:event_RelatorioEstoqueProdutosActionPerformed

    private void RelatorioGeralPavilhaoCelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioGeralPavilhaoCelasActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/ListagemGeralConfere.jasper";
            conecta.executaSQL("SELECT * FROM ITENSLOCACAOINTERNO "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSLOCACAOINTERNO.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN CELAS "
                    + "ON ITENSLOCACAOINTERNO.IdCela=CELAS.IdCela "
                    + "INNER JOIN PAVILHAO "
                    + "ON CELAS.IdPav=PAVILHAO.IdPav ORDER BY DescricaoPav,PRONTUARIOSCRC.NomeInternoCrc,CELAS.EndCelaPav");
            HashMap parametros = new HashMap();
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem Geral de Confere");
            jv.setVisible(true); // Chama o relatorio para ser visualizado
            jv.toFront(); // Traz o relatorio para frente da aplicação
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_RelatorioGeralPavilhaoCelasActionPerformed

    private void ListagemConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListagemConfereActionPerformed
        // TODO add your handling code here:
        TelaRelatorioConfere objRelConfere = new TelaRelatorioConfere();
        TelaModuloNutricao.jPainelNutricao.add(objRelConfere);
        objRelConfere.show();
    }//GEN-LAST:event_ListagemConfereActionPerformed

    private void MapaConfereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MapaConfereActionPerformed
        // TODO add your handling code here:
        TelaRelMapaConfereSeguranca mapop = new TelaRelMapaConfereSeguranca();
        TelaModuloNutricao.jPainelNutricao.add(mapop);
        mapop.show();
    }//GEN-LAST:event_MapaConfereActionPerformed

    private void ListaPassagemInternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaPassagemInternaActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/RelatorioListaPassagemInterna.jasper";
            conecta.executaSQL("SELECT * FROM ITENSAGENDALABORATIVA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSAGENDALABORATIVA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "INNER JOIN EMPRESALAB "
                    + "ON ITENSAGENDALABORATIVA.IdEmp=EMPRESALAB.IdEmp "
                    + "WHERE TipoEmpresa='" + tipoEmpresa + "'AND StatusInterno='" + statusInterno + "'ORDER BY RazaoSocial,NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("tipoEmpresa", tipoEmpresa);
            parametros.put("statusEmpresa", statusInterno);
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Relatório de Lista de Passagem de Internos na Unidade Penal");
            jv.setVisible(true); // Chama o relatorio para ser visualizado
            jv.toFront(); // Traz o relatorio para frente da aplicação
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_ListaPassagemInternaActionPerformed

    private void ListaPassagemExternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaPassagemExternaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListaPassagemExternaActionPerformed

    private void RequisicaoMateriaisCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequisicaoMateriaisCardapioActionPerformed
        // TODO add your handling code here:
        if (objReqCardapio == null || objReqCardapio.isClosed()) {
            objReqCardapio = new TelaRequisicaoMateriaisCardapioNUTRI();
            jPainelNutricao.add(objReqCardapio);
            objReqCardapio.setVisible(true);
        } else {
            if (objReqCardapio.isVisible()) {
                if (objReqCardapio.isIcon()) { // Se esta minimizado
                    try {
                        objReqCardapio.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objReqCardapio.toFront(); // traz para frente
                    objReqCardapio.pack();//volta frame 
                }
            } else {
                objReqCardapio = new TelaRequisicaoMateriaisCardapioNUTRI();
                TelaModuloNutricao.jPainelNutricao.add(objReqCardapio);//adicona frame ao JDesktopPane  
                objReqCardapio.setVisible(true);
            }
        }
        try {
            objReqCardapio.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_RequisicaoMateriaisCardapioActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        try {
            conecta.abrirConexao();
            String path = "reports/ListagemPronturarioInternosRegime.jasper";
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC "
                    + "INNER JOIN DADOSPENAISINTERNOS "
                    + "ON PRONTUARIOSCRC.IdInternoCrc=DADOSPENAISINTERNOS.IdInternoCrc "
                    + "WHERE SituacaoCrc='" + situacaoEnt + "'OR SituacaoCrc='" + situacaoRet + "'ORDER BY NomeInternoCrc");
            HashMap parametros = new HashMap();
            parametros.put("situacaoEntrada", situacaoEnt);
            parametros.put("situacaoRetorno", situacaoRet);
            parametros.put("nomeUsuario", nameUser);
            JRResultSetDataSource relatResul = new JRResultSetDataSource(conecta.rs); // Passa o resulSet Preenchido para o relatorio                                   
            JasperPrint jpPrint = JasperFillManager.fillReport(path, parametros, relatResul); // indica o caminmhodo relatório
            JasperViewer jv = new JasperViewer(jpPrint, false); // Cria instancia para impressao          
            jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH); // Maximizar o relatório
            jv.setTitle("Listagem de População de Internos Por Regime Penal");
            jv.setVisible(true); // Chama o relatorio para ser visualizado                                    
            jv.toFront(); // Traz o relatorio para frente da aplicação            
            conecta.desconecta();
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o Relatório \n\nERRO :" + e);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void AgendaCompromissosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaCompromissosActionPerformed
        // TODO add your handling code here:
        if (objAgEventos == null || objAgEventos.isClosed()) {
            objAgEventos = new TelaAgendaCompromissos();
            jPainelNutricao.add(objAgEventos);
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
                TelaModuloNutricao.jPainelNutricao.add(objAgEventos);//adicona frame ao JDesktopPane  
                objAgEventos.setVisible(true);
            }
        }
        try {
            objAgEventos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaCompromissosActionPerformed

    private void RelatorioEntradaInternosUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradaInternosUnidadeActionPerformed
        // TODO add your handling code here:
        TelaRelatorioEntradas objRelEntradaInter = new TelaRelatorioEntradas();
        TelaModuloNutricao.jPainelNutricao.add(objRelEntradaInter);
        objRelEntradaInter.show();
    }//GEN-LAST:event_RelatorioEntradaInternosUnidadeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgendaCompromissos;
    private javax.swing.JMenuItem AgendaRecados;
    private javax.swing.JMenuItem ComprasMercadorias;
    private javax.swing.JMenuItem EstornoRequisicao;
    private javax.swing.JMenuItem FornecedoresCompras;
    private javax.swing.JMenuItem GrupoProdutos;
    private javax.swing.JMenuItem InventarioEstoque;
    private javax.swing.JMenuItem ListaPassagemExterna;
    private javax.swing.JMenuItem ListaPassagemInterna;
    private javax.swing.JMenuItem ListagemConfere;
    private javax.swing.JMenuItem LocaisArmazenamento;
    private javax.swing.JMenuItem MapaConfere;
    private javax.swing.JMenu Movimentacao;
    private javax.swing.JMenuItem Produtos;
    private javax.swing.JMenuItem Receitas;
    private javax.swing.JMenuItem RelatorioCadastroProdutos;
    private javax.swing.JMenuItem RelatorioConsumoProduto;
    private javax.swing.JMenuItem RelatorioEntradaInternosUnidade;
    private javax.swing.JMenuItem RelatorioEstoqueProdutos;
    private javax.swing.JMenuItem RelatorioGeralPavilhaoCelas;
    private javax.swing.JMenu RelatorioListasPassagens;
    private javax.swing.JMenuItem RelatorioProdutosConsumoAvulso;
    private javax.swing.JMenuItem RelatorioProdutosConsumoInternos;
    private javax.swing.JMenuItem RequisicaoMateriais;
    private javax.swing.JMenuItem RequisicaoMateriaisAvulsa;
    private javax.swing.JMenuItem RequisicaoMateriaisCardapio;
    private javax.swing.JMenuItem SolicitacaoCompras;
    private javax.swing.JMenuItem TiposReceitas;
    private javax.swing.JMenu Utilitarios;
    private javax.swing.JMenu jCadastros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem9;
    public static javax.swing.JDesktopPane jPainelNutricao;
    private javax.swing.JMenu jRelatorios;
    private javax.swing.JMenuItem jSair;
    private javax.swing.JPopupMenu.Separator jSeparator1;
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
                verificarRecado(); // Verificar recados a cada 5 minutos    
                verificarAgendaCompromisso();
            }
        }, periodo, tempo);
    }

    // Chama a calculadora de pena para o java
    public void calcPena() {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start calcpena.exe");
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
// Calculadora do Windows

    public void CalcWindows() {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start calc.exe");
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void verificarRecado() {
        buscarUsuario(nameUser);
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM AGENDARECADOS WHERE IdUsuario='" + codUsuario + "'AND StatusAgenda='" + statusAgenda + "'");
            conecta.rs.first();
            if (codUsuario == conecta.rs.getInt("IdUsuario")) {
                TelaRecadosCompras objRecados = new TelaRecadosCompras();
                TelaModuloNutricao.jPainelNutricao.add(objRecados);
                objRecados.show();
                flag = 1;
                preencherTabelaTodosRecados("SELECT * FROM AGENDARECADOS INNER JOIN USUARIOS ON AGENDARECADOS.IdUsuario=USUARIOS.IdUsuario WHERE NomeUsuario='" + nameUser + "'AND StatusAgenda='" + statusAgenda + "'");
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
                        conecta.executaSQL("SELECT * FROM AGENDARECADOS INNER JOIN USUARIOS ON AGENDARECADOS.IdUsuario=USUARIOS.IdUsuario WHERE NomeUsuario='" + nameUser + "'AND StatusAgenda='" + statusAgenda + "'");
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
            //  JOptionPane.showMessageDialog(rootPane, "Não foi possível verificar mensagem.\nERRO:" + ex);
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
        convertedata.converter(jDataSistema.getText());
        if (tipoServidor == null || tipoServidor.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "É necessário definir o parâmtero para o sistema operacional utilizado no servidor, (UBUNTU-LINUX ou WINDOWS SERVER).");
        } else if (tipoServidor.equals("Servidor Linux (Ubuntu)/MS-SQL Server")) {
            conecta.abrirConexao();
            try {
                conecta.executaSQL("SELECT * FROM AGENDA_COMPROMISSOS WHERE UsuarioAgenda='" + nameUser + "' "
                        + "AND StatusAgenda='" + statusAgenda + "' "
                        + "AND DataLembrete='" + dataSisConvert + "' "
                        + "AND HoraLembrete<='" + jHoraSistema.getText().toString() + "'");
                conecta.rs.first();
                horaLembrete = conecta.rs.getString("HoraLembrete");
                usuarioAgenda = conecta.rs.getString("UsuarioAgenda");
                codigoAgendaComp = conecta.rs.getString("IdAgenda");
                //
                if (nomeUsuarioCompromisso.equals(usuarioAgenda)) {
                    TelaAgendaCompromissos objAgendaComp = new TelaAgendaCompromissos();
                    TelaModuloNutricao.jPainelNutricao.add(objAgendaComp);
                    objAgendaComp.show();
                    flag = 1;
                    preencherTabelaAgendaCompromisso("SELECT * FROM AGENDA_COMPROMISSOS "
                            + "WHERE AGENDA_COMPROMISSOS.UsuarioAgenda='" + nameUser + "' "
                            + "AND AGENDA_COMPROMISSOS.StatusAgenda='" + statusAgenda + "' "
                            + "AND DataLembrete='" + dataSisConvert + "' "
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
            //
        } else if (tipoServidor.equals("Servidor Windows/MS-SQL Server")) {
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
                    TelaModuloNutricao.jPainelNutricao.add(objAgendaComp);
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
