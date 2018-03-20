/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.HistoricoInternosEmpresa;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleHistoricoEmpresasInternos {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    HistoricoInternosEmpresa objHistInterEmp = new HistoricoInternosEmpresa();
    int codInt;
    int codEmp;

    public HistoricoInternosEmpresa incluirInterEmp(HistoricoInternosEmpresa objHistInterEmp) {
        buscarInterno(objHistInterEmp.getNomeInterno());
        buscarEmpresa(objHistInterEmp.getNomeEmpresa());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO HISTORICOLABORINTERNO (IdInternoCrc,IdEmp,DataEntrada,HorarioEntrada,DataSaida,HorarioSaida) VALUES(?,?,?,?,?,?)");
            pst.setInt(1, codInt);
            pst.setInt(2, codEmp);
            pst.setTimestamp(3, new java.sql.Timestamp(objHistInterEmp.getDataEntrada().getTime()));
            pst.setString(4, objHistInterEmp.getHorarioEntrada());
            pst.setTimestamp(5, new java.sql.Timestamp(objHistInterEmp.getDataSaida().getTime()));
            pst.setString(6, objHistInterEmp.getHorarioSaida());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objHistInterEmp;
    }

    public HistoricoInternosEmpresa alterarInterEmp(HistoricoInternosEmpresa objHistInterEmp) {
        buscarInterno(objHistInterEmp.getNomeInterno());
        buscarEmpresa(objHistInterEmp.getNomeEmpresa());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICOLABORINTERNO SET IdInternoCrc=?,IdEmp=?,DataEntrada=?,HorarioEntrada=?,DataSaida=?,HorarioSaida=? WHERE IdInternoCrc='" + objHistInterEmp.getIdInternoCrc() + "'");
            pst.setInt(1, codInt);
            pst.setInt(2, codEmp);
            pst.setTimestamp(3, new java.sql.Timestamp(objHistInterEmp.getDataEntrada().getTime()));
            pst.setString(4, objHistInterEmp.getHorarioEntrada());
            pst.setTimestamp(5, new java.sql.Timestamp(objHistInterEmp.getDataSaida().getTime()));
            pst.setString(6, objHistInterEmp.getHorarioSaida());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objHistInterEmp;
    }

    public HistoricoInternosEmpresa excluirInterEmp(HistoricoInternosEmpresa objHistInterEmp) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM HISTORICOLABORINTERNO WHERE IdInternoCrc='" + objHistInterEmp.getIdInternoCrc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objHistInterEmp;
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

    public void buscarEmpresa(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EMPRESALAB WHERE RazaoSocial='" + desc + "'");
            conecta.rs.first();
            codEmp = conecta.rs.getInt("IdEmp");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (EMPRESA) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
