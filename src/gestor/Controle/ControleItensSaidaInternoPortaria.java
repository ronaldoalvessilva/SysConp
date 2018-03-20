/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensPrevisaoSaida;
import gestor.Modelo.ItensSaidaInterno;
import gestor.Modelo.SaidaInternos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleItensSaidaInternoPortaria {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensSaidaInterno objItemSaida = new ItensSaidaInterno();
    SaidaInternos objSaida = new SaidaInternos();
    ItensPrevisaoSaida objItensPreSaida = new ItensPrevisaoSaida();
    int codInt;
    int qtdUnit = 1;
    //---------------------------------------- ITENSCRCPORTARIA ----------------------------------------------------------
    // Informa quais internos irão sair VINCULO ENTRE ITENSSAIDA E ITENSREGPORTARIA
    public ItensPrevisaoSaida incluirItensSaidaCrcPortaria(ItensPrevisaoSaida objItensPreSaida) {

     //   buscarInternoCrc(objItemSaida.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSCRCPORTARIA (IdInternoCrc,IdSaida,IdItemSaida,DataSaida,DestinoSaida,DocumentoSaida,SaidaConfirmada,Evadido) VALUES(?,?,?,?,?,?,?,?)");
            pst.setInt(1,  objItensPreSaida.getIdInternoCrc());
            pst.setInt(2, objItensPreSaida.getIdLanc());
            pst.setInt(3, objItensPreSaida.getIdItem());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensPreSaida.getDataSaida().getTime()));
            pst.setString(5, objItensPreSaida.getBeneficio());
            pst.setString(6, objItensPreSaida.getNumeroDocumento());
            pst.setString(7, objItensPreSaida.getConfirmaSaida());
            pst.setString(8, objItensPreSaida.getEvadidos());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensPreSaida;
    }

    public ItensPrevisaoSaida alterarItensSaidaCrcPortaria(ItensPrevisaoSaida objItensPreSaida) {

     //   buscarInternoCrc(objItemSaida.getNomeInterno());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSCRCPORTARIA SET IdInternoCrc=?,IdSaida=?,IdItemSaida=?,DataSaida=?,DataRetorno=?,DestinoSaida=?,DocumentoSaida=?,SaidaConfirmada=?,Evadido=? WHERE IdItemSaida='" + objItemSaida.getIdItemSaida() + "'");
            pst.setInt(1,  objItensPreSaida.getIdInternoCrc());
            pst.setInt(2, objItensPreSaida.getIdLanc());
            pst.setInt(3, objItensPreSaida.getIdItem());
            pst.setTimestamp(4, new java.sql.Timestamp(objItensPreSaida.getDataSaida().getTime()));
            pst.setString(5, objItensPreSaida.getBeneficio());
            pst.setString(6, objItensPreSaida.getNumeroDocumento());
            pst.setString(7, objItensPreSaida.getConfirmaSaida());
            pst.setString(8, objItensPreSaida.getEvadidos());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItensPreSaida;
    }

    public ItensSaidaInterno excluirItensSaidaCrcPortaria(ItensSaidaInterno objItemSaida) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSCRCPORTARIA WHERE IdItemSaida='" + objItemSaida.getIdItemSaida() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel DELETAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItemSaida;
    }

    // Buscar INTERNO

    public void buscarInternoCrc(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM PRONTUARIOSCRC WHERE NomeInternoCrc='" + desc + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdInternoCrc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (INTERNOS) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
