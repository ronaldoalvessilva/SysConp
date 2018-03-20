/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.CentroCusto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ronaldo
 */
public class ControleCentroCusto {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    CentroCusto objCentroCus = new CentroCusto();
    int codigoDepto;

    public CentroCusto incluirCentroCusto(CentroCusto objCentroCus) {
        buscarDepartamento(objCentroCus.getDescricaoDepartamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CENTRO_CUSTO (Codigo,DataLanc,StatusCentro,TipoCusto,DescricaoCentro,IdDepartamento,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, objCentroCus.getCodigo());
            pst.setTimestamp(2, new java.sql.Timestamp(objCentroCus.getDataLanc().getTime()));
            pst.setString(3, objCentroCus.getStatusCentro());
            pst.setString(4, objCentroCus.getTipoCusto());
            pst.setString(5, objCentroCus.getDescricaoCentro());
            pst.setInt(6, codigoDepto);
            pst.setString(7, objCentroCus.getObservacao());
            pst.setString(8, objCentroCus.getUsuarioInsert());
            pst.setString(9, objCentroCus.getDataInsert());
            pst.setString(10, objCentroCus.getHorarioInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível INSERIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCentroCus;
    }

    public CentroCusto alterarCentroCusto(CentroCusto objCentroCus) {
        buscarDepartamento(objCentroCus.getDescricaoDepartamento());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CENTRO_CUSTO SET Codigo=?,DataLanc=?,StatusCentro=?,TipoCusto=?,DescricaoCentro=?,IdDepartamento=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdCusto='" + objCentroCus.getIdCusto() + "'");
            pst.setString(1, objCentroCus.getCodigo());
            pst.setTimestamp(2, new java.sql.Timestamp(objCentroCus.getDataLanc().getTime()));
            pst.setString(3, objCentroCus.getStatusCentro());
            pst.setString(4, objCentroCus.getTipoCusto());
            pst.setString(5, objCentroCus.getDescricaoCentro());
            pst.setInt(6, codigoDepto);
            pst.setString(7, objCentroCus.getObservacao());
            pst.setString(8, objCentroCus.getUsuarioUp());
            pst.setString(9, objCentroCus.getDataUp());
            pst.setString(10, objCentroCus.getHorarioUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCentroCus;
    }

    public CentroCusto excuirCentroCusto(CentroCusto objCentroCus) {
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CENTRO_CUSTO WHERE IdCusto='" + objCentroCus.getIdCusto() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível EXCLUIR os Dados\nERRO: " + ex);
        }
        conecta.desconecta();
        return objCentroCus;
    }

    public void buscarDepartamento(String nome) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM DEPARTAMENTOS WHERE NomeDepartamento='" + nome + "'");
            conecta.rs.first();
            codigoDepto = conecta.rs.getInt("IdDepartamento");
        } catch (Exception e) {
        }
        conecta.desconecta();
    }
}
