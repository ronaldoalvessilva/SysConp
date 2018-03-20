/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ItensValeTransporteColaborador;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleItensValeTransporte {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ItensValeTransporteColaborador objItenValeTrans = new ItensValeTransporteColaborador();
    int codFunc;

    public ItensValeTransporteColaborador incluirItensValeTransporte(ItensValeTransporteColaborador objItenValeTrans) {
        buscarColaborador(objItenValeTrans.getNomeColaborador());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSVALETRANSPORTE (DataLanc,IdFunc,IdLanc,MesReferencia,ValorVale,QtdDias,QtdValeDias,ValorTotalVale,TextoRecibo,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objItenValeTrans.getDataLanc().getTime()));
            pst.setInt(2, objItenValeTrans.getIdFunc());
            pst.setInt(3, objItenValeTrans.getIdLanc());
            pst.setString(4, objItenValeTrans.getMesReferencia());
            pst.setFloat(5, objItenValeTrans.getValorVale());
            pst.setInt(6, objItenValeTrans.getQtdDias());
            pst.setInt(7, objItenValeTrans.getQtdValeDia());
            pst.setFloat(8, objItenValeTrans.getValorTotalVale());
            pst.setString(9, objItenValeTrans.getTextoRecibo());
            pst.setString(10, objItenValeTrans.getUsuarioInsert());
            pst.setString(11, objItenValeTrans.getDataInsert());
            pst.setString(12, objItenValeTrans.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItenValeTrans;
    }

    public ItensValeTransporteColaborador alterarItensValeTransporte(ItensValeTransporteColaborador objItenValeTrans) {
        buscarColaborador(objItenValeTrans.getNomeColaborador());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ITENSVALETRANSPORTE SET DataLanc=?,IdFunc=?,IdLanc=?,MesReferencia=?,ValorVale=?,QtdDias=?,QtdValeDias=?,ValorTotalVale=?,TextoRecibo=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdItem='" + objItenValeTrans.getIdItem() + "'AND IdFunc='" + objItenValeTrans.getIdFunc() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objItenValeTrans.getDataLanc().getTime()));
            pst.setInt(2, objItenValeTrans.getIdFunc());
            pst.setInt(3, objItenValeTrans.getIdLanc());
            pst.setString(4, objItenValeTrans.getMesReferencia());
            pst.setFloat(5, objItenValeTrans.getValorVale());
            pst.setInt(6, objItenValeTrans.getQtdDias());
            pst.setInt(7, objItenValeTrans.getQtdValeDia());
            pst.setFloat(8, objItenValeTrans.getValorTotalVale());
            pst.setString(9, objItenValeTrans.getTextoRecibo());
            pst.setString(10, objItenValeTrans.getUsuarioUp());
            pst.setString(11, objItenValeTrans.getDataUp());
            pst.setString(12, objItenValeTrans.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItenValeTrans;
    }

    public ItensValeTransporteColaborador excluirItensValeTransporte(ItensValeTransporteColaborador objItenValeTrans) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ITENSVALETRANSPORTE WHERE IdItem='" + objItenValeTrans.getIdItem() + "'AND IdFunc='" + objItenValeTrans.getIdFunc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItenValeTrans;
    }
    // A diferença desse método é que não precisa buscar o colaborador pelo nome.
    public ItensValeTransporteColaborador incluirItensValeTransporteGerado(ItensValeTransporteColaborador objItenValeTrans) {
       
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ITENSVALETRANSPORTE (DataLanc,IdFunc,IdLanc,MesReferencia,ValorVale,QtdDias,QtdValeDias,ValorTotalVale,TextoRecibo,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objItenValeTrans.getDataLanc().getTime()));
            pst.setInt(2, objItenValeTrans.getIdFunc());
            pst.setInt(3, objItenValeTrans.getIdLanc());
            pst.setString(4, objItenValeTrans.getMesReferencia());
            pst.setFloat(5, objItenValeTrans.getValorVale());
            pst.setInt(6, objItenValeTrans.getQtdDias());
            pst.setInt(7, objItenValeTrans.getQtdValeDia());
            pst.setFloat(8, objItenValeTrans.getValorTotalVale());
            pst.setString(9, objItenValeTrans.getTextoRecibo());
            pst.setString(10, objItenValeTrans.getUsuarioInsert());
            pst.setString(11, objItenValeTrans.getDataInsert());
            pst.setString(12, objItenValeTrans.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objItenValeTrans;
    }
    public void buscarColaborador(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM COLABORADOR WHERE NomeFunc='" + desc + "'");
            conecta.rs.first();
            codFunc = conecta.rs.getInt("IdFunc");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (COLABORADOR) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
