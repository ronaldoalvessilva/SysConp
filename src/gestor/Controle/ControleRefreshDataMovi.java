/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensEntradaLote;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Socializa TI 02
 */
public class ControleRefreshDataMovi {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensEntradaLote objItens = new ItensEntradaLote();

    public ItensEntradaLote alterarDataMovimentacao(ItensEntradaLote ItensEntradaLote) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVIMENTOCRC SET DataMov=CONVERT(DATE, DataMov,103)");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\nERRO: " + ex);
        }
        conecta.desconecta();
        return ItensEntradaLote;
    }
}
