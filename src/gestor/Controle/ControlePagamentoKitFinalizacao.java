/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;


import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ComposicaoKit;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronal
 */
public class ControlePagamentoKitFinalizacao {
    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ComposicaoKit objComp = new ComposicaoKit();
    
    public ComposicaoKit confirmarPagamentoKit(ComposicaoKit objComp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE COMPOSICAO_PAGAMENTO_KIT_INTERNOS_LOTE SET KitPago=?,DataPagamento=? "
                    + "WHERE IdRegistroComp='" + objComp.getIdRegistroComp() + "'");
            pst.setString(1, objComp.getKitPago());
            pst.setTimestamp(2, new java.sql.Timestamp(objComp.getDataPagamentoKit().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR registro.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objComp;
    }
    
    public ComposicaoKit confirmarPagamentoKitProgramacao(ComposicaoKit objComp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PROGRAMACAO_PAGAMENTO_KITS_INTERNOS SET KitPago=?,DataPagamento=? "
                    + "WHERE IdKit='" + objComp.getIdKit() + "'");
            pst.setString(1, objComp.getKitPago());
            pst.setTimestamp(2, new java.sql.Timestamp(objComp.getDataPagamentoKit().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR registro.\nERRO: " + ex);
        }
        conecta.desconecta();
        return objComp;
    }
}
