/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Controle.ControleAtualizaSaldoInventarioAC;
import gestor.Controle.ControleAtualizaSaldoInventarioNUTRI;
import gestor.Controle.ControleEfetivaLoteAC;
import gestor.Controle.ControleEfetivaLoteNUTRI;
import gestor.Controle.ControleHistoricoMovimentacaoAC;
import gestor.Controle.ControleHistoricoMovimentacaoNUTRI;
import gestor.Controle.ControleInventarioEstoqueAC;
import gestor.Controle.ControleInventarioEstoqueNUTRI;
import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.HistoricoMovimentacaoEstoque;
import gestor.Modelo.InventarioEstoque;
import gestor.Modelo.ItensInventarioEstoque;
import gestor.Modelo.ProdutoMedicamento;
import static gestor.Visao.TelaInventarioProdutosAC.jBtResultadoInventario;
import static gestor.Visao.TelaInventarioProdutosAC.jComboBoxTipoInventario;
import static gestor.Visao.TelaInventarioProdutosAC.jDataTermino;
import static gestor.Visao.TelaInventarioProdutosAC.jHorarioTermino;
import static gestor.Visao.TelaInventarioProdutosAC.jIdLanc;
import static gestor.Visao.TelaInventarioProdutosAC.jIdLocal;
import static gestor.Visao.TelaInventarioProdutosAC.jStatusLanc;
import static gestor.Visao.TelaInventarioProdutosAC.jTabelaItensProdutoInvent;
import static gestor.Visao.TelaModuloPrincipal.jDataSistema;
import static gestor.Visao.TelaModuloPrincipal.jHoraSistema;
import static java.lang.Thread.sleep;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class TelaEfetuarInventariosNUTRI extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProdutoMedicamento objProdMed = new ProdutoMedicamento();
    ControleAtualizaSaldoInventarioNUTRI controleSaldo = new ControleAtualizaSaldoInventarioNUTRI();
    ControleEfetivaLoteNUTRI controlLote = new ControleEfetivaLoteNUTRI();
    ControleInventarioEstoqueNUTRI controleFinal = new ControleInventarioEstoqueNUTRI();
    InventarioEstoque objInventEstoque = new InventarioEstoque();
    // HISTÓRICO DE MOVIMENTAÇÃO DO ESTOQUE
    HistoricoMovimentacaoEstoque objHistMovAC = new HistoricoMovimentacaoEstoque();
    ControleHistoricoMovimentacaoNUTRI controlHistMov = new ControleHistoricoMovimentacaoNUTRI();
    //
    String nomeModuloTela = "Nutrição:Efetivar Inventário de Estoque";
    String statusMov;
    String horaMov;
    String dataModFinal, dataValidade;
    double qtdEstoque = 0;
    double qtdItem = 0;
    int codProduto;
    String numeroLote;
    int saldoAtual;
    String tipoInventario; // Se for I = Inventario Inicial, se for A = Ajuste Estoque  
    String statusInventario = "EFETIVADO";

    /**
     * Creates new form TelaEfetuarInventarios
     */
    public TelaEfetuarInventariosNUTRI() {
        initComponents();
        jProgressBar1.setVisible(!true);
        setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE); //Impedir que a janela seja fechada pelo X  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBtConfirmar = new javax.swing.JButton();
        jBtSair = new javax.swing.JButton();
        lblCarregando = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Efetuar Inventário :::...");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Essa tarefa irá atualizar todos produtos relacionados ao inventário.");

        jBtConfirmar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtConfirmar.setForeground(new java.awt.Color(51, 153, 0));
        jBtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/accept.png"))); // NOI18N
        jBtConfirmar.setText("Confirmar");
        jBtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtConfirmarActionPerformed(evt);
            }
        });

        jBtSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jBtSair.setForeground(new java.awt.Color(255, 0, 0));
        jBtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestor/Imagens/Button_Close_Icon_16.png"))); // NOI18N
        jBtSair.setText("Sair");
        jBtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtSairActionPerformed(evt);
            }
        });

        lblCarregando.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCarregando.setForeground(new java.awt.Color(102, 0, 102));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText(" Tenha certeza que todos os valores e quantidades foram lançados.");

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCarregando, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBtConfirmar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtSair)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCarregando, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtConfirmar, jBtSair});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(300, 30, 440, 198);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtConfirmarActionPerformed
        // TODO add your handling code here:
        final DecimalFormat qtdReal = new DecimalFormat("###,##00.0");
        qtdReal.setCurrency(Currency.getInstance(new Locale("pt", "BR")));
        statusMov = "Efetuou";
        horaMov = jHoraSistema.getText();
        dataModFinal = jDataSistema.getText();
        int resposta = JOptionPane.showConfirmDialog(this, "Antes de realizar essa tarefa, tenha certeza de que já foram lançados todos os \nvalores e quantidades. Tem certeza que deseja continuar?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            jProgressBar1.setVisible(true);
            jBtConfirmar.setEnabled(!true);
            jBtSair.setEnabled(!true);
            lblCarregando.setText("Aguarde, efetuando inventário !!!");
            //
            SalvarRegistros registro = new SalvarRegistros();
            BarraDeProgesso barra = new BarraDeProgesso();
            Thread threadBarra = new Thread(barra);
            threadBarra.start();
            Thread executor = new Thread(registro);  // Criação da Thread                             
            executor.start();   // Inicio da execução da Thread        
        }
    }//GEN-LAST:event_jBtConfirmarActionPerformed

    private void jBtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtSairActionPerformed
        // TODO add your handling code here:
        jStatusLanc.setText(statusInventario);
        jBtResultadoInventario.setEnabled(true);
        dispose();
    }//GEN-LAST:event_jBtSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lblCarregando;
    // End of variables declaration//GEN-END:variables

    class BarraDeProgesso implements Runnable {

        //Método de exibição da barra
        @Override
        public void run() {

            for (int i = 0; i < jTabelaItensProdutoInvent.getRowCount() || i <= 101; i++) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                }
                jProgressBar1.setValue(i);
                if (jProgressBar1.getValue() == 100) {
                    lblCarregando.setText("Inventário efetuado com Sucesso !!!");
                    jBtSair.setEnabled(true);
                }
            }
        }
    }

    class SalvarRegistros implements Runnable {

        Date date = null;
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        @Override
        public void run() {
            try {
                sleep(100);
            } catch (InterruptedException e) {
            }
            // FUNCIONADO, TESTADO A PRIMEIRA VEZ EM 28/06/2015
            if (jComboBoxTipoInventario.getSelectedItem().equals("Estoque Inicial")) {
                tipoInventario = "E";
                for (int i = 0; i < jTabelaItensProdutoInvent.getRowCount(); i++) {
                    objProdMed.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    objProdMed.setIdProd((int) jTabelaItensProdutoInvent.getValueAt(i, 1));
                    objProdMed.setSaldoAtual((int) jTabelaItensProdutoInvent.getValueAt(i, 5));
                    objProdMed.setLote((String) jTabelaItensProdutoInvent.getValueAt(i, 6));
                    try {
                        // Converte a data de string para date, para ser inserido no banco de dados.
                        date = (java.util.Date) formatter.parse((String) jTabelaItensProdutoInvent.getValueAt(i, 7));
                    } catch (ParseException ex) {
                    }
                    controleSaldo.alterarEstoqueProdutoNUTRI(objProdMed); // alterar saldo de estoque dos produtos SALDO_ESTQUE_AC
                    verificarProdutoNovoLote(); // Verifica se o produto e o lote existe
                    if (codProduto == objProdMed.getIdProd() && numeroLote == objProdMed.getLote() || codProduto == objProdMed.getIdProd() && numeroLote.equals("")) { // Se existir altera
                        // Se existir atualiza
                        objProdMed.setDataValidade(date);
                        objProdMed.setDataEstoque(jDataTermino.getDate());
                        controlLote.alterarLoteProdutoNUTRI(objProdMed);
                    } else if (codProduto == objProdMed.getIdProd() && numeroLote != objProdMed.getLote()) { // Se não exisitr inclui
                        // Incluir o mesmo produto caso tenha mais de um lote
                        objProdMed.setDataValidade(date);
                        objProdMed.setDataEstoque(jDataTermino.getDate());
                        controlLote.incluirNovoLoteProdutoNUTRI(objProdMed); // Alterar lote de produtos na tabela LOTEPRODUTOS                                           
                    }
                    // ATUALIZAR MOVIMENTAÇÃO DE ESTOQUE NA TABELA HISTORICO_MOVIMENTACAO_ESTOQUE_AC (TESTADO COM SUCESSO.)                    
                    objHistMovAC.setIdProd((int) jTabelaItensProdutoInvent.getValueAt(i, 1));
                    objHistMovAC.setIdLocal(Integer.valueOf(jIdLocal.getText()));
                    objHistMovAC.setTipoOpe(tipoInventario);
                    objHistMovAC.setNomeOperacao((String) jComboBoxTipoInventario.getSelectedItem());
                    objHistMovAC.setIdDoc(Integer.valueOf(jIdLanc.getText()));
                    objHistMovAC.setDataMov(jDataTermino.getDate());
                    objHistMovAC.setQtdItem((int) jTabelaItensProdutoInvent.getValueAt(i, 5));
                    objHistMovAC.setSaldoAtual((float) qtdEstoque);
                    controlHistMov.alterarHistoricoProdutoNUTRI(objHistMovAC);
                    verificarModEstoque(); // VERIFICAR SE O PRODUTO EXISTE NA TABELA HISTORICO_MOVIMENTACAO_ESTOQUE_AC
                    if (codProduto != objHistMovAC.getIdProd() || codProduto == 0) {
                        controlHistMov.incluirHistoricoProdutoNUTRI(objHistMovAC);
                    } else if (codProduto == objHistMovAC.getIdProd()) {
                        SomaProduto(); // SOMAR PRODUTO NA TABELA DE LOTE_ESTOQUE_AC PARA  TABELA HISTORICO_MOVIMENTACAO_ESTOQUE_AC
                        objHistMovAC.setIdProd((int) jTabelaItensProdutoInvent.getValueAt(i, 1));
                        controlHistMov.alterarHistoricoProdutoNUTRI(objHistMovAC);
                    }
                }
                // Modificar o status do inventário para EFETUADO.
                objInventEstoque.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                objInventEstoque.setStatusLanc(statusInventario);
                objInventEstoque.setDataTermino(jDataTermino.getDate());
                objInventEstoque.setHorarioTermino(jHorarioTermino.getText());
                controleFinal.efetivarInventarioAC(objInventEstoque);
                //AINDA NÃO FOI TESTADO
            } else if (jComboBoxTipoInventario.getSelectedItem().equals("Ajuste de Estoque")) {
                tipoInventario = "A";
                for (int i = 0; i < jTabelaItensProdutoInvent.getRowCount(); i++) {
                    objProdMed.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    objProdMed.setIdProd((int) jTabelaItensProdutoInvent.getValueAt(i, 1));
                    objProdMed.setSaldoAtual((int) jTabelaItensProdutoInvent.getValueAt(i, 5));
                    objProdMed.setLote((String) jTabelaItensProdutoInvent.getValueAt(i, 6));
                    try {
                        // Converte a data de string para date, para ser inserido no banco de dados.
                        date = (java.util.Date) formatter.parse((String) jTabelaItensProdutoInvent.getValueAt(i, 7));
                    } catch (ParseException ex) {
                    }
                    controleSaldo.alterarEstoqueProdutoNUTRI(objProdMed); // alterar saldo de estoque dos produtos SALDOESTQUE
                    verificarProdutoNovoLote(); // Verifica se o produto e o lote existe
                    if (codProduto == objProdMed.getIdProd() && numeroLote == objProdMed.getLote() || codProduto == objProdMed.getIdProd() && numeroLote.equals("")) { // Se existir altera
                        // Se existir atualiza
                        objProdMed.setDataValidade(date);
                        objProdMed.setDataEstoque(jDataTermino.getDate());
                        controlLote.alterarLoteProdutoNUTRI(objProdMed);
                    } else if (codProduto == objProdMed.getIdProd() && numeroLote != objProdMed.getLote()) { // Se não exisitr inclui
                        // Incluir o mesmo produto caso tenha mais de um lote
                        objProdMed.setDataValidade(date);
                        objProdMed.setDataEstoque(jDataTermino.getDate());
                        controlLote.incluirNovoLoteProdutoNUTRI(objProdMed); // Alterar lote de produtos na tabela LOTEPRODUTOS                        
                    }
                    // ATUALIZAR MOVIMENTAÇÃO DE ESTOQUE NA TABELA HISTORICO_MOVIMENTACAO_ESTOQUE_AC (TESTADO COM SUCESSO.)                    
                    objHistMovAC.setIdProd((int) jTabelaItensProdutoInvent.getValueAt(i, 1));
                    objHistMovAC.setIdLocal(Integer.valueOf(jIdLocal.getText()));
                    objHistMovAC.setTipoOpe(tipoInventario);
                    objHistMovAC.setNomeOperacao((String) jComboBoxTipoInventario.getSelectedItem());
                    objHistMovAC.setIdDoc(Integer.valueOf(jIdLanc.getText()));
                    objHistMovAC.setDataMov(jDataTermino.getDate());
                    objHistMovAC.setQtdItem((int) jTabelaItensProdutoInvent.getValueAt(i, 5));
                    objHistMovAC.setSaldoAtual((float) qtdEstoque);
                    controlHistMov.incluirHistoricoProdutoNUTRI(objHistMovAC);
                    verificarModEstoque(); // VERIFICAR SE O PRODUTO EXISTE NA TABELA HISTORICO_MOVIMENTACAO_ESTOQUE_AC
                    if (codProduto != objHistMovAC.getIdProd() || codProduto == 0) {
                        controlHistMov.incluirHistoricoProdutoNUTRI(objHistMovAC);
                    } else if (codProduto == objHistMovAC.getIdProd()) {
                        SomaProduto(); // SOMAR PRODUTO NA TABELA DE LOTE_ESTOQUE_AC PARA  TABELA HISTORICO_MOVIMENTACAO_ESTOQUE_AC
                        objHistMovAC.setIdProd((int) jTabelaItensProdutoInvent.getValueAt(i, 1));
                        controlHistMov.alterarHistoricoProdutoNUTRI(objHistMovAC);
                    }
                }
                // Modificar o status do inventário para EFETUADO.
                objInventEstoque.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                objInventEstoque.setStatusLanc(statusInventario);
                objInventEstoque.setDataTermino(jDataTermino.getDate());
                objInventEstoque.setHorarioTermino(jHorarioTermino.getText());
                controleFinal.efetivarInventarioAC(objInventEstoque);
            } else if (jComboBoxTipoInventario.getSelectedItem().equals("Inventário Final Ano")) {
                tipoInventario = "I";
                for (int i = 0; i < jTabelaItensProdutoInvent.getRowCount(); i++) {
                    objProdMed.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                    objProdMed.setIdProd((int) jTabelaItensProdutoInvent.getValueAt(i, 1));
                    objProdMed.setSaldoAtual((int) jTabelaItensProdutoInvent.getValueAt(i, 5));
                    objProdMed.setLote((String) jTabelaItensProdutoInvent.getValueAt(i, 6));
                    try {
                        // Converte a data de string para date, para ser inserido no banco de dados.
                        date = (java.util.Date) formatter.parse((String) jTabelaItensProdutoInvent.getValueAt(i, 7));
                    } catch (ParseException ex) {
                    }
                    controleSaldo.alterarEstoqueProdutoNUTRI(objProdMed); // alterar saldo de estoque dos produtos SALDOESTQUE
                    verificarProdutoNovoLote(); // Verifica se o produto e o lote existe
                    if (codProduto == objProdMed.getIdProd() && numeroLote == objProdMed.getLote() || codProduto == objProdMed.getIdProd() && numeroLote.equals("")) { // Se existir altera
                        // Se existir atualiza
                        objProdMed.setDataValidade(date);
                        objProdMed.setDataEstoque(jDataTermino.getDate());
                        controlLote.alterarLoteProdutoNUTRI(objProdMed);
                    } else if (codProduto == objProdMed.getIdProd() && numeroLote != objProdMed.getLote()) { // Se não exisitr inclui
                        // Incluir o mesmo produto caso tenha mais de um lote
                        objProdMed.setDataValidade(date);
                        objProdMed.setDataEstoque(jDataTermino.getDate());
                        controlLote.incluirNovoLoteProdutoNUTRI(objProdMed); // Alterar lote de produtos na tabela LOTEPRODUTOS                        
                    }
                    // ATUALIZAR MOVIMENTAÇÃO DE ESTOQUE NA TABELA HISTORICO_MOVIMENTACAO_ESTOQUE_AC (TESTADO COM SUCESSO.)                    
                    objHistMovAC.setIdProd((int) jTabelaItensProdutoInvent.getValueAt(i, 1));
                    objHistMovAC.setIdLocal(Integer.valueOf(jIdLocal.getText()));
                    objHistMovAC.setTipoOpe(tipoInventario);
                    objHistMovAC.setNomeOperacao((String) jComboBoxTipoInventario.getSelectedItem());
                    objHistMovAC.setIdDoc(Integer.valueOf(jIdLanc.getText()));
                    objHistMovAC.setDataMov(jDataTermino.getDate());
                    objHistMovAC.setQtdItem((int) jTabelaItensProdutoInvent.getValueAt(i, 5));
                    objHistMovAC.setSaldoAtual((float) qtdEstoque);
                    controlHistMov.incluirHistoricoProdutoNUTRI(objHistMovAC);
                    verificarModEstoque(); // VERIFICAR SE O PRODUTO EXISTE NA TABELA HISTORICO_MOVIMENTACAO_ESTOQUE_AC
                    if (codProduto != objHistMovAC.getIdProd() || codProduto == 0) {
                        controlHistMov.incluirHistoricoProdutoNUTRI(objHistMovAC);
                    } else if (codProduto == objHistMovAC.getIdProd()) {
                        SomaProduto(); // SOMAR PRODUTO NA TABELA DE LOTE_ESTOQUE_AC PARA  TABELA HISTORICO_MOVIMENTACAO_ESTOQUE_AC
                        objHistMovAC.setIdProd((int) jTabelaItensProdutoInvent.getValueAt(i, 1));
                        controlHistMov.alterarHistoricoProdutoNUTRI(objHistMovAC);
                    }
                }
                // Modificar o status do inventário para EFETUADO.
                objInventEstoque.setIdLanc(Integer.valueOf(jIdLanc.getText()));
                objInventEstoque.setStatusLanc(statusInventario);
                objInventEstoque.setDataTermino(jDataTermino.getDate());
                objInventEstoque.setHorarioTermino(jHorarioTermino.getText());
                controleFinal.efetivarInventarioAC(objInventEstoque);
            }
        }
    }

    // SOMAR QUANTIDADE DE CADA PRODUTO NA TABELA DE LOTEPRODUTOS PARA INSERIR NA TABELA DE HISTORICO MOVIMENTAÇÃO ESTOQUE
    public void SomaProduto() {
        qtdEstoque = 0;
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOTE_PRODUTOS_NUTRI WHERE IdProd='" + objHistMovAC.getIdProd() + "'");
            while (conecta.rs.next()) {
                qtdEstoque = qtdEstoque + conecta.rs.getFloat("Qtd");
            }
            objProdMed.setSaldoAtual((float) qtdEstoque);
            objHistMovAC.setSaldoAtual((float) qtdEstoque);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro na soma do saldo de estoque.\nERRO: " + ex);
        }
    }

    public void verificarProdutoNovoLote() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM LOTE_PRODUTOS_NUTRI WHERE IdProd='" + objProdMed.getIdProd() + "'");
            conecta.rs.first();
            codProduto = conecta.rs.getInt("IdProd");
            numeroLote = conecta.rs.getString("Lote");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Produto não encontrado.\nERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void verificarModEstoque() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM HISTORICO_MOVIMENTACAO_ESTOQUE_NUTRI WHERE IdProd='" + objHistMovAC.getIdProd() + "'");
            conecta.rs.first();
            codProduto = conecta.rs.getInt("IdProd");
            qtdItem = conecta.rs.getInt("Qtd");
        } catch (Exception e) {
        }
    }

    // Verificar se o saldo é zero
    public void verificarSaldoZero() {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM SALDO_ESTOQUE_NUTRI WHERE IdProd='" + objProdMed.getIdProd() + "'");
            conecta.rs.first();
            saldoAtual = conecta.rs.getInt("SaldoAtual");
            tipoInventario = conecta.rs.getString("InvEstoque");
        } catch (SQLException ex) {
        }
        conecta.desconecta();
    }

    public class SaldoEstoque {

        public List<ProdutoMedicamento> saldo = new ArrayList<ProdutoMedicamento>();

        public void listar() {
            conecta.abrirConexao();
            ResultSet rs = null;
            try {
                PreparedStatement sql = conecta.con.prepareStatement("SELECT * FROM ITENS_INVENTARIO_NUTRI");
                rs = sql.executeQuery();
                while (rs.next()) {
                    ItensInventarioEstoque produto = new ItensInventarioEstoque();
                    produto.setIdProduto(rs.getInt("IdProd"));
                    produto.setQtdItem(rs.getFloat("SaldoAtual"));
                    saldo.add(objProdMed);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
