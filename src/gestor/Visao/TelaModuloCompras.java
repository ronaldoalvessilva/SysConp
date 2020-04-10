/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import static gestor.Visao.TelaLoginSenha.nameUser;
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
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author user
 */
public class TelaModuloCompras extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    private TelaRecadosCompras objRecadosCompras = null;
    private TelaFornecedorCOMPRAS objForCOMPRAS = null;
    private TelaProdutosCOMPRAS objConsultaProdutosCompras = null;
    private TelaTransportadora objTransVei = null;
    private TelaFormaPagamento objFormaPagto = null;
    private TelaCentroCusto objCentroCusto = null;
    private TelaConsultaEstoqueCompras objConEstoCompras = null;
    private TelaCotacaoCompras objCotacao = null;
    private TelaAgendaCompromissos objAgEventos = null;
    private TelaConsutaSolicitacaoComprasCotacao objConsultaSoli = null;

    String dataLanc;
    int codUsuario;
    int flag;
    String statusAgenda = "Pendente";
    //
    int tempo = (1000 * 60) * 5;   // 5 min.  
    int periodo = 1;  // quantidade de vezes a ser executado. 

    /**
     * Creates new form TelaDiretoria
     */
    public TelaModuloCompras() {
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

        jPainelCompras = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jCadastros = new javax.swing.JMenu();
        FornecedoresCompras = new javax.swing.JMenuItem();
        Transportadoras = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        CondicaoPagamento = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        AgendaCompromissosPessoal = new javax.swing.JMenuItem();
        AgendaRecados = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jSair = new javax.swing.JMenuItem();
        Consultas = new javax.swing.JMenu();
        ConsultaProdutosAlmoxarifado = new javax.swing.JMenuItem();
        ConsultaEstoqueAlmoxarifadoCentral = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        ConsultaSolicitacaoCompras = new javax.swing.JMenuItem();
        Movimentacao = new javax.swing.JMenu();
        SolicitacaoComprasMateriais = new javax.swing.JMenuItem();
        CotacaoComprasMateriais = new javax.swing.JMenuItem();
        PedidoCompraMateriais = new javax.swing.JMenuItem();
        OrdemComprasMateriais = new javax.swing.JMenuItem();
        DevolucaoComprasMateriais = new javax.swing.JMenuItem();
        jRelatorios = new javax.swing.JMenu();
        Utilitarios = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Controle de Compras de Materiais :::...");
        setToolTipText("");

        jPainelCompras.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/BrasaoFundo500Prata2.png"))); // NOI18N

        jPainelCompras.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPainelComprasLayout = new javax.swing.GroupLayout(jPainelCompras);
        jPainelCompras.setLayout(jPainelComprasLayout);
        jPainelComprasLayout.setHorizontalGroup(
            jPainelComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE)
        );
        jPainelComprasLayout.setVerticalGroup(
            jPainelComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );

        jCadastros.setText("Cadastros");

        FornecedoresCompras.setText("Fornecedores");
        FornecedoresCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FornecedoresComprasActionPerformed(evt);
            }
        });
        jCadastros.add(FornecedoresCompras);

        Transportadoras.setText("Transportadoras");
        Transportadoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransportadorasActionPerformed(evt);
            }
        });
        jCadastros.add(Transportadoras);
        jCadastros.add(jSeparator2);

        CondicaoPagamento.setText("Formas de Pagamento");
        CondicaoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CondicaoPagamentoActionPerformed(evt);
            }
        });
        jCadastros.add(CondicaoPagamento);

        jMenuItem1.setText("Centro de Custo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jCadastros.add(jMenuItem1);
        jCadastros.add(jSeparator1);

        AgendaCompromissosPessoal.setText("Agenda de Compromissos Pessoal");
        AgendaCompromissosPessoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaCompromissosPessoalActionPerformed(evt);
            }
        });
        jCadastros.add(AgendaCompromissosPessoal);

        AgendaRecados.setText("Agenda de Recados");
        AgendaRecados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendaRecadosActionPerformed(evt);
            }
        });
        jCadastros.add(AgendaRecados);
        jCadastros.add(jSeparator3);

        jSair.setText("Sair");
        jSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSairActionPerformed(evt);
            }
        });
        jCadastros.add(jSair);

        jMenuBar1.add(jCadastros);

        Consultas.setText("Consultas");

        ConsultaProdutosAlmoxarifado.setText("Produtos para Compras");
        ConsultaProdutosAlmoxarifado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaProdutosAlmoxarifadoActionPerformed(evt);
            }
        });
        Consultas.add(ConsultaProdutosAlmoxarifado);

        ConsultaEstoqueAlmoxarifadoCentral.setText("Estoque de Produtos e Materiais");
        ConsultaEstoqueAlmoxarifadoCentral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaEstoqueAlmoxarifadoCentralActionPerformed(evt);
            }
        });
        Consultas.add(ConsultaEstoqueAlmoxarifadoCentral);
        Consultas.add(jSeparator4);

        ConsultaSolicitacaoCompras.setText("Solicitações de Compras");
        ConsultaSolicitacaoCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaSolicitacaoComprasActionPerformed(evt);
            }
        });
        Consultas.add(ConsultaSolicitacaoCompras);

        jMenuBar1.add(Consultas);

        Movimentacao.setText("Movimentação");

        SolicitacaoComprasMateriais.setText("Solicitação de Compras de Materiais");
        SolicitacaoComprasMateriais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolicitacaoComprasMateriaisActionPerformed(evt);
            }
        });
        Movimentacao.add(SolicitacaoComprasMateriais);

        CotacaoComprasMateriais.setText("Cotação de Compras de Materiais");
        CotacaoComprasMateriais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CotacaoComprasMateriaisActionPerformed(evt);
            }
        });
        Movimentacao.add(CotacaoComprasMateriais);

        PedidoCompraMateriais.setText("Pedido de Compras de Materiais");
        PedidoCompraMateriais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PedidoCompraMateriaisActionPerformed(evt);
            }
        });
        Movimentacao.add(PedidoCompraMateriais);

        OrdemComprasMateriais.setText("Ordem de Compras de Materiais");
        OrdemComprasMateriais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdemComprasMateriaisActionPerformed(evt);
            }
        });
        Movimentacao.add(OrdemComprasMateriais);

        DevolucaoComprasMateriais.setText("Devolução de Compras de Produtos - NFE");
        Movimentacao.add(DevolucaoComprasMateriais);

        jMenuBar1.add(Movimentacao);

        jRelatorios.setText("Relatórios");
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
            .addComponent(jPainelCompras)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelCompras, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jSairActionPerformed

    private void AgendaRecadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaRecadosActionPerformed
        // TODO add your handling code here:
        if (objRecadosCompras == null || objRecadosCompras.isClosed()) {
            objRecadosCompras = new TelaRecadosCompras();
            jPainelCompras.add(objRecadosCompras);
            objRecadosCompras.setVisible(true);
        } else {
            if (objRecadosCompras.isVisible()) {
                if (objRecadosCompras.isIcon()) { // Se esta minimizado
                    try {
                        objRecadosCompras.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objRecadosCompras.toFront(); // traz para frente
                    objRecadosCompras.pack();//volta frame 
                }
            } else {
                objRecadosCompras = new TelaRecadosCompras();
                TelaModuloCompras.jPainelCompras.add(objRecadosCompras);//adicona frame ao JDesktopPane  
                objRecadosCompras.setVisible(true);
            }
        }
        try {
            objRecadosCompras.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaRecadosActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        CalcWindows();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void FornecedoresComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FornecedoresComprasActionPerformed
        // TODO add your handling code here:       
        if (objForCOMPRAS == null || objForCOMPRAS.isClosed()) {
            objForCOMPRAS = new TelaFornecedorCOMPRAS();
            jPainelCompras.add(objForCOMPRAS);
            objForCOMPRAS.setVisible(true);
        } else {
            if (objForCOMPRAS.isVisible()) {
                if (objForCOMPRAS.isIcon()) { // Se esta minimizado
                    try {
                        objForCOMPRAS.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objForCOMPRAS.toFront(); // traz para frente
                    objForCOMPRAS.pack();//volta frame 
                }
            } else {
                objForCOMPRAS = new TelaFornecedorCOMPRAS();
                TelaModuloCompras.jPainelCompras.add(objForCOMPRAS);//adicona frame ao JDesktopPane  
                objForCOMPRAS.setVisible(true);
            }
        }
        try {
            objForCOMPRAS.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
        // TelaFornecedorCOMPRASNUTRI objForCOMPRAS
    }//GEN-LAST:event_FornecedoresComprasActionPerformed

    private void ConsultaProdutosAlmoxarifadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaProdutosAlmoxarifadoActionPerformed
        // TODO add your handling code here:
        // AINDA NÃO FOI DEFINIDO COMO SERÁ A CONSULTA DE PRODUTOS PARA COMPRAS.
        if (objConsultaProdutosCompras == null || objConsultaProdutosCompras.isClosed()) {
            objConsultaProdutosCompras = new TelaProdutosCOMPRAS();
            jPainelCompras.add(objConsultaProdutosCompras);
            objConsultaProdutosCompras.setVisible(true);
        } else {
            if (objConsultaProdutosCompras.isVisible()) {
                if (objConsultaProdutosCompras.isIcon()) { // Se esta minimizado
                    try {
                        objConsultaProdutosCompras.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConsultaProdutosCompras.toFront(); // traz para frente
                    objConsultaProdutosCompras.pack();//volta frame 
                }
            } else {
                objConsultaProdutosCompras = new TelaProdutosCOMPRAS();
                TelaModuloCompras.jPainelCompras.add(objConsultaProdutosCompras);//adicona frame ao JDesktopPane  
                objConsultaProdutosCompras.setVisible(true);
            }
        }
        try {
            objConsultaProdutosCompras.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ConsultaProdutosAlmoxarifadoActionPerformed

    private void TransportadorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransportadorasActionPerformed
        // TODO add your handling code here:
        if (objTransVei == null || objTransVei.isClosed()) {
            objTransVei = new TelaTransportadora();
            jPainelCompras.add(objTransVei);
            objTransVei.setVisible(true);
        } else {
            if (objTransVei.isVisible()) {
                if (objTransVei.isIcon()) { // Se esta minimizado
                    try {
                        objTransVei.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objTransVei.toFront(); // traz para frente
                    objTransVei.pack();//volta frame 
                }
            } else {
                objTransVei = new TelaTransportadora();
                TelaModuloCompras.jPainelCompras.add(objTransVei);//adicona frame ao JDesktopPane  
                objTransVei.setVisible(true);
            }
        }
        try {
            objTransVei.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_TransportadorasActionPerformed

    private void CondicaoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CondicaoPagamentoActionPerformed
        // TODO add your handling code here:
        if (objFormaPagto == null || objFormaPagto.isClosed()) {
            objFormaPagto = new TelaFormaPagamento();
            jPainelCompras.add(objFormaPagto);
            objFormaPagto.setVisible(true);
        } else {
            if (objFormaPagto.isVisible()) {
                if (objFormaPagto.isIcon()) { // Se esta minimizado
                    try {
                        objFormaPagto.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objFormaPagto.toFront(); // traz para frente
                    objFormaPagto.pack();//volta frame 
                }
            } else {
                objFormaPagto = new TelaFormaPagamento();
                TelaModuloCompras.jPainelCompras.add(objFormaPagto);//adicona frame ao JDesktopPane  
                objFormaPagto.setVisible(true);
            }
        }
        try {
            objFormaPagto.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_CondicaoPagamentoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        if (objCentroCusto == null || objCentroCusto.isClosed()) {
            objCentroCusto = new TelaCentroCusto();
            jPainelCompras.add(objCentroCusto);
            objCentroCusto.setVisible(true);
        } else {
            if (objCentroCusto.isVisible()) {
                if (objCentroCusto.isIcon()) { // Se esta minimizado
                    try {
                        objCentroCusto.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objCentroCusto.toFront(); // traz para frente
                    objCentroCusto.pack();//volta frame 
                }
            } else {
                objCentroCusto = new TelaCentroCusto();
                TelaModuloCompras.jPainelCompras.add(objCentroCusto);//adicona frame ao JDesktopPane  
                objCentroCusto.setVisible(true);
            }
        }
        try {
            objCentroCusto.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void ConsultaEstoqueAlmoxarifadoCentralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaEstoqueAlmoxarifadoCentralActionPerformed
        // TODO add your handling code here:
        if (objConEstoCompras == null || objConEstoCompras.isClosed()) {
            objConEstoCompras = new TelaConsultaEstoqueCompras();
            jPainelCompras.add(objConEstoCompras);
            objConEstoCompras.setVisible(true);
        } else {
            if (objConEstoCompras.isVisible()) {
                if (objConEstoCompras.isIcon()) { // Se esta minimizado
                    try {
                        objConEstoCompras.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConEstoCompras.toFront(); // traz para frente
                    objConEstoCompras.pack();//volta frame 
                }
            } else {
                objConEstoCompras = new TelaConsultaEstoqueCompras();
                TelaModuloCompras.jPainelCompras.add(objConEstoCompras);//adicona frame ao JDesktopPane  
                objConEstoCompras.setVisible(true);
            }
        }
        try {
            objConEstoCompras.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_ConsultaEstoqueAlmoxarifadoCentralActionPerformed

    private void SolicitacaoComprasMateriaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolicitacaoComprasMateriaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SolicitacaoComprasMateriaisActionPerformed

    private void CotacaoComprasMateriaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CotacaoComprasMateriaisActionPerformed
        // TODO add your handling code here:
        if (objCotacao == null || objCotacao.isClosed()) {
            objCotacao = new TelaCotacaoCompras();
            jPainelCompras.add(objCotacao);
            objCotacao.setVisible(true);
        } else {
            if (objCotacao.isVisible()) {
                if (objCotacao.isIcon()) { // Se esta minimizado
                    try {
                        objCotacao.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objCotacao.toFront(); // traz para frente
                    objCotacao.pack();//volta frame 
                }
            } else {
                objCotacao = new TelaCotacaoCompras();
                TelaModuloCompras.jPainelCompras.add(objCotacao);//adicona frame ao JDesktopPane  
                objCotacao.setVisible(true);
            }
        }
        try {
            objCotacao.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_CotacaoComprasMateriaisActionPerformed

    private void PedidoCompraMateriaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PedidoCompraMateriaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PedidoCompraMateriaisActionPerformed

    private void OrdemComprasMateriaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdemComprasMateriaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OrdemComprasMateriaisActionPerformed

    private void AgendaCompromissosPessoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendaCompromissosPessoalActionPerformed
        // TODO add your handling code here:
        if (objAgEventos == null || objAgEventos.isClosed()) {
            objAgEventos = new TelaAgendaCompromissos();
            jPainelCompras.add(objAgEventos);
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
                TelaModuloCompras.jPainelCompras.add(objAgEventos);//adicona frame ao JDesktopPane  
                objAgEventos.setVisible(true);
            }
        }
        try {
            objAgEventos.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_AgendaCompromissosPessoalActionPerformed

    private void ConsultaSolicitacaoComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaSolicitacaoComprasActionPerformed
        // TODO add your handling code here:
        if (objConsultaSoli == null || objConsultaSoli.isClosed()) {
            objConsultaSoli = new TelaConsutaSolicitacaoComprasCotacao();
            jPainelCompras.add(objConsultaSoli);
            objConsultaSoli.setVisible(true);
        } else {
            if (objConsultaSoli.isVisible()) {
                if (objConsultaSoli.isIcon()) { // Se esta minimizado
                    try {
                        objConsultaSoli.setIcon(false); // maximiniza
                    } catch (PropertyVetoException ex) {
                    }
                } else {
                    objConsultaSoli.toFront(); // traz para frente
                    objConsultaSoli.pack();//volta frame 
                }
            } else {
                objConsultaSoli = new TelaConsutaSolicitacaoComprasCotacao();
                TelaModuloCompras.jPainelCompras.add(objConsultaSoli);//adicona frame ao JDesktopPane  
                objConsultaSoli.setVisible(true);
            }
        }
        try {
            objConsultaSoli.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
//        private TelaConsutaSolicitacaoComprasCotacao objConsultaSoli = null;
    }//GEN-LAST:event_ConsultaSolicitacaoComprasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgendaCompromissosPessoal;
    private javax.swing.JMenuItem AgendaRecados;
    private javax.swing.JMenuItem CondicaoPagamento;
    private javax.swing.JMenuItem ConsultaEstoqueAlmoxarifadoCentral;
    private javax.swing.JMenuItem ConsultaProdutosAlmoxarifado;
    private javax.swing.JMenuItem ConsultaSolicitacaoCompras;
    private javax.swing.JMenu Consultas;
    private javax.swing.JMenuItem CotacaoComprasMateriais;
    private javax.swing.JMenuItem DevolucaoComprasMateriais;
    private javax.swing.JMenuItem FornecedoresCompras;
    private javax.swing.JMenu Movimentacao;
    private javax.swing.JMenuItem OrdemComprasMateriais;
    private javax.swing.JMenuItem PedidoCompraMateriais;
    private javax.swing.JMenuItem SolicitacaoComprasMateriais;
    private javax.swing.JMenuItem Transportadoras;
    private javax.swing.JMenu Utilitarios;
    private javax.swing.JMenu jCadastros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem13;
    public static javax.swing.JDesktopPane jPainelCompras;
    private javax.swing.JMenu jRelatorios;
    private javax.swing.JMenuItem jSair;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    // End of variables declaration//GEN-END:variables

    // Verificar a cada 5 minutos se o recado foi lido (10/01/2015)
    public void threadMensagem() {
        final Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                verificarRecado(); // Verificar recados a cada 5 minutos                
            }
        }, periodo, tempo);
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
            conecta.executaSQL("SELECT * FROM AGENDARECADOS "
                    + "WHERE IdUsuario='" + codUsuario + "' "
                    + "AND StatusAgenda='" + statusAgenda + "'");
            conecta.rs.first();
            if (codUsuario == conecta.rs.getInt("IdUsuario")) {
                TelaRecadosCompras objRecados = new TelaRecadosCompras();
                TelaModuloCompras.jPainelCompras.add(objRecados);
                objRecados.show();
                flag = 1;
                preencherTabelaTodosRecados("SELECT * FROM AGENDARECADOS "
                        + "INNER JOIN USUARIOS "
                        + "ON AGENDARECADOS.IdUsuario=USUARIOS.IdUsuario "
                        + "WHERE NomeUsuario='" + nameUser + "' "
                        + "AND StatusAgenda='" + statusAgenda + "'");
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
                                + "WHERE NomeUsuario='" + nameUser + "' "
                                + "AND StatusAgenda='" + statusAgenda + "'");
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
            conecta.executaSQL("SELECT * FROM USUARIOS "
                    + "WHERE NomeUsuario='" + nomeUser + "'");
            conecta.rs.first();
            codUsuario = conecta.rs.getInt("IdUsuario");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível encontrar o usuário.\nERRO: " + ex);
        }
    }

    public void preencherTabelaTodosRecados(String sql) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Data", "Remetente", "Destinatário"};
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
}
