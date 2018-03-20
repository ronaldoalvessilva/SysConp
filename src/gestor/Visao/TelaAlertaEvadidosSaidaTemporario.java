/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Visao;

import gestor.Dao.ConexaoBancoDados;
import static gestor.Visao.TelaEvadidosSaidaTemporaria.acao;
import static gestor.Visao.TelaEvadidosSaidaTemporaria.jBtCancelar;
import static gestor.Visao.TelaEvadidosSaidaTemporaria.jBtSalvar;
import static gestor.Visao.TelaEvadidosSaidaTemporaria.jDataLanc;
import static gestor.Visao.TelaEvadidosSaidaTemporaria.jNomeInternoEvadido;
import static gestor.Visao.TelaEvadidosSaidaTemporaria.jObservacao;
import static gestor.Visao.TelaEvadidosSaidaTemporaria.jOperacao;
import static gestor.Visao.TelaEvadidosSaidaTemporaria.jIdInternoEvadido;
import static gestor.Visao.TelaEvadidosSaidaTemporaria.jNrDocumentoSaidaTmp;
import java.util.Calendar;
 
/**
 *
 * @author ronaldo
 */
public class TelaAlertaEvadidosSaidaTemporario extends javax.swing.JInternalFrame {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    int flag;
    String dataSaida,dataEntrada;

    /**
     * Creates new form TelaEvasaoInternos
     */
    public TelaAlertaEvadidosSaidaTemporario() {
        initComponents();
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
        jTabelaIntEvadidosSaidaTemporaria = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("...::: Listagem de Internos Evadidos Saída Temporaria :::...");

        jTabelaIntEvadidosSaidaTemporaria.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTabelaIntEvadidosSaidaTemporaria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTabelaIntEvadidosSaidaTemporaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaIntEvadidosSaidaTemporariaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabelaIntEvadidosSaidaTemporaria);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );

        setBounds(80, 10, 442, 419);
    }// </editor-fold>//GEN-END:initComponents

    private void jTabelaIntEvadidosSaidaTemporariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaIntEvadidosSaidaTemporariaMouseClicked
        // TODO add your handling code here:
        flag = 1;
        if (flag == 1) {
            String idLanc = "" + jTabelaIntEvadidosSaidaTemporaria.getValueAt(jTabelaIntEvadidosSaidaTemporaria.getSelectedRow(), 0);         
            String idInterno = "" + jTabelaIntEvadidosSaidaTemporaria.getValueAt(jTabelaIntEvadidosSaidaTemporaria.getSelectedRow(), 1);         
            String nomeInterno = "" + jTabelaIntEvadidosSaidaTemporaria.getValueAt(jTabelaIntEvadidosSaidaTemporaria.getSelectedRow(), 2);       
            TelaEvadidosSaidaTemporaria objEvaInternosSaidaTmp = new TelaEvadidosSaidaTemporaria();
            TelaModuloCRC.jPainelCRC.add(objEvaInternosSaidaTmp);
            objEvaInternosSaidaTmp.show();
            //
            acao = 1;
            jDataLanc.setEnabled(true);
            jObservacao.setEnabled(true);           
            jDataLanc.setCalendar(Calendar.getInstance());
            jOperacao.setText("EVASAO - SAIDA TEMPORARIA");
            jIdInternoEvadido.setText(idInterno);
            jNrDocumentoSaidaTmp.setText(idLanc);
            jNomeInternoEvadido.setText(nomeInterno);
            //
            jBtSalvar.setEnabled(true);
            jBtCancelar.setEnabled(true);
        }
    }//GEN-LAST:event_jTabelaIntEvadidosSaidaTemporariaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTabelaIntEvadidosSaidaTemporaria;
    // End of variables declaration//GEN-END:variables
  
}
