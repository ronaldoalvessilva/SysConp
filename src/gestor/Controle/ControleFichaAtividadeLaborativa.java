/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.FichaAtividadeLaborativa;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronaldo
 */
public class ControleFichaAtividadeLaborativa {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    FichaAtividadeLaborativa objFichaLab = new FichaAtividadeLaborativa();
    int codEmp;

    public FichaAtividadeLaborativa incluirFichaAtivLabo(FichaAtividadeLaborativa objFichaLab) {
        buscarEmp(objFichaLab.getDescricaoEmpresa());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FICHALABORATIVA (DataLanc,IdEmp,Observacao,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objFichaLab.getDataLanc().getTime()));
            pst.setInt(2, codEmp);
            pst.setString(3, objFichaLab.getObservacao());
            pst.setString(4, objFichaLab.getUsuarioInsert());
            pst.setString(5, objFichaLab.getDataInsert());
            pst.setString(6, objFichaLab.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objFichaLab;
    }

    public FichaAtividadeLaborativa alterarFichaAtivLabo(FichaAtividadeLaborativa objFichaLab) {
        buscarEmp(objFichaLab.getDescricaoEmpresa());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FICHALABORATIVA SET DataLanc=?,IdEmp=?,Observacao=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdLanc='" + objFichaLab.getIdLanc() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objFichaLab.getDataLanc().getTime()));
            pst.setInt(2, codEmp);
            pst.setString(3, objFichaLab.getObservacao());
            pst.setString(4, objFichaLab.getUsuarioUp());
            pst.setString(5, objFichaLab.getDataUp());
            pst.setString(6, objFichaLab.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objFichaLab;
    }

    public FichaAtividadeLaborativa excluirFichaAtivLabo(FichaAtividadeLaborativa objFichaLab) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FICHALABORATIVA WHERE IdLanc='" + objFichaLab.getIdLanc() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objFichaLab;
    }

    public void buscarEmp(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EMPRESALAB WHERE RazaoSocial='" + desc + "'");
            conecta.rs.first();
            codEmp = conecta.rs.getInt("IdEmp");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não existe dados (EMPRESA LABORATIVA) a ser exibido !!!" + e);
        }
        conecta.desconecta();
    }
}
