/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensMovSaidaRetorno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleMovSaidaEvasao {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensMovSaidaRetorno objMovSaiRetornoEva = new ItensMovSaidaRetorno();

    public ItensMovSaidaRetorno incluirMovSaidaEvasao(ItensMovSaidaRetorno objMovSaiRetornoEva) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO MOVISR (IdInternoCrc,IdSaida,DataSaida,DataPrevRetorno,NrDocSaida,NrDocRetorno,DataEvasao) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, objMovSaiRetornoEva.getIdInternoCrc());
            pst.setInt(2, objMovSaiRetornoEva.getIdSaida());
            pst.setTimestamp(3, new java.sql.Timestamp(objMovSaiRetornoEva.getDataSaida().getTime()));
            if (objMovSaiRetornoEva.getDataPrevRetorno()!= null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objMovSaiRetornoEva.getDataPrevRetorno().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, objMovSaiRetornoEva.getNrDocSaida());
            pst.setString(6, objMovSaiRetornoEva.getNrDocRetorno());
            pst.setString(7, objMovSaiRetornoEva.getDataEvasao());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objMovSaiRetornoEva;
    }

    public ItensMovSaidaRetorno alterarMovSaidaEvasao(ItensMovSaidaRetorno objMovSaiRetornoEva) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE MOVISR SET IdInternoCrc=?,IdSaida=?,DataSaida=?,DataPrevRetorno=?,NrDocSaida=? WHERE IdInternoCrc='" + objMovSaiRetornoEva.getIdInternoCrc() + "'AND NrDocSaida='" + objMovSaiRetornoEva.getNrDocSaida() + "'");
            pst.setInt(1, objMovSaiRetornoEva.getIdInternoCrc());
            pst.setInt(2, objMovSaiRetornoEva.getIdSaida());
            pst.setTimestamp(3, new java.sql.Timestamp(objMovSaiRetornoEva.getDataSaida().getTime()));
            if (objMovSaiRetornoEva.getDataPrevRetorno() != null) {
                pst.setTimestamp(4, new java.sql.Timestamp(objMovSaiRetornoEva.getDataPrevRetorno().getTime()));
            } else {
                pst.setDate(4, null);
            }
            pst.setString(5, objMovSaiRetornoEva.getNrDocSaida());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objMovSaiRetornoEva;
    }

    public ItensMovSaidaRetorno excluirMovSaidaEvasao(ItensMovSaidaRetorno objMovSaiRetornoEva) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM MOVISR WHERE IdInternoCrc='" + objMovSaiRetornoEva.getIdInternoCrc() + "'AND NrDocSaida='" + objMovSaiRetornoEva.getNrDocSaida() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objMovSaiRetornoEva;
    }
}
