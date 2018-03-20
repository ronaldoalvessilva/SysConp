/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.ProcedimentoOdontologico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleProcedimentoOdonto {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    ProcedimentoOdontologico objProcedOdonto = new ProcedimentoOdontologico();

    public ProcedimentoOdontologico incluirProcedimentoOdonto(ProcedimentoOdontologico objProcedOdonto) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ODONTOPROCEDIMENTO (DataPro,IdLanc,IdInternoCrc,Procedimento,UsuarioInsert,DataInsert,HorarioInsert) VALUES (?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objProcedOdonto.getDataProcedimento().getTime()));
            pst.setInt(2, objProcedOdonto.getIdLanc());
            pst.setInt(3, objProcedOdonto.getIdInternoCrc());
            pst.setString(4, objProcedOdonto.getProcedimento());
            pst.setString(5, objProcedOdonto.getUsuarioInsert());
            pst.setString(6, objProcedOdonto.getDataInsert());
            pst.setString(7, objProcedOdonto.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objProcedOdonto;
    }

    public ProcedimentoOdontologico alterarProcedimentoOdonto(ProcedimentoOdontologico objProcedOdonto) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ODONTOPROCEDIMENTO SET DataPro=?,IdLanc=?,IdInternoCrc=?,Procedimento=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdPro='" + objProcedOdonto.getIdPro()+ "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objProcedOdonto.getDataProcedimento().getTime()));
            pst.setInt(2, objProcedOdonto.getIdLanc());
            pst.setInt(3, objProcedOdonto.getIdInternoCrc());
            pst.setString(4, objProcedOdonto.getProcedimento());
            pst.setString(5, objProcedOdonto.getUsuarioUp());
            pst.setString(6, objProcedOdonto.getDataUp());
            pst.setString(7, objProcedOdonto.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objProcedOdonto;
    }

    public ProcedimentoOdontologico excluirProcedimentoOdonto(ProcedimentoOdontologico objProcedOdonto) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ODONTOPROCEDIMENTO WHERE IdPro='" + objProcedOdonto.getIdPro()+ "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objProcedOdonto;
    }
}
