/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.HistoricoInternoEducacao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleHistoricoInstituicaoInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    HistoricoInternoEducacao objHistInterEdu = new HistoricoInternoEducacao();
    int codInt;
    int codInst;

    public HistoricoInternoEducacao incluirInterEdu(HistoricoInternoEducacao objHistInterEdu) {
        buscarInterno(objHistInterEdu.getNomeInterno());
        buscarInstituicao(objHistInterEdu.getNomeInstituicao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO HISTORICO_EXTERNO_EDUCACIONAL (IdInternoCrc,IdCod,IdItem,DataEntrada,HorarioEntrada,DataSaida,HorarioSaida) VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, codInst);
            pst.setInt(3, objHistInterEdu.getIdItem());
            pst.setTimestamp(4, new java.sql.Timestamp(objHistInterEdu.getDataEntrada().getTime()));
            pst.setString(5, objHistInterEdu.getHorarioEntrada());
            pst.setTimestamp(6, new java.sql.Timestamp(objHistInterEdu.getDataSaida().getTime()));
            pst.setString(7, objHistInterEdu.getHorarioSaida());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objHistInterEdu;
    }

    public HistoricoInternoEducacao alterarInterEdu(HistoricoInternoEducacao objHistInterEdu) {
        buscarInterno(objHistInterEdu.getNomeInterno());
        buscarInstituicao(objHistInterEdu.getNomeInstituicao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICO_EXTERNO_EDUCACIONAL SET IdInternoCrc=?,IdCod=?,IdItem=?,DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=? WHERE IdInternoCrc='" + objHistInterEdu.getIdInternoCrc() + "'AND IdItem='" + objHistInterEdu.getIdItem() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, codInst);
            pst.setInt(3, objHistInterEdu.getIdItem());
            pst.setTimestamp(4, new java.sql.Timestamp(objHistInterEdu.getDataEntrada().getTime()));
            pst.setString(5, objHistInterEdu.getHorarioEntrada());
            pst.setTimestamp(6, new java.sql.Timestamp(objHistInterEdu.getDataSaida().getTime()));
            pst.setString(7, objHistInterEdu.getHorarioSaida());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objHistInterEdu;
    }

    public HistoricoInternoEducacao excluirInterEdu(HistoricoInternoEducacao objHistInterEdu) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM HISTORICO_EXTERNO_EDUCACIONAL WHERE IdInternoCrc='" + objHistInterEdu.getIdInternoCrc() +"'AND IdItem='" + objHistInterEdu.getIdItem() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objHistInterEdu;
    }

    public void buscarInterno(String desc) {
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

    public void buscarInstituicao(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INSTITUICAOESCOLAR WHERE NomeInstituicao='" + desc + "'");
            conecta.rs.first();
            codInst = conecta.rs.getInt("IdCod");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (EMPRESA) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
