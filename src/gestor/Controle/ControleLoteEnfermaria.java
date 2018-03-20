/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AtualizaLoteEnfermaria;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleLoteEnfermaria {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
  
    AtualizaLoteEnfermaria objAtuaSaldoEnf = new AtualizaLoteEnfermaria();

    public AtualizaLoteEnfermaria incluirNovoLoteProdutoEnfermaria(AtualizaLoteEnfermaria objAtuaSaldoEnf) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO LOTE_PRODUTOS_ENF (IdProd,IdLanc,DataVenc,Lote,Qtd) VALUES (?,?,?,?,?)");
            pst.setInt(1, objAtuaSaldoEnf.getIdProd());
            pst.setInt(2, objAtuaSaldoEnf.getIdLanc());
            if (objAtuaSaldoEnf.getDataValidade() != null) {
                pst.setTimestamp(3, new java.sql.Timestamp(objAtuaSaldoEnf.getDataValidade().getTime()));
            } else {
                pst.setDate(3, null);
            }
            pst.setString(4, objAtuaSaldoEnf.getLote());
            pst.setFloat(5, objAtuaSaldoEnf.getQtd());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INCLUIR NOVO LOTE DE PRODUTOS ENFERMARIA... \n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtuaSaldoEnf;
    }

    public AtualizaLoteEnfermaria alterarLoteProdutoEnfermaria(AtualizaLoteEnfermaria objAtuaSaldoEnf) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE LOTE_PRODUTOS_ENF SET IdLanc=?,DataVenc=?,Lote=?,Qtd=? WHERE IdProd='" + objAtuaSaldoEnf.getIdProd() + "'AND Lote='" + objAtuaSaldoEnf.getLote() + "'");
         //   pst.setInt(1, objAtuaSaldoEnf.getIdProd());
            pst.setInt(1, objAtuaSaldoEnf.getIdLanc());
            if (objAtuaSaldoEnf.getDataValidade() != null) {
                pst.setTimestamp(2, new java.sql.Timestamp(objAtuaSaldoEnf.getDataValidade().getTime()));
            } else {
                pst.setDate(2, null);
            }
            pst.setString(3, objAtuaSaldoEnf.getLote());
            pst.setFloat(4, objAtuaSaldoEnf.getQtd());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR LOTE DE PRODUTOS... \n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAtuaSaldoEnf;
    }
}
