/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.AgendaLaborativa;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleAgendaLaborativa {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    AgendaLaborativa objAgenda = new AgendaLaborativa();
    int codEmpresa;
    String StatusEmp = "Ativa";

    public AgendaLaborativa incluirAgenda(AgendaLaborativa objAgenda) {
        buscarEmpresa(objAgenda.getNomeEmpresa());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO AGENDALABORATIVA (StatusLanc,DataCadastro,IdEmp,ObsLanc,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?)");
            pst.setString(1, objAgenda.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAgenda.getDataCadastro().getTime()));
            pst.setInt(3, codEmpresa);
            pst.setString(4, objAgenda.getObsLanc());
            pst.setString(5, objAgenda.getUsuarioInsert());
            pst.setString(6, objAgenda.getDataInsert());
            pst.setString(7, objAgenda.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAgenda;
    }

    public AgendaLaborativa alterarAgenda(AgendaLaborativa objAgenda) {
        buscarEmpresa(objAgenda.getNomeEmpresa());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AGENDALABORATIVA SET StatusLanc=?,DataCadastro=?,IdEmp=?,ObsLanc=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdAgenda='" + objAgenda.getIdAgenda() + "'");
            pst.setString(1, objAgenda.getStatusLanc());
            pst.setTimestamp(2, new java.sql.Timestamp(objAgenda.getDataCadastro().getTime()));
            pst.setInt(3, codEmpresa);
            pst.setString(4, objAgenda.getObsLanc());
            pst.setString(5, objAgenda.getUsuarioUp());
            pst.setString(6, objAgenda.getDataUp());
            pst.setString(7, objAgenda.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAgenda;
    }

    public AgendaLaborativa excluirAgenda(AgendaLaborativa objAgenda) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM AGENDALABORATIVA WHERE IdAgenda='" + objAgenda.getIdAgenda() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAgenda;
    }

    public AgendaLaborativa finalizarAgenda(AgendaLaborativa objAgenda) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE AGENDALABORATIVA SET StatusLanc=? WHERE IdAgenda='" + objAgenda.getIdAgenda() + "'");
            pst.setString(1, objAgenda.getStatusLanc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados\n\nERRO" + ex);
        }
        conecta.desconecta();
        return objAgenda;
    }

    public void buscarEmpresa(String desc) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM EMPRESALAB WHERE RazaoSocial='" + desc + "' AND StatusEmp='" + StatusEmp + "'");
            conecta.rs.first();
            codEmpresa = conecta.rs.getInt("IdEmp");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar a empresa, talvez ela esteja inativa." + e);
        }
        conecta.desconecta();
    }
}
