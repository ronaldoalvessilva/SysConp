/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import Utilitarios.ModeloTabela;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Ronaldo
 */
public class TelaAlertaSaidaInternosPortaria extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();

    String dataSaida;
    String repostaSaida = "Não";

    /**
     * Creates new form TelaAlertaEntradaInternosPortaria
     */
    public TelaAlertaSaidaInternosPortaria() {
        initComponents();
        preencherTabelaEntradasPortaria();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelaSaidaInternosPortaria = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Alerta de Saída de Internos na Portaria :::...");

        jTabelaSaidaInternosPortaria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaSaidaInternosPortaria.setForeground(new java.awt.Color(255, 0, 0));
        jTabelaSaidaInternosPortaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTabelaSaidaInternosPortaria);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
        );

        setBounds(20, 20, 507, 422);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelaSaidaInternosPortaria;
    // End of variables declaration//GEN-END:variables

    public void preencherTabelaEntradasPortaria() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Código", "Nome do Interno", "Data Saída", "Documento", "Benefício"};
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM ITENSCRCPORTARIA "
                    + "INNER JOIN PRONTUARIOSCRC "
                    + "ON ITENSCRCPORTARIA.IdInternoCrc=PRONTUARIOSCRC.IdInternoCrc "
                    + "WHERE SaidaConfirmada='" + repostaSaida + "' "
                    + "ORDER BY DataSaida");
            conecta.rs.first();
            do {
                // Formatar a data Entrada
                dataSaida = conecta.rs.getString("DataSaida");
                String diae = dataSaida.substring(8, 10);
                String mese = dataSaida.substring(5, 7);
                String anoe = dataSaida.substring(0, 4);
                dataSaida = diae + "/" + mese + "/" + anoe;
                dados.add(new Object[]{conecta.rs.getInt("IdItem"), conecta.rs.getString("NomeInternoCrc"), dataSaida, conecta.rs.getString("DocumentoSaida"), conecta.rs.getString("DestinoSaida")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTabelaSaidaInternosPortaria.setModel(modelo);
        jTabelaSaidaInternosPortaria.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTabelaSaidaInternosPortaria.getColumnModel().getColumn(0).setResizable(false);
        jTabelaSaidaInternosPortaria.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTabelaSaidaInternosPortaria.getColumnModel().getColumn(1).setResizable(false);
        jTabelaSaidaInternosPortaria.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTabelaSaidaInternosPortaria.getColumnModel().getColumn(2).setResizable(false);
        jTabelaSaidaInternosPortaria.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTabelaSaidaInternosPortaria.getColumnModel().getColumn(3).setResizable(false);
        jTabelaSaidaInternosPortaria.getColumnModel().getColumn(4).setPreferredWidth(280);
        jTabelaSaidaInternosPortaria.getColumnModel().getColumn(4).setResizable(false);
        jTabelaSaidaInternosPortaria.getTableHeader().setReorderingAllowed(false);
        jTabelaSaidaInternosPortaria.setAutoResizeMode(jTabelaSaidaInternosPortaria.AUTO_RESIZE_OFF);
        jTabelaSaidaInternosPortaria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTabelaSaidaInternosPortaria.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        jTabelaSaidaInternosPortaria.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        jTabelaSaidaInternosPortaria.getColumnModel().getColumn(3).setCellRenderer(centralizado);        
    }
}
