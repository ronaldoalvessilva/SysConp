/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Controle;

import gestor.Dao.ConexaoBancoDados;
import gestor.Modelo.RolVisitas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControleRolVisitasReligiosas {

    ConexaoBancoDados conecta = new ConexaoBancoDados();
    RolVisitas objRol = new RolVisitas();
    int codInt;

    public RolVisitas incluirRolVisitasReligiosas(RolVisitas objRol) {
        buscarInstituicao(objRol.getNomeInstituicaoRel(),objRol.getIdInstituicao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ROL_VISITAS_RELIGIOSA (DataRol,StatusRol,IdCod,Domingo,Segunda,Terca,Quarta,Quinta,Sexta,Sabado,ObsRol,ObsPortaria,UsuarioInsert,DataInsert,HorarioInsert) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setTimestamp(1, new java.sql.Timestamp(objRol.getDataRol().getTime()));
            pst.setString(2, objRol.getStatusRol());
            pst.setInt(3, codInt);
            pst.setInt(4, objRol.getDomingo());
            pst.setInt(5, objRol.getSegunda());
            pst.setInt(6, objRol.getTerca());
            pst.setInt(7, objRol.getQuarta());
            pst.setInt(8, objRol.getQuinta());
            pst.setInt(9, objRol.getSexta());
            pst.setInt(10, objRol.getSabado());
            pst.setString(11, objRol.getObsRol());
            pst.setString(12, objRol.getObsPortaria());
            pst.setString(13, objRol.getUsuarioInsert());
            pst.setString(14, objRol.getDataInsert());
            pst.setString(15, objRol.getHoraInsert());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel INSERIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRol;
    }

    public RolVisitas alterarRolVisitasReligiosas(RolVisitas objRol) {
        buscarInstituicao(objRol.getNomeInstituicaoRel(),objRol.getIdInstituicao());
        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ROL_VISITAS_RELIGIOSA SET DataRol=?,StatusRol=?,IdCod=?,Domingo=?,Segunda=?,Terca=?,Quarta=?,Quinta=?,Sexta=?,Sabado=?,ObsRol=?,ObsPortaria=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdRol='" + objRol.getIdRol() + "'");
            pst.setTimestamp(1, new java.sql.Timestamp(objRol.getDataRol().getTime()));
            pst.setString(2, objRol.getStatusRol());
            pst.setInt(3, codInt);
            pst.setInt(4, objRol.getDomingo());
            pst.setInt(5, objRol.getSegunda());
            pst.setInt(6, objRol.getTerca());
            pst.setInt(7, objRol.getQuarta());
            pst.setInt(8, objRol.getQuinta());
            pst.setInt(9, objRol.getSexta());
            pst.setInt(10, objRol.getSabado());
            pst.setString(11, objRol.getObsRol());
            pst.setString(12, objRol.getObsPortaria());
            pst.setString(13, objRol.getUsuarioInsert());
            pst.setString(14, objRol.getDataInsert());
            pst.setString(15, objRol.getHoraInsert());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRol;
    }

    public RolVisitas exclusaoRolVisitasReligiosas(RolVisitas objRol) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ROL_VISITAS_RELIGIOSA WHERE IdRol='" + objRol.getIdRol() + "'");
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel EXCLUIR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRol;
    }

    public RolVisitas finalizarRolVisitasReligiosas(RolVisitas objRol) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ROL_VISITAS_RELIGIOSA SET StatusRol=? WHERE IdRol='" + objRol.getIdRol() + "'");
            pst.setString(1, objRol.getStatusRol());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRol;
    }

    // Finalizar Rol de visitas quando o interno sair da unidade pela portaria

    public RolVisitas finalizarRolVisitasPortaria(RolVisitas objRol) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ROLVISITAS SET StatusRol=?,ObsRol=?,UsuarioUp=?,DataUp=?,HorarioUp=? WHERE IdInternoCrc='" + objRol.getIdInterno() + "'");
            pst.setString(1, objRol.getStatusRol());
            pst.setString(2, objRol.getObsRol());
            pst.setString(3, objRol.getUsuarioUp());
            pst.setString(4, objRol.getDataUp());
            pst.setString(5, objRol.getHoraUp());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel FINALIZAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRol;
    }

    public RolVisitas alterarRecebeVisitaAtendimentoSocial(RolVisitas objRol) {

        conecta.abrirConexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE ATENDIMENTOSOCIAL SET RecebeVisita=? WHERE IdInternoCrc='" + objRol.getIdInterno() + "'");
            pst.setString(1, objRol.getRecebeVisita());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível ALTERAR os Dados.\n\nERRO: " + ex);
        }
        conecta.desconecta();
        return objRol;
    }

    public void buscarInstituicao(String nome, int codigo) {
        conecta.abrirConexao();
        try {
            conecta.executaSQL("SELECT * FROM INSTITUICAO_RELIGIOSA WHERE NomeInstituicao='" + nome + "'AND IdCod='" + codigo  + "'");
            conecta.rs.first();
            codInt = conecta.rs.getInt("IdCod");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Existe dados da INSTITUIÇÃO a ser exibido !!!");
        }
        conecta.desconecta();
    }
}
